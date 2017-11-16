package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.CouponsrecordDao;
import com.huazhu.hvip.common.model.Couponsrecord;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-14 13:23
 **/
@Repository("couponsrecordDao")
public class CouponsrecordDaoHibernate extends GenericDaoHibernate<Couponsrecord,Long> implements CouponsrecordDao {
    public CouponsrecordDaoHibernate() {
        super(Couponsrecord.class);
    }
}
