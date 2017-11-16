/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: OrderItemsDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.order.ord.dao.OrderItemsDao;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("orderItemsDao")
public class OrderItemsDaoHibernate extends GenericDaoHibernate<OrderItems, Long> implements OrderItemsDao {

    private static Logger logger = LogManager.getLogger(OrderItemsDaoHibernate.class);

    public OrderItemsDaoHibernate() {
        super(OrderItems.class);
    }

    /**
     * 查找订单货物列表
     */
    public List<OrderItems> searchOrderItemsList(ParamObject paramObject) {
        /*select voi.* from vip_order vo left join vip_orderitems voi
        on vo.orderId=voi.orderId
        where
        vo.hotelUniqueNo='HN02000001'
        and voi.assignTime>='2016-04-01 00:00:00' and voi.assignTime<='2016-04-01 23:59:00'
        and vo.memberName like '%私人订制%'
        and vo.memberTelNo like '%1234567890%'
        and vo.hotelRoomNo like '%203%'
        and voi.goodsName like '%纳米牙具套装%'
        and voi.goodsId=4*/
        StringBuffer queryHQL = new StringBuffer("select voi from Order vo , OrderItems voi where vo.orderId = voi.orderId   ");
        return commonSearchOrderItemsList(paramObject, queryHQL);
    }

    /**
     * 查找订单货物以及订单信息列表
     */
    public List<OrderItemsExt> searchOrderItemsExtList(ParamObject paramObject) {
        StringBuffer queryHQL = new StringBuffer("select new com.huazhu.hvip.order.ord.model.extend.OrderItemsExt(vo.orderId,vo.orderSn,voi.itemsId,voi.goodsId,vo.hotelOrderSn,vo.hotelRoomNo,vo.memberMobile as memberTelNo,vo.memberName,voi.assignTime,voi.status,voi.goodsName) from Order vo , OrderItems voi where vo.orderId = voi.orderId  ");
        return commonSearchOrderItemsList(paramObject, queryHQL);
    }

