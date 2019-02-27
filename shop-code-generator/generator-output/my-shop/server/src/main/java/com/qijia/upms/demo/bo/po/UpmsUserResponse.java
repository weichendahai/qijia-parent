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


public class UpmsUserResponse {

	// 编号
	@JsonProperty("id")
	private Integer id;

	// 帐号
	@JsonProperty("username")
	private String username;

	// 密码MD5(密码+盐)
	@JsonProperty("password")
	private String password;

	// 盐
	@JsonProperty("salt")
	private String salt;

	// 姓名
	@JsonProperty("realname")
	private String realname;

	// 头像
	@JsonProperty("avatar")
	private String avatar;

	// 电话
	@JsonProperty("phone")
	private String phone;

	// 邮箱
	@JsonProperty("email")
	private String email;

	// 性别
	@JsonProperty("sex")
	private Integer sex;

	// 状态(0:正常,1:锁定)
	@JsonProperty("locked")
	private Integer locked;

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
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setSalt(String value) {
		this.salt = value;
	}
	
	public String getSalt() {
		return this.salt;
	}
	
	public void setRealname(String value) {
		this.realname = value;
	}
	
	public String getRealname() {
		return this.realname;
	}
	
	public void setAvatar(String value) {
		this.avatar = value;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setSex(Integer value) {
		this.sex = value;
	}
	
	public Integer getSex() {
		return this.sex;
	}
	
	public void setLocked(Integer value) {
		this.locked = value;
	}
	
	public Integer getLocked() {
		return this.locked;
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
