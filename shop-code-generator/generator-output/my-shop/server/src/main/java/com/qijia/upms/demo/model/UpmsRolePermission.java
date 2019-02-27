package com.qijia.upms.model;

import java.io.Serializable;
import java.util.Date;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public class UpmsRolePermission implements Serializable {

	// 编号
	private Integer id;
	// 角色编号
	private Integer roleId;
	// 权限编号
	private Integer permissionId;
	// 创建时间
	private Long createTime;
	// 修改时间
	private Long updateTime;
		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setRoleId(Integer value) {
		this.roleId = value;
	}
	
	public Integer getRoleId() {
		return this.roleId;
	}
	
	public void setPermissionId(Integer value) {
		this.permissionId = value;
	}
	
	public Integer getPermissionId() {
		return this.permissionId;
	}
	
	public void setCreateTime(Long value) {
		this.createTime = value;
	}
	
	public Long getCreateTime() {
		return this.createTime;
	}
	
	public void setUpdateTime(Long value) {
		this.updateTime = value;
	}
	
	public Long getUpdateTime() {
		return this.updateTime;
	}
	
}
