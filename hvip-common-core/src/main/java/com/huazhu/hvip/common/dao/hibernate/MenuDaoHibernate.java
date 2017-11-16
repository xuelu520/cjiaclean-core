/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MenuDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-20 16:45:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:45:35><version><desc>
 */

package com.huazhu.hvip.common.dao.hibernate;
import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.MenuDao;
import com.huazhu.hvip.common.model.Menu;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuDao")
public class MenuDaoHibernate extends GenericDaoHibernate<Menu, Long> implements MenuDao {

    public MenuDaoHibernate() {
        super(Menu.class);
    }

}
