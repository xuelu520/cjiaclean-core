/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRuleVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-19 14:47:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-19 14:47:53><version><desc>
 */

package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CateCancelRuleVO implements Serializable {

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

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
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

    public BigDecimal getCancelCalcFee() {
        return cancelCalcFee;
    }

    public void setCancelCalcFee(BigDecimal cancelCalcFee) {
        this.cancelCalcFee = cancelCalcFee;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
