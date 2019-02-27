package com.qijia.shop.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weichen on 2018/10/10.
 */
@Controller
@RequestMapping("/api/v1/manage/product")
public class ShopProductController {

//	此接口模拟需要选线校验
//	@RequiresPermissions("shop:product:read")
	@RequiresPermissions("cms:topic:read")
	@RequestMapping(value = "index", method = RequestMethod.GET)
	@ResponseBody
	public Object index () {
		Map<String,String> productList = new HashMap<>();
		productList.put("iphone 8", "苹果手机8手机");
		productList.put("meta 10", "华为Met10 手机");
		return productList;
	}

//	此接口模拟不需要权限校验
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public Object list () {
		Map<String,String> productList = new HashMap<>();
		productList.put("iphone 6", "苹果手机 6手机");
		productList.put("meta 6", "华为Met6 手机");
		return productList;
	}
}
