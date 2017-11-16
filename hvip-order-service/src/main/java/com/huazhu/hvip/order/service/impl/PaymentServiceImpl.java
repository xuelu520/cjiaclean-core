/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PaymentServiceImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-04-05 10:58:09
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-05 10:58:09><version><desc>
 */

package com.huazhu.hvip.order.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.payment.manager.PaymentManager;
import com.huazhu.hvip.order.payment.model.Payment;
import com.huazhu.hvip.order.service.PaymentService;
import com.huazhu.hvip.order.vo.*;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    private static Logger logger = LogManager.getLogger(PaymentServiceImpl.class);

    private PaymentManager paymentManager;

    @Autowired
    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    private OrderManager orderManager;

    @Autowired
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    private SerialNumService serialNumService;

    @Autowired
    public void setSerialNumService(SerialNumService serialNumService) {
        this.serialNumService = serialNumService;
    }

    /**
     * 创建支付单
     *
     * @param orderSn      订单唯一号
     * @param memberInfoVO 会员信息
     * @return
     */
    @Override
    public ReturnObject<PaymentVO> createPayment(String orderSn, MemberInfoVO memberInfoVO) {
        logger.info("call createPayment({\"orderSn\":" + orderSn + "},{\"memberInfoVO:\"" + JsonUtil.JSON_Bean2String(memberInfoVO) + "})");

        ReturnObject<PaymentVO> returnObject = new ReturnObject<>();
        PaymentVO paymentVO = null;

        try {

            if (StringUtils.isBlank(orderSn)) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("创建支付单失败，订单唯一号为空");

                return returnObject;
            }

            ParamObject paramObject = new ParamObject();
            paramObject.add("orderSn", orderSn);
            List<OrderExt> orderExtList = orderManager.getOrderDetail(paramObject);

            if (orderExtList == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("创建支付单失败，找不到该订单，orderSn:" + orderSn);

                return returnObject;
            }
            OrderExt orderExt=orderExtList.get(0);
            if (null == memberInfoVO || !memberInfoVO.getMemberId().equals(orderExt.getMemberId())) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("订单不是当前用户的");
                return returnObject;
            } else if (!Constants.ORDER_PAYSTATUS_WAITPAY.equals(orderExt.getStatus())) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("当前订单不可支付");
                return returnObject;
            }

            //创建支付单
            Payment payment = savePayment(memberInfoVO, orderExt);

            paymentVO = new PaymentVO();
            BeanUtils.copyProperties(payment, paymentVO);

            //订单信息
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(orderExt, orderVO);
            List<OrderItemsVO> orderItemsVOList = new ArrayList<>();
            OrderItemsVO orderItemsVO = null;
            List<OrderItems> orderItemsList = orderExt.getOrderItemsList();
            for (OrderItems orderItems : orderItemsList) {
                orderItemsVO = new OrderItemsVO();
                BeanUtils.copyProperties(orderItems, orderItemsVO);
                orderItemsVOList.add(orderItemsVO);
            }
            orderVO.setOrderItemsVOList(orderItemsVOList);

            paymentVO.setOrderVO(orderVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("创建支付单成功");

        } catch (Exception e) {
            logger.error("创建支付单失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("创建支付单失败");
        }

        returnObject.setData(paymentVO);

        return returnObject;
    }

    /**
     * 支付回调，改变支付单状态及订单状态
     *
     * @param payCallBackVO
     * @return
     */
    @Override
    public ReturnObject<PaymentVO> paymentCallBack(PayCallBackVO payCallBackVO) {
        logger.info("call paymentCallBack({\"payCallBackVO\":" + JsonUtil.JSON_Bean2String(payCallBackVO) + "})");

        ReturnObject<PaymentVO> returnObject = new ReturnObject<>();
        PaymentVO paymentVO = null;

        try {
            String paymentSn = payCallBackVO.getPaymentSn();
            Double totalAmount = payCallBackVO.getTotalAmount();
            Double payAmount = payCallBackVO.getPayAmount();
            Double payPoint = payCallBackVO.getPayPoint();

            if (StringUtils.isBlank(paymentSn)) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("更新支付单失败，支付单号为空");

                return returnObject;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("paymentSn", paymentSn);
            Payment payment = paymentManager.getUniqueResult(queryModel);

            if (payment == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("更新支付单失败，找不到该支付单，paymentSn:" + paymentSn);

                return returnObject;
            }

            if (0 != totalAmount.compareTo(payment.getAmount().doubleValue())) {
                // 请求的金额不相等
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("支付单存在异常,请求的金额不相等");
                return returnObject;
            }

            if (payment.getStatus().equals(Constants.PAYMENT_STATUS_WAITPAY)) {
                payment.setStatus(Constants.PAYMENT_STATUS_PAID);
                payment.setRealAmount(new BigDecimal(payAmount));
                if(payPoint!=null){
                    payment.setRealPoint(new BigDecimal(payPoint));
                }
                payment.setPayMethod(payCallBackVO.getPayMethod());
                payment.setBillNo(payCallBackVO.getBillNo());
                payment.setPayRequest(payCallBackVO.getPayRequest());
                payment.setPayResponse(payCallBackVO.getPayResponse());
                payment.setRemark(payCallBackVO.getRemark());

                payment.setUpdateTime(new Date());
                payment.setUpdateUser("paymentCallBack");

                returnObject = paymentManager.updatePaymentAndOrderToPaid(payment);

            } else {
                logger.error("更新支付单失败:" + payment.getStatus());
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
                returnObject.setReturnMsg("更新支付单失败,当前支付单不能支付");
            }

            paymentVO = new PaymentVO();
            BeanUtils.copyProperties(payment,paymentVO);

            returnObject.setData(paymentVO);

        } catch (Exception e) {
            logger.error("更新支付单失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("更新支付单失败");
        }

        return returnObject;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @Override
    public ReturnObject<PaymentVO> serachPayMentByOrderId(Long orderId) {
        logger.info("call serachPayMentByOrderId({\"orderId\":" + orderId + "})");
        List<PaymentVO> paymentVOList=new ArrayList<>();
        ReturnObject returnObject=new ReturnObject();
        try {
            if(orderId!=null){
                QueryModel queryModel=new QueryModel();
                queryModel.addColumnValueCondition("orderId",orderId);
                List<Payment> paymentList=paymentManager.search(queryModel);
                if(CheckUtil.checkListIsNull(paymentList)){
                    for(Payment payment:paymentList){
                        PaymentVO paymentVO=new PaymentVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(payment,paymentVO);
                        paymentVOList.add(paymentVO);
                    }
                }
            }
            returnObject.setDataList(paymentVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.info("call serachPayMentByOrderId error({})", e);
        }
        return returnObject;
    }

    /**
     * 生成支付单
     *
     * @param memberInfoVO
     * @param orderExt
     * @return
     */
    private Payment savePayment(MemberInfoVO memberInfoVO, OrderExt orderExt) {
        Date nowDate = new Date();

        Payment payment = new Payment();
        payment.setOrderId(orderExt.getOrderId()); //订单id
        String paymentSn = serialNumService.generatePaymentSn();
        payment.setPaymentSn(paymentSn); //订单唯一流水号
        payment.setMemberId(memberInfoVO.getMemberId());
        payment.setPayMemberName(memberInfoVO.getName());
        payment.setAmount(orderExt.getOrderAmount());
        //payment.setRealAmount(orderExt.getOrderAmount());
        payment.setPayTime(nowDate);
        payment.setPayType(Constants.PAYMENT_TYPE_ONLINE);
        payment.setStatus(Constants.PAYMENT_STATUS_WAITPAY);

        payment.setCreateTime(nowDate);
        payment.setCreateUser(memberInfoVO.getName());
        payment.setUpdateTime(nowDate);
        payment.setUpdateUser(memberInfoVO.getName());

        paymentManager.save(payment);

        return payment;
    }


    /**
     * 门店员工操作付款
     *
     * @param orderSn      订单唯一号
     * @param operatorInfo 门店员工信息
     * @return
     */
    @Override
    public ReturnObject<PaymentVO> createPayment(String orderSn, OperatorInfo operatorInfo) {
        logger.info("call createPayment({\"orderSn\":" + orderSn + "},{\"operatorInfo:\"" + JsonUtil.JSON_Bean2String(operatorInfo) + "})");

        ReturnObject<PaymentVO> returnObject = new ReturnObject<>();
        PaymentVO paymentVO = null;
        try {
            if (StringUtils.isBlank(orderSn)) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("创建支付单失败，订单唯一号为空");
                return returnObject;
            }
            ParamObject paramObject = new ParamObject();
            paramObject.add("orderSn", orderSn);
            List<OrderExt> orderExtList = orderManager.getOrderDetail(paramObject);
            if (orderExtList == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("创建支付单失败，找不到该订单，orderSn:" + orderSn);
                return returnObject;
            }
            OrderExt orderExt=orderExtList.get(0);
            if (!Constants.ORDER_PAYSTATUS_WAITPAY.equals(orderExt.getStatus())) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("当前订单不可支付");
                return returnObject;
            }
            //创建支付单
            Payment payment = savePayment(operatorInfo, orderExt);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("创建支付单成功");
        } catch (Exception e) {
            logger.error("创建支付单失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("创建支付单失败");
        }
        returnObject.setData(paymentVO);
        return returnObject;
    }

    /**
     * 生成支付单
     *
     * @param operatorInfo
     * @param orderExt
     * @return
     */
    private Payment savePayment(OperatorInfo operatorInfo, OrderExt orderExt) {
        Date nowDate = new Date();

        Payment payment = new Payment();
        payment.setOrderId(orderExt.getOrderId()); //订单id
        String paymentSn = serialNumService.generatePaymentSn();
        payment.setPaymentSn(paymentSn); //订单唯一流水号
        payment.setMemberId(orderExt.getMemberId());
        payment.setPayMemberName(orderExt.getMemberName());
        payment.setAmount(orderExt.getOrderAmount());
        //payment.setRealAmount(orderExt.getOrderAmount());
        payment.setPayTime(nowDate);
        payment.setPayType(Constants.PAYMENT_TYPE_STORE);
        payment.setStatus(Constants.PAYMENT_STATUS_PAID);
        payment.setPayMethod(Constants.ASSTYPE_CASH);

        payment.setCreateTime(nowDate);
        payment.setCreateUser(operatorInfo.getOperatorName());
        payment.setUpdateTime(nowDate);
        payment.setUpdateUser(operatorInfo.getOperatorName());

        paymentManager.save(payment);

        return payment;
    }
}
