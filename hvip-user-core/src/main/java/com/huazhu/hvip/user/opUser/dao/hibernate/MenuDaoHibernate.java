
package com.huazhu.hvip.user.opUser.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.user.opUser.dao.MenuDao;
import com.huazhu.hvip.user.opUser.model.Menu;
import org.springframework.stereotype.Repository;

@Repository("menuDao")
public class MenuDaoHibernate extends GenericDaoHibernate<Menu, Long> implements MenuDao {

    public MenuDaoHibernate() {
        super(Menu.class);
    }

}
