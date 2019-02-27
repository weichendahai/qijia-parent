package login.web.service;

import login.web.dao.SysUserDao;
import login.web.model.SysUser;

import java.util.List;
import java.util.Set;

/**
 * desc : SysUser
 * Created by weichen on  2018/09/18.
 */
public interface SysUserService {

	SysUser insert(SysUser sysUser);

	SysUser update(SysUser sysUser);

	Integer delete(Long userId);

	void changePassword(Long userId, String newPassword);

	SysUser findOne(Long userId);

	List<SysUser> findAll();

	SysUser findByUsername(String username);

	/**
	 * 根据用户名查找其角色
	 *
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 *
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);
}