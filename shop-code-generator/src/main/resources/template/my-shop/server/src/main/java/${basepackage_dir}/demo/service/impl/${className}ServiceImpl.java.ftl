<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import ${basepackage}.bo.vo.${className}Request;
import ${basepackage}.bo.po.${className}Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<#include "/java_copyright.include">

@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Dao,${className}> implements ${className}Service {

	@Autowired
	${className}Dao ${classNameLower}Dao;

	@Override
	public PageResponse<${className}Response> queryByObject(${className}Request ${classNameLower}Request) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		${className} ${classNameLower} = assemble${className}(${classNameLower}Request);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(${classNameLower}Request.getPageRequest());
		List<${className}> ${classNameLower}List = ${classNameLower}Dao.queryByObject(${classNameLower});

//		转换model 为 response data
		List<${className}Response> myList = new ArrayList<${className}Response>();
		for (${className} item : ${classNameLower}List ) {
			myList.add(assemble${className}(item));
		}

		PageResponse<${className}Response> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； ${className} 转换为 ${className}Response
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public ${className}Response assemble${className} (${className} ${classNameLower} ){

		${className}Response ${classNameLower}Response = new ${className}Response();
		<#list table.columns as column>
		${classNameLower}Response.set${column.columnName}(${classNameLower}.get${column.columnName}());
		</#list>
		return ${classNameLower}Response;
	}

	/**
	 * 客户端请求 ${className}Request 转换为 ${className}
	 * @param ${classNameLower}Request
	 * @return
	 */
	@Override
	public ${className} assemble${className} (${className}Request ${classNameLower}Request ){
		${className} ${classNameLower} = new ${className}();
		<#list table.columns as column>
		${classNameLower}.set${column.columnName}(${classNameLower}Request.get${column.columnName}());
		</#list>
		return ${classNameLower};
	}
}
