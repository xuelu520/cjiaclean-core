package com.huazhu.hvip.product.vo;

import java.io.Serializable;

/**
 * Created by cmy on 2016/10/18.
 */
public class SpreeUntoVO implements Serializable{
    private Long untoId;  //之间表id
    private Long giftId; //礼包id
    private Long goodsId; //商品id
    private String goodsName; //商品名称

    public Long getUntoId() {
        return untoId;
    }

    public void setUntoId(Long untoId) {
        this.untoId = untoId;
    }

    public Long getGiftId() {
        return giftId;
    }

    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
