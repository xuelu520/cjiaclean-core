/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsDaoHibernate.java
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
import com.huazhu.hvip.product.goods.dao.GoodsDao;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("goodsDao")
public class GoodsDaoHibernate extends GenericDaoHibernate<Goods, Long> implements GoodsDao {

    public GoodsDaoHibernate() {
        super(Goods.class);
    }

    public List searchCompanys(QueryModel queryModel) {
        return null;
    }


    /**
     * 根据queryModel查询goods
     *
     * @param queryModel
     * @param paramObject
     * @return List<Goods>
     */
    @Override
    public List<GoodsExt> searchGoodsList(QueryModel queryModel, ParamObject paramObject) {

        List<GoodsExt> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT g.*,gt.isPhysical,gt.typeName,c.cateSn,c.cateName,");

            String sqlW = "";

            if (paramObject != null) {

                String channelCode = paramObject.getStringParam("channelCode");
                if (StringUtils.isNotBlank(channelCode)) {
                    sqlW = "c.channelCode = '" + channelCode + "' AND (cr.channelObjectId IS NULL OR cr.channelObjectId='') AND ";
                }
            }

            String sqlS = "(" +
                    "SELECT cgp.sellPrice FROM vip_channelgoodsprice cgp  " +
                    "LEFT JOIN vip_channelrate cr ON cr.rateId = cgp.rateId " +
                    "LEFT JOIN vip_channel c ON c.channelId=cr.channelId " +
                    "WHERE " + sqlW + " cgp.goodsId = g.goodsId LIMIT 1"
                    + ") price, ";

            sqlS += "(" +
                    "SELECT cgp.priceId FROM vip_channelgoodsprice cgp " +
                    "LEFT JOIN vip_channelrate cr ON cr.rateId = cgp.rateId " +
                    "LEFT JOIN vip_channel c ON c.channelId=cr.channelId " +
                    "WHERE " + sqlW + " cgp.goodsId = g.goodsId LIMIT 1"
                    + ") channelPriceId ";

            sql.append(sqlS);
            sql.append(" FROM vip_goods g ");
            sql.append(" LEFT JOIN vip_category c ON  g.cateId=c.cateId");
            sql.append(" LEFT JOIN vip_goodstype gt ON c.typeId = gt.typeId");
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

            String sortHql = queryModel.getSortHql();

            if(StringUtils.isNotBlank(sortHql)){
                sql.append(" ORDER BY "+sortHql);
            }


            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(GoodsExt.class);

            queryModel.assignValue(query);

            // 分页模式下只列当前页
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
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

   /* *//**
     * 根据id删除商品
     *
     * @param ids
     * @return count
     *//*
    @Override
    public int deleteGoods(Long[] ids) {
        StringBuffer inSql = new StringBuffer("");
        for (int i = 0; i < ids.length; i++) {
            if (i != 0) {
                inSql.append(",");
            }
            inSql.append(ids[i]);
        }
        String sql = "update vip_goods set deleteFlag=1 where goodsId in(" + inSql + ")";

        return super.updateObject(sql);
    }
*/
//    /**
//     * 上下架
//     *
//     * @param goodsId
//     * @param enable
//     * @return
//     */
//    @Override
//    public int setMarketEnable(Long goodsId, String enable) {
//        String sql = " update vip_goods set marketEnable='" + enable + "' where goodsId=" + goodsId;
//        return super.updateObject(sql);
//    }

    /**
     * 根据cateId判断商品是否存在
     *
     * @param cateId
     * @return
     */
    @Override
    public Integer getGoodsIsExistByCategoryId(Long cateId) {
        String sql = "select count(0) from vip_goods where cateId=" + cateId;
        Object recount=super.searchObject(sql);
        return Integer.valueOf(recount.toString());
    }


}
