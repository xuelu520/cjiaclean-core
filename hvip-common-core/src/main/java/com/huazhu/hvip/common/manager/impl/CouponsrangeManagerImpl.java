package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.CouponsrangeDao;
import com.huazhu.hvip.common.manager.CouponsrangeManager;
import com.huazhu.hvip.common.model.Couponsrange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-14 13:18
 **/
@Service("couponsrangeManager")
public class CouponsrangeManagerImpl extends GenericManagerImpl<Couponsrange, Long> implements CouponsrangeManager {
    private CouponsrangeDao couponsrangeDao;

    @Autowired
    public CouponsrangeManagerImpl(CouponsrangeDao couponsrangeDao) {
        super(couponsrangeDao);
        this.couponsrangeDao = couponsrangeDao;
    }
}
