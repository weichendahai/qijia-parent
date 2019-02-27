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


//public class UpmsPermissionRequest extends PageRequest {
public class UpmsPermissionRequest {

//	默认构造函数
	public UpmsPermissionRequest() {
	}

//	全体构造函数
	public UpmsPermissionRequest(Integer id,Integer systemId,Integer pid,String name,Integer type,String permissionValue,String uri,String icon,Integer status,Long orders,Long createTime,Long updateTime, PageRequest pageRequest) {
		this.id = id;
		this.systemId = systemId;
		this.pid = pid;
		this.name = name;
		this.type = type;
		this.permissionValue = permissionValue;
		this.uri = uri;
		this.icon = icon;
		this.status = status;
		this.orders = orders;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.pageRequest = pageRequest;
	}

	// 编号
	@JsonProperty("id")
	private Integer id;

	// 所属系统
	@JsonProperty("system_id")
	private Integer systemId;

	// 所属上级
	@JsonProperty("pid")
	private Integer pid;

	// 名称
	@JsonProperty("name")
	private String name;

	// 类型(1:目录,2:菜单,3:按钮)
	@JsonProperty("type")
	private Integer type;

	// 权限值
	@JsonProperty("permission_value")
	private String permissionValue;

	// 路径
	@JsonProperty("uri")
	private String uri;

	// 图标
	@JsonProperty("icon")
	private String icon;

	// 状态(0:禁止,1:正常)
	@JsonProperty("status")
	private Integer status;

	// 排序
	@JsonProperty("orders")
	private Long orders;

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
	
	public void setSystemId(Integer value) {
		this.systemId = value;
	}
	
	public Integer getSystemId() {
		return this.systemId;
	}
	
	public void setPid(Integer value) {
		this.pid = value;
	}
	
	public Integer getPid() {
		return this.pid;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setPermissionValue(String value) {
		this.permissionValue = value;
	}
	
	public String getPermissionValue() {
		return this.permissionValue;
	}
	
	public void setUri(String value) {
		this.uri = value;
	}
	
	public String getUri() {
		return this.uri;
	}
	
	public void setIcon(String value) {
		this.icon = value;
	}
	
	public String getIcon() {
		return this.icon;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setOrders(Long value) {
		this.orders = value;
	}
	
	public Long getOrders() {
		return this.orders;
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
