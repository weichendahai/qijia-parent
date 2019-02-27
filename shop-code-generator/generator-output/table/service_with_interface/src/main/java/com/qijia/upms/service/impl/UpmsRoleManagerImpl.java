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
public class UpmsRoleManagerImpl implements UpmsRoleManager {

	private UpmsRoleDao upmsRoleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUpmsRoleDao(UpmsRoleDao dao) {
		this.upmsRoleDao = dao;
	}
	
	/** 
	 * 创建UpmsRole
	 **/
	public UpmsRole save(UpmsRole upmsRole) {
	    Assert.notNull(upmsRole,"'upmsRole' must be not null");
	    initDefaultValuesForCreate(upmsRole);
	    new UpmsRoleChecker().checkCreateUpmsRole(upmsRole);
	    this.upmsRoleDao.save(upmsRole);
	    return upmsRole;
	}
	
	/** 
	 * 更新UpmsRole
	 **/	
    public UpmsRole update(UpmsRole upmsRole) {
        Assert.notNull(upmsRole,"'upmsRole' must be not null");
        new UpmsRoleChecker().checkUpdateUpmsRole(upmsRole);
        this.upmsRoleDao.update(upmsRole);
        return upmsRole;
    }	
    
	/** 
	 * 删除UpmsRole
	 **/
    public void removeById(Integer id) {
        this.upmsRoleDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到UpmsRole
	 **/    
    public UpmsRole getById(Integer id) {
        return this.upmsRoleDao.getById(id);
    }
    
	/** 
	 * 分页查询: UpmsRole
	 **/      
	@Transactional(readOnly=true)
	public Page findPage(UpmsRoleQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return upmsRoleDao.findPage(query);
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UpmsRole v) {
    }
    
    /**
     * UpmsRole的属性检查类,根据自己需要编写自定义检查
     **/
    public class UpmsRoleChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUpmsRole(UpmsRole v) {
            checkUpmsRole(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUpmsRole(UpmsRole v) {
            checkUpmsRole(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUpmsRole(UpmsRole v) {
        	// Bean Validator检查,属性检查失败将抛异常
        	validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
