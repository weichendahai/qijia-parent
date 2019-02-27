package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsSystemRequest;
import com.qijia.upms.bo.po.UpmsSystemResponse;
import com.qijia.upms.model.UpmsSystem;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsSystemService extends IBaseService<UpmsSystem> {
	PageResponse<UpmsSystemResponse> queryByObject (UpmsSystemRequest upmsSystemRequest);

	UpmsSystemResponse assembleUpmsSystem(UpmsSystem upmsSystem);

	UpmsSystem assembleUpmsSystem(UpmsSystemRequest upmsSystemRequest);
}