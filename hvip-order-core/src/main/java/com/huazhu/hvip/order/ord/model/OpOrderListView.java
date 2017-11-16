package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author cmy
 * @create 2017-08-18 14:53
 **/
@Entity
@Table(name = "view_oporderlist", schema = "", catalog = "cjiaclean_order")
public class OpOrderListView {
    private Long orderId;
    private String status;
    private String orderSn;
    private String goodsSn;
    private String createUser;
    private Timestamp createTime;
    private BigDecimal goodsAmount;
    private BigDecimal orderAmount;
    private String shipMobile;
    private Integer serviceLength;
    private String cycle;
    private Integer totalServiceCount;
    private Integer waitServiceCount;
    private Integer finishService;
    private String shipAddr;
    private String goodsName;
    private String memberMobile;
    private String memberName;


    @Id
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "finishService")
    public Integer getFinishService() {
        return finishService;
    }

    public void setFinishService(Integer finishService) {
        this.finishService = finishService;
    }



    @Basic
    @Column(name = "shipMobile")
    public String getShipMobile() {
        return shipMobile;
    }

    public void setShipMobile(String shipMobile) {
        this.shipMobile = shipMobile;
    }

    @Basic
    @Column(name = "memberMobile")
    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }
    @Basic
    @Column(name = "memberName")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Basic
    @Column(name = "shipAddr")
    public String getShipAddr() {
        return shipAddr;
    }

    public void setShipAddr(String shipAddr) {
        this.shipAddr = shipAddr;
    }

    @Basic
    @Column(name = "goodsSn")
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
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
    @Column(name = "orderSn")
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
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
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "goodsAmount")
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    @Basic
    @Column(name = "orderAmount")
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "serviceLength")
    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    @Basic
    @Column(name = "cycle")
    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    @Basic
    @Column(name = "totalServiceCount")
    public Integer getTotalServiceCount() {
        return totalServiceCount;
    }

    public void setTotalServiceCount(Integer totalServiceCount) {
        this.totalServiceCount = totalServiceCount;
    }

    @Basic
    @Column(name = "waitServiceCount")
    public Integer getWaitServiceCount() {
        return waitServiceCount;
    }

    public void setWaitServiceCount(Integer waitServiceCount) {
        this.waitServiceCount = waitServiceCount;
    }

    @Basic
    @Column(name = "goodsName")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpOrderListView that = (OpOrderListView) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (orderSn != null ? !orderSn.equals(that.orderSn) : that.orderSn != null) return false;
        if (goodsSn != null ? !goodsSn.equals(that.goodsSn) : that.goodsSn != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (goodsAmount != null ? !goodsAmount.equals(that.goodsAmount) : that.goodsAmount != null) return false;
        if (orderAmount != null ? !orderAmount.equals(that.orderAmount) : that.orderAmount != null) return false;
        if (serviceLength != null ? !serviceLength.equals(that.serviceLength) : that.serviceLength != null)
            return false;
        if (cycle != null ? !cycle.equals(that.cycle) : that.cycle != null) return false;
        if (totalServiceCount != null ? !totalServiceCount.equals(that.totalServiceCount) : that.totalServiceCount != null)
            return false;
        if (waitServiceCount != null ? !waitServiceCount.equals(that.waitServiceCount) : that.waitServiceCount != null)
            return false;
        if (finishService != null ? !finishService.equals(that.finishService) : that.finishService != null)
            return false;
        if (shipAddr != null ? !shipAddr.equals(that.shipAddr) : that.shipAddr != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (memberMobile != null ? !memberMobile.equals(that.memberMobile) : that.memberMobile != null) return false;
        if (memberName != null ? !memberName.equals(that.memberName) : that.memberName != null) return false;
        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderSn != null ? orderSn.hashCode() : 0);
        result = 31 * result + (goodsSn != null ? goodsSn.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (goodsAmount != null ? goodsAmount.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (serviceLength != null ? serviceLength.hashCode() : 0);
        result = 31 * result + (cycle != null ? cycle.hashCode() : 0);
        result = 31 * result + (totalServiceCount != null ? totalServiceCount.hashCode() : 0);
        result = 31 * result + (waitServiceCount != null ? waitServiceCount.hashCode() : 0);
        result = 31 * result + (finishService != null ? finishService.hashCode() : 0);
        result = 31 * result + (shipAddr != null ? shipAddr.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (memberMobile != null ? memberMobile.hashCode() : 0);
        result = 31 * result + (memberName != null ? memberName.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    private String id;

}
