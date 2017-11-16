/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: LookupManagerImpl.java
 * Author:   admin
 * Date:     2016-03-10 14:19:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:19:08><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.huazhu.hvip.user.opUser.dao.LookupDao;
import com.huazhu.hvip.user.opUser.manager.LookupManager;
import com.huazhu.hvip.user.opUser.model.OpRole;
import com.huazhu.hvip.util.LabelValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupManagerImpl implements LookupManager {
    @Autowired
    LookupDao dao;

    /**
     * {@inheritDoc}
     */
    public List<LabelValue> getAllRoles() {
        List<OpRole> roles = dao.getRoles();
        List<LabelValue> list = new ArrayList<LabelValue>();

        for (OpRole role1 : roles) {
            list.add(new LabelValue(role1.getRoleName(), role1.getRoleName()));
        }

        return list;
    }
}
