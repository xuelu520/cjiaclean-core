/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-14 15:49:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:49:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.channel.dao.ChannelDao;
import com.huazhu.hvip.product.channel.manager.ChannelManager;
import com.huazhu.hvip.product.channel.model.Channel;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.channel.model.extend.ChannelRateExt;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import javassist.compiler.ast.Keyword;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("channelManager")
public class ChannelManagerImpl extends GenericManagerImpl<Channel, Long> implements ChannelManager {
    private static Logger logger = LogManager.getLogger(ChannelManagerImpl.class);

    ChannelDao channelDao;

    @Autowired
    public ChannelManagerImpl(ChannelDao channelDao) {
        super(channelDao);
        this.channelDao = channelDao;
    }

    /**
     * 自定义查询渠道列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Channel> searchChannelList(ParamObject paramObject) {
        logger.info("call searchChannelList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");
        String keyword = paramObject.getStringParam("keyword");
        Long channelId = paramObject.getLongParam("channelId"); //渠道Id
        String channelSn = paramObject.getStringParam("channelSn");//商品编号
        String channelName = paramObject.getStringParam("channelName"); //渠道 名称
        String channelCode = paramObject.getStringParam("channelCode"); //渠道码
        Long typeId = paramObject.getLongParam("typeId");   //渠道类型
        String status = paramObject.getStringParam("status");   //渠道状态
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();

        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        if (!StringUtil.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (c.channelName LIKE '%" + keyword + "%' OR c.typeId LIKE '%" + keyword + "%') ");
        }
        if (channelSn != null) {
            queryModel.addColumnValueCondition("c.channelSn", channelSn);
        }
        if (channelName != null) {
            queryModel.addHqlCondition(" (c.channelName LIKE '%" + channelName + "%') ");
        }
        if (channelId != null) {
            queryModel.addColumnValueCondition("c.channelId", channelId);
        }

        if (!StringUtil.isEmpty(channelCode)) {
            queryModel.addColumnValueCondition("c.channelCode", channelCode);
        }

        if (typeId != null) {
            queryModel.addColumnValueCondition("c.typeId", typeId);
        }

        if (StringUtils.isNotBlank(status)) {
            queryModel.addColumnValueCondition("c.status", status);
        }

        return channelDao.searchChannelList(queryModel, paramObject);
    }

    /**
     * 自定义条件查询价格名称列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelRateExt> searchRateList(ParamObject paramObject) {
        logger.info("call searchRateList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");
        String keyword = paramObject.getStringParam("keyword");
        Long rateId = paramObject.getLongParam("rateId"); //价格Id
        String channelName = paramObject.getStringParam("channelName");//渠道名称
        String rateName = paramObject.getStringParam("rateName"); //价格名称
        Long channelId = paramObject.getLongParam("channelId");   //渠道类型
        Long activityId = paramObject.getLongParam("activityId"); //活动Id
        String checked = paramObject.getStringParam("checked"); //是否检验
        String payRules = paramObject.getStringParam("payRules"); //支付规则
        String status = paramObject.getStringParam("status");   //状态
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();
        QueryModel queryModel = new QueryModel();
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        if (!StringUtil.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (c.rateName LIKE '%" + keyword + "%' OR c1.channelName LIKE '%" + keyword + "%') ");
        }
        if (!StringUtil.isEmpty(channelName)) {
            queryModel.addColumnValueCondition("c.channelName", channelName);
        }
        if (rateId != null) {
            queryModel.addColumnValueCondition("c.rateId", rateId);
        }
        if (!StringUtil.isEmpty(rateName)) {
            queryModel.addHqlCondition(" (c.rateName LIKE '%" + rateName + "%') ");
        }
        if (channelId != null) {
            queryModel.addColumnValueCondition("c.channelId", channelId);
        }
        if (activityId != null) {
            queryModel.addColumnValueCondition("c.activityId", activityId);
        }
        if (!StringUtil.isEmpty(checked)) {
            queryModel.addColumnValueCondition("c.checked", checked);
        }
        if (!StringUtil.isEmpty(payRules)) {
            queryModel.addColumnValueCondition("c.payRules", payRules);
        }
        if (StringUtils.isNotBlank(status)) {
            queryModel.addColumnValueCondition("c.status", status);
        }
        return channelDao.searchRateList(queryModel, paramObject);
    }
    /**
     * 自定义条件查询详细价格列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelGoodsPriceExt> searchChannelGoodsPriceList(ParamObject paramObject) {
        logger.info("call searchChannelGoodsPriceList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");
        String keyword = paramObject.getStringParam("keyword");
        Long priceId = paramObject.getLongParam("priceId"); //价格Id
        Long goodsId = paramObject.getLongParam("goodsId"); //价格Id
        Long productId = paramObject.getLongParam("productId"); //价格Id
        Long rateId = paramObject.getLongParam("rateId"); //价格Id
        String rateName = paramObject.getStringParam("rateName"); //价格名称
        String status = paramObject.getStringParam("status"); //状态
        String goodsName = paramObject.getStringParam("goodsName"); //商品名
        String channelName = paramObject.getStringParam("channelName"); //渠道名称
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();
        QueryModel queryModel = new QueryModel();
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        if (!StringUtil.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (c.rateName LIKE '%" + keyword + "%' OR c2.channelName LIKE '%" + keyword + "%' OR g.goodsName LIKE '%" + keyword + "%') ");
        }
        if (priceId != null) {
            queryModel.addColumnValueCondition("c.priceId", priceId);
        }
        if (goodsId != null) {
            queryModel.addColumnValueCondition("c.goodsId", goodsId);
        }
        if (productId != null) {
            queryModel.addColumnValueCondition("c.productId", productId);
        }
        if (rateId != null) {
            queryModel.addColumnValueCondition("c.rateId", rateId);
        }
        if (!StringUtil.isEmpty(rateName)) {
            queryModel.addColumnValueCondition("c.rateName", rateName);
        }
        if (!StringUtil.isEmpty(status)) {
            queryModel.addColumnValueCondition("c.status", status);
        }
        if (!StringUtil.isEmpty(goodsName)) {
            queryModel.addColumnValueCondition("g.goodsName", goodsName);
        }
        if (!StringUtil.isEmpty(channelName)) {
            queryModel.addColumnValueCondition("c1.goodsName", channelName);
        }
        return channelDao.searchChannelGoodsPriceList(queryModel, paramObject);
    }

    /**
     * 查询渠道所有类型
     *
     * @return
     */
    @Override
    public List<Channel> getTypeListJson() {
        String sql="SELECT * from vip_channel c group by c.typeId";
        return channelDao.searchObject(sql,Channel.class);
    }
    /**
     * 根据id删除渠道
     * @param paramObject 渠道ID
     * @return count
     * 更改deleteFlag状态
     */
    @Override
    public void deleteChannel(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();
        String id = paramObject.getStringParam("id");
        if (StringUtils.isNotEmpty(id)){
            queryModel.addHqlCondition("channelId in ("+id+")");
        }
        queryModel.addHqlCondition("deleteFlag !="+Constants.DELETE_FLAG_TRUE+"");
        List<Channel> channelList = channelDao.search(queryModel);
        for (Channel channel : channelList){
            channel.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
            channelDao.save(channel);
        }
    }
    }
