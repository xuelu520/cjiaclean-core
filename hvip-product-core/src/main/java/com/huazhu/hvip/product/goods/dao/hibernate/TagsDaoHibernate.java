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
import com.huazhu.hvip.product.goods.dao.TagsDao;
import com.huazhu.hvip.product.goods.model.Tags;
import com.huazhu.hvip.product.goods.model.extend.TagsExt;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("tagsDao")
public class TagsDaoHibernate extends GenericDaoHibernate<Tags, Long> implements TagsDao {

    public TagsDaoHibernate() {
        super(Tags.class);
    }

    /**
     * 获取全部标签列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<TagsExt> searchAllTagsList(QueryModel queryModel, ParamObject paramObject) {
        List<TagsExt> tagsList = new ArrayList<TagsExt>();
        try {
            StringBuilder sql = new StringBuilder();
            Session session = super.getSessionFactory().getCurrentSession();
            sql.append("SELECT t.*,p.url picUrl from vip_tags t LEFT  JOIN hvip_common.picture p ON t.picId=p.picId where ");
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
            query.addEntity(TagsExt.class);
            queryModel.assignValue(query);
            if (queryModel.getPageSize() != null && queryModel.getPageSize() > 0) {
                tagsList = query.setFirstResult(queryModel.getStartRecord()).setMaxResults(queryModel.getPageSize()).list();

            } else {
                tagsList = query.list();
            }
            if (!pageFlag) {
                if (!tagsList.isEmpty())
                    queryModel.setTotalNum(tagsList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tagsList;
    }

    /**
     * 根据Id查询标签
     *
     * @param tagsId
     * @return
     */
    @Override
    public TagsExt searchTagsById(Long tagsId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT t.*,p.url picUrl  FROM vip_tags t INNER JOIN hvip_common.picture p on t.picId=p.picId where ");
        sql.append("t.tagsId=" + tagsId + "");
        List<TagsExt> list = super.searchObject(sql.toString(), TagsExt.class);
        return list.get(0);
    }


//    /**
//     * 保存更改标签
//     *
//     * @param tagsExt
//     * @return
//     */
//    @Override
//    public void saveEdit(TagsExt tagsExt) {
//        Tags tags = new Tags();
//        BeanUtils.copyProperties(tagsExt, tags, tagsExt.getPicUrl());
//        super.updateObject("UPDATE vip_tags t SET t.picId='"+tagsExt.getPicId()+"',t.picWidth='" + tagsExt.getPicWidth() + "',t.picHeight='" + tagsExt.getPicHeight() + "' WHERE t.tagsId=" + tagsExt.getTagsId());
//        String url =null;
//        if (!StringUtil.isEmpty(tagsExt.getPicUrl())) {
//            url = tagsExt.getPicUrl();
//        }
//        String sql = "UPDATE hvip_common.picture p SET p.url=" + url + " WHERE p.picId= " + tagsExt.getPicId();
//        Session session = super.getSessionFactory().getCurrentSession();
//        super.updateObject(sql);
//    }
}