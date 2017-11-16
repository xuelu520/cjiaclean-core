/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderDebitService.java
 * Author:   lijing
 * Date:     2016-04-28 10:39:26
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-28 10:39:26> <version>   <desc>
 *
 */

package com.huazhu.hvip.order.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.order.qo.OrderDebitQO;
import com.huazhu.hvip.order.vo.OrderDebitVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface OrderDebitService {

    /**
     * 创建订单挂账
     * @param orderDebitVO
     * @return
     */
    public ReturnObject<OrderDebitVO> addOrderDebit(OrderDebitVO orderDebitVO);


    /**
     * 查询入账记录
     *
     * @param orderDebitQO
     * @return
     */
    public ReturnObject<OrderDebitVO> searchOrderDebit(OrderDebitQO orderDebitQO);

}
