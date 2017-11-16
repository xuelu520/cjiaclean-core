/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebRoleDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-20 14:09:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:09:07> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.member.dao.WebRoleDao;
import com.huazhu.hvip.member.model.WebRole;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("webRoleDao")
public class WebRoleDaoHibernate extends GenericDaoHibernate<WebRole,Long> implements WebRoleDao{

    public WebRoleDaoHibernate() {
        super(WebRole.class);
    }

    /**
     * {@inheritDoc}
     */
    public WebRole getRoleByName(String rolename) {
        List roles = getSession().createCriteria(WebRole.class).add(Restrictions.eq("roleName", rolename)).list();
        if (roles.isEmpty()) {
            return null;
        } else {
            return (WebRole) roles.get(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
        Object role = getRoleByName(rolename);
        Session session = getSessionFactory().getCurrentSession();
        session.delete(role);
    }

}
