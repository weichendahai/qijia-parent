package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsRolePermissionRequest;
import com.qijia.upms.bo.po.UpmsRolePermissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsRolePermission;
import com.qijia.upms.dao.UpmsRolePermissionDao;
import com.qijia.upms.service.UpmsRolePermissionService;

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
public class UpmsRolePermissionServiceImpl extends BaseServiceImpl<UpmsRolePermissionDao,UpmsRolePermission> implements UpmsRolePermissionService {

	@Autowired
	UpmsRolePermissionDao upmsRolePermissionDao;

	@Override
	public PageResponse<UpmsRolePermissionResponse> queryByObject(UpmsRolePermissionRequest upmsRolePermissionRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsRolePermission upmsRolePermission = assembleUpmsRolePermission(upmsRolePermissionRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsRolePermissionRequest.getPageRequest());
		List<UpmsRolePermission> upmsRolePermissionList = upmsRolePermissionDao.queryByObject(upmsRolePermission);

//		转换model 为 response data
		List<UpmsRolePermissionResponse> myList = new ArrayList<UpmsRolePermissionResponse>();
		for (UpmsRolePermission item : upmsRolePermissionList ) {
			myList.add(assembleUpmsRolePermission(item));
		}

		PageResponse<UpmsRolePermissionResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsRolePermission 转换为 UpmsRolePermissionResponse
	 * @param upmsRolePermission
	 * @return
	 */
	@Override
	public UpmsRolePermissionResponse assembleUpmsRolePermission (UpmsRolePermission upmsRolePermission ){

		UpmsRolePermissionResponse upmsRolePermissionResponse = new UpmsRolePermissionResponse();
		upmsRolePermissionResponse.setId(upmsRolePermission.getId());
		upmsRolePermissionResponse.setRoleId(upmsRolePermission.getRoleId());
		upmsRolePermissionResponse.setPermissionId(upmsRolePermission.getPermissionId());
		upmsRolePermissionResponse.setCreateTime(upmsRolePermission.getCreateTime());
		upmsRolePermissionResponse.setUpdateTime(upmsRolePermission.getUpdateTime());
		return upmsRolePermissionResponse;
	}

	/**
	 * 客户端请求 UpmsRolePermissionRequest 转换为 UpmsRolePermission
	 * @param upmsRolePermissionRequest
	 * @return
	 */
	@Override
	public UpmsRolePermission assembleUpmsRolePermission (UpmsRolePermissionRequest upmsRolePermissionRequest ){
		UpmsRolePermission upmsRolePermission = new UpmsRolePermission();
		upmsRolePermission.setId(upmsRolePermissionRequest.getId());
		upmsRolePermission.setRoleId(upmsRolePermissionRequest.getRoleId());
		upmsRolePermission.setPermissionId(upmsRolePermissionRequest.getPermissionId());
		upmsRolePermission.setCreateTime(upmsRolePermissionRequest.getCreateTime());
		upmsRolePermission.setUpdateTime(upmsRolePermissionRequest.getUpdateTime());
		return upmsRolePermission;
	}
}
