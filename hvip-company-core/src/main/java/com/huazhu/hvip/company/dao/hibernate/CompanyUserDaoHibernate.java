package com.huazhu.hvip.company.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.company.dao.CompanyUserDao;
import com.huazhu.hvip.company.model.CompanyUser;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-10-12 13:35
 **/
@Repository("companyUserDao")
public class CompanyUserDaoHibernate extends GenericDaoHibernate<CompanyUser,Long> implements CompanyUserDao {
    public CompanyUserDaoHibernate() {
        super(CompanyUser.class);
    }
}
