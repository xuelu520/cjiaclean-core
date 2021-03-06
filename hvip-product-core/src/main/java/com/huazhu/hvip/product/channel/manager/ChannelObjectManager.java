/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelObjectManager.java
 * Author:   lijing
 * Date:     2016-03-14 15:39:20
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:39:20> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.channel.model.ChannelObject;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ChannelObjectManager extends GenericManager<ChannelObject, Long>{
    /**
     * 根据objectId查询渠道里面明细对象
     *
     * @param paramObject
     * @return
     */
    List<ChannelObject> searchChannelObjectList(ParamObject paramObject);

    void saveHotelDIYChannel(ParamObject paramObject);
}
