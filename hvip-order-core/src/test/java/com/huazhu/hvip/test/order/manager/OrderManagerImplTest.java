/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OrderManagerImplTest.java
 * Author:   admin
 * Date:     2016-03-09 16:58:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-09 16:58:42><version><desc><source>
 */

package com.huazhu.hvip.test.order.manager;

import com.huazhu.hvip.order.ord.dao.OrderDao;
import com.huazhu.hvip.order.ord.manager.impl.OrderManagerImpl;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.test.order.manager.base.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class OrderManagerImplTest extends BaseManagerMockTestCase {
    private OrderManagerImpl manager = null;
    private OrderDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(OrderDao.class);
        manager = new OrderManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

//    @Test
//    public void addOrderTest() {
//        log.debug("testing get...");
//
//        final Order order = new Order();
//        order.setOrderName("test1");
//        order.setPrice(10);
//
//        context.checking(new Expectations() {{
//            one(dao).save(with(same(order)));
//        }});
//
//
//        Long orderId = manager.addOrder(order);
//
//    }


}