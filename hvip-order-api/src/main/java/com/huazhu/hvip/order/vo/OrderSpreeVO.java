package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cmy on 2016/10/18.
 */
public class OrderSpreeVO implements Serializable {

    private long spreeId;
    private String refNo;
    private String giftName;
    private String status;
    private String memberId;
    private String memberName;
    private Integer num;
    private Integer hotelNo;
    private String hotelName;
    private String createUser;
    private String updateUser;
    private Date createTime;
    private Date updateTime;

    public long getSpreeId() {
        return spreeId;
    }

    public void setSpreeId(long spreeId) {
        this.spreeId = spreeId;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(Integer hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
