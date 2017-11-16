package com.huazhu.hvip.company.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.company.dao.CompanyDao;
import com.huazhu.hvip.company.model.Company;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-10-11 16:52
 **/
@Repository("companyDao")
public class CompanyDaoHibernate extends GenericDaoHibernate<Company,Long> implements CompanyDao {
    public CompanyDaoHibernate() {
        super(Company.class);
    }
}
