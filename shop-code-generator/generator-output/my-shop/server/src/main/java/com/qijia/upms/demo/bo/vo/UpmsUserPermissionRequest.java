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


//public class UpmsUserPermissionRequest extends PageRequest {
public class UpmsUserPermissionRequest {

//	默认构造函数
	public UpmsUserPermissionRequest() {
	}

//	全体构造函数
	public UpmsUserPermissionRequest(Integer id,Integer userId,Integer permissionId,Integer type,Long createTime,Long updateTime, PageRequest pageRequest) {
		this.id = id;
		this.userId = userId;
		this.permissionId = permissionId;
		this.type = type;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.pageRequest = pageRequest;
	}

	// 编号
	@JsonProperty("id")
	private Integer id;

	// 用户编号
	@JsonProperty("user_id")
	private Integer userId;

	// 权限编号
	@JsonProperty("permission_id")
	private Integer permissionId;

	// 权限类型(-1:减权限,1:增权限)
	@JsonProperty("type")
	private Integer type;

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
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setPermissionId(Integer value) {
		this.permissionId = value;
	}
	
	public Integer getPermissionId() {
		return this.permissionId;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
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