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
import com.qijia.upms.bo.vo.UpmsLogRequest;
import com.qijia.upms.bo.po.UpmsLogResponse;
import com.qijia.upms.model.UpmsLog;
import com.qijia.upms.service.UpmsLogService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/upmslog")
public class UpmsLogController extends BaseController {

	@Autowired
	UpmsLogService upmsLogService;

	/**
	 *
	 * @api {POST} /api/v1/upmslog/insert 添加数据
	 * @apiName insert_data
	 * @apiGroup upmslog
	 * @apiVersion 1.0.0
	 * @apiDescription 添加数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} description 操作描述
	 * @apiParam {String} username 操作用户
	 * @apiParam {Long} start_time 操作时间
	 * @apiParam {Integer} spend_time 消耗时间
	 * @apiParam {String} base_path 根路径
	 * @apiParam {String} uri URI
	 * @apiParam {String} url URL
	 * @apiParam {String} method 请求类型
	 * @apiParam {String} parameter parameter
	 * @apiParam {String} user_agent 用户标识
	 * @apiParam {String} ip IP地址
	 * @apiParam {String} result result
	 * @apiParam {String} permissions 权限值
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "description": (String) 操作描述
	 *     "username": (String) 操作用户
	 *     "start_time": (Long) 操作时间
	 *     "spend_time": (Integer) 消耗时间
	 *     "base_path": (String) 根路径
	 *     "uri": (String) URI
	 *     "url": (String) URL
	 *     "method": (String) 请求类型
	 *     "parameter": (String) parameter
	 *     "user_agent": (String) 用户标识
	 *     "ip": (String) IP地址
	 *     "result": (String) result
	 *     "permissions": (String) 权限值
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
	 *      "description": (String) 操作描述
	 *      "username": (String) 操作用户
	 *      "start_time": (Long) 操作时间
	 *      "spend_time": (Integer) 消耗时间
	 *      "base_path": (String) 根路径
	 *      "uri": (String) URI
	 *      "url": (String) URL
	 *      "method": (String) 请求类型
	 *      "parameter": (String) parameter
	 *      "user_agent": (String) 用户标识
	 *      "ip": (String) IP地址
	 *      "result": (String) result
	 *      "permissions": (String) 权限值
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
	private String insert (@RequestBody UpmsLogRequest params) {
		UpmsLog upmsLog = upmsLogService.assembleUpmsLog(params);
		int r = upmsLogService.insert(upmsLog);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmslog/delete 删除数据
	 * @apiName delete_data
	 * @apiGroup upmslog
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
		int r = upmsLogService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmslog/update 修改数据
	 * @apiName update_data
	 * @apiGroup upmslog
	 * @apiVersion 1.0.0
	 * @apiDescription 修改数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} description 操作描述
	 * @apiParam {String} username 操作用户
	 * @apiParam {Long} start_time 操作时间
	 * @apiParam {Integer} spend_time 消耗时间
	 * @apiParam {String} base_path 根路径
	 * @apiParam {String} uri URI
	 * @apiParam {String} url URL
	 * @apiParam {String} method 请求类型
	 * @apiParam {String} parameter parameter
	 * @apiParam {String} user_agent 用户标识
	 * @apiParam {String} ip IP地址
	 * @apiParam {String} result result
	 * @apiParam {String} permissions 权限值
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "description": (String) 操作描述
	 *     "username": (String) 操作用户
	 *     "start_time": (Long) 操作时间
	 *     "spend_time": (Integer) 消耗时间
	 *     "base_path": (String) 根路径
	 *     "uri": (String) URI
	 *     "url": (String) URL
	 *     "method": (String) 请求类型
	 *     "parameter": (String) parameter
	 *     "user_agent": (String) 用户标识
	 *     "ip": (String) IP地址
	 *     "result": (String) result
	 *     "permissions": (String) 权限值
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
	private String update (@RequestBody UpmsLogRequest params) {
		UpmsLog upmsLog = upmsLogService.assembleUpmsLog(params);
		int r = upmsLogService.update(upmsLog);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmslog/list 列表数据
	 * @apiName get_data
	 * @apiGroup upmslog
	 * @apiVersion 1.0.0
	 * @apiDescription 列表数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} description 操作描述
	 * @apiParam {String} username 操作用户
	 * @apiParam {Long} start_time 操作时间
	 * @apiParam {Integer} spend_time 消耗时间
	 * @apiParam {String} base_path 根路径
	 * @apiParam {String} uri URI
	 * @apiParam {String} url URL
	 * @apiParam {String} method 请求类型
	 * @apiParam {String} parameter parameter
	 * @apiParam {String} user_agent 用户标识
	 * @apiParam {String} ip IP地址
	 * @apiParam {String} result result
	 * @apiParam {String} permissions 权限值
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *      "id": (Integer) 编号
	 *      "description": (String) 操作描述
	 *      "username": (String) 操作用户
	 *      "start_time": (Long) 操作时间
	 *      "spend_time": (Integer) 消耗时间
	 *      "base_path": (String) 根路径
	 *      "uri": (String) URI
	 *      "url": (String) URL
	 *      "method": (String) 请求类型
	 *      "parameter": (String) parameter
	 *      "user_agent": (String) 用户标识
	 *      "ip": (String) IP地址
	 *      "result": (String) result
	 *      "permissions": (String) 权限值
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
	 *      	"description": (String) 操作描述
	 *      	"username": (String) 操作用户
	 *      	"start_time": (Long) 操作时间
	 *      	"spend_time": (Integer) 消耗时间
	 *      	"base_path": (String) 根路径
	 *      	"uri": (String) URI
	 *      	"url": (String) URL
	 *      	"method": (String) 请求类型
	 *      	"parameter": (String) parameter
	 *      	"user_agent": (String) 用户标识
	 *      	"ip": (String) IP地址
	 *      	"result": (String) result
	 *      	"permissions": (String) 权限值
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
	private String list (@RequestBody UpmsLogRequest params) {
		PageResponse<UpmsLogResponse> upmsLogList = upmsLogService.queryByObject(params);
		String str = callbackSuccess(upmsLogList);
		return str;
	}
}