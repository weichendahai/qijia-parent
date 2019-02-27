/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.qijia.upms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UpmsUserRoleManager extends BaseManager<UpmsUserRole,Integer>{

	private UpmsUserRoleDao upmsUserRoleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUpmsUserRoleDao(UpmsUserRoleDao dao) {
		this.upmsUserRoleDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.upmsUserRoleDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(UpmsUserRoleQuery query) {
		return upmsUserRoleDao.findPage(query);
	}
	
}
