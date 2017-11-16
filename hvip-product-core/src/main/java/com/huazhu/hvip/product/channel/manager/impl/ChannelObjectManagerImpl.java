/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelObjectManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-14 15:49:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:49:52> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.channel.dao.ChannelGoodsPriceDao;
import com.huazhu.hvip.product.channel.dao.ChannelObjectDao;
import com.huazhu.hvip.product.channel.dao.ChannelRateDao;
import com.huazhu.hvip.product.channel.manager.ChannelObjectManager;
import com.huazhu.hvip.product.channel.model.ChannelGoodsPrice;
import com.huazhu.hvip.product.channel.model.ChannelObject;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("channelObjectManager")
public class ChannelObjectManagerImpl extends GenericManagerImpl<ChannelObject, Long> implements ChannelObjectManager {

    ChannelObjectDao channelObjectDao;


    @Autowired
    public ChannelObjectManagerImpl(ChannelObjectDao channelObjectDao) {
        super(channelObjectDao);
        this.channelObjectDao = channelObjectDao;
    }

    @Autowired
    private ChannelRateDao channelRateDao;

    @Autowired
    private ChannelGoodsPriceDao channelGoodsPriceDao;

    /**
     * 根据objectId查询渠道里面明细对象
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelObject> searchChannelObjectList(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("objectId", paramObject.getLongParam("objectId"));
        queryModel.addColumnValueCondition("channelId", paramObject.getLongParam("channelId"));
        return channelObjectDao.search(queryModel);
    }

    /**
     * 保存对象
     *
     * @param paramObject
     */
    @Override
    public void saveHotelDIYChannel(ParamObject paramObject) {
        String userName = paramObject.getStringParam("userName");
        Long goodsId = paramObject.getLongParam("goodsId");
        String hotelName = paramObject.getStringParam("hotelName");
        BigDecimal costPrice = (BigDecimal) paramObject.getParam("costPrice");
        BigDecimal onlinePrice = (BigDecimal) paramObject.getParam("onlinePrice");
        BigDecimal offlinePrice = (BigDecimal) paramObject.getParam("offlinePrice");
        QueryModel queryModel = new QueryModel();
        List<String> channelObjectIdList = new ArrayList<>();
        List<String> rateIdList = new ArrayList<>();
        List<ChannelObject> channelObjects = (List<ChannelObject>) paramObject.getParam("channelObjects");
        List<ChannelRate> channelRateList = new ArrayList<>();
        List<ChannelObject> channelObjectList = new ArrayList<>();
        for (ChannelObject channelObject : channelObjects) {
            ChannelObject channelObject1 = channelObjectDao.save(channelObject);
            channelObjectList.add(channelObject);
            channelRateList.add(setChannelRateVOPramgram(channelObject1, paramObject.getStringParam("userName")));
            channelObjectIdList.add(channelObject1.getChannelObjectId().toString());
        }
        queryModel = new QueryModel();
        String channelObjectId = StringUtils.join(channelObjectIdList, ",");
        queryModel.addHqlCondition(" channelObjectId in (" + channelObjectId + ")");
        List<ChannelRate> channelRates = channelRateDao.search(queryModel);
        if (channelRates != null && channelRates.size() != 0) {//存在的情况
            for (ChannelRate channelRate : channelRates) {
                for (ChannelRate channelRate1 : channelRateList) {
                    if (channelRate.getChannelObjectId() == channelRate1.getChannelObjectId()) {
                        channelRate1.setRateId(channelRate.getRateId());
                        channelRate1.setCreateTime(channelRate.getCreateTime());
                        break;
                    }
                }
            }
        }
        List<ChannelRate> channelRateList1 = new ArrayList<>();
        for (ChannelRate channelRate : channelRateList) {//保存channelRate
            ChannelRate channelRate1 = channelRateDao.save(channelRate);
            channelRateList1.add(channelRate1);
        }
        List<ChannelGoodsPrice> channelGoodsPriceList = new ArrayList<>();
        for (ChannelRate channelRate : channelRateList1) {//查出保存后的rateId
            channelGoodsPriceList.add(setChannelGoodsPriceVOParagram(channelRate, userName, goodsId, hotelName, costPrice, onlinePrice, offlinePrice));
            rateIdList.add(channelRate.getRateId().toString());
        }
        queryModel = new QueryModel();
        String rateId = StringUtils.join(rateIdList, ",");
        queryModel.addHqlCondition(" rateId in (" + rateId + ")");
        queryModel.addColumnValueCondition("goodsId", goodsId);
        List<ChannelGoodsPrice> channelGoodsPriceList1 = channelGoodsPriceDao.search(queryModel); //查是否有goodprice 有更新 无新增
        if (channelGoodsPriceList1.size() != 0 && channelGoodsPriceList1 != null) {
            for (ChannelGoodsPrice channelGoodsPrice : channelGoodsPriceList1) {
                for (ChannelGoodsPrice channelGoodsPrice1 : channelGoodsPriceList) {
                    if (channelGoodsPrice.getRateId() == channelGoodsPrice1.getRateId()) {
                        channelGoodsPrice1.setCreateTime(channelGoodsPrice.getCreateTime());
                        channelGoodsPrice1.setPriceId(channelGoodsPrice.getPriceId());
                    }
                }
            }
        }
        for (ChannelGoodsPrice channelGoodsPrice : channelGoodsPriceList) {
            channelGoodsPriceDao.save(channelGoodsPrice);
        }
    }

