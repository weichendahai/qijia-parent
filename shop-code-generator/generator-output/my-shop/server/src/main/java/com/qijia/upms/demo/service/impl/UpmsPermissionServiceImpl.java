package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsPermissionRequest;
import com.qijia.upms.bo.po.UpmsPermissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsPermission;
import com.qijia.upms.dao.UpmsPermissionDao;
import com.qijia.upms.service.UpmsPermissionService;

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
public class UpmsPermissionServiceImpl extends BaseServiceImpl<UpmsPermissionDao,UpmsPermission> implements UpmsPermissionService {

	@Autowired
	UpmsPermissionDao upmsPermissionDao;

	@Override
	public PageResponse<UpmsPermissionResponse> queryByObject(UpmsPermissionRequest upmsPermissionRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsPermission upmsPermission = assembleUpmsPermission(upmsPermissionRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsPermissionRequest.getPageRequest());
		List<UpmsPermission> upmsPermissionList = upmsPermissionDao.queryByObject(upmsPermission);

//		转换model 为 response data
		List<UpmsPermissionResponse> myList = new ArrayList<UpmsPermissionResponse>();
		for (UpmsPermission item : upmsPermissionList ) {
			myList.add(assembleUpmsPermission(item));
		}

		PageResponse<UpmsPermissionResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsPermission 转换为 UpmsPermissionResponse
	 * @param upmsPermission
	 * @return
	 */
	@Override
	public UpmsPermissionResponse assembleUpmsPermission (UpmsPermission upmsPermission ){

		UpmsPermissionResponse upmsPermissionResponse = new UpmsPermissionResponse();
		upmsPermissionResponse.setId(upmsPermission.getId());
		upmsPermissionResponse.setSystemId(upmsPermission.getSystemId());
		upmsPermissionResponse.setPid(upmsPermission.getPid());
		upmsPermissionResponse.setName(upmsPermission.getName());
		upmsPermissionResponse.setType(upmsPermission.getType());
		upmsPermissionResponse.setPermissionValue(upmsPermission.getPermissionValue());
		upmsPermissionResponse.setUri(upmsPermission.getUri());
		upmsPermissionResponse.setIcon(upmsPermission.getIcon());
		upmsPermissionResponse.setStatus(upmsPermission.getStatus());
		upmsPermissionResponse.setOrders(upmsPermission.getOrders());
		upmsPermissionResponse.setCreateTime(upmsPermission.getCreateTime());
		upmsPermissionResponse.setUpdateTime(upmsPermission.getUpdateTime());
		return upmsPermissionResponse;
	}

	/**
	 * 客户端请求 UpmsPermissionRequest 转换为 UpmsPermission
	 * @param upmsPermissionRequest
	 * @return
	 */
	@Override
	public UpmsPermission assembleUpmsPermission (UpmsPermissionRequest upmsPermissionRequest ){
		UpmsPermission upmsPermission = new UpmsPermission();
		upmsPermission.setId(upmsPermissionRequest.getId());
		upmsPermission.setSystemId(upmsPermissionRequest.getSystemId());
		upmsPermission.setPid(upmsPermissionRequest.getPid());
		upmsPermission.setName(upmsPermissionRequest.getName());
		upmsPermission.setType(upmsPermissionRequest.getType());
		upmsPermission.setPermissionValue(upmsPermissionRequest.getPermissionValue());
		upmsPermission.setUri(upmsPermissionRequest.getUri());
		upmsPermission.setIcon(upmsPermissionRequest.getIcon());
		upmsPermission.setStatus(upmsPermissionRequest.getStatus());
		upmsPermission.setOrders(upmsPermissionRequest.getOrders());
		upmsPermission.setCreateTime(upmsPermissionRequest.getCreateTime());
		upmsPermission.setUpdateTime(upmsPermissionRequest.getUpdateTime());
		return upmsPermission;
	}
}
