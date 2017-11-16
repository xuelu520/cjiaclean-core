/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PaymentDao.java
 * Author:   HUQIANBO001
 * Date:     2016-04-05 11:03:20
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-05 11:03:20><version><desc>
 */

package com.huazhu.hvip.order.payment.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.payment.model.Payment;

import java.util.List;
import java.util.Map;

/**
 * An interface that provides a data management interface to the Order table.
 */
public interface PaymentDao extends GenericDao<Payment, Long> {


    List<Map<Long,String>> searchReportPayTypeList(QueryModel queryModel);
}