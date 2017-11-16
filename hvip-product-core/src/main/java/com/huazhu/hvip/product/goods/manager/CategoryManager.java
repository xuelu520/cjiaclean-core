/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CategoryManager.java
 * Author:   lijing
 * Date:     2016-03-16 20:20:46
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 20:20:46> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.Category;
import com.huazhu.hvip.product.goods.model.extend.CategoryExt;

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
public interface CategoryManager extends GenericManager<Category, Long> {

    /**
     * 根据名称获取分类
     *
     * @param cateName
     * @return
     */
    Category getCategoryByName(String cateName);

    /**
     * 获取子分类
     *
     * @param cate
     * @return
     */
    List<Category> getChildren(Category cate);

    /**
     * 获取父分类
     *
     * @param cate
     * @return
     */
    Category getParent(Category cate);

    /**
     * 检测分类名是否存在
     *
     * @param cateName
     * @return 存在返回真，不存在返回假
     */
    public boolean checkname(String cateName, Long cateId);

    /**
     * 获取某个分类的所有父分类
     *
     * @param cate
     * @return
     */
    public List<Category> getAllParents(Category cate);

    /**
     * 查询主分类列表
     *
     * @return List<Category>
     */
    public List<CategoryExt> searchCategoryList();

    /**
     * 查询树形结构分类列表
     *
     * @return List<Category>
     */
    public List<CategoryExt> searchAllCategory();

    /**
     * 根据条件查询分类列表
     *
     * @param paramObject
     * @return
     */
    public List<CategoryExt> searchCategoryList(ParamObject paramObject);

    /**
     * 添加分类
     *
     * @param category
     * @return
     */
    public Category addCategory(Category category);

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    public void saveSort(Map<Long, Integer> sortMap);

    /**
     * 判断是否为父分类
     * @param cateId
     * @return
     */
    public Integer getIsParentByCategoryId(Long cateId);
}
