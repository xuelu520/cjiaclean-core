package com.huazhu.hvip.order.ord.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;

import java.util.List;
import java.util.Map;

/**
 * Created by XUEYONGPING001 on 2016/4/7.
 */
public interface OrderItemsManager extends GenericManager<OrderItems, Long> {

    /**
     * 查找订单货物列表
     */
    public List<OrderItems> searchOrderItemsList(ParamObject paramObject);

    /**
     * 查找订单货物以及订单信息列表
     */
    public List<OrderItemsExt> searchOrderItemsExtList(ParamObject paramObject);
    /**
     * 积分报表
     *
     * @param paramObject
     * @return
     */
    List<Map<String, Object>> searchPointListJson(ParamObject paramObject);
}
