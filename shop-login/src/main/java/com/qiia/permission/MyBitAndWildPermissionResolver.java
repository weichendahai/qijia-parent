package com.qiia.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by weichen on 2018/9/13.
 * MyBitAndWildPermissionResolver 实现 permissionResolver接口
 * 并根据权限字符串是否包含"+"开头来解析全选字符串为 MyBitPermission 或 WildcardPermission
 */
public class MyBitAndWildPermissionResolver implements PermissionResolver {

	@Override
	public Permission resolvePermission(String permissionString) {

		System.out.println("MyBitAndWildPermissionResolver --> resolvePermission 执行");

		if (permissionString.startsWith("+")) {
			return new MyBitPermission(permissionString);
		}

		return new WildcardPermission(permissionString);
	}
}
