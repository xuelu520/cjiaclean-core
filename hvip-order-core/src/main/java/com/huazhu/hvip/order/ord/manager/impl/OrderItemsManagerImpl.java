package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OrderActionDao;
import com.huazhu.hvip.order.ord.dao.OrderDao;
import com.huazhu.hvip.order.ord.dao.OrderItemsDao;
import com.huazhu.hvip.order.ord.manager.OrderItemsManager;
import com.huazhu.hvip.order.ord.manager.OrderManager;
import com.huazhu.hvip.order.ord.model.OrderItems;
import com.huazhu.hvip.order.ord.model.extend.OrderItemsExt;
import com.huazhu.hvip.order.payment.dao.PaymentDao;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XUEYONGPING001 on 2016/4/7.
 */
@Service("orderItemsManager")
public class OrderItemsManagerImpl extends GenericManagerImpl<OrderItems, Long> implements OrderItemsManager {

    private static Logger logger = LogManager.getLogger(OrderItemsManagerImpl.class);

    private OrderItemsDao orderItemsDao;

    @Autowired
    public OrderItemsManagerImpl(OrderItemsDao orderItemsDao) {
        super(orderItemsDao);
        this.orderItemsDao = orderItemsDao;
    }

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderActionDao orderActionDao;

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private OrderManager orderManager;

    /**
     * 查找订单货物列表
     */
    public List<OrderItems> searchOrderItemsList(ParamObject paramObject) {
        List<OrderItems> orderItemsList = orderItemsDao.searchOrderItemsList(paramObject);
        return orderItemsList;
    }

    /**
     * 查找订单货物以及订单信息列表
     */
    public List<OrderItemsExt> searchOrderItemsExtList(ParamObject paramObject) {
        List<OrderItemsExt> orderItemsExtList = orderItemsDao.searchOrderItemsExtList(paramObject);
        return orderItemsExtList;
    }


    /**
     * 积分报表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Map<String, Object>> searchPointListJson(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        String beginTime = paramObject.getStringParam("beginTime");
        String endTime = paramObject.getStringParam("endTime");
        String keyword=paramObject.getStringParam("keyword");
        if(StringUtils.isNotEmpty(beginTime)&&StringUtils.isNotEmpty(endTime)){
            queryModel.addHqlCondition(" pc.bizDate >= '" + beginTime + "'");
            queryModel.addHqlCondition(" pc.bizDate <= '" + endTime + "'");
        }
        if(StringUtils.isNotEmpty(keyword)){
            queryModel.addHqlCondition(" pc.hotelName like '%"+keyword+"%' or pc.hotelId like '"+keyword+"'");
        }
        Integer pageNo=paramObject.getIntegerParam("pageNo");
        Integer pageSize=paramObject.getIntegerParam("pageSize");
        if(pageNo!=null && pageSize!=null){
            queryModel.setPageNo(pageNo);
            queryModel.setPageSize(pageSize);
        }
        queryModel.addColumnValueCondition("pc.payMethod",paramObject.getStringParam("payMethod"));
        List<Map<String, Object>> stringObjectMap=orderItemsDao.searchPointListJson(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());
        return stringObjectMap;
    }

}
