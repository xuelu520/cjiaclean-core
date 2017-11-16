/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CategoryDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-16 20:16:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 20:16:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.CategoryDao;
import com.huazhu.hvip.product.goods.model.Category;
import com.huazhu.hvip.product.goods.model.GoodsStore;
import com.huazhu.hvip.product.goods.model.extend.CategoryExt;
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
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("categoryDao")
public class CategoryDaoHibernate extends GenericDaoHibernate<Category, Long> implements CategoryDao {

    public CategoryDaoHibernate() {
        super(Category.class);
    }

    /**
     * 查询主分类列表
     *
     * @param queryModel
     * @return List<Category>
     */
    @Override
    public List<CategoryExt> searchCategoryList(QueryModel queryModel) {

        List<CategoryExt> list = new ArrayList();
        try {
            Session session = super.getSessionFactory().getCurrentSession();
            String conditionSql = queryModel.getQueryHqlStr();
            StringBuffer sql = new StringBuffer();
            sql.append(" select c.*,gt.typeName from vip_category c LEFT JOIN vip_goodstype gt on c.typeId = gt.typeId  WHERE " );
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

            String sortHql = queryModel.getSortHql();

            if (StringUtils.isNotBlank(sortHql)) {
                sql.append(" ORDER BY " + sortHql);
            }

            String queryString = sql.toString();

            SQLQuery query = session.createSQLQuery(queryString);

            query.addEntity(CategoryExt.class);

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
     * 查询树形结构分类列表
     *
     * @return List<Category>
     */
    @Override
    public List<CategoryExt> searchAllCategory() {
        String sql = "select c.*,gt.typeName from vip_category c " +
                "LEFT JOIN vip_goodstype gt on c.typeId = gt.typeId order by c.parentId,c.cateId,c.sort desc";

        List<CategoryExt> allCateList = super.searchObject(sql, CategoryExt.class);
        List<CategoryExt> cateTree = null;
        if (allCateList != null && allCateList.size() > 0) {
            cateTree = new ArrayList<CategoryExt>();
            for (CategoryExt cate : allCateList) {
                if (cate.getParentId() == 0) {
                    List children = getChildrenCate(allCateList, cate);
                    cate.setChildren(children);
                    cateTree.add(cate);
                }
            }
        }
        return cateTree;
    }

    /**
     * 判断是否为父分类
     *
     * @param cateId
     * @return
     */
    @Override
    public Integer getIsParentByCategoryId(Long cateId) {
        String sql = "select count(0) from vip_category where parentId=" + cateId;
        Object recount = super.searchObject(sql);
        return Integer.valueOf(recount.toString());
    }

    /**
     * 获取子分类
     *
     * @param list
     * @param parent
     * @return
     */
    public List<CategoryExt> getChildrenCate(List<CategoryExt> list, CategoryExt parent) {
        List<CategoryExt> a = null;
        if (list != null && list.size() > 0) {
            a = new ArrayList<CategoryExt>();
            for (CategoryExt cate : list) {
                if ((parent.getCateId()).equals(cate.getParentId())) {
                    List children = getChildrenCate(list, cate);
                    cate.setChildren(children);
                    a.add(cate);
                }
            }
        }
        return a;
    }

}
