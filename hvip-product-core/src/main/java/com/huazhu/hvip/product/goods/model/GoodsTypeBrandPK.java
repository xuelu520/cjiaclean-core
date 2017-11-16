/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeBrandPK.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class GoodsTypeBrandPK extends DynamicField {
    private Long goodsTypeId;
    private Long brandId;

    @Column(name = "goodsTypeId")
    @Id
    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    @Column(name = "brandId")
    @Id
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsTypeBrandPK that = (GoodsTypeBrandPK) o;

        if (goodsTypeId != that.goodsTypeId) return false;
        if (brandId != that.brandId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (goodsTypeId ^ (goodsTypeId >>> 32));
        result = 31 * result + (int) (brandId ^ (brandId >>> 32));
        return result;
    }
}
