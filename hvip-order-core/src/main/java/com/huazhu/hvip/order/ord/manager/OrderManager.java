/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: LookRoomManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.order.ord.manager;

import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.Service;
import com.huazhu.hvip.order.ord.model.extend.HotelOrderSale;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.ord.model.extend.OrderExtInfos;
import com.huazhu.hvip.order.shipments.model.Shipments;

import java.util.Date;
import java.util.List;

public interface OrderManager extends GenericManager<Order, Long> {

    /**
     * 创建订单
     *
     * @param order
     * @param orderItemsList
     * @return
     */
    Long createOrder(Order order, List<OrderItems> orderItemsList);

    /**
     * 根据条件获取订单相关信息
     *
     * @param paramObject
     * @return
     */
    List<OrderExt> getOrderDetail(ParamObject paramObject);

    /**
     * 根据条件查询订单信息
     *
     * @param paramObject
     * @return
     */
    List<OrderExt> searchOrderList(ParamObject paramObject);

    /**
     * 根据条件查询订单信息
     *
     * @param paramObject
     * @return
     */
    List<OrderExt> searchOrderListByParam(ParamObject paramObject);

    /**
     * op根据条件查询订单信息
     *
     * @param paramObject
     * @return
     */
    List<OrderExt> searchOrderListForOp(ParamObject paramObject);

    /**
     * 生成发货单明细
     *
     * @param shipments
     * @param orderItems
     * @param operatorInfo
     * @param nowDate
     */
    void createShipmentsItem(Shipments shipments, Order order, OrderItems orderItems, OperatorInfo operatorInfo, Date nowDate, OrderExtInfos orderExtInfos);

    /**
     * 获取订单的来源
     *
     * @return
     */
    List<String> searchOrderSourceList();

    /**
     * 订单查询与报表
     *
     * @param paramObject
     * @return
     */
    List<OrderExt> newOrderListJson(ParamObject paramObject);

    /**
     * 根据orderSn获取订单详情对getOrderDetailForHms更改
     *
     * @param paramObject
     * @return
     */
    List<OrderExt> getOrderDetailForHms(ParamObject paramObject);

    /**
     * 统计酒店销售额
     * @param paramObject
     * @return
     */
    List<HotelOrderSale> searchHotelOrderSale(ParamObject paramObject);


    /**
     * 报表列表查询
     *
     * @param paramObject
     * @return
     */
    /*List<OrderExt> searchReportList(ParamObject paramObject);*/

    Order saveOrder(ParamObject paramObject);

    /**
     * 工单关联保洁员信息
     * @param paramObject
     */
    Service saveServiceItem(ParamObject paramObject);

    /**
     * 周期添加工单
     * @param paramObject
     * @return
     */
    List<Service> saveServiceVos(ParamObject paramObject);

    /**
     * 取消订单
     * @param paramObject
     * @return
     */
    List<Order> updateCancelOrder(ParamObject paramObject);

    /**
     * 退款
     * @param paramObject
     * @return
     */
    Order updateRefundOrder(ParamObject paramObject);

    /**
     * 保存订单
     * @param orderList
     * @return
     */
    List<Order> saveOrderList(List<Order> orderList);

    /**
     * 保存订单
     * @param paramObject
     * @return
     */
    Order saveOrderParam(ParamObject paramObject);
}