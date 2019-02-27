
package com.qijia.upms.dao;

import org.springframework.stereotype.Repository;
import com.qijia.framework.dao.IBaseDao;
import com.qijia.upms.model.UpmsUser;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Repository(value = "upmsUser")
public interface UpmsUserDao extends IBaseDao<UpmsUser> {
}