package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.constants.Constants;

/**
 * Created by HUQIANBO001 on 2016/3/31.
 */
public enum OrderStatus {

    WAITPAY(Constants.ORDER_STATUS_WAITPAY), //待支付
    DON(Constants.ORDER_STATUS_DON), //已完成
    CAL(Constants.ORDER_STATUS_CAL), //取消
    REFUNDING(Constants.ORDER_STATUS_REFUNDING), //退款中
    REFUNDED(Constants.ORDER_STATUS_REFUNDED); //已退款

    private String code;

    public String getCode() {
        return this.code;
    }

    private OrderStatus(String code) {
        this.code = code;
    }

    public String toString() {
        return this.name();
    }

}
