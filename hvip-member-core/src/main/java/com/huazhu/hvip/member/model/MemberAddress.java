/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberAddress.java
 * Author:   lijing
 * Date:     2016-03-20 11:59:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 11:59:23> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "memberaddress")
public class MemberAddress extends DynamicField{
    private Long addressId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "addressId")
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    private Long memberId;

    @Basic
    @javax.persistence.Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    private String contactName;

    @Basic
    @javax.persistence.Column(name = "contactName")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    private String country;

    @Basic
    @javax.persistence.Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private Long provinceId;

    @Basic
    @javax.persistence.Column(name = "provinceId")
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    private Long cityId;

    @Basic
    @javax.persistence.Column(name = "cityId")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    private Long regionId;

    @Basic
    @javax.persistence.Column(name = "regionId")
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    private String region;

    @Basic
    @javax.persistence.Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    private String city;

    @Basic
    @javax.persistence.Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String province;

    @Basic
    @javax.persistence.Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    private String addr;

    @Basic
    @javax.persistence.Column(name = "addr")
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    private String zip;

    @Basic
    @javax.persistence.Column(name = "zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    private String telNo;

    @Basic
    @javax.persistence.Column(name = "telNo")
    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    private String mobile;

    @Basic
    @javax.persistence.Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String defaultFlag;

    @Basic
    @javax.persistence.Column(name = "defaultFlag")
    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    private String deleteFlag;

    @Basic
    @javax.persistence.Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    private Date createTime;

    @Basic
    @javax.persistence.Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String createUser;

    @Basic
    @javax.persistence.Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    private Date updateTime;

    @Basic
    @javax.persistence.Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private String updateUser;

    @Basic
    @javax.persistence.Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
