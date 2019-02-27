package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsSystemRequest;
import com.qijia.upms.bo.po.UpmsSystemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsSystem;
import com.qijia.upms.dao.UpmsSystemDao;
import com.qijia.upms.service.UpmsSystemService;

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
public class UpmsSystemServiceImpl extends BaseServiceImpl<UpmsSystemDao,UpmsSystem> implements UpmsSystemService {

	@Autowired
	UpmsSystemDao upmsSystemDao;

	@Override
	public PageResponse<UpmsSystemResponse> queryByObject(UpmsSystemRequest upmsSystemRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsSystem upmsSystem = assembleUpmsSystem(upmsSystemRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsSystemRequest.getPageRequest());
		List<UpmsSystem> upmsSystemList = upmsSystemDao.queryByObject(upmsSystem);

//		转换model 为 response data
		List<UpmsSystemResponse> myList = new ArrayList<UpmsSystemResponse>();
		for (UpmsSystem item : upmsSystemList ) {
			myList.add(assembleUpmsSystem(item));
		}

		PageResponse<UpmsSystemResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsSystem 转换为 UpmsSystemResponse
	 * @param upmsSystem
	 * @return
	 */
	@Override
	public UpmsSystemResponse assembleUpmsSystem (UpmsSystem upmsSystem ){

		UpmsSystemResponse upmsSystemResponse = new UpmsSystemResponse();
		upmsSystemResponse.setId(upmsSystem.getId());
		upmsSystemResponse.setIcon(upmsSystem.getIcon());
		upmsSystemResponse.setBanner(upmsSystem.getBanner());
		upmsSystemResponse.setTheme(upmsSystem.getTheme());
		upmsSystemResponse.setBasepath(upmsSystem.getBasepath());
		upmsSystemResponse.setStatus(upmsSystem.getStatus());
		upmsSystemResponse.setName(upmsSystem.getName());
		upmsSystemResponse.setTitle(upmsSystem.getTitle());
		upmsSystemResponse.setDescription(upmsSystem.getDescription());
		upmsSystemResponse.setOrders(upmsSystem.getOrders());
		upmsSystemResponse.setCreateTime(upmsSystem.getCreateTime());
		upmsSystemResponse.setUpdateTime(upmsSystem.getUpdateTime());
		return upmsSystemResponse;
	}

	/**
	 * 客户端请求 UpmsSystemRequest 转换为 UpmsSystem
	 * @param upmsSystemRequest
	 * @return
	 */
	@Override
	public UpmsSystem assembleUpmsSystem (UpmsSystemRequest upmsSystemRequest ){
		UpmsSystem upmsSystem = new UpmsSystem();
		upmsSystem.setId(upmsSystemRequest.getId());
		upmsSystem.setIcon(upmsSystemRequest.getIcon());
		upmsSystem.setBanner(upmsSystemRequest.getBanner());
		upmsSystem.setTheme(upmsSystemRequest.getTheme());
		upmsSystem.setBasepath(upmsSystemRequest.getBasepath());
		upmsSystem.setStatus(upmsSystemRequest.getStatus());
		upmsSystem.setName(upmsSystemRequest.getName());
		upmsSystem.setTitle(upmsSystemRequest.getTitle());
		upmsSystem.setDescription(upmsSystemRequest.getDescription());
		upmsSystem.setOrders(upmsSystemRequest.getOrders());
		upmsSystem.setCreateTime(upmsSystemRequest.getCreateTime());
		upmsSystem.setUpdateTime(upmsSystemRequest.getUpdateTime());
		return upmsSystem;
	}
}
