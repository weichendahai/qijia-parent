package com.qijia.upms.client.shiro.realm;

import com.qijia.common.utils.MD5Util;
import com.qijia.common.utils.PropertiesFileUtil;
import com.qijia.upms.model.UpmsPermission;
import com.qijia.upms.model.UpmsRole;
import com.qijia.upms.model.UpmsUser;
import com.qijia.upms.rpc.api.UpmsApiService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * 用户授权与认证
 * Created by weichen on 2018/10/8.
 */
public class UpmsRealm extends AuthorizingRealm {


	//	终端session名称
	@Value("${zheng.upms.type}")
	private String appUpmsType;

	@Autowired
	private UpmsApiService upmsApiService;

	/**
	 * 校验权限
	 *
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String) principals.getPrimaryPrincipal();
		UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(userName);

		//当前用户所有角色
		List<UpmsRole> upmsRoles = upmsApiService.selectUpmsRoleByUpmsUserId(upmsUser.getId());
		Set<String> roles = new HashSet<>();

		for (UpmsRole upmsRole : upmsRoles) {
			if (StringUtils.isNotBlank(upmsRole.getName())) {
				roles.add(upmsRole.getName());
			}
		}

		// 当前用户所有权限
		List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(upmsUser.getId());
		Set<String> permissions = new HashSet<>();
		for (UpmsPermission upmsPermission : upmsPermissions) {
			if (StringUtils.isNotBlank(upmsPermission.getPermissionValue())) {
				permissions.add(upmsPermission.getPermissionValue());
			}
		}

		permissions.add("*.*");

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		simpleAuthorizationInfo.setStringPermissions(permissions);
		simpleAuthorizationInfo.setRoles(roles);
		return simpleAuthorizationInfo;
	}

	/**
	 * 校验登录
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String userName = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());

		//client 无密码验证
//		String upmsType = PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.type");
		String upmsType = this.appUpmsType;
		if ("client".equals(upmsType)) {
//			return new SimpleAuthenticationInfo(userName, password, getName());

			UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(userName);
			return new SimpleAuthenticationInfo(
					userName,
					upmsUser.getPassword(), //密码
					getName()    //realm name
			);
		}

//		查找用户信息
		UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(userName);

//		用户不存在
		if (null == upmsUser) {
			throw new UnknownAccountException();
		}

//		校验用户密码
//		if(!upmsUser.getPassword().equals(MD5Util.MD5(password + upmsUser.getSalt()))) {
//			throw new IncorrectCredentialsException();
//		}


//		Md5Hash md5Hash = new Md5Hash(password, userName + upmsUser.getSalt(), 2);
//		if(!upmsUser.getPassword().equals(md5Hash.toString())) {
//			throw new IncorrectCredentialsException();
//		}

		if (upmsUser.getLocked() == 1) {
			throw new LockedAccountException();
		}

//		此处使用shiro md5 方法，自动校验密码
//		校验方式Md5Hash md5Hash = new Md5Hash(password, userName + upmsUser.getSalt(), 2);
//		return new SimpleAuthenticationInfo(
//				userName,
//				upmsUser.getPassword(), //密码
//				ByteSource.Util.bytes(upmsUser.getUsername() + upmsUser.getSalt()), //salt=username+salt
//				getName()    //realm name
//		);

		return new SimpleAuthenticationInfo(
				userName,
				upmsUser.getPassword(), //密码
				getName()    //realm name
		);

//		return new SimpleAuthenticationInfo(userName, password, getName());
	}

}
