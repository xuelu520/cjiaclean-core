/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelControlPriceManagerItemImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-06-13 17:04:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-06-13 17:04:37><version><desc>
 */

package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelControlPriceItemDao;
import com.huazhu.hvip.operation.manager.HotelControlPriceItemManager;
import com.huazhu.hvip.operation.model.HotelControlPriceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("hotelControlPriceItemManager")
public class HotelControlPriceManagerItemImpl extends GenericManagerImpl<HotelControlPriceItem, Long> implements HotelControlPriceItemManager {

    private HotelControlPriceItemDao hotelControlPriceItemDao;

    @Autowired
    public HotelControlPriceManagerItemImpl(HotelControlPriceItemDao hotelControlPriceItemDao) {
        super(hotelControlPriceItemDao);
        this.hotelControlPriceItemDao = hotelControlPriceItemDao;
    }

}
