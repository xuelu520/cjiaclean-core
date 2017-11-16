/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderDebitVO.java
 * Author:   lijing
 * Date:     2016-04-28 10:36:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-28 10:36:15> <version>   <desc>
 *
 */

package com.huazhu.hvip.order.vo;

import java.io.Serializable;
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
public class OrderDebitVO implements Serializable {
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
    private String billType;//账单类型:0 未入账 1 已入账 2 调账
    private String billNo;//账单号

    public Long getOrderDebitId() {
        return orderDebitId;
    }

    public void setOrderDebitId(Long orderDebitId) {
        this.orderDebitId = orderDebitId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getHotelBillId() {
        return hotelBillId;
    }

    public void setHotelBillId(String hotelBillId) {
        this.hotelBillId = hotelBillId;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getDebitType() {
        return debitType;
    }

    public void setDebitType(String debitType) {
        this.debitType = debitType;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
}
