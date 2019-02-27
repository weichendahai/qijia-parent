package login.web.model;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

 /**
  * desc : SysOrganization
  * Created by weichen on  2018/09/18.
  */
@TableName(value = "sys_organization")
public class SysOrganization implements Serializable {

	// id
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;
	// name
	private String name;
	// parentId
	private Long parentId;
	// parentIds
	private String parentIds;
	// available
	private Boolean available;
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setParentId(Long value) {
		this.parentId = value;
	}
	
	public Long getParentId() {
		return this.parentId;
	}
	
	public void setParentIds(String value) {
		this.parentIds = value;
	}
	
	public String getParentIds() {
		return this.parentIds;
	}
	
	public void setAvailable(Boolean value) {
		this.available = value;
	}
	
	public Boolean getAvailable() {
		return this.available;
	}
	
}
