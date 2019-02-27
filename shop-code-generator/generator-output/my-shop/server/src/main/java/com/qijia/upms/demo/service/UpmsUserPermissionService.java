package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsUserPermissionRequest;
import com.qijia.upms.bo.po.UpmsUserPermissionResponse;
import com.qijia.upms.model.UpmsUserPermission;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsUserPermissionService extends IBaseService<UpmsUserPermission> {
	PageResponse<UpmsUserPermissionResponse> queryByObject (UpmsUserPermissionRequest upmsUserPermissionRequest);

	UpmsUserPermissionResponse assembleUpmsUserPermission(UpmsUserPermission upmsUserPermission);

	UpmsUserPermission assembleUpmsUserPermission(UpmsUserPermissionRequest upmsUserPermissionRequest);
}