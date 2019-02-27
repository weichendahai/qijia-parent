package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsUserRoleRequest;
import com.qijia.upms.bo.po.UpmsUserRoleResponse;
import com.qijia.upms.model.UpmsUserRole;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsUserRoleService extends IBaseService<UpmsUserRole> {
	PageResponse<UpmsUserRoleResponse> queryByObject (UpmsUserRoleRequest upmsUserRoleRequest);

	UpmsUserRoleResponse assembleUpmsUserRole(UpmsUserRole upmsUserRole);

	UpmsUserRole assembleUpmsUserRole(UpmsUserRoleRequest upmsUserRoleRequest);
}