/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelRateManager.java
 * Author:   lijing
 * Date:     2016-03-14 15:40:21
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:40:21> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.channel.model.ChannelRate;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ChannelRateManager extends GenericManager<ChannelRate, Long>{

    /**
     * 查询ChannelRate
     * @param paramObject
     * @return
     */
    public List<ChannelRate> searchChannelRateList(ParamObject paramObject);

    /**
     * 根据channelObjectId查询价格渠道的定义名称
     *
     * @param paramObject
     * @return
     */
    List<ChannelRate> searchChannelRateBychannelObjectId(ParamObject paramObject);
}
