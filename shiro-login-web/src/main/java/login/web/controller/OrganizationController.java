
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
import login.web.model.Organization;
import login.web.service.OrganizationService;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Controller
@RequestMapping("/api/v1/organization")
public class OrganizationController extends BaseController {

	@Autowired
	OrganizationService organizationService;

	@RequiresPermissions("upms:organization:read")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		List<Organization> result = organizationService.selectList(new MyEntityWrapper<>());
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

    @RequiresPermissions("upms:organization:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
		@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
		@RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
		@RequestParam(required = false, defaultValue = "", value = "search") String search,
		@RequestParam(required = false, value = "sort") String sort,
		@RequestParam(required = false, value = "order") String order
    ) {
    	MyPage<Organization> myPage = new MyPage<>();
        myPage.setCurrent(offset);
        myPage.setSize(limit);
        if (order.equals("desc") == true) {
        	myPage.setDescs(Arrays.asList(sort.split(",")));
        } else {
        	myPage.setAscs(Arrays.asList(sort.split(",")));
        }

        MyEntityWrapper<Organization> myEntityWrapper = new MyEntityWrapper<>();
		MyPage<Organization> result = organizationService.selectPage(myPage, myEntityWrapper);
    	return new UpmsResult(UpmsResultConstant.SUCCESS, result);
    }

	@RequiresPermissions("upms:organization:read")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable("id") int organizationId) {
		Organization result = organizationService.selectById(organizationId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

	@RequiresPermissions("upms:organization:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Object create(@RequestBody Organization organization) {
		int count = organizationService.insert(organization);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:organization:delete")
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		String[] idsArray = ids.split(",");
		List<String> idsList = Arrays.asList(idsArray);
		int count = organizationService.deleteBatchIds(idsList);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:organization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object update(@PathVariable("id") int id, Organization organization) {
		organization.setId(id);
		int count = organizationService.updateById(organization);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}