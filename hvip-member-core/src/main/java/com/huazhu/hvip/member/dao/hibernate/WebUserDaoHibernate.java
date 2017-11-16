/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-20 14:10:34
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:10:34> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.member.dao.WebUserDao;
import com.huazhu.hvip.member.model.WebUser;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("webUserDao")
public class WebUserDaoHibernate extends GenericDaoHibernate<WebUser,Long> implements WebUserDao{

    /**
     * Constructor that sets the entity to User.class.
     */
    public WebUserDaoHibernate() {
        super(WebUser.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<WebUser> getUsers() {
        Query qry = getSession().createQuery("from WebUser u order by upper(u.username)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public WebUser saveUser(WebUser user) {
        if (log.isDebugEnabled()) {
            log.debug("user's id: " + user.getWebUserId());
        }
        getSession().saveOrUpdate(user);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return user;
    }

    /**
     * Overridden simply to call the saveUser method. This is happening
     * because saveUser flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param user the user to save
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public WebUser save(WebUser user) {
        return this.saveUser(user);
    }

    /**
     * {@inheritDoc}
    */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List users = getSession().createCriteria(WebUser.class).add(Restrictions.eq("username", username))
        		  .add(Restrictions.eq("status", 0))
        		.list();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (UserDetails) users.get(0);
        }
    }

    /**
     * {@inheritDoc}
    */
    public String getUserPassword(Long userId) {
        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(WebUser.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select securityCode from " + table.name() + " where webuserId=?", String.class, userId);
    }


	public WebUser getUserByUsername(String username) {
		  List users = getSession().createCriteria(WebUser.class).add(Restrictions.eq("username", username))
				  .list();
	        if (users == null || users.isEmpty()) {
	            return null;
	        } else {
	            return (WebUser) users.get(0);
	        }
	}

}
