/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CategoryManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-16 20:22:00
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 20:22:00> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.CateCancelRuleDao;
import com.huazhu.hvip.product.goods.dao.CateOrderRuleDao;
import com.huazhu.hvip.product.goods.dao.CategoryDao;
import com.huazhu.hvip.product.goods.manager.CategoryManager;
import com.huazhu.hvip.product.goods.model.CateCancelRule;
import com.huazhu.hvip.product.goods.model.CateOrderRule;
import com.huazhu.hvip.product.goods.model.Category;
import com.huazhu.hvip.product.goods.model.extend.CategoryExt;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("categoryManager")
public class CategoryManagerImpl extends GenericManagerImpl<Category, Long> implements CategoryManager {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CateOrderRuleDao cateOrderRuleDao;
    @Autowired
    private CateCancelRuleDao cateCancelRuleDao;

    @Autowired
    public CategoryManagerImpl(CategoryDao categoryDao) {
        super(categoryDao);
        this.categoryDao = categoryDao;
    }

    /**
     * 根据名称获取分类
     *
     * @param cateName
     * @return
     */
    @Override
    public Category getCategoryByName(String cateName) {

        String sql = "select * from vip_category where cateName = '" + cateName + "'";
        Category cate = (Category) categoryDao.searchObject(sql);
        return cate;
    }

    /**
     * 获取子分类
     *
     * @param cate
     * @return
     */
    @Override
    public List<Category> getChildren(Category cate) {

        Long cateId = cate.getCateId();
        String sql = "select * from vip_category where parentId = " + cateId;
        List<Category> childList = categoryDao.searchObject(sql, Category.class);
        return childList;
    }

    /**
     * 获取父分类
     *
     * @param cate
     * @return
     */
    @Override
    public Category getParent(Category cate) {

        Long parentId = cate.getParentId();
        String sql = "select * from vip_category where cateId = '" + parentId + "'";
        Category parentCate = (Category) categoryDao.searchObject(sql);
        return parentCate;
    }

    /**
     * 检查分类名是否存在
     *
     * @param cateName
     * @param cateId
     * @return
     */
    @Override
    public boolean checkname(String cateName, Long cateId) {

        String sql = "select count(0) from vip_category where cateName = '" + cateName + "' and cateId<>" + cateId;
        int count = (int) categoryDao.searchObject(sql);
        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 获取所有父分类
     *
     * @param cate
     * @return
     */
    @Override
    public List<Category> getAllParents(Category cate) {
        return null;
    }

    /**
     * 查询主分类列表
     *
     * @return List<Category>
     */
    @Override
    public List<CategoryExt> searchCategoryList() {

        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("c.parentId", Long.valueOf(0));
        queryModel.setSortHql(" c.sort desc ");

        return categoryDao.searchCategoryList(queryModel);
    }

    /**
     * 查询树形结构分类列表
     *
     * @return List<Category>
     */
    @Override
    public List<CategoryExt> searchAllCategory() {
        return categoryDao.searchAllCategory();
    }

    /**
     * 根据条件查询分类列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<CategoryExt> searchCategoryList(ParamObject paramObject) {

        Integer pageNo = paramObject.getPageNo(); //当前页
        Integer pageSize = paramObject.getPageSize(); //每页显示数量
        String orderBy = paramObject.getStringParam("orderBy"); //排序
        String status = paramObject.getStringParam("status"); //状态
        Long parentId = paramObject.getLongParam("parentId");//父类id

        QueryModel queryModel = new QueryModel();

        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        }
        if (StringUtils.isNotBlank(status)) {
            queryModel.addColumnValueCondition("c.status", status);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }

        if (parentId != null) {
            queryModel.addColumnValueCondition("c.parentId",parentId);
        }
        List<CategoryExt> categoryList = categoryDao.searchCategoryList(queryModel);

        return categoryList;
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @Transactional
    @Override
    public Category addCategory(Category category) {

        //添加分类
        category = categoryDao.save(category);

        //添加订单支付规则
        CateOrderRule rule =  new CateOrderRule();
        rule.setCateId(category.getCateId());
        rule.setStorePayFlag(Constants.FLAG_FALSE);//是否支持门店支付
        rule.setPaidCancelFlag(Constants.FLAG_TRUE);//付款后能否取消
        rule.setPayCountdown(60);//付款倒计时 默认60分钟
        rule.setStatus(Constants.FLAG_TRUE);//状态
        rule.setReservationFlag(Constants.FLAG_FALSE);//是否要预约详细
        rule.setAccountingFlag(Constants.FLAG_TRUE); //是否需要入账 0否 1是
        rule.setCrmPayFlag(Constants.FLAG_TRUE); // 是否支持储值卡支付:  0.否 1.是
        cateOrderRuleDao.save(rule);

        //添加订单取消规则
        CateCancelRule cancelRule = new CateCancelRule();
        cancelRule.setCateId(category.getCateId());
        cancelRule.setCancelType(Constants.CANCEL_TYPE_0);//取消类型 默认全额退款
        cancelRule.setReturnsFlag(Constants.FLAG_FALSE);//默认发货后不可退货
        cancelRule.setReturnsMinutes(30);//多少时间(分钟)内前台有退货权限
        cancelRule.setStatus(Constants.FLAG_TRUE);//默认状态可用
        cateCancelRuleDao.save(cancelRule);

        return category;
    }

    /**
     * 保存排序
     * @param sortMap
     * @return
     */
    @Override
    public void saveSort(Map<Long,Integer> sortMap) {

        Category cate = null;
        Iterator it = sortMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Long cateId = Long.valueOf(key.toString());
            Integer sort = Integer.valueOf(value.toString());
            cate = categoryDao.get(cateId);
            if(null != cate){
                cate.setSort(sort);
                categoryDao.save(cate);
            }
        }
    }

    /**
     * 判断是否为父分类
     * @param cateId
     * @return
     */
    @Override
    public Integer getIsParentByCategoryId(Long cateId) {
        Integer recount=categoryDao.getIsParentByCategoryId(cateId);
        return recount;
    }

}
