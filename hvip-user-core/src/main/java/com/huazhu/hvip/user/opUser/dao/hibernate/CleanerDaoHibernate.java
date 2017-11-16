package com.huazhu.hvip.user.opUser.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.user.opUser.dao.CleanerDao;
import com.huazhu.hvip.user.opUser.model.Cleaner;
import com.huazhu.hvip.user.opUser.model.OpUser;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cmy
 * @create 2017-08-08 16:30
 **/
@Repository("cleanerDao")
public class CleanerDaoHibernate extends GenericDaoHibernate<Cleaner,Long> implements CleanerDao {
    public CleanerDaoHibernate() {
        super(Cleaner.class);
    }

    @Override
    public Cleaner getUserByUserName(String userName) {
        List users = getSession().createCriteria(Cleaner.class).add(Restrictions.eq("name", userName)).list();
        if (users == null || users.isEmpty()) {
            return null;
        } else {
            return (Cleaner) users.get(0);
        }
    }
}
