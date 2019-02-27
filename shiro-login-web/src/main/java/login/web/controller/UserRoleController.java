
package login.web.controller;

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
import login.web.constant.UpmsResult;
import login.web.constant.UpmsResultConstant;
import login.web.model.UserRole;
import login.web.service.UserRoleService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/userrole")
public class UserRoleController extends BaseController {

	@Autowired
	UserRoleService userRoleService;

	@RequiresPermissions("upms:userrole:read")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		List<UserRole> result = userRoleService.selectList(new MyEntityWrapper<>());
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

    @RequiresPermissions("upms:userrole:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
		@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
		@RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
		@RequestParam(required = false, defaultValue = "", value = "search") String search,
		@RequestParam(required = false, value = "sort") String sort,
		@RequestParam(required = false, value = "order") String order
    ) {
    	MyPage<UserRole> myPage = new MyPage<>();
        myPage.setCurrent(offset);
        myPage.setSize(limit);
        if (order.equals("desc") == true) {
        	myPage.setDescs(Arrays.asList(sort.split(",")));
        } else {
        	myPage.setAscs(Arrays.asList(sort.split(",")));
        }

        MyEntityWrapper<UserRole> myEntityWrapper = new MyEntityWrapper<>();
		MyPage<UserRole> result = userRoleService.selectPage(myPage, myEntityWrapper);
    	return new UpmsResult(UpmsResultConstant.SUCCESS, result);
    }

	@RequiresPermissions("upms:userrole:read")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable("id") int userroleId) {
		UserRole result = userRoleService.selectById(userroleId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

	@RequiresPermissions("upms:userrole:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Object create(@RequestBody UserRole userrole) {
		int count = userRoleService.insert(userrole);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:userrole:delete")
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		String[] idsArray = ids.split(",");
		List<String> idsList = Arrays.asList(idsArray);
		int count = userRoleService.deleteBatchIds(idsList);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:userrole:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object update(@PathVariable("id") int id, UserRole userrole) {
		userrole.setId(id);
		int count = userRoleService.updateById(userrole);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}