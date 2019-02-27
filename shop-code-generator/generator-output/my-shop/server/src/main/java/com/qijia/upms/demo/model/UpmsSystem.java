package com.qijia.upms.model;

import java.io.Serializable;
import java.util.Date;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public class UpmsSystem implements Serializable {

	// 编号
	private Integer id;
	// 图标
	private String icon;
	// 背景
	private String banner;
	// 主题
	private String theme;
	// 根目录
	private String basepath;
	// 状态(-1:黑名单,1:正常)
	private Integer status;
	// 系统名称
	private String name;
	// 系统标题
	private String title;
	// 系统描述
	private String description;
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
