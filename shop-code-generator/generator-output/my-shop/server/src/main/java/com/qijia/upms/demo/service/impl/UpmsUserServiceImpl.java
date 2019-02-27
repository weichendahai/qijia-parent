package com.qijia.upms.service.impl;

import com.github.pagehelper.Page;
import com.srsj.common.bo.PageResponse;
import com.srsj.common.bo.PageUtil;
import com.qijia.upms.bo.vo.UpmsUserRequest;
import com.qijia.upms.bo.po.UpmsUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srsj.common.service.impl.BaseServiceImpl;
import com.qijia.upms.model.UpmsUser;
import com.qijia.upms.dao.UpmsUserDao;
import com.qijia.upms.service.UpmsUserService;

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
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserDao,UpmsUser> implements UpmsUserService {

	@Autowired
	UpmsUserDao upmsUserDao;

	@Override
	public PageResponse<UpmsUserResponse> queryByObject(UpmsUserRequest upmsUserRequest) {

//		设置查询条件;如有非model 模型数据；自己编写 map查询条件
		UpmsUser upmsUser = assembleUpmsUser(upmsUserRequest);

//		初始化分页数据;切进行查询数据
		Page page = PageUtil.initPage(upmsUserRequest.getPageRequest());
		List<UpmsUser> upmsUserList = upmsUserDao.queryByObject(upmsUser);

//		转换model 为 response data
		List<UpmsUserResponse> myList = new ArrayList<UpmsUserResponse>();
		for (UpmsUser item : upmsUserList ) {
			myList.add(assembleUpmsUser(item));
		}

		PageResponse<UpmsUserResponse> responsePageData = PageUtil.getResponsePageData(page, myList);
		return responsePageData;
	}

	/**
	 * 数据库查询成功后； UpmsUser 转换为 UpmsUserResponse
	 * @param upmsUser
	 * @return
	 */
	@Override
	public UpmsUserResponse assembleUpmsUser (UpmsUser upmsUser ){

		UpmsUserResponse upmsUserResponse = new UpmsUserResponse();
		upmsUserResponse.setId(upmsUser.getId());
		upmsUserResponse.setUsername(upmsUser.getUsername());
		upmsUserResponse.setPassword(upmsUser.getPassword());
		upmsUserResponse.setSalt(upmsUser.getSalt());
		upmsUserResponse.setRealname(upmsUser.getRealname());
		upmsUserResponse.setAvatar(upmsUser.getAvatar());
		upmsUserResponse.setPhone(upmsUser.getPhone());
		upmsUserResponse.setEmail(upmsUser.getEmail());
		upmsUserResponse.setSex(upmsUser.getSex());
		upmsUserResponse.setLocked(upmsUser.getLocked());
		upmsUserResponse.setCreateTime(upmsUser.getCreateTime());
		upmsUserResponse.setUpdateTime(upmsUser.getUpdateTime());
		return upmsUserResponse;
	}

	/**
	 * 客户端请求 UpmsUserRequest 转换为 UpmsUser
	 * @param upmsUserRequest
	 * @return
	 */
	@Override
	public UpmsUser assembleUpmsUser (UpmsUserRequest upmsUserRequest ){
		UpmsUser upmsUser = new UpmsUser();
		upmsUser.setId(upmsUserRequest.getId());
		upmsUser.setUsername(upmsUserRequest.getUsername());
		upmsUser.setPassword(upmsUserRequest.getPassword());
		upmsUser.setSalt(upmsUserRequest.getSalt());
		upmsUser.setRealname(upmsUserRequest.getRealname());
		upmsUser.setAvatar(upmsUserRequest.getAvatar());
		upmsUser.setPhone(upmsUserRequest.getPhone());
		upmsUser.setEmail(upmsUserRequest.getEmail());
		upmsUser.setSex(upmsUserRequest.getSex());
		upmsUser.setLocked(upmsUserRequest.getLocked());
		upmsUser.setCreateTime(upmsUserRequest.getCreateTime());
		upmsUser.setUpdateTime(upmsUserRequest.getUpdateTime());
		return upmsUser;
	}
}
