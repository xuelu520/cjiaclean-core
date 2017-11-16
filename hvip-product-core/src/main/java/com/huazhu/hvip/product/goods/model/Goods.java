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

package com.huazhu.hvip.product.goods.model;

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
@javax.persistence.Table(name = "vip_goods")
public class Goods extends DynamicField {
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
    private String bizScope;
    private Long storeId;
    private String storeName;
    private String params;
    private String specs;
    private String goodsType;
    private Long unitId;
    private String unit;
    private String marketEnable;
    private BigDecimal cost;
    private BigDecimal mktprice;
    private BigDecimal sellPrice;
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
    private String deleteFlag; //删除标志 0未删除 1已删除
    private String overViewUrl; //全景链接
    private String iconUrl; //图标路径
    private String picUrl; //推广图片路径
    private Integer serviceLength; //服务时长
    private String cycle; //是否周期服务
    private String cycleType; //周期类型
    private String serviceCount; //服务次数
    private String notice; //注意事项
    private String opera; //说明事项
    private Integer weekCount;//周次

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @javax.persistence.Column(name = "weekCount")
    public Integer getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    @Basic
    @javax.persistence.Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Basic
    @javax.persistence.Column(name = "opera")
    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }



    @Basic
    @javax.persistence.Column(name = "serviceCount")
    public String getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(String serviceCount) {
        this.serviceCount = serviceCount;
    }

    @Basic
    @javax.persistence.Column(name = "cycleType")
    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    @Basic
    @javax.persistence.Column(name = "cycle")
    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    @Basic
    @javax.persistence.Column(name = "serviceLength")
    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    @Basic
    @javax.persistence.Column(name = "sellPrice")
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Basic
    @javax.persistence.Column(name = "goodsName")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @javax.persistence.Column(name = "goodsNo")
    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    @Basic
    @javax.persistence.Column(name = "goodsSn")
    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    @Basic
    @javax.persistence.Column(name = "cateId")
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    @Basic
    @javax.persistence.Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @javax.persistence.Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @javax.persistence.Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }


    @Basic
    @javax.persistence.Column(name = "brandId")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }


    @Basic
    @javax.persistence.Column(name = "typeId")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }


    @Basic
    @javax.persistence.Column(name = "storeId")
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }


    @Basic
    @javax.persistence.Column(name = "storeName")
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


    @Basic
    @javax.persistence.Column(name = "params")
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }


    @Basic
    @javax.persistence.Column(name = "specs")
    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Basic
    @javax.persistence.Column(name = "goodsType")
    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    @Basic
    @javax.persistence.Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Basic
    @javax.persistence.Column(name = "marketEnable")
    public String getMarketEnable() {
        return marketEnable;
    }

    public void setMarketEnable(String marketEnable) {
        this.marketEnable = marketEnable;
    }

    @Basic
    @javax.persistence.Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @javax.persistence.Column(name = "mktprice")
    public BigDecimal getMktprice() {
        return mktprice;
    }

    public void setMktprice(BigDecimal mktprice) {
        this.mktprice = mktprice;
    }


    @Basic
    @javax.persistence.Column(name = "haveSpec")
    public String getHaveSpec() {
        return haveSpec;
    }

    public void setHaveSpec(String haveSpec) {
        this.haveSpec = haveSpec;
    }


    @Basic
    @javax.persistence.Column(name = "adjuncts")
    public String getAdjuncts() {
        return adjuncts;
    }

    public void setAdjuncts(String adjuncts) {
        this.adjuncts = adjuncts;
    }

    @Basic
    @javax.persistence.Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Basic
    @javax.persistence.Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    @Basic
    @javax.persistence.Column(name = "fieldFlag")
    public String getFieldFlag() {
        return fieldFlag;
    }

    public void setFieldFlag(String fieldFlag) {
        this.fieldFlag = fieldFlag;
    }


    @Basic
    @javax.persistence.Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Basic
    @javax.persistence.Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    @Basic
    @javax.persistence.Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Basic
    @javax.persistence.Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


    @Basic
    @javax.persistence.Column(name = "viewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @javax.persistence.Column(name = "orderCount")
    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }


    @Basic
    @javax.persistence.Column(name = "commentNum")
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }


    @Basic
    @javax.persistence.Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }


    @Basic
    @javax.persistence.Column(name = "point")
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }


    @Basic
    @javax.persistence.Column(name = "pageTitle")
    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }


    @Basic
    @javax.persistence.Column(name = "metaKeywords")
    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }


    @Basic
    @javax.persistence.Column(name = "metaDescription")
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }


    @Basic
    @javax.persistence.Column(name = "templateId")
    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }


    @Basic
    @javax.persistence.Column(name = "goodsTransfeeCharge")
    public String getGoodsTransfeeCharge() {
        return goodsTransfeeCharge;
    }

    public void setGoodsTransfeeCharge(String goodsTransfeeCharge) {
        this.goodsTransfeeCharge = goodsTransfeeCharge;
    }


    @Basic
    @javax.persistence.Column(name = "isGroupBuy")
    public String getIsGroupBuy() {
        return isGroupBuy;
    }

    public void setIsGroupBuy(String isGroupBuy) {
        this.isGroupBuy = isGroupBuy;
    }

    @Basic
    @javax.persistence.Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @javax.persistence.Column(name = "overViewUrl")
    public String getOverViewUrl() {
        return overViewUrl;
    }

    public void setOverViewUrl(String overViewUrl) {
        this.overViewUrl = overViewUrl;
    }

    @Basic
    @javax.persistence.Column(name = "unitId")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Basic
    @javax.persistence.Column(name = "bizScope")
    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    @Basic
    @javax.persistence.Column(name = "iconUrl")
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
}
