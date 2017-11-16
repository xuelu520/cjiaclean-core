package com.huazhu.hvip.order.ord.model.extend;

import com.huazhu.hvip.base.model.DynamicField;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.OrderItems;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by XUEYONGPING001 on 2016/4/7.
 */
@Entity
public class OrderItemsExt extends DynamicField {

    private Long itemsId;
    private String hotelOrderSn; //酒店订单编号
    private String hotelRoomNo; //酒店房间号
    private String address; //酒店的地址
    private Long telNo; //酒店的电话
    private String memberTelNo;
    private String memberName;
    private Integer salesNum;
    private BigDecimal price;
    private Date assignTime;
    private String status;
    private String goodsName;
    private Long orderId;
    private String orderSn; //订单唯一号
    private Long goodsId;
    private Date shipmentsCreateTime;
    private Date payTime;
    private String source;
    private Date orderCreateTime;
    private String orderCreateUser;
    private String orderUpdateUser;
    private String orderStatus;
    private String billType;
    private String payType; //支付方式
    private BigDecimal orderALLAcmount;//订单总金额
    private BigInteger saleUserNumber; //人员销售数量
    private BigDecimal saleUserMoney; //员工销售金额
    private BigDecimal H5Money; //H5渠道的金额
    private BigDecimal APPMoney; //APP渠道
    private String recordingUser;//入账人
    private Date hoCheckOutDate;//离店时间
    private Date hoCheckInDate; //入住时间
    public OrderItemsExt() {
    }

    public OrderItemsExt(Long itemsId, String hotelOrderSn, String hotelRoomNo, String address, Long telNo, String memberTelNo, String memberName, Integer salesNum, BigDecimal price, Date assignTime, String status, String goodsName, Long orderId, String orderSn, Long goodsId, Date shipmentsCreateTime, Date payTime, String source, String orderCreateUser, String orderUpdateUser, String orderStatus) {
        this.itemsId = itemsId;
        this.hotelOrderSn = hotelOrderSn;
        this.hotelRoomNo = hotelRoomNo;
        this.address = address;
        this.telNo = telNo;
        this.memberTelNo = memberTelNo;
        this.memberName = memberName;
        this.salesNum = salesNum;
        this.price = price;
        this.assignTime = assignTime;
        this.status = status;
        this.goodsName = goodsName;
        this.orderId = orderId;
        this.orderSn = orderSn;
        this.goodsId = goodsId;
        this.shipmentsCreateTime = shipmentsCreateTime;
        this.payTime = payTime;
        this.source = source;
        this.orderCreateUser = orderCreateUser;
        this.orderUpdateUser = orderUpdateUser;
        this.orderStatus = orderStatus;
    }

    @Id
    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public String getHotelRoomNo() {
        return hotelRoomNo;
    }

    public void setHotelRoomNo(String hotelRoomNo) {
        this.hotelRoomNo = hotelRoomNo;
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

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getShipmentsCreateTime() {
        return shipmentsCreateTime;
    }

    public void setShipmentsCreateTime(Date shipmentsCreateTime) {
        this.shipmentsCreateTime = shipmentsCreateTime;
    }

    public Long getTelNo() {
        return telNo;
    }

    public void setTelNo(Long telNo) {
        this.telNo = telNo;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrderCreateUser() {
        return orderCreateUser;
    }

    public void setOrderCreateUser(String orderCreateUser) {
        this.orderCreateUser = orderCreateUser;
    }

    public String getOrderUpdateUser() {
        return orderUpdateUser;
    }

    public void setOrderUpdateUser(String orderUpdateUser) {
        this.orderUpdateUser = orderUpdateUser;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getOrderALLAcmount() {
        return orderALLAcmount;
    }

    public void setOrderALLAcmount(BigDecimal orderALLAcmount) {
        this.orderALLAcmount = orderALLAcmount;
    }

    public BigInteger getSaleUserNumber() {
        return saleUserNumber;
    }

    public void setSaleUserNumber(BigInteger saleUserNumber) {
        this.saleUserNumber = saleUserNumber;
    }

    public BigDecimal getSaleUserMoney() {
        return saleUserMoney;
    }

    public void setSaleUserMoney(BigDecimal saleUserMoney) {
        this.saleUserMoney = saleUserMoney;
    }

    public BigDecimal getH5Money() {
        return H5Money;
    }

    public void setH5Money(BigDecimal h5Money) {
        H5Money = h5Money;
    }

    public BigDecimal getAPPMoney() {
        return APPMoney;
    }

    public void setAPPMoney(BigDecimal APPMoney) {
        this.APPMoney = APPMoney;
    }

    public String getRecordingUser() {
        return recordingUser;
    }

    public void setRecordingUser(String recordingUser) {
        this.recordingUser = recordingUser;
    }

    public Date getHoCheckOutDate() {
        return hoCheckOutDate;
    }

    public void setHoCheckOutDate(Date hoCheckOutDate) {
        this.hoCheckOutDate = hoCheckOutDate;
    }

    public Date getHoCheckInDate() {
        return hoCheckInDate;
    }

    public void setHoCheckInDate(Date hoCheckInDate) {
        this.hoCheckInDate = hoCheckInDate;
    }
}
