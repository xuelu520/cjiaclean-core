

package com.huazhu.hvip.order.ord.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.*;
import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.*;
import com.huazhu.hvip.order.ord.model.extend.HotelOrderSale;
import com.huazhu.hvip.order.ord.model.extend.OrderExt;
import com.huazhu.hvip.order.ord.model.extend.OrderExtInfos;
import com.huazhu.hvip.order.payment.dao.PaymentDao;
import com.huazhu.hvip.order.payment.dao.RefundLogsDao;
import com.huazhu.hvip.order.payment.model.Payment;
import com.huazhu.hvip.order.payment.model.RefundLogs;
import com.huazhu.hvip.order.shipments.dao.ShipmentsDao;
import com.huazhu.hvip.order.shipments.dao.ShipmentsItemDao;
import com.huazhu.hvip.order.shipments.model.Shipments;
import com.huazhu.hvip.order.shipments.model.ShipmentsItem;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("orderManager")
public class OrderManagerImpl extends GenericManagerImpl<Order, Long> implements OrderManager {

    private static Logger logger = LogManager.getLogger(OrderManagerImpl.class);

    private OrderDao orderDao;

    @Autowired
    public OrderManagerImpl(OrderDao orderDao) {
        super(orderDao);
        this.orderDao = orderDao;
    }

    @Autowired
    private OrderItemsDao orderItemsDao;
    @Autowired
    private OrderActionDao orderActionDao;
    @Autowired
    private ShipmentsDao shipmentsDao;
    @Autowired
    private ShipmentsItemDao shipmentsItemDao;
    @Autowired
    private PaymentlogDao paymentlogDao;

    @Autowired
    private RefundLogsDao refundLogsDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private ServiceActionDao serviceActionDao;
    @Autowired
    private ServiceitemDao serviceitemDao;
    @Autowired
    private OrderUpdateLogDao orderUpdateLogDao;

    /**
     * 创建订单
     *
     * @param order
     * @param orderItemsList
     * @return
     */
    @Transactional
    @Override
    public Long createOrder(Order order, List<OrderItems> orderItemsList) {
        logger.info("call OrderManagerImpl.createOrder({\"order:\"" + JsonUtil.JSON_Bean2String(order) + "}," +
                "{\"orderItemsList:\"" + JsonUtil.JSON_List2String(orderItemsList) + "})");

        if (order == null) {
            logger.info("订单对象为空。。。");
            return null;
        }

        //初始化类型为未入账状态
        order.setBillType(Constants.BILL_TYPE_0);

        //保存订单信息
        order = orderDao.save(order);

        Long orderId = order.getOrderId();

        if (orderId == null) {
            logger.info("创建订单失败，orderId为空");
            return null;
        }

        //保存订单货物信息
        for (OrderItems orderItems : orderItemsList) {
            orderItems.setOrderId(orderId);
            orderItemsDao.save(orderItems);
        }


        return orderId;
    }

