package com.qiia.sessionfactory;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by weichen on 2018/9/18.
 */
public class MyOnlineSessionFactory implements SessionFactory {

	public Session createSession(SessionContext initData) {

		OnlineSession session = new OnlineSession();
		session.setHost("127.0.0.1");
		session.setUserAgent("User-Agent-chrome");
		session.setSystemHost("127.0.0.1:8088");

//		if (initData != null && initData instanceof WebSessionContext)
//		{
//			WebSessionContext sessionContext = (WebSessionContext)initData;
//			HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
//			if (request != null) {
//				session.setHost(IpUtils.getIpAddr(request));
//				session.setUserAgent(request.getHeader("User-Agent"));
//				session.setSystemHost(request.getLocalAddr() + ":" + request.getLocalPort());
//			}
//		}

		return session;
	}
}
