package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsUserRequest;
import com.qijia.upms.bo.po.UpmsUserResponse;
import com.qijia.upms.model.UpmsUser;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsUserService extends IBaseService<UpmsUser> {
	PageResponse<UpmsUserResponse> queryByObject (UpmsUserRequest upmsUserRequest);

	UpmsUserResponse assembleUpmsUser(UpmsUser upmsUser);

	UpmsUser assembleUpmsUser(UpmsUserRequest upmsUserRequest);
}