    /**
     * 根据条件获取订单相关信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OrderExt> getOrderDetail(ParamObject paramObject) {
        logger.info("call OrderManagerImpl.getOrderDetail({\"order:\"" + JsonUtil.JSON_Bean2String(paramObject) + "}");
        Long orderId = paramObject.getLongParam("orderId");
        String orderSn = paramObject.getStringParam("orderSn");
        List<OrderExt> orderExtList = new ArrayList<>();
        Map<String, List<OrderItems>> listHashMap = new HashMap<>();
        List<String> orderIdList = (List<String>) paramObject.getParam("orderIds"); //查询条件
        QueryModel queryModel = new QueryModel();

        if (orderId != null) {
            queryModel.addColumnValueCondition("orderId", orderId);
        }
        StringBuffer orderSnSB = new StringBuffer();
        if (orderSn != null) {
            if (StringUtils.isNotEmpty(orderSn)) {
                String[] orderSnArray = orderSn.split(",");
                for (int i = 0; i < orderSnArray.length; i++) {
                    orderSnSB.append("'");
                    orderSnSB.append(orderSnArray[i]);
                    orderSnSB.append("'");
                    if (i != orderSnArray.length - 1) {
                        orderSnSB.append(",");
                    }
                }

                queryModel.addHqlCondition(" orderSn in(" + orderSnSB.toString() + ")");
            }
        }
        if ((orderIdList == null || orderIdList.size() <= 0) && orderId == null && orderSn == null) {
            logger.info("至少得有一个参数");
            return null;
        }
        String orderIds = StringUtils.join(orderIdList, ",");
        if (StringUtils.isNotEmpty(orderIds)) {
            queryModel.addHqlCondition(" orderId in(" + orderIds + ")");
        }
        List<Order> orderList = orderDao.search(queryModel);

        if (orderList == null || orderList.size() <= 0) {
            logger.info("未查询到订单信息");
            return null;
        }
        orderIdList = new ArrayList<>();
        if (orderList != null && orderList.size() > 0) {
            for (Order order : orderList) {
                OrderExt orderExt = new OrderExt();
                BeanUtils.copyProperties(order, orderExt);
                orderIdList.add(order.getOrderId().toString());
                orderExtList.add(orderExt);
            }
        }
        QueryModel query = new QueryModel();
        orderIds = StringUtils.join(orderIdList, ",");
        if (StringUtils.isNotEmpty(orderIds)) {
            query.addHqlCondition(" orderId in(" + orderIds + ")");
        }
        query.addHqlCondition("status != '" + Constants.ORDERITEM_STATUS_DEL + "'");
        List<OrderItems> orderItemsList = orderItemsDao.search(query);
        if (orderExtList != null && orderExtList.size() > 0) {
            for (String id : orderIdList) {
                List<OrderItems> orderItemses = new ArrayList<>();
                for (OrderItems orderItems : orderItemsList) {
                    if (id.equals(orderItems.getOrderId().toString())) {
                        orderItemses.add(orderItems);
                    }
                }
                listHashMap.put(id, orderItemses);
            }
        }
        for (OrderExt orderExt : orderExtList) {
            orderItemsList = listHashMap.get(orderExt.getOrderId().toString());
            orderExt.setOrderItemsList(orderItemsList);
        }

        return orderExtList;
    }

    /**
     * 根据条件查询订单信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OrderExt> searchOrderList(ParamObject paramObject) {
        logger.info("call searchOrderList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        String sOrderID = paramObject.getStringParam("sOrderID");
        String orderBy = paramObject.getStringParam("orderBy"); //排序
        String keyword = paramObject.getStringParam("keyword"); //查询条件
        List<String> statusList = (List<String>) paramObject.getParam("statusList"); //状态
        List<String> orderIds = (List<String>) paramObject.getParam("orderIds"); //查询条件

        QueryModel queryModel = new QueryModel();
        String orderIDFlag = paramObject.getStringParam("orderIDFlag");
        List<String> orderSnlist = (List<String>) paramObject.getParam("orderSnList");
        queryModel.addColumnValueCondition("memberId", paramObject.getStringParam("memberId"));
        queryModel.addColumnValueCondition("hotelId", paramObject.getLongParam("hotelId"));
        queryModel.addColumnValueCondition("orderId", paramObject.getLongParam("orderId"));
        queryModel.addColumnValueCondition("orderSn", paramObject.getStringParam("orderSn"));
        queryModel.addColumnValueCondition("hotelUniqueNo", paramObject.getStringParam("hotelUniqueNo"));
        queryModel.addColumnValueCondition("deleteFlag", paramObject.getStringParam("deleteFlag"));
        queryModel.addColumnValueCondition("status", paramObject.getStringParam("status"));
        queryModel.addColumnValueCondition("hotelRoomNo", paramObject.getStringParam("hotelRoomNo"));
        if (StringUtils.isNotBlank(sOrderID)) {
            if (StringUtils.isNotBlank(orderIDFlag) && orderIDFlag.equals("true")) {  //主单
                //queryModel.addHqlCondition(" hotelOrderSn='"+paramObject.getStringParam("sOrderID")+"' and (hotelRecOrderSn='"+paramObject.getStringParam("hotelOrderSn")+"' or hotelRecOrderSn is null)");
                queryModel.addHqlCondition(" hotelRecOrderSn = '" + paramObject.getStringParam("hotelRecOrderSn") + "' or (hotelOrderSn = '" + sOrderID + "' and hotelRecOrderSn is null) ");
            } else if (StringUtils.isNotBlank(orderIDFlag) && orderIDFlag.equals("false")) { //从单
                queryModel.addColumnValueCondition("hotelRecOrderSn", paramObject.getStringParam("hotelRecOrderSn"));
            } else { //预订单或其他
                queryModel.addColumnValueCondition("hotelOrderSn", sOrderID);
                queryModel.addColumnValueCondition("hotelRecOrderSn", paramObject.getStringParam("hotelRecOrderSn"));
            }
        } else {
            queryModel.addColumnValueCondition("hotelRecOrderSn", paramObject.getStringParam("hotelRecOrderSn"));
        }
        String orderId = StringUtils.join(orderIds, ",");
        if (StringUtils.isNotEmpty(orderId)) {
            queryModel.addHqlCondition(" orderId in(" + orderId + ")");
        }
        if (statusList != null && statusList.size() > 0) {
            String s = StringUtils.join(statusList, ",");
            queryModel.addColumnValueCondition("status", QueryModel.OPERATOR_IN, "(" + s + ")");
        }

        if (StringUtils.isNotBlank(keyword)) {
            queryModel.addHqlCondition(" (memberName like '%" + keyword + "%' or memberMobile like '%" + keyword + "%' or hotelOrderSn like '%" + keyword + "%' ) ");
        }
        StringBuffer orderSns = new StringBuffer();
        if (orderSnlist != null && orderSnlist.size() > 0) {
            int count = 1;
            for (String orderSn : orderSnlist) {
                orderSns.append("'");
                orderSns.append(orderSn);
                orderSns.append("'");
                if (count != orderSnlist.size()) {
                    orderSns.append(",");
                }
                count++;
            }
        }

        if (!StringUtils.isEmpty(orderSns.toString())) {
            queryModel.addHqlCondition(" orderSn in(" + orderSns.toString() + ")");
        }
        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        } else {
            queryModel.setSortHql(" createTime DESC ");
        }
        if (paramObject.getPageNo() != null && paramObject.getPageSize() != null) {
            queryModel.setPageNo(paramObject.getPageNo());
            queryModel.setPageSize(paramObject.getPageSize());
        }
        List<Order> orderList = orderDao.search(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());
        if (orderList == null || orderList.isEmpty()) {
            return null;
        }

        List<OrderExt> orderExtList = new ArrayList<>();
        OrderExt orderExt = null;

        List<Long> orderIdList = new ArrayList<>();
        for (Order order : orderList) {
            orderIdList.add(order.getOrderId());

            orderExt = new OrderExt();
            BeanUtils.copyProperties(order, orderExt);
            orderExtList.add(orderExt);
        }
        QueryModel query = new QueryModel();
        String str = StringUtils.join(orderIdList, ",");
        query.addColumnValueCondition("orderId", QueryModel.OPERATOR_IN, "(" + str + ")");
        query.addHqlCondition("status != '" + Constants.ORDERITEM_STATUS_DEL + "'");
        List<OrderItems> orderItemsList = orderItemsDao.search(query);
        Map<Long, List<OrderItems>> itemMap = new HashMap<>();
        List<OrderItems> itemsList = null;

        for (Long oid : orderIdList) {
            itemsList = new ArrayList<>();

            for (OrderItems items : orderItemsList) {
                if (oid.equals(items.getOrderId())) {
                    itemsList.add(items);
                }
            }

            itemMap.put(oid, itemsList);
        }


        for (OrderExt orderExt1 : orderExtList) {
            List<OrderItems> orderItemsList1 = itemMap.get(orderExt1.getOrderId());

            orderExt1.setOrderItemsList(orderItemsList1);
        }

        return orderExtList;
    }

    /**
     * 根据条件查询订单信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OrderExt> searchOrderListByParam(ParamObject paramObject) {
        logger.info("call searchOrderListByParam({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        String sOrderID = paramObject.getStringParam("sOrderID");
        String orderBy = paramObject.getStringParam("orderBy"); //排序
        String keyword = paramObject.getStringParam("keyword"); //查询条件
        String beginTime = paramObject.getStringParam("beginTime");
        String endTime = paramObject.getStringParam("endTime");
        List<String> statusList = (List<String>) paramObject.getParam("statusList"); //状态

        QueryModel queryModel = new QueryModel();

        queryModel.addColumnValueCondition("o.memberId", paramObject.getLongParam("memberId"));
        queryModel.addColumnValueCondition("o.hotelId", paramObject.getLongParam("hotelId"));
        queryModel.addColumnValueCondition("o.orderId", paramObject.getLongParam("orderId"));
        queryModel.addColumnValueCondition("o.orderSn", paramObject.getStringParam("orderSn"));
        queryModel.addColumnValueCondition("o.hotelUniqueNo", paramObject.getStringParam("hotelUniqueNo"));
        queryModel.addColumnValueCondition("o.deleteFlag", paramObject.getStringParam("deleteFlag"));
        queryModel.addColumnValueCondition("o.status", paramObject.getStringParam("status"));
        queryModel.addColumnValueCondition("o.hotelRoomNo", paramObject.getStringParam("hotelRoomNo"));
        queryModel.addColumnValueCondition("oi.goodsId", paramObject.getLongParam("goodsId"));


        if (StringUtils.isNotBlank(sOrderID)) {
            queryModel.addHqlCondition(" (o.hotelOrderSn like '%" + paramObject.getStringParam("hotelOrderSn") + "%' or o.hotelOrderSn like '%" + sOrderID + "%' ) ");
        } else {
            queryModel.addColumnValueCondition("o.hotelOrderSn", paramObject.getStringParam("hotelOrderSn"));
        }

        if (statusList != null && statusList.size() > 0) {
            String s = StringUtils.join(statusList, ",");
            queryModel.addColumnValueCondition("o.status", QueryModel.OPERATOR_IN, "(" + s + ")");
        }

        if (StringUtils.isNotBlank(keyword)) {
            queryModel.addHqlCondition(" (o.memberName like '%" + keyword + "%' or o.memberMobile like '%" + keyword + "%' or o.hotelOrderSn like '%" + keyword + "%' or o.hotelRecOrderSn like '%" + keyword + "%' ) ");
        }

        if (StringUtils.isNotBlank(beginTime)) {
            queryModel.addHqlCondition(" oi.assignTime >= '" + beginTime + " 00:00:00' ");
        }

        if (StringUtils.isNotBlank(endTime)) {
            queryModel.addHqlCondition(" oi.assignTime <= '" + endTime + " 23:59:59' ");
        }

        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        } else {
            queryModel.setSortHql(" o.createTime DESC ");
        }
        if (paramObject.getPageNo() != null && paramObject.getPageSize() != null) {
            queryModel.setPageNo(paramObject.getPageNo());
            queryModel.setPageSize(paramObject.getPageSize());
        }

        List<OrderExt> orderExtList = orderDao.searchOrderList(queryModel);

        paramObject.setTotalNum(queryModel.getTotalNum());

        if (orderExtList == null || orderExtList.isEmpty()) {
            return null;
        }

        List<Long> orderIdList = new ArrayList<>();
        for (OrderExt order : orderExtList) {
            orderIdList.add(order.getOrderId());
        }

        QueryModel query = new QueryModel();
        String str = StringUtils.join(orderIdList, ",");
        query.addColumnValueCondition("orderId", QueryModel.OPERATOR_IN, "(" + str + ")");
        query.addHqlCondition("status != '" + Constants.ORDERITEM_STATUS_DEL + "'");
        List<OrderItems> orderItemsList = orderItemsDao.search(query);

        Map<Long, List<OrderItems>> itemMap = new HashMap<>();
        List<OrderItems> itemsList = null;

        for (Long oid : orderIdList) {
            itemsList = new ArrayList<>();

            for (OrderItems items : orderItemsList) {
                if (oid.equals(items.getOrderId())) {
                    itemsList.add(items);
                }
            }
            itemMap.put(oid, itemsList);
        }


        for (OrderExt orderExt1 : orderExtList) {
            List<OrderItems> orderItemsList1 = itemMap.get(orderExt1.getOrderId());

            orderExt1.setOrderItemsList(orderItemsList1);
        }

        return orderExtList;
    }

    /**
     * op根据条件查询订单信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OrderExt> searchOrderListForOp(ParamObject paramObject) {
        logger.info("call searchOrderList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        String orderBy = paramObject.getStringParam("orderBy"); //排序
        String keyword = paramObject.getStringParam("keyword");//模糊查询关键字
        String beginTime = paramObject.getStringParam("beginTime");
        String endTime = paramObject.getStringParam("endTime");

        QueryModel queryModel = new QueryModel();
        queryModel.setPageNo(paramObject.getPageNo());
        queryModel.setPageSize(paramObject.getPageSize());
        queryModel.addColumnValueCondition("memberId", paramObject.getLongParam("memberId"));
        queryModel.addColumnValueCondition("hotelId", paramObject.getLongParam("hotelId"));
        queryModel.addColumnValueCondition("orderId", paramObject.getLongParam("orderId"));
        queryModel.addColumnValueCondition("orderSn", paramObject.getStringParam("orderSn"));
        queryModel.addColumnValueCondition("hotelUniqueNo", paramObject.getStringParam("hotelUniqueNo"));
        queryModel.addColumnValueCondition("deleteFlag", paramObject.getStringParam("deleteFlag"));
        queryModel.addColumnValueCondition("status", paramObject.getStringParam("status"));
        queryModel.addColumnValueCondition("billType", paramObject.getStringParam("billType"));
        queryModel.addColumnValueCondition("source", paramObject.getStringParam("source"));
        if (StringUtils.isNotBlank(beginTime)) {
            queryModel.addHqlCondition("createTime >= '" + beginTime + "'");
        }
        if (StringUtils.isNotBlank(endTime)) {
            queryModel.addHqlCondition("createTime <= '" + endTime + "'");
        }
        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        } else {
            queryModel.setSortHql(" createTime DESC ");
        }
        if (!StringUtil.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (orderSn like '%" + keyword + "%' or memberName like '%" + keyword + "%' or hotelName like '%" + keyword + "%') ");
        }

        List<Order> orderList = orderDao.search(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());

        if (orderList == null || orderList.isEmpty()) {
            return null;
        }

        List<OrderExt> orderExtList = new ArrayList<>();
        OrderExt orderExt = null;

        List<Long> orderIdList = new ArrayList<>();
        for (Order order : orderList) {
            orderIdList.add(order.getOrderId());

            orderExt = new OrderExt();
            BeanUtils.copyProperties(order, orderExt);

            orderExtList.add(orderExt);
        }

        QueryModel query = new QueryModel();
        String str = StringUtils.join(orderIdList, ",");
        query.addColumnValueCondition("orderId", QueryModel.OPERATOR_IN, "(" + str + ")");
        query.addHqlCondition("status != '" + Constants.ORDERITEM_STATUS_DEL + "'");

        List<OrderItems> orderItemsList = orderItemsDao.search(query);

        Map<Long, List<OrderItems>> itemMap = new HashMap<>();
        Map<Long, String> goodsMap = new HashMap<>();
        Map<Long, String> serviceMap = new HashMap<>();
        List<OrderItems> itemsList = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Long oid : orderIdList) {
            String goodsShow = "";
            String serviceTime = "";
            itemsList = new ArrayList<>();
            for (OrderItems items : orderItemsList) {
                if (oid.equals(items.getOrderId())) {
                    itemsList.add(items);
                    goodsShow += items.getGoodsName() + "*" + items.getSalesNum() + ";";
                    serviceTime += sdf.format(items.getAssignTime()) + "; ";
                }
            }
            itemMap.put(oid, itemsList);
            goodsMap.put(oid, goodsShow);
            serviceMap.put(oid, serviceTime);
        }


        for (OrderExt od : orderExtList) {
            List<OrderItems> orderItemsList1 = itemMap.get(od.getOrderId());

            od.setOrderItemsList(orderItemsList1);
            od.setGoodsShow(goodsMap.get(od.getOrderId()));
            od.setServiceTime(serviceMap.get(od.getOrderId()));
        }

        return orderExtList;
    }


    /**
     * 生成发货单
     *
     * @param order
     * @param operatorInfo
     */
    private Shipments createShipments(Order order, OperatorInfo operatorInfo, Date nowDate) {

        Shipments shipments = new Shipments();
        shipments.setCreateTime(nowDate);
        shipments.setCreateUser(operatorInfo == null ? null : operatorInfo.getOperatorName());

//        QueryModel queryModel = new QueryModel();
//        queryModel.addColumnValueCondition("orderId", order.getOrderId());
//        List<Shipments> shipmentsList = shipmentsDao.search(queryModel);
//
//        if (shipmentsList != null && shipmentsList.size() > 0) {
//            shipments = shipmentsList.get(0);
//        } else {
//            shipments = new Shipments();
//            shipments.setCreateTime(nowDate);
//            shipments.setCreateUser(operatorInfo == null ? null : operatorInfo.getOperatorName());
//        }

        shipments.setOrderId(order.getOrderId());
        shipments.setShipmentsType(Constants.SHIPMENTS_TYPE_SHIP);
        shipments.setReceiveName(order.getShipName());
        shipments.setReceiveAddr(order.getShipAddr());
        shipments.setReceiveZipCode(order.getShipZip());
        shipments.setReceiveTelNo(order.getShipTel());
        shipments.setReceiveMobile(order.getShipMobile());
        shipments.setReceiveEmail(order.getShipEmail());
        shipments.setRemark(order.getRemark());

        shipments.setUpdateTime(nowDate);
        shipments.setUpdateUser(operatorInfo == null ? null : operatorInfo.getOperatorName());

        shipments = shipmentsDao.save(shipments);

        return shipments;

    }

