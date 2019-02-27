
package login.web.dao;

import com.qijia.framework.dao.IBaseDao;
import login.web.model.SysUser;
import org.springframework.stereotype.Component;

 /**
  * desc : SysUser
  * Created by weichen on  2018/09/18.
  */
@Component(value = "sysUserDao")
public interface SysUserDao extends IBaseDao<SysUser> {

}