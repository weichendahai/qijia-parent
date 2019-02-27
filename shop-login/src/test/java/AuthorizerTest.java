import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by weichen on 2018/9/13.
 */
public class AuthorizerTest {

	@Test
	public void testIsPermission() {
		TestCommon testCommon = new TestCommon();
		String ConfigFile = "classpath:shiro-authorizer.ini";

		Subject subject = testCommon.userLogin(ConfigFile, "zhangsan", "123");

		//判断拥有权限:user:update
		boolean permitted1 = subject.isPermitted("user1:update");
		boolean permitted2 = subject.isPermitted("user2:update");
		System.out.println((permitted1 == true ? "拥有user1:update" : "未拥有user1:update"));
		System.out.println((permitted2 == true ? "拥有user2:update" : "未拥有user2:update"));

		boolean permitted3 = subject.isPermitted("+user1+2");
		boolean permitted4 = subject.isPermitted("+user1+8");
		boolean permitted5 = subject.isPermitted("+user2+10");
		boolean permitted6 = subject.isPermitted("+user1+4");
		boolean permitted7 = subject.isPermitted("menu:view");

		System.out.println((permitted3 == true ? "拥有+user1+2"  : "未拥有+user1+2"));
		System.out.println((permitted4 == true ? "拥有+user1+8"  : "未拥有+user1+8"));
		System.out.println((permitted5 == true ? "拥有+user2+10" : "未拥有+user2+10"));
		System.out.println((permitted6 == true ? "拥有+user1+4"  : "未拥有+user1+4"));
		System.out.println((permitted7 == true ? "拥有menu:view" : "未拥有menu:view"));
	}
}
