package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
public class AddOrderItemVO implements Serializable {

    private Long goodsId; //商品id
    private Integer goodsNum; //商品数量
    private Date assignTime; //预约时间/服务时间
    private String assignPerson; //预约人/服务技师（针对推拿分类）
    private String assignTelNo; //预约人/服务技师的联系方式
    private String assignExtJson; //预约信息扩展json字串
    private Long inventoryNum; //库存数量

    private BigDecimal rate; //税率
    private Long rateId; //酒店税率id

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getAssignPerson() {
        return assignPerson;
    }

    public void setAssignPerson(String assignPerson) {
        this.assignPerson = assignPerson;
    }

    public String getAssignTelNo() {
        return assignTelNo;
    }

    public void setAssignTelNo(String assignTelNo) {
        this.assignTelNo = assignTelNo;
    }

    public String getAssignExtJson() {
        return assignExtJson;
    }

    public void setAssignExtJson(String assignExtJson) {
        this.assignExtJson = assignExtJson;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getRateId() {
        return rateId;
    }

    public Long getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Long inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }
}
