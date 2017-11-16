/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRule.java
 * Author:   HUQIANBO001
 * Date:     2016-04-19 14:43:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-19 14:43:31><version><desc>
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "vip_catecancelrule")
public class CateCancelRule extends DynamicField {

    private Long ruleId;
    private Long cateId; //分类id
    private String cancelType; //取消类型：0 取消全额退款 1 取消按照固定金额退款 2 取消按照百分比退款 9 取消不退款
    private Integer lastCancelHours; //最晚取消时间（精确到小时）：     判断时间 - 当前日期 >= hours
    private String lastCancelTime; //最后可取消时间  例：19:00 计算日期当天 19:00
    private BigDecimal cancelCalcFee; //取消后扣款金额
    private String returnsFlag; //发货后是否可以退货：0否  1是
    private Integer returnsMinutes; //多少时间(分钟)内前台有退货权限
    private String description; //描述
    private String status; //状态:0.不启用 1.启用

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
    @Column(name = "cancelType")
    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    @Basic
    @Column(name = "lastCancelHours")
    public Integer getLastCancelHours() {
        return lastCancelHours;
    }

    public void setLastCancelHours(Integer lastCancelHours) {
        this.lastCancelHours = lastCancelHours;
    }

    @Basic
    @Column(name = "lastCancelTime")
    public String getLastCancelTime() {
        return lastCancelTime;
    }

    public void setLastCancelTime(String lastCancelTime) {
        this.lastCancelTime = lastCancelTime;
    }

    @Basic
    @Column(name = "cancelCalcFee")
    public BigDecimal getCancelCalcFee() {
        return cancelCalcFee;
    }

    public void setCancelCalcFee(BigDecimal cancelCalcFee) {
        this.cancelCalcFee = cancelCalcFee;
    }

    @Basic
    @Column(name = "returnsFlag")
    public String getReturnsFlag() {
        return returnsFlag;
    }

    public void setReturnsFlag(String returnsFlag) {
        this.returnsFlag = returnsFlag;
    }

    @Basic
    @Column(name = "returnsMinutes")
    public Integer getReturnsMinutes() {
        return returnsMinutes;
    }

    public void setReturnsMinutes(Integer returnsMinutes) {
        this.returnsMinutes = returnsMinutes;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
