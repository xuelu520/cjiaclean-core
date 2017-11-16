package com.huazhu.hvip.inventory.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-07-27 16:03
 **/
@Entity
public class Warehouse {
    private Long warehouseId;
    private String warehouseName;
    private Long provinceId;
    private String warehouseType;
    private String orgType;
    private String province;
    private Long cityId;
    private String city;
    private Long regionId;
    private String region;
    private String address;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private String deleteFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "warehouseId")
    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }


    @Basic
    @Column(name = "warehouseType")
    public String getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(String warehouseType) {
        this.warehouseType = warehouseType;
    }

    @Basic
    @Column(name = "orgType")
    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Basic
    @Column(name = "warehouseName")
    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (warehouseId != null ? !warehouseId.equals(warehouse.warehouseId) : warehouse.warehouseId != null)
            return false;
        if (warehouseName != null ? !warehouseName.equals(warehouse.warehouseName) : warehouse.warehouseName != null)
            return false;
        if (provinceId != null ? !provinceId.equals(warehouse.provinceId) : warehouse.provinceId != null) return false;
        if (province != null ? !province.equals(warehouse.province) : warehouse.province != null) return false;
        if (cityId != null ? !cityId.equals(warehouse.cityId) : warehouse.cityId != null) return false;
        if (city != null ? !city.equals(warehouse.city) : warehouse.city != null) return false;
        if (regionId != null ? !regionId.equals(warehouse.regionId) : warehouse.regionId != null) return false;
        if (region != null ? !region.equals(warehouse.region) : warehouse.region != null) return false;
        if (address != null ? !address.equals(warehouse.address) : warehouse.address != null) return false;
        if (createUser != null ? !createUser.equals(warehouse.createUser) : warehouse.createUser != null) return false;
        if (createTime != null ? !createTime.equals(warehouse.createTime) : warehouse.createTime != null) return false;
        if (updateUser != null ? !updateUser.equals(warehouse.updateUser) : warehouse.updateUser != null) return false;
        if (updateTime != null ? !updateTime.equals(warehouse.updateTime) : warehouse.updateTime != null) return false;
        return !(deleteFlag != null ? !deleteFlag.equals(warehouse.deleteFlag) : warehouse.deleteFlag != null);

    }

    @Override
    public int hashCode() {
        int result = warehouseId != null ? warehouseId.hashCode() : 0;
        result = 31 * result + (warehouseName != null ? warehouseName.hashCode() : 0);
        result = 31 * result + (provinceId != null ? provinceId.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        return result;
    }
}