    /**
     * 生成发货单明细
     *
     * @param shipments
     * @param orderItems
     * @param operatorInfo
     * @param nowDate
     */
    public void createShipmentsItem(Shipments shipments, Order order, OrderItems orderItems, OperatorInfo operatorInfo, Date nowDate, OrderExtInfos orderExtInfos) {

//        //如果发货单不存在则创建发货单
        if (shipments == null || shipments.getShipmentsId() == null) {
            shipments = createShipments(order, operatorInfo, nowDate);
        }

        ShipmentsItem item = new ShipmentsItem();
        item.setShipmentsId(shipments.getShipmentsId());

        BeanUtils.copyProperties(orderItems, item);

        item.setNum(orderItems.getSalesNum());
        item.setOrderItemId(orderItems.getItemsId());

        if (orderExtInfos != null) {
            item.setRealExtJson(orderExtInfos.getRealExtJson());
            item.setRealExtJson(orderExtInfos.getRealExtJson());
        }

        item.setCreateTime(nowDate);
        item.setCreateUser(operatorInfo == null ? null : operatorInfo.getOperatorName());
        item.setUpdateTime(nowDate);
        item.setUpdateUser(operatorInfo == null ? null : operatorInfo.getOperatorName());

        shipmentsItemDao.save(item);

    }


