package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsUserOrganizationRequest;
import com.qijia.upms.bo.po.UpmsUserOrganizationResponse;
import com.qijia.upms.model.UpmsUserOrganization;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsUserOrganizationService extends IBaseService<UpmsUserOrganization> {
	PageResponse<UpmsUserOrganizationResponse> queryByObject (UpmsUserOrganizationRequest upmsUserOrganizationRequest);

	UpmsUserOrganizationResponse assembleUpmsUserOrganization(UpmsUserOrganization upmsUserOrganization);

	UpmsUserOrganization assembleUpmsUserOrganization(UpmsUserOrganizationRequest upmsUserOrganizationRequest);
}