/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsManager.java
 * Author:   chenli
 * Date:     2016-03-20 17:29:09
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 17:29:09> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.GoodsGallery;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;

import java.util.List;
import java.util.Map;

public interface GoodsManager extends GenericManager<Goods, Long> {


    /**
     * 根据条件查询Goods
     *
     * @param paramObject
     * @return List<Goods>
     */
    public List<GoodsExt> searchGoodsList(ParamObject paramObject);

    /**
     * 根据id批量删除商品
     *
     * @param ids
     * @return count
     */
    public int deleteGoods(Long[] ids);

    /**
     * 保存商品
     *
     * @param goods
     * @return
     */
    public Goods saveGoods(Goods goods);

    /**
     * 创建商品
     *
     * @param goods
     * @param list
     * @return
     */
    public Goods createGoods(Goods goods, List<GoodsGallery> list);

    /**
     * 商品下单数+1
     *
     * @param goodsIdList
     * @return
     */
    ReturnObject saveGoodsOrderCount(List<Long> goodsIdList);

    /**
     * 上下架设置
     *
     * @param goodsId
     * @param enable
     * @return
     */
    public int setMarketEnable(Long goodsId, String enable);

    /**
     * 保存商品
     *
     * @param goods
     * @param list
     * @return
     */
    public Goods saveGoods(Goods goods, List<GoodsGallery> list);

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    void saveSort(Map<Long, Integer> sortMap);

    /**
     * 根据cateId查询商品是否存在
     *
     * @param cateId
     * @return
     */
    public Integer getGoodsIsExistByCategoryId(Long cateId);
}