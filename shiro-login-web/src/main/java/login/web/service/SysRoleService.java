package login.web.service;

import login.web.model.SysRole;

import java.util.List;
import java.util.Set;

/**
 * desc : SysRole
 * Created by weichen on  2018/09/18.
 */
public interface SysRoleService {

	SysRole createRole(SysRole role);

	SysRole updateRole(SysRole role);

	void deleteRole(Long roleId);

	SysRole findOne(Long roleId);

	List<SysRole> findAll();

	/**
	 * 根据角色编号得到角色标识符列表
	 *
	 * @param roleIds
	 * @return
	 */
	Set<String> findRoles(Long... roleIds);

	/**
	 * 根据角色编号得到权限字符串列表
	 *
	 * @param roleIds
	 * @return
	 */
	Set<String> findPermissions(Long[] roleIds);
}