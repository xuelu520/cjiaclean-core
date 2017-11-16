package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.CouponsrangeDao;
import com.huazhu.hvip.common.model.Couponsrange;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-14 13:20
 **/
@Repository("couponsrangeDao")
public class CouponsrangeDaoHibernate extends GenericDaoHibernate<Couponsrange,Long> implements CouponsrangeDao {
    public CouponsrangeDaoHibernate() {
        super(Couponsrange.class);
    }
}
