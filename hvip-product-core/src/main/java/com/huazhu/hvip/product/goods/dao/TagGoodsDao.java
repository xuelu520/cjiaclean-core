/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagsDao.java
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
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.TagGoods;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagGoodsExt;

import java.util.List;

/**
 * An interface that provides a data management interface to the Tags table.
 */
public interface TagGoodsDao extends GenericDao<TagGoods, Long> {
    /**
     * 查询标签商品设置
     *
     * @param paramObject
     * @return
     */
    List<TagGoodsExt> searchTagGoodsList(QueryModel queryModel, ParamObject paramObject);

//    /**
//     * 根据id删除标签
//     *
//     * @param ids
//     * @return
//     */
//    void deleteTagsByIds(Long[] ids);

    /**
     * 查询标签下的商品
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    List<Goods> listGoodsJsonByTagsId(QueryModel queryModel, ParamObject paramObject, Long tagsId);

    /**
     * 关联商品与标签
     *
     * @param tagGoods
     * @return
     */
    void addTagsGoods(TagGoods tagGoods);

}