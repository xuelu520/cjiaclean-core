package com.huazhu.hvip.order.ord.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_orderfeedetail")
public class OrderFeeDetail extends DynamicField {
    private Long feeId;
    private String feeCode;
    private String remark;
    private Long orderId;
    private Long itemsId;
    private BigDecimal price;
    private String couponNo;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feeId")
    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    @Basic
    @Column(name = "feeCode")
    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "itemsId")
    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "couponNo")
    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderFeeDetail that = (OrderFeeDetail) o;

        if (feeId != that.feeId) return false;
        if (feeCode != null ? !feeCode.equals(that.feeCode) : that.feeCode != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (itemsId != null ? !itemsId.equals(that.itemsId) : that.itemsId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (couponNo != null ? !couponNo.equals(that.couponNo) : that.couponNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (feeId ^ (feeId >>> 32));
        result = 31 * result + (feeCode != null ? feeCode.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (itemsId != null ? itemsId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (couponNo != null ? couponNo.hashCode() : 0);
        return result;
    }
}
