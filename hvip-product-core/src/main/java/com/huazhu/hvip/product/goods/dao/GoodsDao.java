/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsDao.java
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
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;

import java.util.List;

/**
 * An interface that provides a data management interface to the Goods table.
 */
public interface GoodsDao extends GenericDao<Goods, Long> {

    /**
     * 根据queryModel查询goods
     *
     * @param queryModel
     * @param paramObject
     * @return List<Goods>
     */
    public List<GoodsExt> searchGoodsList(QueryModel queryModel,ParamObject paramObject);

 /*   *//**
     * 根据id删除商品
     * @param ids
     * @return count
     *//*
    public int deleteGoods(Long[] ids);*/

//    /**
//     * 上下架
//     * @param goodsId
//     * @param enable
//     * @return
//     */
//    public int setMarketEnable(Long goodsId,String enable);

    /**
     * 根据cateId判断商品是否存在
     *
     * @param cateId
     * @return
     */
    public Integer getGoodsIsExistByCategoryId(Long cateId);

}