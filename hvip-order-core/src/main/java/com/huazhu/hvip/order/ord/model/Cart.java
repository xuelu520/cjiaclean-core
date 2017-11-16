package com.huazhu.hvip.order.ord.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_cart")
public class Cart extends DynamicField {
    private Long cartId;
    private Long goodsId;
    private Long productId;
    private Integer itemtype;
    private Integer goodsNum;
    private BigDecimal weight;
    private String sessionId;
    private String goodsName;
    private BigDecimal price;
    private String addon;
    private Long storeId;
    private Long memberId;
    private Long channelRateId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartId")
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
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
    @Column(name = "itemtype")
    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }

    @Basic
    @Column(name = "goodsNum")
    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "sessionId")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "addon")
    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
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
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "channelRateId")
    public Long getChannelRateId() {
        return channelRateId;
    }

    public void setChannelRateId(Long channelRateId) {
        this.channelRateId = channelRateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (goodsId != null ? !goodsId.equals(cart.goodsId) : cart.goodsId != null) return false;
        if (productId != null ? !productId.equals(cart.productId) : cart.productId != null) return false;
        if (itemtype != null ? !itemtype.equals(cart.itemtype) : cart.itemtype != null) return false;
        if (goodsNum != null ? !goodsNum.equals(cart.goodsNum) : cart.goodsNum != null) return false;
        if (weight != null ? !weight.equals(cart.weight) : cart.weight != null) return false;
        if (sessionId != null ? !sessionId.equals(cart.sessionId) : cart.sessionId != null) return false;
        if (goodsName != null ? !goodsName.equals(cart.goodsName) : cart.goodsName != null) return false;
        if (price != null ? !price.equals(cart.price) : cart.price != null) return false;
        if (addon != null ? !addon.equals(cart.addon) : cart.addon != null) return false;
        if (storeId != null ? !storeId.equals(cart.storeId) : cart.storeId != null) return false;
        if (memberId != null ? !memberId.equals(cart.memberId) : cart.memberId != null) return false;
        if (channelRateId != null ? !channelRateId.equals(cart.channelRateId) : cart.channelRateId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cartId ^ (cartId >>> 32));
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (itemtype != null ? itemtype.hashCode() : 0);
        result = 31 * result + (goodsNum != null ? goodsNum.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (addon != null ? addon.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (channelRateId != null ? channelRateId.hashCode() : 0);
        return result;
    }
}
