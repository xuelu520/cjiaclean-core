package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.CouponscodeDao;
import com.huazhu.hvip.common.model.Couponscode;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-14 13:15
 **/
@Repository("couponscodeDao")
public class CouponscodeDaoHibernate extends GenericDaoHibernate<Couponscode,Long> implements CouponscodeDao {
    public CouponscodeDaoHibernate() {
        super(Couponscode.class);
    }
}
