/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsGalleryManager.java
 * Author:   admin
 * Date:     2016-03-13 14:32:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:32:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.GoodsGallery;

import java.util.List;
import java.util.Set;

public interface GoodsGalleryManager extends GenericManager<GoodsGallery, Long> {

    /**
     * 查询相册
     * @param para
     * @return
     */
    public List<GoodsGallery> searchGalleryList(ParamObject para);

    /**
     * 查询多个goodsId下的商品相册
     * @param goodsIdset
     * @return
     */
    public List<GoodsGallery> searchGalleryList(Set goodsIdset);

}