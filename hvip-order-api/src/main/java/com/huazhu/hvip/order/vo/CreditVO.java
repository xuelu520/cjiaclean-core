package com.huazhu.hvip.order.vo;

import java.io.Serializable;

/**
 * Created by XUEYONGPING001 on 2016/4/25.
 */
public class CreditVO implements Serializable {

    private String hotelId;
    private String billId;
    private String assType;
    private String operatorId;
    private String amount;
    private String payNo;
    private String bizDay;
    private String point;
    private String payType;
    private Long orderDebitId;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getBizDay() {
        return bizDay;
    }

    public void setBizDay(String bizDay) {
        this.bizDay = bizDay;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Long getOrderDebitId() {
        return orderDebitId;
    }

    public void setOrderDebitId(Long orderDebitId) {
        this.orderDebitId = orderDebitId;
    }
}
