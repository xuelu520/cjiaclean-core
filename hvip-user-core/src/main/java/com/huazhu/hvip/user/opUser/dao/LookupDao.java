/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: LookupDao.java
 * Author:   admin
 * Date:     2016-03-10 14:03:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:03:24><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.dao;

import com.huazhu.hvip.user.opUser.model.OpRole;

import java.util.List;


/**
 * Lookup Data Access Object (GenericDao) interface.  This is used to lookup values in
 * the database (i.e. for drop-downs).
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupDao {
    //~ Methods ================================================================

    /**
     * Returns all Roles ordered by name
     * @return populated list of roles
     */
    List<OpRole> getRoles();
}
