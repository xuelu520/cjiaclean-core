package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.ord.dao.ServiceDao;
import com.huazhu.hvip.order.ord.model.Service;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-15 11:05
 **/
@Repository("serviceManagerDao")
public class ServiceDaoHibernate extends GenericDaoHibernate<Service,Long> implements ServiceDao {
    public ServiceDaoHibernate() {
        super(Service.class);
    }
}
