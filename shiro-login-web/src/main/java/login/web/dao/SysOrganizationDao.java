
package login.web.dao;

import com.qijia.framework.dao.IBaseDao;
import login.web.model.SysOrganization;
import org.springframework.stereotype.Component;

/**
 * desc : SysOrganization
 * Created by weichen on  2018/09/18.
 */
@Component(value = "sysOrganizationDao")
public interface SysOrganizationDao extends IBaseDao<SysOrganization> {
}