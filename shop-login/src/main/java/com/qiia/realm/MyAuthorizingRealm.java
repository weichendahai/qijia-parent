package com.qiia.realm;

import com.qiia.permission.MyBitPermission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * Created by weichen on 2018/9/13.
 * 此时我们继承 AuthorizingRealm 而不是实现 Realm 接口;
 * 推荐使用 AuthorizingRealm，
 * 因为:
 * AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token):表示获取身份验证信息;
 * AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals):表示根据用户身份获取授权信息。
 * 这种方式的好处是当只需要身份验证时只需要获取身份验证信息而不需要获取授权信息
 */
public class MyAuthorizingRealm extends AuthorizingRealm {

	/**
	 * 如果身份验证成功，在进行授权时就通过 doGetAuthorizationInfo 方法获 取角色 / 权限信息用于授权验证。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		System.out.println("MyAuthorizingRealm ---> doGetAuthorizationInfo 执行");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("role1");
		authorizationInfo.addRole("role2");

		authorizationInfo.addObjectPermission(new MyBitPermission("+user1+10"));
		authorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));

		authorizationInfo.addStringPermission("+user2+10");
		authorizationInfo.addStringPermission("user2:*");
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		System.out.println("MyAuthorizingRealm ---> doGetAuthenticationInfo 执行");

		//		根据authenticationToken获取用户名和密码
//		principals: 在shiro中是"身份"；及主体的标识属性，唯一ID信息；一个主体可以有多个principals，但是只能有一个primary principals
//		credentials： 在shiro中是"证明，凭证"，即只有主体知道的安全值，如密码、安全秘钥等
//		最常见的 principals 和 credentials 组合，就是用户名和密码
		String userName = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());

		System.out.println(String.format("userName: %s, password: %s", userName, password));

		if (!"zhangsan".equals(userName)) {
			//用户不存在
			throw new UnknownAccountException();
		}

		if (!"123".equals(password)) {
			// 密码错误
			throw new IncorrectCredentialsException();
		}
		//身份验证成功通过，返回一个 AuthenticationInfo 的实例；
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());
		return simpleAuthenticationInfo;
	}
}
