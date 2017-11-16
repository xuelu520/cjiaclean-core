package com.huazhu.hvip.order.shipments.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_shipmentsitem")
public class ShipmentsItem extends DynamicField {
    private Long itemId;
    private Long shipmentsId;
    private Long goodsId;
    private String goodsName;
    private String goodsNo;
    private String goodsSn;
    private Long productId;
    private String productName;
    private String productNo;
    private String productSn;
    private String name;
    private Integer num;
    private String itemType;
    private Long orderItemId;
    private String assignPerson;
    private String assignTelNo;
    private Date assignTime;
    private String assignExtJson;
    private Date realShipTime;
    private String realExtJson;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemId")
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    @Basic
    @Column(name = "shipmentsId")
    public Long getShipmentsId() {
        return shipmentsId;
    }

    public void setShipmentsId(Long shipmentsId) {
        this.shipmentsId = shipmentsId;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    @Basic
    @Column(name = "itemType")
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    @Basic
    @Column(name = "orderItemId")
    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
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
    @Column(name = "realShipTime")
    public Date getRealShipTime() {
        return realShipTime;
    }

    public void setRealShipTime(Date realShipTime) {
        this.realShipTime = realShipTime;
    }


    @Basic
    @Column(name = "realExtJson")
    public String getRealExtJson() {
        return realExtJson;
    }

    public void setRealExtJson(String realExtJson) {
        this.realExtJson = realExtJson;
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

        ShipmentsItem that = (ShipmentsItem) o;

        if (itemId != that.itemId) return false;
        if (shipmentsId != null ? !shipmentsId.equals(that.shipmentsId) : that.shipmentsId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsNo != null ? !goodsNo.equals(that.goodsNo) : that.goodsNo != null) return false;
        if (goodsSn != null ? !goodsSn.equals(that.goodsSn) : that.goodsSn != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productNo != null ? !productNo.equals(that.productNo) : that.productNo != null) return false;
        if (productSn != null ? !productSn.equals(that.productSn) : that.productSn != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;
        if (itemType != null ? !itemType.equals(that.itemType) : that.itemType != null) return false;
        if (orderItemId != null ? !orderItemId.equals(that.orderItemId) : that.orderItemId != null) return false;
        if (assignPerson != null ? !assignPerson.equals(that.assignPerson) : that.assignPerson != null) return false;
        if (assignTelNo != null ? !assignTelNo.equals(that.assignTelNo) : that.assignTelNo != null) return false;
        if (assignTime != null ? !assignTime.equals(that.assignTime) : that.assignTime != null) return false;
        if (assignExtJson != null ? !assignExtJson.equals(that.assignExtJson) : that.assignExtJson != null)
            return false;
        if (realShipTime != null ? !realShipTime.equals(that.realShipTime) : that.realShipTime != null) return false;
        if (realExtJson != null ? !realExtJson.equals(that.realExtJson) : that.realExtJson != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + (shipmentsId != null ? shipmentsId.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsNo != null ? goodsNo.hashCode() : 0);
        result = 31 * result + (goodsSn != null ? goodsSn.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productNo != null ? productNo.hashCode() : 0);
        result = 31 * result + (productSn != null ? productSn.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = 31 * result + (orderItemId != null ? orderItemId.hashCode() : 0);
        result = 31 * result + (assignPerson != null ? assignPerson.hashCode() : 0);
        result = 31 * result + (assignTelNo != null ? assignTelNo.hashCode() : 0);
        result = 31 * result + (assignTime != null ? assignTime.hashCode() : 0);
        result = 31 * result + (assignExtJson != null ? assignExtJson.hashCode() : 0);
        result = 31 * result + (realShipTime != null ? realShipTime.hashCode() : 0);
        result = 31 * result + (realExtJson != null ? realExtJson.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
