package com.qijia.upms.client.shiro.filter;

import com.alibaba.fastjson.JSONObject;
//import com.qijia.common.util.PropertiesFileUtil;
//import com.qijia.common.util.RedisUtil;
import com.qijia.common.utils.PropertiesFileUtil;
import com.qijia.upms.client.shiro.session.UpmsSessionDao;
import com.qijia.upms.client.utils.RequestParameterUtil;
import com.qijia.upms.common.constant.UpmsConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import qijia.common.redis.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 重写authc过滤器
 * Created by shuzheng on 2017/3/11.
 */
public class UpmsAuthenticationFilter extends AuthenticationFilter {

	private final static Logger _log = LoggerFactory.getLogger(UpmsAuthenticationFilter.class);

	// 局部会话key
	private final static String ZHENG_UPMS_CLIENT_SESSION_ID = "zheng-upms-client-session-id";
	// 单点同一个code所有局部会话key
	private final static String ZHENG_UPMS_CLIENT_SESSION_IDS = "zheng-upms-client-session-ids";

	@Autowired
	UpmsSessionDao upmsSessionDao;


	//	终端session名称
	@Value("${zheng.upms.type}")
	private String appUpmsType;

	//	单点登录认证中心地址
	@Value("${zheng.upms.sso.server.url}")
	private String loginUrl;

	//	登录成功回调地址
	@Value("${zheng.upms.successUrl}")
	private String successUrl;

	//	未授权地址
	@Value("${zheng.upms.unauthorizedUrl}")
	private String unauthorizedUrl;

	//	会话时长,半小时（单位毫秒）
	@Value("${zheng.upms.session.timeout}")
	private Integer globalSessionTimeout;

	//	终端session名称
	@Value("${zheng.upms.session.id}")
	private String sessionIdCookieName;

	//	记住密码时长30天
	@Value("${zheng.upms.rememberMe.timeout}")
	private Integer rememberMeCookieMaxAge;

	//
	@Value("${zheng.upms.appID}")
	private String upmsAppId;

	//
	@Value("${zheng.upms.appSecret}")
	private String upmsAppSecurityKey;


	//    isAccessAllowed 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		// 判断请求类型
//        String upmsType = PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.type");
		String upmsType = this.appUpmsType;

		session.setAttribute(UpmsConstant.UPMS_TYPE, upmsType);
		if ("client".equals(upmsType)) {
			return validateClient(request, response);
		}
		if ("server".equals(upmsType)) {
			return subject.isAuthenticated();
		}
		return false;
	}

	//onAccessDenied 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        StringBuffer sso_server_url = new StringBuffer(PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.sso.server.url"));
		StringBuffer sso_server_url = new StringBuffer(this.loginUrl);

		// server需要登录
//        String upmsType = PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.type");
		String upmsType = this.appUpmsType;
		if ("server".equals(upmsType)) {
			WebUtils.toHttp(response).sendRedirect(sso_server_url.append("/sso/login").toString());
			return false;
		}

		// 回跳地址 backurl 参数
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		StringBuffer backurl = httpServletRequest.getRequestURL();
		String queryString = httpServletRequest.getQueryString();
		if (StringUtils.isNotBlank(queryString)) {
			backurl.append("?").append(queryString);
		}

//        sso_server_url.append("/sso/index").append("?").append("appid").append("=").append(PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.appID"));
		sso_server_url.append("/sso/index").append("?").append("appid").append("=").append(this.upmsAppId);
		sso_server_url.append("&").append("backurl").append("=").append(URLEncoder.encode(backurl.toString(), "utf-8"));
//        sso_server_url = String.format("%s/sso/index?appid=%s&backurl=%s", sso_server_url.toString(),this.upmsAppId, URLEncoder.encode(backurl.toString(), "utf-8"))
		WebUtils.toHttp(response).sendRedirect(sso_server_url.toString());
		return false;
	}

	/**
	 * 认证中心登录成功带回code
	 *
	 * @param request
	 */
	private boolean validateClient(ServletRequest request, ServletResponse response) {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		String sessionId = session.getId().toString();
		int timeOut = (int) session.getTimeout() / 1000;
		// 判断局部会话是否登录
		String cacheClientSession = RedisUtil.get(ZHENG_UPMS_CLIENT_SESSION_ID + "_" + session.getId());
		if (StringUtils.isNotBlank(cacheClientSession)) {
			// 更新code有效期
			RedisUtil.set(ZHENG_UPMS_CLIENT_SESSION_ID + "_" + sessionId, cacheClientSession, timeOut);
			Jedis jedis = RedisUtil.getJedis();
			jedis.expire(ZHENG_UPMS_CLIENT_SESSION_IDS + "_" + cacheClientSession, timeOut);
			jedis.close();
			// 移除url中的code参数
			if (null != request.getParameter("code")) {
				String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
				HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
				try {
					httpServletResponse.sendRedirect(backUrl.toString());
				} catch (IOException e) {
					_log.error("局部会话已登录，移除code参数跳转出错：", e);
				}
			} else {
				return true;
			}
		}
		// 判断是否有认证中心code
		String code = request.getParameter("upms_code");
		// 已拿到code
		if (StringUtils.isNotBlank(code)) {
			// HttpPost去校验code
			try {
//                StringBuffer sso_server_url = new StringBuffer(PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.sso.server.url"));
				StringBuffer sso_server_url = new StringBuffer(this.loginUrl);

				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(sso_server_url.toString() + "/sso/code");

				List<NameValuePair> nameValuePairs = new ArrayList<>();
				nameValuePairs.add(new BasicNameValuePair("code", code));
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse httpResponse = httpclient.execute(httpPost);
				if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity httpEntity = httpResponse.getEntity();
					JSONObject result = JSONObject.parseObject(EntityUtils.toString(httpEntity));

					Object XXXX = result.get("data");
					if (XXXX == null) {
						_log.warn("upms code XXXX: is null");
						_log.error("验证token失败：");
						return false;
					}
					if (1 == result.getIntValue("code") && result.getString("data").equals(code)) {
						// code校验正确，创建局部会话
						RedisUtil.set(ZHENG_UPMS_CLIENT_SESSION_ID + "_" + sessionId, code, timeOut);
						// 保存code对应的局部会话sessionId，方便退出操作
						RedisUtil.sadd(ZHENG_UPMS_CLIENT_SESSION_IDS + "_" + code, sessionId, timeOut);
						_log.debug("当前code={}，对应的注册系统个数：{}个", code, RedisUtil.getJedis().scard(ZHENG_UPMS_CLIENT_SESSION_IDS + "_" + code));
						// 移除url中的token参数
						String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
						// 返回请求资源
						try {
							// client无密认证
							String username = request.getParameter("upms_username");
							UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, "");
							subject.login(usernamePasswordToken);
							HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
							httpServletResponse.sendRedirect(backUrl.toString());
							return true;
						} catch (IOException e) {
							_log.error("已拿到code，移除code参数跳转出错：", e);
						}
					} else {
						_log.warn(result.getString("data"));
					}
				}
			} catch (IOException e) {
				_log.error("验证token失败：", e);
			}
		}
		return false;
	}

}
