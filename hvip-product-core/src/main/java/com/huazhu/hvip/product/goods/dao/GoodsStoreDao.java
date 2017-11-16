/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsSpecDao.java
 * Author:   admin
 * Date:     2016-03-13 14:31:21
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:21> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.GoodsSpec;
import com.huazhu.hvip.product.goods.model.GoodsStore;

import java.util.List;

/**
 * An interface that provides a data management interface to the GoodsSpec table.
 */
public interface GoodsStoreDao extends GenericDao<GoodsStore, Long> {

    /**
     * 根据查询条件查询商品库存列表
     *
     * @param queryModel
     * @return
     */
    List<GoodsStore> searchGoodsStore(QueryModel queryModel);
}