<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#--自定义变量-->
<#assign sqlTableName = table.sqlName>

package ${basepackage}.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

<#include "/java_copyright.include">

@TableName(value = "${sqlTableName}")
public class ${className} implements Serializable {

	<#list table.columns as column>
	// ${column.columnAlias}
	<#if column.columnNameLower == "id">
    @TableId(value = "id",type = IdType.AUTO)
	</#if>
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
		
	<#list table.columns as column>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</#list>
}
<#macro generateJavaColumns>
	<#list table.columns as column>
    <@generateBycondition column.sqlName>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</@generateBycondition>
	</#list>
</#macro>