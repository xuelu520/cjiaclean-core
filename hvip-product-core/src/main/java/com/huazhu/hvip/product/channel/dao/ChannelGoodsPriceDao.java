/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceDao.java
 * Author:   lijing
 * Date:     2016-03-14 15:16:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:16:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
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
public interface ChannelGoodsPriceDao extends GenericDao<ChannelGoodsPrice, Long>{

    /**
     * 查询商品价格信息
     *
     * @param queryModel
     * @return
     */
    List<ChannelGoodsPrice> searchChannelGoodsPriceList(QueryModel queryModel);

    /**
     * 查询商品价格
     * @param queryModel
     * @param para
     * @return
     */
    List<ChannelGoodsPrice> searchChannelGoodsPrice(QueryModel queryModel,ParamObject para);

    /**
     * 查询商品价格
     * @param queryModel
     * @param para
     * @return
     */
    List<Frequency> searchFrequencyGoods(QueryModel queryModel, ParamObject para);

    /**
     * 根据Id查询商品销售价格
     * @param queryModel
     * @return
     */
    List<ChannelGoodsPriceExt> searchChannelAndPriceByGoodsId(QueryModel queryModel);
}
