package com.huazhu.hvip.product.goods.model;

import javax.persistence.*;

/**
 * Created by LYL on 2016/10/18.
 */
@Entity
@Table(name = "vip_spreeunto")
public class SpreeUnto {
    private Long untoId;
    private Long giftId;
    private Long goodsId;
    private String goodsName;

    @Id
    @Column(name = "untoId")
    public Long getUntoId() {
        return untoId;
    }

    public void setUntoId(Long untoId) {
        this.untoId = untoId;
    }

    @Basic
    @Column(name = "giftId")
    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
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
    @Column(name = "goodsName")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpreeUnto that = (SpreeUnto) o;

        if (untoId != null ? !untoId.equals(that.untoId) : that.untoId != null) return false;
        if (giftId != null ? !giftId.equals(that.giftId) : that.giftId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = untoId != null ? untoId.hashCode() : 0;
        result = 31 * result + (giftId != null ? giftId.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        return result;
    }
}
