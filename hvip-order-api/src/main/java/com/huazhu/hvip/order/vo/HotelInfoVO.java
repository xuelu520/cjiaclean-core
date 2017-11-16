package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HotelInfoVO implements Serializable {

    private String hotelUniqueNo; //酒店统一编号

    private String hotelName; //酒店名称

    private String hotelAddress; //酒店地址

    private String hotelOrderSn; //酒店订单编号

    private String hotelRecOrderSn; //酒店接待单号

    private String hotelRoomNo; //酒店房间号

    private String hoBillId; //华住订单billId

    private String hotelTelNo; //酒店联系方式

    private Date hoCheckInDate; //入住日

    private Date hoCheckOutDate; //离店日

    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
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

    public String getHotelOrderSn() {
        return hotelOrderSn;
    }

    public void setHotelOrderSn(String hotelOrderSn) {
        this.hotelOrderSn = hotelOrderSn;
    }

    public String getHotelRecOrderSn() {
        return hotelRecOrderSn;
    }

    public void setHotelRecOrderSn(String hotelRecOrderSn) {
        this.hotelRecOrderSn = hotelRecOrderSn;
    }

    public String getHotelRoomNo() {
        return hotelRoomNo;
    }

    public void setHotelRoomNo(String hotelRoomNo) {
        this.hotelRoomNo = hotelRoomNo;
    }

    public String getHotelTelNo() {
        return hotelTelNo;
    }

    public void setHotelTelNo(String hotelTelNo) {
        this.hotelTelNo = hotelTelNo;
    }

    public String getHoBillId() {
        return hoBillId;
    }

    public void setHoBillId(String hoBillId) {
        this.hoBillId = hoBillId;
    }

    public Date getHoCheckInDate() {
        return hoCheckInDate;
    }

    public void setHoCheckInDate(Date hoCheckInDate) {
        this.hoCheckInDate = hoCheckInDate;
    }

    public Date getHoCheckOutDate() {
        return hoCheckOutDate;
    }

    public void setHoCheckOutDate(Date hoCheckOutDate) {
        this.hoCheckOutDate = hoCheckOutDate;
    }
}
