/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ShipmentsDaoHibernate.java
 * Author:   HUQIANBO001
 * Date:     2016-04-07 16:19:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-07 16:19:23><version><desc>
 */

package com.huazhu.hvip.order.shipments.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.shipments.dao.ShipmentsDao;
import com.huazhu.hvip.order.shipments.model.Shipments;
import org.springframework.stereotype.Repository;

@Repository("shipmentsDao")
public class ShipmentsDaoHibernate extends GenericDaoHibernate<Shipments, Long> implements ShipmentsDao {

    public ShipmentsDaoHibernate() {
        super(Shipments.class);
    }

}
