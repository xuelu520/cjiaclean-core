package com.huazhu.hvip.common.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.qo.CouponQO;
import com.huazhu.hvip.common.vo.CouponVO;

/**
 * @author cmy
 * @create 2017-08-14 13:53
 **/
public interface CouponService {

    /**
     * 查询优惠券
     * @param couponQO
     * @return
     */
    ReturnObject<CouponVO> getCouponList(CouponQO couponQO);
}
