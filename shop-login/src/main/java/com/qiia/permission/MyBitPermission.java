package com.qiia.permission;


import com.mysql.jdbc.StringUtils;
import org.apache.shiro.authz.Permission;

/**
 * Created by weichen on 2018/9/13.
 * BitPermission用于实现唯一方式的权限，规则如下
 * 权限字符串格式: + 资源字符串 + 权限位 + 实例ID;
 * 以 "+" 开头中间通过 "+" 分割
 * 权限位说明如下:
 * 0 表示所有权限
 * 1 表示新增权限（二进制:0001）
 * 2 表示修改权限（二进制:0010）
 * 4 表示新增权限（二进制:0100）
 * 8 表示新增权限（二进制:1000）
 *
 * 如 +user+10 表示对资源 user 拥有修改 / 查看权限
 */
public class MyBitPermission implements Permission {

	private String resourceIdentify;
	private int permissionBit;
	private String instanceId;

	public MyBitPermission (String permissionString) {

		System.out.println(String.format("MyBitPermission 有参，构造函数执行"));
		String[] arrayPermission = permissionString.split("\\+");

		if ( arrayPermission.length > 1) {
			resourceIdentify = arrayPermission[1];
		}

		if (StringUtils.isEmptyOrWhitespaceOnly(resourceIdentify)) {
			resourceIdentify = "*";
		}

		if (arrayPermission.length > 2) {
			permissionBit = Integer.valueOf(arrayPermission[2]);
		}

		if (arrayPermission.length > 3) {
			instanceId = arrayPermission[3];
		}

		if (StringUtils.isEmptyOrWhitespaceOnly(instanceId)) {
			instanceId = "*";
		}
	}

	@Override
	public boolean implies(Permission permission) {

		System.out.println(String.format("MyBitPermission 比对权限函数，implies 执行"));

		if (!(permission instanceof MyBitPermission)) {
			return false;
		}

		MyBitPermission other = (MyBitPermission)permission;

		if (!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))) {
			return false;
		}

		if (!(this.permissionBit == 0 || (this.permissionBit & other.permissionBit) != 0)) {
			return false;
		}

		if (!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {
			return false;
		}

		return true;
	}
}
