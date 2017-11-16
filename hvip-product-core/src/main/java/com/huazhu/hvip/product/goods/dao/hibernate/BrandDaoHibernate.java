/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: BrandDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-13 14:31:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.BrandDao;
import com.huazhu.hvip.product.goods.model.Brand;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("brandDao")
public class BrandDaoHibernate extends GenericDaoHibernate<Brand, Long> implements BrandDao {

    public BrandDaoHibernate() {
        super(Brand.class);
    }


    /**
     * 查询品牌列表
     * @param queryModel
     * @param para
     * @return
     */
    @Override
    public List<Brand> searchBrandList(QueryModel queryModel, ParamObject para) {

        List<Brand> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT b.* FROM vip_brand b WHERE " );
            sql.append(conditionSql);

            String sqlW = "";
            if(para!=null){
                Long typeId = para.getLongParam("typeId");
                if(typeId!=null) {
                        sqlW = " AND b.brandId IN (SELECT gtb.brandId FROM vip_goodstypebrand gtb WHERE gtb.goodsTypeId=" + typeId + ") ";
                }
            }
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
                para.setTotalNum(totalNum);
                pageFlag = true;
            }

            String queryString = sql.toString();
            SQLQuery query = session.createSQLQuery(queryString);
            query.addEntity(Brand.class);
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
