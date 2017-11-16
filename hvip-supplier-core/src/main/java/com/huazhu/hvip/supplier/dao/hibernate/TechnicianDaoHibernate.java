/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TechnicianDaoHibernate.java
 * Author:   lijing
 * Date:     2016-05-04 09:57:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-04 09:57:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.supplier.dao.TechnicianDao;
import com.huazhu.hvip.supplier.model.Technician;
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
@Repository("technicianDao")
public class TechnicianDaoHibernate extends GenericDaoHibernate<Technician,Long> implements TechnicianDao{
    public TechnicianDaoHibernate() {
        super(Technician.class);
    }

    /**
     * 查询技师列表
     * @param queryModel
     * @param param
     * @return
     */
    @Override
    public List<Technician> searchTechnicianList(QueryModel queryModel, ParamObject param) {

        List<Technician> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT t.* " );

            String sqlW = "";

            if(param != null){

                Long goodsId = param.getLongParam("goodsId");
                if(goodsId!=null){
                    sqlW = "";
                }
            }


            sql.append(" FROM technician t ");
            sql.append(" WHERE");
            sql.append(conditionSql);
            sql.append(sqlW);

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
                param.setTotalNum(totalNum);
                pageFlag = true;
            }

            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(Technician.class);

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
