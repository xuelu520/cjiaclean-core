/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelControlPrice.java
 * Author:   HUQIANBO001
 * Date:     2016-06-13 16:50:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-06-13 16:50:07><version><desc>
 */

package com.huazhu.hvip.operation.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
public class HotelControlPrice extends DynamicField {
    private Long controlPriceId;
    private Long hotelId;
    private String hotelNo;
    private String hotelName;
    private String remark;
    private String status;
    private String createUser;
    private Date createTime;
    private String verifierName;
    private Date verificationTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "controlPriceId")
    public Long getControlPriceId() {
        return controlPriceId;
    }

    public void setControlPriceId(Long controlPriceId) {
        this.controlPriceId = controlPriceId;
    }

    @Basic
    @Column(name = "hotelId")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "hotelNo")
    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
    @Column(name = "verifierName")
    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    @Basic
    @Column(name = "verificationTime")
    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelControlPrice that = (HotelControlPrice) o;

        if (controlPriceId != null ? !controlPriceId.equals(that.controlPriceId) : that.controlPriceId != null)
            return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (hotelNo != null ? !hotelNo.equals(that.hotelNo) : that.hotelNo != null) return false;
        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (verifierName != null ? !verifierName.equals(that.verifierName) : that.verifierName != null) return false;
        if (verificationTime != null ? !verificationTime.equals(that.verificationTime) : that.verificationTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = controlPriceId != null ? controlPriceId.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (verifierName != null ? verifierName.hashCode() : 0);
        result = 31 * result + (verificationTime != null ? verificationTime.hashCode() : 0);
        return result;
    }
}
