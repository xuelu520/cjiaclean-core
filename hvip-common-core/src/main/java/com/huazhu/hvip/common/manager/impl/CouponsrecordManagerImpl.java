package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.CouponsrecordDao;
import com.huazhu.hvip.common.manager.CouponsrecordManager;
import com.huazhu.hvip.common.model.Couponsrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-14 13:22
 **/
@Service("couponsrecordManager")
public class CouponsrecordManagerImpl extends GenericManagerImpl<Couponsrecord,Long> implements CouponsrecordManager {

    private CouponsrecordDao couponsrecordDao;

    @Autowired
    public CouponsrecordManagerImpl(CouponsrecordDao couponsrecordDao) {
        super(couponsrecordDao);
        this.couponsrecordDao = couponsrecordDao;
    }
}
