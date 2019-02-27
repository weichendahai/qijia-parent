package com.qijia.upms.controller;

import com.qijia.framework.controller.BaseController;
import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.upms.client.shiro.session.UpmsSession;
import com.qijia.upms.client.shiro.session.UpmsSessionDao;
import com.qijia.upms.common.constant.UpmsResult;
import com.qijia.upms.common.constant.UpmsResultConstant;
import com.qijia.upms.model.UpmsSystem;
import com.qijia.upms.rpc.api.UpmsSystemService;
import com.qijia.upms.rpc.api.UpmsUserService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qijia.common.redis.utils.RedisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

/**
 * 单点登录管理
 * Created by weichen on 2018/10/9.
 */
@Controller
@RequestMapping("/sso")
public class SSOController extends BaseController {

	private final static Logger _log = LoggerFactory.getLogger(SSOController.class);

	//	全局会话Key
	private final static String ZHENG_UPMS_SERVER_SESSION_ID = "zheng-upms-server-session-id";
	//	全局会话key列表
	private final static String ZHENG_UPMS_SERVER_SESSION_IDS = "zheng-upms-server-session-ids";
	//	code key
	private final static String ZHENG_UPMS_SERVER_CODE = "zheng-upms-server-code";

	@Autowired
	UpmsSystemService upmsSystemService;

	@Autowired
	UpmsUserService upmsUserService;

	@Autowired
	UpmsSessionDao upmsSessionDao;

	@RequestMapping(value = "/t1", method = RequestMethod.GET)
	@ResponseBody
	public Object t1(HttpServletRequest request) throws Exception {
		return "hh 0001";
	}

	/**
	 * 认证中心首页
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) throws Exception {
		String appId = request.getParameter("appid");
		String backUrl = request.getParameter("backurl");

		if (StringUtils.isBlank(appId)) {
			throw new RuntimeException("无效访问，参数异常");
		}

		UpmsSystem modelFilter = new UpmsSystem();
		modelFilter.setName(appId);
		UpmsSystem upmsSystem = upmsSystemService.selectOne(modelFilter);

		if (null == upmsSystem) {
			throw new RuntimeException(String.format("未注册的系统:%s", appId));
		}

		return String.format("redirect:/sso/login?backurl=%s", URLEncoder.encode(backUrl, "utf-8"));
	}


	/**
	 * 返回登录页面；提示用户进行登录
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String serverSessionId = session.getId().toString();

//		判断是否已经登录，如果已经登录，则跳回
		String code = RedisUtil.get(String.format("%s_%s", ZHENG_UPMS_SERVER_SESSION_ID, serverSessionId));

//		code 校验值
		if (StringUtils.isNotBlank(code)) {
			//回跳转
			String backurl = request.getParameter("backurl");
			String userName = (String) subject.getPrincipal();

			if (StringUtils.isBlank(backurl)) {
				backurl = "/";
			} else {
				if (backurl.contains("?")) {
					backurl = String.format("%s&upms_code=%s&upms_username=%s", backurl, code, userName);
				} else {
					backurl = String.format("%s?upms_code=%s&upms_username=%s", backurl, code, userName);
				}
			}

			_log.debug("认证中心账号通过，带code回跳{}", backurl);
			return String.format("redirect:%s", backurl);
		}

//		返回登录页面
		return "login";
//		return "sso/login";
//		return "/sso/login.jsp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody Map RequestBody, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
//		String userName = request.getParameter("username");
//		String password = request.getParameter("password");
//		String rememberMe = request.getParameter("rememberMe");

		String userName = RequestBody.get("username").toString();
		String password = RequestBody.get("password").toString();
		String rememberMe = RequestBody.get("rememberMe").toString();

		if (StringUtils.isBlank(userName)) {
			return new UpmsResult(UpmsResultConstant.EMPTY_USERNAME, "帐号不能为空！");
		}
		if (org.apache.commons.lang.StringUtils.isBlank(password)) {
			return new UpmsResult(UpmsResultConstant.EMPTY_PASSWORD, "密码不能为空！");
		}

		//准备shiro进行登录
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String sessionId = session.getId().toString();

//		判断是否已经登录，如果已经登录，则调回；放置重复登录
		String haveCode = RedisUtil.get(String.format("%s_%s", ZHENG_UPMS_SERVER_SESSION_ID, sessionId));

		//用户未登录
		if (StringUtils.isBlank(haveCode)) {
//			使用shiro进行登录校验
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
			try {
				if (BooleanUtils.toBoolean(rememberMe)) {
					usernamePasswordToken.setRememberMe(true);
				} else {
					usernamePasswordToken.setRememberMe(false);
				}
//				执行登录
				subject.login(usernamePasswordToken);
			} catch (UnknownAccountException e) {
				return new UpmsResult(UpmsResultConstant.INVALID_USERNAME, "帐号不存在！");
			} catch (IncorrectCredentialsException e) {
				return new UpmsResult(UpmsResultConstant.INVALID_PASSWORD, "密码错误！");
			} catch (LockedAccountException e) {
				return new UpmsResult(UpmsResultConstant.INVALID_ACCOUNT, "帐号已锁定！");
			}

			// TODO: 2018/10/9 sdfsfsdfsdfsdf
//			用户登录成功之后操作

//			更新session状态
			upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.on_line);
//			全局会话sessionId列表，供会话管理
			RedisUtil.lpush(ZHENG_UPMS_SERVER_SESSION_IDS, sessionId);
//			默认验证帐号密码正确，创建code
			String code = UUID.randomUUID().toString();
			// 全局会话的code
			RedisUtil.set(String.format("%s_%s", ZHENG_UPMS_SERVER_SESSION_ID, sessionId), code, (int) subject.getSession().getTimeout() / 1000);
			// code校验值
			RedisUtil.set(String.format("%s_%s", ZHENG_UPMS_SERVER_CODE, code), code, (int) subject.getSession().getTimeout() / 1000);
		}

		// 回跳登录前地址
		String backurl = RequestBody.get("backurl").toString();
//		String backurl = request.getParameter("backurl");
		if (StringUtils.isBlank(backurl)) {
			return new UpmsResult(UpmsResultConstant.SUCCESS, "/");
		} else {
			return new UpmsResult(UpmsResultConstant.SUCCESS, backurl);
		}
	}

	/**
	 * 校验 code
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	@ResponseBody
	public Object code(HttpServletRequest request) {
		String codeParam = request.getParameter("code");
		String code = RedisUtil.get(String.format("%s_%s", ZHENG_UPMS_SERVER_CODE, codeParam));

		if (StringUtils.isBlank(codeParam) || !codeParam.equals(code)) {
			new UpmsResult(UpmsResultConstant.FAILED, "无效code");
		}
		return new UpmsResult(UpmsResultConstant.SUCCESS, code);
	}

	/**
	 * 退出登录
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
//		shiro 退出登录
		SecurityUtils.getSubject().logout();

//		调转回原地址
		String redirectUrl = request.getHeader("Referer");

		if (null == redirectUrl) {
			redirectUrl = "/";
		}

		return "redirect:" + redirectUrl;
	}

}
