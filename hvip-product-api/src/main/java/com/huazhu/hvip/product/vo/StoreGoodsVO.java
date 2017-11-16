/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreGoodsVO.java
 * Author:   lijing
 * Date:     2016-03-23 10:04:46
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-23 10:04:46> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <店铺商品展示VO>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StoreGoodsVO implements Serializable {

    private Long storeId; //商家id
    private String storeName; // 商家名称
    private List<GoodsVO> goodsVolist; // 商品列表

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<GoodsVO> getGoodsVolist() {
        return goodsVolist;
    }

    public void setGoodsVolist(List<GoodsVO> goodsVolist) {
        this.goodsVolist = goodsVolist;
    }
}
