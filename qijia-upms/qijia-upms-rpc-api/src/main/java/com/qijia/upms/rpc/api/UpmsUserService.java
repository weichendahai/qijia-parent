
package com.qijia.upms.rpc.api;

import com.qijia.framework.service.IBaseService;
import com.qijia.upms.model.UpmsUser;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsUserService extends IBaseService<UpmsUser> {
	UpmsUser selectUpmsUserByUsername(String userName);
}