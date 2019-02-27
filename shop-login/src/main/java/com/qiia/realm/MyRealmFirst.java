package com.qiia.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by weichen on 2018/9/12.
 * 此文件自定义模拟 shiro的 realm 源
 * 及模拟 用户名；密码存储在这个文件内
 */
public class MyRealmFirst implements Realm {

	@Override
	public String getName() {
		return "MyRealmFirst";
	}

	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		if (authenticationToken instanceof UsernamePasswordToken) {
			return true;
		}
		return false;
	}

	//	如果身份验证失败请捕获
//	AuthenticationException 或其子类，常见的如:
//	DisabledAccountExceptio n(禁用的帐号)、
//	LockedAccountException(锁定的帐号)、
//	UnknownAccountException(错误的 帐号)、
//	ExcessiveAttemptsException(登录失败次数过多)、
//	IncorrectCredentialsException (错误 的凭证)、
//	ExpiredCredentialsException(过期的凭证)等，
//	具体请查看其继承关系;对于页面的错误消 息展示，
//	最好使用如 “用户名 / 密码错误”
//	而不是 “用户名错误”/“密码错误”，
//	防止一些恶意用户非法 扫描帐号库;
	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
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
