/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderDebitVO.java
 * Author:   lijing
 * Date:     2016-04-28 10:36:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-28 10:36:15> <version>   <desc>
 *
 */

package com.huazhu.hvip.order.qo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderDebitQO implements Serializable {
    private Long orderDebitId;
    private Long orderId;
    private Long orderItemId;
    private String type;
    private String billType;//账单类型:0 未入账 1 已入账 2 调账
    private String billNo;//账单号
    private String status; //状态 0.未入账 1.已入账 8.入账失败 9删除

    public Long getOrderDebitId() {
        return orderDebitId;
    }

    public void setOrderDebitId(Long orderDebitId) {
        this.orderDebitId = orderDebitId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
