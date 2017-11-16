package com.huazhu.hvip.product.goods.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LYL on 2016/10/18.
 */
@Entity
@Table(name = "vip_spreegift")
public class SpreeGift {
    private Long giftId;
    private String giftName;
    private Integer giftType;
    private Integer status;
    private Long hotelNo;
    private String createUser;
    private String updateUser;
    private Date createTime;
    private Date updateTime;
    private String deleteFlag;

    @Id
    @Column(name = "giftId")
    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
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
    @Column(name = "giftType")
    public Integer getGiftType() {
        return giftType;
    }

    public void setGiftType(Integer giftType) {
        this.giftType = giftType;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "hotelNo")
    public Long getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(Long hotelNo) {
        this.hotelNo = hotelNo;
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

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpreeGift spreeGift = (SpreeGift) o;

        if (giftId != null ? !giftId.equals(spreeGift.giftId) : spreeGift.giftId != null) return false;
        if (giftName != null ? !giftName.equals(spreeGift.giftName) : spreeGift.giftName != null) return false;
        if (giftType != null ? !giftType.equals(spreeGift.giftType) : spreeGift.giftType != null) return false;
        if (status != null ? !status.equals(spreeGift.status) : spreeGift.status != null) return false;
        if (hotelNo != null ? !hotelNo.equals(spreeGift.hotelNo) : spreeGift.hotelNo != null) return false;
        if (createUser != null ? !createUser.equals(spreeGift.createUser) : spreeGift.createUser != null) return false;
        if (updateUser != null ? !updateUser.equals(spreeGift.updateUser) : spreeGift.updateUser != null) return false;
        if (createTime != null ? !createTime.equals(spreeGift.createTime) : spreeGift.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(spreeGift.updateTime) : spreeGift.updateTime != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(spreeGift.deleteFlag) : spreeGift.deleteFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = giftId != null ? giftId.hashCode() : 0;
        result = 31 * result + (giftName != null ? giftName.hashCode() : 0);
        result = 31 * result + (giftType != null ? giftType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        return result;
    }
}