    /**
     * 封装channelRateVo对象
     *
     * @param channelObject
     * @return
     */
    private ChannelRate setChannelRateVOPramgram(ChannelObject channelObject, String userName) {
        ChannelRate channelrateVO = new ChannelRate();
        channelrateVO.setRateName(channelObject.getObjectName());
        channelrateVO.setStatus(Constants.CHANNELOBJECT_STATUS_AVAIL);
        channelrateVO.setChecked(Constants.CHANNELRATE_CODE_PASS);
        channelrateVO.setUpdateTime(new Date());
        channelrateVO.setCreateUser(userName);
        channelrateVO.setUpdateUser(userName);
        if (channelObject.getChannelId().equals(Constants.OPEN_CHANNEL_ONLINE)) {
            channelrateVO.setChannelObjectId(channelObject.getChannelObjectId());
            channelrateVO.setChannelId(channelObject.getChannelId());
        } else {
            channelrateVO.setChannelObjectId(channelObject.getChannelObjectId());
            channelrateVO.setChannelId(channelObject.getChannelId());
        }
        return channelrateVO;
    }

    /**
     * 设置channelgoodPrice属性
     *
     * @param channelRate
     * @param userName
     * @param goodsId
     * @param hotelName
     * @param costPrice
     * @param onlinePrice
     * @param offlinePrice
     * @return
     */
    private ChannelGoodsPrice setChannelGoodsPriceVOParagram(ChannelRate channelRate
            , String userName, Long goodsId, String hotelName
            , BigDecimal costPrice, BigDecimal onlinePrice, BigDecimal offlinePrice) {
        ChannelGoodsPrice channelGoodsPrice = new ChannelGoodsPrice();
        channelGoodsPrice.setRateName(hotelName);
        channelGoodsPrice.setGoodsId(goodsId);
        channelGoodsPrice.setRateId(channelRate.getRateId());
        channelGoodsPrice.setBillPrice(costPrice);
        channelGoodsPrice.setUpdateTime(new Date());
        channelGoodsPrice.setUpdateUser(userName);
        channelGoodsPrice.setCreateUser(userName);
        if (channelRate.getChannelId().toString().equals(Constants.OPEN_CHANNEL_ONLINE)) {
            channelGoodsPrice.setSellPrice(onlinePrice);
        } else if (channelRate.getChannelId().toString().equals(Constants.OPEN_CHANNEL_OFFLINE)) {
            channelGoodsPrice.setSellPrice(offlinePrice);
        }
        return channelGoodsPrice;
    }
}
