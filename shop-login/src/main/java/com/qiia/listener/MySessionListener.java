package com.qiia.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * Created by weichen on 2018/9/18.
 */
public class MySessionListener implements SessionListener {
	@Override
	public void onStart(Session session) {
		System.out.println(String.format("会话被创建: %s", session.getId()));
	}

	@Override
	public void onStop(Session session) {
		System.out.println(String.format("会话停止: %s", session.getId()));

	}

	@Override
	public void onExpiration(Session session) {
		System.out.println(String.format("会话过期: %s", session.getId()));
	}
}
