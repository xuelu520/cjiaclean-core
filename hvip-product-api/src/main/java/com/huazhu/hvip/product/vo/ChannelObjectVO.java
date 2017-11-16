package com.huazhu.hvip.product.vo;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChannelObjectVO implements Serializable {
    private Long channelObjectId;
    private Long channelId;
    private Long objectId;
    private String objectType;
    private String objectName;
    private String objectCode;
    private String status;
    private String userName; //操作人
    private Long goodsId; //商品Id
    private String hotelName; //酒店名称
    private BigDecimal costprice;  //成本价
    private BigDecimal onlinePrice; //线上价格
    private BigDecimal offlinePrice; //线下价

    @Id
    public Long getChannelObjectId() {
        return channelObjectId;
    }

    public void setChannelObjectId(Long channelObjectId) {
        this.channelObjectId = channelObjectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getOnlinePrice() {
        return onlinePrice;
    }

    public void setOnlinePrice(BigDecimal onlinePrice) {
        this.onlinePrice = onlinePrice;
    }

    public BigDecimal getOfflinePrice() {
        return offlinePrice;
    }

    public void setOfflinePrice(BigDecimal offlinePrice) {
        this.offlinePrice = offlinePrice;
    }
}
