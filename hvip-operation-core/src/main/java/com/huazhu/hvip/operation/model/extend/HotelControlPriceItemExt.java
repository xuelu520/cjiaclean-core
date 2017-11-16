/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Hotelcontrolpriceitem.java
 * Author:   HUQIANBO001
 * Date:     2016-06-13 16:50:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-06-13 16:50:07><version><desc>
 */

package com.huazhu.hvip.operation.model.extend;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
public class HotelControlPriceItemExt extends DynamicField {
    private Long itemId;
    private Long hotelId;
    private String hotelNo;
    private String hotelName;
    private Long goodsId;
    private String goodsName;
    private String centralPurchaseFlag;
    private String openChannel;
    private BigDecimal costPrice;
    private BigDecimal onlinePrice;
    private BigDecimal offlinePrice;
    private String status;
    private String createUser;
    private Date createTime;
    private String verifierName;
    private Date verificationTime;
    private String rejectReason;
    private String cateName; //商品分类名
    private BigDecimal sellPrice; //销售价格 包括线上线下

    @Id
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCentralPurchaseFlag() {
        return centralPurchaseFlag;
    }

    public void setCentralPurchaseFlag(String centralPurchaseFlag) {
        this.centralPurchaseFlag = centralPurchaseFlag;
    }

    public String getOpenChannel() {
        return openChannel;
    }

    public void setOpenChannel(String openChannel) {
        this.openChannel = openChannel;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getOnlinePrice() {
        return onlinePrice;
    }

    public void setOnlinePrice(BigDecimal onlinePrice) {
        this.onlinePrice = onlinePrice;
    }

    public BigDecimal getOfflinePrice() {
        return offlinePrice;
    }

    public void setOfflinePrice(BigDecimal offlinePrice) {
        this.offlinePrice = offlinePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelControlPriceItemExt that = (HotelControlPriceItemExt) o;

        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (hotelNo != null ? !hotelNo.equals(that.hotelNo) : that.hotelNo != null) return false;
        if (hotelName != null ? !hotelName.equals(that.hotelName) : that.hotelName != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (centralPurchaseFlag != null ? !centralPurchaseFlag.equals(that.centralPurchaseFlag) : that.centralPurchaseFlag != null)
            return false;
        if (openChannel != null ? !openChannel.equals(that.openChannel) : that.openChannel != null) return false;
        if (costPrice != null ? !costPrice.equals(that.costPrice) : that.costPrice != null) return false;
        if (onlinePrice != null ? !onlinePrice.equals(that.onlinePrice) : that.onlinePrice != null) return false;
        if (offlinePrice != null ? !offlinePrice.equals(that.offlinePrice) : that.offlinePrice != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (verifierName != null ? !verifierName.equals(that.verifierName) : that.verifierName != null) return false;
        if (verificationTime != null ? !verificationTime.equals(that.verificationTime) : that.verificationTime != null)
            return false;
        if (rejectReason != null ? !rejectReason.equals(that.rejectReason) : that.rejectReason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (hotelNo != null ? hotelNo.hashCode() : 0);
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (centralPurchaseFlag != null ? centralPurchaseFlag.hashCode() : 0);
        result = 31 * result + (openChannel != null ? openChannel.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (onlinePrice != null ? onlinePrice.hashCode() : 0);
        result = 31 * result + (offlinePrice != null ? offlinePrice.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (verifierName != null ? verifierName.hashCode() : 0);
        result = 31 * result + (verificationTime != null ? verificationTime.hashCode() : 0);
        result = 31 * result + (rejectReason != null ? rejectReason.hashCode() : 0);
        return result;
    }
}
