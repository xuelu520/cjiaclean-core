/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagsDaoHibernate.java
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
import com.huazhu.hvip.product.goods.dao.TagGoodsDao;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.TagGoods;
import com.huazhu.hvip.product.goods.model.extend.TagGoodsExt;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("tagGoodsDao")
public class TagGoodsDaoHibernate extends GenericDaoHibernate<TagGoods, Long> implements TagGoodsDao {

    public TagGoodsDaoHibernate() {
        super(TagGoods.class);
    }

    /**
     * 查询标签商品设置
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<TagGoodsExt> searchTagGoodsList(QueryModel queryModel, ParamObject paramObject) {
        List<TagGoodsExt> tagGoodsExtList = new ArrayList<TagGoodsExt>();
        try {
            StringBuilder sql = new StringBuilder();
            Session session = super.getSessionFactory().getCurrentSession();
            sql.append("SELECT g.*,t.tagsName from vip_taggoods g INNER JOIN vip_tags t ON t.tagsId=g.tagsId where ");
            String conditionSql = queryModel.getQueryHqlStr();
            sql.append(conditionSql);
            boolean pageFlag = false;
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {
                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(1)  ");
                countSql.append(" FROM (" + sql + ") aa ");
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
            query.addEntity(TagGoodsExt.class);
            queryModel.assignValue(query);
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                tagGoodsExtList = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                tagGoodsExtList = query.list();
            }
            if (!pageFlag) {
                if (!tagGoodsExtList.isEmpty())
                    queryModel.setTotalNum(tagGoodsExtList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tagGoodsExtList;
    }

//    /**
//     * 根据id删除标签
//     *
//     * @param ids
//     * @return
//     */
//    @Override
//    public void deleteTagsByIds(Long[] ids) {
//        StringBuilder inSql = new StringBuilder();
//        Session session = super.getSessionFactory().getCurrentSession();
//        for (int i = 0; i < ids.length; i++) {
//            if (ids.length == 1) {
//                inSql.append(ids[i]);
//                continue;
//            }
//            if (ids.length != i + 1) {
//                inSql.append(ids[i] + ",");
//            } else {
//                inSql.append(ids[i]);
//            }
//        }
//        String sql = "delete from vip_tags where tagsId in(" + inSql.toString() + ")";
//        super.updateObject(sql);
//
//    }

    /**
     * 查询标签下的商品
     *
     * @param queryModel
     * @param paramObject
     * @param tagsId
     * @return
     */
    @Override
    public List<Goods> listGoodsJsonByTagsId(QueryModel queryModel, ParamObject paramObject, Long tagsId) {
        List<Goods> goodsList = new ArrayList<Goods>();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT g.* from vip_goods g INNER JOIN vip_taggoods t on g.goodsId=t.goodsId WHERE t.tagsId=" + tagsId + " and");
            String conditionSql = queryModel.getQueryHqlStr();
            Session session = super.getSessionFactory().getCurrentSession();
            sql.append(conditionSql);
            boolean pageFlag = false;
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {
                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(1)  ");
                countSql.append(" FROM (" + sql + ") aa ");
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
            query.addEntity(Goods.class);
            queryModel.assignValue(query);
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                goodsList = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                goodsList = query.list();
            }
            if (!pageFlag) {
                if (!goodsList.isEmpty())
                    queryModel.setTotalNum(goodsList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    /**
     * 关联商品与标签
     *
     * @param tagGoods
     * @return
     */
    @Override
    public void addTagsGoods(TagGoods tagGoods) {
        String querySql = "SELECT * from vip_taggoods t WHERE t.tagsId=" + tagGoods.getTagsId() + "";
        List<TagGoods> tagGoodsList = super.searchObject(querySql, TagGoods.class);
        for (TagGoods tagGoods1 : tagGoodsList) {
            if (tagGoods1.getGoodsId() == tagGoods.getGoodsId()) {
                throw new RuntimeException("该商品已经与标签关联");
            }
        }
        String sql = "INSERT INTO vip_taggoods (tagsId,goodsId) VALUES(" + tagGoods.getTagsId() + "," + tagGoods.getGoodsId() + ")";
        super.updateObject(sql);
    }

}
