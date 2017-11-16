package com.huazhu.hvip.order.ord.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.order.ord.dao.OpOrderListViewDao;
import com.huazhu.hvip.order.ord.manager.OpOrderListViewManager;
import com.huazhu.hvip.order.ord.model.OpOrderListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cmy
 * @create 2017-08-18 15:01
 **/
@Service("opOrderListViewManager")
public class OpOrderListViewManagerImpl extends GenericManagerImpl<OpOrderListView,Long> implements OpOrderListViewManager {
    private OpOrderListViewDao opOrderListViewDao;

    @Autowired
    public OpOrderListViewManagerImpl(OpOrderListViewDao opOrderListViewDao) {
        super(opOrderListViewDao);
        this.opOrderListViewDao = opOrderListViewDao;
    }
}
