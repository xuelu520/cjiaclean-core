/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelVO.java
 * Author:   chenli
 * Date:     2016-03-23 17:51:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:51:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.vo;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class HotelVO implements Serializable{
    private Long hotelId;

    private String hotelName;

    private String enName;

    private String deleteFlag;

    private String alias;

    private String province;

    private String city;

    private String area;

    private String address;

    private String hotelType;

    private String telNo;

    private String hotelEmail;

    private String fourTelphone;

    private String website;

    private Integer floorNum;

    private String breafIntroduction;

    private String onecharacter;

    private Double longitude;

    private Double latitude;

    private String status;

    private Date createTime;

    private String fullArea;

    private String pmsid;

    private String ncCode;

    private String addressTip;

    private String hotelUniqueNo;

    private String hotelNo;

    private String hotelMgrEmpNo;

    private String hotelMgrAd;


    private String hotelMgr;

    private String cityAreaId;

    private String cityAreaName;

    private String provinceId;

    private String areaId;

    private String telAreaNo;

    private String cityId;

    private String mgrModel;

    private String openVipFlag;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getFourTelphone() {
        return fourTelphone;
    }

    public void setFourTelphone(String fourTelphone) {
        this.fourTelphone = fourTelphone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public String getBreafIntroduction() {
        return breafIntroduction;
    }

    public void setBreafIntroduction(String breafIntroduction) {
        this.breafIntroduction = breafIntroduction;
    }

    public String getOnecharacter() {
        return onecharacter;
    }

    public void setOnecharacter(String onecharacter) {
        this.onecharacter = onecharacter;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFullArea() {
        return fullArea;
    }

    public void setFullArea(String fullArea) {
        this.fullArea = fullArea;
    }

    public String getPmsid() {
        return pmsid;
    }

    public void setPmsid(String pmsid) {
        this.pmsid = pmsid;
    }

    public String getNcCode() {
        return ncCode;
    }

    public void setNcCode(String ncCode) {
        this.ncCode = ncCode;
    }

    public String getAddressTip() {
        return addressTip;
    }

    public void setAddressTip(String addressTip) {
        this.addressTip = addressTip;
    }

    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelMgrEmpNo() {
        return hotelMgrEmpNo;
    }

    public void setHotelMgrEmpNo(String hotelMgrEmpNo) {
        this.hotelMgrEmpNo = hotelMgrEmpNo;
    }

    public String getHotelMgrAd() {
        return hotelMgrAd;
    }

    public void setHotelMgrAd(String hotelMgrAd) {
        this.hotelMgrAd = hotelMgrAd;
    }

    public String getHotelMgr() {
        return hotelMgr;
    }

    public void setHotelMgr(String hotelMgr) {
        this.hotelMgr = hotelMgr;
    }

    public String getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(String cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public String getCityAreaName() {
        return cityAreaName;
    }

    public void setCityAreaName(String cityAreaName) {
        this.cityAreaName = cityAreaName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getTelAreaNo() {
        return telAreaNo;
    }

    public void setTelAreaNo(String telAreaNo) {
        this.telAreaNo = telAreaNo;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getMgrModel() {
        return mgrModel;
    }

    public void setMgrModel(String mgrModel) {
        this.mgrModel = mgrModel;
    }

    public String getOpenVipFlag() {
        return openVipFlag;
    }

    public void setOpenVipFlag(String openVipFlag) {
        this.openVipFlag = openVipFlag;
    }
}
