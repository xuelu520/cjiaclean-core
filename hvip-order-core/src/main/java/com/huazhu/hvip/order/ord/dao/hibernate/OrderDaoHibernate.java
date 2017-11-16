/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: LookRoomDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.order.ord.dao.OrderDao;
import com.huazhu.hvip.order.ord.model.Order;
import com.huazhu.hvip.order.ord.model.extend.HotelOrderSale;
import com.huazhu.hvip.order.ord.model.extend.OrderActionExt;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("orderDao")
public class OrderDaoHibernate extends GenericDaoHibernate<Order, Long> implements OrderDao {

    public OrderDaoHibernate() {
        super(Order.class);
    }

//    /**
//     * 跟新关联外部订单信息
//     *
//     * @param order
//     */
//    @Override
//    public void updateOrgOrder(Order order) {
//        Long orderId = order.getOrderId();
//        String orderSn = order.getOrderSn();
//        String sql = " update vip_order set orgType='" + order.getOrgType() + "',orgValue='" + order.getOrgValue() + "' ";
//        String where = "";
//        if (orderId != null) {
//            where = " where orderId =" + orderId;
//        } else if (!StringUtil.isEmpty(orderSn)) {
//            where = " where orderSn ='" + orderSn + "'";
//        } else {
//            return;
//        }
//        super.updateObject(sql + where);
//    }

    /**
     * 查询订单列表
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<OrderExt> searchOrderList(QueryModel queryModel) {

        List<OrderExt> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT o.orderId,o.orderNo,o.orderSn,o.storeId,o.hotelId,o.hotelName,o.hotelAddress,o.hotelUniqueNo, ");
            sql.append(" o.hotelNo,o.hotelOrderSn,o.hotelRecOrderSn,o.hotelTelNo,o.hotelRoomNo,o.hoBillId,o.parentId,o.`status`,o.payStatus,o.shipStatus, ");
            sql.append(" o.deleteFlag,o.goodsAmount,o.shippingAmount,o.discount,o.orderAmount,o.refundAmount,o.memberId,o.memberMobile, ");
            sql.append(" o.memberTelNo,o.memberName,o.memberAddress,o.memberIdType,o.memberIdNo,o.shipName,o.shipAddr,o.shipZip,o.shipEmail, ");
            sql.append(" o.shipMobile,o.shipTel,o.shipDay,o.shipTime,o.cancelReason,o.signingTime,o.theSign,o.remark,o.completeTime,o.payTime, ");
            sql.append(" o.cateRule,o.pmsBillNo,o.allocationTime,o.createTime,o.createUser,o.updateTime,o.updateUser,o.billType,o.source,o.splitProportion,o.orgType,o.orgValue,s.createTime shipmentTime,null as serviceTime,oi.goodsName ");
            sql.append(" FROM vip_order o LEFT JOIN vip_orderitems oi on o.orderId=oi.orderId ");
            sql.append(" LEFT JOIN vip_shipments s on o.orderId=s.orderId ");
            sql.append(" WHERE ");
            sql.append(conditionSql);


            boolean pageFlag = false;

            // 如果在分页模式下，则计算总数
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {

                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(*)  ");
                countSql.append(" FROM (" + sql + ") aa GROUP BY aa.orderId ");
                //countSql.append(conditionSql);
                SQLQuery countQuery = session.createSQLQuery(countSql.toString());
                queryModel.assignValue(countQuery);
                List countList = countQuery.list();
                int totalNum = 0;
                if (!countList.isEmpty()) {
                    totalNum = countList.size();
                }
                queryModel.setTotalNum(totalNum);
                pageFlag = true;
            }

            String sortHql = queryModel.getSortHql();

//            if (StringUtils.isNotBlank(sortHql)) {
//                sql.append(" ORDER BY " + sortHql);
//            }

            String queryString = sql.toString();
            queryString = "SELECT a.* FROM (" + queryString + ") a GROUP BY a.orderId ORDER BY a.createTime DESC ";
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 获取订单的来源
     *
     * @return
     */
    @Override
    public List<String> searchOrderSourceList() {
        Session session = super.getSessionFactory().getCurrentSession();
        String queryString = "SELECT DISTINCT(vip_order.source) FROM vip_order";
        SQLQuery query = session.createSQLQuery(queryString);
        List<String> sourceList = query.list();
        return sourceList;
    }

