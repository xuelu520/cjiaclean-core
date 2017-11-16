/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderItemsStatusVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-06 09:55:16
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-06 09:55:16><version><desc>
 */

package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.model.OperatorInfo;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderItemsStatusVO implements Serializable {

    private Long itemsId; //订单货物id
    private OrderStatus orderStatus; //状态枚举
    private OrderExtInfo orderExtInfo; //扩展信息，可用作与订单的实际到货信息
    private OperatorInfo operatorInfo;
    private List<Long> itemsIds;//多个订单货物id
    private String orderItemsStatus;


    public String getOrderItemsStatus() {
        return orderItemsStatus;
    }

    public void setOrderItemsStatus(String orderItemsStatus) {
        this.orderItemsStatus = orderItemsStatus;
    }

    public List<Long> getItemsIds() {
        return itemsIds;
    }

    public void setItemsIds(List<Long> itemsIds) {
        this.itemsIds = itemsIds;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo) {
        this.operatorInfo = operatorInfo;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderExtInfo getOrderExtInfo() {
        return orderExtInfo;
    }

    public void setOrderExtInfo(OrderExtInfo orderExtInfo) {
        this.orderExtInfo = orderExtInfo;
    }
}
