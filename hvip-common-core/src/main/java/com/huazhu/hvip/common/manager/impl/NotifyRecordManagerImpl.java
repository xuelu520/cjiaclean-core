/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MenuManagerImpl.java
 * Author:   lijing
 * Date:     2016-04-18 16:16:59
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-18 16:16:59> <version>   <desc>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.NotifyRecordDao;
import com.huazhu.hvip.common.manager.NotifyRecordManager;
import com.huazhu.hvip.common.model.NotifyRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("notifyRecordManager")
public class NotifyRecordManagerImpl extends GenericManagerImpl<NotifyRecord,Long> implements NotifyRecordManager {

    NotifyRecordDao notifyRecordDao;

    @Autowired
    public NotifyRecordManagerImpl(NotifyRecordDao notifyRecordDao){
        super(notifyRecordDao);
        this.notifyRecordDao = notifyRecordDao;
    }
}
