package login.web.service.impl;


import login.web.dao.SysUserDao;
import login.web.model.SysUser;
import login.web.service.SysRoleService;
import login.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
  * desc : SysUser
  * Created by weichen on  2018/09/18.
  */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserDao userDao;

	@Autowired
	SysRoleService roleService;

	public SysUser insert(SysUser sysUser) {
		userDao.insert(sysUser);
		return sysUser;
	}

	public SysUser update(SysUser sysUser) {
		userDao.updateById(sysUser);
		return sysUser;
	}

	public Integer delete(Long userId) {
		return userDao.deleteById(userId);
	}

	public void changePassword(Long userId, String newPassword) {

	}

	public SysUser findOne(Long userId) {
		SysUser sysUser = userDao.selectById(userId);
		return sysUser;
	}

	public List<SysUser> findAll() {
		List<SysUser> sysUsers = userDao.selectBatchIds(null);
		if(sysUsers == null) {
			return Collections.EMPTY_LIST;
		}
		return sysUsers;
	}

	public SysUser findByUsername(String username) {
		SysUser model = new SysUser();
		model.setUsername(username);
		SysUser sysUser = userDao.selectOne(model);
		return sysUser;
	}

	public Set<String> findRoles(String username) {
		SysUser sysUser = this.findByUsername(username);
		String userRoleIds = sysUser.getRoleIds();
		String[] split = userRoleIds.split(",");

		Set<Long> result = new HashSet<Long>();
		for (String item : split) {
			result.add(Long.valueOf(item));
		}
		return roleService.findRoles(result.toArray(new Long[0]));

	}

	public Set<String> findPermissions(String username) {
		SysUser sysUser = this.findByUsername(username);
		String userRoleIds = sysUser.getRoleIds();
		String[] split = userRoleIds.split(",");
		Set<Long> result = new HashSet<Long>();
		for (String item : split) {
			result.add(Long.valueOf(item));
		}

		return roleService.findPermissions(result.toArray(new Long[0]));
	}
}
