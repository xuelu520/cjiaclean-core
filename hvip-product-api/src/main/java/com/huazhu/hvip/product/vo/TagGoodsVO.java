package com.huazhu.hvip.product.vo;

import java.io.Serializable;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TagGoodsVO implements Serializable{
    private Long tagGoodsId;
    private Long tagsId;
    private Long goodsId;
    private Integer sort;
    private String tagsName;

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
