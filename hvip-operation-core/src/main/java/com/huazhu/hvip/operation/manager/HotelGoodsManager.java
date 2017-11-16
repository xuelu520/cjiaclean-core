/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelGoodsManager.java
 * Author:   chenli
 * Date:     2016-03-23 17:28:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:28:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.operation.model.HotelGoods;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface HotelGoodsManager extends GenericManager<HotelGoods, Long> {

    /**
     * 更新酒店商品
     *
     * @param paramObject
     * @return
     */
    public ReturnObject updateOpenGoodsByHotelId(ParamObject paramObject);

    /**
     * 通过商品的Id查询酒店的订单
     * @param paramObject
     * @return
     */
    List<HotelGoods> searchHotelByGoodsId(ParamObject paramObject);

    /**
     * 更改hotelCateId
     * @param paramObject
     */
    void updateCateIdByGoodsId(ParamObject paramObject);
}
