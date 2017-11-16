/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SpecificationManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.SpecificationDao;
import com.huazhu.hvip.product.goods.manager.SpecManager;
import com.huazhu.hvip.product.goods.model.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("specificationManager")
public class SpecManagerImpl extends GenericManagerImpl<Spec, Long> implements SpecManager {
    SpecificationDao specificationDao;

    @Autowired
    public SpecManagerImpl(SpecificationDao specificationDao) {
        super(specificationDao);
        this.specificationDao = specificationDao;
    }
}