package com.huazhu.hvip.operation.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.operation.dao.HotelTaxRatesDao;
import com.huazhu.hvip.operation.model.HotelTaxRates;
import org.springframework.stereotype.Repository;

/**
 * Created by cmy on 2016/6/14.
 */
@Repository("hotelTaxRatesDao")
public class HotelTaxRatesDaoHibernate extends GenericDaoHibernate<HotelTaxRates, Long> implements HotelTaxRatesDao {
    public HotelTaxRatesDaoHibernate() {
        super(HotelTaxRates.class);
    }
}
