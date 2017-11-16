/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SpecValueManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-14 16:41:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 16:41:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.SpecValuesDao;
import com.huazhu.hvip.product.goods.manager.SpecValuesManager;
import com.huazhu.hvip.product.goods.model.SpecValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("specValuesManager")
public class SpecValuesManagerImpl extends GenericManagerImpl<SpecValues, Long> implements SpecValuesManager {
    SpecValuesDao specValuesDao;

    @Autowired
    public SpecValuesManagerImpl(SpecValuesDao specValuesDao) {
        super(specValuesDao);
        this.specValuesDao = specValuesDao;
    }
}