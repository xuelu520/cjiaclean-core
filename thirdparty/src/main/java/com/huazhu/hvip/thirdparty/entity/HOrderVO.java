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


import com.huazhu.hvip.thirdparty.utils.Const;
import org.apache.commons.lang.StringUtils;

public class HOrderVO {

    private String orderId;//订单id
    private String orderSn;//订单编号
    private String hoBillId; //华住订单billId
    private String checkInDateView;//入住日期
    private String checkOutDateView;//离店日期
    private String status;//订单状态
    private String userName;//入住人
    private String roomTypeName;//入住房型名称
    private Integer roomCount;//房间数
    private String arrTime;//到店时间

    //----------------------view-----------------------------------//

    //订单状态
    public String getStatusView() {
        String orderStatus = "";
        if (StringUtils.isNotBlank(status)) {
            if (Const.HZ_ORDER_STATUS_1.equals(status)) {
                orderStatus = "预订中";
            } else if (Const.HZ_ORDER_STATUS_2.equals(status)) {
                orderStatus = "已入住";
            }
        }
        return orderStatus;
    }
    //----------------------/view-----------------------------------//

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getCheckInDateView() {
        return checkInDateView;
    }

    public void setCheckInDateView(String checkInDateView) {
        this.checkInDateView = checkInDateView;
    }

    public String getCheckOutDateView() {
        return checkOutDateView;
    }

    public void setCheckOutDateView(String checkOutDateView) {
        this.checkOutDateView = checkOutDateView;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getHoBillId() {
        return hoBillId;
    }

    public void setHoBillId(String hoBillId) {
        this.hoBillId = hoBillId;
    }
}
