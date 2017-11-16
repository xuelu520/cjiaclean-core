/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceVO.java
 * Author:   lijing
 * Date:     2016-04-08 15:10:04
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-08 15:10:04> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChannelGoodsPriceVO implements Serializable {
    private Long priceId;
    private Long goodsId;
    private Long productId;
    private Long rateId;
    private String rateName;
    private BigDecimal billPrice;
    private BigDecimal sellPrice;
    private BigDecimal maxCash;
    private BigDecimal maxCrm;
    private Integer maxPoint;
    private String status;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private String goodsName;
    private String channelCode;
    private String cateName;
    private BigDecimal channelCost;
    private String onlineRate;
    private String storeRate;
    private Long categoryTypeId;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
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

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public BigDecimal getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(BigDecimal billPrice) {
        this.billPrice = billPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getMaxCash() {
        return maxCash;
    }

    public void setMaxCash(BigDecimal maxCash) {
        this.maxCash = maxCash;
    }

    public BigDecimal getMaxCrm() {
        return maxCrm;
    }

    public void setMaxCrm(BigDecimal maxCrm) {
        this.maxCrm = maxCrm;
    }

    public Integer getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public BigDecimal getChannelCost() {
        return channelCost;
    }

    public void setChannelCost(BigDecimal channelCost) {
        this.channelCost = channelCost;
    }

    public String getOnlineRate() {
        return onlineRate;
    }

    public void setOnlineRate(String onlineRate) {
        this.onlineRate = onlineRate;
    }

    public String getStoreRate() {
        return storeRate;
    }

    public void setStoreRate(String storeRate) {
        this.storeRate = storeRate;
    }

    public Long getCategoryTypeId() {
        return categoryTypeId;
    }

    public void setCategoryTypeId(Long categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }
}
