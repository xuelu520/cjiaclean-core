/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CategoryDao.java
 * Author:   lijing
 * Date:     2016-03-16 20:14:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 20:14:48> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.Category;
import com.huazhu.hvip.product.goods.model.extend.CategoryExt;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CategoryDao extends GenericDao<Category, Long> {

    /**
     * 查询主分类列表
     *
     * @param queryModel
     * @return List<Category>
     */
    public List<CategoryExt> searchCategoryList(QueryModel queryModel);

    /**
     * 查询树形结构分类列表
     *
     * @return List<Category>
     */
    public List<CategoryExt> searchAllCategory();

    /**
     * 判断是否为父分类
     * @param cateId
     * @return
     */
    public Integer getIsParentByCategoryId(Long cateId);
}
