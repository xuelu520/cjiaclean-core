/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsSpec.java
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
@Table(name = "vip_goodsspec")
@IdClass(GoodsSpecPK.class)
public class GoodsSpec extends DynamicField {
    private Long specId;
    private Long specValueId;
    private Long goodsId;
    private Long productId;

    @Id
    @Column(name = "specId")
    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    @Id
    @Column(name = "specValueId")
    public long getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(long specValueId) {
        this.specValueId = specValueId;
    }

    @Id
    @Column(name = "goodsId")
    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "productId")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsSpec goodsSpec = (GoodsSpec) o;

        if (specId != goodsSpec.specId) return false;
        if (specValueId != goodsSpec.specValueId) return false;
        if (goodsId != goodsSpec.goodsId) return false;
        if (productId != goodsSpec.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (specId ^ (specId >>> 32));
        result = 31 * result + (int) (specValueId ^ (specValueId >>> 32));
        result = 31 * result + (int) (goodsId ^ (goodsId >>> 32));
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        return result;
    }
}
