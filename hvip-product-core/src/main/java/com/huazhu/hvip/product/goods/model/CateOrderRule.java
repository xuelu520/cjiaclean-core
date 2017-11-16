/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateOrderRule.java
 * Author:   HUQIANBO001
 * Date:     2016-04-11 18:58:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-11 18:58:24><version><desc>
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "vip_cateorderrule")
public class CateOrderRule extends DynamicField {

    private Long ruleId; //主键id
    private Long cateId; //分类id
    private String storePayFlag; //是否支持门店支付：0否 1是
    private String paidCancelFlag; //付款后能否取消：0否 1是
    private Integer payCountdown; //付款倒计时(以分钟存储)
    private String canReservationTime; //入住当日几点前可预订
    private String rulePromptMsg; //规则提示信息，json字串
    private String description; //描述
    private String status; //状态：0.不启用 1.启用
    private String reservationFlag; //是否要预约详细：0.否 1.是
    private String accountingFlag; //是否需要入账 0否 1是
    private String crmPayFlag; //是否支持储值卡支付:  0.否 1.是
    private String cateRule; //类型规则分为 1:收费商品 2:收费租赁 3:免费商品 4:免费租赁' AFTER `crmPayFlag`

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ruleId")
    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    @Basic
    @Column(name = "cateId")
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "storePayFlag")
    public String getStorePayFlag() {
        return storePayFlag;
    }

    public void setStorePayFlag(String storePayFlag) {
        this.storePayFlag = storePayFlag;
    }

    @Basic
    @Column(name = "paidCancelFlag")
    public String getPaidCancelFlag() {
        return paidCancelFlag;
    }

    public void setPaidCancelFlag(String paidCancelFlag) {
        this.paidCancelFlag = paidCancelFlag;
    }

    @Basic
    @Column(name = "payCountdown")
    public Integer getPayCountdown() {
        return payCountdown;
    }

    public void setPayCountdown(Integer payCountdown) {
        this.payCountdown = payCountdown;
    }

    @Basic
    @Column(name = "canReservationTime")
    public String getCanReservationTime() {
        return canReservationTime;
    }

    public void setCanReservationTime(String canReservationTime) {
        this.canReservationTime = canReservationTime;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rulePromptMsg")
    public String getRulePromptMsg() {
        return rulePromptMsg;
    }

    public void setRulePromptMsg(String rulePromptMsg) {
        this.rulePromptMsg = rulePromptMsg;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "reservationFlag")
    public String getReservationFlag() {
        return reservationFlag;
    }

    public void setReservationFlag(String reservationFlag) {
        this.reservationFlag = reservationFlag;
    }

    @Basic
    @Column(name = "accountingFlag")
    public String getAccountingFlag() {
        return accountingFlag;
    }

    public void setAccountingFlag(String accountingFlag) {
        this.accountingFlag = accountingFlag;
    }

    @Basic
    @Column(name = "crmPayFlag")
    public String getCrmPayFlag() {
        return crmPayFlag;
    }

    public void setCrmPayFlag(String crmPayFlag) {
        this.crmPayFlag = crmPayFlag;
    }

    @Basic
    @Column(name = "cateRule")
    public String getCateRule() {
        return cateRule;
    }

    public void setCateRule(String cateRule) {
        this.cateRule = cateRule;
    }
}
