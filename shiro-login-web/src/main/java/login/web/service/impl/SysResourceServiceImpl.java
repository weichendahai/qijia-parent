package login.web.service.impl;


import login.web.dao.SysResourceDao;
import login.web.model.SysResource;
import login.web.service.SysResourceService;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
  * desc : SysResource
  * Created by weichen on  2018/09/18.
  */
@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	SysResourceDao resourceDao;

	public SysResource createResource(SysResource resource) {
		resourceDao.insert(resource);
		return resource;
	}

	public SysResource updateResource(SysResource resource) {
		resourceDao.updateById(resource);
		return resource;
	}

	public void deleteResource(Long resourceId) {
		resourceDao.deleteById(resourceId);
	}

	public SysResource findOne(Long resourceId) {
		SysResource sysResource = resourceDao.selectById(resourceId);
		return sysResource;
	}

	public List<SysResource> findAll() {
		List<SysResource> sysResources = resourceDao.selectList(null);
		return sysResources;
	}

	public Set<String> findPermissions(Set<Long> resourceIds) {
		Set<String> permissions = new HashSet<String>();
		for(Long resourceId : resourceIds) {
			SysResource resource = findOne(resourceId);
			if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
				permissions.add(resource.getPermission());
			}
		}
		return permissions;
	}

	public List<SysResource> findMenus(Set<String> permissions) {
		List<SysResource> allResources = findAll();
		List<SysResource> menus = new ArrayList<SysResource>();
		for(SysResource resource : allResources) {
//			if(resource.isRootNode()) {
//				continue;
//			}
			if(resource.getType() != ResourceType.menu.toString()) {
				continue;
			}
			if(!hasPermission(permissions, resource)) {
				continue;
			}
			menus.add(resource);
		}
		return menus;
	}

	public static enum ResourceType {
		menu("菜单"), button("按钮");

		private final String info;
		private ResourceType(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	private boolean hasPermission(Set<String> permissions, SysResource resource) {
		if(StringUtils.isEmpty(resource.getPermission())) {
			return true;
		}
		for(String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(resource.getPermission());
			if(p1.implies(p2) || p2.implies(p1)) {
				return true;
			}
		}
		return false;
	}
}
