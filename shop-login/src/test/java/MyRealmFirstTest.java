import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by weichen on 2018/9/12.
 */
public class MyRealmFirstTest {

	@Test
	public void testRealmFirst () {

//		1. 获取SecurityManager工厂，此处使用Ini配置恩建初始化SecurityManager
		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//		2. 根据工厂对象，获取SeurityManager实例
		SecurityManager securityManager = iniSecurityManagerFactory.createInstance();
//		3. 将SecurityManager 实例绑定至 SecurityUtils对象上
		SecurityUtils.setSecurityManager(securityManager);
//		4. 得到Subject，也就是创建 用户名/密码身份验证的Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
		try {
//			5. 登录，即身份验证；且成功
			subject.login(token);
			System.out.println("user login is success!");
		} catch (AuthenticationException e) {
//			6.身份验证失败
			e.printStackTrace();
			System.out.println("user login is fail!");
		}

		Assert.assertEquals(true, subject.isAuthenticated());
//		7. 退出
		subject.logout();
	}
}
