package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.ServiceitemDao;
import com.huazhu.hvip.order.ord.manager.ServiceitemManager;
import com.huazhu.hvip.order.ord.model.Serviceitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-15 11:10
 **/
@Service("serviceitemManager")
public class ServiceitemManagerImpl extends GenericManagerImpl<Serviceitem, Long> implements ServiceitemManager {
    private ServiceitemDao serviceitemDao;

    @Autowired
    public ServiceitemManagerImpl(ServiceitemDao serviceitemDao) {
        super(serviceitemDao);
        this.serviceitemDao = serviceitemDao;
    }
}
