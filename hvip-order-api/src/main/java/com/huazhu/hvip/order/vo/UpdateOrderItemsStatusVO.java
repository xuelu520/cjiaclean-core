/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: UpdateOrderItemsStatusVO.java
 * Author:   HUQIANBO001
 * Date:     2016-04-06 09:53:38
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-06 09:53:38><version><desc>
 */

package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.model.OperatorInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HUQIANBO001 on 2016/3/31.
 */
public class UpdateOrderItemsStatusVO implements Serializable {

    private String orderSn; //订单唯一号
    private List<OrderItemsStatusVO> orderItemsStatusVOList; //订单货物项
    private OperatorInfo operatorInfo; //操作人信息

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public List<OrderItemsStatusVO> getOrderItemsStatusVOList() {
        return orderItemsStatusVOList;
    }

    public void setOrderItemsStatusVOList(List<OrderItemsStatusVO> orderItemsStatusVOList) {
        this.orderItemsStatusVOList = orderItemsStatusVOList;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo) {
        this.operatorInfo = operatorInfo;
    }
}