    /**
     * 获取订单的来源
     *
     * @return
     */
    @Override
    public List<String> searchOrderSourceList() {
        List<String> sourceList = orderDao.searchOrderSourceList();
        return sourceList;
    }

    /**
     * 订单查询与报表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OrderExt> newOrderListJson(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();
        String keyword = paramObject.getStringParam("keyword");
        String beginTime = paramObject.getStringParam("beginTime");
        String endTime = paramObject.getStringParam("endTime");
        Integer pageno = paramObject.getPageNo();
        Integer pageSize = paramObject.getPageSize();
        if (StringUtils.isNotBlank(beginTime)) {
            queryModel.addHqlCondition("o.createTime >= '" + beginTime + "'");
        }
        if (StringUtils.isNotBlank(endTime)) {
            queryModel.addHqlCondition("o.createTime <= '" + endTime + "'");
        }
        queryModel.addColumnValueCondition("o.source", paramObject.getStringParam("source"));
        queryModel.addColumnValueCondition("o.orgType", paramObject.getStringParam("orgType"));
        queryModel.addColumnValueCondition("o.status", paramObject.getStringParam("status"));
        queryModel.addColumnValueCondition("o.billType", paramObject.getStringParam("billType"));
        if (!StringUtils.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (o.orderSn like '%" + keyword + "%' or o.hotelName like '%" + keyword + "%' or o.memberName like '%" + keyword + "%')");
        }
        if (pageno != null && pageSize != null) {
            queryModel.setPageNo(pageno);
            queryModel.setPageSize(pageSize);
        }
        queryModel.addHqlCondition(" (o.orderAmount>=0 or o.goodsAmount>=0) ");
        queryModel.addHqlCondition(" o.deleteFlag !=" + Constants.DELETE_FLAG_TRUE + " group by o.orderId ");
        queryModel.setSortHql(" o.orderId desc");
        List<OrderExt> orderExts = orderItemsDao.searchNewOrderListJson(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());
        return orderExts;
    }


    /**
     * 根据orderSn获取订单详情对getOrderDetailForHms更改
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OrderExt> getOrderDetailForHms(ParamObject paramObject) {
        String orderSns = paramObject.getStringParam("orderSns");
        QueryModel queryModel = new QueryModel();
        List<OrderExt> orderExtList = new ArrayList<>();
        List<String> orderIdList = new ArrayList<>();
        Map<String, List<OrderItems>> objectMap = new HashMap<>();
        StringBuffer orderSnSB = new StringBuffer();
        if (orderSns != null) {
            if (StringUtils.isNotEmpty(orderSns)) {
                String[] orderSnArray = orderSns.split(",");
                for (int i = 0; i < orderSnArray.length; i++) {
                    orderSnSB.append("'");
                    orderSnSB.append(orderSnArray[i]);
                    orderSnSB.append("'");
                    if (i != orderSnArray.length - 1) {
                        orderSnSB.append(",");
                    }
                }

                queryModel.addHqlCondition(" orderSn in(" + orderSnSB.toString() + ")");
            }
        }
        List<Order> orderList = orderDao.search(queryModel);
        if (orderList != null && orderList.size() > 0) {
            for (Order order : orderList) {
                if (!orderIdList.contains(order.getOrderId().toString())) {
                    orderIdList.add(order.getOrderId().toString());
                }
            }
            String orderIds = StringUtils.join(orderIdList, ",");
            queryModel = new QueryModel();
            queryModel.addHqlCondition(" orderId in (" + orderIds + ")");
            List<OrderItems> orderItemsList = orderItemsDao.search(queryModel);
            if (orderItemsList != null && orderItemsList.size() > 0) {
                for (String id : orderIdList) {
                    List<OrderItems> orderItemses = new ArrayList<>();
                    for (OrderItems orderItems : orderItemsList) {
                        if (id.equals(orderItems.getOrderId().toString())) {
                            orderItemses.add(orderItems);
                        }
                    }
                    objectMap.put(id, orderItemses);
                }
            }
            for (Order order : orderList) {
                OrderExt orderExt = new OrderExt();
                BeanUtils.copyProperties(order, orderExt);
                orderExt.setOrderItemsList(objectMap.get(order.getOrderId().toString()));
                orderExtList.add(orderExt);
            }
        }
        return orderExtList;
    }

    /**
     * 创建订单保存
     *
     * @param paramObject
     * @return
     */
    @Transactional
    @Override
    public Order saveOrder(ParamObject paramObject) {
        Order order = (Order) paramObject.getParam("order");
        List<OrderItems> orderItemsList = (List<OrderItems>) paramObject.getParam("orderItemsList");
        OrderAction orderAction = (OrderAction) paramObject.getParam("orderAction");
        Payment payment = (Payment) paramObject.getParam("payment");
        Paymentlog paymentlog = (Paymentlog) paramObject.getParam("paymentlog");
        List<com.huazhu.hvip.order.ord.model.Service> serviceList = (List<com.huazhu.hvip.order.ord.model.Service>) paramObject.getParam("serviceList");
        order = orderDao.save(order);
        for (OrderItems orderItems : orderItemsList) {
            orderItems.setOrderId(order.getOrderId());
            orderItemsDao.save(orderItems);
        }
        orderAction.setOrderId(order.getOrderId());
        orderActionDao.save(orderAction);
        payment.setOrderId(order.getOrderId());
        payment = paymentDao.save(payment);
        paymentlog.setOrderId(order.getOrderId());
        paymentlog.setPaymentId(payment.getPaymentId());
        if (Constants.ORDER_STATUS_WAITPAY.equals(order.getStatus())) {
            paymentlog.setAction("支付单(id:" + payment.getPaymentId() + ")" + "动作:创建支付单");
        } else if (Constants.ORDER_STATUS_WAITSERVICE.equals(order.getStatus())) {
            paymentlog.setAction("支付单(id:" + payment.getPaymentId() + ")" + "动作:支付单回调");
        }
        paymentlogDao.save(paymentlog);
        if (CheckUtil.checkListIsNull(serviceList)) {
            for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                service.setOrderId(order.getOrderId());
                service = serviceDao.save(service);
                serviceActionDao.save(setServiceAction(service));
            }
        }
        return order;
    }

    /**
     * 工单关联保洁员信息
     *
     * @param paramObject
     */
    @Transactional
    @Override
    public com.huazhu.hvip.order.ord.model.Service saveServiceItem(ParamObject paramObject) {
        com.huazhu.hvip.order.ord.model.Service service = (com.huazhu.hvip.order.ord.model.Service) paramObject.getParam("service");
        List<Serviceitem> serviceitemList = (List<Serviceitem>) paramObject.getParam("serviceitemList");
        service = serviceDao.save(service);
        ServiceAction serviceAction = setServiceAction(service);
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("serviceId", service.getServiceId());
        queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
        List<Serviceitem> serviceitems = serviceitemDao.search(queryModel);
        if (CheckUtil.checkListIsNull(serviceitems)) {
            for (Serviceitem serviceitem : serviceitems) {
                serviceitem.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
                serviceitemDao.save(serviceitem);
            }
        }
        serviceActionDao.save(serviceAction);
        for (Serviceitem serviceitem : serviceitemList) {
            serviceitemDao.save(serviceitem);
        }
        return service;
    }

    /**
     * 周期添加工单
     *
     * @param paramObject
     * @return
     */
    @Transactional
    @Override
    public List<com.huazhu.hvip.order.ord.model.Service> saveServiceVos(ParamObject paramObject) {
        List<com.huazhu.hvip.order.ord.model.Service> services = new ArrayList<>();
        Long orderId = null;
        List<com.huazhu.hvip.order.ord.model.Service> serviceList = (List<com.huazhu.hvip.order.ord.model.Service>) paramObject.getParam("services");
        for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
            service = serviceDao.save(service);
            orderId = service.getOrderId();
            ServiceAction serviceAction = setServiceAction(service);
            serviceActionDao.save(serviceAction);
            services.add(service);
        }
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("orderId", orderId);
        List<com.huazhu.hvip.order.ord.model.Service> list = serviceDao.search(queryModel);
        Order order = orderDao.get(orderId);
        int finishCount = 0;
        int waitServiceCount = 0;
        for (com.huazhu.hvip.order.ord.model.Service service : list) {
            if (Constants.SERVICE_STATUS_DON.equals(service.getStatus())) {
                finishCount++;
            } else if (Constants.SERVICE_STATUS_PAY.equals(service.getStatus())
                    || Constants.SERVICE_STATUS_WAITSERVICE.equals(service.getStatus())
                    || Constants.SERVICE_STATUS_SERVICING.equals(service.getStatus())) {
                waitServiceCount++;
            }
        }
        order.setFinishService(finishCount);
        order.setWaitServiceCount(waitServiceCount);
        orderDao.save(order);
        return services;
    }

    /**
     * 取消订单
     *
     * @param paramObject
     * @return
     */
    @Transactional
    @Override
    public List<Order> updateCancelOrder(ParamObject paramObject) {
        List<Order> orderList = (List<Order>) paramObject.getParam("orderList");
        List<OrderItems> orderItemsList = (List<OrderItems>) paramObject.getParam("orderItemsList");
        List<OrderAction> orderActionList = (List<OrderAction>) paramObject.getParam("orderActionList");
        List<com.huazhu.hvip.order.ord.model.Service> serviceList = (List<com.huazhu.hvip.order.ord.model.Service>) paramObject.getParam("serviceList");
        List<Serviceitem> serviceitemList = (List<Serviceitem>) paramObject.getParam("serviceitemList");
        for (Order order : orderList) {
            orderDao.save(order);
        }
        if (CheckUtil.checkListIsNull(orderItemsList)) {
            for (OrderItems orderItems : orderItemsList) {
                orderItemsDao.save(orderItems);
            }
        }
        for (OrderAction orderAction : orderActionList) {
            orderActionDao.save(orderAction);
        }
        if (CheckUtil.checkListIsNull(serviceList)) {
            for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                service = serviceDao.save(service);
                serviceActionDao.save(setServiceAction(service));
            }
        }
        if (CheckUtil.checkListIsNull(serviceitemList)) {
            for (Serviceitem serviceitem : serviceitemList) {
                serviceitemDao.save(serviceitem);
            }
        }
        return orderList;
    }


    /**
     * 退款
     *
     * @param paramObject
     * @return
     */
    @Override
    public Order updateRefundOrder(ParamObject paramObject) {
        Order order = (Order) paramObject.getParam("order");
        OrderAction orderAction = (OrderAction) paramObject.getParam("orderAction");
        orderActionDao.save(orderAction);
        RefundLogs refundLogs = (RefundLogs) paramObject.getParam("refundLogs");
        refundLogsDao.save(refundLogs);
        List<OrderItems> orderItemsList = (List<OrderItems>) paramObject.getParam("orderItemsList");
        if (CheckUtil.checkListIsNull(orderItemsList)) {
            for (OrderItems orderItems : orderItemsList) {
                orderItemsDao.save(orderItems);
            }
        }
        List<com.huazhu.hvip.order.ord.model.Service> serviceList = (List<com.huazhu.hvip.order.ord.model.Service>) paramObject.getParam("serviceList");
        if (CheckUtil.checkListIsNull(serviceList)) {
            for (com.huazhu.hvip.order.ord.model.Service service : serviceList) {
                service = serviceDao.save(service);
                serviceActionDao.save(setServiceAction(service));
            }
        }
        List<Serviceitem> serviceitemList = (List<Serviceitem>) paramObject.getParam("serviceitemList");
        if (CheckUtil.checkListIsNull(serviceitemList)) {
            for (Serviceitem serviceitem : serviceitemList) {
                serviceitemDao.save(serviceitem);
            }
        }
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("orderId", order.getOrderId());
        List<com.huazhu.hvip.order.ord.model.Service> list = serviceDao.search(queryModel);
        int finishCount = 0;
        int waitServiceCount = 0;
        for (com.huazhu.hvip.order.ord.model.Service service : list) {
            if (Constants.SERVICE_STATUS_DON.equals(service.getStatus())) {
                finishCount++;
            } else if (Constants.SERVICE_STATUS_PAY.equals(service.getStatus())
                    || Constants.SERVICE_STATUS_WAITSERVICE.equals(service.getStatus())
                    || Constants.SERVICE_STATUS_SERVICING.equals(service.getStatus())) {
                waitServiceCount++;
            }
        }
        order.setFinishService(finishCount);
        order.setWaitServiceCount(waitServiceCount);
        orderDao.save(order);
        return order;
    }

    /**
     * 批量保存
     *
     * @param orderList
     * @return
     */
    @Override
    @Transactional
    public List<Order> saveOrderList(List<Order> orderList) {
        for (Order order : orderList) {
            orderDao.save(order);
        }
        return orderList;
    }

    /**
     * 保存订单并做日志记录
     *
     * @param
     * @return
     */
    @Override
    @Transactional
    public Order saveOrderParam(ParamObject paramObject) {
        Order neworder = null;
        if (paramObject != null) {
            Order oldorder = (Order) paramObject.getParam("oldorder");
            neworder = (Order) paramObject.getParam("oldorder");
            neworder = orderDao.save(neworder);
            OrderUpdateLog orderUpdateLog = new OrderUpdateLog();
            orderUpdateLog.setUpdateUser(neworder.getUpdateUser());
            orderUpdateLog.setUpdateTime(neworder.getUpdateTime());
            orderUpdateLog.setOrderId(oldorder.getOrderId());
            orderUpdateLog.setNewParam(JSONObject.toJSONString(neworder));
            orderUpdateLog.setOldParam(JSONObject.toJSONString(oldorder));
            orderUpdateLogDao.save(orderUpdateLog);
        }
        return neworder;
    }

    private ServiceAction setServiceAction(com.huazhu.hvip.order.ord.model.Service service) {
        ServiceAction serviceAction = new ServiceAction();
        serviceAction.setOpId(service.getMemberId());
        serviceAction.setOpName(service.getUpdateUser());
        serviceAction.setOpTime(new Date());
        serviceAction.setServiceId(service.getServiceId());
        if (Constants.SERVICE_STATUS_WAITPAY.equals(service.getStatus())) {
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:创建工单");
        } else if (Constants.SERVICE_STATUS_PAY.equals(service.getStatus())) {
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:付款成功,待分配");
        } else if (Constants.SERVICE_STATUS_WAITSERVICE.equals(service.getStatus())) {
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:分配成功,保洁员:" + service.getCleanName());
        } else if (Constants.SERVICE_STATUS_SERVICING.equals(service.getStatus())) {
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:打扫中,保洁员:" + service.getCleanName());
        } else if (Constants.SERVICE_STATUS_DON.equals(service.getStatus())) {
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:打扫完成,保洁员:" + service.getCleanName());
        } else if (Constants.SERVICE_STATUS_CAL.equals(service.getStatus())) {
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:取消工单,操作人:" + service.getUpdateUser());
        }
        return serviceAction;
    }

    /**
     * 统计酒店销售额
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<HotelOrderSale> searchHotelOrderSale(ParamObject paramObject) {
        logger.info("call searchHotelOrderSale({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");
        QueryModel queryModel = new QueryModel();

//        Integer year = paramObject.getIntegerParam("year");
//        Integer month = paramObject.getIntegerParam("month");
//        if(year != null){
//            queryModel.addHqlCondition("");
//        }

        queryModel.addColumnValueCondition("YEAR(o.createTime)", paramObject.getIntegerParam("year"));
        queryModel.addColumnValueCondition("MONTH(o.createTime)", paramObject.getIntegerParam("month"));
        queryModel.addColumnValueCondition("o.billType", paramObject.getStringParam("billType"));

        if (paramObject.getParam("statusList") != null) {
            List<String> statusList = (List<String>) paramObject.getParam("statusList");
            String str = StringUtils.join(statusList, ",");
            queryModel.addColumnValueCondition("o.status", QueryModel.OPERATOR_IN, "(" + str + ")");
        }

        queryModel.addColumnValueCondition("o.deleteFlag", paramObject.getStringParam("deleteFlag"));

        return orderDao.searchHotelOrderSale(queryModel);
    }

    /**
     * 报表列表查询
     *
     * @param paramObject
     * @return
     */
   /* @Override
    public List<OrderExt> searchReportList(ParamObject paramObject) {
        logger.info("call searchReportList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");
        String hotelUniqueNo = paramObject.getStringParam("hotelUniqueNo");
        String source = paramObject.getStringParam("source");
        String goodsName = paramObject.getStringParam("goodsName");
        String beginTime = paramObject.getStringParam("beginTime");
        String endTime = paramObject.getStringParam("endTime");
        String status = paramObject.getStringParam("status");
        Integer pageNo = paramObject.getPageNo();
        Integer pageSize = paramObject.getPageSize();

        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("hotelUniqueNo", hotelUniqueNo);
        if (source.equals("-1")) {
            queryModel.addHqlCondition(" o.source !='" + source + "'");
        } else {
            queryModel.addHqlCondition("  o.source ='" + source + "'");
        }
        if (goodsName.equals("-1")) {
            queryModel.addHqlCondition("  oi.goodsName !='" + goodsName + "'");
        } else {
            queryModel.addHqlCondition("  oi.goodsName= '" + goodsName + "'");
        }
        queryModel.addHqlCondition("s.createTime > '" + beginTime + "' AND s.createTime < '" + endTime + "'");
        queryModel.addHqlCondition("o.status IN (" + status + ") AND o.deleteFlag != 1");
        queryModel.setSortHql("s.source DESC");
        queryModel.setSortHql("s.createTime DESC");
        queryModel.setPageNo(pageNo);
        queryModel.setPageSize(pageSize);
        List<OrderExt> orderExtList = orderDao.searchReportList(queryModel);
        List<Long> orderIdList = new ArrayList<>();
        for (OrderExt orderExt : orderExtList) {
            orderIdList.add(orderExt.getOrderId());
        }
        QueryModel queryModel1 = new QueryModel();
        String orderId = StringUtils.join(orderIdList, ",");
        queryModel1.addHqlCondition(" orderId in (" + orderId + ")");
        List<OrderItems> orderItemsList = orderItemsDao.search(queryModel1);
        for (OrderExt orderExt : orderExtList) {
            List<OrderItems> itemsList=new ArrayList<>();
            for (OrderItems orderItems : orderItemsList) {
                if (orderExt.getOrderId().equals(orderItems.getOrderId())) {
                    itemsList.add(orderItems);
                }
            }
            orderExt.setOrderItemsList(itemsList);
        }
        paramObject.setTotalNum(queryModel.getTotalNum());
        return orderExtList;
    }*/

}