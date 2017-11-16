package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OrderUpdateLogDao;
import com.huazhu.hvip.order.ord.manager.OrderUpdateLogManager;
import com.huazhu.hvip.order.ord.model.OrderUpdateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-11-15 15:24
 **/
@Service("/orderUpdateLogManager")
public class OrderUpdateLogManagerImpl extends GenericManagerImpl<OrderUpdateLog, Long> implements OrderUpdateLogManager {
    private OrderUpdateLogDao orderUpdateLogDao;
    @Autowired
    public OrderUpdateLogManagerImpl(OrderUpdateLogDao orderUpdateLogDao) {
        super(orderUpdateLogDao);
        this.orderUpdateLogDao = orderUpdateLogDao;
    }
}
