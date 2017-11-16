/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsGalleryManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.GoodsGalleryDao;
import com.huazhu.hvip.product.goods.manager.GoodsGalleryManager;
import com.huazhu.hvip.product.goods.model.GoodsGallery;
import com.huazhu.hvip.util.CheckUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("goodsGalleryManager")
public class GoodsGalleryManagerImpl extends GenericManagerImpl<GoodsGallery, Long> implements GoodsGalleryManager {
    GoodsGalleryDao goodsGalleryDao;

    @Autowired
    public GoodsGalleryManagerImpl(GoodsGalleryDao goodsGalleryDao) {
        super(goodsGalleryDao);
        this.goodsGalleryDao = goodsGalleryDao;
    }


    /**
     * 查询相册
     * @param para
     * @return
     */
    @Override
    public List<GoodsGallery> searchGalleryList(ParamObject para) {
        QueryModel queryModel = new QueryModel();
        Long goodsId = para.getLongParam("goodsId");
        if(goodsId!=null){
            queryModel.addColumnValueCondition("g.goodsId",goodsId);
        }
        List<GoodsGallery> pictureList = goodsGalleryDao.searchGalleryList(queryModel,para);

        return pictureList;
    }


    /**
     * 查询多个goodsId下的商品相册
     * @param goodsIdset
     * @return
     */
    @Override
    public List<GoodsGallery> searchGalleryList(Set goodsIdset) {
        if(CheckUtil.checkListIsNull(goodsIdset)){
            String goodsIds= StringUtils.join(goodsIdset,",");
            if(StringUtils.isNotBlank(goodsIds)){
                QueryModel queryModel=new QueryModel();
                queryModel.addHqlCondition(" goodsId in ("+goodsIds+")");
                List<GoodsGallery> goodsGalleries =goodsGalleryDao.search(queryModel);
                return goodsGalleries;
            }
        }
        return null;
    }
}