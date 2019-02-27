
package login.web.model;

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


@TableName(value = "upms_log")
public class Log implements Serializable {

	// 编号
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	// 操作描述
	private String description;
	// 操作用户
	private String username;
	// 操作时间
	private Long startTime;
	// 消耗时间
	private Integer spendTime;
	// 根路径
	private String basePath;
	// URI
	private String uri;
	// URL
	private String url;
	// 请求类型
	private String method;
	// parameter
	private String parameter;
	// 用户标识
	private String userAgent;
	// IP地址
	private String ip;
	// result
	private String result;
	// 权限值
	private String permissions;
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

}
