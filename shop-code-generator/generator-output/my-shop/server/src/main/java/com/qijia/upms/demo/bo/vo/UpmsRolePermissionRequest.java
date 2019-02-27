package com.qijia.upms.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.srsj.common.bo.PageRequest;
import java.util.Date;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


//public class UpmsRolePermissionRequest extends PageRequest {
public class UpmsRolePermissionRequest {

//	默认构造函数
	public UpmsRolePermissionRequest() {
	}

//	全体构造函数
	public UpmsRolePermissionRequest(Integer id,Integer roleId,Integer permissionId,Long createTime,Long updateTime, PageRequest pageRequest) {
		this.id = id;
		this.roleId = roleId;
		this.permissionId = permissionId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.pageRequest = pageRequest;
	}

	// 编号
	@JsonProperty("id")
	private Integer id;

	// 角色编号
	@JsonProperty("role_id")
	private Integer roleId;

	// 权限编号
	@JsonProperty("permission_id")
	private Integer permissionId;

	// 创建时间
	@JsonProperty("create_time")
	private Long createTime;

	// 修改时间
	@JsonProperty("update_time")
	private Long updateTime;

	// 分页信息
	@JsonProperty("page")
	private PageRequest pageRequest;
		
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
	

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
}
