import com.qiia.authenticator.MyAuthenticator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by weichen on 2018/9/12.
 */
public class MyAuthenTicatorTest {

	@Test
	public void testAllSuccessfulStrategyWithSuccess() {
		String configFile = "classpath:shiro-authenticator-all-success.ini";
		MyAuthenticator myAuthenticator = new MyAuthenticator();
		myAuthenticator.login(configFile);

		Subject subject = SecurityUtils.getSubject();

		PrincipalCollection principals = subject.getPrincipals();
		System.out.println(principals.toString());

		Assert.assertEquals(1, principals.asList().size());
	}
}
