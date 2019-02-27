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


//public class UpmsLogRequest extends PageRequest {
public class UpmsLogRequest {

//	默认构造函数
	public UpmsLogRequest() {
	}

//	全体构造函数
	public UpmsLogRequest(Integer id,String description,String username,Long startTime,Integer spendTime,String basePath,String uri,String url,String method,String parameter,String userAgent,String ip,String result,String permissions,Long createTime,Long updateTime, PageRequest pageRequest) {
		this.id = id;
		this.description = description;
		this.username = username;
		this.startTime = startTime;
		this.spendTime = spendTime;
		this.basePath = basePath;
		this.uri = uri;
		this.url = url;
		this.method = method;
		this.parameter = parameter;
		this.userAgent = userAgent;
		this.ip = ip;
		this.result = result;
		this.permissions = permissions;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.pageRequest = pageRequest;
	}

	// 编号
	@JsonProperty("id")
	private Integer id;

	// 操作描述
	@JsonProperty("description")
	private String description;

	// 操作用户
	@JsonProperty("username")
	private String username;

	// 操作时间
	@JsonProperty("start_time")
	private Long startTime;

	// 消耗时间
	@JsonProperty("spend_time")
	private Integer spendTime;

	// 根路径
	@JsonProperty("base_path")
	private String basePath;

	// URI
	@JsonProperty("uri")
	private String uri;

	// URL
	@JsonProperty("url")
	private String url;

	// 请求类型
	@JsonProperty("method")
	private String method;

	// parameter
	@JsonProperty("parameter")
	private String parameter;

	// 用户标识
	@JsonProperty("user_agent")
	private String userAgent;

	// IP地址
	@JsonProperty("ip")
	private String ip;

	// result
	@JsonProperty("result")
	private String result;

	// 权限值
	@JsonProperty("permissions")
	private String permissions;

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
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setStartTime(Long value) {
		this.startTime = value;
	}
	
	public Long getStartTime() {
		return this.startTime;
	}
	
	public void setSpendTime(Integer value) {
		this.spendTime = value;
	}
	
	public Integer getSpendTime() {
		return this.spendTime;
	}
	
	public void setBasePath(String value) {
		this.basePath = value;
	}
	
	public String getBasePath() {
		return this.basePath;
	}
	
	public void setUri(String value) {
		this.uri = value;
	}
	
	public String getUri() {
		return this.uri;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setMethod(String value) {
		this.method = value;
	}
	
	public String getMethod() {
		return this.method;
	}
	
	public void setParameter(String value) {
		this.parameter = value;
	}
	
	public String getParameter() {
		return this.parameter;
	}
	
	public void setUserAgent(String value) {
		this.userAgent = value;
	}
	
	public String getUserAgent() {
		return this.userAgent;
	}
	
	public void setIp(String value) {
		this.ip = value;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void setResult(String value) {
		this.result = value;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setPermissions(String value) {
		this.permissions = value;
	}
	
	public String getPermissions() {
		return this.permissions;
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
