package login.web.shiro;

import login.web.model.SysUser;
import login.web.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by weichen on 2018/9/18.
 */
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService userService;

	// 获取用户权限
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//		String userName = (String) principalCollection.getPrimaryPrincipal();
//		SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();

		SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();

		String userName = sysUser.getUsername();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		authorizationInfo.setRoles(userService.findRoles(userName));
		authorizationInfo.setStringPermissions(userService.findPermissions(userName));

		System.out.println(String.format("用户权限: %s", userService.findPermissions(userName)));
		return authorizationInfo;
	}

	/*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/

	//	用户登录
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String userName = (String) authenticationToken.getPrincipal();
		//通过username从数据库中查找 User对象，如果找到，没找到.
		//实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		SysUser user = userService.findByUsername(userName);

		//账号不存在
		if (user == null) {
			throw new UnknownAccountException();
		}

		//账号被锁定
		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException();
		}

		return new SimpleAuthenticationInfo(
				user,
				user.getPassword(), //密码
				ByteSource.Util.bytes(user.getUsername() + user.getSalt()), //salt=username+salt
				getName()    //realm name
		);

//		return new SimpleAuthenticationInfo(
//				user.getUsername(),//用户名
//				user.getPassword(),//密码
//				ByteSource.Util.bytes(user.getUsername() + user.getSalt()), //salt=username+salt
//				getName()    //realm name
//		);
	}
}
