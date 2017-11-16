/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsVO.java
 * Author:   chenli
 * Date:     2016-03-21 17:05:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-21 17:05:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class GoodsVO implements Serializable {

    private Long goodsId; //商品id
    private String goodsName; //商品名称
    private String goodsNo; //商品编号
    private String goodsSn; //商品唯一号
    private Long cateId; //分类id
    private String brief; //简介
    private String description; //详细描述
    private BigDecimal weight; //重量
    private Long brandId; //品牌id
    private Long typeId; //类型id
    private Long storeId; //店铺id
    private String storeName; //店铺名称
    private String params; //参数字串
    private String specs; //规格字串
    private String goodsType; //商品类型
    private String unit; //计量单位
    private Long unitId; //计量单位
    private String marketEnable; //是否上架 0 未上架 1已上架
    private BigDecimal cost; //成本价
    private BigDecimal mktprice; //市场价
    private BigDecimal sellPrice;
    private String haveSpec; //是否有规格
    private String adjuncts; //配件字串
    private String status; //状态
    private Integer sort; //排序值
    private String fieldFlag; //是否有自定义字段
    private Date createTime; //创建时间
    private String createUser; //创建人
    private Date updateTime; //修改时间
    private String updateUser; //修改人
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
    private Boolean openFlag; //是否开通
    private String cateName;//分类名称
    private String typeName;//类型名称
    private String deleteFlag; //删除标志 0未删除 1已删除
    private String overViewUrl; //全景链接
    private String iconUrl; //图标路径
    private String picUrl; //推广图片路径
    private String bizScope; //业务范围：1.百宝箱收费产品 2.niiice cafe 3 百宝箱免费产品',
    private BigDecimal price; //销售价格
    private Integer serviceLength; //服务时长
    private String cycle; //是否周期服务
    private String cycleType; //周期类型
    private String serviceCount; //服务次数
    private String notice; //注意事项
    private String opera; //说明事项
    private Integer weekCount;//周次


    public Integer getWeekCount() {

        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(String serviceCount) {
        this.serviceCount = serviceCount;
    }

    private Long channelPriceId; //渠道价钱id

    private String isPhysical; //是否是实体商品  0.服务类商品 1.实体类商品

    private String cateSn; //分类唯一码

    private Integer freeStoreNum; //可用库存，目前暂时取商品的第一条库存记录数的可用库存

    private List<GoodsStoreVO> goodsStoreVOList; //商品库存信息列表

    private List<ProductVO> productVOList; //货品信息

    private GoodsParam goodsParam; //商品参数

    private List<GoodsTagsVO> goodsTagsVOList; //商品标签

    private CategoryVO categoryVO; //商品分类对象

    private GoodsPictureVO defaultGoodsPicture; //默认图片

    private List<GoodsPictureVO> goodsPictureVOList; //商品图片列表

    private CateOrderRuleVO cateOrderRuleVO; //商品分类规则

    private String openChannel; //开通渠道 ： 0全部 1.代表线上 2.代表线下

    private String adjustPriceFlag; //是否支持调价 0否   1是

    private Integer hotelGoodsSort; //酒店设置的排序值

    private GoodsTypeVO goodsTypeVO; //商品类型


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

    public String getCateSn() {
        return cateSn;
    }

    public void setCateSn(String cateSn) {
        this.cateSn = cateSn;
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

    public String getIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(String isPhysical) {
        this.isPhysical = isPhysical;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<GoodsStoreVO> getGoodsStoreVOList() {
        return goodsStoreVOList;
    }

    public void setGoodsStoreVOList(List<GoodsStoreVO> goodsStoreVOList) {
        this.goodsStoreVOList = goodsStoreVOList;
    }

    public List<ProductVO> getProductVOList() {
        return productVOList;
    }

    public void setProductVOList(List<ProductVO> productVOList) {
        this.productVOList = productVOList;
    }

    public Integer getFreeStoreNum() {
        return freeStoreNum;
    }

    public void setFreeStoreNum(Integer freeStoreNum) {
        this.freeStoreNum = freeStoreNum;
    }

    public GoodsParam getGoodsParam() {
        return goodsParam;
    }

    public void setGoodsParam(GoodsParam goodsParam) {
        this.goodsParam = goodsParam;
    }

    public List<GoodsTagsVO> getGoodsTagsVOList() {
        return goodsTagsVOList;
    }

    public void setGoodsTagsVOList(List<GoodsTagsVO> goodsTagsVOList) {
        this.goodsTagsVOList = goodsTagsVOList;
    }

    public CategoryVO getCategoryVO() {
        return categoryVO;
    }

    public void setCategoryVO(CategoryVO categoryVO) {
        this.categoryVO = categoryVO;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public Boolean getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Boolean openFlag) {
        this.openFlag = openFlag;
    }

    public Long getChannelPriceId() {
        return channelPriceId;
    }

    public void setChannelPriceId(Long channelPriceId) {
        this.channelPriceId = channelPriceId;
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

    public GoodsPictureVO getDefaultGoodsPicture() {
        return defaultGoodsPicture;
    }

    public void setDefaultGoodsPicture(GoodsPictureVO defaultGoodsPicture) {
        this.defaultGoodsPicture = defaultGoodsPicture;
    }

    public List<GoodsPictureVO> getGoodsPictureVOList() {
        return goodsPictureVOList;
    }

    public void setGoodsPictureVOList(List<GoodsPictureVO> goodsPictureVOList) {
        this.goodsPictureVOList = goodsPictureVOList;
    }

    public CateOrderRuleVO getCateOrderRuleVO() {
        return cateOrderRuleVO;
    }

    public void setCateOrderRuleVO(CateOrderRuleVO cateOrderRuleVO) {
        this.cateOrderRuleVO = cateOrderRuleVO;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getOpenChannel() {
        return openChannel;
    }

    public void setOpenChannel(String openChannel) {
        this.openChannel = openChannel;
    }

    public String getAdjustPriceFlag() {
        return adjustPriceFlag;
    }

    public void setAdjustPriceFlag(String adjustPriceFlag) {
        this.adjustPriceFlag = adjustPriceFlag;
    }

    public Integer getHotelGoodsSort() {
        return hotelGoodsSort;
    }

    public void setHotelGoodsSort(Integer hotelGoodsSort) {
        this.hotelGoodsSort = hotelGoodsSort;
    }

    public GoodsTypeVO getGoodsTypeVO() {
        return goodsTypeVO;
    }

    public void setGoodsTypeVO(GoodsTypeVO goodsTypeVO) {
        this.goodsTypeVO = goodsTypeVO;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
}
