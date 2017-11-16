package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.PaymentlogDao;
import com.huazhu.hvip.order.ord.manager.PaymentlogManager;
import com.huazhu.hvip.order.ord.model.Paymentlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-15 11:15
 **/
@Service("paymentlogManager")
public class PaymentlogManagerImpl extends GenericManagerImpl<Paymentlog,Long> implements PaymentlogManager {

    private PaymentlogDao paymentlogDao;

    @Autowired
    public PaymentlogManagerImpl(PaymentlogDao paymentlogDao) {
        super(paymentlogDao);
        this.paymentlogDao = paymentlogDao;
    }
}
