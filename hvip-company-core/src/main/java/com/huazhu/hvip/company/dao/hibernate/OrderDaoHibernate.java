package com.huazhu.hvip.company.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.company.dao.OrderDao;
import com.huazhu.hvip.company.model.Order;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-11-02 10:32
 **/
@Repository("orderDao")
public class OrderDaoHibernate extends GenericDaoHibernate<Order,Long> implements OrderDao {

    public OrderDaoHibernate() {
        super(Order.class);
    }
}
