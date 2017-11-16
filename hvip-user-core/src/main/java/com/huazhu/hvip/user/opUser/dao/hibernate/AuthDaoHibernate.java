/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AuthDaoHibernate.java
 * Author:   lijing
 * Date:     2016-04-18 18:11:03
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-18 18:11:03> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.user.opUser.dao.AuthDao;
import com.huazhu.hvip.user.opUser.model.Auth;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("authDao")
public class AuthDaoHibernate extends GenericDaoHibernate<Auth,Long> implements AuthDao{
    public AuthDaoHibernate() {
        super(Auth.class);
    }

    /**
     * 获取OP用户权限
     * @param queryModel
     * @param para
     * @return
     */
    @Override
    public List<Auth> searchAuth(QueryModel queryModel, ParamObject para) {

        List<Auth> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT a.* " );
            sql.append(" FROM auth a ");
            sql.append(" WHERE ");
            StringBuffer sqlW = new StringBuffer("");
            if(para != null){
                Long userId = para.getLongParam("userId");
                if(userId!=null){
                    sqlW.append(" a.authId IN ");
                    sqlW.append(" (SELECT ra.authId FROM roleauth ra WHERE ra.roleId IN ");
                    sqlW.append(" (SELECT our.roleId FROM opuserrole our WHERE our.userId=" + userId + ")) AND ");
                }
            }
            sql.append(sqlW);
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
                para.setTotalNum(totalNum);
                pageFlag = true;
            }

            String queryString = sql.toString();
            SQLQuery query = session.createSQLQuery(queryString);
            query.addEntity(Auth.class);
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
