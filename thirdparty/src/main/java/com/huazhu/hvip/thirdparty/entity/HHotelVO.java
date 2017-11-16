/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberVO.java
 * Author:   lijing
 * Date:     2016-03-20 15:18:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 15:18:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.thirdparty.entity;

public class HHotelVO {

    private String hotelId;//酒店id
    private String hotelSn;//酒店编号
    private String hotelAddress;//酒店地址
    private String hotelName;//酒店名称
    private String hotelTelNo;//酒店电话
    private String cityName;//城市名称
    private Double longitude;//经度
    private Double latitude;//纬度

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelSn() {
        return hotelSn;
    }

    public void setHotelSn(String hotelSn) {
        this.hotelSn = hotelSn;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelTelNo() {
        return hotelTelNo;
    }

    public void setHotelTelNo(String hotelTelNo) {
        this.hotelTelNo = hotelTelNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
