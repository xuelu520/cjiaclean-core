package com.huazhu.hvip.order.ord.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_orderitems")
public class OrderItems extends DynamicField {

    private Long itemsId;
    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private String goodsNo;
    private String goodsSn;
    private Long goodsPicId;
    private String specJson;
    private Long productId;
    private String productName;
    private String productNo;
    private String productSn;
    private Integer salesNum;
    private Integer shipNum;
    private String status;
    private String unit;
    private BigDecimal cost;
    private BigDecimal price;
    private Long channelPriceId;
    private String assignPerson;
    private String assignTelNo;
    private Date assignTime;
    private String assignExtJson;
    private BigDecimal rate; //税率
    private Long rateId; //酒店税率id
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private String cycle;
    private String bizScope;
    private Integer serviceLength;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemsId")
    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    @Basic
    @Column(name = "serviceLength")
    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    @Basic
    @Column(name = "bizScope")
    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    @Basic
    @Column(name = "cycle")
    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
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


    @Basic
    @Column(name = "goodsNo")
    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }


    @Basic
    @Column(name = "goodsSn")
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }


    @Basic
    @Column(name = "goodsPicId")
    public Long getGoodsPicId() {
        return goodsPicId;
    }

    public void setGoodsPicId(Long goodsPicId) {
        this.goodsPicId = goodsPicId;
    }


    @Basic
    @Column(name = "specJson")
    public String getSpecJson() {
        return specJson;
    }

    public void setSpecJson(String specJson) {
        this.specJson = specJson;
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
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Basic
    @Column(name = "productNo")
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }


    @Basic
    @Column(name = "productSn")
    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }


    @Basic
    @Column(name = "salesNum")
    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }


    @Basic
    @Column(name = "shipNum")
    public Integer getShipNum() {
        return shipNum;
    }

    public void setShipNum(Integer shipNum) {
        this.shipNum = shipNum;
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
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
    @Column(name = "channelPriceId")
    public Long getChannelPriceId() {
        return channelPriceId;
    }

    public void setChannelPriceId(Long channelPriceId) {
        this.channelPriceId = channelPriceId;
    }


    @Basic
    @Column(name = "assignPerson")
    public String getAssignPerson() {
        return assignPerson;
    }

    public void setAssignPerson(String assignPerson) {
        this.assignPerson = assignPerson;
    }


    @Basic
    @Column(name = "assignTelNo")
    public String getAssignTelNo() {
        return assignTelNo;
    }

    public void setAssignTelNo(String assignTelNo) {
        this.assignTelNo = assignTelNo;
    }


    @Basic
    @Column(name = "assignTime")
    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }


    @Basic
    @Column(name = "assignExtJson")
    public String getAssignExtJson() {
        return assignExtJson;
    }

    public void setAssignExtJson(String assignExtJson) {
        this.assignExtJson = assignExtJson;
    }

    @Basic
    @Column(name = "rate")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderItems that = (OrderItems) o;

        if (itemsId != null ? !itemsId.equals(that.itemsId) : that.itemsId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsNo != null ? !goodsNo.equals(that.goodsNo) : that.goodsNo != null) return false;
        if (goodsSn != null ? !goodsSn.equals(that.goodsSn) : that.goodsSn != null) return false;
        if (goodsPicId != null ? !goodsPicId.equals(that.goodsPicId) : that.goodsPicId != null) return false;
        if (specJson != null ? !specJson.equals(that.specJson) : that.specJson != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productNo != null ? !productNo.equals(that.productNo) : that.productNo != null) return false;
        if (productSn != null ? !productSn.equals(that.productSn) : that.productSn != null) return false;
        if (salesNum != null ? !salesNum.equals(that.salesNum) : that.salesNum != null) return false;
        if (shipNum != null ? !shipNum.equals(that.shipNum) : that.shipNum != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (channelPriceId != null ? !channelPriceId.equals(that.channelPriceId) : that.channelPriceId != null)
            return false;
        if (assignPerson != null ? !assignPerson.equals(that.assignPerson) : that.assignPerson != null) return false;
        if (assignTelNo != null ? !assignTelNo.equals(that.assignTelNo) : that.assignTelNo != null) return false;
        if (assignTime != null ? !assignTime.equals(that.assignTime) : that.assignTime != null) return false;
        if (assignExtJson != null ? !assignExtJson.equals(that.assignExtJson) : that.assignExtJson != null)
            return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (rateId != null ? !rateId.equals(that.rateId) : that.rateId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        if (cycle != null ? !cycle.equals(that.cycle) : that.cycle != null) return false;
        if (bizScope != null ? !bizScope.equals(that.bizScope) : that.bizScope != null) return false;
        return !(serviceLength != null ? !serviceLength.equals(that.serviceLength) : that.serviceLength != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (itemsId != null ? itemsId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsNo != null ? goodsNo.hashCode() : 0);
        result = 31 * result + (goodsSn != null ? goodsSn.hashCode() : 0);
        result = 31 * result + (goodsPicId != null ? goodsPicId.hashCode() : 0);
        result = 31 * result + (specJson != null ? specJson.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productNo != null ? productNo.hashCode() : 0);
        result = 31 * result + (productSn != null ? productSn.hashCode() : 0);
        result = 31 * result + (salesNum != null ? salesNum.hashCode() : 0);
        result = 31 * result + (shipNum != null ? shipNum.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (channelPriceId != null ? channelPriceId.hashCode() : 0);
        result = 31 * result + (assignPerson != null ? assignPerson.hashCode() : 0);
        result = 31 * result + (assignTelNo != null ? assignTelNo.hashCode() : 0);
        result = 31 * result + (assignTime != null ? assignTime.hashCode() : 0);
        result = 31 * result + (assignExtJson != null ? assignExtJson.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (rateId != null ? rateId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (cycle != null ? cycle.hashCode() : 0);
        result = 31 * result + (bizScope != null ? bizScope.hashCode() : 0);
        result = 31 * result + (serviceLength != null ? serviceLength.hashCode() : 0);
        return result;
    }
}
