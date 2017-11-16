/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsStore.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:13> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class GoodsStoreVO implements Serializable {

    private Long goodsStoreId;
    private Long goodsId;
    private Long productId;
    private Long depotId;
    private Integer storeNum;
    private Integer freeStoreNum;
    private Integer warnStoreNum;
    private Long channelId;
    private Long rateId;

    public Long getGoodsStoreId() {
        return goodsStoreId;
    }

    public void setGoodsStoreId(Long goodsStoreId) {
        this.goodsStoreId = goodsStoreId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    public Integer getFreeStoreNum() {
        return freeStoreNum;
    }

    public void setFreeStoreNum(Integer freeStoreNum) {
        this.freeStoreNum = freeStoreNum;
    }

    public Integer getWarnStoreNum() {
        return warnStoreNum;
    }

    public void setWarnStoreNum(Integer warnStoreNum) {
        this.warnStoreNum = warnStoreNum;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }
}
