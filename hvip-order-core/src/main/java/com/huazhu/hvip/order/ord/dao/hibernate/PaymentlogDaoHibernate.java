package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.ord.dao.PaymentlogDao;
import com.huazhu.hvip.order.ord.model.Paymentlog;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-15 11:16
 **/
@Repository("paymentlogDao")
public class PaymentlogDaoHibernate extends GenericDaoHibernate<Paymentlog,Long> implements PaymentlogDao {
    public PaymentlogDaoHibernate() {
        super(Paymentlog.class);
    }
}
