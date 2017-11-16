/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsGalleryDao.java
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
import com.huazhu.hvip.product.goods.model.GoodsGallery;

import java.util.List;

/**
 * An interface that provides a data management interface to the GoodsGallery table.
 */
public interface GoodsGalleryDao extends GenericDao<GoodsGallery, Long> {


    /**
     * 查询相册
     * @param queryModel
     * @param para
     * @return
     */
    public List<GoodsGallery> searchGalleryList(QueryModel queryModel,ParamObject para);

}