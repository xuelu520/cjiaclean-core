/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SmsTemplateManagerImpl.java
 * Author:   admin
 * Date:     2016-03-20 16:51:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:51:42><version><desc>
 */

package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.SmsTemplateDao;
import com.huazhu.hvip.common.manager.SmsTemplateManager;
import com.huazhu.hvip.common.model.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("smsTemplateManager")
 public class SmsTemplateManagerImpl extends GenericManagerImpl<SmsTemplate, Long> implements SmsTemplateManager {
    SmsTemplateDao smsTemplateDao;

    @Autowired
    public SmsTemplateManagerImpl(SmsTemplateDao smsTemplateDao) {
        super(smsTemplateDao);
        this.smsTemplateDao = smsTemplateDao;
    }
}