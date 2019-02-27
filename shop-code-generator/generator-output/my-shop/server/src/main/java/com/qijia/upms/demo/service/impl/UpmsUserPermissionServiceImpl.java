package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsUserPermissionRequest;
import com.qijia.upms.bo.po.UpmsUserPermissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsUserPermission;
import com.qijia.upms.dao.UpmsUserPermissionDao;
import com.qijia.upms.service.UpmsUserPermissionService;

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
public class UpmsUserPermissionServiceImpl extends BaseServiceImpl<UpmsUserPermissionDao,UpmsUserPermission> implements UpmsUserPermissionService {

	@Autowired
	UpmsUserPermissionDao upmsUserPermissionDao;

	@Override
	public PageResponse<UpmsUserPermissionResponse> queryByObject(UpmsUserPermissionRequest upmsUserPermissionRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsUserPermission upmsUserPermission = assembleUpmsUserPermission(upmsUserPermissionRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsUserPermissionRequest.getPageRequest());
		List<UpmsUserPermission> upmsUserPermissionList = upmsUserPermissionDao.queryByObject(upmsUserPermission);

//		转换model 为 response data
		List<UpmsUserPermissionResponse> myList = new ArrayList<UpmsUserPermissionResponse>();
		for (UpmsUserPermission item : upmsUserPermissionList ) {
			myList.add(assembleUpmsUserPermission(item));
		}

		PageResponse<UpmsUserPermissionResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsUserPermission 转换为 UpmsUserPermissionResponse
	 * @param upmsUserPermission
	 * @return
	 */
	@Override
	public UpmsUserPermissionResponse assembleUpmsUserPermission (UpmsUserPermission upmsUserPermission ){

		UpmsUserPermissionResponse upmsUserPermissionResponse = new UpmsUserPermissionResponse();
		upmsUserPermissionResponse.setId(upmsUserPermission.getId());
		upmsUserPermissionResponse.setUserId(upmsUserPermission.getUserId());
		upmsUserPermissionResponse.setPermissionId(upmsUserPermission.getPermissionId());
		upmsUserPermissionResponse.setType(upmsUserPermission.getType());
		upmsUserPermissionResponse.setCreateTime(upmsUserPermission.getCreateTime());
		upmsUserPermissionResponse.setUpdateTime(upmsUserPermission.getUpdateTime());
		return upmsUserPermissionResponse;
	}

	/**
	 * 客户端请求 UpmsUserPermissionRequest 转换为 UpmsUserPermission
	 * @param upmsUserPermissionRequest
	 * @return
	 */
	@Override
	public UpmsUserPermission assembleUpmsUserPermission (UpmsUserPermissionRequest upmsUserPermissionRequest ){
		UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
		upmsUserPermission.setId(upmsUserPermissionRequest.getId());
		upmsUserPermission.setUserId(upmsUserPermissionRequest.getUserId());
		upmsUserPermission.setPermissionId(upmsUserPermissionRequest.getPermissionId());
		upmsUserPermission.setType(upmsUserPermissionRequest.getType());
		upmsUserPermission.setCreateTime(upmsUserPermissionRequest.getCreateTime());
		upmsUserPermission.setUpdateTime(upmsUserPermissionRequest.getUpdateTime());
		return upmsUserPermission;
	}
}
