/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrdersTest.java
 * Author:   admin
 * Date:     2016-03-09 18:03:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-09 18:03:51><version><desc><source>
 */

package com.huazhu.hvip.test.order.manager;

import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author ZhengYong
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*.xml"})
public class OrdersTest {

    @Autowired
    private OrderManager orderManager;

//    @Test
//   public void addTets(){
//        Order order = new Order();
//        order.setOrderName("test");
//        order.setPrice(111);
//        orderManager.addOrder(order);
//
//   }

}
