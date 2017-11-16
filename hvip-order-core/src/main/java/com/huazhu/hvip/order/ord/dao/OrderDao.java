/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: LookRoomDao.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.order.ord.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.extend.HotelOrderSale;
import com.huazhu.hvip.order.ord.model.extend.OrderActionExt;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * An interface that provides a data management interface to the Order table.
 */
public interface OrderDao extends GenericDao<Order, Long> {

//    /**
//     * 更新关联外部订单信息
//     *
//     * @param order
//     */
//    public void updateOrgOrder(Order order);

    /**
     * 查询订单列表
     *
     * @param queryModel
     * @return
     */
    List<OrderExt> searchOrderList(QueryModel queryModel);

    /**
     * 获取订单的来源
     *
     * @return
     */
    List<String> searchOrderSourceList();

    /**
     * 报表列表查询
     *
     * @param queryModel
     * @return
     */
    List<OrderExt> searchReportList(QueryModel queryModel);

    /**
     * 统计酒店销售额
     * @param queryModel
     * @return
     */
    List<HotelOrderSale> searchHotelOrderSale(QueryModel queryModel);


    /**
     * 积分报表查询订单部分数据
     * @param queryModel
     * @return
     */
    List<OrderActionExt> searchScoreListJson(QueryModel queryModel);

    /**查询订单总额
     *
     * @param queryModel
     * @return
     */
    BigDecimal searchOrderAllMoney(QueryModel queryModel);

    /**
     * 查询每个员工的销售额
     * @param queryModel
     * @return
     */
    List<Map<String, Object>> searchEveryEmyployeeSalary(QueryModel queryModel);



    /*List<OrderExt> searchReportList(ParamObject paramObject);*/
}