package com.huazhu.hvip.product.goods.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.product.goods.dao.FrequencyDao;
import com.huazhu.hvip.product.goods.model.Frequency;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-08-09.
 */
@Repository("frequencyDao")
public class FrequencyDaoHibernate extends GenericDaoHibernate<Frequency, Long> implements FrequencyDao {
    public FrequencyDaoHibernate() {
        super(Frequency.class);
    }
}
