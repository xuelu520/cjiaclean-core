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

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
public class TagGoodsExt extends DynamicField {
    private Long tagGoodsId;
    private Long tagsId;
    private Long goodsId;
    private Integer sort;
    private String tagsName;

    @Id
    public Long getTagGoodsId() {
        return tagGoodsId;
    }

    public void setTagGoodsId(Long tagGoodsId) {
        this.tagGoodsId = tagGoodsId;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }
}
