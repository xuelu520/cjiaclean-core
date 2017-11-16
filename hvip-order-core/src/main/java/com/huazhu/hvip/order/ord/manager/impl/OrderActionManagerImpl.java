package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OrderActionDao;
import com.huazhu.hvip.order.ord.manager.OrderActionManager;
import com.huazhu.hvip.order.ord.model.OrderAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-15 19:15
 **/
@Service("orderActionManager")
public class OrderActionManagerImpl extends GenericManagerImpl<OrderAction,Long> implements OrderActionManager {

    private OrderActionDao orderActionDao;

    @Autowired
    public OrderActionManagerImpl(OrderActionDao orderActionDao) {
        super(orderActionDao);
        this.orderActionDao = orderActionDao;
    }
}
