package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.CouponscodeDao;
import com.huazhu.hvip.common.manager.CouponscodeManager;
import com.huazhu.hvip.common.model.Couponscode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-14 13:14
 **/
@Service("couponscodeManager")
public class CouponscodeManagerImpl extends GenericManagerImpl<Couponscode, Long> implements CouponscodeManager {
    private CouponscodeDao couponscodeDao;

    @Autowired
    public CouponscodeManagerImpl(CouponscodeDao couponscodeDao) {
        super(couponscodeDao);
        this.couponscodeDao = couponscodeDao;
    }
}
