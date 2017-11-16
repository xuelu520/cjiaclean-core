/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagGoods.java
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
@Table(name = "vip_taggoods")
public class TagGoods extends DynamicField {
    private Long tagGoodsId;
    private Long tagsId;
    private Long goodsId;
    private Integer sort;

    @Id
    @Basic
    @Column(name = "tagGoodsId")
    public Long getTagGoodsId() {
        return tagGoodsId;
    }

    public void setTagGoodsId(Long tagGoodsId) {
        this.tagGoodsId = tagGoodsId;
    }

    @Basic
    @Column(name = "tagsId")
    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
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
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
