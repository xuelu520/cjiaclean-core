package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelTaxRatesDao;
import com.huazhu.hvip.operation.manager.HotelTaxRatesManager;
import com.huazhu.hvip.operation.model.HotelTaxRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cmy on 2016/6/14.
 */
@Service("hotelOperateManager")
public class HotelTaxRatesManagerImpl extends GenericManagerImpl<HotelTaxRates, Long> implements HotelTaxRatesManager {

    private HotelTaxRatesDao hotelTaxRatesDao;

    @Autowired
    public HotelTaxRatesManagerImpl(HotelTaxRatesDao hotelTaxRatesDao) {
        super(hotelTaxRatesDao);
        this.hotelTaxRatesDao = hotelTaxRatesDao;
    }
}
