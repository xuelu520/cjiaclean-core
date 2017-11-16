/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SysParamManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.FinanceSubjectDao;
import com.huazhu.hvip.common.manager.FinanceSubjectManager;
import com.huazhu.hvip.common.model.FinanceSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("financeSubjectManager")
public class FinanceSubjectManagerImpl extends GenericManagerImpl<FinanceSubject, Long> implements FinanceSubjectManager {

    FinanceSubjectDao financeSubjectDao;

    @Autowired
    public FinanceSubjectManagerImpl(FinanceSubjectDao financeSubjectDao) {
        super(financeSubjectDao);
        this.financeSubjectDao = financeSubjectDao;
    }

}