package login.web.service.impl;

import com.qijia.framework.service.impl.BaseServiceImpl;
import login.web.dao.UserDao;
import login.web.model.User;
import login.web.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by weichen on 2018/9/27.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

}