/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: LookupDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-10 14:04:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:04:22><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.dao.hibernate;

import java.util.List;

import com.huazhu.hvip.user.opUser.dao.LookupDao;
import com.huazhu.hvip.user.opUser.model.OpRole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Hibernate implementation of LookupDao.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *      Modified by jgarcia: updated to hibernate 4
 */
@Repository
public class LookupDaoHibernate implements LookupDao {
    private Log log = LogFactory.getLog(LookupDaoHibernate.class);
    private final SessionFactory sessionFactory;

    /**
     * Initialize LookupDaoHibernate with Hibernate SessionFactory.
     * @param sessionFactory
     */
    @Autowired
    public LookupDaoHibernate(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<OpRole> getRoles() {
        log.debug("Retrieving all role names...");
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(OpRole.class).list();
    }
}
