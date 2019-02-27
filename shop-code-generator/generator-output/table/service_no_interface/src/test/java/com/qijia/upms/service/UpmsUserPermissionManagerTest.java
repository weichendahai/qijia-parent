/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.qijia.upms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

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
public class UpmsUserPermissionManagerTest extends BaseManagerTestCase{

	private UpmsUserPermissionManager manager;
	
	@Autowired
	public void setUpmsUserPermissionManager(UpmsUserPermissionManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/UpmsUserPermission.xml",
                            "classpath:testdata/UpmsUserPermission_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		UpmsUserPermission obj = newUpmsUserPermission();
		manager.save(obj);
		//manager.getEntityDao().flush(); //flush for hibernate
		
		manager.update(obj);
		//manager.getEntityDao().flush(); //flush for hibernate
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		//manager.getEntityDao().flush(); //flush for hibernate
	
	}
	
	public static UpmsUserPermission newUpmsUserPermission() {
		UpmsUserPermission obj = new UpmsUserPermission();
		
	  	obj.setUserId(new Integer("1"));
	  	obj.setPermissionId(new Integer("1"));
	  	obj.setType(new Integer("1"));
	  	obj.setCreateTime(new Long("1"));
	  	obj.setUpdateTime(new Long("1"));
		return obj;
	}
}
