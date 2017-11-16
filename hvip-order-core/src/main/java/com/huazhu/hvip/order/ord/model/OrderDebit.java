/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Orderdebit.java
 * Author:   lijing
 * Date:     2016-04-28 10:32:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-28 10:32:24> <version>   <desc>
 *
 */
package com.huazhu.hvip.order.ord.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "vip_orderdebit")
public class OrderDebit extends DynamicField {
    private Long orderDebitId;
    private Long orderId;
    private Long orderItemId;
    private String hotelId;
    private String hotelOrderSn;
    private String roomNo;
    private String hotelBillId;
    private String payNo;
    private BigDecimal amount;
    private String type;
    private String remark;
    private String assType;
    private Integer point;
    private String userName;
    private String bizDate;
    private Date createTime;
    private String status;
    private String operatorId;
    private String debitType;
    private String billType;
    private String billNo;//账单号

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderDebitId")
    public Long getOrderDebitId() {
        return orderDebitId;
    }

    public void setOrderDebitId(Long orderDebitId) {
        this.orderDebitId = orderDebitId;
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
    @Column(name = "orderItemId")
    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Basic
    @Column(name = "hotelId")
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "hotelOrderSn")
    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    @Basic
    @Column(name = "roomNo")
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Basic
    @Column(name = "hotelBillId")
    public String getHotelBillId() {
        return hotelBillId;
    }

    public void setHotelBillId(String hotelBillId) {
        this.hotelBillId = hotelBillId;
    }

    @Basic
    @Column(name = "payNo")
    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "assType")
    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    @Basic
    @Column(name = "point")
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "bizDate")
    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "operatorId")
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "debitType")
    public String getDebitType() {
        return debitType;
    }

    public void setDebitType(String debitType) {
        this.debitType = debitType;
    }

    @Basic
    @Column(name = "billType")
    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    @Basic
    @Column(name = "billNo")
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDebit that = (OrderDebit) o;

        if (orderDebitId != that.orderDebitId) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderItemId != null ? !orderItemId.equals(that.orderItemId) : that.orderItemId != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (hotelOrderSn != null ? !hotelOrderSn.equals(that.hotelOrderSn) : that.hotelOrderSn != null) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (hotelBillId != null ? !hotelBillId.equals(that.hotelBillId) : that.hotelBillId != null) return false;
        if (payNo != null ? !payNo.equals(that.payNo) : that.payNo != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (assType != null ? !assType.equals(that.assType) : that.assType != null) return false;
        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (bizDate != null ? !bizDate.equals(that.bizDate) : that.bizDate != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (debitType != null ? !debitType.equals(that.debitType) : that.debitType != null) return false;
        if (billType != null ? !billType.equals(that.billType) : that.billType != null) return false;
        if (billNo != null ? !billNo.equals(that.billNo) : that.billNo != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderDebitId ^ (orderDebitId >>> 32));
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (orderItemId != null ? orderItemId.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (hotelOrderSn != null ? hotelOrderSn.hashCode() : 0);
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (hotelBillId != null ? hotelBillId.hashCode() : 0);
        result = 31 * result + (payNo != null ? payNo.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (assType != null ? assType.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (bizDate != null ? bizDate.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (debitType != null ? debitType.hashCode() : 0);
        result = 31 * result + (billType != null ? billType.hashCode() : 0);
        result = 31 * result + (billNo != null ? billNo.hashCode() : 0);
        return result;
    }
}
