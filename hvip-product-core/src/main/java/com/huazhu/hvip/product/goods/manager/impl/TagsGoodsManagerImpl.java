/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagsManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.TagGoodsDao;
import com.huazhu.hvip.product.goods.manager.TagGoodsManager;
import com.huazhu.hvip.product.goods.model.TagGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagsGoodsManager")
public class TagsGoodsManagerImpl extends GenericManagerImpl<TagGoods, Long> implements TagGoodsManager {

    @Autowired
    private TagGoodsDao tagGoodsDao;

    /**
     * 关联商品与标签
     *
     * @param tagGoods
     * @return
     */
    @Override
    public void addTagsGoods(TagGoods tagGoods) {
        tagGoodsDao.addTagsGoods(tagGoods);
    }

    /**
     * 根据商品Id删除标签下的关联商品
     *
     * @param goodsId
     * @param tagsId
     * @return
     */
    @Override
    public void deleteGoods(Long goodsId, Long tagsId) {
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("goodsId",goodsId);
        queryModel.addColumnValueCondition("tagsId",tagsId);
        List<TagGoods> goodsList = tagGoodsDao.search(queryModel);
        if (goodsList !=null && goodsList.size()>0){
            for (TagGoods tagGoods : goodsList){
                tagGoodsDao.remove(tagGoods);
            }
        }
    }
}