/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: RefundLogsHibernate.java
 * Author:   HUQIANBO001
 * Date:     2016-04-08 13:59:38
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-08 13:59:38><version><desc>
 */

package com.huazhu.hvip.order.payment.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.payment.dao.RefundLogsDao;
import com.huazhu.hvip.order.payment.model.RefundLogs;
import org.springframework.stereotype.Repository;

@Repository("refundLogsDao")
public class RefundLogsHibernate extends GenericDaoHibernate<RefundLogs, Long> implements RefundLogsDao {

    public RefundLogsHibernate() {
        super(RefundLogs.class);
    }

}