    /**
     * 报表查询
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<OrderItemsExt> searchReportList(QueryModel queryModel) {
        List<OrderItemsExt> list = new ArrayList<>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append("select oi.itemsId,oi.orderId,oi.goodsId,oi.goodsName" +
                    ",oi.goodsNo,oi.goodsPicId,oi.specJson,oi.productId" +
                    ",oi.productName,oi.productNo,oi.productSn,oi.salesNum" +
                    ",oi.shipNum,oi.`status`,oi.unit,oi.cost,oi.price" +
                    ",oi.channelPriceId,oi.assignPerson,oi.assignTelNo,oi.assignTime" +
                    ",oi.assignExtJson,oi.createTime,oi.createUser,oi.updateTime,oi.updateUser" +
                    ",o.billType,o.hoCheckInDate,o.hoCheckOutDate,\n" +
                    "\to.createUser AS orderCreateUser,\n" +
                    "\to.createTime AS orderCreateTime,\n" +
                    "\to.updateUser orderUpdateUser,\n" +
                    "\to. STATUS orderStatus,\n" +
                    "\to.hotelTelNo AS telNo,\n" +
                    "\to.payTime,\n" +
                    "\to.orderSn,\n" +
                    "\to.source,\n" +
                    "\tod.createTime AS shipmentsCreateTime,\n" +
                    "\to.hotelRoomNo,\n" +
                    "\to.memberTelNo,\n" +
                    "\to.memberName,\n" +
                    "\to.hotelAddress AS address,\n" +
                    "\to.orderSn AS hotelOrderSn,\n" +
                    "\tNULL AS orderALLAcmount,\n" +
                    "\tNULL AS saleUserNumber,\n" +
                    "\tNULL AS saleUserMoney,\n" +
                    "\tNULL AS APPMoney,\n" +
                    "\tNULL AS H5Money,od.userName AS recordingUser");
            sql.append(" FROM vip_orderitems oi");
            sql.append(" LEFT JOIN vip_order o ON o.orderId = oi.orderId");
            sql.append(" LEFT JOIN vip_shipmentsitem s ON s.orderItemId = oi.itemsId");
            sql.append(" LEFT JOIN vip_orderdebit od ON od.orderId = o.orderId");
            sql.append(" where");
            sql.append(conditionSql);
            sql.append(" group by oi.itemsId ORDER BY FIELD(oi.`status`,4,3,1,11,0,2,5,6,7,8),od.userName,o.createTime desc");
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {
                sql.append(" limit "+(queryModel.getPageNo()-1)*queryModel.getPageSize()+","+queryModel.getPageSize());
            }
            StringBuffer queryString=new StringBuffer();
            queryString.append("SELECT a.*,p.payType FROM ("+sql.toString()+") a");
            queryString.append(" LEFT JOIN vip_payment p ON p.orderId = a.orderId GROUP BY a.itemsId");
            queryString.append(" order by FIELD(a.`status`,4,3,1,11,0,2,5,6,7,8),a.createTime DESC,a.recordingUser");

            // 如果在分页模式下，则计算总数
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {
                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(1) from (");
                countSql.append(" select oi.itemsId FROM vip_orderitems oi LEFT JOIN vip_order o ON o.orderId = oi.orderId  ");
                countSql.append(" LEFT JOIN vip_orderdebit od ON od.orderId = o.orderId where " + conditionSql + "");
                countSql.append(" GROUP BY oi.itemsId");
                countSql.append(" ) a");
                SQLQuery countQuery = session.createSQLQuery(countSql.toString());
                BigInteger totalNum = (BigInteger) countQuery.uniqueResult();
                queryModel.setTotalNum(totalNum.intValue());
            }
            SQLQuery query = session.createSQLQuery(queryString.toString());
            query.addEntity(OrderItemsExt.class);
            queryModel.assignValue(query);
            list=query.list();
            // 分页模式下只列当前页
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 订单查询与报表
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<OrderExt> searchNewOrderListJson(QueryModel queryModel) {
        List<OrderExt> list = new ArrayList<>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT o.orderId,o.orderNo,o.orderSn,o.storeId,o.hotelId,o.hotelName,o.hotelAddress,o.hotelUniqueNo, ");
            sql.append(" o.hotelNo,o.hotelOrderSn,o.hotelRecOrderSn,o.hotelTelNo,o.hotelRoomNo,o.hoBillId,o.parentId,o.`status`,o.payStatus,o.shipStatus, ");
            sql.append(" o.deleteFlag,o.goodsAmount,o.shippingAmount,o.discount,o.orderAmount,o.refundAmount,o.memberId,o.memberMobile, ");
            sql.append(" o.memberTelNo,o.memberName,o.memberAddress,o.memberIdType,o.memberIdNo,o.shipName,o.shipAddr,o.shipZip,o.shipEmail, ");
            sql.append(" o.shipMobile,o.shipTel,o.shipDay,o.shipTime,o.cancelReason,o.signingTime,o.theSign,o.remark,o.completeTime,o.payTime, ");
            sql.append(" o.cateRule,o.pmsBillNo,o.allocationTime,o.createTime,o.createUser,o.updateTime,o.updateUser,o.billType,o.source,o.orgType,o.orgValue,o.splitProportion,GROUP_CONCAT(oi.`goodsName`,'*',oi.`salesNum`) as goodsName,GROUP_CONCAT(DATE_FORMAT (oi.`assignTime`,'%Y-%m-%d')) as serviceTime,null as shipmentTime");
            sql.append(" FROM vip_order o LEFT JOIN vip_orderitems oi on o.orderId=oi.orderId");
            sql.append(" WHERE ");
            sql.append(conditionSql);
            boolean pageFlag = false;

            // 如果在分页模式下，则计算总数
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {

                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(*)  ");
                countSql.append(" FROM (" + sql + ") aa ");
                //countSql.append(conditionSql);
                SQLQuery countQuery = session.createSQLQuery(countSql.toString());
                queryModel.assignValue(countQuery);
                List countList = countQuery.list();
                int totalNum = 0;
                if (!countList.isEmpty()) {
                    String str = new String(countList.get(0).toString());
                    totalNum = (Long.valueOf(str)).intValue();
                }
                queryModel.setTotalNum(totalNum);
                pageFlag = true;
            }

            String sortHql = queryModel.getSortHql();

            if (StringUtils.isNotBlank(sortHql)) {
                sql.append(" ORDER BY " + sortHql);
            }

            String queryString = sql.toString();
            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(OrderExt.class);

            queryModel.assignValue(query);
            // 分页模式下只列当前页
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                list = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();
            } else {
                list = query.list();
            }
            if (!pageFlag) {
                if (!list.isEmpty())
                    queryModel.setTotalNum(list.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 积分报表部分数据
     * @param queryModel
     * @return
     */
    @Override
    public List<Map<String, Object>> searchPointListJson(QueryModel queryModel) {
        Session session = super.getSessionFactory().getCurrentSession();
        String conditionSql=queryModel.getQueryHqlStr();
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT pc.rate, pc.orderId,pc.hotelId,pc.amount,pc.bizDate from view_paymentchannels pc");
        sql.append(" where");
        sql.append(conditionSql);
        sql.append(" order by pc.bizDate desc");
        Query query = session.createSQLQuery(sql.toString());
        if (queryModel.getPageSize() != null && queryModel.getPageNo() != null) {
            Integer pagecount = query.list().size();
            Integer pageSize = queryModel.getPageSize();
            Integer pageNo = queryModel.getPageNo();
            query.setMaxResults(pageSize);
            query.setFirstResult((pageNo - 1) * pageSize);
            queryModel.setTotalNum(pagecount);
        }
        return (List<Map<String, Object>>) query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    private List commonSearchOrderItemsList(ParamObject paramObject, StringBuffer queryHQL) {
        if (paramObject.getStringParam("hotelUniqueNo") != null) {
            queryHQL.append(" and vo.hotelUniqueNo=").append("'" + paramObject.getStringParam("hotelUniqueNo") + "'");
        }
        if (paramObject.getStringParam("statusArray") != null) {
            queryHQL.append(" and voi.status in ( ").append(paramObject.getStringParam("statusArray")).append(") ");
        }
        if (paramObject.getIntegerParam("index") != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Integer index = paramObject.getIntegerParam("index");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR, index);
            queryHQL.append(" and voi.assignTime>=").append("'" + sdf.format(c.getTime()) + " 00:00:00'");
            queryHQL.append(" and voi.assignTime<=").append("'" + sdf.format(c.getTime()) + " 23:59:59'");
        }
        if (paramObject.getStringParam("query") != null) {
            String query = paramObject.getStringParam("query");
            queryHQL.append(" and ( ");
            queryHQL.append("  vo.memberName like ").append("'%" + query + "%'");
            queryHQL.append(" or vo.memberMobile like ").append("'%" + query + "%'");
            queryHQL.append(" or vo.hotelRoomNo like ").append("'%" + query + "%'");
            queryHQL.append(" or voi.goodsName like ").append("'%" + query + "%'");
            queryHQL.append(" ) ");
        }
        if (paramObject.getStringParam("goodsId") != null) {
            queryHQL.append(" and voi.goodsId in ( ").append(paramObject.getStringParam("goodsId")).append(") ");
        }
        if (paramObject.getStringParam("itemsId") != null) {
            queryHQL.append(" and voi.itemsId in ( ").append(paramObject.getStringParam("itemsId")).append(") ");
        }
        queryHQL.append(" order by voi.assignTime ,vo.memberName,vo.orderId ");
        logger.info("call OrderItemsDaoHibernate.searchOrderItemsList({\"queryHQL\":" + queryHQL.toString() + "}");
        Session session = getSession();
        Query query = session.createQuery(queryHQL.toString());
        if (paramObject.getPageSize() != null && paramObject.getPageNo() != null) {
            Integer pagecount = query.list().size();
            Integer pageSize = paramObject.getPageSize();
            Integer pageNo = paramObject.getPageNo();
            query.setMaxResults(pageSize);
            query.setFirstResult((pageNo - 1) * pageSize);
            paramObject.setTotalNum(pagecount);
        }
        return query.list();
    }
}
