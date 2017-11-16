/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AreaDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import java.util.List;

import com.huazhu.hvip.common.dao.AreaDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.model.Area;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;

@Repository("areaDao")
public class AreaDaoHibernate extends GenericDaoHibernate<Area, Long> implements AreaDao {

    public AreaDaoHibernate() {
        super(Area.class);
    }

    private AreaDao areaDao;

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public List getAreaList(QueryModel queryModel) {
        try {
            Session session = super.getSessionFactory().getCurrentSession();

            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT areaId,areaName ");
            sql.append("FROM area WHERE ");
            sql.append(conditionSql);
            sql.append(" and status = '0' ");
            String queryString = sql.toString();
            SQLQuery query = session.createSQLQuery(queryString);
            queryModel.assignValue(query);
            List list = null;

            list = query.list();

            return list;
        } catch (RuntimeException re) {
            re.printStackTrace();
            log.error("find by getAreaList failed", re);
            throw re;
        }
    }

    /**
     * 添加酒店區域的方法
     */
    @Override
    public Area createArea(Area area) {
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("AreaName", area.getAreaName());
        queryModel.addColumnValueCondition("status", 1);
        return areaDao.save(area);
    }
}
