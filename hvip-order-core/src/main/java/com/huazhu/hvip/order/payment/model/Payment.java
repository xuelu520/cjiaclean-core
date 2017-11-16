package com.huazhu.hvip.order.payment.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_payment")
public class Payment extends DynamicField {

    private Long paymentId;
    private Long orderId;
    private String payMethod;
    private String paymentSn;
    private Long memberId;
    private String payMemberName;
    private BigDecimal amount;
    private BigDecimal realAmount;
    private BigDecimal realPoint;
    private Date payTime;
    private String payRequest;
    private String payResponse;
    private String billNo; //支付回调单号
    private String remark;
    private String payType;
    private String status;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paymentId")
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
    @Column(name = "payMethod")
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
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
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    @Basic
    @Column(name = "realAmount")
    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }


    @Basic
    @Column(name = "realPoint")
    public BigDecimal getRealPoint() {
        return realPoint;
    }

    public void setRealPoint(BigDecimal realPoint) {
        this.realPoint = realPoint;
    }


    @Basic
    @Column(name = "payTime")
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }


    @Basic
    @Column(name = "payRequest")
    public String getPayRequest() {
        return payRequest;
    }

    public void setPayRequest(String payRequest) {
        this.payRequest = payRequest;
    }


    @Basic
    @Column(name = "payResponse")
    public String getPayResponse() {
        return payResponse;
    }

    public void setPayResponse(String payResponse) {
        this.payResponse = payResponse;
    }

    @Basic
    @Column(name = "billNo")
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
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
    @Column(name = "payType")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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
