/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Hotel.java
 * Author:   chenli
 * Date:     2016-03-23 17:11:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:11:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.sql.Timestamp;
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
public class Hotel extends DynamicField {
    private Long hotelId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "hotelId")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    private String hotelName;

    @Basic
    @javax.persistence.Column(name = "hotelName")
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    private String enName;

    @Basic
    @javax.persistence.Column(name = "enName")
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
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

    private String alias;

    @Basic
    @javax.persistence.Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    private String city;

    @Basic
    @javax.persistence.Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String area;

    @Basic
    @javax.persistence.Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String hotelType;

    @Basic
    @javax.persistence.Column(name = "hotelType")
    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
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

    private String hotelEmail;

    @Basic
    @javax.persistence.Column(name = "hotelEmail")
    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    private String fourTelphone;

    @Basic
    @javax.persistence.Column(name = "fourTelphone")
    public String getFourTelphone() {
        return fourTelphone;
    }

    public void setFourTelphone(String fourTelphone) {
        this.fourTelphone = fourTelphone;
    }

    private String website;

    @Basic
    @javax.persistence.Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private Integer floorNum;

    @Basic
    @javax.persistence.Column(name = "floorNum")
    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    private String breafIntroduction;

    @Basic
    @javax.persistence.Column(name = "breafIntroduction")
    public String getBreafIntroduction() {
        return breafIntroduction;
    }

    public void setBreafIntroduction(String breafIntroduction) {
        this.breafIntroduction = breafIntroduction;
    }

    private String onecharacter;

    @Basic
    @javax.persistence.Column(name = "onecharacter")
    public String getOnecharacter() {
        return onecharacter;
    }

    public void setOnecharacter(String onecharacter) {
        this.onecharacter = onecharacter;
    }

    private Double longitude;

    @Basic
    @javax.persistence.Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    private Double latitude;

    @Basic
    @javax.persistence.Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    private String fullArea;

    @Basic
    @javax.persistence.Column(name = "fullArea")
    public String getFullArea() {
        return fullArea;
    }

    public void setFullArea(String fullArea) {
        this.fullArea = fullArea;
    }

    private String pmsid;

    @Basic
    @javax.persistence.Column(name = "PMSID")
    public String getPmsid() {
        return pmsid;
    }

    public void setPmsid(String pmsid) {
        this.pmsid = pmsid;
    }

    private String ncCode;

    @Basic
    @javax.persistence.Column(name = "ncCode")
    public String getNcCode() {
        return ncCode;
    }

    public void setNcCode(String ncCode) {
        this.ncCode = ncCode;
    }

    private String addressTip;

    @Basic
    @javax.persistence.Column(name = "addressTip")
    public String getAddressTip() {
        return addressTip;
    }

    public void setAddressTip(String addressTip) {
        this.addressTip = addressTip;
    }

    private String hotelUniqueNo;

    @Basic
    @javax.persistence.Column(name = "hotelUniqueNo")
    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    private String hotelNo;

    @Basic
    @javax.persistence.Column(name = "hotelNo")
    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    private String hotelMgrEmpNo;

    @Basic
    @javax.persistence.Column(name = "hotelMgrEmpNo")
    public String getHotelMgrEmpNo() {
        return hotelMgrEmpNo;
    }

    public void setHotelMgrEmpNo(String hotelMgrEmpNo) {
        this.hotelMgrEmpNo = hotelMgrEmpNo;
    }

    private String hotelMgrAd;

    @Basic
    @javax.persistence.Column(name = "hotelMgrAd")
    public String getHotelMgrAd() {
        return hotelMgrAd;
    }

    public void setHotelMgrAd(String hotelMgrAd) {
        this.hotelMgrAd = hotelMgrAd;
    }

    private String hotelMgr;

    @Basic
    @javax.persistence.Column(name = "hotelMgr")
    public String getHotelMgr() {
        return hotelMgr;
    }

    public void setHotelMgr(String hotelMgr) {
        this.hotelMgr = hotelMgr;
    }

    private String cityAreaId;

    @Basic
    @javax.persistence.Column(name = "cityAreaId")
    public String getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(String cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    private String cityAreaName;

    @Basic
    @javax.persistence.Column(name = "cityAreaName")
    public String getCityAreaName() {
        return cityAreaName;
    }

    public void setCityAreaName(String cityAreaName) {
        this.cityAreaName = cityAreaName;
    }

    private String provinceId;

    @Basic
    @javax.persistence.Column(name = "provinceId")
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    private String areaId;

    @Basic
    @javax.persistence.Column(name = "areaId")
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    private String telAreaNo;

    @Basic
    @javax.persistence.Column(name = "telAreaNo")
    public String getTelAreaNo() {
        return telAreaNo;
    }

    public void setTelAreaNo(String telAreaNo) {
        this.telAreaNo = telAreaNo;
    }

    private String cityId;

    @Basic
    @javax.persistence.Column(name = "cityId")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    private String mgrModel;

    @Basic
    @javax.persistence.Column(name = "mgrModel")
    public String getMgrModel() {
        return mgrModel;
    }

    public void setMgrModel(String mgrModel) {
        this.mgrModel = mgrModel;
    }

    private String openVipFlag;

    @Basic
    @javax.persistence.Column(name = "openVipFlag")
    public String getOpenVipFlag() {
        return openVipFlag;
    }

    public void setOpenVipFlag(String openVipFlag) {
        this.openVipFlag = openVipFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hotel hotel = (Hotel) o;

        if (hotelId != null ? !hotelId.equals(hotel.hotelId) : hotel.hotelId != null) return false;
        if (hotelName != null ? !hotelName.equals(hotel.hotelName) : hotel.hotelName != null) return false;
        if (enName != null ? !enName.equals(hotel.enName) : hotel.enName != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(hotel.deleteFlag) : hotel.deleteFlag != null) return false;
        if (alias != null ? !alias.equals(hotel.alias) : hotel.alias != null) return false;
        if (province != null ? !province.equals(hotel.province) : hotel.province != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        if (area != null ? !area.equals(hotel.area) : hotel.area != null) return false;
        if (address != null ? !address.equals(hotel.address) : hotel.address != null) return false;
        if (hotelType != null ? !hotelType.equals(hotel.hotelType) : hotel.hotelType != null) return false;
        if (telNo != null ? !telNo.equals(hotel.telNo) : hotel.telNo != null) return false;
        if (hotelEmail != null ? !hotelEmail.equals(hotel.hotelEmail) : hotel.hotelEmail != null) return false;
        if (fourTelphone != null ? !fourTelphone.equals(hotel.fourTelphone) : hotel.fourTelphone != null) return false;
        if (website != null ? !website.equals(hotel.website) : hotel.website != null) return false;
        if (floorNum != null ? !floorNum.equals(hotel.floorNum) : hotel.floorNum != null) return false;
        if (breafIntroduction != null ? !breafIntroduction.equals(hotel.breafIntroduction) : hotel.breafIntroduction != null)
            return false;
        if (onecharacter != null ? !onecharacter.equals(hotel.onecharacter) : hotel.onecharacter != null) return false;
        if (longitude != null ? !longitude.equals(hotel.longitude) : hotel.longitude != null) return false;
        if (latitude != null ? !latitude.equals(hotel.latitude) : hotel.latitude != null) return false;
        if (status != null ? !status.equals(hotel.status) : hotel.status != null) return false;
        if (createTime != null ? !createTime.equals(hotel.createTime) : hotel.createTime != null) return false;
        if (fullArea != null ? !fullArea.equals(hotel.fullArea) : hotel.fullArea != null) return false;
        if (pmsid != null ? !pmsid.equals(hotel.pmsid) : hotel.pmsid != null) return false;
        if (ncCode != null ? !ncCode.equals(hotel.ncCode) : hotel.ncCode != null) return false;
        if (addressTip != null ? !addressTip.equals(hotel.addressTip) : hotel.addressTip != null) return false;
        if (hotelUniqueNo != null ? !hotelUniqueNo.equals(hotel.hotelUniqueNo) : hotel.hotelUniqueNo != null)
            return false;
        if (hotelNo != null ? !hotelNo.equals(hotel.hotelNo) : hotel.hotelNo != null) return false;
        if (hotelMgrEmpNo != null ? !hotelMgrEmpNo.equals(hotel.hotelMgrEmpNo) : hotel.hotelMgrEmpNo != null)
            return false;
        if (hotelMgrAd != null ? !hotelMgrAd.equals(hotel.hotelMgrAd) : hotel.hotelMgrAd != null) return false;
        if (hotelMgr != null ? !hotelMgr.equals(hotel.hotelMgr) : hotel.hotelMgr != null) return false;
        if (cityAreaId != null ? !cityAreaId.equals(hotel.cityAreaId) : hotel.cityAreaId != null) return false;
        if (cityAreaName != null ? !cityAreaName.equals(hotel.cityAreaName) : hotel.cityAreaName != null) return false;
        if (provinceId != null ? !provinceId.equals(hotel.provinceId) : hotel.provinceId != null) return false;
        if (areaId != null ? !areaId.equals(hotel.areaId) : hotel.areaId != null) return false;
        if (telAreaNo != null ? !telAreaNo.equals(hotel.telAreaNo) : hotel.telAreaNo != null) return false;
        if (cityId != null ? !cityId.equals(hotel.cityId) : hotel.cityId != null) return false;
        if (mgrModel != null ? !mgrModel.equals(hotel.mgrModel) : hotel.mgrModel != null) return false;
        return !(openVipFlag != null ? !openVipFlag.equals(hotel.openVipFlag) : hotel.openVipFlag != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (enName != null ? enName.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (hotelType != null ? hotelType.hashCode() : 0);
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (hotelEmail != null ? hotelEmail.hashCode() : 0);
        result = 31 * result + (fourTelphone != null ? fourTelphone.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (floorNum != null ? floorNum.hashCode() : 0);
        result = 31 * result + (breafIntroduction != null ? breafIntroduction.hashCode() : 0);
        result = 31 * result + (onecharacter != null ? onecharacter.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (fullArea != null ? fullArea.hashCode() : 0);
        result = 31 * result + (pmsid != null ? pmsid.hashCode() : 0);
        result = 31 * result + (ncCode != null ? ncCode.hashCode() : 0);
        result = 31 * result + (addressTip != null ? addressTip.hashCode() : 0);
        result = 31 * result + (hotelUniqueNo != null ? hotelUniqueNo.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        result = 31 * result + (hotelMgrEmpNo != null ? hotelMgrEmpNo.hashCode() : 0);
        result = 31 * result + (hotelMgrAd != null ? hotelMgrAd.hashCode() : 0);
        result = 31 * result + (hotelMgr != null ? hotelMgr.hashCode() : 0);
        result = 31 * result + (cityAreaId != null ? cityAreaId.hashCode() : 0);
        result = 31 * result + (cityAreaName != null ? cityAreaName.hashCode() : 0);
        result = 31 * result + (provinceId != null ? provinceId.hashCode() : 0);
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (telAreaNo != null ? telAreaNo.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (mgrModel != null ? mgrModel.hashCode() : 0);
        result = 31 * result + (openVipFlag != null ? openVipFlag.hashCode() : 0);
        return result;
    }
}
