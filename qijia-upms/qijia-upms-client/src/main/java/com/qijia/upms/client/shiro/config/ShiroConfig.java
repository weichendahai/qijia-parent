package com.qijia.upms.client.shiro.config;

import com.qijia.upms.client.shiro.filter.UpmsAuthenticationFilter;
import com.qijia.upms.client.shiro.listener.UpmsSessionListener;
import com.qijia.upms.client.shiro.realm.UpmsRealm;
import com.qijia.upms.client.shiro.session.UpmsSessionDao;
import com.qijia.upms.client.shiro.session.UpmsSessionFactory;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;


/**
 * Created by weichen on 2018/9/19.
 * 如何配置让shiro执行我们的自定义sessionManager呢？下面看ShiroConfig类。
 */
//临时注释
@Configuration
public class ShiroConfig {

//	# 终端类型
//	zheng.upms.type=${zheng.upms.type}
//	# 终端session名称
//	zheng.upms.session.id=${zheng.upms.session.id}
//	# 会话时长,半小时（单位毫秒）
//	zheng.upms.session.timeout=${zheng.upms.session.timeout}
//	# 单点登录认证中心地址
//	zheng.upms.sso.server.url=${zheng.upms.sso.server.url}
//	# 登录成功回调地址
//	zheng.upms.successUrl=${zheng.upms.successUrl}
//	# 未授权地址
//	zheng.upms.unauthorizedUrl=${zheng.upms.unauthorizedUrl}
//	# 记住密码时长30天
//	zheng.upms.rememberMe.timeout=${zheng.upms.rememberMe.timeout}


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

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		//设置管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);

//		web serlet 过滤器 | 重写authc过滤器
		Map<String, Filter> authcFilters = new HashMap<>();
		authcFilters.put("authc", upmsAuthenticationFilter());
		shiroFilterFactoryBean.setFilters(authcFilters);

		// 配置不会被拦截的链接 顺序判断
		//注意过滤器配置顺序 不能颠倒
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//		filterChainDefinitionMap.put("/logout", "logout");
//		filterChainDefinitionMap.put("/static/**", "anon");
//		filterChainDefinitionMap.put("/ajaxLogin", "anon");
//		filterChainDefinitionMap.put("/login", "anon");
//		filterChainDefinitionMap.put("/**", "authc");

		filterChainDefinitionMap.put("/api/v1/manage/**/**", "authc");
		filterChainDefinitionMap.put("/api/v1/manage/**", "authc");
		filterChainDefinitionMap.put("/manage/**", "authc");
		filterChainDefinitionMap.put("/druid/**", "user");
		filterChainDefinitionMap.put("/swagger-ui.html", "user");
		filterChainDefinitionMap.put("/resources/**", "anon");
		filterChainDefinitionMap.put("/**", "anon");

//		 /manage/** = upmsSessionForceLogout,authc
//		 /manage/index = user
//		 /druid/** = user
//		 /swagger-ui.html = user
//		 /resources/** = anon
//		 /** = anon
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		//配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
		shiroFilterFactoryBean.setLoginUrl(loginUrl);
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl(successUrl);
		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
//		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
//		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
//		return hashedCredentialsMatcher;

		MyHashedCredentialsMatcher hashedCredentialsMatcher = new MyHashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	@Bean
	public UpmsRealm myShiroRealm() {
		UpmsRealm myShiroRealm = new UpmsRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}


	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		// 自定义session管理 使用redis
		securityManager.setSessionManager(sessionManager());
		// 自定义缓存实现 使用redis
		// TODO: 2018/10/9 此处需要重写；使用redis进行处理
//		securityManager.setCacheManager(cacheManager());
		return securityManager;
	}

	//自定义sessionManager
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

//		全局session超时时间
		sessionManager.setGlobalSessionTimeout(globalSessionTimeout);
		sessionManager.setSessionDAO(redisSessionDAO());
		sessionManager.setSessionIdCookieEnabled(true);
		sessionManager.setSessionIdCookie(sessionIdCookie());
		sessionManager.setSessionValidationSchedulerEnabled(false);

		ArrayList<SessionListener> sessionListeners = new ArrayList<>();
		sessionListeners.add(new UpmsSessionListener());
		sessionManager.setSessionListeners(sessionListeners);

		sessionManager.setSessionFactory(upmsSessionFactory());

		return sessionManager;
//		MySessionManager mySessionManager = new MySessionManager();
//		mySessionManager.setSessionDAO(redisSessionDAO());
//		return mySessionManager;
	}

	//	会话Cookie模板
	@Bean
	public SimpleCookie sessionIdCookie() {
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setHttpOnly(true);
		simpleCookie.setMaxAge(rememberMeCookieMaxAge);
		simpleCookie.setName(sessionIdCookieName);
		return simpleCookie;
	}

	/**
	 * RedisSessionDAO shiro sessionDao层的实现 通过redis
	 * <p>
	 * 使用的是shiro-redis开源插件
	 */
	@Bean
	public UpmsSessionDao redisSessionDAO() {
		UpmsSessionDao redisSessionDAO = new UpmsSessionDao();
//		redisSessionDAO.setRedisManager(redisManager());
		return redisSessionDAO;
	}

	@Bean
	public UpmsSessionFactory upmsSessionFactory() {
		return new UpmsSessionFactory();
	}


	/**
	 * @return
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	/**
	 * 开启shiro aop注解支持.
	 * 使用代理方式;所以需要开启代码支持;
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

//	@Bean(name = "lifecycleBeanPostProcessor")
//	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//		return new LifecycleBeanPostProcessor();
//	}

	//================
	@Bean
	public UpmsAuthenticationFilter upmsAuthenticationFilter() {
		return  new UpmsAuthenticationFilter();
	}
}
