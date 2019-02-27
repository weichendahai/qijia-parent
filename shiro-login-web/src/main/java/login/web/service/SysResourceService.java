package login.web.service;

import login.web.model.SysResource;

import java.util.List;
import java.util.Set;

/**
 * desc : SysResource
 * Created by weichen on  2018/09/18.
 */
public interface SysResourceService {

	SysResource createResource(SysResource resource);

	SysResource updateResource(SysResource resource);

	void deleteResource(Long resourceId);

	SysResource findOne(Long resourceId);

	List<SysResource> findAll();

	/**
	 * 得到资源对应的权限字符串
	 *
	 * @param resourceIds
	 * @return
	 */
	Set<String> findPermissions(Set<Long> resourceIds);

	/**
	 * 根据用户权限得到菜单
	 *
	 * @param permissions
	 * @return
	 */
	List<SysResource> findMenus(Set<String> permissions);
}