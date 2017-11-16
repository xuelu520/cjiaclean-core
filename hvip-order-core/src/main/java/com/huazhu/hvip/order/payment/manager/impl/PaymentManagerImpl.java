/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PaymentManagerImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-04-05 11:01:57
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-05 11:01:57><version><desc>
 */

package com.huazhu.hvip.order.payment.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OrderActionDao;
import com.huazhu.hvip.order.ord.dao.OrderDao;
import com.huazhu.hvip.order.ord.dao.OrderItemsDao;
import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.OrderAction;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.payment.dao.PaymentDao;
import com.huazhu.hvip.order.payment.manager.PaymentManager;
import com.huazhu.hvip.order.payment.model.Payment;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("paymentManager")
public class PaymentManagerImpl extends GenericManagerImpl<Payment, Long> implements PaymentManager {

    private static Logger logger = LogManager.getLogger(PaymentManagerImpl.class);

    private PaymentDao paymentDao;

    @Autowired
    public PaymentManagerImpl(PaymentDao paymentDao) {
        super(paymentDao);
        this.paymentDao = paymentDao;
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

    /**
     * 修改支付单及订单状态为已付款
     *
     * @param payment
     * @return
     */
    @Transactional
    @Override
    public ReturnObject updatePaymentAndOrderToPaid(Payment payment) {
        logger.info("call updatePaymentAndOrder({\"payment:\"" + JsonUtil.JSON_Bean2String(payment) + "})");

        ReturnObject returnObject = new ReturnObject();

        Order order = orderDao.get(payment.getOrderId());
        if(order == null){
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("未查询到订单信息，订单id："+payment.getOrderId());
            return returnObject;
        }

        //修改支付单状态
        paymentDao.save(payment);

        //修改订单状态
        String desc = "订单(id:" + order.getOrderId() + ")从状态 " + order.getStatus() + " 变为" + Constants.PAYMENT_STATUS_PAID;

        order.setStatus(Constants.PAYMENT_STATUS_PAID);
        order.setPayStatus(Constants.ORDER_PAYSTATUS_PAID);

        Date nowDate = new Date();

        order.setPayTime(nowDate);
        order.setUpdateTime(nowDate);
        //order.setUpdateUser(payment.getUpdateUser());

        order = orderDao.save(order);

        //修改订单货物状态
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("orderId",order.getOrderId());
        List<OrderItems> orderItemsList = orderItemsDao.search(queryModel);
        for (OrderItems orderItems : orderItemsList){
            if(!Constants.PAYMENT_STATUS_WAITPAY.equals(orderItems.getStatus())){
                continue;
            }
            orderItems.setStatus(Constants.PAYMENT_STATUS_PAID);
            orderItems.setUpdateTime(nowDate);
            //orderItems.setUpdateUser(payment.getUpdateUser());

            orderItemsDao.save(orderItems);
        }


        //保存订单操作记录
        OrderAction orderAction = new OrderAction();
        orderAction.setOrderId(order.getOrderId());
        orderAction.setActionType(Constants.PAYMENT_STATUS_PAID);
        orderAction.setDescription(desc);
        orderAction.setOpName(payment.getUpdateUser());
        orderAction.setMessage(payment.getRemark());
        orderAction.setOpTime(nowDate);

        orderActionDao.save(orderAction);

        returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        returnObject.setReturnMsg("更新支付单及订单成功");

        return returnObject;
    }



}
