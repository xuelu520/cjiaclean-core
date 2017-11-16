package com.huazhu.hvip.company.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.company.dao.OrderDao;
import com.huazhu.hvip.company.manager.OrderManager;
import com.huazhu.hvip.company.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-11-02 10:31
 **/
@Service("orderManager")
public class OrderManagerImpl extends GenericManagerImpl<Order,Long> implements OrderManager {

    private OrderDao orderDao;

    @Autowired
    public OrderManagerImpl(OrderDao orderDao) {
        super(orderDao);
        this.orderDao = orderDao;
    }
}
