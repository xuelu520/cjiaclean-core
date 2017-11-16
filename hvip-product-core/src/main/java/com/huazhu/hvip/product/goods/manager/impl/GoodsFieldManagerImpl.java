/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsFieldManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.GoodsFieldDao;
import com.huazhu.hvip.product.goods.manager.GoodsFieldManager;
import com.huazhu.hvip.product.goods.model.GoodsField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsFieldManager")
public class GoodsFieldManagerImpl extends GenericManagerImpl<GoodsField, Long> implements GoodsFieldManager {
    GoodsFieldDao goodsFieldDao;

    @Autowired
    public GoodsFieldManagerImpl(GoodsFieldDao goodsFieldDao) {
        super(goodsFieldDao);
        this.goodsFieldDao = goodsFieldDao;
    }
}