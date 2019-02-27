package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsLogRequest;
import com.qijia.upms.bo.po.UpmsLogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsLog;
import com.qijia.upms.dao.UpmsLogDao;
import com.qijia.upms.service.UpmsLogService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Service
public class UpmsLogServiceImpl extends BaseServiceImpl<UpmsLogDao,UpmsLog> implements UpmsLogService {

	@Autowired
	UpmsLogDao upmsLogDao;

	@Override
	public PageResponse<UpmsLogResponse> queryByObject(UpmsLogRequest upmsLogRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsLog upmsLog = assembleUpmsLog(upmsLogRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsLogRequest.getPageRequest());
		List<UpmsLog> upmsLogList = upmsLogDao.queryByObject(upmsLog);

//		转换model 为 response data
		List<UpmsLogResponse> myList = new ArrayList<UpmsLogResponse>();
		for (UpmsLog item : upmsLogList ) {
			myList.add(assembleUpmsLog(item));
		}

		PageResponse<UpmsLogResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsLog 转换为 UpmsLogResponse
	 * @param upmsLog
	 * @return
	 */
	@Override
	public UpmsLogResponse assembleUpmsLog (UpmsLog upmsLog ){

		UpmsLogResponse upmsLogResponse = new UpmsLogResponse();
		upmsLogResponse.setId(upmsLog.getId());
		upmsLogResponse.setDescription(upmsLog.getDescription());
		upmsLogResponse.setUsername(upmsLog.getUsername());
		upmsLogResponse.setStartTime(upmsLog.getStartTime());
		upmsLogResponse.setSpendTime(upmsLog.getSpendTime());
		upmsLogResponse.setBasePath(upmsLog.getBasePath());
		upmsLogResponse.setUri(upmsLog.getUri());
		upmsLogResponse.setUrl(upmsLog.getUrl());
		upmsLogResponse.setMethod(upmsLog.getMethod());
		upmsLogResponse.setParameter(upmsLog.getParameter());
		upmsLogResponse.setUserAgent(upmsLog.getUserAgent());
		upmsLogResponse.setIp(upmsLog.getIp());
		upmsLogResponse.setResult(upmsLog.getResult());
		upmsLogResponse.setPermissions(upmsLog.getPermissions());
		upmsLogResponse.setCreateTime(upmsLog.getCreateTime());
		upmsLogResponse.setUpdateTime(upmsLog.getUpdateTime());
		return upmsLogResponse;
	}

	/**
	 * 客户端请求 UpmsLogRequest 转换为 UpmsLog
	 * @param upmsLogRequest
	 * @return
	 */
	@Override
	public UpmsLog assembleUpmsLog (UpmsLogRequest upmsLogRequest ){
		UpmsLog upmsLog = new UpmsLog();
		upmsLog.setId(upmsLogRequest.getId());
		upmsLog.setDescription(upmsLogRequest.getDescription());
		upmsLog.setUsername(upmsLogRequest.getUsername());
		upmsLog.setStartTime(upmsLogRequest.getStartTime());
		upmsLog.setSpendTime(upmsLogRequest.getSpendTime());
		upmsLog.setBasePath(upmsLogRequest.getBasePath());
		upmsLog.setUri(upmsLogRequest.getUri());
		upmsLog.setUrl(upmsLogRequest.getUrl());
		upmsLog.setMethod(upmsLogRequest.getMethod());
		upmsLog.setParameter(upmsLogRequest.getParameter());
		upmsLog.setUserAgent(upmsLogRequest.getUserAgent());
		upmsLog.setIp(upmsLogRequest.getIp());
		upmsLog.setResult(upmsLogRequest.getResult());
		upmsLog.setPermissions(upmsLogRequest.getPermissions());
		upmsLog.setCreateTime(upmsLogRequest.getCreateTime());
		upmsLog.setUpdateTime(upmsLogRequest.getUpdateTime());
		return upmsLog;
	}
}
