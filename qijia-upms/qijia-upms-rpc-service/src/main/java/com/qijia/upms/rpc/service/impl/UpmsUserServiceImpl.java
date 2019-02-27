
package com.qijia.upms.rpc.service.impl;

import com.qijia.framework.dao.MyEntityWrapper;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qijia.framework.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsUser;
import com.qijia.upms.dao.UpmsUserDao;
import com.qijia.upms.rpc.api.UpmsUserService;


/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Service
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserDao,UpmsUser> implements UpmsUserService {

	@Autowired
	UpmsUserDao upmsUserDao;

	@Override
	public UpmsUser selectUpmsUserByUsername(String userName) {
		UpmsUser upmsUser = new UpmsUser();
		upmsUser.setUsername(userName);
		UpmsUser result = upmsUserDao.selectOne(upmsUser);
		return result;
	}
}
