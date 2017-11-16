package com.huazhu.hvip.operation.model.extend;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OpenGoodsInfo implements Serializable {

    private String goodsName; //商品名称

    private Long cateId;//分类iD

    private String openChannel; //开通渠道

    private String adjustPriceFlag; //是否可以控制价格

    private Integer sort; //排序值

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getOpenChannel() {
        return openChannel;
    }

    public void setOpenChannel(String openChannel) {
        this.openChannel = openChannel;
    }

    public String getAdjustPriceFlag() {
        return adjustPriceFlag;
    }

    public void setAdjustPriceFlag(String adjustPriceFlag) {
        this.adjustPriceFlag = adjustPriceFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }
}
