package com.huazhu.hvip.operation.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by cmy on 2016/6/14.
 */
public class HotelOperateVO implements Serializable {
    private Long itemId; //ID
    private Long goodsId; //商品Id
    private String centralPurchaseFlag; //是否统购 0否 1是
    private String openChannel; //开通渠道：0.全部 1.线上 2.线下
    private BigDecimal costPrice; //成本价
    private BigDecimal onlinePrice; //线上价
    private BigDecimal offlinePrice; //线下价格
    private String rejectReason;  //拒绝原因
    private Long controlPriceId;
    private Long hotelId; //酒店ID
    private String hotelNo; //酒店编号
    private String hotelUniqueNo;//酒店唯一编码
    private String remark; //备注
    private Date createTime; //生成时间
    private Date verificationTime; //审核时间
    private String verifierName; //审核人
    private String hotelName; //酒店名称
    private String goodsName; //商品名称
    private String createUser; //提交人
    private String status; //状态
    private String statusName; //状态名
    private String cateName; //分类名
    private BigDecimal channelOnlineSellPrice; //建议线上销售价格
    private BigDecimal channelStoreSellPrice; //建议线下价格
    private BigDecimal channelCost; //建议成本价
    private String onlineRate; //线上毛利率
    private String storeRate; //线下利率
    private String openChannelName; //渠道名称
    private String adjustPriceFlag; //是否支持调价 0否   1是
    private Long categoryTypeId;
    private HotelRateParameterVO hotelRateParameterVO;
    private List<String> goodsIdList;//商品Id
    private List<String> statusList; //状态集合


    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    public Long getCategoryTypeId() {
        return categoryTypeId;
    }

    public void setCategoryTypeId(Long categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }

    public String getStoreRate() {
        return storeRate;
    }

    public void setStoreRate(String storeRate) {
        this.storeRate = storeRate;
    }

    public String getOnlineRate() {
        return onlineRate;
    }

    public void setOnlineRate(String onlineRate) {
        this.onlineRate = onlineRate;
    }

    public BigDecimal getChannelOnlineSellPrice() {
        return channelOnlineSellPrice;
    }

    public void setChannelOnlineSellPrice(BigDecimal channelOnlineSellPrice) {
        this.channelOnlineSellPrice = channelOnlineSellPrice;
    }

    public BigDecimal getChannelStoreSellPrice() {
        return channelStoreSellPrice;
    }

    public void setChannelStoreSellPrice(BigDecimal channelStoreSellPrice) {
        this.channelStoreSellPrice = channelStoreSellPrice;
    }

    public BigDecimal getChannelCost() {
        return channelCost;
    }

    public void setChannelCost(BigDecimal channelCost) {
        this.channelCost = channelCost;
    }

    public Long getControlPriceId() {
        return controlPriceId;
    }

    public void setControlPriceId(Long controlPriceId) {
        this.controlPriceId = controlPriceId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getCentralPurchaseFlag() {
        return centralPurchaseFlag;
    }

    public void setCentralPurchaseFlag(String centralPurchaseFlag) {
        this.centralPurchaseFlag = centralPurchaseFlag;
    }

    public String getOpenChannel() {
        return openChannel;
    }

    public void setOpenChannel(String openChannel) {
        this.openChannel = openChannel;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
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

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getOpenChannelName() {
        return openChannelName;
    }

    public void setOpenChannelName(String openChannelName) {
        this.openChannelName = openChannelName;
    }

    public HotelRateParameterVO getHotelRateParameterVO() {
        return hotelRateParameterVO;
    }

    public void setHotelRateParameterVO(HotelRateParameterVO hotelRateParameterVO) {
        this.hotelRateParameterVO = hotelRateParameterVO;
    }


    public String getAdjustPriceFlag() {
        return adjustPriceFlag;
    }

    public void setAdjustPriceFlag(String adjustPriceFlag) {
        this.adjustPriceFlag = adjustPriceFlag;
    }

    public List<String> getGoodsIdList() {
        return goodsIdList;
    }

    public void setGoodsIdList(List<String> goodsIdList) {
        this.goodsIdList = goodsIdList;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }
}
