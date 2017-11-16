/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsSpecPK.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:13> <version>   <desc>
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

public class GoodsSpecPK extends DynamicField {
    private Long specId;

    @Column(name = "specId")
    @Id
    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    private Long specValueId;

    @Column(name = "specValueId")
    @Id
    public Long getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(Long specValueId) {
        this.specValueId = specValueId;
    }

    private Long goodsId;

    @Column(name = "goodsId")
    @Id
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    private Long productId;

    @Column(name = "productId")
    @Id
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
