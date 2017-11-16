/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Area.java
 * Author:   admin
 * Date:     2016-03-20 16:22:55
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:55><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "area")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Area extends BaseObject{

    private static final long serialVersionUID = -7482530894850026233L;
    private Long areaId;
    private String areaType;
    private String areaName;
    private String pinyin;
    private String areacode;
    private Long parentId;
    private Double longitude;
    private Double latitude;
    private String address;
    private Integer orderNum;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "areaId")
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "areaType")
    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    @Basic
    @Column(name = "areaName")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "pinyin")
    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Basic
    @Column(name = "areacode")
    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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
    @Column(name = "orderNum")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Area area = (Area) o;

        if (areaId != area.areaId) return false;
        if (areaType != null ? !areaType.equals(area.areaType) : area.areaType != null) return false;
        if (areaName != null ? !areaName.equals(area.areaName) : area.areaName != null) return false;
        if (pinyin != null ? !pinyin.equals(area.pinyin) : area.pinyin != null) return false;
        if (areacode != null ? !areacode.equals(area.areacode) : area.areacode != null) return false;
        if (parentId != null ? !parentId.equals(area.parentId) : area.parentId != null) return false;
        if (longitude != null ? !longitude.equals(area.longitude) : area.longitude != null) return false;
        if (latitude != null ? !latitude.equals(area.latitude) : area.latitude != null) return false;
        if (address != null ? !address.equals(area.address) : area.address != null) return false;
        if (orderNum != null ? !orderNum.equals(area.orderNum) : area.orderNum != null) return false;
        if (status != null ? !status.equals(area.status) : area.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (areaId ^ (areaId >>> 32));
        result = 31 * result + (areaType != null ? areaType.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (pinyin != null ? pinyin.hashCode() : 0);
        result = 31 * result + (areacode != null ? areacode.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
