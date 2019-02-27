<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameAllLower = table.classNameLowerCase>
package ${basepackage}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Date;
import com.srsj.common.bo.PageResponse;
import ${basepackage}.bo.vo.${className}Request;
import ${basepackage}.bo.po.${className}Response;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

<#include "/java_copyright.include">

@Controller
@RequestMapping("/api/v1/${tableNameAllLower}")
public class ${className}Controller extends BaseController {

	@Autowired
	${className}Service ${classNameLower}Service;

	/**
	 *
	 * @api {POST} /api/v1/${tableNameAllLower}/insert 添加数据
	 * @apiName insert_data
	 * @apiGroup ${tableNameAllLower}
	 * @apiVersion 1.0.0
	 * @apiDescription 添加数据;接口详细描述
	 *
	 <#list table.columns as column>
	 * @apiParam {${column.simpleJavaType}} ${column.sqlName} ${column.columnAlias}
	 </#list>
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
		<#list table.columns as column>
	 *     "${column.sqlName}": (${column.simpleJavaType}) ${column.columnAlias}
		</#list>
	 * }
	 *
	 * @apiSuccess {int} code 结果码
	 * @apiSuccess {String} message 消息说明
	 * @apiSuccess {String} data 返回内容
	 *
	 * @apiSuccessExample {json} Success-Response:
	 * HTTP/1.1 200 OK
	 * {
	 *   "code": 0,
	 *   "message": "",
	 *   "data":{
	 	  <#list table.columns as column>
	 *      "${column.sqlName}": (${column.simpleJavaType}) ${column.columnAlias}
	 	  </#list>
	 *   }
	 * }
	 *
	 * @apiError -3XXX1 <code>{"code": -3XXX1, "message": "参数错误描述001", "data": {}}</code>
	 * @apiError -3XXX2 <code>{"code": -3XXX2, "message": "逻辑错误描述001", "data": {}}</code>
	 * @apiErrorExample {json} Error-Response:
	 * HTTP/1.1 200
	 * {"code": -3XXX1, "message": "参数错误描述001", "data": {}}
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String insert (@RequestBody ${className}Request params) {
		${className} ${classNameLower} = ${classNameLower}Service.assemble${className}(params);
		int r = ${classNameLower}Service.insert(${classNameLower});
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/${tableNameAllLower}/delete 删除数据
	 * @apiName delete_data
	 * @apiGroup ${tableNameAllLower}
	 * @apiVersion 1.0.0
	 * @apiDescription 删除数据;接口详细描述
	 *
	 * @apiParam {int} id 记录唯一标识
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
     *   110
	 * }
	 *
	 * @apiSuccess {int} code 结果码
	 * @apiSuccess {String} message 消息说明
	 * @apiSuccess {String} data 返回内容
	 *
	 * @apiSuccessExample {json} Success-Response:
	 * HTTP/1.1 200 OK
	 * {
	 *   "code": 0,
	 *   "message": "",
	 *   "data":{
	 *   }
	 * }
	 *
	 * @apiError -3XXX1 <code>{"code": -3XXX1, "message": "参数错误描述001", "data": {}}</code>
	 * @apiError -3XXX2 <code>{"code": -3XXX2, "message": "逻辑错误描述001", "data": {}}</code>
	 * @apiErrorExample {json} Error-Response:
	 * HTTP/1.1 200
	 * {"code": -3XXX1, "message": "参数错误描述001", "data": {}}
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String delete (@RequestBody Long id) {
		int r = ${classNameLower}Service.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/${tableNameAllLower}/update 修改数据
	 * @apiName update_data
	 * @apiGroup ${tableNameAllLower}
	 * @apiVersion 1.0.0
	 * @apiDescription 修改数据;接口详细描述
	 *
	 <#list table.columns as column>
	 * @apiParam {${column.simpleJavaType}} ${column.sqlName} ${column.columnAlias}
	 </#list>
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
		<#list table.columns as column>
	 *     "${column.sqlName}": (${column.simpleJavaType}) ${column.columnAlias}
		</#list>
	 * }
	 *
	 * @apiSuccess {int} code 结果码
	 * @apiSuccess {String} message 消息说明
	 * @apiSuccess {String} data 返回内容
	 *
	 * @apiSuccessExample {json} Success-Response:
	 * HTTP/1.1 200 OK
	 * {
	 *   "code": 0,
	 *   "message": "",
	 *   "data":{
	 *   }
	 * }
	 *
	 * @apiError -3XXX1 <code>{"code": -3XXX1, "message": "参数错误描述001", "data": {}}</code>
	 * @apiError -3XXX2 <code>{"code": -3XXX2, "message": "逻辑错误描述001", "data": {}}</code>
	 * @apiErrorExample {json} Error-Response:
	 * HTTP/1.1 200
	 * {"code": -3XXX1, "message": "参数错误描述001", "data": {}}
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String update (@RequestBody ${className}Request params) {
		${className} ${classNameLower} = ${classNameLower}Service.assemble${className}(params);
		int r = ${classNameLower}Service.update(${classNameLower});
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/${tableNameAllLower}/list 列表数据
	 * @apiName get_data
	 * @apiGroup ${tableNameAllLower}
	 * @apiVersion 1.0.0
	 * @apiDescription 列表数据;接口详细描述
	 *
	 <#list table.columns as column>
	 * @apiParam {${column.simpleJavaType}} ${column.sqlName} ${column.columnAlias}
	 </#list>
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
		<#list table.columns as column>
	 *      "${column.sqlName}": (${column.simpleJavaType}) ${column.columnAlias}
		</#list>
	 *		"page": {
	 *			"current_page": 1   (int) 当前页索引
	 *			"page_size": 10		(int) 每页记录个数
	 *			"sort_field": ""    (String) 排序字段
	 *			"sort_order": ""    (String) 排序顺序
	 *		}
	 * }
	 *
	 * @apiSuccess {int} code 结果码
	 * @apiSuccess {String} message 消息说明
	 * @apiSuccess {String} data 返回内容
	 *
	 * @apiSuccessExample {json} Success-Response:
	 * HTTP/1.1 200 OK
	 * {
	 *   "code": 0,
	 *   "message": "",
	 *   "data":{
	 *      "page": 1             (int) 当前页索引
	 *      "page_size": 10,      (int) 每页记录个数
	 *      "total_count": 101,   (int) 记录总个数
	 *      "page_count": 11,     (int) 总共页数
	 *      "item_list":[
			<#list table.columns as column>
	 *      	"${column.sqlName}": (${column.simpleJavaType}) ${column.columnAlias}
			</#list>
	 *		]
	 *	 }
	 * }
	 *
	 * @apiError -3XXX1 <code>{"code": -3XXX1, "message": "参数错误描述001", "data": {}}</code>
	 * @apiError -3XXX2 <code>{"code": -3XXX2, "message": "逻辑错误描述001", "data": {}}</code>
	 * @apiErrorExample {json} Error-Response:
	 * HTTP/1.1 200
	 * {"code": -3XXX1, "message": "参数错误描述001", "data": {}}
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	@ResponseBody
	private String list (@RequestBody ${className}Request params) {
		PageResponse<${className}Response> ${classNameLower}List = ${classNameLower}Service.queryByObject(params);
		String str = callbackSuccess(${classNameLower}List);
		return str;
	}
}