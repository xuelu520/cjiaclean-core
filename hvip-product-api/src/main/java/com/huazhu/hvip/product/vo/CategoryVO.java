/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CategoryVO.java
 * Author:   lijing
 * Date:     2016-03-16 20:25:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 20:25:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import com.huazhu.hvip.base.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CategoryVO implements Serializable {
    private Long cateId;
    private String cateSn; //分类唯一码
    private String cateName; //分类名称
    private Long parentId; //父id
    private Integer sort; //排序值
    private String photoUrl;//上传图片路径
    private Long picId; //图片id
    private Long typeId; //类型id
    private String typeName; //类型名称
    private String status; //状态
    private String description; //描述
    private List<CategoryVO> children; //子分类
    private Boolean openFlag; //是否开通
    private String defaultSize;
    private List<GoodsVO> goodsVOList;
    private String bizScope;

    private String picUrlView;
    private String picPrefixView;
    private String PicSuffixView;

    // --------------------- view ----------------------------- //
    public String getPicUrlView() {
        String url_prefix = StringUtils.substringBeforeLast(photoUrl, ".");
        String url_suffix = StringUtils.substringAfterLast(photoUrl, ".");
        if (StringUtils.isNotBlank(defaultSize)) {
            return url_prefix + "!" + defaultSize + "." + url_suffix;
        } else {
            return url_prefix + "!" + Constants.PIC_DEFAULTSIZE + "." + url_suffix;
        }
    }


    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getPicPrefixView() {
        return StringUtils.substringBeforeLast(photoUrl, ".");
    }

    public String getPicSuffixView() {
        return StringUtils.substringAfterLast(photoUrl, ".");
    }

    public String getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(String defaultSize) {
        this.defaultSize = defaultSize;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateSn() {
        return cateSn;
    }

    public void setCateSn(String cateSn) {
        this.cateSn = cateSn;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryVO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryVO> children) {
        this.children = children;
    }

    public Boolean getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Boolean openFlag) {
        this.openFlag = openFlag;
    }

    public List<GoodsVO> getGoodsVOList() {
        return goodsVOList;
    }

    public void setGoodsVOList(List<GoodsVO> goodsVOList) {
        this.goodsVOList = goodsVOList;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
