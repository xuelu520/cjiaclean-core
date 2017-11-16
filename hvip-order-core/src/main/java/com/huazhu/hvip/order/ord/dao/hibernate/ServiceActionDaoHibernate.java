package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.ord.dao.ServiceActionDao;
import com.huazhu.hvip.order.ord.model.ServiceAction;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-17 17:46
 **/
@Repository("serviceActionDao")
public class ServiceActionDaoHibernate extends GenericDaoHibernate<ServiceAction,Long> implements ServiceActionDao {
    public ServiceActionDaoHibernate() {
        super(ServiceAction.class);
    }
}
