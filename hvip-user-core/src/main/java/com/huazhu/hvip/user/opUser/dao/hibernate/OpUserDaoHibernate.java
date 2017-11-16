/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-10 14:04:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:04:22><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.user.opUser.dao.OpUserDao;
import com.huazhu.hvip.user.opUser.model.OpUser;
import com.huazhu.hvip.user.opUser.model.extend.OpUserExt;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve User objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *   Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 *   Extended to implement Acegi UserDetailsService interface by David Carter david@carter.net
 *   Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a> to work with
 *   the new BaseDaoHibernate implementation that uses generics.
 *   Modified by jgarcia (updated to hibernate 4)
*/
@Repository("opUserDao")
public class OpUserDaoHibernate extends GenericDaoHibernate<OpUser, Long> implements OpUserDao{

    /**
     * Constructor that sets the entity to User.class.
     */
    public OpUserDaoHibernate() {
        super(OpUser.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<OpUser> getUsers() {
        Query qry = getSession().createQuery("from User u order by upper(u.username)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public OpUser saveUser(OpUser user) {
        if (log.isDebugEnabled()) {
            log.debug("user's id: " + user.getUserId());
        }
        getSession().saveOrUpdate(user);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
//        getSession().flush();
        return user;
    }

    @Override
    public OpUser loadUserByUsername(String username) throws UsernameNotFoundException {
        List users = getSession().createCriteria(OpUser.class).add(Restrictions.eq("userName", username)).list();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (OpUser) users.get(0);
        }
    }

    /**
     * {@inheritDoc}
    */
    public String getUserPassword(Long userId) {
        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(OpUser.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select securityCode from " + table.name() + " where userId=?", String.class, userId);
    }

    @Override
    public List<OpUserExt> searchUserList(QueryModel queryModel, ParamObject paramObject) {
        return null;
    }

    @Override
	public OpUser getUserByUserName(String userName) {
		    List users = getSession().createCriteria(OpUser.class).add(Restrictions.eq("userName", userName)).list();
	        if (users == null || users.isEmpty()) {
	           return null;
	        } else {
	            return (OpUser) users.get(0);
	        }
	}

    /**
     * 查询用户列表
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<OpUserExt> searchUserList(QueryModel queryModel) {

        List<OpUserExt> list = new ArrayList();

        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT opu.*,c.name,c.employeeNo " );
/*
            sql.append(" SELECT s.*,su.userName,su.lastName,su.firstName,su.mobile" );
*/
            sql.append(" FROM opuser opu ");
            sql.append(" LEFT JOIN cleaner c ON opu.cleanId=c.cleanId");
            sql.append(" WHERE ");
            sql.append(conditionSql);

            boolean pageFlag = false;

            // 如果在分页模式下，则计算总数
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {

                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(*)  ");
                countSql.append(" FROM (" + sql + ") aa ");
                //countSql.append(conditionSql);
                SQLQuery countQuery = session.createSQLQuery(countSql.toString());
                queryModel.assignValue(countQuery);
                List countList = countQuery.list();
                int totalNum = 0;
                if (!countList.isEmpty()) {
                    String str = new String(countList.get(0).toString());
                    totalNum = (Long.valueOf(str)).intValue();
                }
                queryModel.setTotalNum(totalNum);
                pageFlag = true;
            }

            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(OpUserExt.class);

            queryModel.assignValue(query);

            // 分页模式下只列当前页
            if (queryModel.getPageSize() !=null && queryModel.getPageSize() > 0) {
                list = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                list = query.list();

            }

            if (!pageFlag) {

                if (!list.isEmpty())
                    queryModel.setTotalNum(list.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 根据用户名查询密码
     *
     * @param userName
     * @return
     */
    @Override
    public OpUser getPasswordByUserName(String userName) {

        OpUser opUser = null;
        Session session = super.getSessionFactory().getCurrentSession();
        String sql = "select * from opuser where username ='"+userName+"'";

        List<OpUser> list = (List) super.searchObject(sql,OpUser.class);
        if(list!=null&&list.size()>0){
            opUser = list.get(0);
        }
        return opUser;
    }

    @Override
    public Set<Long> getOpUserRoleByUserId(Long userId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT DISTINCT roleId FROM opuserrole WHERE userId = :userId ");
        SQLQuery query = getSession().createSQLQuery(sql.toString());
        query.setParameter("userId", userId);
        Set set = new HashSet();
        set.addAll(query.list());
        return set;

    }
}
