package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.*;
import com.huazhu.hvip.order.ord.manager.ServiceManager;
import com.huazhu.hvip.order.ord.model.*;
import com.huazhu.hvip.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-15 11:04
 **/
@org.springframework.stereotype.Service("serviceManager")
public class ServiceManagerImpl extends GenericManagerImpl<Service, Long> implements ServiceManager {

    private ServiceDao serviceDao;

    @Autowired
    private ServiceActionDao serviceActionDao;

    @Autowired
    private ServiceitemDao serviceitemDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderActionDao orderActionDao;
    @Autowired
    private OrderItemsDao orderItemsDao;

    @Autowired
    public ServiceManagerImpl(ServiceDao serviceDao) {
        super(serviceDao);
        this.serviceDao = serviceDao;
    }

    /**
     * 事务更改工单信息
     *
     * @param paramObject
     * @return
     */
    @Transactional
    @Override
    public Service updateOrderService(ParamObject paramObject) {
        Service service = (Service) paramObject.getParam("service");
        List<Serviceitem> serviceitemList = (List<Serviceitem>) paramObject.getParam("serviceitemList");
        service = serviceDao.save(service);
        for (Serviceitem serviceitem : serviceitemList) {
            serviceitemDao.save(serviceitem);
        }
        ServiceAction serviceAction = setServiceAction(service);
        serviceActionDao.save(serviceAction);
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("orderId", service.getOrderId());
        List<com.huazhu.hvip.order.ord.model.Service> list = serviceDao.search(queryModel);
        Order order = orderDao.get(service.getOrderId());
        int finishCount = 0;
        int waitServiceCount = 0;
        for (com.huazhu.hvip.order.ord.model.Service services : list) {
            if (Constants.SERVICE_STATUS_DON.equals(services.getStatus())) {
                finishCount++;
            } else if (Constants.SERVICE_STATUS_PAY.equals(services.getStatus())
                    || Constants.SERVICE_STATUS_WAITSERVICE.equals(services.getStatus())
                    || Constants.SERVICE_STATUS_SERVICING.equals(services.getStatus())) {
                waitServiceCount++;
            }
        }
        order.setFinishService(finishCount);
        order.setWaitServiceCount(waitServiceCount);
        orderDao.save(order);
        return service;
    }

    /**
     * 保洁员开始服务
     *
     * @param p
     * @return
     */
    @Transactional
    @Override
    public Service updateBeginService(ParamObject p) {
        Service service = (Service) p.getParam("service");
        Order order = (Order) p.getParam("order");
        OrderAction orderAction = (OrderAction) p.getParam("orderAction");
        List<OrderItems> orderItemsList = (List<OrderItems>) p.getParam("orderItemsList");
        serviceDao.save(service);
        ServiceAction serviceAction = setServiceAction(service);
        serviceActionDao.save(serviceAction);
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("serviceId", service.getServiceId());
        List<Serviceitem> serviceitemList = serviceitemDao.search(queryModel);
        if (CheckUtil.checkListIsNull(serviceitemList)) {
            for (Serviceitem serviceitem : serviceitemList) {
                serviceitem.setStatus(service.getStatus());
                serviceitem.setUpdateTime(service.getUpdateTime());
                serviceitem.setUpdateUser(service.getUpdateUser());
                serviceitemDao.save(serviceitem);
            }
        }
        orderDao.save(order);
        orderActionDao.save(orderAction);
        if (CheckUtil.checkListIsNull(orderItemsList)) {
            for (OrderItems orderItems : orderItemsList) {
                orderItemsDao.save(orderItems);
            }
        }
        return service;
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
            serviceAction.setAction("工单id:" + service.getServiceId() + "动作:取消工单,操作人:" + service.getUpdateUser() + "会员id" + service.getMemberId());
        }
        return serviceAction;
    }
}
