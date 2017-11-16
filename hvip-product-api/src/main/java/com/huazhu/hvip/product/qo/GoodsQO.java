package com.huazhu.hvip.product.qo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XUEYONGPING001 on 2016/4/8.
 */
public class GoodsQO implements Serializable {

    private Long goodsId;
    private Long hotelId;
    private String hotelUniqueNo;//酒店统一编号
    private String goodsName; //商品名称
    private Long typeId; //类型id
    private List<Long> typeList;//类型list
    private String cateSn; //分类代码
    private List<String> goodsSnList; //商品编号
    private List<Long> cateIds; //已开通的分类id列表
    private List<String> cateSnList;
    private String openChannel; //开通渠道 0全部 1.代表线上 2.代表线下
    private String bizScope; //业务范围 ： 1.百宝箱 2.niiice cafe
    private Integer serviceLength; //服务时长
    private String cycle; //是否周期服务
    private String cycleType; //周期类型
    private String serviceCount; //服务次数
    private String notice; //注意事项
    private String opera; //操作事项
    private Integer weekCount;//周次


    public Integer getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(Integer weekCount) {
        this.weekCount = weekCount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public Integer getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Integer serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(String serviceCount) {
        this.serviceCount = serviceCount;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public List<Long> getCateIds() {
        return cateIds;
    }

    public void setCateIds(List<Long> cateIds) {
        this.cateIds = cateIds;
    }

    public String getHotelUniqueNo() {
        return hotelUniqueNo;
    }

    public void setHotelUniqueNo(String hotelUniqueNo) {
        this.hotelUniqueNo = hotelUniqueNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getCateSn() {
        return cateSn;
    }

    public void setCateSn(String cateSn) {
        this.cateSn = cateSn;
    }

    public List<String> getGoodsSnList() {
        return goodsSnList;
    }

    public void setGoodsSnList(List<String> goodsSnList) {
        this.goodsSnList = goodsSnList;
    }

    public List<String> getCateSnList() {
        return cateSnList;
    }

    public void setCateSnList(List<String> cateSnList) {
        this.cateSnList = cateSnList;
    }

    public String getOpenChannel() {
        return openChannel;
    }

    public void setOpenChannel(String openChannel) {
        this.openChannel = openChannel;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public List<Long> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Long> typeList) {
        this.typeList = typeList;
    }

}
