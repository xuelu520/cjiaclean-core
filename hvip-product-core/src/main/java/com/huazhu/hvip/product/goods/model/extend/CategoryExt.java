/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Category.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:06> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model.extend;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
public class CategoryExt implements Serializable {
    private Long cateId;
    private String cateSn;
    private String cateName;
    private Long parentId;
    private Integer sort;
    private Long picId;
    private Long typeId;
    private String status;
    private String description;
    private String typeName;
    private List<CategoryExt> children;

    @Id
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Transient
    public List<CategoryExt> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryExt> children) {
        this.children = children;
    }
}
