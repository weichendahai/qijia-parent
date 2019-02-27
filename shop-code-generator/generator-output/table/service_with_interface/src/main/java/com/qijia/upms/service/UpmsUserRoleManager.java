/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package com.qijia.upms.service;

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
public interface UpmsUserRoleManager {

	/** 
	 * 创建UpmsUserRole
	 **/
	public UpmsUserRole save(UpmsUserRole upmsUserRole);
	
	/** 
	 * 更新UpmsUserRole
	 **/	
    public UpmsUserRole update(UpmsUserRole upmsUserRole);
    
	/** 
	 * 删除UpmsUserRole
	 **/
    public void removeById(Integer id);
    
	/** 
	 * 根据ID得到UpmsUserRole
	 **/    
    public UpmsUserRole getById(Integer id);
    
	/** 
	 * 分页查询: UpmsUserRole
	 **/      
	public Page findPage(UpmsUserRoleQuery query);
	
    
}
