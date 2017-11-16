/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ProductDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-13 14:31:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.GoodsStoreDao;
import com.huazhu.hvip.product.goods.dao.ProductDao;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.GoodsStore;
import com.huazhu.hvip.product.goods.model.Product;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("goodsStoreDao")
public class GoodsStoreHibernate extends GenericDaoHibernate<GoodsStore, Long> implements GoodsStoreDao {

    public GoodsStoreHibernate() {
        super(GoodsStore.class);
    }

    /**
     * 根据查询条件查询商品库存列表
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<GoodsStore> searchGoodsStore(QueryModel queryModel) {

        List<GoodsStore> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT gs.* from vip_goodsStore gs LEFT JOIN vip_depot d ON gs.depotId = d.depotId WHERE " );
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

            query.addEntity(GoodsStore.class);

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
