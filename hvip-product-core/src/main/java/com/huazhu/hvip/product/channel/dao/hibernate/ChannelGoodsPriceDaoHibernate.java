/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelGoodsPriceDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-14 15:22:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:22:52> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.channel.dao.ChannelGoodsPriceDao;
import com.huazhu.hvip.product.channel.model.ChannelGoodsPrice;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.goods.model.Frequency;
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
@Repository("channelGoodsPriceDao")
public class ChannelGoodsPriceDaoHibernate extends GenericDaoHibernate<ChannelGoodsPrice, Long> implements ChannelGoodsPriceDao {

    public ChannelGoodsPriceDaoHibernate(){
        super(ChannelGoodsPrice.class);
    }

    /**
     * 查询商品价格信息
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<ChannelGoodsPrice> searchChannelGoodsPriceList(QueryModel queryModel) {
        List<ChannelGoodsPrice> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT cgp.* FROM vip_channelgoodsprice cgp ");
            sql.append("LEFT JOIN vip_channelrate cr ON cr.rateId = cgp.rateId ");
            sql.append("LEFT JOIN vip_channel c ON c.channelId=cr.channelId  ");
            sql.append("LEFT JOIN vip_channelobject co ON co.channelObjectId = cr.channelObjectId ");
            sql.append("WHERE ");
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

            query.addEntity(ChannelGoodsPrice.class);

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
     * 查询商品价格
     * @param queryModel
     * @param para
     * @return
     */
    @Override
    public List<ChannelGoodsPrice> searchChannelGoodsPrice(QueryModel queryModel, ParamObject para) {

        List<ChannelGoodsPrice> list = new ArrayList<ChannelGoodsPrice>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT cgp.* " );
            sql.append(" FROM vip_channelgoodsprice cgp WHERE");
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

            query.addEntity(ChannelGoodsPrice.class);

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
     * 查询商品价格
     * @param queryModel
     * @param para
     * @return
     */
    @Override
    public List<Frequency> searchFrequencyGoods(QueryModel queryModel, ParamObject para) {

        List<Frequency> list = new ArrayList<Frequency>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT cgp.* " );
            sql.append(" FROM vip_frequency cgp WHERE");
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

            query.addEntity(ChannelGoodsPrice.class);

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
     * 根据Id查询商品销售价格
     * @param queryModel
     * @return
     */
    @Override
    public List<ChannelGoodsPriceExt> searchChannelAndPriceByGoodsId(QueryModel queryModel) {
        List<ChannelGoodsPriceExt> channelGoodsPriceExtList=new ArrayList<>();
        Session session = super.getSessionFactory().getCurrentSession();
        String conditionSql = queryModel.getQueryHqlStr();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT cgp.*,c.typeId categoryTypeId,cn.channelCode,g.goodsName,c.cateName,g.cost as channelCost FROM vip_channelgoodsprice cgp ");
        sql.append(" LEFT JOIN vip_goods g ON g.goodsId = cgp.goodsId");
        sql.append(" LEFT JOIN vip_category c ON c.cateId=g.cateId");
        sql.append(" LEFT JOIN vip_channelrate cr ON cr.rateId=cgp.rateId");
        sql.append(" LEFT JOIN vip_channel cn ON cn.channelId=cr.channelId");
        sql.append(" WHERE ");
        sql.append(conditionSql);
        String queryString = sql.toString();
        SQLQuery query = session.createSQLQuery(queryString);
        query.addEntity(ChannelGoodsPriceExt.class);
        queryModel.assignValue(query);
        channelGoodsPriceExtList=query.list();
        return channelGoodsPriceExtList;
    }
}
