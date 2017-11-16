/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Store.java
 * Author:   chenli
 * Date:     2016-03-23 15:33:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 15:33:13> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
public class Store extends DynamicField {
    private Long storeId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "storeId")
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long supplierId;

    public String supplierNo;

    public String supplierSn;

    public String supplierName;

    private String storeName;

    private Long provinceId;

    private Long cityId;

    private Long regionId;

    private String province;

    private String city;

    private String region;

    private String address;

    private String zipCode;

    private String telNo;

    private Date openTime;

    private Date closeTime;

    private String status;

    private Long picId;

    private Integer sort;

    private String bankAccountName;

    private String description;

    private String bankAccountNumber;

    private String bankName;

    private String bankCode;

    private String bankProvince;

    private String bankCity;

    private String bankRegion;

    private Long bankProvinceId;

    private Long bankCityId;

    private Long bankRegionId;

    private Long storeLevelId;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer recommendFlag;

    private Integer storeTheme;

    private Integer storeCredit;

    private Float storeDesccredit;

    private Float storeServicecredit;

    private Float storeDeliverycredit;

    private Integer storeCollect;

    private Integer storeAuth;

    private Integer nameAuth;

    private String storeBanner;

    private String qq;

    @Basic
    @Column(name = "supplierId")
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "supplierName")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "supplierSn")
    public String getSupplierSn() {
        return supplierSn;
    }

    public void setSupplierSn(String supplierSn) {
        this.supplierSn = supplierSn;
    }

    @Basic
    @Column(name = "supplierNo")
    public String getSupplierNo() {
        return supplierNo;
    }


    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    @Basic
    @Column(name = "storeName")
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "provinceId")
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "cityId")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "regionId")
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "telNo")
    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
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
    @Column(name = "openTime")
    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    @Basic
    @Column(name = "closeTime")
    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "picId")
    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "bankAccountName")
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    @Basic
    @Column(name = "bankAccountNumber")
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Basic
    @Column(name = "bankName")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "bankCode")
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Basic
    @Column(name = "bankProvince")
    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    @Basic
    @Column(name = "bankCity")
    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    @Basic
    @Column(name = "bankRegion")
    public String getBankRegion() {
        return bankRegion;
    }

    public void setBankRegion(String bankRegion) {
        this.bankRegion = bankRegion;
    }

    @Basic
    @Column(name = "bankProvinceId")
    public Long getBankProvinceId() {
        return bankProvinceId;
    }

    public void setBankProvinceId(Long bankProvinceId) {
        this.bankProvinceId = bankProvinceId;
    }

    @Basic
    @Column(name = "bankCityId")
    public Long getBankCityId() {
        return bankCityId;
    }

    public void setBankCityId(Long bankCityId) {
        this.bankCityId = bankCityId;
    }

    @Basic
    @Column(name = "bankRegionId")
    public Long getBankRegionId() {
        return bankRegionId;
    }

    public void setBankRegionId(Long bankRegionId) {
        this.bankRegionId = bankRegionId;
    }

    @Basic
    @Column(name = "storeLevelId")
    public Long getStoreLevelId() {
        return storeLevelId;
    }

    public void setStoreLevelId(Long storeLevelId) {
        this.storeLevelId = storeLevelId;
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
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "recommendFlag")
    public Integer getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(Integer recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    @Basic
    @Column(name = "storeTheme")
    public Integer getStoreTheme() {
        return storeTheme;
    }

    public void setStoreTheme(Integer storeTheme) {
        this.storeTheme = storeTheme;
    }

    @Basic
    @Column(name = "storeCredit")
    public Integer getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(Integer storeCredit) {
        this.storeCredit = storeCredit;
    }

    private Float praiseRate;

    @Basic
    @Column(name = "praiseRate")
    public Float getPraiseRate() {
        return praiseRate;
    }

    public void setPraiseRate(Float praiseRate) {
        this.praiseRate = praiseRate;
    }

    @Basic
    @Column(name = "storeDesccredit")
    public Float getStoreDesccredit() {
        return storeDesccredit;
    }

    public void setStoreDesccredit(Float storeDesccredit) {
        this.storeDesccredit = storeDesccredit;
    }

    @Basic
    @Column(name = "storeServicecredit")
    public Float getStoreServicecredit() {
        return storeServicecredit;
    }

    public void setStoreServicecredit(Float storeServicecredit) {
        this.storeServicecredit = storeServicecredit;
    }

    @Basic
    @Column(name = "storeDeliverycredit")
    public Float getStoreDeliverycredit() {
        return storeDeliverycredit;
    }

    public void setStoreDeliverycredit(Float storeDeliverycredit) {
        this.storeDeliverycredit = storeDeliverycredit;
    }

    @Basic
    @Column(name = "storeCollect")
    public Integer getStoreCollect() {
        return storeCollect;
    }

    public void setStoreCollect(Integer storeCollect) {
        this.storeCollect = storeCollect;
    }

    @Basic
    @Column(name = "storeAuth")
    public Integer getStoreAuth() {
        return storeAuth;
    }

    public void setStoreAuth(Integer storeAuth) {
        this.storeAuth = storeAuth;
    }

    @Basic
    @Column(name = "nameAuth")
    public Integer getNameAuth() {
        return nameAuth;
    }

    public void setNameAuth(Integer nameAuth) {
        this.nameAuth = nameAuth;
    }

    @Basic
    @Column(name = "storeBanner")
    public String getStoreBanner() {
        return storeBanner;
    }

    public void setStoreBanner(String storeBanner) {
        this.storeBanner = storeBanner;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


}
