package com.huazhu.hvip.user.opUser.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-07-26 12:38
 **/
@Entity
@Table(name = "employee")
public class Employee {
    private Long empId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "empId")
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    private String empNo;

    @Basic
    @javax.persistence.Column(name = "empNo")
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    private String empAd;

    @Basic
    @javax.persistence.Column(name = "empAD")
    public String getEmpAd() {
        return empAd;
    }

    public void setEmpAd(String empAd) {
        this.empAd = empAd;
    }

    private String lastName;

    @Basic
    @javax.persistence.Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;

    @Basic
    @javax.persistence.Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String sex;

    @Basic
    @javax.persistence.Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Integer age;

    @Basic
    @javax.persistence.Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String email;

    @Basic
    @javax.persistence.Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private Integer workage;

    @Basic
    @javax.persistence.Column(name = "workage")
    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
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


    private Integer provinceId;
    @Basic
    @javax.persistence.Column(name = "provinceId")
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    private Integer cityId;
    @Basic
    @javax.persistence.Column(name = "cityId")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    private Integer regionId;

    @Basic
    @javax.persistence.Column(name = "regionId")
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }


    private Long orgId;

    @Basic
    @javax.persistence.Column(name = "orgId")
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    private String certificate;

    @Basic
    @javax.persistence.Column(name = "certificate")
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    private String skill;

    @Basic
    @javax.persistence.Column(name = "skill")
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    private Long superiorId;

    @Basic
    @javax.persistence.Column(name = "superiorId")
    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    private Integer level;

    @Basic
    @javax.persistence.Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    private String userdept;

    @Basic
    @javax.persistence.Column(name = "userdept")
    public String getUserdept() {
        return userdept;
    }

    public void setUserdept(String userdept) {
        this.userdept = userdept;
    }

    private String position;

    @Basic
    @javax.persistence.Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    private String remark;

    @Basic
    @javax.persistence.Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empId != null ? !empId.equals(employee.empId) : employee.empId != null) return false;
        if (empNo != null ? !empNo.equals(employee.empNo) : employee.empNo != null) return false;
        if (empAd != null ? !empAd.equals(employee.empAd) : employee.empAd != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (sex != null ? !sex.equals(employee.sex) : employee.sex != null) return false;
        if (age != null ? !age.equals(employee.age) : employee.age != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (telNo != null ? !telNo.equals(employee.telNo) : employee.telNo != null) return false;
        if (mobile != null ? !mobile.equals(employee.mobile) : employee.mobile != null) return false;
        if (workage != null ? !workage.equals(employee.workage) : employee.workage != null) return false;
        if (province != null ? !province.equals(employee.province) : employee.province != null) return false;
        if (city != null ? !city.equals(employee.city) : employee.city != null) return false;
        if (region != null ? !region.equals(employee.region) : employee.region != null) return false;
        if (orgId != null ? !orgId.equals(employee.orgId) : employee.orgId != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (certificate != null ? !certificate.equals(employee.certificate) : employee.certificate != null)
            return false;
        if (status != null ? !status.equals(employee.status) : employee.status != null) return false;
        if (skill != null ? !skill.equals(employee.skill) : employee.skill != null) return false;
        if (superiorId != null ? !superiorId.equals(employee.superiorId) : employee.superiorId != null) return false;
        if (level != null ? !level.equals(employee.level) : employee.level != null) return false;
        if (userdept != null ? !userdept.equals(employee.userdept) : employee.userdept != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        if (createTime != null ? !createTime.equals(employee.createTime) : employee.createTime != null) return false;
        if (createUser != null ? !createUser.equals(employee.createUser) : employee.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(employee.updateTime) : employee.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(employee.updateUser) : employee.updateUser != null) return false;
        if (remark != null ? !remark.equals(employee.remark) : employee.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empId != null ? empId.hashCode() : 0;
        result = 31 * result + (empNo != null ? empNo.hashCode() : 0);
        result = 31 * result + (empAd != null ? empAd.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (workage != null ? workage.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (certificate != null ? certificate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        result = 31 * result + (superiorId != null ? superiorId.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (userdept != null ? userdept.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
