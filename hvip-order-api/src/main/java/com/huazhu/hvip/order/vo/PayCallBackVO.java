/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PayCallBackVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-05 15:20:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-05 15:20:22><version><desc>
 */

package com.huazhu.hvip.order.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PayCallBackVO implements Serializable {

    private String paymentSn; //支付单号
    private Double totalAmount; //付款金额
    private Double payAmount; //实际支付金额
    private Double payPoint; //实际支付积分金额
    private String payMethod; //支付方式
    private String payRequest; //支付请求字串
    private String payResponse; //支付相应字串
    private String billNo; //支付回调单号
    private String remark; //备注

    public String getPaymentSn() {
        return paymentSn;
    }

    public void setPaymentSn(String paymentSn) {
        this.paymentSn = paymentSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Double getPayPoint() {
        return payPoint;
    }

    public void setPayPoint(Double payPoint) {
        this.payPoint = payPoint;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getPayRequest() {
        return payRequest;
    }

    public void setPayRequest(String payRequest) {
        this.payRequest = payRequest;
    }

    public String getPayResponse() {
        return payResponse;
    }

    public void setPayResponse(String payResponse) {
        this.payResponse = payResponse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
