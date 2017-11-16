/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelControlPriceDaoHibernate.java
 * Author:   HUQIANBO001
 * Date:     2016-06-13 16:57:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-06-13 16:57:56><version><desc>
 */

package com.huazhu.hvip.operation.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.operation.dao.HotelControlPriceDao;
import com.huazhu.hvip.operation.model.HotelControlPrice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Repository(value = "hotelControlPriceDao")
public class HotelControlPriceDaoHibernate extends GenericDaoHibernate<HotelControlPrice, Long> implements HotelControlPriceDao {

    public HotelControlPriceDaoHibernate() {
        super(HotelControlPrice.class);
    }

}
