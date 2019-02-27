package com.qijia.upms.service;

import com.srsj.common.bo.PageResponse;
import com.srsj.common.service.IBaseService;
import com.qijia.upms.bo.vo.UpmsLogRequest;
import com.qijia.upms.bo.po.UpmsLogResponse;
import com.qijia.upms.model.UpmsLog;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


public interface UpmsLogService extends IBaseService<UpmsLog> {
	PageResponse<UpmsLogResponse> queryByObject (UpmsLogRequest upmsLogRequest);

	UpmsLogResponse assembleUpmsLog(UpmsLog upmsLog);

	UpmsLog assembleUpmsLog(UpmsLogRequest upmsLogRequest);
}