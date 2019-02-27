<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.srsj.common.bo.PageRequest;
import java.util.Date;

<#include "/java_copyright.include">

//public class ${className}Request extends PageRequest {
public class ${className}Request {

//	默认构造函数
	public ${className}Request() {
	}

//	全体构造函数
	public ${className}Request(<#list table.columns as column>${column.simpleJavaType} ${column.columnNameLower}<#if column_has_next>,</#if></#list>, PageRequest pageRequest) {
	<#list table.columns as column>
		this.${column.columnNameLower} = ${column.columnNameLower};
	</#list>
		this.pageRequest = pageRequest;
	}

	<#list table.columns as column>
	// ${column.columnAlias}
	@JsonProperty("${column.sqlName}")
	private ${column.simpleJavaType} ${column.columnNameLower};

	</#list>
	// 分页信息
	@JsonProperty("page")
	private PageRequest pageRequest;
		
	<#list table.columns as column>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</#list>

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
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