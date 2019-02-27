package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsRoleRequest;
import com.qijia.upms.bo.po.UpmsRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsRole;
import com.qijia.upms.dao.UpmsRoleDao;
import com.qijia.upms.service.UpmsRoleService;

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
public class UpmsRoleServiceImpl extends BaseServiceImpl<UpmsRoleDao,UpmsRole> implements UpmsRoleService {

	@Autowired
	UpmsRoleDao upmsRoleDao;

	@Override
	public PageResponse<UpmsRoleResponse> queryByObject(UpmsRoleRequest upmsRoleRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsRole upmsRole = assembleUpmsRole(upmsRoleRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsRoleRequest.getPageRequest());
		List<UpmsRole> upmsRoleList = upmsRoleDao.queryByObject(upmsRole);

//		转换model 为 response data
		List<UpmsRoleResponse> myList = new ArrayList<UpmsRoleResponse>();
		for (UpmsRole item : upmsRoleList ) {
			myList.add(assembleUpmsRole(item));
		}

		PageResponse<UpmsRoleResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsRole 转换为 UpmsRoleResponse
	 * @param upmsRole
	 * @return
	 */
	@Override
	public UpmsRoleResponse assembleUpmsRole (UpmsRole upmsRole ){

		UpmsRoleResponse upmsRoleResponse = new UpmsRoleResponse();
		upmsRoleResponse.setId(upmsRole.getId());
		upmsRoleResponse.setName(upmsRole.getName());
		upmsRoleResponse.setTitle(upmsRole.getTitle());
		upmsRoleResponse.setDescription(upmsRole.getDescription());
		upmsRoleResponse.setOrders(upmsRole.getOrders());
		upmsRoleResponse.setCreateTime(upmsRole.getCreateTime());
		upmsRoleResponse.setUpdateTime(upmsRole.getUpdateTime());
		return upmsRoleResponse;
	}

	/**
	 * 客户端请求 UpmsRoleRequest 转换为 UpmsRole
	 * @param upmsRoleRequest
	 * @return
	 */
	@Override
	public UpmsRole assembleUpmsRole (UpmsRoleRequest upmsRoleRequest ){
		UpmsRole upmsRole = new UpmsRole();
		upmsRole.setId(upmsRoleRequest.getId());
		upmsRole.setName(upmsRoleRequest.getName());
		upmsRole.setTitle(upmsRoleRequest.getTitle());
		upmsRole.setDescription(upmsRoleRequest.getDescription());
		upmsRole.setOrders(upmsRoleRequest.getOrders());
		upmsRole.setCreateTime(upmsRoleRequest.getCreateTime());
		upmsRole.setUpdateTime(upmsRoleRequest.getUpdateTime());
		return upmsRole;
	}
}
