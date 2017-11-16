package com.huazhu.hvip.order.shipments.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_shipments")
public class Shipments extends DynamicField {
    private Long shipmentsId;
    private Long orderId;
    private String shipmentsType;
    private String receiveName;
    private Long provinceId;
    private Long cityId;
    private Long regionId;
    private String region;
    private String city;
    private String province;
    private String receiveAddr;
    private String receiveZipCode;
    private String receiveTelNo;
    private String receiveMobile;
    private String receiveEmail;
    private Long shipId;
    private String shipName;
    private String shipNo;
    private String shipCode;
    private BigDecimal money;
    private String remark;
    private Date createTime;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shipmentsId")
    public Long getShipmentsId() {
        return shipmentsId;
    }

    public void setShipmentsId(Long shipmentsId) {
        this.shipmentsId = shipmentsId;
    }


    @Basic
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "shipmentsType")
    public String getShipmentsType() {
        return shipmentsType;
    }

    public void setShipmentsType(String shipmentsType) {
        this.shipmentsType = shipmentsType;
    }


    @Basic
    @Column(name = "receiveName")
    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
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
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    @Basic
    @Column(name = "receiveAddr")
    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }


    @Basic
    @Column(name = "receiveZipCode")
    public String getReceiveZipCode() {
        return receiveZipCode;
    }

    public void setReceiveZipCode(String receiveZipCode) {
        this.receiveZipCode = receiveZipCode;
    }


    @Basic
    @Column(name = "receiveTelNo")
    public String getReceiveTelNo() {
        return receiveTelNo;
    }

    public void setReceiveTelNo(String receiveTelNo) {
        this.receiveTelNo = receiveTelNo;
    }


    @Basic
    @Column(name = "receiveMobile")
    public String getReceiveMobile() {
        return receiveMobile;
    }

    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }


    @Basic
    @Column(name = "receiveEmail")
    public String getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail;
    }


    @Basic
    @Column(name = "shipId")
    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }


    @Basic
    @Column(name = "shipName")
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }


    @Basic
    @Column(name = "shipNo")
    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }


    @Basic
    @Column(name = "shipCode")
    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }


    @Basic
    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String createUser;

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
}
