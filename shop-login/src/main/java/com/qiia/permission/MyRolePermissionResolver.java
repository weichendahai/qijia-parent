package com.qiia.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by weichen on 2018/9/13.
 * RolePermissionResolver 用于根据角色字符串来解析得到权限集合
 * 此处实现很简单
 * 用户拥有role1角色；那么就返回一个"menu:*"的权限
 */
public class MyRolePermissionResolver implements RolePermissionResolver {
	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {

		System.out.println("MyRolePermissionResolver --> resolvePermissionsInRole 执行");

		if ("role1".equals(roleString)) {
			return Arrays.asList((Permission) new WildcardPermission("menu:*"));
		}
		return null;
	}
}
