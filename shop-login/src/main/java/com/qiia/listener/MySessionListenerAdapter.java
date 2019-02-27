package com.qiia.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * Created by weichen on 2018/9/18.
 */
public class MySessionListenerAdapter extends SessionListenerAdapter{

	@Override
	public void onStart(Session session) {
		System.out.println(String.format("会话被创建2: %s", session.getId()));
	}

	@Override
	public void onStop(Session session) {
		System.out.println(String.format("会话停止2: %s", session.getId()));

	}

	@Override
	public void onExpiration(Session session) {
		System.out.println(String.format("会话过期2: %s", session.getId()));
	}

}
