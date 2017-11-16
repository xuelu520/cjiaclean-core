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
import com.huazhu.hvip.product.channel.manager.ChannelRateManager;
import com.huazhu.hvip.product.channel.model.Channel;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.channel.model.extend.ChannelRateExt;
import com.huazhu.hvip.product.service.ChannelRateService;
import com.huazhu.hvip.product.service.ChannelService;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.product.vo.ChannelVO;
import com.huazhu.hvip.product.vo.ChannelrateVO;
import com.huazhu.hvip.util.JsonUtil;
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
public class ChannelRateServiceImpl implements ChannelRateService {
    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ChannelRateServiceImpl.class);

    @Autowired
    private ChannelRateManager channelRateManager;

    /**
     * 保存价格渠道的定义
     *
     * @param channelrateVOs
     * @return
     */
    @Override
    public ReturnObject saveChannelRate(List<ChannelrateVO> channelrateVOs) {
        logger.info("call saveChannelRate param(" + JsonUtil.JSON_List2String(channelrateVOs) + ")");
        ReturnObject returnObject = new ReturnObject();
        try {
            for (ChannelrateVO channelrateVO : channelrateVOs) {
                ChannelRate channelRate = new ChannelRate();
                BeanUtils.copyProperties(channelrateVO, channelRate);
                channelRateManager.save(channelRate);
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            e.printStackTrace();
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("保存失败");
        }
        return returnObject;
    }

    /**
     * 根据channelObjectId查询价格渠道的定义名称
     *
     * @param channelObjectId
     * @return
     */
    @Override
    public ReturnObject searchChannelRateBychannelObjectId(String channelObjectId) {
        logger.info("call searchChannelRateBychannelObjectId param("+channelObjectId+")");
        ReturnObject returnObject=new ReturnObject();
        try {
            ParamObject paramObject=new ParamObject();
            paramObject.add("channelObjectId",channelObjectId);
            List<ChannelRate> channelRates=channelRateManager.searchChannelRateBychannelObjectId(paramObject);
            returnObject.setDataList(channelRates);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setReturnMsg("查询失败");
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return returnObject;
    }
}
