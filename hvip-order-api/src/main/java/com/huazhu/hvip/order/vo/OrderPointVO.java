package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cmy on 2016/9/1.
 */
public class OrderPointVO implements Serializable{
    private String bizDate; //营业日
    private String mgrModel; //酒店类型
    private String hotelNo; //酒店NO
    private String hotelId; //酒店id
    private String hotelName; //酒店名称
    private String ncCode;  //ncCode
    private String cityAreaName; //城区
    private BigDecimal rateTotalMoney; //全积分销售的商品总额（包括税金额）
    private BigDecimal amount;   //销售额
    private String rate;    //税率
    private BigDecimal rateMoney; //税额
    private BigDecimal noRateMoney; //全积分消费兑换的商品

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getMgrModel() {
        return mgrModel;
    }

    public void setMgrModel(String mgrModel) {
        this.mgrModel = mgrModel;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public BigDecimal getRateTotalMoney() {
        return rateTotalMoney;
    }

    public void setRateTotalMoney(BigDecimal rateTotalMoney) {
        this.rateTotalMoney = rateTotalMoney;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public BigDecimal getRateMoney() {
        return rateMoney;
    }

    public void setRateMoney(BigDecimal rateMoney) {
        this.rateMoney = rateMoney;
    }

    public BigDecimal getNoRateMoney() {
        return noRateMoney;
    }

    public void setNoRateMoney(BigDecimal noRateMoney) {
        this.noRateMoney = noRateMoney;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }
}