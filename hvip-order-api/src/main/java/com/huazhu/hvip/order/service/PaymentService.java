package com.huazhu.hvip.order.service;

import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.order.vo.MemberInfoVO;
import com.huazhu.hvip.order.vo.PayCallBackVO;
import com.huazhu.hvip.order.vo.PaymentVO;

/**
 * Created by HUQIANBO001 on 2016/4/5.
 */
public interface PaymentService {

    /**
     * 创建支付单
     *
     * @param orderSn 订单唯一号
     * @param memberInfoVO 会员信息
     * @return
     */
    ReturnObject<PaymentVO> createPayment(String orderSn,MemberInfoVO memberInfoVO);


    /**
     * 门店员工操作付款
     *
     * @param orderSn 订单唯一号
     * @param operatorInfo 门店员工信息
     * @return
     */
    ReturnObject<PaymentVO> createPayment(String orderSn,OperatorInfo operatorInfo);

    /**
     * 支付回调，改变支付单状态及订单状态
     *
     * @param payCallBackVO
     * @return
     */
    ReturnObject<PaymentVO> paymentCallBack(PayCallBackVO payCallBackVO);

    /**
     * 查询支付单
     * @param orderId
     * @return
     */
    ReturnObject<PaymentVO> serachPayMentByOrderId(Long orderId);

}
