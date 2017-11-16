/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: PaymentDaoHibernate.java
 * Author:   HUQIANBO001
 * Date:     2016-04-05 11:03:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-05 11:03:42><version><desc>
 */

package com.huazhu.hvip.order.payment.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.order.ord.dao.OrderItemsDao;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;
import com.huazhu.hvip.order.payment.dao.PaymentDao;
import com.huazhu.hvip.order.payment.model.Payment;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("paymentDao")
public class PaymentDaoHibernate extends GenericDaoHibernate<Payment, Long> implements PaymentDao {

    public PaymentDaoHibernate() {
        super(Payment.class);
    }

    @Override
    public List<Map<Long,String>> searchReportPayTypeList(QueryModel queryModel) {
        List<Map<Long,String>> paymentMapList = new ArrayList<>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            StringBuffer paymentSql=new StringBuffer();
            sql.append("select o.orderId");
            sql.append(" from vip_orderitems oi left JOIN vip_order o ON o.orderId = oi.orderId left JOIN vip_shipmentsitem s ON s.orderItemId = oi.itemsId");
            sql.append(" where o.orderId = p.orderId and ");
            sql.append(conditionSql);
            paymentSql.append("select p.orderId, p.payType");
            paymentSql.append(" FROM vip_payment p");
            paymentSql.append(" WHERE EXISTS ("+sql.toString()+")");
            Query query = session.createSQLQuery(paymentSql.toString());
            paymentMapList= (List)query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return paymentMapList;
    }
}
