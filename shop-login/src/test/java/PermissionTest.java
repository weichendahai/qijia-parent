import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by weichen on 2018/9/13.
 */
public class PermissionTest {

	@Test
	public void testRoleIsPermission() {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro-permission.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal());

//		等价；只是写法不同而已
//		subject.checkPermission("menu:view:1");
//		subject.checkPermission(new WildcardPermission("menu:view:1"));
		boolean permitted = subject.isPermitted("user:create");
		System.out.println((permitted == true ? "拥有user:create" : "未拥有user:create"));

		boolean permitted1 = subject.isPermitted(new WildcardPermission("user:create"));
		System.out.println((permitted1 == true ? "拥有user:create" : "未拥有user:create"));

		boolean permittedAll = subject.isPermittedAll("user:create", "user:update");
		System.out.println((permittedAll == true ? "拥有user:create, user:update" : "未拥有user:create, user:update"));

		boolean permittedAll1 = subject.isPermittedAll("user:create", "user:delete");
		System.out.println((permittedAll1 == true ? "拥有user:create, user:delete" : "未拥有user:create, user:delete"));

		boolean permittedAll2 = subject.isPermittedAll("user:create", "user:delete-xxxx");
		System.out.println((permittedAll2 == true ? "拥有user:create, user:delete" : "未拥有user:create, user:delete-xxxx"));

	}


	@Test
	public void testRoleCheckPermission() {
		TestCommon testCommon = new TestCommon();
		Subject subject = testCommon.userLogin("classpath:shiro-permission.ini", "zhangsan", "123");
		System.out.println(subject.getPrincipal());

		try {
			subject.checkPermission("user:create");
			System.out.println("拥有user:create");
		} catch (AuthorizationException e) {
			e.printStackTrace();
			System.out.println("未拥有user:create");
		}

		try {
			subject.checkPermissions("user:create", "user:update");
			System.out.println("拥有user:create, user:update");
		} catch (AuthorizationException e) {
			e.printStackTrace();
			System.out.println("未拥有user:create, user:update");
		}

		try {
			subject.checkPermissions("user:create", "user:delete");
			System.out.println("拥有user:create, user:delete");
		} catch (AuthorizationException e) {
			e.printStackTrace();
			System.out.println("未拥有user:create, user:delete");
		}


		try {
			subject.checkPermissions("user:create", "user:delete-xxxx");
			System.out.println("拥有user:create, user:delete-xxxx");
		} catch (AuthorizationException e) {
			System.out.println("未拥有user:create, user:delete-xxxx");
			e.printStackTrace();
		}
	}
}
