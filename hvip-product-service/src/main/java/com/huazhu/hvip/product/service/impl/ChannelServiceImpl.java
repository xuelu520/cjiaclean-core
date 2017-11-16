/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelServiceImpl.java
 * Author:   cmy
 * Date:     2016-04-13 14:12:17
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-13 14:12:17> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.channel.manager.ChannelManager;
import com.huazhu.hvip.product.channel.model.Channel;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.channel.model.extend.ChannelRateExt;
import com.huazhu.hvip.product.service.ChannelService;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.product.vo.ChannelObjectVO;
import com.huazhu.hvip.product.vo.ChannelVO;
import com.huazhu.hvip.product.vo.ChannelrateVO;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ChannelServiceImpl.class);

    @Autowired
    private ChannelManager channelManager;

    /**
     * 根据自定的条件查询渠道列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<ChannelVO> searchChannelList(ParamObject paramObject) {
        ReturnObject<ChannelVO> ret = new ReturnObject();
        try {
            logger.info("call searchChannelList()");
            List<Channel> list = channelManager.searchChannelList(paramObject);
            List<ChannelVO> voList = new ArrayList<>();
            for (Channel channel : list) {
                ChannelVO channelVO = new ChannelVO();
                BeanUtils.copyProperties(channel, channelVO);
                voList.add(channelVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 自定义条件查询价格名称列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<ChannelrateVO> searchRateList(ParamObject paramObject) {
        ReturnObject<ChannelrateVO> ret = new ReturnObject();
        try {
            logger.info("call searchRateList()");
            List<ChannelRateExt> list = channelManager.searchRateList(paramObject);
            List<ChannelrateVO> voList = new ArrayList<>();
            for (ChannelRateExt channelRateExt : list) {
                ChannelrateVO channelrateVO = new ChannelrateVO();
                BeanUtils.copyProperties(channelRateExt, channelrateVO);
                voList.add(channelrateVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    @Override
    public ReturnObject<ChannelGoodsPriceVO> searchChannelGoodsPriceList(ParamObject paramObject) {
        ReturnObject<ChannelGoodsPriceVO> ret = new ReturnObject();
        try {
            logger.info("call searchChannelGoodsPriceList()");
            List<ChannelGoodsPriceExt> list = channelManager.searchChannelGoodsPriceList(paramObject);
            List<ChannelGoodsPriceVO> voList = new ArrayList<>();
            for (ChannelGoodsPriceExt channelGoodsPriceExt : list) {
                ChannelGoodsPriceVO channelGoodsPriceVO = new ChannelGoodsPriceVO();
                BeanUtils.copyProperties(channelGoodsPriceExt, channelGoodsPriceVO);
                voList.add(channelGoodsPriceVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 查询渠道所有类型
     *
     * @return
     */
    @Override
    public ReturnObject<ChannelVO> getTypeListJson(){
        ReturnObject<ChannelVO> ret = new ReturnObject();
        try {
            List<Channel> channelList = channelManager.getTypeListJson();
            List<ChannelVO> voList = new ArrayList<>();
            for (Channel channel : channelList) {
                ChannelVO channelVO = new ChannelVO();
                BeanUtils.copyProperties(channel, channelVO);
                voList.add(channelVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }
    /**
     * 保存渠道
     * @param channelVO
     * @return ReturnObject
     */
    @Override
    public ReturnObject<ChannelVO> saveChannel(ChannelVO channelVO){
        ReturnObject<ChannelVO> ret=new ReturnObject<ChannelVO>();
        try{
            Channel channel=new Channel();
            BeanUtils.copyProperties(channelVO,channel);
            Channel channel1=channelManager.save(channel);
            ChannelVO channelVO1=new ChannelVO();
            BeanUtils.copyProperties(channel1,channelVO1);
            ret.setData(channelVO1);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }
    /**
     * 根据id删除渠道
     * @param ids 渠道ID
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject deleteChannel(Long[] ids) {
        logger.info("call deleteChannel({\"ids:\"" + ids.toString() + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ParamObject paramObject = new ParamObject();
            String id= StringUtils.join(ids, ",");
            paramObject.add("id",id);
            channelManager.deleteChannel(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除渠道成功");
        } catch (Exception e) {
            logger.error("删除渠道失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除渠道失败");
        }

        return ret;
    }
}
