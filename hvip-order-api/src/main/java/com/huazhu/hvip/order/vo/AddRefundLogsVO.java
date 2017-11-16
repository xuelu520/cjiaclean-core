/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AddRefundLogsVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-07 18:37:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-07 18:37:50><version><desc>
 */

package com.huazhu.hvip.order.vo;

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
public class AddRefundLogsVO implements Serializable {

    private String orderSn; //订单唯一号
    private Long orderItemsId; //订单货物id
    private Long memberId; //当前登录会员id
    private String refundName; //退款操作人姓名
    private BigDecimal refundAmount; //退款金额
    private String remark; //备注
    private String status; //状态， 不填为0. 退款中

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(Long orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
