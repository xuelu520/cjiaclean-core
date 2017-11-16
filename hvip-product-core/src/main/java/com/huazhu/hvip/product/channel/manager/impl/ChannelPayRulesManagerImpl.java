/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelPayRulesManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-14 15:50:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:50:06> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.channel.dao.ChannelPayRulesDao;
import com.huazhu.hvip.product.channel.manager.ChannelPayRulesManager;
import com.huazhu.hvip.product.channel.model.ChannelPayRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("channelPayRulesManager")
public class ChannelPayRulesManagerImpl extends GenericManagerImpl<ChannelPayRules, Long> implements ChannelPayRulesManager {

    ChannelPayRulesDao channelPayRulesDao;

    @Autowired
    public ChannelPayRulesManagerImpl(ChannelPayRulesDao channelPayRulesDao){
        super(channelPayRulesDao);
        this.channelPayRulesDao = channelPayRulesDao;
    }
}
