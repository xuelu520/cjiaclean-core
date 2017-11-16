/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsDepot.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:11
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:11> <version>   <desc>
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
@Table(name = "vip_goodsdepot")
public class GoodsDepot extends DynamicField {
    private Long goodsDepotId;
    private Long goodsId;
    private Long depotId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goodsDepotId")
    public Long getGoodsDepotId() {
        return goodsDepotId;
    }

    public void setGoodsDepotId(Long goodsDepotId) {
        this.goodsDepotId = goodsDepotId;
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
    @Column(name = "depotId")
    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsDepot that = (GoodsDepot) o;

        if (goodsDepotId != that.goodsDepotId) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (depotId != null ? !depotId.equals(that.depotId) : that.depotId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (goodsDepotId ^ (goodsDepotId >>> 32));
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (depotId != null ? depotId.hashCode() : 0);
        return result;
    }
}
