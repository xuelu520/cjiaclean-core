/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: LookupManager.java
 * Author:   admin
 * Date:     2016-03-10 14:05:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:05:52><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.manager;

import com.huazhu.hvip.util.LabelValue;

import java.util.List;


/**
 * Business Service Interface to talk to persistence layer and
 * retrieve values for drop-down choice lists.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupManager {
    /**
     * Retrieves all possible roles from persistence layer
     * @return List of LabelValue objects
     */
    List<LabelValue> getAllRoles();
}
