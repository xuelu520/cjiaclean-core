package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.PageCondition;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author cmy
 * @create 2017-08-18 14:58
 **/
public class OpOrderListViewVO extends PageCondition{
    private Long orderId;
    private String status;
    private String orderSn;
    private String createUser;
    private Timestamp createTime;
    private BigDecimal goodsAmount;
    private BigDecimal orderAmount;
    private Integer serviceLength;
    private String cycle;
    private String shipMobile;
    private Integer totalServiceCount;
    private Integer waitServiceCount;
    private Integer finishService;
    private String goodsName;
    private String goodsSn;
    private String shipAddr;
    private String memberMobile;
    private String memberName;
    private BigDecimal refundAmount;


    public String getShipMobile() {
        return shipMobile;
    }

    public void setShipMobile(String shipMobile) {
        this.shipMobile = shipMobile;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
    public Integer getFinishService() {
        return finishService;
    }

    public void setFinishService(Integer finishService) {
        this.finishService = finishService;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getShipAddr() {
        return shipAddr;
    }

    public void setShipAddr(String shipAddr) {
        this.shipAddr = shipAddr;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getTotalServiceCount() {
        return totalServiceCount;
    }

    public void setTotalServiceCount(Integer totalServiceCount) {
        this.totalServiceCount = totalServiceCount;
    }

    public Integer getWaitServiceCount() {
        return waitServiceCount;
    }

    public void setWaitServiceCount(Integer waitServiceCount) {
        this.waitServiceCount = waitServiceCount;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
