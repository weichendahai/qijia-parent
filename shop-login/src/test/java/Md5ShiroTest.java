import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * Created by weichen on 2018/9/21.
 */
public class Md5ShiroTest {

	@Test
	public void testMd5Shiro() {

//		d3c59d25033dbf980d29554025c23a75
//		d3c59d25033dbf980d29554025c23a75


		final String source = "123456"; // 明文密码
		final String salt = "zhangsan8d78869f470951332959580424d4bf4f"; // 盐值
//		final String source = "123456"; // 明文密码
//		final String salt = "admin8d78869f470951332959580424d4bf4f"; // 盐值
		final int hashIterations = 2; // 散列次数，例如：2 等于 MD5(md5())
//		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);

		Md5Hash md5Hash = new Md5Hash(source, null, hashIterations);

		// 上述的底层实现如下：
		// SimpleHash sh = new SimpleHash("MD5", source, salt, hashIterations);
		System.out.println(md5Hash.toString());



	}

}
