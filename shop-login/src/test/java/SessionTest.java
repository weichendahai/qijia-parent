import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.io.Serializable;

/**
 * Created by weichen on 2018/9/18.
 */
public class SessionTest {

	@Test
	public void testSession () {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal().toString());

		Session session = subject.getSession();
		Serializable sessionId = session.getId();
		System.out.println(String.format("session sessionId: %s",sessionId));
//		获取当前 Subject 的主机地址，该地址是通过 HostAuthenticationToken.getHost() 提供的。
		System.out.println(String.format("session 主机地址: %s",session.getHost()));
//		获取 / 设置当前 Session 的过期时间;如果不设置默认是会话管理器的全局过期时间。
		System.out.println(String.format("session 过期时间: %s",session.getTimeout()));
//		获取 / 设置当前 Session 的过期时间;如果不设置默认是会话管理器的全局过期时间。
		System.out.println(String.format("session 开始登陆时间: %s",session.getStartTimestamp()));
		System.out.println(String.format("session 最后访问时间: %s",session.getLastAccessTime()));

//		sessiong 自定义属性
		session.setAttribute("my_key", "112233");
		System.out.println(String.format("添加 my_key: %s", "112233"));
		Object my_key = session.getAttribute("my_key");
		System.out.println(String.format("自定义key my_key: %s",my_key));
		session.removeAttribute("my_key");
		System.out.println(String.format("移除 my_key"));

//		如果是 JavaSE 应用需要自己定期调用 session.touch() 去更新最后访问 时间;
//		如果是 Web 应用，每次进入 ShiroFilter 都会自动调用 session.touch() 来更新最后访问时间。
		session.touch();
		System.out.println(String.format("刷新session会话时间"));


		subject.logout();
	}


	/**
	 * 主要测试会话管理及会话监听
	 */
//	Shiro 提供了三个默认实现:
//	DefaultSessionManager:DefaultSecurityManager 使用的默认实现，用于 JavaSE 环境;
//	ServletContainerSessionManager:DefaultWebSecurityManager 使用的默认实现，用于Web环境，其直接使用Servlet容器的会话;
//	DefaultWebSessionManager:用于Web环境的实现，可以替代ServletContainerSessionManager，自己维护着会话，直接废弃了Servlet容器的会话管理。
	@Test
	public void testSessionManager () {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro-session-manager.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal().toString());

		Session session = subject.getSession();
		Serializable sessionId = session.getId();
		System.out.println(String.format("session sessionId: %s",sessionId));
//		获取当前 Subject 的主机地址，该地址是通过 HostAuthenticationToken.getHost() 提供的。
		System.out.println(String.format("session 主机地址: %s",session.getHost()));
//		获取 / 设置当前 Session 的过期时间;如果不设置默认是会话管理器的全局过期时间。
		System.out.println(String.format("session 过期时间: %s",session.getTimeout()));
//		获取 / 设置当前 Session 的过期时间;如果不设置默认是会话管理器的全局过期时间。
		System.out.println(String.format("session 开始登陆时间: %s",session.getStartTimestamp()));
		System.out.println(String.format("session 最后访问时间: %s",session.getLastAccessTime()));

//		sessiong 自定义属性
		session.setAttribute("my_key", "112233");
		System.out.println(String.format("添加 my_key: %s", "112233"));
		Object my_key = session.getAttribute("my_key");
		System.out.println(String.format("自定义key my_key: %s",my_key));
		session.removeAttribute("my_key");
		System.out.println(String.format("移除 my_key"));

//		如果是 JavaSE 应用需要自己定期调用 session.touch() 去更新最后访问 时间;
//		如果是 Web 应用，每次进入 ShiroFilter 都会自动调用 session.touch() 来更新最后访问时间。
		session.touch();
		System.out.println(String.format("刷新session会话时间"));

		subject.logout();
	}


	@Test
	public void testSessionManagerDAO () {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro-session-manager-dao.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal().toString());

		Session session = subject.getSession();
		Serializable sessionId = session.getId();
		System.out.println(String.format("session sessionId: %s",sessionId));
//		获取当前 Subject 的主机地址，该地址是通过 HostAuthenticationToken.getHost() 提供的。
		System.out.println(String.format("session 主机地址: %s",session.getHost()));
//		获取 / 设置当前 Session 的过期时间;如果不设置默认是会话管理器的全局过期时间。
		System.out.println(String.format("session 过期时间: %s",session.getTimeout()));
//		获取 / 设置当前 Session 的过期时间;如果不设置默认是会话管理器的全局过期时间。
		System.out.println(String.format("session 开始登陆时间: %s",session.getStartTimestamp()));
		System.out.println(String.format("session 最后访问时间: %s",session.getLastAccessTime()));

//		sessiong 自定义属性
		session.setAttribute("my_key", "112233");
		System.out.println(String.format("添加 my_key: %s", "112233"));
		Object my_key = session.getAttribute("my_key");
		System.out.println(String.format("自定义key my_key: %s",my_key));
		session.removeAttribute("my_key");
		System.out.println(String.format("移除 my_key"));

//		如果是 JavaSE 应用需要自己定期调用 session.touch() 去更新最后访问 时间;
//		如果是 Web 应用，每次进入 ShiroFilter 都会自动调用 session.touch() 来更新最后访问时间。
		session.touch();
		System.out.println(String.format("刷新session会话时间"));

		subject.logout();
	}
}
