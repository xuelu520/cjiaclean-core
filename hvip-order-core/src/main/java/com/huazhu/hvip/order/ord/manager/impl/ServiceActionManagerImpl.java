package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.ServiceActionDao;
import com.huazhu.hvip.order.ord.manager.ServiceActionManager;
import com.huazhu.hvip.order.ord.model.ServiceAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-17 17:45
 **/
@Service
public class ServiceActionManagerImpl extends GenericManagerImpl<ServiceAction,Long> implements ServiceActionManager {

    private ServiceActionDao serviceActionDao;

    @Autowired
    public ServiceActionManagerImpl(ServiceActionDao serviceActionDao) {
        super(serviceActionDao);
        this.serviceActionDao = serviceActionDao;
    }
}
