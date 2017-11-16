/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-14 15:50:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:50:22> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.channel.dao.ChannelGoodsPriceDao;
import com.huazhu.hvip.product.channel.manager.ChannelGoodsPriceManager;
import com.huazhu.hvip.product.channel.model.ChannelGoodsPrice;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.goods.model.Frequency;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("ChannelGoodsPriceManager")
public class ChannelGoodsPriceManagerImpl extends GenericManagerImpl<ChannelGoodsPrice, Long> implements ChannelGoodsPriceManager {

    ChannelGoodsPriceDao channelGoodsPriceDao;

    @Autowired
    public ChannelGoodsPriceManagerImpl(ChannelGoodsPriceDao channelGoodsPriceDao){
        super(channelGoodsPriceDao);
        this.channelGoodsPriceDao = channelGoodsPriceDao;
    }

    /**
     * 查询商品价格
     * @param para
     * @return
     */
    @Override
    public List<ChannelGoodsPrice> searchChannelGoodsPrice(ParamObject para) {
        List<ChannelGoodsPrice> list = null;

        QueryModel queryModel = new QueryModel();
        Long goodsId = para.getLongParam("goodsId");

        if(goodsId!=null){
            queryModel.addColumnValueCondition("cgp.goodsId",goodsId);
        }

        list = channelGoodsPriceDao.searchChannelGoodsPrice(queryModel,para);

        return list;
    }

    /**
     * 保存商品价格信息
     * @param list
     * @return
     */
    @Override
    public List<ChannelGoodsPrice> saveGoodsPrice(List<ChannelGoodsPrice> list) {

        List<ChannelGoodsPrice> newList = null;

        if(list!=null&&list.size()>0){
            newList = new ArrayList<ChannelGoodsPrice>();
            for(ChannelGoodsPrice price : list){

                Long priceId = price.getPriceId();
                //新增商品价格
                if(priceId==null){
                    price.setCreateTime(new Date());

                //修改商品价格
                }else{
                    ChannelGoodsPrice price1 = channelGoodsPriceDao.get(priceId);
                    BeanUtils.copyProperties(price,price1);
                    price = price1;
                    price.setUpdateTime(new Date());
                }

                newList.add(channelGoodsPriceDao.save(price));
            }
        }
        return newList;
    }


    /**
     * 根据Id查询商品销售价格
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelGoodsPriceExt> searchChannelAndPriceByGoodsId(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        if(paramObject.getStringParam("goodsIds")!=null){
            queryModel.addHqlCondition("cgp.goodsId in ("+paramObject.getStringParam("goodsIds")+")");
        }
        queryModel.addHqlCondition("cn.channelCode in ('online','store')");
        queryModel.addHqlCondition("cr.channelObjectId is null");
        List<ChannelGoodsPriceExt> channelGoodsPriceExtList=channelGoodsPriceDao.searchChannelAndPriceByGoodsId(queryModel);
        return channelGoodsPriceExtList;
    }
}
