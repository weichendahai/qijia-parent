package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsRoleRequest;
import com.qijia.upms.bo.po.UpmsRoleResponse;
import com.qijia.upms.model.UpmsRole;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsRoleService extends IBaseService<UpmsRole> {
	PageResponse<UpmsRoleResponse> queryByObject (UpmsRoleRequest upmsRoleRequest);

	UpmsRoleResponse assembleUpmsRole(UpmsRole upmsRole);

	UpmsRole assembleUpmsRole(UpmsRoleRequest upmsRoleRequest);
}