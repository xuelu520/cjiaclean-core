package com.huazhu.hvip.user.opUser.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.user.opUser.dao.RoleAuthDao;
import com.huazhu.hvip.user.opUser.manager.RoleAuthManager;
import com.huazhu.hvip.user.opUser.model.RoleAuth;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cmy
 * @create 2017-07-24 12:36
 **/
public class RoleAuthManagerImpl extends GenericManagerImpl<RoleAuth, Long> implements RoleAuthManager {

    RoleAuthDao roleAuthDao;

    @Autowired
    public RoleAuthManagerImpl(RoleAuthDao roleAuthDao) {
        super(roleAuthDao);
        this.roleAuthDao = roleAuthDao;
    }
}
