/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelDao.java
 * Author:   lijing
 * Date:     2016-03-14 15:14:09
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:14:09> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.channel.model.Channel;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.channel.model.extend.ChannelRateExt;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ChannelDao extends GenericDao<Channel, Long> {
    /**
     * 自定义查询渠道列表
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    List<Channel> searchChannelList(QueryModel queryModel, ParamObject paramObject);

    /**
     * 自定义条件查询价格名称列表
     *
     * @param paramObject
     * @return
     */
    List<ChannelRateExt> searchRateList(QueryModel queryModel, ParamObject paramObject);

    /**
     * 自定义条件查询价格名称列表
     *
     * @param paramObject
     * @return
     */
    List<ChannelGoodsPriceExt> searchChannelGoodsPriceList(QueryModel queryModel, ParamObject paramObject);

}
