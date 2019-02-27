package com.qijia.upms.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public class UpmsSystemResponse {

	// 编号
	@JsonProperty("id")
	private Integer id;

	// 图标
	@JsonProperty("icon")
	private String icon;

	// 背景
	@JsonProperty("banner")
	private String banner;

	// 主题
	@JsonProperty("theme")
	private String theme;

	// 根目录
	@JsonProperty("basepath")
	private String basepath;

	// 状态(-1:黑名单,1:正常)
	@JsonProperty("status")
	private Integer status;

	// 系统名称
	@JsonProperty("name")
	private String name;

	// 系统标题
	@JsonProperty("title")
	private String title;

	// 系统描述
	@JsonProperty("description")
	private String description;

	// 排序
	@JsonProperty("orders")
	private Long orders;

	// 创建时间
	@JsonProperty("create_time")
	private Long createTime;

	// 修改时间
	@JsonProperty("update_time")
	private Long updateTime;

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setIcon(String value) {
		this.icon = value;
	}
	
	public String getIcon() {
		return this.icon;
	}
	
	public void setBanner(String value) {
		this.banner = value;
	}
	
	public String getBanner() {
		return this.banner;
	}
	
	public void setTheme(String value) {
		this.theme = value;
	}
	
	public String getTheme() {
		return this.theme;
	}
	
	public void setBasepath(String value) {
		this.basepath = value;
	}
	
	public String getBasepath() {
		return this.basepath;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
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
