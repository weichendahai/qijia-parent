
package login.web.dao;

import com.qijia.framework.dao.IBaseDao;
import login.web.model.SysRole;
import org.springframework.stereotype.Component;

 /**
  * desc : SysRole
  * Created by weichen on  2018/09/18.
  */
@Component(value = "sysRoleDao")
public interface SysRoleDao  extends IBaseDao<SysRole> {
}