package com.huazhu.hvip.company.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-10-11 18:08
 **/
@Entity
public class Company {
    private Long companyId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "companyId")
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    private String companyNo;

    @Basic
    @javax.persistence.Column(name = "companyNo")
    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    private String companySn;

    @Basic
    @javax.persistence.Column(name = "companySn")
    public String getCompanySn() {
        return companySn;
    }

    public void setCompanySn(String companySn) {
        this.companySn = companySn;
    }

    private String companyName;

    @Basic
    @javax.persistence.Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    private String region;

    @Basic
    @javax.persistence.Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    private String companyType;

    @Basic
    @javax.persistence.Column(name = "companyType")
    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
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

    private String companyContacts;

    @Basic
    @javax.persistence.Column(name = "companyContacts")
    public String getCompanyContacts() {
        return companyContacts;
    }

    public void setCompanyContacts(String companyContacts) {
        this.companyContacts = companyContacts;
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

    private String description;

    @Basic
    @javax.persistence.Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    private Long picId;

    @Basic
    @javax.persistence.Column(name = "picId")
    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    private String picUrl;

    @Basic
    @javax.persistence.Column(name = "picUrl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    private Long levelId;

    @Basic
    @javax.persistence.Column(name = "levelId")
    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    private Integer point;

    @Basic
    @javax.persistence.Column(name = "point")
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (companyId != null ? !companyId.equals(company.companyId) : company.companyId != null) return false;
        if (companyNo != null ? !companyNo.equals(company.companyNo) : company.companyNo != null) return false;
        if (companySn != null ? !companySn.equals(company.companySn) : company.companySn != null) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (provinceId != null ? !provinceId.equals(company.provinceId) : company.provinceId != null) return false;
        if (cityId != null ? !cityId.equals(company.cityId) : company.cityId != null) return false;
        if (regionId != null ? !regionId.equals(company.regionId) : company.regionId != null) return false;
        if (province != null ? !province.equals(company.province) : company.province != null) return false;
        if (city != null ? !city.equals(company.city) : company.city != null) return false;
        if (region != null ? !region.equals(company.region) : company.region != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (companyType != null ? !companyType.equals(company.companyType) : company.companyType != null) return false;
        if (telNo != null ? !telNo.equals(company.telNo) : company.telNo != null) return false;
        if (companyContacts != null ? !companyContacts.equals(company.companyContacts) : company.companyContacts != null)
            return false;
        if (website != null ? !website.equals(company.website) : company.website != null) return false;
        if (description != null ? !description.equals(company.description) : company.description != null) return false;
        if (status != null ? !status.equals(company.status) : company.status != null) return false;
        if (picId != null ? !picId.equals(company.picId) : company.picId != null) return false;
        if (picUrl != null ? !picUrl.equals(company.picUrl) : company.picUrl != null) return false;
        if (createTime != null ? !createTime.equals(company.createTime) : company.createTime != null) return false;
        if (createUser != null ? !createUser.equals(company.createUser) : company.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(company.updateTime) : company.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(company.updateUser) : company.updateUser != null) return false;
        if (levelId != null ? !levelId.equals(company.levelId) : company.levelId != null) return false;
        return !(point != null ? !point.equals(company.point) : company.point != null);

    }

    @Override
    public int hashCode() {
        int result = companyId != null ? companyId.hashCode() : 0;
        result = 31 * result + (companyNo != null ? companyNo.hashCode() : 0);
        result = 31 * result + (companySn != null ? companySn.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (provinceId != null ? provinceId.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (companyType != null ? companyType.hashCode() : 0);
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (companyContacts != null ? companyContacts.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (picId != null ? picId.hashCode() : 0);
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (levelId != null ? levelId.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        return result;
    }
}
