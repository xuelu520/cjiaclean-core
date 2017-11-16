package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.CouponDao;
import com.huazhu.hvip.common.manager.CouponManager;
import com.huazhu.hvip.common.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-14 11:45
 **/
@Service("couponManager")
public class CouponManagerImpl extends GenericManagerImpl<Coupon,Long> implements CouponManager {

    private CouponDao couponDao;

    @Autowired
    public CouponManagerImpl(CouponDao couponDao) {
        super(couponDao);
        this.couponDao = couponDao;
    }
}
