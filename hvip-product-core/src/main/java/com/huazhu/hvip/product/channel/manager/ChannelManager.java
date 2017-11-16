/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelManager.java
 * Author:   chenli
 * Date:     2016-03-20 17:21:11
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 17:21:11> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.channel.model.Channel;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.channel.model.extend.ChannelRateExt;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ChannelManager extends GenericManager<Channel, Long> {
    /**
     * 自定义查询渠道列表
     *
     * @param paramObject
     * @return
     */
    List<Channel> searchChannelList(ParamObject paramObject);

    /**
     * 自定义条件查询价格名称列表
     *
     * @param paramObject
     * @return
     */
    List<ChannelRateExt> searchRateList(ParamObject paramObject);

    /**
     * 自定义条件查询详细价格列表
     *
     * @param paramObject
     * @return
     */
    List<ChannelGoodsPriceExt> searchChannelGoodsPriceList(ParamObject paramObject);

    /**
     * 查询渠道所有类型
     *
     * @return
     */
    List<Channel> getTypeListJson();
    /**
     * 根据id删除渠道
     * @param paramObject 渠道ID
     * @return count
     */
    public void deleteChannel(ParamObject paramObject);
}