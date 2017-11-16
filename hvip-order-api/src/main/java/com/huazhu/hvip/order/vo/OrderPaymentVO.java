package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cmy on 2016/8/3.
 * 用于op积分报表
 */
public class OrderPaymentVO implements Serializable{
    private Long orderId; //订单id
    private String hotelName; //酒店名称
    private String hotelNo; //酒店Id
    private String ncCode; //酒店nc
    private String cityAreaName; //城区
    private String city; //城市
    private String mgrModel; //运营方式
    private String orderSn; //百宝箱订单号
    private String hotelOrderSn;//酒店订单
    private String status; //订单状态
    private String billType; //入账
    private String source; //来源
    private String goodsName; //商品名
    private BigDecimal orderAmount; //订单金额
    private String payType; //支付方式
    private BigDecimal crmValue; //储值卡金额
    private BigDecimal crmPoint; //积分
    private BigDecimal alipayWap; //支付宝
    private BigDecimal unionCreditCardPay;//信用卡
    private Date orderCreateTime; //下单时间
    private Date billTime; //入账时间
    private String billCreateUser; //入账人
    private Date sendTime; //发货时间
    private Long hotelId; //酒店ID
    private String sendCreateUser;//发货人
    private Date returnTime; //退货时间
    private String returnUser; //退货人
    private String memberName; //会员姓名
    private String memberMobile;//会员手机号


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getNcCode() {
        return ncCode;
    }

    public void setNcCode(String ncCode) {
        this.ncCode = ncCode;
    }

    public String getCityAreaName() {
        return cityAreaName;
    }

    public void setCityAreaName(String cityAreaName) {
        this.cityAreaName = cityAreaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMgrModel() {
        return mgrModel;
    }

    public void setMgrModel(String mgrModel) {
        this.mgrModel = mgrModel;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public BigDecimal getCrmValue() {
        return crmValue;
    }

    public void setCrmValue(BigDecimal crmValue) {
        this.crmValue = crmValue;
    }

    public BigDecimal getCrmPoint() {
        return crmPoint;
    }

    public void setCrmPoint(BigDecimal crmPoint) {
        this.crmPoint = crmPoint;
    }

    public BigDecimal getAlipayWap() {
        return alipayWap;
    }

    public void setAlipayWap(BigDecimal alipayWap) {
        this.alipayWap = alipayWap;
    }

    public BigDecimal getUnionCreditCardPay() {
        return unionCreditCardPay;
    }

    public void setUnionCreditCardPay(BigDecimal unionCreditCardPay) {
        this.unionCreditCardPay = unionCreditCardPay;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getBillCreateUser() {
        return billCreateUser;
    }

    public void setBillCreateUser(String billCreateUser) {
        this.billCreateUser = billCreateUser;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendCreateUser() {
        return sendCreateUser;
    }

    public void setSendCreateUser(String sendCreateUser) {
        this.sendCreateUser = sendCreateUser;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnUser() {
        return returnUser;
    }

    public void setReturnUser(String returnUser) {
        this.returnUser = returnUser;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
