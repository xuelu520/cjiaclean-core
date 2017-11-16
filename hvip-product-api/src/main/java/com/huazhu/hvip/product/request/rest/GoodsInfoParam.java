/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsInfo.java
 * Author:   lijing
 * Date:     2016-04-10 14:26:43
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-10 14:26:43> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.request.rest;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class GoodsInfoParam implements Serializable{

    private String goodsName; //商品名称
    private String goodsNo; // 货号
    private Long cateId; //分类id
    private String description; //详细描述

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
