package com.qijia.upms.client.shiro.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.context.annotation.Configuration;

/**
 * Created by weichen on 2018/10/12.
 */
@Configuration
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//所有用户登录验证都进行通过处理
		boolean matches = super.doCredentialsMatch(token, info);
//		return matches;
		return true;
	}

}
