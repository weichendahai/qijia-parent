package com.qiia.sessiondao;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by weichen on 2018/9/18.
 */
public class MySessionDAO extends CachingSessionDAO{

//	private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();
	/**
	 * 会话在缓存会话中创建
	 * @param session
	 * @return
	 */
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session); assignSessionId(session, sessionId);
		String sql = "insert into sessions(id, session) values(?,?)";
//		jdbcTemplate.update(sql, sessionId, SerializableUtils.serialize(session));
		System.out.println(sql);
		return session.getId();


	}

	/**
	 * 会话在缓存会话中修改
	 * @param session
	 */
	protected void doUpdate(Session session) {
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) { return; //如果会话过期/停止 没必要再更新了
		}
		String sql = "update sessions set session=? where id=?";
		System.out.println(sql);
//		jdbcTemplate.update(sql, SerializableUtils.serialize(session), session.getId());
	}

	/**
	 * 会话在缓存会话中删除
	 * @param session
	 */
	protected void doDelete(Session session) {
		String sql = "delete from sessions where id=?";
		System.out.println(sql);
//		jdbcTemplate.update(sql, session.getId());
	}


	/**
	 * 会话在缓存内读取
	 * @param sessionId
	 * @return
	 */
	protected Session doReadSession(Serializable sessionId) {
		String sql = "select session from sessions where id=?";
		System.out.println(sql);
		return null;
//		List<String> sessionStrList = jdbcTemplate.queryForList(sql, String.class, sessionId);
//		if(sessionStrList.size() == 0) return null;
//		return SerializableUtils.deserialize(sessionStrList.get(0));
	}
}
