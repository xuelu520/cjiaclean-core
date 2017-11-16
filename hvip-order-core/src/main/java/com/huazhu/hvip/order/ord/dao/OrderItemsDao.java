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
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;

import java.util.List;
import java.util.Map;

/**
 * An interface that provides a data management interface to the Order table.
 */
public interface OrderItemsDao extends GenericDao<OrderItems, Long> {

    /**
     * 查找订单货物列表
     */
    public List<OrderItems> searchOrderItemsList(ParamObject paramObject);

    /**
     * 查找订单货物以及订单信息列表
     */
    public List<OrderItemsExt> searchOrderItemsExtList(ParamObject paramObject);

    /**
     * 报表查询
     *
     * @param queryModel
     * @return
     */
    List<OrderItemsExt> searchReportList(QueryModel queryModel);

    /**
     * 订单查询与报表
     *
     * @param queryModel
     * @return
     */
    List<OrderExt> searchNewOrderListJson(QueryModel queryModel);

    /**
     * 积分报表部分数据
     * @param queryModel
     * @return
     */
    List<Map<String, Object>> searchPointListJson(QueryModel queryModel);
}