/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsStoreService.java
 * Author:   chenli
 * Date:     2016-04-01 16:04:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-01 16:04:12> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.ChangeGoodsStoreVO;
import com.huazhu.hvip.product.vo.GoodsStoreVO;

import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface GoodsStoreService {

    /**
     * 根据商品id查询商品库存表
     *
     * @param goodsIdList
     * @return
     */
    public ReturnObject<GoodsStoreVO> searchGoodsStore(Long hotelId,List<Long> goodsIdList);

    /**
     * 更新或保存商品库存
     *
     * @param hotelId
     * @param goodsStoreMap
     * @return
     */
    public ReturnObject updateGoodsStore(Long hotelId,Map<Long,Integer> goodsStoreMap);

    /**
     * 改变商品库存，适用于下单、取消、退款等商品库存的变化
     *
     * @param changeGoodsStoreVO
     * @return
     */
    ReturnObject changeGoodsStore(ChangeGoodsStoreVO changeGoodsStoreVO);

    /**
     * 删除酒店下的所有ID
     *
     * @param hotelId
     */
    public ReturnObject removeHotelGoodStore(String hotelId);

    /**
     * 删除分类下的库存
     * @param hotelId
     * @param cateIds
     * @return
     */
    public ReturnObject removeHotelGoodStoreByCateId(String hotelId,List<String> cateIds);
}
