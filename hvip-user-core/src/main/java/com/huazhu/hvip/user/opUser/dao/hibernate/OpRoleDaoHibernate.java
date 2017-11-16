/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleDaoHibernate.java
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
import com.huazhu.hvip.user.opUser.dao.OpRoleDao;
import com.huazhu.hvip.user.opUser.model.OpRole;
import com.huazhu.hvip.user.opUser.model.RoleAuth;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Role objects.
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @author jgarcia (updated to hibernate 4)
 */
@Repository("OpRoleDao")
public class OpRoleDaoHibernate extends GenericDaoHibernate<OpRole, Long> implements OpRoleDao {

    /**
     * Constructor to create a Generics-based version using Role as the entity
     */
    public OpRoleDaoHibernate() {
        super(OpRole.class);
    }

    /**
     * {@inheritDoc}
     */
    public OpRole getRoleByName(String rolename) {
        List roles = getSession().createCriteria(OpRole.class).add(Restrictions.eq("roleName", rolename)).list();
        if (roles.isEmpty()) {
            return null;
        } else {
            return (OpRole) roles.get(0);
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

    /**
     * {@inheritDoc}
     */
	public Set<String> getAuthedMenu(String roleId) {


		Session session = super.getSessionFactory().getCurrentSession();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT DISTINCT menuId FROM oprolemenu WHERE roleid = :roleId ");
        SQLQuery query = session.createSQLQuery(sql.toString());
        query.setParameter("roleId", roleId);
        //query.addEntity(String.class);
       // query.addScalar("menuId",Hibernate.);

        Set set = new HashSet();
        set.addAll(query.list());
        return set;

	}

    @Override
    public Set<Long> getAuthedMenu(Long roleId) {
        Session session = super.getSessionFactory().getCurrentSession();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT DISTINCT authId FROM roleauth WHERE roleId = :roleId ");
        SQLQuery query = session.createSQLQuery(sql.toString());
        query.setParameter("roleId", roleId);
        //query.addEntity(Long.class);
        // query.addScalar("menuId",Hibernate.);

        Set set = new HashSet();
        set.addAll(query.list());
        return set;
    }

    @Override
    public void deleteRoleAuthByRoleId(Long roleId) {
        Session session = getSession();
        List<RoleAuth> roleAuthList = session.createCriteria(RoleAuth.class).add(Restrictions.eq("composeIdPK.roleId", roleId)).list();
        if(roleAuthList!=null&&roleAuthList.size()!=0){
            for(RoleAuth roleAuth:roleAuthList){
                session.delete(roleAuth);
            }
        }
    }

    /**
     * 查询用户列表
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    @Override
    public List<OpRole> searchRoleList(QueryModel queryModel, ParamObject paramObject) {
        List<OpRole> list = new ArrayList();


        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT *" );
/*
            sql.append(" SELECT s.*,su.userName,su.lastName,su.firstName,su.mobile" );
*/
            sql.append(" FROM oprole ");
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
                paramObject.setTotalNum(totalNum);
                pageFlag = true;
            }

            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(OpRole.class);

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
     * 查询用户列表部分字段
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    @Override
    public List<OpRole> searchRoleListPartialField(QueryModel queryModel, ParamObject paramObject) {
        List<OpRole> list = new ArrayList();

        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT roleId,roleName" );
/*
            sql.append(" SELECT s.*,su.userName,su.lastName,su.firstName,su.mobile" );
*/
            sql.append(" FROM oprole ");
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
                paramObject.setTotalNum(totalNum);
                pageFlag = true;
            }

            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(OpRole.class);

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


}
