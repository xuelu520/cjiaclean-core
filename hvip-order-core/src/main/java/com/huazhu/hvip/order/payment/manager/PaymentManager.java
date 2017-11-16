/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PaymentManager.java
 * Author:   HUQIANBO001
 * Date:     2016-04-05 11:00:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-05 11:00:48><version><desc>
 */

package com.huazhu.hvip.order.payment.manager;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.payment.model.Payment;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface PaymentManager extends GenericManager<Payment, Long> {

    /**
     * 修改支付单及订单状态为已付款
     *
     * @param payment
     * @return
     */
    ReturnObject updatePaymentAndOrderToPaid(Payment payment);
}
