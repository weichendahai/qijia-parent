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
public interface UpmsRoleManager {

	/** 
	 * 创建UpmsRole
	 **/
	public UpmsRole save(UpmsRole upmsRole);
	
	/** 
	 * 更新UpmsRole
	 **/	
    public UpmsRole update(UpmsRole upmsRole);
    
	/** 
	 * 删除UpmsRole
	 **/
    public void removeById(Integer id);
    
	/** 
	 * 根据ID得到UpmsRole
	 **/    
    public UpmsRole getById(Integer id);
    
	/** 
	 * 分页查询: UpmsRole
	 **/      
	public Page findPage(UpmsRoleQuery query);
	
    
}
