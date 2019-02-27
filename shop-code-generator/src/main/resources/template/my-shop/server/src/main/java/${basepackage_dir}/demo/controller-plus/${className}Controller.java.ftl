<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameAllLower = table.classNameLowerCase>

<#--项目自定义参数-->
<#assign appModelPackangeName = basepackage + '.model'>
<#assign appDaoPackangeName = basepackage + '.dao'>
<#assign appConfigPackangeName = basepackage + '.config'>
<#assign appServicePackangeName = basepackage + '.rpc.api'>
<#assign appControllerPackangeName = basepackage + '.controller'>
<#assign appConstantPackangeName = basepackage + '.common.constant'>

package ${appControllerPackangeName};

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
import ${appConstantPackangeName}.UpmsResult;
import ${appConstantPackangeName}.UpmsResultConstant;
import ${appModelPackangeName}.${className};
import ${appServicePackangeName}.${className}Service;

<#include "/java_copyright.include">

@Controller
@RequestMapping("/api/v1/${tableNameAllLower}")
public class ${className}Controller extends BaseController {

	@Autowired
	${className}Service ${classNameLower}Service;

	@RequiresPermissions("upms:${tableNameAllLower}:read")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		List<${className}> result = ${classNameLower}Service.selectList(new MyEntityWrapper<>());
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

    @RequiresPermissions("upms:${tableNameAllLower}:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
		@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
		@RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
		@RequestParam(required = false, defaultValue = "", value = "search") String search,
		@RequestParam(required = false, value = "sort") String sort,
		@RequestParam(required = false, value = "order") String order
    ) {
    	MyPage<${className}> myPage = new MyPage<>();
        myPage.setCurrent(offset);
        myPage.setSize(limit);
        if (order.equals("desc") == true) {
        	myPage.setDescs(Arrays.asList(sort.split(",")));
        } else {
        	myPage.setAscs(Arrays.asList(sort.split(",")));
        }

        MyEntityWrapper<${className}> myEntityWrapper = new MyEntityWrapper<>();
		MyPage<${className}> result = ${classNameLower}Service.selectPage(myPage, myEntityWrapper);
    	return new UpmsResult(UpmsResultConstant.SUCCESS, result);
    }

	@RequiresPermissions("upms:${tableNameAllLower}:read")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable("id") int ${tableNameAllLower}Id) {
		${className} result = ${classNameLower}Service.selectById(${tableNameAllLower}Id);
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

	@RequiresPermissions("upms:${tableNameAllLower}:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Object create(@RequestBody ${className} ${tableNameAllLower}) {
		int count = ${classNameLower}Service.insert(${tableNameAllLower});
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:${tableNameAllLower}:delete")
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		String[] idsArray = ids.split(",");
		List<String> idsList = Arrays.asList(idsArray);
		int count = ${classNameLower}Service.deleteBatchIds(idsList);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@RequiresPermissions("upms:${tableNameAllLower}:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object update(@PathVariable("id") int id, ${className} ${tableNameAllLower}) {
		${tableNameAllLower}.setId(id);
		int count = ${classNameLower}Service.updateById(${tableNameAllLower});
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}