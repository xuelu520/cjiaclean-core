/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelRateManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-14 15:50:34
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:50:34> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.channel.dao.ChannelRateDao;
import com.huazhu.hvip.product.channel.manager.ChannelRateManager;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("channelRateManager")
public class ChannelRateManagerImpl extends GenericManagerImpl<ChannelRate, Long> implements ChannelRateManager {

    ChannelRateDao channelRateDao;

    @Autowired
    public ChannelRateManagerImpl(ChannelRateDao channelRateDao) {
        super(channelRateDao);
        this.channelRateDao = channelRateDao;
    }

    /**
     * 查询ChannelRate
     *
     * @param para
     * @return
     */
    @Override
    public List<ChannelRate> searchChannelRateList(ParamObject para) {
        List<ChannelRate> list = null;

        Long channelObjectId = para.getLongParam("channelObjectId");
        QueryModel queryModel = new QueryModel();

        if (channelObjectId == null) {
            queryModel.addHqlCondition(" cr.channelObjectId IS NULL ");
        }

        list = channelRateDao.searchChannelRateList(queryModel, para);

        return list;
    }

    /**
     * 根据channelObjectId查询价格渠道的定义名称
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelRate> searchChannelRateBychannelObjectId(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        queryModel.addColumnValueCondition("channelObjectId",paramObject.getStringParam("channelObjectId"));
        List<ChannelRate>channelRates=channelRateDao.search(queryModel);
        return channelRates;
    }
}
