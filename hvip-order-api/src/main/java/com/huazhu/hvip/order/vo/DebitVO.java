package com.huazhu.hvip.order.vo;

import java.io.Serializable;

/**
 * Created by XUEYONGPING001 on 2016/4/25.
 */
public class DebitVO implements Serializable {

    private String hotelId;
    private String billId;
    private String operatorId;
    private String payNo;
    private String debitSum;
    private String debitType;
    private String memo;
    private Long orderDebitId;

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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getDebitSum() {
        return debitSum;
    }

    public void setDebitSum(String debitSum) {
        this.debitSum = debitSum;
    }

    public String getDebitType() {
        return debitType;
    }

    public void setDebitType(String debitType) {
        this.debitType = debitType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getOrderDebitId() {
        return orderDebitId;
    }

    public void setOrderDebitId(Long orderDebitId) {
        this.orderDebitId = orderDebitId;
    }
}
