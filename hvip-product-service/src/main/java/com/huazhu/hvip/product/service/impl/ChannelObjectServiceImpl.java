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
import com.huazhu.hvip.product.channel.manager.ChannelObjectManager;
import com.huazhu.hvip.product.channel.model.ChannelObject;
import com.huazhu.hvip.product.service.ChannelObjectService;
import com.huazhu.hvip.product.vo.ChannelObjectVO;
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
public class ChannelObjectServiceImpl implements ChannelObjectService {
    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ChannelObjectServiceImpl.class);

    @Autowired
    private ChannelObjectManager channelObjectManager;

    /**
     * 保存channelObjectVO
     *
     * @param channelObjectVOs
     * @return
     */
    @Override
    public ReturnObject saveHotelDIYChannel(List<ChannelObjectVO> channelObjectVOs) {
        logger.info("call saveHotelDIYChannel param(" + JsonUtil.JSON_List2String(channelObjectVOs));
        ReturnObject returnObject = new ReturnObject();
        ParamObject paramObject = new ParamObject();
        List<ChannelObject> channelObjects = new ArrayList<>();
        try {
            for (ChannelObjectVO channelObjectVO : channelObjectVOs) {
                ChannelObject channelObject = new ChannelObject();
                BeanUtils.copyProperties(channelObjectVO, channelObject);
                channelObjects.add(channelObject);
                paramObject.add("userName", channelObjectVO.getUserName());
                paramObject.add("goodsId", channelObjectVO.getGoodsId());
                paramObject.add("hotelName", channelObjectVO.getHotelName());
                paramObject.add("costPrice", channelObjectVO.getCostprice());
                paramObject.add("onlinePrice", channelObjectVO.getOnlinePrice());
                paramObject.add("offlinePrice", channelObjectVO.getOfflinePrice());
            }
            paramObject.add("channelObjects", channelObjects);
            channelObjectManager.saveHotelDIYChannel(paramObject);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            e.printStackTrace();
            returnObject.setReturnMsg("保存失败");
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
        }
        return returnObject;
    }

    /**
     * 根据objectId查询渠道里面明细对象
     *
     * @param channelObjectVO
     * @return
     */
    @Override
    public ReturnObject searchChannelObjectList(ChannelObjectVO channelObjectVO) {
        logger.info("call searchChannelObjectList param:" + JsonUtil.JSON_Bean2String(channelObjectVO));
        ReturnObject returnObject = new ReturnObject();
        try {
            List<ChannelObjectVO> channelObjectVOs=new ArrayList<>();
            ParamObject paramObject = new ParamObject();
            paramObject.add("objectId", channelObjectVO.getObjectId());
            paramObject.add("channelId", channelObjectVO.getChannelId());
            List<ChannelObject> channelObjects = channelObjectManager.searchChannelObjectList(paramObject);
            if(channelObjects.size()!=0&&channelObjects!=null){
                for(ChannelObject channelObject:channelObjects){
                    ChannelObjectVO channelObjectVO1=new ChannelObjectVO();
                    BeanUtils.copyProperties(channelObject,channelObjectVO1);
                    channelObjectVOs.add(channelObjectVO1);
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(channelObjectVOs);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;
    }
}
