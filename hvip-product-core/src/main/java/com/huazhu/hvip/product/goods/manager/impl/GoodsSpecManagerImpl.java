/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsSpecManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.GoodsSpecDao;
import com.huazhu.hvip.product.goods.manager.GoodsSpecManager;
import com.huazhu.hvip.product.goods.model.GoodsSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsSpecManager")
public class GoodsSpecManagerImpl extends GenericManagerImpl<GoodsSpec, Long> implements GoodsSpecManager {
    GoodsSpecDao goodsSpecDao;

    @Autowired
    public GoodsSpecManagerImpl(GoodsSpecDao goodsSpecDao) {
        super(goodsSpecDao);
        this.goodsSpecDao = goodsSpecDao;
    }
}