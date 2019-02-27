package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsUserRoleRequest;
import com.qijia.upms.bo.po.UpmsUserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsUserRole;
import com.qijia.upms.dao.UpmsUserRoleDao;
import com.qijia.upms.service.UpmsUserRoleService;

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
public class UpmsUserRoleServiceImpl extends BaseServiceImpl<UpmsUserRoleDao,UpmsUserRole> implements UpmsUserRoleService {

	@Autowired
	UpmsUserRoleDao upmsUserRoleDao;

	@Override
	public PageResponse<UpmsUserRoleResponse> queryByObject(UpmsUserRoleRequest upmsUserRoleRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsUserRole upmsUserRole = assembleUpmsUserRole(upmsUserRoleRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsUserRoleRequest.getPageRequest());
		List<UpmsUserRole> upmsUserRoleList = upmsUserRoleDao.queryByObject(upmsUserRole);

//		转换model 为 response data
		List<UpmsUserRoleResponse> myList = new ArrayList<UpmsUserRoleResponse>();
		for (UpmsUserRole item : upmsUserRoleList ) {
			myList.add(assembleUpmsUserRole(item));
		}

		PageResponse<UpmsUserRoleResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsUserRole 转换为 UpmsUserRoleResponse
	 * @param upmsUserRole
	 * @return
	 */
	@Override
	public UpmsUserRoleResponse assembleUpmsUserRole (UpmsUserRole upmsUserRole ){

		UpmsUserRoleResponse upmsUserRoleResponse = new UpmsUserRoleResponse();
		upmsUserRoleResponse.setId(upmsUserRole.getId());
		upmsUserRoleResponse.setUserId(upmsUserRole.getUserId());
		upmsUserRoleResponse.setRoleId(upmsUserRole.getRoleId());
		upmsUserRoleResponse.setCreateTime(upmsUserRole.getCreateTime());
		upmsUserRoleResponse.setUpdateTime(upmsUserRole.getUpdateTime());
		return upmsUserRoleResponse;
	}

	/**
	 * 客户端请求 UpmsUserRoleRequest 转换为 UpmsUserRole
	 * @param upmsUserRoleRequest
	 * @return
	 */
	@Override
	public UpmsUserRole assembleUpmsUserRole (UpmsUserRoleRequest upmsUserRoleRequest ){
		UpmsUserRole upmsUserRole = new UpmsUserRole();
		upmsUserRole.setId(upmsUserRoleRequest.getId());
		upmsUserRole.setUserId(upmsUserRoleRequest.getUserId());
		upmsUserRole.setRoleId(upmsUserRoleRequest.getRoleId());
		upmsUserRole.setCreateTime(upmsUserRoleRequest.getCreateTime());
		upmsUserRole.setUpdateTime(upmsUserRoleRequest.getUpdateTime());
		return upmsUserRole;
	}
}