    @Override
    public List<OrderExt> searchReportList(QueryModel queryModel) {
        List<OrderExt> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT o.orderId,o.orderNo,o.orderSn,o.storeId,o.hotelId,o.hotelName,o.hotelAddress,o.hotelUniqueNo, ");
            sql.append(" o.hotelNo,o.hotelOrderSn,o.hotelRecOrderSn,o.hotelTelNo,o.hotelRoomNo,o.hoBillId,o.parentId,o.`status`,o.payStatus,o.shipStatus, ");
            sql.append(" o.deleteFlag,o.goodsAmount,o.shippingAmount,o.discount,o.orderAmount,o.refundAmount,o.memberId,o.memberMobile, ");
            sql.append(" o.memberTelNo,o.memberName,o.memberAddress,o.memberIdType,o.memberIdNo,o.shipName,o.shipAddr,o.shipZip,o.shipEmail, ");
            sql.append(" o.shipMobile,o.shipTel,o.shipDay,o.shipTime,o.cancelReason,o.signingTime,o.theSign,o.remark,o.completeTime,o.payTime, ");
            sql.append(" o.cateRule,o.pmsBillNo,o.allocationTime,o.createTime,o.createUser,o.updateTime,o.updateUser,o.billType,o.source,o.orgType,o.orgValue,o.splitProportion,null as serviceTime,s.createTime as shipmentTime");
            sql.append(" FROM vip_order o LEFT JOIN vip_orderitems oi on o.orderId=oi.orderId LEFT JOIN vip_shipmentsitem s ON s.goodsId = oi.goodsId");
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 统计酒店销售额
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<HotelOrderSale> searchHotelOrderSale(QueryModel queryModel) {
        List list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT o.`hotelId`,o.`hotelNo`,o.`hotelName`,YEAR(o.createTime) year,MONTH(o.createTime) month," +
                    "SUM(o.`orderAmount`) sale FROM vip_order o ");
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

            sql.append(" GROUP BY o.hotelId ");

            if (StringUtils.isNotBlank(sortHql)) {
                sql.append(" ORDER BY " + sortHql);
            }

            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(HotelOrderSale.class);

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 积分报表查询订单部分数据
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<OrderActionExt> searchScoreListJson(QueryModel queryModel) {
        List<OrderActionExt> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT o.orderId,o.orderNo,o.orderSn,o.storeId,o.hotelId,o.hotelName,o.hotelAddress,o.hotelUniqueNo, ");
            sql.append(" o.hotelNo,o.hotelOrderSn,o.hotelRecOrderSn,o.hotelTelNo,o.hotelRoomNo,o.hoBillId,o.parentId,o.`status`,o.payStatus,o.shipStatus, ");
            sql.append(" o.deleteFlag,o.goodsAmount,o.shippingAmount,o.discount,o.orderAmount,o.refundAmount,o.memberId,o.memberMobile, ");
            sql.append(" o.memberTelNo,o.memberName,o.memberAddress,o.memberIdType,o.memberIdNo,o.shipName,o.shipAddr,o.shipZip,o.shipEmail, ");
            sql.append(" o.shipMobile,o.shipTel,o.shipDay,o.shipTime,o.cancelReason,o.signingTime,o.theSign,o.remark,o.completeTime,o.payTime, ");
            sql.append(" o.pmsBillNo,o.allocationTime,o.createTime,o.createUser,o.updateTime,o.updateUser,o.billType,o.source,o.orgType,o.orgValue,o.splitProportion,GROUP_CONCAT(oi.`goodsName`,'*',oi.`salesNum`) as goodsName,GROUP_CONCAT(DATE_FORMAT (oi.`assignTime`,'%Y-%m-%d')) as serviceTime,null as shipmentTime,p.payMethod,p.payResponse");
            sql.append(" FROM vip_order o LEFT JOIN vip_orderitems oi on o.orderId=oi.orderId");
            sql.append(" LEFT JOIN vip_payment p ON p.orderId=o.orderId");
            sql.append(" WHERE ");
            sql.append(conditionSql);
            boolean pageFlag = false;

            // 如果在分页模式下，则计算总数
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {

                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(*)  ");
                countSql.append(" FROM (" + sql + ") aa ");
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

            query.addEntity(OrderActionExt.class);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 统计订单销售总额
     * @param queryModel
     * @return
     */
    @Override
    public BigDecimal searchOrderAllMoney(QueryModel queryModel) {
        Session session = super.getSessionFactory().getCurrentSession();
        BigDecimal orderAllAmount=new BigDecimal("0.00");
        String conditionSql = queryModel.getQueryHqlStr();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT SUM(a.orderAmount) from");
        sql.append(" (SELECT o.orderId,o.orderNo,o.orderSn,o.storeId,o.hotelId,o.hotelName,o.hotelAddress,o.hotelUniqueNo, ");
        sql.append(" o.hotelNo,o.hotelOrderSn,o.hotelTelNo,o.hotelRoomNo,o.hoBillId,o.parentId,o.`status`,o.payStatus,o.shipStatus, ");
        sql.append(" o.deleteFlag,o.goodsAmount,o.shippingAmount,o.discount,o.orderAmount,o.refundAmount,o.memberId,o.memberMobile, ");
        sql.append(" o.memberTelNo,o.memberName,o.memberAddress,o.memberIdType,o.memberIdNo,o.shipName,o.shipAddr,o.shipZip,o.shipEmail, ");
        sql.append(" o.shipMobile,o.shipTel,o.shipDay,o.shipTime,o.cancelReason,o.signingTime,o.theSign,o.remark,o.completeTime,o.payTime, ");
        sql.append(" o.pmsBillNo,o.allocationTime,o.createTime,o.createUser,o.updateTime,o.updateUser,o.billType,o.source,o.orgType,o.orgValue,o.splitProportion");
        sql.append(" FROM vip_order o LEFT JOIN vip_orderitems oi on o.orderId=oi.orderId");
        sql.append(" LEFT JOIN vip_orderdebit od ON od.orderId=o.orderId");
        sql.append(" WHERE ");
        sql.append(" o.billType=1 and");
        sql.append(conditionSql);
        sql.append(" GROUP BY o.orderId");
        sql.append(" ) a");
        String queryString = sql.toString();
        SQLQuery countQuery = session.createSQLQuery(queryString);
        orderAllAmount = (BigDecimal) countQuery.uniqueResult();
        return orderAllAmount;
    }

    /**
     * 每个员工的销售金额
     *
     * @param queryModel
     * @return
     */
    @Override
    public  List<Map<String, Object>> searchEveryEmyployeeSalary(QueryModel queryModel) {
        Session session=super.getSessionFactory().getCurrentSession();
        String conditionSql = queryModel.getQueryHqlStr();
        StringBuffer sql=new StringBuffer();
        sql.append("SELECT oi.orderId,oi.price,oi.salesNum,od.userName ");
        sql.append(" FROM vip_orderitems oi LEFT JOIN vip_order o ON o.orderId = oi.orderId");
        sql.append(" LEFT JOIN vip_orderdebit od ON od.orderId=oi.orderId");
        sql.append(" WHERE ");
        sql.append(conditionSql.toString());
        sql.append(" GROUP BY oi.itemsId");
        StringBuffer queryString =new StringBuffer();
        queryString.append(" SELECT COUNT(a.orderId) as saleUserNumber,SUM(a.salesNum * a.price) as saleUserMoney,a.userName as recordingUser FROM (" );
        queryString.append( sql.toString());
        queryString.append(" )a GROUP BY a.userName");
        Query query = session.createSQLQuery(queryString.toString());
        return (List<Map<String, Object>>) query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }


    /**
     * 报表列表查询
     *
     * @param paramObject
     * @return
     *//*
    @Override
    public List<OrderExt> searchReportList(ParamObject paramObject) {
        ReturnObject<OrderExt> ret = new ReturnObject<>();
        String hotelUniqueNo = paramObject.getStringParam("hotelUniqueNo");
        String source = paramObject.getStringParam("source");
        String goodsName = paramObject.getStringParam("goodsName");
        String beginTime = paramObject.getStringParam("beginTime");
        String endTime = paramObject.getStringParam("endTime");
        String status =  paramObject.getStringParam("status");
        Integer pageNo=paramObject.getPageNo();
        Integer pageSize=paramObject.getPageSize();
        StringBuilder sql =new StringBuilder();
        sql.append("SELECT o.*,s.createTime as shipmentsCreateTime FROM vip_order o left JOIN vip_orderitems ot ON o.orderId = ot.orderId left JOIN vip_shipmentsitem s ON s.goodsId = ot.goodsId");
        *//*sql.append("limit "+paramObject.getPageNo()+","+paramObject.getPageSize()+"");*//*
        *//*sql.append("limit 1,20");*//*
        sql.append("  WHERE o.hotelUniqueNo = '"+hotelUniqueNo+"'");
        if(source.equals("-1")){
            sql.append(" AND o.source !='"+source+"'");
        }else {
            sql.append(" AND o.source ='"+source+"'");
        }
        if(goodsName.equals("-1")){
            sql.append(" AND ot.goodsName !='"+goodsName+"'");
        }else {
            sql.append(" AND ot.goodsName= '"+goodsName+"'");
        }
        sql.append(" AND ot.assignTime > '"+beginTime+"' AND ot.assignTime < '"+endTime+"'");
        sql.append(" AND o.status IN ("+status+") AND o.deleteFlag != 1 ORDER BY s.createTime DESC ");
        String countsql="select count(1) from ("+sql.toString()+") aa order by aa.createUser";
        Session session = super.getSessionFactory().getCurrentSession();
        BigInteger totalnum= (BigInteger) session.createSQLQuery(countsql).uniqueResult();
        Integer totalPage=((totalnum.intValue() +paramObject.getPageSize() - 1) / paramObject.getPageSize());
        paramObject.setTotelPageNum(totalPage);
        String querysql="select * from ("+sql.toString()+") aa order by aa.createUser limit "+pageNo+","+pageSize+"";
        SQLQuery sqlQuery =session.createSQLQuery(querysql);
        sqlQuery.addEntity(OrderExt.class);
        List<OrderExt>orderExtList=sqlQuery.list();
        return orderExtList;
    }*/
}
