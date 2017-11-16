package com.huazhu.hvip.product.goods.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-08-09.
 */
@Entity
@javax.persistence.Table(name = "vip_frequency")
public class Frequency {
    private Long frequenId;
    private String frequenName;
    private String frequenPrice;
    private Long goodsId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "frequenId")
    public Long getFrequenId() {
        return frequenId;
    }

    public void setFrequenId(Long frequenId) {
        this.frequenId = frequenId;
    }

    @Basic
    @Column(name = "frequenName")
    public String getFrequenName() {
        return frequenName;
    }

    public void setFrequenName(String frequenName) {
        this.frequenName = frequenName;
    }

    @Basic
    @Column(name = "frequenPrice")
    public String getFrequenPrice() {
        return frequenPrice;
    }

    public void setFrequenPrice(String frequenPrice) {
        this.frequenPrice = frequenPrice;
    }

    @Basic
    @Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frequency frequency = (Frequency) o;

        if (frequenId != frequency.frequenId) return false;
        if (frequenName != null ? !frequenName.equals(frequency.frequenName) : frequency.frequenName != null)
            return false;
        if (frequenPrice != null ? !frequenPrice.equals(frequency.frequenPrice) : frequency.frequenPrice != null)
            return false;
        if (goodsId != null ? !goodsId.equals(frequency.goodsId) : frequency.goodsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (frequenId ^ (frequenId >>> 32));
        result = 31 * result + (frequenName != null ? frequenName.hashCode() : 0);
        result = 31 * result + (frequenPrice != null ? frequenPrice.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        return result;
    }
}
