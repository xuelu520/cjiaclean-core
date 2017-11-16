/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SupplierDaoHibernate.java
 * Author:   chenli
 * Date:     2016-03-23 11:14:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 11:14:35> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.supplier.model.Supplier;
import com.huazhu.hvip.supplier.dao.SupplierDao;
import com.huazhu.hvip.supplier.model.extend.SupplierExt;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Repository("supplierDao")
public class SupplierDaoHibernate extends GenericDaoHibernate<Supplier, Long> implements SupplierDao {

    public SupplierDaoHibernate() {
        super(Supplier.class);
    }

    public List searchSupplierList(QueryModel queryModel) {
        return null;
    }

    /**
     * 根据queryModel查询supplier
     *
     * @param queryModel
     * @param paramObject
     * @return List<SupplierExt>
     */
    @Override
    public List<SupplierExt> searchSupplierList(QueryModel queryModel, ParamObject paramObject) {

        List<SupplierExt> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT s.*,su.userName,su.lastName,su.firstName,su.mobile,su.telNo as userTelNo,su.userId,su.email" );
/*
            sql.append(" SELECT s.*,su.userName,su.lastName,su.firstName,su.mobile" );
*/
            sql.append(" FROM supplier s ");
            sql.append(" LEFT JOIN supplieruser su ON  s.supplierId=su.supplierId");
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

            query.addEntity(SupplierExt.class);

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
