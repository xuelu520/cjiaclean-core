/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Technician.java
 * Author:   lijing
 * Date:     2016-05-03 19:06:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-03 19:06:42> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.model;

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
@javax.persistence.Table(name = "technician")
public class Technician extends DynamicField{
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long technicianId;

    @Basic
    @javax.persistence.Column(name = "technicianId")
    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    private String description;

    @Basic
    @javax.persistence.Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String phone;

    @Basic
    @javax.persistence.Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String tags;

    @Basic
    @javax.persistence.Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    private Integer orderAmount;

    @Basic
    @javax.persistence.Column(name = "orderAmount")
    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    private Integer workingAge;

    @Basic
    @javax.persistence.Column(name = "workingAge")
    public Integer getWorkingAge() {
        return workingAge;
    }

    public void setWorkingAge(Integer workingAge) {
        this.workingAge = workingAge;
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

    private Double Longitude;

    @Basic
    @javax.persistence.Column(name = "Longitude")
    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
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

    private String photoUrl;

    @Basic
    @javax.persistence.Column(name = "photoURL")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    private String type;

    @Basic
    @javax.persistence.Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    private Integer age;

    @Basic
    @javax.persistence.Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
