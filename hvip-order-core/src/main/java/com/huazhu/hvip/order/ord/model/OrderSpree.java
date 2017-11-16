package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LYL on 2016/10/18.
 */
@Entity
@Table(name = "vip_orderspree")
public class OrderSpree {
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

    @Id
    @Column(name = "spreeId")
    public long getSpreeId() {
        return spreeId;
    }

    public void setSpreeId(long spreeId) {
        this.spreeId = spreeId;
    }

    @Basic
    @Column(name = "refNo")
    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Basic
    @Column(name = "giftName")
    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
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
    @Column(name = "memberId")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "hotelNo")
    public Integer getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(Integer hotelNo) {
        this.hotelNo = hotelNo;
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
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderSpree that = (OrderSpree) o;

        if (spreeId != that.spreeId) return false;
        if (refNo != null ? !refNo.equals(that.refNo) : that.refNo != null) return false;
        if (giftName != null ? !giftName.equals(that.giftName) : that.giftName != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (memberName != null ? !memberName.equals(that.memberName) : that.memberName != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (hotelNo != null ? !hotelNo.equals(that.hotelNo) : that.hotelNo != null) return false;
        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (spreeId ^ (spreeId >>> 32));
        result = 31 * result + (refNo != null ? refNo.hashCode() : 0);
        result = 31 * result + (giftName != null ? giftName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (memberName != null ? memberName.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
