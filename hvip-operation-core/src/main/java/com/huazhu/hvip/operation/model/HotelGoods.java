package com.huazhu.hvip.operation.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cc
 * @create 2017-09-07 10:12
 **/
@Entity
@Table(name = "hotelgoods")
public class HotelGoods {
    private Long hotelGoodsId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotelGoodsId")
    public Long getHotelGoodsId() {
        return hotelGoodsId;
    }

    public void setHotelGoodsId(Long hotelGoodsId) {
        this.hotelGoodsId = hotelGoodsId;
    }

    private Long hotelId;

    @Basic
    @Column(name = "hotelId")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    private Long typeId;

    @Basic
    @Column(name = "typeId")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    private Long cateId;

    @Basic
    @Column(name = "cateId")
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    private Long goodsId;

    @Basic
    @Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    private String goodsSn;

    @Basic
    @Column(name = "goodsSn")
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    private String goodsName;

    @Basic
    @Column(name = "goodsName")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    private String goodsType;

    @Basic
    @Column(name = "goodsType")
    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    private BigDecimal discountMoney;

    @Basic
    @Column(name = "discountMoney")
    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    private String hotelDiscountDay;

    @Basic
    @Column(name = "hotelDiscountDay")
    public String getHotelDiscountDay() {
        return hotelDiscountDay;
    }

    public void setHotelDiscountDay(String hotelDiscountDay) {
        this.hotelDiscountDay = hotelDiscountDay;
    }

    private String status;

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private BigDecimal sellPrice;

    @Basic
    @Column(name = "sellPrice")
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    private BigDecimal onlinePrice;

    @Basic
    @Column(name = "onlinePrice")
    public BigDecimal getOnlinePrice() {
        return onlinePrice;
    }

    public void setOnlinePrice(BigDecimal onlinePrice) {
        this.onlinePrice = onlinePrice;
    }

    private Date beginTime;

    @Basic
    @Column(name = "beginTime")
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    private Date endTime;

    @Basic
    @Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private String openChannel;

    @Basic
    @Column(name = "openChannel")
    public String getOpenChannel() {
        return openChannel;
    }

    public void setOpenChannel(String openChannel) {
        this.openChannel = openChannel;
    }

    private String adjustPriceFlag;

    @Basic
    @Column(name = "adjustPriceFlag")
    public String getAdjustPriceFlag() {
        return adjustPriceFlag;
    }

    public void setAdjustPriceFlag(String adjustPriceFlag) {
        this.adjustPriceFlag = adjustPriceFlag;
    }

    private Integer sort;

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    private String deleteFlag;

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    private String updateUser;

    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    private Long unitId;

    @Basic
    @Column(name = "unitId")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    private String unit;

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    private BigDecimal weight;

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    private String producer;

    @Basic
    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    private String material;

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    private String packagingUnit;

    @Basic
    @Column(name = "packagingUnit")
    public String getPackagingUnit() {
        return packagingUnit;
    }

    public void setPackagingUnit(String packagingUnit) {
        this.packagingUnit = packagingUnit;
    }

    private Date createDate;

    @Basic
    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    private Date updateDate;

    @Basic
    @Column(name = "updateDate")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    private String applyFlag;

    @Basic
    @Column(name = "applyFlag")
    public String getApplyFlag() {
        return applyFlag;
    }

    public void setApplyFlag(String applyFlag) {
        this.applyFlag = applyFlag;
    }

    private String hotelGoodsUrl;

    @Basic
    @Column(name = "hotelGoodsUrl")
    public String getHotelGoodsUrl() {
        return hotelGoodsUrl;
    }

    public void setHotelGoodsUrl(String hotelGoodsUrl) {
        this.hotelGoodsUrl = hotelGoodsUrl;
    }

    private String description;

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String reason;

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String promptMessage;

    @Basic
    @Column(name = "promptMessage")
    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    private String remarks;

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelGoods that = (HotelGoods) o;

        if (hotelGoodsId != null ? !hotelGoodsId.equals(that.hotelGoodsId) : that.hotelGoodsId != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (cateId != null ? !cateId.equals(that.cateId) : that.cateId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsSn != null ? !goodsSn.equals(that.goodsSn) : that.goodsSn != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsType != null ? !goodsType.equals(that.goodsType) : that.goodsType != null) return false;
        if (discountMoney != null ? !discountMoney.equals(that.discountMoney) : that.discountMoney != null)
            return false;
        if (hotelDiscountDay != null ? !hotelDiscountDay.equals(that.hotelDiscountDay) : that.hotelDiscountDay != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (sellPrice != null ? !sellPrice.equals(that.sellPrice) : that.sellPrice != null) return false;
        if (onlinePrice != null ? !onlinePrice.equals(that.onlinePrice) : that.onlinePrice != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (openChannel != null ? !openChannel.equals(that.openChannel) : that.openChannel != null) return false;
        if (adjustPriceFlag != null ? !adjustPriceFlag.equals(that.adjustPriceFlag) : that.adjustPriceFlag != null)
            return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(that.deleteFlag) : that.deleteFlag != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (producer != null ? !producer.equals(that.producer) : that.producer != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (packagingUnit != null ? !packagingUnit.equals(that.packagingUnit) : that.packagingUnit != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (applyFlag != null ? !applyFlag.equals(that.applyFlag) : that.applyFlag != null) return false;
        if (hotelGoodsUrl != null ? !hotelGoodsUrl.equals(that.hotelGoodsUrl) : that.hotelGoodsUrl != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (promptMessage != null ? !promptMessage.equals(that.promptMessage) : that.promptMessage != null)
            return false;
        return !(remarks != null ? !remarks.equals(that.remarks) : that.remarks != null);

    }

    @Override
    public int hashCode() {
        int result = hotelGoodsId != null ? hotelGoodsId.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (cateId != null ? cateId.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (goodsSn != null ? goodsSn.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsType != null ? goodsType.hashCode() : 0);
        result = 31 * result + (discountMoney != null ? discountMoney.hashCode() : 0);
        result = 31 * result + (hotelDiscountDay != null ? hotelDiscountDay.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (sellPrice != null ? sellPrice.hashCode() : 0);
        result = 31 * result + (onlinePrice != null ? onlinePrice.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (openChannel != null ? openChannel.hashCode() : 0);
        result = 31 * result + (adjustPriceFlag != null ? adjustPriceFlag.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (packagingUnit != null ? packagingUnit.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (applyFlag != null ? applyFlag.hashCode() : 0);
        result = 31 * result + (hotelGoodsUrl != null ? hotelGoodsUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (promptMessage != null ? promptMessage.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
