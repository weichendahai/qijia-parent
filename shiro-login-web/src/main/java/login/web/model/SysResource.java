package login.web.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

 /**
  * desc : SysResource
  * Created by weichen on  2018/09/18.
  */
 @TableName(value = "sys_resource")
public class SysResource implements Serializable {

	// id
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;
	// name
	private String name;
	// type
	private String type;
	// url
	private String url;
	// parentId
	private Long parentId;
	// parentIds
	private String parentIds;
	// permission
	private String permission;
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
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
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
	
	public void setPermission(String value) {
		this.permission = value;
	}
	
	public String getPermission() {
		return this.permission;
	}
	
	public void setAvailable(Boolean value) {
		this.available = value;
	}
	
	public Boolean getAvailable() {
		return this.available;
	}
	
}
