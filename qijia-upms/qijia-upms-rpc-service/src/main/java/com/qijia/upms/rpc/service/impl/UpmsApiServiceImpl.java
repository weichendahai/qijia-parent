package com.qijia.upms.rpc.service.impl;


import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.upms.dao.*;
import com.qijia.upms.model.*;
import com.qijia.upms.rpc.api.UpmsApiService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * UpmsApiService实现
 * Created by shuzheng on 2016/01/19.
 */
@Service
@Transactional
public class UpmsApiServiceImpl implements UpmsApiService {

    private static Logger _log = LoggerFactory.getLogger(UpmsApiServiceImpl.class);

    @Autowired
    UpmsUserDao upmsUserMapper;

//    @Autowired
//    UpmsApiMapper upmsApiMapper;

    @Autowired
    UpmsRolePermissionDao upmsRolePermissionMapper;

    @Autowired
    UpmsUserPermissionDao upmsUserPermissionMapper;

    @Autowired
    UpmsSystemDao upmsSystemMapper;

    @Autowired
    UpmsOrganizationDao upmsOrganizationMapper;

    @Autowired
    UpmsLogDao upmsLogMapper;

    @Autowired
    UpmsUserRoleDao upmsUserRoleDao;


    @Autowired
    UpmsRoleDao upmsRoleDao;

    @Autowired
    UpmsPermissionDao upmsPermissionDao;

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    @Override
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
        // 用户不存在或锁定状态
        UpmsUser upmsUser = upmsUserMapper.selectById(upmsUserId);
        if (null == upmsUser || 1 == upmsUser.getLocked()) {
            _log.info("selectUpmsPermissionByUpmsUserId : upmsUserId={}", upmsUserId);
            return null;
        }

//      根据用户ID获取用户权限
        List<UpmsUserPermission> upmsUserPermissions1 = this.selectUpmsUserPermissionByUpmsUserId(upmsUserId);

        //根据用户ID获取用户所有角色
        List<UpmsRole> upmsRoles = this.selectUpmsRoleByUpmsUserId(upmsUserId);
        List<Integer> userRoleIdList = new ArrayList<>();
        for (UpmsRole itemUpmsRole: upmsRoles) {
            userRoleIdList.add(itemUpmsRole.getId());
        }
        MyEntityWrapper<UpmsRolePermission> wrapperRolePermission = new MyEntityWrapper<>();
        wrapperRolePermission.in("role_id", userRoleIdList);
        List<UpmsRolePermission> upmsRolePermissions = upmsRolePermissionMapper.selectList(wrapperRolePermission);


//        组装用户所有权限ID List
        List<Integer> userPermissionIdsList = new ArrayList<>();
        for (UpmsUserPermission itemUpmsUserPermission : upmsUserPermissions1) {
            if (!userPermissionIdsList.contains(itemUpmsUserPermission.getPermissionId())) {
                userPermissionIdsList.add(itemUpmsUserPermission.getPermissionId());
            }
        }

        for (UpmsRolePermission itemUpmsRolePermission : upmsRolePermissions) {
            if (!userPermissionIdsList.contains(itemUpmsRolePermission.getPermissionId())) {
                userPermissionIdsList.add(itemUpmsRolePermission.getPermissionId());
            }
        }

//      根据选线ID list 查询用户所有权限信息(用户权限+用户角色权限)
        MyEntityWrapper<UpmsPermission> wrapperPermission = new MyEntityWrapper<>();
        wrapperPermission.in("id", userPermissionIdsList);
        List<UpmsPermission> upmsPermissions = upmsPermissionDao.selectList(wrapperPermission);
        return upmsPermissions;

        //List<UpmsPermission> upmsPermissions = upmsApiMapper.selectUpmsPermissionByUpmsUserId(upmsUserId);
//        return upmsPermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    @Override
    @Cacheable(value = "zheng-upms-rpc-service-ehcache", key = "'selectUpmsPermissionByUpmsUserId_' + #upmsUserId")
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
        return selectUpmsPermissionByUpmsUserId(upmsUserId);
    }

    /**
     * 根据用户id获取所属的角色
     * @param upmsUserId
     * @return
     */
    @Override
    public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
        // 用户不存在或锁定状态
        UpmsUser upmsUser = upmsUserMapper.selectById(upmsUserId);
        if (null == upmsUser || 1 == upmsUser.getLocked()) {
            _log.info("selectUpmsRoleByUpmsUserId : upmsUserId={}", upmsUserId);
            return null;
        }
