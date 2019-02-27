
package com.qijia.upms.controller.manager;

import com.qijia.framework.controller.BaseController;
import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.framework.dao.MyPage;
import com.qijia.upms.common.constant.UpmsResult;
import com.qijia.upms.common.constant.UpmsResultConstant;
import com.qijia.upms.model.UpmsUser;
import com.qijia.upms.rpc.api.UpmsUserService;
import com.qijia.upms.service.MyUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/rpc")
public class UserTestController extends BaseController {

	@Autowired
	MyUserService myUserService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		List<UpmsUser> result = myUserService.hello();
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object selectById(@PathVariable("id") Integer userId) {
		UpmsUser user = myUserService.selectById(userId);
		return user;
	}

	@RequestMapping(value = "/query/ids/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public List<UpmsUser> selectBatchIds(@PathVariable("ids") String ids) {
		List<UpmsUser> users = myUserService.selectBatchIds(ids);
		return users;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	List<UpmsUser> selectList() {
		List<UpmsUser> users = myUserService.selectList();
		return users;
	}

	@RequestMapping(value = "/query/page/", method = RequestMethod.POST)
	@ResponseBody
	MyPage<UpmsUser> selectPage(@RequestBody MyPage<UpmsUser> page) {
		MyPage<UpmsUser> userMyPage = myUserService.selectPage(page);
		return userMyPage;
	}
}