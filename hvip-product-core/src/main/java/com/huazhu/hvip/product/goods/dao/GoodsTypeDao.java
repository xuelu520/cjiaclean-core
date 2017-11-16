/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeDao.java
 * Author:   admin
 * Date:     2016-03-13 14:31:21
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:21> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.GoodsType;

import java.util.List;

/**
 * An interface that provides a data management interface to the GoodsType table.
 */
public interface GoodsTypeDao extends GenericDao<GoodsType, Long> {

    /**
     * 查询类型列表
     * @param queryModel
     * @param para
     * @return
     */
    public List<GoodsType> searchGoodsTypeList(QueryModel queryModel,ParamObject para);

}