/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberVO.java
 * Author:   lijing
 * Date:     2016-03-20 15:18:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 15:18:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RulesVO implements Serializable {
    // ------------------cancel parameter---------------------------- //
    private String cancelType;//取消类型
    private Boolean canCancel = true;//是否可以取消
    private Boolean canReturn = true;//是否可以退款
    private Boolean needDebit = false;//是否需要扣款
    private BigDecimal cancelAmount;//取消后扣款
    private BigDecimal cancelCalcFee;//扣款计算金额
    private String cancelRemark;//取消备注
// ------------------ /cancel parameter---------------------------- //

    private Integer lastCancelHours; //提前取消小时
    private String lastCancelTime;//最晚取消time
    private String returnsFlag;//是否能退货
    private Integer returnsMinutes;//退货时间
    private Date minServiceTime;//服务时间
    private BigDecimal orderAmount;//订单金额

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public Boolean getCanCancel() {
        return canCancel;
    }

    public void setCanCancel(Boolean canCancel) {
        this.canCancel = canCancel;
    }

    public BigDecimal getCancelAmount() {
        return cancelAmount;
    }

    public void setCancelAmount(BigDecimal cancelAmount) {
        this.cancelAmount = cancelAmount;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }

    public Boolean getNeedDebit() {
        return needDebit;
    }

    public void setNeedDebit(Boolean needDebit) {
        this.needDebit = needDebit;
    }

    public BigDecimal getCancelCalcFee() {
        return cancelCalcFee;
    }

    public void setCancelCalcFee(BigDecimal cancelCalcFee) {
        this.cancelCalcFee = cancelCalcFee;
    }

    public Boolean getCanReturn() {
        return canReturn;
    }

    public void setCanReturn(Boolean canReturn) {
        this.canReturn = canReturn;
    }

    public Integer getLastCancelHours() {
        return lastCancelHours;
    }

    public void setLastCancelHours(Integer lastCancelHours) {
        this.lastCancelHours = lastCancelHours;
    }

    public String getLastCancelTime() {
        return lastCancelTime;
    }

    public void setLastCancelTime(String lastCancelTime) {
        this.lastCancelTime = lastCancelTime;
    }

    public String getReturnsFlag() {
        return returnsFlag;
    }

    public void setReturnsFlag(String returnsFlag) {
        this.returnsFlag = returnsFlag;
    }

    public Integer getReturnsMinutes() {
        return returnsMinutes;
    }

    public void setReturnsMinutes(Integer returnsMinutes) {
        this.returnsMinutes = returnsMinutes;
    }

    public Date getMinServiceTime() {
        return minServiceTime;
    }

    public void setMinServiceTime(Date minServiceTime) {
        this.minServiceTime = minServiceTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
