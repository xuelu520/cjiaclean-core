package com.huazhu.hvip.inventory.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-07-27 16:03
 **/
@Entity
public class Inventory {
    private Long inventoryId;
    private Long goodsId;
    private Long productId;
    private Long materielId;
    private Long warehouseId;
    private Long unitId;
    private String unit;
    private Integer inventoryNum;
    private Integer freeInventoryNum;
    private Integer warnInventoryNum;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventoryId")
    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "productId")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "materielId")
    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    @Basic
    @Column(name = "warehouseId")
    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "unitId")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "inventoryNum")
    public Integer getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    @Basic
    @Column(name = "freeInventoryNum")
    public Integer getFreeInventoryNum() {
        return freeInventoryNum;
    }

    public void setFreeInventoryNum(Integer freeInventoryNum) {
        this.freeInventoryNum = freeInventoryNum;
    }

    @Basic
    @Column(name = "warnInventoryNum")
    public Integer getWarnInventoryNum() {
        return warnInventoryNum;
    }

    public void setWarnInventoryNum(Integer warnInventoryNum) {
        this.warnInventoryNum = warnInventoryNum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (inventoryId != null ? !inventoryId.equals(inventory.inventoryId) : inventory.inventoryId != null)
            return false;
        if (goodsId != null ? !goodsId.equals(inventory.goodsId) : inventory.goodsId != null) return false;
        if (productId != null ? !productId.equals(inventory.productId) : inventory.productId != null) return false;
        if (materielId != null ? !materielId.equals(inventory.materielId) : inventory.materielId != null) return false;
        if (warehouseId != null ? !warehouseId.equals(inventory.warehouseId) : inventory.warehouseId != null)
            return false;
        if (unitId != null ? !unitId.equals(inventory.unitId) : inventory.unitId != null) return false;
        if (unit != null ? !unit.equals(inventory.unit) : inventory.unit != null) return false;
        if (inventoryNum != null ? !inventoryNum.equals(inventory.inventoryNum) : inventory.inventoryNum != null)
            return false;
        if (freeInventoryNum != null ? !freeInventoryNum.equals(inventory.freeInventoryNum) : inventory.freeInventoryNum != null)
            return false;
        if (warnInventoryNum != null ? !warnInventoryNum.equals(inventory.warnInventoryNum) : inventory.warnInventoryNum != null)
            return false;
        if (createUser != null ? !createUser.equals(inventory.createUser) : inventory.createUser != null) return false;
        if (createTime != null ? !createTime.equals(inventory.createTime) : inventory.createTime != null) return false;
        if (updateUser != null ? !updateUser.equals(inventory.updateUser) : inventory.updateUser != null) return false;
        if (updateTime != null ? !updateTime.equals(inventory.updateTime) : inventory.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inventoryId != null ? inventoryId.hashCode() : 0;
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (materielId != null ? materielId.hashCode() : 0);
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (inventoryNum != null ? inventoryNum.hashCode() : 0);
        result = 31 * result + (freeInventoryNum != null ? freeInventoryNum.hashCode() : 0);
        result = 31 * result + (warnInventoryNum != null ? warnInventoryNum.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
