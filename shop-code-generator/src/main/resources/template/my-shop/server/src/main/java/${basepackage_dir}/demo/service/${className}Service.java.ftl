<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import ${basepackage}.bo.vo.${className}Request;
import ${basepackage}.bo.po.${className}Response;
import ${basepackage}.model.${className};

<#include "/java_copyright.include">

public interface ${className}Service extends IBaseService<${className}> {
	PageResponse<${className}Response> queryByObject (${className}Request ${classNameLower}Request);

	${className}Response assemble${className}(${className} ${classNameLower});

	${className} assemble${className}(${className}Request ${classNameLower}Request);
}