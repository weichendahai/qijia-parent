/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.qijia.upms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
 *
 * @author weichen
 * @version 1.0
 * @since 1.0
 *

 */
@Service
@Transactional
public class UpmsPermissionManagerImpl implements UpmsPermissionManager {

	private UpmsPermissionDao upmsPermissionDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUpmsPermissionDao(UpmsPermissionDao dao) {
		this.upmsPermissionDao = dao;
	}
	
	/** 
	 * 创建UpmsPermission
	 **/
	public UpmsPermission save(UpmsPermission upmsPermission) {
	    Assert.notNull(upmsPermission,"'upmsPermission' must be not null");
	    initDefaultValuesForCreate(upmsPermission);
	    new UpmsPermissionChecker().checkCreateUpmsPermission(upmsPermission);
	    this.upmsPermissionDao.save(upmsPermission);
	    return upmsPermission;
	}
	
	/** 
	 * 更新UpmsPermission
	 **/	
    public UpmsPermission update(UpmsPermission upmsPermission) {
        Assert.notNull(upmsPermission,"'upmsPermission' must be not null");
        new UpmsPermissionChecker().checkUpdateUpmsPermission(upmsPermission);
        this.upmsPermissionDao.update(upmsPermission);
        return upmsPermission;
    }	
    
	/** 
	 * 删除UpmsPermission
	 **/
    public void removeById(Integer id) {
        this.upmsPermissionDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到UpmsPermission
	 **/    
    public UpmsPermission getById(Integer id) {
        return this.upmsPermissionDao.getById(id);
    }
    
	/** 
	 * 分页查询: UpmsPermission
	 **/      
	@Transactional(readOnly=true)
	public Page findPage(UpmsPermissionQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return upmsPermissionDao.findPage(query);
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UpmsPermission v) {
    }
    
    /**
     * UpmsPermission的属性检查类,根据自己需要编写自定义检查
     **/
    public class UpmsPermissionChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUpmsPermission(UpmsPermission v) {
            checkUpmsPermission(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUpmsPermission(UpmsPermission v) {
            checkUpmsPermission(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUpmsPermission(UpmsPermission v) {
        	// Bean Validator检查,属性检查失败将抛异常
        	validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
