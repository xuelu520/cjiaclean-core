package com.huazhu.hvip.order.ord.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.order.ord.dao.OpOrderListViewDao;
import com.huazhu.hvip.order.ord.model.OpOrderListView;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-18 15:03
 **/
@Repository("opOrderListViewDao")
public class OpOrderListViewDaoHibernate extends GenericDaoHibernate<OpOrderListView, Long> implements OpOrderListViewDao {
    public OpOrderListViewDaoHibernate() {
        super(OpOrderListView.class);
    }
}
