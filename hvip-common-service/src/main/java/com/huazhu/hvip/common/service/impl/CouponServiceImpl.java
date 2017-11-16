package com.huazhu.hvip.common.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.CouponManager;
import com.huazhu.hvip.common.model.Coupon;
import com.huazhu.hvip.common.qo.CouponQO;
import com.huazhu.hvip.common.service.CouponService;
import com.huazhu.hvip.common.vo.CouponVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-14 13:54
 **/
@Service("couponService")
public class CouponServiceImpl implements CouponService {
    private static Logger logger = LogManager.getLogger(CouponServiceImpl.class);

    @Autowired
    private CouponManager couponManager;

    /**
     * 查询优惠券
     *
     * @param couponQO
     * @return
     */
    @Override
    public ReturnObject<CouponVO> getCouponList(CouponQO couponQO) {
        logger.info("call getCouponList({\"couponQO:\"" + JsonUtil.JSON_Bean2String(couponQO) + "})");
        ReturnObject returnObject = new ReturnObject();
        List<CouponVO> couponVOList=new ArrayList<>();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("couponType", couponQO.getCouponType());
            queryModel.addColumnValueCondition("couponSn", couponQO.getCouponSn());
            queryModel.addColumnValueCondition("couponName", couponQO.getCouponName());
            List<Coupon> couponList = couponManager.search(queryModel);
            if (CheckUtil.checkListIsNull(couponList)) {
                for(Coupon coupon:couponList){
                    CouponVO couponVO=new CouponVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(coupon,couponVO);
                    couponVOList.add(couponVO);
                }
            }
            returnObject.setTotalSize(queryModel.getTotalNum());
            returnObject.setDataList(couponVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call getCouponList error({})", e);
        }
        return returnObject;
    }
}
