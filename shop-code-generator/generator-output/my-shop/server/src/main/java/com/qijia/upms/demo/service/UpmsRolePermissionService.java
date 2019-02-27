package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsRolePermissionRequest;
import com.qijia.upms.bo.po.UpmsRolePermissionResponse;
import com.qijia.upms.model.UpmsRolePermission;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsRolePermissionService extends IBaseService<UpmsRolePermission> {
	PageResponse<UpmsRolePermissionResponse> queryByObject (UpmsRolePermissionRequest upmsRolePermissionRequest);

	UpmsRolePermissionResponse assembleUpmsRolePermission(UpmsRolePermission upmsRolePermission);

	UpmsRolePermission assembleUpmsRolePermission(UpmsRolePermissionRequest upmsRolePermissionRequest);
}