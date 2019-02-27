package com.qiia.authenticator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by weichen on 2018/9/12.
 */
public class MyAuthenticator {

	public void login(String configFile) {
		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory(configFile);
		SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan", "123");
		subject.login(usernamePasswordToken);
	}

}
