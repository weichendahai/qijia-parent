package login.web.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

 /**
  * desc : SysUser
  * Created by weichen on  2018/09/18.
  */
@TableName(value = "sys_user")
public class SysUser implements Serializable {

	// id
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;
	// organizationId
	private Long organizationId;
	// username
	private String username;
	// password
	private String password;
	// salt
	private String salt;
	// roleIds
	private String roleIds;
	// locked
	private Boolean locked;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setOrganizationId(Long value) {
		this.organizationId = value;
	}
	
	public Long getOrganizationId() {
		return this.organizationId;
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
	
	public void setRoleIds(String value) {
		this.roleIds = value;
	}
	
	public String getRoleIds() {
		return this.roleIds;
	}
	
	public void setLocked(Boolean value) {
		this.locked = value;
	}
	
	public Boolean getLocked() {
		return this.locked;
	}
	
}
