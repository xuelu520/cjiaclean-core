/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RefundLogsManagerImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-04-08 13:58:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-08 13:58:13><version><desc>
 */

package com.huazhu.hvip.order.payment.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OrderActionDao;
import com.huazhu.hvip.order.ord.dao.OrderDao;
import com.huazhu.hvip.order.ord.dao.OrderItemsDao;
import com.huazhu.hvip.order.payment.dao.PaymentDao;
import com.huazhu.hvip.order.payment.dao.RefundLogsDao;
import com.huazhu.hvip.order.payment.manager.RefundLogsManager;
import com.huazhu.hvip.order.payment.model.RefundLogs;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("refundLogsManager")
public class RefundLogsManagerImpl extends GenericManagerImpl<RefundLogs, Long> implements RefundLogsManager {

    private static Logger logger = LogManager.getLogger(RefundLogsManagerImpl.class);

    private RefundLogsDao refundLogsDao;

    @Autowired
    public RefundLogsManagerImpl(RefundLogsDao refundLogsDao) {
        super(refundLogsDao);
        this.refundLogsDao = refundLogsDao;
    }

    private OrderDao orderDao;
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    private OrderItemsDao orderItemsDao;
    @Autowired
    public void setOrderItemsDao(OrderItemsDao orderItemsDao) {
        this.orderItemsDao = orderItemsDao;
    }

    private OrderActionDao orderActionDao;
    @Autowired
    public void setOrderActionDao(OrderActionDao orderActionDao) {
        this.orderActionDao = orderActionDao;
    }

    private PaymentDao paymentDao;
    @Autowired
    public void setPaymentDao(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }




}
