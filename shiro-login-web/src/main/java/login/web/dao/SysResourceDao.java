package login.web.dao;

import com.qijia.framework.dao.IBaseDao;
import login.web.model.SysResource;
import org.springframework.stereotype.Component;

 /**
  * desc : SysResource
  * Created by weichen on  2018/09/18.
  */
@Component(value = "sysResourceDao")
public interface SysResourceDao extends IBaseDao<SysResource> {
}