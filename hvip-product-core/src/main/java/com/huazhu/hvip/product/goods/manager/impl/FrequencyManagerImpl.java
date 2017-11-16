package com.huazhu.hvip.product.goods.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.CateOrderRuleDao;
import com.huazhu.hvip.product.goods.dao.FrequencyDao;
import com.huazhu.hvip.product.goods.manager.FrequencyManager;
import com.huazhu.hvip.product.goods.model.Frequency;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-08-09.
 */
@Service("frequencyManager")
public class FrequencyManagerImpl extends GenericManagerImpl<Frequency, Long> implements FrequencyManager {
    private static Logger logger = LogManager.getLogger(FrequencyManagerImpl.class);

    FrequencyDao frequencyDao;

    @Autowired
    public FrequencyManagerImpl(FrequencyDao frequencyDao) {
        super(frequencyDao);
        this.frequencyDao = frequencyDao;
    }


}
