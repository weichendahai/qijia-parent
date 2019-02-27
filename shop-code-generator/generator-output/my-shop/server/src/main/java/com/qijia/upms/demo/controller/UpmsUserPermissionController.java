package com.qijia.upms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Date;
import com.srsj.common.bo.PageResponse;
import com.qijia.upms.bo.vo.UpmsUserPermissionRequest;
import com.qijia.upms.bo.po.UpmsUserPermissionResponse;
import com.qijia.upms.model.UpmsUserPermission;
import com.qijia.upms.service.UpmsUserPermissionService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/upmsuserpermission")
public class UpmsUserPermissionController extends BaseController {

	@Autowired
	UpmsUserPermissionService upmsUserPermissionService;

	/**
	 *
	 * @api {POST} /api/v1/upmsuserpermission/insert 添加数据
	 * @apiName insert_data
	 * @apiGroup upmsuserpermission
	 * @apiVersion 1.0.0
	 * @apiDescription 添加数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {Integer} user_id 用户编号
	 * @apiParam {Integer} permission_id 权限编号
	 * @apiParam {Integer} type 权限类型(-1:减权限,1:增权限)
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "user_id": (Integer) 用户编号
	 *     "permission_id": (Integer) 权限编号
	 *     "type": (Integer) 权限类型(-1:减权限,1:增权限)
	 *     "create_time": (Long) 创建时间
	 *     "update_time": (Long) 修改时间
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
	 *      "id": (Integer) 编号
	 *      "user_id": (Integer) 用户编号
	 *      "permission_id": (Integer) 权限编号
	 *      "type": (Integer) 权限类型(-1:减权限,1:增权限)
	 *      "create_time": (Long) 创建时间
	 *      "update_time": (Long) 修改时间
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
	private String insert (@RequestBody UpmsUserPermissionRequest params) {
		UpmsUserPermission upmsUserPermission = upmsUserPermissionService.assembleUpmsUserPermission(params);
		int r = upmsUserPermissionService.insert(upmsUserPermission);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmsuserpermission/delete 删除数据
	 * @apiName delete_data
	 * @apiGroup upmsuserpermission
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
		int r = upmsUserPermissionService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmsuserpermission/update 修改数据
	 * @apiName update_data
	 * @apiGroup upmsuserpermission
	 * @apiVersion 1.0.0
	 * @apiDescription 修改数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {Integer} user_id 用户编号
	 * @apiParam {Integer} permission_id 权限编号
	 * @apiParam {Integer} type 权限类型(-1:减权限,1:增权限)
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "user_id": (Integer) 用户编号
	 *     "permission_id": (Integer) 权限编号
	 *     "type": (Integer) 权限类型(-1:减权限,1:增权限)
	 *     "create_time": (Long) 创建时间
	 *     "update_time": (Long) 修改时间
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
	private String update (@RequestBody UpmsUserPermissionRequest params) {
		UpmsUserPermission upmsUserPermission = upmsUserPermissionService.assembleUpmsUserPermission(params);
		int r = upmsUserPermissionService.update(upmsUserPermission);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmsuserpermission/list 列表数据
	 * @apiName get_data
	 * @apiGroup upmsuserpermission
	 * @apiVersion 1.0.0
	 * @apiDescription 列表数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {Integer} user_id 用户编号
	 * @apiParam {Integer} permission_id 权限编号
	 * @apiParam {Integer} type 权限类型(-1:减权限,1:增权限)
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *      "id": (Integer) 编号
	 *      "user_id": (Integer) 用户编号
	 *      "permission_id": (Integer) 权限编号
	 *      "type": (Integer) 权限类型(-1:减权限,1:增权限)
	 *      "create_time": (Long) 创建时间
	 *      "update_time": (Long) 修改时间
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
	 *      	"id": (Integer) 编号
	 *      	"user_id": (Integer) 用户编号
	 *      	"permission_id": (Integer) 权限编号
	 *      	"type": (Integer) 权限类型(-1:减权限,1:增权限)
	 *      	"create_time": (Long) 创建时间
	 *      	"update_time": (Long) 修改时间
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
	private String list (@RequestBody UpmsUserPermissionRequest params) {
		PageResponse<UpmsUserPermissionResponse> upmsUserPermissionList = upmsUserPermissionService.queryByObject(params);
		String str = callbackSuccess(upmsUserPermissionList);
		return str;
	}
}