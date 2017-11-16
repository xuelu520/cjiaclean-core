package com.huazhu.hvip.order.ord.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_order")
public class Order extends DynamicField {

    private Long orderId;
    private String orderNo;
    private String orderSn;
    private Long storeId;
    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelUniqueNo;
    private String hotelNo;
    private String hotelOrderSn; //酒店订单编号
    private String hotelRecOrderSn; //酒店接待单号
    private String hotelTelNo; //酒店电话
    private String hotelRoomNo; //酒店房间号
    private String hoBillId; //华住订单billId
    private Date hoCheckInDate; //酒店订单入住日
    private Date hoCheckOutDate; //酒店订单离店日
    private Long parentId;
    private String status;
    private String payStatus;
    private String shipStatus;
    private String deleteFlag;
    private BigDecimal goodsAmount;
    private BigDecimal shippingAmount;
    private BigDecimal discount;
    private BigDecimal orderAmount;
    private BigDecimal refundAmount;
    private Long memberId;
    private String memberMobile;
    private String memberTelNo;
    private String memberName;
    private String memberAddress;
    private String memberIdType;
    private String memberIdNo;
    private String shipName;
    private String shipAddr;
    private String shipZip;
    private String shipEmail;
    private String shipMobile;
    private String shipTel;
    private String shipDay;
    private String shipTime;
    private String cancelReason;
    private Date signingTime;
    private String theSign;
    private String remark;
    private Date completeTime;
    private Date payTime;
    private Date allocationTime;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private String billType;//账单类型:0 未入账 1 已入账 2 调账
    private String source;//订单来源,例如 HMS，APP，H5
    private Integer splitProportion; //分成比例(以整数方式存储，例如40%对应就是40)
    private String bizScope;//关联外部订单类型 1 点到
    private String orgValue;//关联外部订单号
    private String cateRule; //订单的分类规则 1收费 2收费租赁 3免费 4免费租赁
    private String cycle;
    private Integer totalServiceCount;
    private Integer waitServiceCount;
    private Integer finishService;
    private Integer serviceLength;
    private Date closingDate;//截止日期



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "closingDate")
    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
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
    @Column(name = "finishService")
    public Integer getFinishService() {
        return finishService;
    }

    public void setFinishService(Integer finishService) {
        this.finishService = finishService;
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
    @Column(name = "orderNo")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "storeId")
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "hotelId")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "hotelName")
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Basic
    @Column(name = "hotelAddress")
    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Basic
    @Column(name = "hotelUniqueNo")
    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    @Basic
    @Column(name = "hotelNo")
    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
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
    @Column(name = "hotelRecOrderSn")
    public String getHotelRecOrderSn() {
        return hotelRecOrderSn;
    }

    public void setHotelRecOrderSn(String hotelRecOrderSn) {
        this.hotelRecOrderSn = hotelRecOrderSn;
    }

    @Basic
    @Column(name = "hotelTelNo")
    public String getHotelTelNo() {
        return hotelTelNo;
    }

    public void setHotelTelNo(String hotelTelNo) {
        this.hotelTelNo = hotelTelNo;
    }

    @Basic
    @Column(name = "hotelRoomNo")
    public String getHotelRoomNo() {
        return hotelRoomNo;
    }

    public void setHotelRoomNo(String hotelRoomNo) {
        this.hotelRoomNo = hotelRoomNo;
    }

    @Basic
    @Column(name = "hoBillId")
    public String getHoBillId() {
        return hoBillId;
    }

    public void setHoBillId(String hoBillId) {
        this.hoBillId = hoBillId;
    }

    @Basic
    @Column(name = "hoCheckInDate")
    public Date getHoCheckInDate() {
        return hoCheckInDate;
    }

    public void setHoCheckInDate(Date hoCheckInDate) {
        this.hoCheckInDate = hoCheckInDate;
    }

    @Basic
    @Column(name = "hoCheckOutDate")
    public Date getHoCheckOutDate() {
        return hoCheckOutDate;
    }

    public void setHoCheckOutDate(Date hoCheckOutDate) {
        this.hoCheckOutDate = hoCheckOutDate;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
    @Column(name = "payStatus")
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "shipStatus")
    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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
    @Column(name = "shippingAmount")
    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }


    @Basic
    @Column(name = "discount")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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
    @Column(name = "refundAmount")
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
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
    @Column(name = "memberMobile")
    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }


    @Basic
    @Column(name = "memberTelNo")
    public String getMemberTelNo() {
        return memberTelNo;
    }

    public void setMemberTelNo(String memberTelNo) {
        this.memberTelNo = memberTelNo;
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
    @Column(name = "memberAddress")
    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }


    @Basic
    @Column(name = "memberIdType")
    public String getMemberIdType() {
        return memberIdType;
    }

    public void setMemberIdType(String memberIdType) {
        this.memberIdType = memberIdType;
    }


    @Basic
    @Column(name = "memberIdNo")
    public String getMemberIdNo() {
        return memberIdNo;
    }

    public void setMemberIdNo(String memberIdNo) {
        this.memberIdNo = memberIdNo;
    }


    @Basic
    @Column(name = "shipName")
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
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
    @Column(name = "shipZip")
    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }


    @Basic
    @Column(name = "shipEmail")
    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
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
    @Column(name = "shipTel")
    public String getShipTel() {
        return shipTel;
    }

    public void setShipTel(String shipTel) {
        this.shipTel = shipTel;
    }


    @Basic
    @Column(name = "shipDay")
    public String getShipDay() {
        return shipDay;
    }

    public void setShipDay(String shipDay) {
        this.shipDay = shipDay;
    }


    @Basic
    @Column(name = "shipTime")
    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }


    @Basic
    @Column(name = "cancelReason")
    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }


    @Basic
    @Column(name = "signingTime")
    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }


    @Basic
    @Column(name = "theSign")
    public String getTheSign() {
        return theSign;
    }

    public void setTheSign(String theSign) {
        this.theSign = theSign;
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
    @Column(name = "completeTime")
    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
    @Column(name = "allocationTime")
    public Date getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(Date allocationTime) {
        this.allocationTime = allocationTime;
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

    @Basic
    @Column(name = "billType")
    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    @Basic
    @Column(name = "bizScope")
    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    @Basic
    @Column(name = "orgValue")
    public String getOrgValue() {
        return orgValue;
    }

    public void setOrgValue(String orgValue) {
        this.orgValue = orgValue;
    }

    @Basic
    @Column(name = "splitProportion")
    public Integer getSplitProportion() {
        return splitProportion;
    }

    public void setSplitProportion(Integer splitProportion) {
        this.splitProportion = splitProportion;
    }

    @Basic
    @Column(name = "cateRule")
    public String getCateRule() {
        return cateRule;
    }

    public void setCateRule(String cateRule) {
        this.cateRule = cateRule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (orderNo != null ? !orderNo.equals(order.orderNo) : order.orderNo != null) return false;
        if (orderSn != null ? !orderSn.equals(order.orderSn) : order.orderSn != null) return false;
        if (storeId != null ? !storeId.equals(order.storeId) : order.storeId != null) return false;
        if (hotelId != null ? !hotelId.equals(order.hotelId) : order.hotelId != null) return false;
        if (hotelName != null ? !hotelName.equals(order.hotelName) : order.hotelName != null) return false;
        if (hotelAddress != null ? !hotelAddress.equals(order.hotelAddress) : order.hotelAddress != null) return false;
        if (hotelUniqueNo != null ? !hotelUniqueNo.equals(order.hotelUniqueNo) : order.hotelUniqueNo != null)
            return false;
        if (hotelNo != null ? !hotelNo.equals(order.hotelNo) : order.hotelNo != null) return false;
        if (hotelOrderSn != null ? !hotelOrderSn.equals(order.hotelOrderSn) : order.hotelOrderSn != null) return false;
        if (hotelRecOrderSn != null ? !hotelRecOrderSn.equals(order.hotelRecOrderSn) : order.hotelRecOrderSn != null)
            return false;
        if (hotelTelNo != null ? !hotelTelNo.equals(order.hotelTelNo) : order.hotelTelNo != null) return false;
        if (hotelRoomNo != null ? !hotelRoomNo.equals(order.hotelRoomNo) : order.hotelRoomNo != null) return false;
        if (hoBillId != null ? !hoBillId.equals(order.hoBillId) : order.hoBillId != null) return false;
        if (hoCheckInDate != null ? !hoCheckInDate.equals(order.hoCheckInDate) : order.hoCheckInDate != null)
            return false;
        if (hoCheckOutDate != null ? !hoCheckOutDate.equals(order.hoCheckOutDate) : order.hoCheckOutDate != null)
            return false;
        if (parentId != null ? !parentId.equals(order.parentId) : order.parentId != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (payStatus != null ? !payStatus.equals(order.payStatus) : order.payStatus != null) return false;
        if (shipStatus != null ? !shipStatus.equals(order.shipStatus) : order.shipStatus != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(order.deleteFlag) : order.deleteFlag != null) return false;
        if (goodsAmount != null ? !goodsAmount.equals(order.goodsAmount) : order.goodsAmount != null) return false;
        if (shippingAmount != null ? !shippingAmount.equals(order.shippingAmount) : order.shippingAmount != null)
            return false;
        if (discount != null ? !discount.equals(order.discount) : order.discount != null) return false;
        if (orderAmount != null ? !orderAmount.equals(order.orderAmount) : order.orderAmount != null) return false;
        if (refundAmount != null ? !refundAmount.equals(order.refundAmount) : order.refundAmount != null) return false;
        if (memberId != null ? !memberId.equals(order.memberId) : order.memberId != null) return false;
        if (memberMobile != null ? !memberMobile.equals(order.memberMobile) : order.memberMobile != null) return false;
        if (memberTelNo != null ? !memberTelNo.equals(order.memberTelNo) : order.memberTelNo != null) return false;
        if (memberName != null ? !memberName.equals(order.memberName) : order.memberName != null) return false;
        if (memberAddress != null ? !memberAddress.equals(order.memberAddress) : order.memberAddress != null)
            return false;
        if (memberIdType != null ? !memberIdType.equals(order.memberIdType) : order.memberIdType != null) return false;
        if (memberIdNo != null ? !memberIdNo.equals(order.memberIdNo) : order.memberIdNo != null) return false;
        if (shipName != null ? !shipName.equals(order.shipName) : order.shipName != null) return false;
        if (shipAddr != null ? !shipAddr.equals(order.shipAddr) : order.shipAddr != null) return false;
        if (shipZip != null ? !shipZip.equals(order.shipZip) : order.shipZip != null) return false;
        if (shipEmail != null ? !shipEmail.equals(order.shipEmail) : order.shipEmail != null) return false;
        if (shipMobile != null ? !shipMobile.equals(order.shipMobile) : order.shipMobile != null) return false;
        if (shipTel != null ? !shipTel.equals(order.shipTel) : order.shipTel != null) return false;
        if (shipDay != null ? !shipDay.equals(order.shipDay) : order.shipDay != null) return false;
        if (shipTime != null ? !shipTime.equals(order.shipTime) : order.shipTime != null) return false;
        if (cancelReason != null ? !cancelReason.equals(order.cancelReason) : order.cancelReason != null) return false;
        if (signingTime != null ? !signingTime.equals(order.signingTime) : order.signingTime != null) return false;
        if (theSign != null ? !theSign.equals(order.theSign) : order.theSign != null) return false;
        if (remark != null ? !remark.equals(order.remark) : order.remark != null) return false;
        if (completeTime != null ? !completeTime.equals(order.completeTime) : order.completeTime != null) return false;
        if (payTime != null ? !payTime.equals(order.payTime) : order.payTime != null) return false;
        if (allocationTime != null ? !allocationTime.equals(order.allocationTime) : order.allocationTime != null)
            return false;
        if (createTime != null ? !createTime.equals(order.createTime) : order.createTime != null) return false;
        if (createUser != null ? !createUser.equals(order.createUser) : order.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(order.updateTime) : order.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(order.updateUser) : order.updateUser != null) return false;
        if (billType != null ? !billType.equals(order.billType) : order.billType != null) return false;
        if (source != null ? !source.equals(order.source) : order.source != null) return false;
        if (splitProportion != null ? !splitProportion.equals(order.splitProportion) : order.splitProportion != null)
            return false;
        if (bizScope != null ? !bizScope.equals(order.bizScope) : order.bizScope != null) return false;
        if (orgValue != null ? !orgValue.equals(order.orgValue) : order.orgValue != null) return false;
        if (cateRule != null ? !cateRule.equals(order.cateRule) : order.cateRule != null) return false;
        if (cycle != null ? !cycle.equals(order.cycle) : order.cycle != null) return false;
        if (totalServiceCount != null ? !totalServiceCount.equals(order.totalServiceCount) : order.totalServiceCount != null)
            return false;
        if (waitServiceCount != null ? !waitServiceCount.equals(order.waitServiceCount) : order.waitServiceCount != null)
            return false;
        return !(finishService != null ? !finishService.equals(order.finishService) : order.finishService != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (orderSn != null ? orderSn.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (hotelAddress != null ? hotelAddress.hashCode() : 0);
        result = 31 * result + (hotelUniqueNo != null ? hotelUniqueNo.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        result = 31 * result + (hotelOrderSn != null ? hotelOrderSn.hashCode() : 0);
        result = 31 * result + (hotelRecOrderSn != null ? hotelRecOrderSn.hashCode() : 0);
        result = 31 * result + (hotelTelNo != null ? hotelTelNo.hashCode() : 0);
        result = 31 * result + (hotelRoomNo != null ? hotelRoomNo.hashCode() : 0);
        result = 31 * result + (hoBillId != null ? hoBillId.hashCode() : 0);
        result = 31 * result + (hoCheckInDate != null ? hoCheckInDate.hashCode() : 0);
        result = 31 * result + (hoCheckOutDate != null ? hoCheckOutDate.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (payStatus != null ? payStatus.hashCode() : 0);
        result = 31 * result + (shipStatus != null ? shipStatus.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (goodsAmount != null ? goodsAmount.hashCode() : 0);
        result = 31 * result + (shippingAmount != null ? shippingAmount.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (refundAmount != null ? refundAmount.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (memberMobile != null ? memberMobile.hashCode() : 0);
        result = 31 * result + (memberTelNo != null ? memberTelNo.hashCode() : 0);
        result = 31 * result + (memberName != null ? memberName.hashCode() : 0);
        result = 31 * result + (memberAddress != null ? memberAddress.hashCode() : 0);
        result = 31 * result + (memberIdType != null ? memberIdType.hashCode() : 0);
        result = 31 * result + (memberIdNo != null ? memberIdNo.hashCode() : 0);
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        result = 31 * result + (shipAddr != null ? shipAddr.hashCode() : 0);
        result = 31 * result + (shipZip != null ? shipZip.hashCode() : 0);
        result = 31 * result + (shipEmail != null ? shipEmail.hashCode() : 0);
        result = 31 * result + (shipMobile != null ? shipMobile.hashCode() : 0);
        result = 31 * result + (shipTel != null ? shipTel.hashCode() : 0);
        result = 31 * result + (shipDay != null ? shipDay.hashCode() : 0);
        result = 31 * result + (shipTime != null ? shipTime.hashCode() : 0);
        result = 31 * result + (cancelReason != null ? cancelReason.hashCode() : 0);
        result = 31 * result + (signingTime != null ? signingTime.hashCode() : 0);
        result = 31 * result + (theSign != null ? theSign.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (allocationTime != null ? allocationTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (billType != null ? billType.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (splitProportion != null ? splitProportion.hashCode() : 0);
        result = 31 * result + (bizScope != null ? bizScope.hashCode() : 0);
        result = 31 * result + (orgValue != null ? orgValue.hashCode() : 0);
        result = 31 * result + (cateRule != null ? cateRule.hashCode() : 0);
        result = 31 * result + (cycle != null ? cycle.hashCode() : 0);
        result = 31 * result + (totalServiceCount != null ? totalServiceCount.hashCode() : 0);
        result = 31 * result + (waitServiceCount != null ? waitServiceCount.hashCode() : 0);
        result = 31 * result + (finishService != null ? finishService.hashCode() : 0);
        return result;
    }
}
