
package login.web.dao;

import org.springframework.stereotype.Repository;
import com.qijia.framework.dao.IBaseDao;
import login.web.model.RolePermission;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


@Repository(value = "rolePermission")
public interface RolePermissionDao extends IBaseDao<RolePermission> {
}