/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceService.java
 * Author:   lijing
 * Date:     2016-04-08 15:16:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-08 15:16:07> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.request.ChannelGoodsPriceInfo;
import com.huazhu.hvip.product.vo.ChangeStoreInfoVO;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ChannelGoodsPriceService {

    /**
     * 根据商品id查询商品价格
     * @param goodsId
     * @return
     */
    ReturnObject<ChannelGoodsPriceVO> searchChannelGoodsPriceByGoodsId(Long goodsId);

    /**
     * 保存商品价格信息
     * @param list
     * @return
     */
    ReturnObject<ChannelGoodsPriceVO> saveGoodsPrice(List<ChannelGoodsPriceInfo> list);

    /**
     * 根据Id查询商品销售价格
     * @param goodsIds
     * @return
     */
    ReturnObject<ChannelGoodsPriceVO> searchChannelAndPriceByGoodsId(String goodsIds,String hotelNo);

    /**
     * 保存酒店申请的信息
     * @param channelGoodsPriceVOs
     * @return
     */
    ReturnObject saveHotelGoodsPrice(List<ChannelGoodsPriceVO> channelGoodsPriceVOs);
}