//        根据用户ID获取用户所有角色
        MyEntityWrapper<UpmsUserRole> wrapperUserRole = new MyEntityWrapper<>();
        wrapperUserRole.where("user_id={0}", upmsUserId);
        List<UpmsUserRole> upmsUserRoles = upmsUserRoleDao.selectList(wrapperUserRole);

        List<Integer> roleIdsList = new ArrayList<>();
        for (UpmsUserRole itemUserRole : upmsUserRoles) {
            roleIdsList.add(itemUserRole.getRoleId());
        }

//        根据用户所有角色，获取角色信息
        MyEntityWrapper<UpmsRole> wrapperRole = new MyEntityWrapper<>();
        wrapperUserRole.in("id", roleIdsList);

        List<UpmsRole> upmsRoles = upmsRoleDao.selectList(wrapperRole);
        return upmsRoles;

//        List<UpmsRole> upmsRoles = upmsApiMapper.selectUpmsRoleByUpmsUserId(upmsUserId);
//        return upmsRoles;
    }

    /**
     * 根据用户id获取所属的角色
     * @param upmsUserId
     * @return
     */
    @Override
    @Cacheable(value = "zheng-upms-rpc-service-ehcache", key = "'selectUpmsRoleByUpmsUserId_' + #upmsUserId")
    public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
        return selectUpmsRoleByUpmsUserId(upmsUserId);
    }

    /**
     * 根据角色id获取所拥有的权限
     * @param upmsRoleId
     * @return
     */
    @Override
    public List<UpmsRolePermission> selectUpmsRolePermisstionByUpmsRoleId(Integer upmsRoleId) {
        MyEntityWrapper<UpmsRolePermission> wrapper = new MyEntityWrapper<>();
        wrapper.where("role_id={0}", upmsRoleId);
        List<UpmsRolePermission> upmsRolePermissions = upmsRolePermissionMapper.selectList(wrapper);
        return upmsRolePermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
    @Override
    public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
        MyEntityWrapper<UpmsUserPermission> wrapper = new MyEntityWrapper<>();
        wrapper.where("user_id={0}", upmsUserId);
        List<UpmsUserPermission> upmsUserPermissions = upmsUserPermissionMapper.selectList(wrapper);
        return upmsUserPermissions;
    }

    /**
     * 根据条件获取系统数据
     * @param upmsSystem
     * @return
     */
    @Override
    public List<UpmsSystem> selectUpmsSystemByExample(UpmsSystem upmsSystem) {
        MyEntityWrapper<UpmsSystem> wrapper = new MyEntityWrapper<>();
        wrapper.where("id={0}", upmsSystem.getId());
        return upmsSystemMapper.selectList(wrapper);
    }

    /**
     * 根据条件获取组织数据
     * @param upmsOrganizationExample
     * @return
     */
    @Override
    public List<UpmsOrganization> selectUpmsOrganizationByExample(UpmsOrganization upmsOrganizationExample) {
        MyEntityWrapper<UpmsOrganization> wrapper = new MyEntityWrapper<>();
        wrapper.where("id={0}", upmsOrganizationExample.getId());
        return upmsOrganizationMapper.selectList(wrapper);
    }

    /**
     * 根据username获取UpmsUser
     * @param username
     * @return
     */
    @Override
    public UpmsUser selectUpmsUserByUsername(String username) {
        MyEntityWrapper<UpmsUser> wrapper = new MyEntityWrapper<>();
        wrapper.where("username={0}", username);
        List<UpmsUser> upmsUsers = upmsUserMapper.selectList(wrapper);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
    }

    /**
     * 写入操作日志
     * @param record
     * @return
     */
    @Override
    public int insertUpmsLogSelective(UpmsLog record) {
        return upmsLogMapper.insert(record);
    }

}