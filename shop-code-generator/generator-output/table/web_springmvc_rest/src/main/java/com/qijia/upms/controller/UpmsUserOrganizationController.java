/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


package com.qijia.upms.controller;

import java.util.Map;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;

import java.io.*;
import java.net.*;
import java.util.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.qijia.upms.model.*;
import com.qijia.upms.dao.*;
import com.qijia.upms.service.*;
import com.qijia.upms.query.*;


/**
 * 标准的rest方法列表
 * <pre>
 * /upmsuserorganization                => index()  
 * /upmsuserorganization/new            => _new()  注意: 不使用/userinfo/add => add()的原因是ad会被一些浏览器当做广告URL拦截
 * /upmsuserorganization/{id}           => show()  
 * /upmsuserorganization/{id}/edit      => edit()  
 * /upmsuserorganization        POST    => create()  
 * /upmsuserorganization/{id}   PUT     => update()  
 * /upmsuserorganization/{id}   DELETE  => delete()  
 * /upmsuserorganization        DELETE  => batchDelete()  
 * </pre>
 *
 * @author weichen
 * @version 1.0
 * @since 1.0
 *

 *
 */
@Controller
@RequestMapping("/upmsuserorganization")
public class UpmsUserOrganizationController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private UpmsUserOrganizationManager upmsUserOrganizationManager;
	
	private final String LIST_ACTION = "redirect:/upmsuserorganization";
	
	/** 
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
	 **/
	public void setUpmsUserOrganizationManager(UpmsUserOrganizationManager manager) {
		this.upmsUserOrganizationManager = manager;
	}
	
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,UpmsUserOrganizationQuery query,HttpServletRequest request) {
		Page page = this.upmsUserOrganizationManager.findPage(query);
		
		model.addAllAttributes(toModelMap(page, query));
		return "/upmsuserorganization/index";
	}
	
	/** 显示 */
	@RequestMapping(value="/{id}")
	public String show(ModelMap model,@PathVariable Integer id) throws Exception {
		UpmsUserOrganization upmsUserOrganization = (UpmsUserOrganization)upmsUserOrganizationManager.getById(id);
		model.addAttribute("upmsUserOrganization",upmsUserOrganization);
		return "/upmsuserorganization/show";
	}

	/** 进入新增 */
	@RequestMapping(value="/new")
	public String _new(ModelMap model,UpmsUserOrganization upmsUserOrganization) throws Exception {
		model.addAttribute("upmsUserOrganization",upmsUserOrganization);
		return "/upmsuserorganization/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(method=RequestMethod.POST)
	public String create(ModelMap model,UpmsUserOrganization upmsUserOrganization,BindingResult errors) throws Exception {
		try {
			upmsUserOrganizationManager.save(upmsUserOrganization);
		}catch(ConstraintViolationException e) {
			convert(e, errors);
			return  "/upmsuserorganization/new";
		}catch(ValidationException e) {
			Flash.current().error(e.getMessage());
			return  "/upmsuserorganization/new";
		}
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable Integer id) throws Exception {
		UpmsUserOrganization upmsUserOrganization = (UpmsUserOrganization)upmsUserOrganizationManager.getById(id);
		model.addAttribute("upmsUserOrganization",upmsUserOrganization);
		return "/upmsuserorganization/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(ModelMap model,@PathVariable Integer id,UpmsUserOrganization upmsUserOrganization,BindingResult errors) throws Exception {
		try {
			upmsUserOrganizationManager.update(upmsUserOrganization);
		}catch(ConstraintViolationException e) {
			convert(e, errors);
			return  "/upmsuserorganization/edit";
		}catch(ValidationException e) {
			Flash.current().error(e.getMessage());
			return  "/upmsuserorganization/edit";
		}
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	
	/** 删除 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable Integer id) {
		upmsUserOrganizationManager.removeById(id);
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}

	/** 批量删除 */
	@RequestMapping(method=RequestMethod.DELETE)
	public String batchDelete(ModelMap model,@RequestParam("items") Integer[] items) {
		for(int i = 0; i < items.length; i++) {
			upmsUserOrganizationManager.removeById(items[i]);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	
}

