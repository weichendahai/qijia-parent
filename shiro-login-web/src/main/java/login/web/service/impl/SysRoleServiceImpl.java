package login.web.service.impl;


import login.web.dao.SysRoleDao;
import login.web.model.SysRole;
import login.web.service.SysResourceService;
import login.web.service.SysRoleService;
import org.apache.ibatis.annotations.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
  * desc : SysRole
  * Created by weichen on  2018/09/18.
  */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	SysRoleDao roleDao;

	@Autowired
	SysResourceService resourceService;

	public SysRole createRole(SysRole role) {
		roleDao.insert(role);
		return role;
	}

	public SysRole updateRole(SysRole role) {
		roleDao.updateById(role);
		return role;
	}

	public void deleteRole(Long roleId) {
		roleDao.deleteById(roleId);
	}

	public SysRole findOne(Long roleId) {
		return roleDao.selectById(roleId);
	}

	public List<SysRole> findAll() {
		List<SysRole> sysRoles = roleDao.selectList(null);
		return sysRoles;
	}

	public Set<String> findRoles(Long... roleIds) {
		Set<String> roles = new HashSet<String>();
		for(Long roleId : roleIds) {
			SysRole role = this.findOne(roleId);
			if(role != null) {
				roles.add(role.getRole());
			}
		}
		return roles;
	}

	public Set<String> findPermissions(Long[] roleIds) {
		Set<Long> resourceIds = new HashSet<Long>();
		for(Long roleId : roleIds) {
			SysRole role = findOne(roleId);
			if(role != null) {

				String resourceIds2 = role.getResourceIds();
				String[] split2 = resourceIds2.split(",");
				for (String item2 : split2) {
					resourceIds.add(Long.valueOf(item2));
				}
//				resourceIds.addAll(Arrays.asList(split2));
			}
		}
		return resourceService.findPermissions(resourceIds);
	}
}
