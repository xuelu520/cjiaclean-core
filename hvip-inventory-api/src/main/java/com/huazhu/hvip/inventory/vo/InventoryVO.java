package com.huazhu.hvip.inventory.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by cmy on 2016/9/23.
 */
public class InventoryVO implements Serializable {
    private Long inventoryId;
    private Long goodsId;
    private Long productId;
    private String HotelId;
    private String HotelName;
    private Long materielId;
    private Long warehouseId;
    private Long unitId;
    private String unit;
    private Integer inventoryNum;
    private Integer freeInventoryNum;
    private Integer warnInventoryNum;
    private String createUser;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;


    public String getHotelId() {
        return HotelId;
    }

    public void setHotelId(String hotelId) {
        HotelId = hotelId;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public Integer getFreeInventoryNum() {
        return freeInventoryNum;
    }

    public void setFreeInventoryNum(Integer freeInventoryNum) {
        this.freeInventoryNum = freeInventoryNum;
    }

    public Integer getWarnInventoryNum() {
        return warnInventoryNum;
    }

    public void setWarnInventoryNum(Integer warnInventoryNum) {
        this.warnInventoryNum = warnInventoryNum;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
