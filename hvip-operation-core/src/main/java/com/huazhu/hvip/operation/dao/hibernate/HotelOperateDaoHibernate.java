package com.huazhu.hvip.operation.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.operation.dao.HotelOperateDao;
import com.huazhu.hvip.operation.model.HotelControlPrice;
import org.springframework.stereotype.Repository;

/**
 * Created by cmy on 2016/6/14.
 */
@Repository("hotelOperateDao")
public class HotelOperateDaoHibernate extends GenericDaoHibernate<HotelControlPrice, Long> implements HotelOperateDao{
    public HotelOperateDaoHibernate() {
        super(HotelControlPrice.class);
    }
}
