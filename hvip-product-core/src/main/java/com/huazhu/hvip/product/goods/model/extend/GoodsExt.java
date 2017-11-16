/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Goods.java
 * Author:   chenli
 * Date:     2016-03-23 10:23:26
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 10:23:26> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model.extend;

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
public class GoodsExt extends DynamicField {
    private Long goodsId;
    private String goodsName;
    private String goodsNo;
    private String goodsSn;
    private Long cateId;
    private String brief;
    private String description;
    private BigDecimal weight;
    private Long brandId;
    private Long typeId;
    private Long storeId;
    private String storeName;
    private String params;
    private String specs;
    private String goodsType;
    private String unit;
    private Long unitId;
    private String marketEnable;
    private BigDecimal cost;
    private BigDecimal mktprice;
    private String haveSpec;
    private String adjuncts;
    private String status;
    private Integer sort;
    private String fieldFlag;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private Integer viewCount; //浏览次数
    private Integer orderCount; //下单次数
    private Integer commentNum; //评论次数
    private Integer grade; //评价值
    private Integer point; //积分
    private String pageTitle; //页面标题
    private String metaKeywords; //页面关键字
    private String metaDescription; //页面内容描述
    private Long templateId; //商品运费模板
    private String goodsTransfeeCharge; //0,买家承担运费,1,卖家承担运费
    private String isGroupBuy; //是否为团购商品
    private String overViewUrl; //全景链接
    private String iconUrl; //图标路径
    private String picUrl; //推广图片路径
    private String bizScope; //业务范围：1.百宝箱收费产品 2.niiice cafe 3 百宝箱免费产品',
    private BigDecimal price; //销售价格

    private Long channelPriceId; //渠道价钱id

    private String isPhysical; //是否是实体商品  0.服务类商品 1.实体类商品

    private String cateSn; //分类唯一码

    private String cateName;//分类名称

    private String typeName;//类型名称


    @Id
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

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMarketEnable() {
        return marketEnable;
    }

    public void setMarketEnable(String marketEnable) {
        this.marketEnable = marketEnable;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getMktprice() {
        return mktprice;
    }

    public void setMktprice(BigDecimal mktprice) {
        this.mktprice = mktprice;
    }

    public String getHaveSpec() {
        return haveSpec;
    }

    public void setHaveSpec(String haveSpec) {
        this.haveSpec = haveSpec;
    }

    public String getAdjuncts() {
        return adjuncts;
    }

    public void setAdjuncts(String adjuncts) {
        this.adjuncts = adjuncts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFieldFlag() {
        return fieldFlag;
    }

    public void setFieldFlag(String fieldFlag) {
        this.fieldFlag = fieldFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getGoodsTransfeeCharge() {
        return goodsTransfeeCharge;
    }

    public void setGoodsTransfeeCharge(String goodsTransfeeCharge) {
        this.goodsTransfeeCharge = goodsTransfeeCharge;
    }

    public String getIsGroupBuy() {
        return isGroupBuy;
    }

    public void setIsGroupBuy(String isGroupBuy) {
        this.isGroupBuy = isGroupBuy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(String isPhysical) {
        this.isPhysical = isPhysical;
    }

    public String getCateSn() {
        return cateSn;
    }

    public void setCateSn(String cateSn) {
        this.cateSn = cateSn;
    }

    public Long getChannelPriceId() {
        return channelPriceId;
    }

    public void setChannelPriceId(Long channelPriceId) {
        this.channelPriceId = channelPriceId;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOverViewUrl() {
        return overViewUrl;
    }

    public void setOverViewUrl(String overViewUrl) {
        this.overViewUrl = overViewUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
}
