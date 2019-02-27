
package com.qijia.upms.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@TableName(value = "upms_permission")
public class UpmsPermission implements Serializable {

	// 编号
    @TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	// 所属系统
	private Integer systemId;
	// 所属上级
	private Integer pid;
	// 名称
	private String name;
	// 类型(1:目录,2:菜单,3:按钮)
	private Integer type;
	// 权限值
	private String permissionValue;
	// 路径
	private String uri;
	// 图标
	private String icon;
	// 状态(0:禁止,1:正常)
	private Integer status;
	// 排序
	private Long orders;
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
	
}
