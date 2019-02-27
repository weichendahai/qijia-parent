
package com.qijia.upms.controller.manager;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qijia.framework.controller.BaseController;
import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.framework.dao.MyPage;
import com.qijia.upms.common.constant.UpmsResult;
import com.qijia.upms.common.constant.UpmsResultConstant;
import com.qijia.upms.model.UpmsRole;
import com.qijia.upms.rpc.api.UpmsRoleService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/manager/upmsrole")
public class UpmsRoleController extends BaseController {

	@Autowired
	UpmsRoleService upmsRoleService;

	@RequiresPermissions("upms:upmsrole:read")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		List<UpmsRole> result = upmsRoleService.selectList(new MyEntityWrapper<>());
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

    @RequiresPermissions("upms:upmsrole:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
		@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
		@RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
		@RequestParam(required = false, defaultValue = "", value = "search") String search,
		@RequestParam(required = false, value = "sort") String sort,
		@RequestParam(required = false, value = "order") String order
    ) {
    	MyPage<UpmsRole> myPage = new MyPage<>();
        myPage.setCurrent(offset);
        myPage.setSize(limit);
        if (order.equals("desc") == true) {
        	myPage.setDescs(Arrays.asList(sort.split(",")));
        } else {
        	myPage.setAscs(Arrays.asList(sort.split(",")));
        }

        MyEntityWrapper<UpmsRole> myEntityWrapper = new MyEntityWrapper<>();
		MyPage<UpmsRole> result = upmsRoleService.selectPage(myPage, myEntityWrapper);
    	return new UpmsResult(UpmsResultConstant.SUCCESS, result);
    }

	@RequiresPermissions("upms:upmsrole:read")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable("id") int upmsroleId) {
		UpmsRole result = upmsRoleService.selectById(upmsroleId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

	@RequiresPermissions("upms:upmsrole:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Object create(@RequestBody UpmsRole upmsrole) {
		int count = upmsRoleService.insert(upmsrole);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:upmsrole:delete")
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		String[] idsArray = ids.split(",");
		List<String> idsList = Arrays.asList(idsArray);
		int count = upmsRoleService.deleteBatchIds(idsList);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:upmsrole:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object update(@PathVariable("id") int id, UpmsRole upmsrole) {
		upmsrole.setId(id);
		int count = upmsRoleService.updateById(upmsrole);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}