package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.WxMenuDao;
import com.huazhu.hvip.common.model.WxMenu;
import org.springframework.stereotype.Repository;

/**
 * @author cmy
 * @create 2017-08-03 10:36
 **/

@Repository("wxMenuDao")
public class WxMenuDaoHibernate extends GenericDaoHibernate<WxMenu,Long> implements WxMenuDao {
    public WxMenuDaoHibernate() {
        super(WxMenu.class);
    }
}
