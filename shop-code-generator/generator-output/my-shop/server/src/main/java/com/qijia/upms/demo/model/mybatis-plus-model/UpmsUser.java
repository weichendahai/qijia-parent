
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


@TableName(value = "upms_user")
public class UpmsUser implements Serializable {

	// 编号
    @TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	// 帐号
	private String username;
	// 密码MD5(密码+盐)
	private String password;
	// 盐
	private String salt;
	// 姓名
	private String realname;
	// 头像
	private String avatar;
	// 电话
	private String phone;
	// 邮箱
	private String email;
	// 性别
	private Integer sex;
	// 状态(0:正常,1:锁定)
	private Integer locked;
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
