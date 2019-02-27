package login.web.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

 /**
  * desc : SysRole
  * Created by weichen on  2018/09/18.
  */
 @TableName(value = "sys_role")
public class SysRole implements Serializable {

	// id
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;
	// role
	private String role;
	// description
	private String description;
	// resourceIds
	private String resourceIds;
	// available
	private Boolean available;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setRole(String value) {
		this.role = value;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setResourceIds(String value) {
		this.resourceIds = value;
	}
	
	public String getResourceIds() {
		return this.resourceIds;
	}
	
	public void setAvailable(Boolean value) {
		this.available = value;
	}
	
	public Boolean getAvailable() {
		return this.available;
	}
	
}
