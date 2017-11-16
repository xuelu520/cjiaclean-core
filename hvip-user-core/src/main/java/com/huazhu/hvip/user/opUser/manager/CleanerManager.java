package com.huazhu.hvip.user.opUser.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.user.opUser.model.Cleaner;

/**
 * @author cmy
 * @create 2017-08-08 16:27
 **/
public interface CleanerManager extends GenericManager<Cleaner,Long> {
    /**
     * 后台用户登录
     *
     * @param paramObject
     * @return
     */
    ReturnObject<Cleaner> loginForOpUser(ParamObject paramObject);

}
