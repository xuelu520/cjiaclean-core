/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsStore.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:13> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_goodsstore")
public class GoodsStore extends DynamicField {
    private Long goodsStoreId;
    private Long goodsId;
    private Long productId;
    private Long depotId;
    private Integer storeNum;
    private Integer freeStoreNum;
    private Integer warnStoreNum;
    private Long channelId;
    private Long rateId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goodsStoreId")
    public Long getGoodsStoreId() {
        return goodsStoreId;
    }

    public void setGoodsStoreId(Long goodsStoreId) {
        this.goodsStoreId = goodsStoreId;
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
    @Column(name = "depotId")
    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    @Basic
    @Column(name = "storeNum")
    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    @Basic
    @Column(name = "freeStoreNum")
    public Integer getFreeStoreNum() {
        return freeStoreNum;
    }

    public void setFreeStoreNum(Integer freeStoreNum) {
        this.freeStoreNum = freeStoreNum;
    }

    @Basic
    @Column(name = "warnStoreNum")
    public Integer getWarnStoreNum() {
        return warnStoreNum;
    }

    public void setWarnStoreNum(Integer warnStoreNum) {
        this.warnStoreNum = warnStoreNum;
    }

    @Basic
    @Column(name = "channelId")
    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "rateId")
    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsStore that = (GoodsStore) o;

        if (goodsStoreId != that.goodsStoreId) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (depotId != null ? !depotId.equals(that.depotId) : that.depotId != null) return false;
        if (storeNum != null ? !storeNum.equals(that.storeNum) : that.storeNum != null) return false;
        if (freeStoreNum != null ? !freeStoreNum.equals(that.freeStoreNum) : that.freeStoreNum != null) return false;
        if (warnStoreNum != null ? !warnStoreNum.equals(that.warnStoreNum) : that.warnStoreNum != null) return false;
        if (channelId != null ? !channelId.equals(that.channelId) : that.channelId != null) return false;
        if (rateId != null ? !rateId.equals(that.rateId) : that.rateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (goodsStoreId ^ (goodsStoreId >>> 32));
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (depotId != null ? depotId.hashCode() : 0);
        result = 31 * result + (storeNum != null ? storeNum.hashCode() : 0);
        result = 31 * result + (freeStoreNum != null ? freeStoreNum.hashCode() : 0);
        result = 31 * result + (warnStoreNum != null ? warnStoreNum.hashCode() : 0);
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        result = 31 * result + (rateId != null ? rateId.hashCode() : 0);
        return result;
    }
}
