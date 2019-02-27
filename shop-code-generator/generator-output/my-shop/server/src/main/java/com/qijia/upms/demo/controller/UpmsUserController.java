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
import com.qijia.upms.bo.vo.UpmsUserRequest;
import com.qijia.upms.bo.po.UpmsUserResponse;
import com.qijia.upms.model.UpmsUser;
import com.qijia.upms.service.UpmsUserService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/upmsuser")
public class UpmsUserController extends BaseController {

	@Autowired
	UpmsUserService upmsUserService;

	/**
	 *
	 * @api {POST} /api/v1/upmsuser/insert 添加数据
	 * @apiName insert_data
	 * @apiGroup upmsuser
	 * @apiVersion 1.0.0
	 * @apiDescription 添加数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} username 帐号
	 * @apiParam {String} password 密码MD5(密码+盐)
	 * @apiParam {String} salt 盐
	 * @apiParam {String} realname 姓名
	 * @apiParam {String} avatar 头像
	 * @apiParam {String} phone 电话
	 * @apiParam {String} email 邮箱
	 * @apiParam {Integer} sex 性别
	 * @apiParam {Integer} locked 状态(0:正常,1:锁定)
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "username": (String) 帐号
	 *     "password": (String) 密码MD5(密码+盐)
	 *     "salt": (String) 盐
	 *     "realname": (String) 姓名
	 *     "avatar": (String) 头像
	 *     "phone": (String) 电话
	 *     "email": (String) 邮箱
	 *     "sex": (Integer) 性别
	 *     "locked": (Integer) 状态(0:正常,1:锁定)
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
	 *      "username": (String) 帐号
	 *      "password": (String) 密码MD5(密码+盐)
	 *      "salt": (String) 盐
	 *      "realname": (String) 姓名
	 *      "avatar": (String) 头像
	 *      "phone": (String) 电话
	 *      "email": (String) 邮箱
	 *      "sex": (Integer) 性别
	 *      "locked": (Integer) 状态(0:正常,1:锁定)
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
	private String insert (@RequestBody UpmsUserRequest params) {
		UpmsUser upmsUser = upmsUserService.assembleUpmsUser(params);
		int r = upmsUserService.insert(upmsUser);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmsuser/delete 删除数据
	 * @apiName delete_data
	 * @apiGroup upmsuser
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
		int r = upmsUserService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmsuser/update 修改数据
	 * @apiName update_data
	 * @apiGroup upmsuser
	 * @apiVersion 1.0.0
	 * @apiDescription 修改数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} username 帐号
	 * @apiParam {String} password 密码MD5(密码+盐)
	 * @apiParam {String} salt 盐
	 * @apiParam {String} realname 姓名
	 * @apiParam {String} avatar 头像
	 * @apiParam {String} phone 电话
	 * @apiParam {String} email 邮箱
	 * @apiParam {Integer} sex 性别
	 * @apiParam {Integer} locked 状态(0:正常,1:锁定)
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "username": (String) 帐号
	 *     "password": (String) 密码MD5(密码+盐)
	 *     "salt": (String) 盐
	 *     "realname": (String) 姓名
	 *     "avatar": (String) 头像
	 *     "phone": (String) 电话
	 *     "email": (String) 邮箱
	 *     "sex": (Integer) 性别
	 *     "locked": (Integer) 状态(0:正常,1:锁定)
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
	private String update (@RequestBody UpmsUserRequest params) {
		UpmsUser upmsUser = upmsUserService.assembleUpmsUser(params);
		int r = upmsUserService.update(upmsUser);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmsuser/list 列表数据
	 * @apiName get_data
	 * @apiGroup upmsuser
	 * @apiVersion 1.0.0
	 * @apiDescription 列表数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} username 帐号
	 * @apiParam {String} password 密码MD5(密码+盐)
	 * @apiParam {String} salt 盐
	 * @apiParam {String} realname 姓名
	 * @apiParam {String} avatar 头像
	 * @apiParam {String} phone 电话
	 * @apiParam {String} email 邮箱
	 * @apiParam {Integer} sex 性别
	 * @apiParam {Integer} locked 状态(0:正常,1:锁定)
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *      "id": (Integer) 编号
	 *      "username": (String) 帐号
	 *      "password": (String) 密码MD5(密码+盐)
	 *      "salt": (String) 盐
	 *      "realname": (String) 姓名
	 *      "avatar": (String) 头像
	 *      "phone": (String) 电话
	 *      "email": (String) 邮箱
	 *      "sex": (Integer) 性别
	 *      "locked": (Integer) 状态(0:正常,1:锁定)
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
	 *      	"username": (String) 帐号
	 *      	"password": (String) 密码MD5(密码+盐)
	 *      	"salt": (String) 盐
	 *      	"realname": (String) 姓名
	 *      	"avatar": (String) 头像
	 *      	"phone": (String) 电话
	 *      	"email": (String) 邮箱
	 *      	"sex": (Integer) 性别
	 *      	"locked": (Integer) 状态(0:正常,1:锁定)
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
	private String list (@RequestBody UpmsUserRequest params) {
		PageResponse<UpmsUserResponse> upmsUserList = upmsUserService.queryByObject(params);
		String str = callbackSuccess(upmsUserList);
		return str;
	}
}