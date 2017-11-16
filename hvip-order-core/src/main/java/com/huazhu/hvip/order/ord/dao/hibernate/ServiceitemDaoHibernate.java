package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.ord.dao.ServiceitemDao;
import com.huazhu.hvip.order.ord.model.Serviceitem;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-15 11:12
 **/
@Repository("serviceitemDao")
public class ServiceitemDaoHibernate extends GenericDaoHibernate<Serviceitem,Long>  implements ServiceitemDao {
    public ServiceitemDaoHibernate() {
        super(Serviceitem.class);
    }
}
