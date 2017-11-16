/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-13 14:31:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.GoodsTypeDao;
import com.huazhu.hvip.product.goods.model.GoodsType;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("goodsTypeDao")
public class GoodsTypeDaoHibernate extends GenericDaoHibernate<GoodsType, Long> implements GoodsTypeDao {

    public GoodsTypeDaoHibernate() {
        super(GoodsType.class);
    }

    /**
     * 查询商品类型列表
     * @param queryModel
     * @param para
     * @return
     */
    @Override
    public List<GoodsType> searchGoodsTypeList(QueryModel queryModel, ParamObject para) {

        List<GoodsType> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT gt.* FROM vip_goodstype gt WHERE " );

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
            query.addEntity(GoodsType.class);
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
