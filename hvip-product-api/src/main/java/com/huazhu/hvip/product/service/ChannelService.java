/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsService.java
 * Author:   chenli
 * Date:     2016-03-21 17:05:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-21 17:05:06> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.ChannelGoodsPriceVO;
import com.huazhu.hvip.product.vo.ChannelObjectVO;
import com.huazhu.hvip.product.vo.ChannelVO;
import com.huazhu.hvip.product.vo.ChannelrateVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface ChannelService {
    /**
     * 自定义条件查询渠道
     * @param paramObject
     * @return
     */
    ReturnObject<ChannelVO> searchChannelList(ParamObject paramObject);

    /**
     * 自定义条件查询价格名称列表
     * @param paramObject
     * @return
     */
    ReturnObject<ChannelrateVO> searchRateList(ParamObject paramObject);
    /**
     * 自定义条件查询详细价格列表
     * @param paramObject
     * @return
     */
    ReturnObject<ChannelGoodsPriceVO> searchChannelGoodsPriceList(ParamObject paramObject);

    /**
     * 查询渠道所有类型
     * @return
     */
    ReturnObject<ChannelVO> getTypeListJson();
    /**
     * 保存渠道
     * @param channelVO
     * @return ReturnObject
     */
    ReturnObject<ChannelVO> saveChannel(ChannelVO channelVO);
    /**
     * 根据id删除渠道
     * @param ids 渠道ID
     * @return ret 通用返回参数
     */
    public ReturnObject deleteChannel(Long[] ids);
}
