/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsGallery.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:12> <version>   <desc>
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
@Table(name = "vip_goodsgallery")
public class GoodsGallery extends DynamicField {
    private Long galleryId;
    private Long goodsId;
    private Long picId;
    private String defaultFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "galleryId")
    public Long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
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
    @Column(name = "picId")
    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    @Basic
    @Column(name = "defaultFlag")
    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsGallery that = (GoodsGallery) o;

        if (galleryId != that.galleryId) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (picId != null ? !picId.equals(that.picId) : that.picId != null) return false;
        if (defaultFlag != null ? !defaultFlag.equals(that.defaultFlag) : that.defaultFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (galleryId ^ (galleryId >>> 32));
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (picId != null ? picId.hashCode() : 0);
        result = 31 * result + (defaultFlag != null ? defaultFlag.hashCode() : 0);
        return result;
    }
}
