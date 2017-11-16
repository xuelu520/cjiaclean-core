package com.huazhu.hvip.order.ord.model.extend;

import com.huazhu.hvip.base.model.DynamicField;
import com.huazhu.hvip.order.ord.model.OrderAction;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.payment.model.Payment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by LYL on 2016/8/5.
 */
@Entity
public class OrderActionExt extends DynamicField {
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
    private String hotelTelNo; //酒店电话
    private String hotelRoomNo; //酒店房间号
    private String hoBillId; //华住订单billId
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
    private String goodsShow;
    private String serviceTime; //服务时间
    private String billType;
    private String source;
    private Integer splitProportion; //分成比例(以整数方式存储，例如40%对应就是40)
    private String orgType;
    private String orgValue;
    private Date shipmentTime; //发货时间
    private String goodsName;//商品名称

    private List<OrderItems> orderItemsList;
    private Payment payment;
    private Date BillTime; //入账时间
    private String BillCreateUser; //入账人
    private String sendTime;//发货时间
    private String sendCreateUser;//发货人
    private Date returnTime; //退货时间
    private Date returnUser; //退货人
    private String payMethod; //支付方式
    private String payResponse;//支付响应
    private List<OrderAction> orderActionList;

    @Id
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public String getHotelTelNo() {
        return hotelTelNo;
    }

    public void setHotelTelNo(String hotelTelNo) {
        this.hotelTelNo = hotelTelNo;
    }

    public String getHotelRoomNo() {
        return hotelRoomNo;
    }

    public void setHotelRoomNo(String hotelRoomNo) {
        this.hotelRoomNo = hotelRoomNo;
    }

    public String getHoBillId() {
        return hoBillId;
    }

    public void setHoBillId(String hoBillId) {
        this.hoBillId = hoBillId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberTelNo() {
        return memberTelNo;
    }

    public void setMemberTelNo(String memberTelNo) {
        this.memberTelNo = memberTelNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberIdType() {
        return memberIdType;
    }

    public void setMemberIdType(String memberIdType) {
        this.memberIdType = memberIdType;
    }

    public String getMemberIdNo() {
        return memberIdNo;
    }

    public void setMemberIdNo(String memberIdNo) {
        this.memberIdNo = memberIdNo;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddr() {
        return shipAddr;
    }

    public void setShipAddr(String shipAddr) {
        this.shipAddr = shipAddr;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public String getShipMobile() {
        return shipMobile;
    }

    public void setShipMobile(String shipMobile) {
        this.shipMobile = shipMobile;
    }

    public String getShipTel() {
        return shipTel;
    }

    public void setShipTel(String shipTel) {
        this.shipTel = shipTel;
    }

    public String getShipDay() {
        return shipDay;
    }

    public void setShipDay(String shipDay) {
        this.shipDay = shipDay;
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public String getTheSign() {
        return theSign;
    }

    public void setTheSign(String theSign) {
        this.theSign = theSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(Date allocationTime) {
        this.allocationTime = allocationTime;
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

    @Transient
    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItems> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public Date getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(Date shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgValue() {
        return orgValue;
    }

    public void setOrgValue(String orgValue) {
        this.orgValue = orgValue;
    }

    public Integer getSplitProportion() {
        return splitProportion;
    }

    public void setSplitProportion(Integer splitProportion) {
        this.splitProportion = splitProportion;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Transient
    public String getGoodsShow() {
        return goodsShow;
    }

    public void setGoodsShow(String goodsShow) {
        this.goodsShow = goodsShow;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    @Transient
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    @Transient
    public Date getBillTime() {
        return BillTime;
    }

    public void setBillTime(Date billTime) {
        BillTime = billTime;
    }
    @Transient
    public String getBillCreateUser() {
        return BillCreateUser;
    }

    public void setBillCreateUser(String billCreateUser) {
        BillCreateUser = billCreateUser;
    }
    @Transient
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
    @Transient
    public String getSendCreateUser() {
        return sendCreateUser;
    }

    public void setSendCreateUser(String sendCreateUser) {
        this.sendCreateUser = sendCreateUser;
    }
    @Transient
    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
    @Transient
    public Date getReturnUser() {
        return returnUser;
    }

    public void setReturnUser(Date returnUser) {
        this.returnUser = returnUser;
    }

    public String getPayResponse() {
        return payResponse;
    }

    public void setPayResponse(String payResponse) {
        this.payResponse = payResponse;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    @Transient
    public List<OrderAction> getOrderActionList() {
        return orderActionList;
    }

    public void setOrderActionList(List<OrderAction> orderActionList) {
        this.orderActionList = orderActionList;
    }
}