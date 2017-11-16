package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
public class PaymentVO implements Serializable {

    private Long paymentId; //支付单id
    private Long orderId; //订单id
    private String payMethod; //支付方式
    private String paymentSn; //支付单唯一号
    private Long memberId; //会员id
    private String payMemberName; //付款人
    private BigDecimal amount; //付款金额
    private BigDecimal realAmount; //实际付款金额
    private BigDecimal realPoint;
    private Date payTime; //支付时间
    private String payRequest; //支付请求字串
    private String payResponse; //支付相应字串
    private String billNo; //支付回调单号
    private String remark; //备注
    private String payType; //支付类型
    private String status; //状态 0.未确认 1已确认(成功) 2.已确认(失败)
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private BigDecimal CRMValue; //储值卡金额
    private BigDecimal CRMPoint; //积分
    private BigDecimal AlipayWap; //支付宝
    private BigDecimal UnionCreditCardPay;//信用卡
    private OrderVO orderVO;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPaymentSn() {
        return paymentSn;
    }

    public void setPaymentSn(String paymentSn) {
        this.paymentSn = paymentSn;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getPayMemberName() {
        return payMemberName;
    }

    public void setPayMemberName(String payMemberName) {
        this.payMemberName = payMemberName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public BigDecimal getRealPoint() {
        return realPoint;
    }

    public void setRealPoint(BigDecimal realPoint) {
        this.realPoint = realPoint;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public OrderVO getOrderVO() {
        return orderVO;
    }

    public void setOrderVO(OrderVO orderVO) {
        this.orderVO = orderVO;
    }

    public BigDecimal getCRMValue() {
        return CRMValue;
    }

    public void setCRMValue(BigDecimal CRMValue) {
        this.CRMValue = CRMValue;
    }

    public BigDecimal getCRMPoint() {
        return CRMPoint;
    }

    public void setCRMPoint(BigDecimal CRMPoint) {
        this.CRMPoint = CRMPoint;
    }

    public BigDecimal getAlipayWap() {
        return AlipayWap;
    }

    public void setAlipayWap(BigDecimal alipayWap) {
        AlipayWap = alipayWap;
    }

    public BigDecimal getUnionCreditCardPay() {
        return UnionCreditCardPay;
    }

    public void setUnionCreditCardPay(BigDecimal unionCreditCardPay) {
        UnionCreditCardPay = unionCreditCardPay;
    }
}
