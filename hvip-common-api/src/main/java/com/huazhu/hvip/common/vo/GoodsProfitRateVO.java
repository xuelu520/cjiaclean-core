package com.huazhu.hvip.common.vo;

import java.io.Serializable;

/**
 * 商品利润额比例
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoodsProfitRateVO implements Serializable {

    private Long goodsTypeId; //商品分类id

    private Double minRate; //最小毛利率

    private Double maxRate; //最大毛利率

    private Integer profitAmount; //毛利润

    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    public Double getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(Double maxRate) {
        this.maxRate = maxRate;
    }

    public Integer getProfitAmount() {
        return profitAmount;
    }

    public void setProfitAmount(Integer profitAmount) {
        this.profitAmount = profitAmount;
    }
}
