/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-14 15:21:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:21:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.channel.dao.ChannelDao;
import com.huazhu.hvip.product.channel.model.Channel;
import com.huazhu.hvip.product.channel.model.ChannelRate;
import com.huazhu.hvip.product.channel.model.extend.ChannelGoodsPriceExt;
import com.huazhu.hvip.product.channel.model.extend.ChannelRateExt;
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
@Repository("channelDao")
public class ChannelDaoHibernate extends GenericDaoHibernate<Channel, Long> implements ChannelDao {

    public ChannelDaoHibernate() {
        super(Channel.class);
    }

    @Override
    public List<Channel> searchChannelList(QueryModel queryModel, ParamObject paramObject) {
        List<Channel> channelList = new ArrayList<>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append("select * from vip_channel c where");
            sql.append(conditionSql);
            boolean pageFlag = false;
            if (queryModel.getPageSize() != null && queryModel.getTotalNum() != null) {
                StringBuffer countSql = new StringBuffer();
                countSql.append(" select count(*)  ");
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
            query.addEntity(Channel.class);
            queryModel.assignValue(query);
            // 分页模式下只列当前页
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                channelList = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                channelList = query.list();
            }
            if (!pageFlag) {
                if (!channelList.isEmpty())
                    queryModel.setTotalNum(channelList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channelList;
    }

    /**
     * 自定义条件查询价格名称列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelRateExt> searchRateList(QueryModel queryModel, ParamObject paramObject) {
        List<ChannelRateExt> channelRateList = new ArrayList<>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append("select c.*,c1.channelName from vip_channelrate c INNER JOIN vip_channel c1 on c.channelId=c1.channelId where");
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
            query.addEntity(ChannelRateExt.class);
            queryModel.assignValue(query);
            // 分页模式下只列当前页
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                channelRateList = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                channelRateList = query.list();
            }
            if (!pageFlag) {
                if (!channelRateList.isEmpty())
                    queryModel.setTotalNum(channelRateList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channelRateList;
    }

    /**
     * 自定义条件查询详细价格列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<ChannelGoodsPriceExt> searchChannelGoodsPriceList(QueryModel queryModel, ParamObject paramObject) {
        List<ChannelGoodsPriceExt> ChannelGoodsPriceList = new ArrayList<>();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append("select c.*,c2.channelName,g.goodsName from vip_channelgoodsprice c INNER JOIN vip_channelrate c1 ON c.rateId=c1.rateId INNER JOIN vip_goods g ON c.goodsId=g.goodsId INNER JOIN vip_channel c2 ON c2.channelId=c1.channelId where");
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
            query.addEntity(ChannelGoodsPriceExt.class);
            queryModel.assignValue(query);
            // 分页模式下只列当前页
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                ChannelGoodsPriceList = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                ChannelGoodsPriceList = query.list();
            }
            if (!pageFlag) {
                if (!ChannelGoodsPriceList.isEmpty())
                    queryModel.setTotalNum(ChannelGoodsPriceList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ChannelGoodsPriceList;
    }
}
