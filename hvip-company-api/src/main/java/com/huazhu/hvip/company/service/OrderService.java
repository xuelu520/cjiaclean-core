package com.huazhu.hvip.company.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.company.qo.OrderQO;

/**
 * 公司订单
 * @author cmy
 * @create 2017-11-02 10:23
 **/
public interface OrderService {
    /**
     * 查询下的工程列表
     * @param orderQO
     * @return
     */
    ReturnObject orderListJson(OrderQO orderQO);
}
