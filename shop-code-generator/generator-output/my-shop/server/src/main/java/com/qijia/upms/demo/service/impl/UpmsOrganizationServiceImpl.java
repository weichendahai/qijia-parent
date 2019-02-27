package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsOrganizationRequest;
import com.qijia.upms.bo.po.UpmsOrganizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsOrganization;
import com.qijia.upms.dao.UpmsOrganizationDao;
import com.qijia.upms.service.UpmsOrganizationService;

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
public class UpmsOrganizationServiceImpl extends BaseServiceImpl<UpmsOrganizationDao,UpmsOrganization> implements UpmsOrganizationService {

	@Autowired
	UpmsOrganizationDao upmsOrganizationDao;

	@Override
	public PageResponse<UpmsOrganizationResponse> queryByObject(UpmsOrganizationRequest upmsOrganizationRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsOrganization upmsOrganization = assembleUpmsOrganization(upmsOrganizationRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsOrganizationRequest.getPageRequest());
		List<UpmsOrganization> upmsOrganizationList = upmsOrganizationDao.queryByObject(upmsOrganization);

//		转换model 为 response data
		List<UpmsOrganizationResponse> myList = new ArrayList<UpmsOrganizationResponse>();
		for (UpmsOrganization item : upmsOrganizationList ) {
			myList.add(assembleUpmsOrganization(item));
		}

		PageResponse<UpmsOrganizationResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsOrganization 转换为 UpmsOrganizationResponse
	 * @param upmsOrganization
	 * @return
	 */
	@Override
	public UpmsOrganizationResponse assembleUpmsOrganization (UpmsOrganization upmsOrganization ){

		UpmsOrganizationResponse upmsOrganizationResponse = new UpmsOrganizationResponse();
		upmsOrganizationResponse.setId(upmsOrganization.getId());
		upmsOrganizationResponse.setPid(upmsOrganization.getPid());
		upmsOrganizationResponse.setName(upmsOrganization.getName());
		upmsOrganizationResponse.setDescription(upmsOrganization.getDescription());
		upmsOrganizationResponse.setCreateTime(upmsOrganization.getCreateTime());
		upmsOrganizationResponse.setUpdateTime(upmsOrganization.getUpdateTime());
		return upmsOrganizationResponse;
	}

	/**
	 * 客户端请求 UpmsOrganizationRequest 转换为 UpmsOrganization
	 * @param upmsOrganizationRequest
	 * @return
	 */
	@Override
	public UpmsOrganization assembleUpmsOrganization (UpmsOrganizationRequest upmsOrganizationRequest ){
		UpmsOrganization upmsOrganization = new UpmsOrganization();
		upmsOrganization.setId(upmsOrganizationRequest.getId());
		upmsOrganization.setPid(upmsOrganizationRequest.getPid());
		upmsOrganization.setName(upmsOrganizationRequest.getName());
		upmsOrganization.setDescription(upmsOrganizationRequest.getDescription());
		upmsOrganization.setCreateTime(upmsOrganizationRequest.getCreateTime());
		upmsOrganization.setUpdateTime(upmsOrganizationRequest.getUpdateTime());
		return upmsOrganization;
	}
}
