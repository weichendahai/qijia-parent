package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsOrganizationRequest;
import com.qijia.upms.bo.po.UpmsOrganizationResponse;
import com.qijia.upms.model.UpmsOrganization;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsOrganizationService extends IBaseService<UpmsOrganization> {
	PageResponse<UpmsOrganizationResponse> queryByObject (UpmsOrganizationRequest upmsOrganizationRequest);

	UpmsOrganizationResponse assembleUpmsOrganization(UpmsOrganization upmsOrganization);

	UpmsOrganization assembleUpmsOrganization(UpmsOrganizationRequest upmsOrganizationRequest);
}