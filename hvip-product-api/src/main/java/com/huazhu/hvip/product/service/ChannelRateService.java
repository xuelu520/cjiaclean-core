/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsService.java
 * Author:   chenli
 * Date:     2016-03-21 17:05:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-21 17:05:06> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.product.vo.ChannelVO;
import com.huazhu.hvip.product.vo.ChannelrateVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface ChannelRateService {

    /**
     *保存价格渠道的定义
     * @param channelrateVOs
     * @return
     */
    ReturnObject saveChannelRate(List<ChannelrateVO> channelrateVOs);

    /**
     * 根据channelObjectId查询价格渠道的定义名称
     * @param channelObjectId
     * @return
     */
    ReturnObject searchChannelRateBychannelObjectId(String channelObjectId);
}
