package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsPermissionRequest;
import com.qijia.upms.bo.po.UpmsPermissionResponse;
import com.qijia.upms.model.UpmsPermission;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsPermissionService extends IBaseService<UpmsPermission> {
	PageResponse<UpmsPermissionResponse> queryByObject (UpmsPermissionRequest upmsPermissionRequest);

	UpmsPermissionResponse assembleUpmsPermission(UpmsPermission upmsPermission);

	UpmsPermission assembleUpmsPermission(UpmsPermissionRequest upmsPermissionRequest);
}