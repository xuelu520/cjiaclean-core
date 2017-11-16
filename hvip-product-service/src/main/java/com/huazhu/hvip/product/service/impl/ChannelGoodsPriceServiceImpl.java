/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceServiceImpl.java
 * Author:   lijing
 * Date:     2016-04-08 15:15:27
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-08 15:15:27> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import antlr.StringUtils;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.channel.manager.ChannelGoodsPriceManager;
import com.huazhu.hvip.product.channel.manager.ChannelRateManager;
import com.huazhu.hvip.product.channel.model.ChannelGoodsPrice;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.request.ChannelGoodsPriceInfo;
import com.huazhu.hvip.product.service.ChannelGoodsPriceService;
import com.huazhu.hvip.product.vo.ChangeStoreInfoVO;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChannelGoodsPriceServiceImpl implements ChannelGoodsPriceService {
    private static Logger logger = LogManager.getLogger(ChannelGoodsPriceServiceImpl.class);

    private ChannelGoodsPriceManager channelGoodsPriceManager;

    @Autowired
    public void setChannelGoodsPriceManager(ChannelGoodsPriceManager channelGoodsPriceManager) {
        this.channelGoodsPriceManager = channelGoodsPriceManager;
    }

    private ChannelRateManager channelRateManager;

    @Autowired
    public void setChannelRate(ChannelRateManager channelRateManager) {
        this.channelRateManager = channelRateManager;
    }

    /**
     * 根据商品id查询商品价格
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<ChannelGoodsPriceVO> searchChannelGoodsPriceByGoodsId(Long goodsId) {
        logger.info("call searchChannelGoodsPriceByGoodsId({\"goodsId:\"" + goodsId + "})");

        ReturnObject<ChannelGoodsPriceVO> ret = new ReturnObject<ChannelGoodsPriceVO>();

        try {
            //查询商品价格
            ParamObject para1 = new ParamObject();
            para1.add("goodsId",goodsId);
            List<ChannelGoodsPrice> priceList = channelGoodsPriceManager.searchChannelGoodsPrice(para1);
            Map<Long,ChannelGoodsPrice> priceMap = new HashMap<Long,ChannelGoodsPrice>();
            if(priceList!=null&&priceList.size()>0) {
                for (ChannelGoodsPrice cgp : priceList) {
                    priceMap.put(cgp.getRateId(), cgp);
                }
            }

            //查询默认价格渠道
            ParamObject para2 = new ParamObject();
            para2.add("channelObjectId",null);
            List<ChannelRate> rateList = channelRateManager.searchChannelRateList(para2);

            //根据默认渠道拼装商品价格数据
            List<ChannelGoodsPrice> list = new ArrayList<ChannelGoodsPrice>();
            if(rateList!=null&&rateList.size()>0){
                for(ChannelRate rate : rateList){
                    Long rateId = rate.getRateId();
                    ChannelGoodsPrice price = priceMap.get(rateId);
                    if(price==null){
                        price = new ChannelGoodsPrice();
                        price.setRateId(rate.getRateId());
                        price.setRateName(rate.getRateName());
                    }
                    list.add(price);
                }
            }

            //将商品价格model转换成VO
            List<ChannelGoodsPriceVO> priceVOList = new ArrayList<ChannelGoodsPriceVO>();
            ChannelGoodsPriceVO priceVO = null;
            for(ChannelGoodsPrice price : list){
                priceVO = new ChannelGoodsPriceVO();
                BeanUtils.copyProperties(price,priceVO);
                priceVOList.add(priceVO);
            }

            ret.setDataList(priceVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 保存商品价格信息
     * @param list
     * @return
     */
    @Override
    public ReturnObject<ChannelGoodsPriceVO> saveGoodsPrice(List<ChannelGoodsPriceInfo> list) {
        logger.info("call addGoodsPrice({\"list:\"" + JsonUtil.JSON_List2String(list) + "})");

        ReturnObject<ChannelGoodsPriceVO> ret = new ReturnObject<ChannelGoodsPriceVO>();

        try {

            List<ChannelGoodsPrice> priceList= null;
            if(list!=null&&list.size()>0){
                priceList = new ArrayList<ChannelGoodsPrice>();
                ChannelGoodsPrice price = null;
                for(ChannelGoodsPriceInfo priceInfo : list){
                    price = new ChannelGoodsPrice();
                    BeanUtils.copyProperties(priceInfo,price);
                    priceList.add(price);
                }
            }

            //批量保存商品价格
            priceList = channelGoodsPriceManager.saveGoodsPrice(priceList);

            List<ChannelGoodsPriceVO> voList = null;
            if(priceList!=null&&priceList.size()>0){
                voList = new ArrayList<ChannelGoodsPriceVO>();
                ChannelGoodsPriceVO priceVO = null;
                for(ChannelGoodsPrice price : priceList){
                    priceVO = new ChannelGoodsPriceVO();
                    BeanUtils.copyProperties(price,priceVO);
                    voList.add(priceVO);
                }
            }

            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }

        return ret;
    }
    /**
     * 根据Id查询商品销售价格
     * @param goodsIds
     * @return
     */
    @Override
    public ReturnObject<ChannelGoodsPriceVO> searchChannelAndPriceByGoodsId(String goodsIds,String hotelNo) {
        logger.info("call searchChannelAndPriceByGoodsId(),param:"+goodsIds);
        ParamObject paramObject=new ParamObject();
        ReturnObject ret=new ReturnObject();
        List<ChannelGoodsPriceVO> channelGoodsPriceVOList= null;
        try {
            paramObject.add("goodsIds", goodsIds);
            paramObject.add("hotelNo",hotelNo);
            channelGoodsPriceVOList = new ArrayList<>();
            List<ChannelGoodsPriceExt> channelGoodsPriceExts=channelGoodsPriceManager.searchChannelAndPriceByGoodsId(paramObject);
            if(channelGoodsPriceExts!=null && channelGoodsPriceExts.size()!=0){
                for(ChannelGoodsPriceExt channelGoodsPriceExt:channelGoodsPriceExts){
                    ChannelGoodsPriceVO channelGoodsPriceVO=new ChannelGoodsPriceVO();
                    BeanUtils.copyProperties(channelGoodsPriceExt,channelGoodsPriceVO);
                    channelGoodsPriceVOList.add(channelGoodsPriceVO);
                }
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setDataList(channelGoodsPriceVOList);
            }else {
                ret.setReturnMsg("没有查到数据");
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            }
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnMsg("查询失败");
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return ret;
    }

    /**
     * 保存酒店申请的信息
     * @param channelGoodsPriceVOs
     * @return
     */
    @Override
    public ReturnObject saveHotelGoodsPrice(List<ChannelGoodsPriceVO> channelGoodsPriceVOs) {
        logger.info("call saveHotelGoodsPrice param("+JsonUtil.JSON_List2String(channelGoodsPriceVOs)+")");
        ReturnObject returnObject=new ReturnObject();
        try {
            for (ChannelGoodsPriceVO channelGoodsPriceVO:channelGoodsPriceVOs){
                ChannelGoodsPrice channelGoodsPrice=new ChannelGoodsPrice();
                BeanUtils.copyProperties(channelGoodsPriceVO,channelGoodsPrice);
                channelGoodsPriceManager.save(channelGoodsPrice);
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("保存失败");
            e.printStackTrace();
            logger.info(e);
        }
        return returnObject;
    }
}
