package com.huazhu.hvip.company.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.company.dao.CompanyDao;
import com.huazhu.hvip.company.manager.CompanyManager;
import com.huazhu.hvip.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-10-11 16:49
 **/
@Service("companyManager")
public class CompanyManagerImpl extends GenericManagerImpl<Company,Long> implements CompanyManager {

    private CompanyDao companyDao;

    @Autowired
    public CompanyManagerImpl(CompanyDao companyDao) {
        super(companyDao);
        this.companyDao = companyDao;
    }
}
