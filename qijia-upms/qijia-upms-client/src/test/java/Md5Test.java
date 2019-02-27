import com.qijia.common.utils.MD5Util;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import java.util.List;

/**
 * Created by weichen on 2018/10/10.
 */

public class Md5Test {
	@Test
	public void testMd5() {
//		admin 用户名
//		3038D9CB63B3152A79B8153FB06C02F7 密码
//		66f1b370c660445a8657bf8bf1794486 salt

		final String source = "123456"; // 明文密码
		final String salt = "admin66f1b370c660445a8657bf8bf1794486"; // 盐值
		final int hashIterations = 2; // 散列次数，例如：2 等于 MD5(md5())
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		// 上述的底层实现如下：
//		 SimpleHash md5Hash = new SimpleHash("MD5", source, salt, hashIterations);
		System.out.println(md5Hash.toString());

		String md5Str = MD5Util.MD5(source+salt);
		System.out.println(md5Str);

	}
}
