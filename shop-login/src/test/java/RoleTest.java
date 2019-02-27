import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by weichen on 2018/9/13.
 */
public class RoleTest {

	@Test
	public void testHasRole() {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro-role.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal().toString());

//		1. 判断角色是否具有 角色role1
		Assert.assertTrue(subject.hasRole("role1"));

//		2. 判断拥有角色:role1 and role2
		Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1","role2")));

//		3. . 判断拥有角色:role1 and role2 and role3
		boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
		Assert.assertEquals(true, result[2]);

		subject.logout();
	}

	@Test(expected = UnauthorizedException.class)
	public void testCheckRole() {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro-role.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal().toString());

		subject.checkRole("role1");
		subject.checkRoles("role1", "role2");
		subject.checkRoles("role1", "role2", "role3");
		subject.logout();
	}


//	public Subject userLogin (String configFile, String userName, String password) {
////		1. 获取SecurityManager工厂，此处使用Ini配置恩建初始化SecurityManager
//		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory(configFile);
////		2. 根据工厂对象，获取SeurityManager实例
//		SecurityManager securityManager = iniSecurityManagerFactory.createInstance();
////		3. 将SecurityManager 实例绑定至 SecurityUtils对象上
//		SecurityUtils.setSecurityManager(securityManager);
////		4. 得到Subject，也就是创建 用户名/密码身份验证的Token（即用户身份/凭证）
//		Subject subject = SecurityUtils.getSubject();
//
//		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//		try {
////			5. 登录，即身份验证；且成功
//			subject.login(token);
//			System.out.println("user login success!");
//		} catch (AuthenticationException e) {
////			6.身份验证失败
//			e.printStackTrace();
//			System.out.println("user login fail!");
//		}
//
//		return subject;
//	}

}
