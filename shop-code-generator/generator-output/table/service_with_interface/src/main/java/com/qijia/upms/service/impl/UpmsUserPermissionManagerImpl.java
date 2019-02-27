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
public class UpmsUserPermissionManagerImpl implements UpmsUserPermissionManager {

	private UpmsUserPermissionDao upmsUserPermissionDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUpmsUserPermissionDao(UpmsUserPermissionDao dao) {
		this.upmsUserPermissionDao = dao;
	}
	
	/** 
	 * 创建UpmsUserPermission
	 **/
	public UpmsUserPermission save(UpmsUserPermission upmsUserPermission) {
	    Assert.notNull(upmsUserPermission,"'upmsUserPermission' must be not null");
	    initDefaultValuesForCreate(upmsUserPermission);
	    new UpmsUserPermissionChecker().checkCreateUpmsUserPermission(upmsUserPermission);
	    this.upmsUserPermissionDao.save(upmsUserPermission);
	    return upmsUserPermission;
	}
	
	/** 
	 * 更新UpmsUserPermission
	 **/	
    public UpmsUserPermission update(UpmsUserPermission upmsUserPermission) {
        Assert.notNull(upmsUserPermission,"'upmsUserPermission' must be not null");
        new UpmsUserPermissionChecker().checkUpdateUpmsUserPermission(upmsUserPermission);
        this.upmsUserPermissionDao.update(upmsUserPermission);
        return upmsUserPermission;
    }	
    
	/** 
	 * 删除UpmsUserPermission
	 **/
    public void removeById(Integer id) {
        this.upmsUserPermissionDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到UpmsUserPermission
	 **/    
    public UpmsUserPermission getById(Integer id) {
        return this.upmsUserPermissionDao.getById(id);
    }
    
	/** 
	 * 分页查询: UpmsUserPermission
	 **/      
	@Transactional(readOnly=true)
	public Page findPage(UpmsUserPermissionQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return upmsUserPermissionDao.findPage(query);
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UpmsUserPermission v) {
    }
    
    /**
     * UpmsUserPermission的属性检查类,根据自己需要编写自定义检查
     **/
    public class UpmsUserPermissionChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUpmsUserPermission(UpmsUserPermission v) {
            checkUpmsUserPermission(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUpmsUserPermission(UpmsUserPermission v) {
            checkUpmsUserPermission(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUpmsUserPermission(UpmsUserPermission v) {
        	// Bean Validator检查,属性检查失败将抛异常
        	validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
