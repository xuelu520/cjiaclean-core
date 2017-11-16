package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.ord.dao.OrderUpdateLogDao;
import com.huazhu.hvip.order.ord.model.OrderUpdateLog;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-11-15 15:26
 **/
@Repository("orderUpdateLogDao")
public class OrderUpdateLogDaoHibernate extends GenericDaoHibernate<OrderUpdateLog,Long> implements OrderUpdateLogDao {
    public OrderUpdateLogDaoHibernate() {
        super(OrderUpdateLog.class);
    }
}
