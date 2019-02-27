package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsUserOrganizationRequest;
import com.qijia.upms.bo.po.UpmsUserOrganizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsUserOrganization;
import com.qijia.upms.dao.UpmsUserOrganizationDao;
import com.qijia.upms.service.UpmsUserOrganizationService;

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
public class UpmsUserOrganizationServiceImpl extends BaseServiceImpl<UpmsUserOrganizationDao,UpmsUserOrganization> implements UpmsUserOrganizationService {

	@Autowired
	UpmsUserOrganizationDao upmsUserOrganizationDao;

	@Override
	public PageResponse<UpmsUserOrganizationResponse> queryByObject(UpmsUserOrganizationRequest upmsUserOrganizationRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsUserOrganization upmsUserOrganization = assembleUpmsUserOrganization(upmsUserOrganizationRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsUserOrganizationRequest.getPageRequest());
		List<UpmsUserOrganization> upmsUserOrganizationList = upmsUserOrganizationDao.queryByObject(upmsUserOrganization);

//		转换model 为 response data
		List<UpmsUserOrganizationResponse> myList = new ArrayList<UpmsUserOrganizationResponse>();
		for (UpmsUserOrganization item : upmsUserOrganizationList ) {
			myList.add(assembleUpmsUserOrganization(item));
		}

		PageResponse<UpmsUserOrganizationResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsUserOrganization 转换为 UpmsUserOrganizationResponse
	 * @param upmsUserOrganization
	 * @return
	 */
	@Override
	public UpmsUserOrganizationResponse assembleUpmsUserOrganization (UpmsUserOrganization upmsUserOrganization ){

		UpmsUserOrganizationResponse upmsUserOrganizationResponse = new UpmsUserOrganizationResponse();
		upmsUserOrganizationResponse.setId(upmsUserOrganization.getId());
		upmsUserOrganizationResponse.setUserId(upmsUserOrganization.getUserId());
		upmsUserOrganizationResponse.setOrganizationId(upmsUserOrganization.getOrganizationId());
		upmsUserOrganizationResponse.setCreateTime(upmsUserOrganization.getCreateTime());
		upmsUserOrganizationResponse.setUpdateTime(upmsUserOrganization.getUpdateTime());
		return upmsUserOrganizationResponse;
	}

	/**
	 * 客户端请求 UpmsUserOrganizationRequest 转换为 UpmsUserOrganization
	 * @param upmsUserOrganizationRequest
	 * @return
	 */
	@Override
	public UpmsUserOrganization assembleUpmsUserOrganization (UpmsUserOrganizationRequest upmsUserOrganizationRequest ){
		UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
		upmsUserOrganization.setId(upmsUserOrganizationRequest.getId());
		upmsUserOrganization.setUserId(upmsUserOrganizationRequest.getUserId());
		upmsUserOrganization.setOrganizationId(upmsUserOrganizationRequest.getOrganizationId());
		upmsUserOrganization.setCreateTime(upmsUserOrganizationRequest.getCreateTime());
		upmsUserOrganization.setUpdateTime(upmsUserOrganizationRequest.getUpdateTime());
		return upmsUserOrganization;
	}
}
