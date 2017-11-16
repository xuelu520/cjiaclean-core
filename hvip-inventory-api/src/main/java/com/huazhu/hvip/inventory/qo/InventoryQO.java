package com.huazhu.hvip.inventory.qo;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by LYL on 2016/9/23.
 */
public class InventoryQO implements Serializable{
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
    private Long channelId;
    private Long rateId;

    @Id
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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }
}
