package com.huazhu.hvip.rest.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoodsInfoForAPP implements Serializable {

    private Long goodsId; //商品ID

    private String goodsName; // 商品名称

    private String goodsSn; //商品代码

    private Long cateId; //类别id

    private String bref; //商品简介

    private String description; //商品详细描述

    private BigDecimal salePrice; //销售价格

    private String unit; //单位

    private Integer  freeStoreNum; //可用库存

    private String iconUrl; //商品icon路径

    private String goodsDetailUrl; //商品详情url

    private String pictureUrl; //商品图片Url

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getBref() {
        return bref;
    }

    public void setBref(String bref) {
        this.bref = bref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFreeStoreNum() {
        return freeStoreNum;
    }

    public void setFreeStoreNum(Integer freeStoreNum) {
        this.freeStoreNum = freeStoreNum;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getGoodsDetailUrl() {
        return goodsDetailUrl;
    }

    public void setGoodsDetailUrl(String goodsDetailUrl) {
        this.goodsDetailUrl = goodsDetailUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
