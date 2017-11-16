/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: VipTags.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:16
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:16> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_tags")
public class Tags extends DynamicField {
    private Long tagsId;
    private String tagsName;
    private Long parentId;
    private Integer goodsCount;
    private Integer sort;
    private Long storeId;
    private String mark;
    private String isParent;
    private String picId;
    private Integer picWidth;
    private Integer picHeight;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tagsId")
    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

    @Basic
    @Column(name = "tagsName")
    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "goodsCount")
    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
    @Column(name = "mark")
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "isParent")
    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    @Basic
    @Column(name = "picId")
    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    @Basic
    @Column(name = "picWidth")
    public Integer getPicWidth() {
        return picWidth;
    }

    public void setPicWidth(Integer picWidth) {
        this.picWidth = picWidth;
    }

    @Basic
    @Column(name = "picHeight")
    public Integer getPicHeight() {
        return picHeight;
    }

    public void setPicHeight(Integer picHeight) {
        this.picHeight = picHeight;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
