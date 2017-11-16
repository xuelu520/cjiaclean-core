package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.model.OperatorInfo;

import java.io.Serializable;

/**
 * Created by HUQIANBO001 on 2016/3/31.
 */
public class UpdateOrderStatusVO implements Serializable {

    private String orderSn; //订单唯一号
    private OrderStatus orderStatus; //状态枚举
    private OperatorInfo operatorInfo; //操作人信息
    private OrderExtInfo orderExtInfo; //扩展信息，可用作与订单的实际到货信息
    private String payType; //支付方式
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo) {
        this.operatorInfo = operatorInfo;
    }

    public OrderExtInfo getOrderExtInfo() {
        return orderExtInfo;
    }

    public void setOrderExtInfo(OrderExtInfo orderExtInfo) {
        this.orderExtInfo = orderExtInfo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
