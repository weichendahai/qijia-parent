package login.web.constant;

import com.qijia.framework.result.BaseResult;

/**
 * upms系统常量枚举类
 * Created by weichen on 2018/2/18.
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

}
