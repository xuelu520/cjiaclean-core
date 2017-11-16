package com.huazhu.hvip.common.model;

import javax.persistence.*;

/**
 * @author cmy
 * @create 2017-08-14 11:39
 **/
@Entity
@Table(name = "couponsrange")
public class Couponsrange {
    private Long rangeId;
    private Long couponId;
    private Long storeId;
    private Long cateId;
    private Long goodsId;
    private Integer sort;

    @Id
    @Column(name = "rangeId")
    public Long getRangeId() {
        return rangeId;
    }

    public void setRangeId(Long rangeId) {
        this.rangeId = rangeId;
    }

    @Basic
    @Column(name = "couponId")
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "storeId")
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "cateId")
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
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
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Couponsrange that = (Couponsrange) o;

        if (rangeId != null ? !rangeId.equals(that.rangeId) : that.rangeId != null) return false;
        if (couponId != null ? !couponId.equals(that.couponId) : that.couponId != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (cateId != null ? !cateId.equals(that.cateId) : that.cateId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rangeId != null ? rangeId.hashCode() : 0;
        result = 31 * result + (couponId != null ? couponId.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (cateId != null ? cateId.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }
}
