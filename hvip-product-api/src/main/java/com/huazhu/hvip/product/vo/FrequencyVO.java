package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-08-09.
 */
public class FrequencyVO implements Serializable {
    private Long frequenId;
    private String frequenName;
    private String frequenPrice;
    private Long goodsId;

    public Long getFrequenId() {
        return frequenId;
    }

    public void setFrequenId(Long frequenId) {
        this.frequenId = frequenId;
    }

    public String getFrequenName() {
        return frequenName;
    }

    public void setFrequenName(String frequenName) {
        this.frequenName = frequenName;
    }

    public String getFrequenPrice() {
        return frequenPrice;
    }

    public void setFrequenPrice(String frequenPrice) {
        this.frequenPrice = frequenPrice;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
