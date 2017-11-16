/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPrice.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:07> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_channelgoodsprice")
public class ChannelGoodsPrice extends DynamicField {
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "priceId")
    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
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
    @Column(name = "rateId")
    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "billPrice")
    public BigDecimal getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(BigDecimal billPrice) {
        this.billPrice = billPrice;
    }

    @Basic
    @Column(name = "sellPrice")
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Basic
    @Column(name = "maxCash")
    public BigDecimal getMaxCash() {
        return maxCash;
    }

    public void setMaxCash(BigDecimal maxCash) {
        this.maxCash = maxCash;
    }

    @Basic
    @Column(name = "maxCrm")
    public BigDecimal getMaxCrm() {
        return maxCrm;
    }

    public void setMaxCrm(BigDecimal maxCrm) {
        this.maxCrm = maxCrm;
    }

    @Basic
    @Column(name = "maxPoint")
    public Integer getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Basic
    @Column(name = "rateName")
    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelGoodsPrice that = (ChannelGoodsPrice) o;

        if (priceId != that.priceId) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (rateId != null ? !rateId.equals(that.rateId) : that.rateId != null) return false;
        if (billPrice != null ? !billPrice.equals(that.billPrice) : that.billPrice != null) return false;
        if (sellPrice != null ? !sellPrice.equals(that.sellPrice) : that.sellPrice != null) return false;
        if (maxCash != null ? !maxCash.equals(that.maxCash) : that.maxCash != null) return false;
        if (maxCrm != null ? !maxCrm.equals(that.maxCrm) : that.maxCrm != null) return false;
        if (maxPoint != null ? !maxPoint.equals(that.maxPoint) : that.maxPoint != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (priceId ^ (priceId >>> 32));
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (rateId != null ? rateId.hashCode() : 0);
        result = 31 * result + (billPrice != null ? billPrice.hashCode() : 0);
        result = 31 * result + (sellPrice != null ? sellPrice.hashCode() : 0);
        result = 31 * result + (maxCash != null ? maxCash.hashCode() : 0);
        result = 31 * result + (maxCrm != null ? maxCrm.hashCode() : 0);
        result = 31 * result + (maxPoint != null ? maxPoint.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
