/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceInfo.java
 * Author:   lijing
 * Date:     2016-04-10 16:50:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-10 16:50:48> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChannelGoodsPriceInfo implements Serializable{
    private Long priceId;
    private Long rateId;
    private Long goodsId;
    private String rateName;
    private BigDecimal billPrice;
    private BigDecimal sellPrice;

    public Long getPriceId() {

        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public BigDecimal getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(BigDecimal billPrice) {
        this.billPrice = billPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
