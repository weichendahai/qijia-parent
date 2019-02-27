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
import com.qijia.upms.bo.vo.UpmsSystemRequest;
import com.qijia.upms.bo.po.UpmsSystemResponse;
import com.qijia.upms.model.UpmsSystem;
import com.qijia.upms.service.UpmsSystemService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/upmssystem")
public class UpmsSystemController extends BaseController {

	@Autowired
	UpmsSystemService upmsSystemService;

	/**
	 *
	 * @api {POST} /api/v1/upmssystem/insert 添加数据
	 * @apiName insert_data
	 * @apiGroup upmssystem
	 * @apiVersion 1.0.0
	 * @apiDescription 添加数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} icon 图标
	 * @apiParam {String} banner 背景
	 * @apiParam {String} theme 主题
	 * @apiParam {String} basepath 根目录
	 * @apiParam {Integer} status 状态(-1:黑名单,1:正常)
	 * @apiParam {String} name 系统名称
	 * @apiParam {String} title 系统标题
	 * @apiParam {String} description 系统描述
	 * @apiParam {Long} orders 排序
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "icon": (String) 图标
	 *     "banner": (String) 背景
	 *     "theme": (String) 主题
	 *     "basepath": (String) 根目录
	 *     "status": (Integer) 状态(-1:黑名单,1:正常)
	 *     "name": (String) 系统名称
	 *     "title": (String) 系统标题
	 *     "description": (String) 系统描述
	 *     "orders": (Long) 排序
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
	 *      "icon": (String) 图标
	 *      "banner": (String) 背景
	 *      "theme": (String) 主题
	 *      "basepath": (String) 根目录
	 *      "status": (Integer) 状态(-1:黑名单,1:正常)
	 *      "name": (String) 系统名称
	 *      "title": (String) 系统标题
	 *      "description": (String) 系统描述
	 *      "orders": (Long) 排序
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
	private String insert (@RequestBody UpmsSystemRequest params) {
		UpmsSystem upmsSystem = upmsSystemService.assembleUpmsSystem(params);
		int r = upmsSystemService.insert(upmsSystem);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmssystem/delete 删除数据
	 * @apiName delete_data
	 * @apiGroup upmssystem
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
		int r = upmsSystemService.delete(id);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmssystem/update 修改数据
	 * @apiName update_data
	 * @apiGroup upmssystem
	 * @apiVersion 1.0.0
	 * @apiDescription 修改数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} icon 图标
	 * @apiParam {String} banner 背景
	 * @apiParam {String} theme 主题
	 * @apiParam {String} basepath 根目录
	 * @apiParam {Integer} status 状态(-1:黑名单,1:正常)
	 * @apiParam {String} name 系统名称
	 * @apiParam {String} title 系统标题
	 * @apiParam {String} description 系统描述
	 * @apiParam {Long} orders 排序
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *     "id": (Integer) 编号
	 *     "icon": (String) 图标
	 *     "banner": (String) 背景
	 *     "theme": (String) 主题
	 *     "basepath": (String) 根目录
	 *     "status": (Integer) 状态(-1:黑名单,1:正常)
	 *     "name": (String) 系统名称
	 *     "title": (String) 系统标题
	 *     "description": (String) 系统描述
	 *     "orders": (Long) 排序
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
	private String update (@RequestBody UpmsSystemRequest params) {
		UpmsSystem upmsSystem = upmsSystemService.assembleUpmsSystem(params);
		int r = upmsSystemService.update(upmsSystem);
		String str = callbackSuccess (r);
		return str;
	}

	/**
	 * @api {POST} /api/v1/upmssystem/list 列表数据
	 * @apiName get_data
	 * @apiGroup upmssystem
	 * @apiVersion 1.0.0
	 * @apiDescription 列表数据;接口详细描述
	 *
	 * @apiParam {Integer} id 编号
	 * @apiParam {String} icon 图标
	 * @apiParam {String} banner 背景
	 * @apiParam {String} theme 主题
	 * @apiParam {String} basepath 根目录
	 * @apiParam {Integer} status 状态(-1:黑名单,1:正常)
	 * @apiParam {String} name 系统名称
	 * @apiParam {String} title 系统标题
	 * @apiParam {String} description 系统描述
	 * @apiParam {Long} orders 排序
	 * @apiParam {Long} create_time 创建时间
	 * @apiParam {Long} update_time 修改时间
	 *
	 * @apiParamExample {json} Request-Example：
	 * {
	 *      "id": (Integer) 编号
	 *      "icon": (String) 图标
	 *      "banner": (String) 背景
	 *      "theme": (String) 主题
	 *      "basepath": (String) 根目录
	 *      "status": (Integer) 状态(-1:黑名单,1:正常)
	 *      "name": (String) 系统名称
	 *      "title": (String) 系统标题
	 *      "description": (String) 系统描述
	 *      "orders": (Long) 排序
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
	 *      	"icon": (String) 图标
	 *      	"banner": (String) 背景
	 *      	"theme": (String) 主题
	 *      	"basepath": (String) 根目录
	 *      	"status": (Integer) 状态(-1:黑名单,1:正常)
	 *      	"name": (String) 系统名称
	 *      	"title": (String) 系统标题
	 *      	"description": (String) 系统描述
	 *      	"orders": (Long) 排序
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
	private String list (@RequestBody UpmsSystemRequest params) {
		PageResponse<UpmsSystemResponse> upmsSystemList = upmsSystemService.queryByObject(params);
		String str = callbackSuccess(upmsSystemList);
		return str;
	}
}