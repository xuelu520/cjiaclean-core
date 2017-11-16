/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderDebitManagerImpl.java
 * Author:   lijing
 * Date:     2016-04-28 10:51:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-28 10:51:48> <version>   <desc>
 *
 */

package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OrderActionDao;
import com.huazhu.hvip.order.ord.dao.OrderDao;
import com.huazhu.hvip.order.ord.dao.OrderDebitDao;
import com.huazhu.hvip.order.ord.manager.OrderDebitManager;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.OrderAction;
import com.huazhu.hvip.order.ord.model.OrderDebit;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("orderDebitManager")
public class OrderDebitManagerImpl extends GenericManagerImpl<OrderDebit,Long>implements OrderDebitManager{

    private OrderDebitDao orderDebitDao;

    @Autowired
    public OrderDebitManagerImpl(OrderDebitDao orderDebitDao){
        super(orderDebitDao);
        this.orderDebitDao = orderDebitDao;
    }

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderActionDao orderActionDao;

    /**
     * 创建订单挂账
     * @param orderDebit
     * @return
     */
    @Override
    public OrderDebit addOrderDebit(OrderDebit orderDebit) {
        orderDebit.setCreateTime(new Date());
        orderDebit.setStatus(Constants.FLAG_TRUE);
        return orderDebitDao.save(orderDebit);
    }
}
