/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: IOrderService.java
 * Author:   admin
 * Date:     2016-03-08 18:51:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 18:51:15><version><desc><source>
 */

package com.huazhu.hvip.order.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.order.qo.OrderQO;
import com.huazhu.hvip.order.qo.ServiceQO;
import com.huazhu.hvip.order.vo.*;

import java.util.List;

/**
 * 订单相关接口api
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface OrderService {




    /**
     * (hms)根据酒店统一编号,日期，名称，电话等模糊查找获取订单商品数量统计
     *
     * @param orderQO 酒店统一编号,日期，名称，电话等模糊查找
     * @return
     */
    ReturnObject<OrderItemsVO> itemsCount(OrderQO orderQO);

    /**
     * 根据orderSn获取订单详情
     *
     * @param orderSn
     * @return
     */
    ReturnObject<OrderVO> getOrderDetailForHms(String orderSn);



    /**
     * (hms)根据货物编号获取货物明细列表打印出来
     *
     * @param orderQO 货物编号
     * @return
     */
    ReturnObject<OrderItemsVO> printOrderOrderItemsList(OrderQO orderQO);



    /**
     * (hms)获取DebitVO
     *
     * @param orderItemsVO 订单货物
     * @return
     */
    ReturnObject<DebitVO> getDebitVO(OrderItemsVO orderItemsVO);


    /**
     * (hms)获取CreditVO （新）
     *
     * @param orderVO 订单
     * @return
     */
    ReturnObject<CreditVO> getOrderCreditVO(OrderVO orderVO);

    /**
     * (hms)是否是线上下单线上支付
     *
     * @param orderItemsVO 订单货物
     * @return
     */
    boolean isOnlinePay(OrderItemsVO orderItemsVO);


    /**
     * (op)根据关键字：订单唯一号，或者订货人或者全查询订单列表
     *
     * @param orderQO
     * @param pageCondition
     * @return
     */
    ReturnObject<OrderVO> searchOrderListForOp(OrderQO orderQO, PageCondition pageCondition);


    /**
     * 根据酒店订单号查询订单信息
     *
     * @param hotelOrderSn
     * @return
     */
    ReturnObject<OrderVO> searchOrderListByHotelOrderSn(String hotelOrderSn);


    /**
     * 获取订单的来源
     *
     * @return
     */
    ReturnObject searchOrderSourceList();


    /**
     * 2016年7月5日09:53:27
     * 对listjson进行修改
     *
     * @param orderQO
     * @return
     */
    ReturnObject newOrderListJson(OrderQO orderQO);

    /**
     * 统计酒店销售额
     *
     * @param orderQO
     * @return
     */
    ReturnObject<HotelOrderSaleVO> searchHotelOrderSale(OrderQO orderQO);


    /**
     * 积分报表查询
     *
     * @param orderQO
     * @return
     */
    ReturnObject<OrderPointVO> searchpointListJson(OrderQO orderQO);

    /**
     * 城家订单保存
     *
     * @param orderVO
     * @return
     */
    ReturnObject<OrderVO> saveOrder(OrderVO orderVO);

    /**
     * 查询订单
     *
     * @param orderSn
     * @return
     */
    ReturnObject<OrderVO> getOrderDetailByOrderSn(String orderSn);

    /**
     * 扭转订单状态
     *
     * @param orderVO
     * @return
     */
    ReturnObject<OrderVO> reverseOrder(OrderVO orderVO);

    /**
     * 查询订单下的工单
     *
     * @param orderQO
     * @return
     */
    ReturnObject<OrderVO>  getOrderServiceByOrderQO(OrderQO orderQO) ;


    /**
     * 查询工单列表
     * @param orderQO
     * @return
     */
    ReturnObject<ServiceVO> serviceListJson(OrderQO orderQO);

    /**
     * 分配工单员工
     * @param serviceVO
     * @return
     */
    ReturnObject<ServiceVO> addServiceCleaner(ServiceVO serviceVO);


    /**
     * 查询订单
     * @param orderQO
     * @return
     */
    ReturnObject<OrderVO> getOrderListByQO(OrderQO orderQO);

    /**
     * 周期添加工单
     * @param serviceVOs
     * @return
     */
    ReturnObject<ServiceVO> saveServiceVo(List<ServiceVO> serviceVOs);

    /**
     *用户取消工单
     *
     * @param serviceVO
     * @return
     */
    ReturnObject<ServiceVO> cancelOrderService(ServiceVO serviceVO);

    /**
     * 查询保洁员下的工单
     * @param serviceQO
     * @return
     */
    ReturnObject<ServiceVO> getOrderServiceByCleanMobile(ServiceQO serviceQO);


    /**
     * 查询员工下的工单
     * @param serviceQO
     * @return
     */
    ReturnObject<ServiceVO> getOrderServiceByMemberMobile(ServiceQO serviceQO);

    /**
     * 查询保洁员下的工单
     * @param serviceVO
     * @return
     */
    ReturnObject<ServiceVO> updateCleanerService(ServiceVO serviceVO);

    /**
     * 取消订单
     * @param orderVOList
     * @return
     */
    ReturnObject<OrderVO> cancelOrderVO(List<OrderVO> orderVOList);

    /**
     * 退款
     * @param orderVO
     * @return
     */
    ReturnObject<OrderVO> refundOrderVO(OrderVO orderVO);


    /**
     * 获取特地工单
     * @param serviceQO
     * @return
     */
    ReturnObject<ServiceVO> getServiceVO(ServiceQO serviceQO);


    /**
     * 获取特地工单及商品信息
     * @param serviceQO
     * @return
     */
    ReturnObject<ServiceVO> getServiceAndGoods(ServiceQO serviceQO);

    /**
     * 获取订单及工单信息
     * @param orderQO
     * @return
     */
    ReturnObject<OrderVO> getOrderService(OrderQO orderQO);

    /**
     * 查询订单下的item
     * @param orderQO
     * @return
     */
    ReturnObject<OrderItemsVO> searchOrderItemList(OrderQO orderQO);


    /**
     * 保存修改
     * @param serviceVO
     * @return
     */
    ReturnObject<ServiceVO> saveServiceVO(ServiceVO serviceVO);


    /**
     * 批量保存
     * @param orderVO
     * @return
     */
    ReturnObject<OrderVO> saveOrderParam(OrderVO orderVO);

}
