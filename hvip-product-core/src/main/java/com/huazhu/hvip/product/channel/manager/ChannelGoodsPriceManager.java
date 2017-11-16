/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceManager.java
 * Author:   lijing
 * Date:     2016-03-14 15:40:03
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:40:03> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.channel.model.ChannelGoodsPrice;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.goods.model.Frequency;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ChannelGoodsPriceManager extends GenericManager<ChannelGoodsPrice, Long>{

    /**
     * 查询商品价格
     * @param para
     * @return
     */
    public List<ChannelGoodsPrice> searchChannelGoodsPrice(ParamObject para);

    /**
     * 保存商品价格信息
     * @param list
     * @return
     */
    public List<ChannelGoodsPrice> saveGoodsPrice(List<ChannelGoodsPrice> list);


    /**
     * 根据Id查询商品销售价格
     * @param paramObject
     * @return
     */
    List<ChannelGoodsPriceExt> searchChannelAndPriceByGoodsId(ParamObject paramObject);
}
