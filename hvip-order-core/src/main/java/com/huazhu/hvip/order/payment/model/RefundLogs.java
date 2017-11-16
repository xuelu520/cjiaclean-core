/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RefundLogs.java
 * Author:   HUQIANBO001
 * Date:     2016-04-08 11:38:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-08 11:38:51><version><desc>
 */

package com.huazhu.hvip.order.payment.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "vip_refundlogs")
public class RefundLogs extends DynamicField {

    private Long refundId;
    private String refundSn;
    private Long orderId;
    private String orderSn;
    private Long orderItemsId;
    private Long memberId;
    private String paymentSn;
    private String payMemberName;
    private String payType;
    private String payMethod;
    private BigDecimal amount;
    private String refundUser;
    private Date refundTime;
    private String status;
    private String remark;
    private String refundRequest;
    private String refundResponse;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "refundId")
    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }


    @Basic
    @Column(name = "refundSn")
    public String getRefundSn() {
        return refundSn;
    }

    public void setRefundSn(String refundSn) {
        this.refundSn = refundSn;
    }


    @Basic
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "orderSn")
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    @Basic
    @Column(name = "orderItemsId")
    public Long getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(Long orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    @Basic
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }


    @Basic
    @Column(name = "paymentSn")
    public String getPaymentSn() {
        return paymentSn;
    }

    public void setPaymentSn(String paymentSn) {
        this.paymentSn = paymentSn;
    }


    @Basic
    @Column(name = "payMemberName")
    public String getPayMemberName() {
        return payMemberName;
    }

    public void setPayMemberName(String payMemberName) {
        this.payMemberName = payMemberName;
    }


    @Basic
    @Column(name = "payType")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }


    @Basic
    @Column(name = "payMethod")
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }


    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    @Basic
    @Column(name = "refundUser")
    public String getRefundUser() {
        return refundUser;
    }

    public void setRefundUser(String refundUser) {
        this.refundUser = refundUser;
    }


    @Basic
    @Column(name = "refundTime")
    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }


    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Basic
    @Column(name = "refundRequest")
    public String getRefundRequest() {
        return refundRequest;
    }

    public void setRefundRequest(String refundRequest) {
        this.refundRequest = refundRequest;
    }


    @Basic
    @Column(name = "refundResponse")
    public String getRefundResponse() {
        return refundResponse;
    }

    public void setRefundResponse(String refundResponse) {
        this.refundResponse = refundResponse;
    }


    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Basic
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    @Basic
    @Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


}
