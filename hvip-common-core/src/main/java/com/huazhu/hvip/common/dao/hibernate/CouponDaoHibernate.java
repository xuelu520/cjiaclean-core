package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.CouponDao;
import com.huazhu.hvip.common.model.Coupon;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-14 11:47
 **/
@Repository("couponDao")
public class CouponDaoHibernate extends GenericDaoHibernate<Coupon,Long> implements CouponDao {

    public CouponDaoHibernate() {
        super(Coupon.class);
    }
}
