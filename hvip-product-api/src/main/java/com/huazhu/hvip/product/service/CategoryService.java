/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsCatService.java
 * Author:   lijing
 * Date:     2016-03-16 18:27:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 18:27:39> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.request.CategoryInfo;
import com.huazhu.hvip.product.vo.CategoryVO;

import java.util.Map;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CategoryService {

    /**
     * 获取所有分类
     *
     * @return
     */
    ReturnObject<CategoryVO> getAll();

    /**
     * 根据id获取分类
     *
     * @param cateId cateId
     * @return
     */
    ReturnObject<CategoryVO> getCategoryById(Long cateId);


    /**
     * 根据名称获取分类
     *
     * @param paramObject cateName
     * @return
     */
    ReturnObject<CategoryVO> getCategoryByName(ParamObject paramObject);

    /**
     * 保存分类
     *
     * @param categoryInfo
     * @return
     */
    ReturnObject<CategoryVO> saveCategory(CategoryInfo categoryInfo);

    /**
     * 移除分类
     *
     * @param categoryVO
     * @return
     */
    ReturnObject removeCategory(CategoryVO categoryVO);

    /**
     * 获取子分类
     *
     * @param cateId
     * @return
     */
    ReturnObject<CategoryVO> getChildren(Long cateId);

    /**
     * 获取父分类
     *
     * @param categoryVO
     * @return
     */
    ReturnObject<CategoryVO> getParent(CategoryVO categoryVO);

    /**
     * 检查分类名是否存在
     *
     * @param paramObject cateName cateId
     * @return
     */
    ReturnObject<Boolean> checkName(ParamObject paramObject);

    /**
     * 查询主分类列表
     *
     * @return ReturnObject
     */
    ReturnObject<CategoryVO> searchCategoryList();

    /**
     * 查询树形结构分类列表
     *
     * @return ReturnObject
     */
    ReturnObject<CategoryVO> searchAllCategory();

    /**
     * 获取分类列表(已开通以及全部分类)
     *
     * @param hotelUniqueNo 酒店唯一编号
     * @param page 分页参数
     * @return
     */
    ReturnObject<CategoryVO> searchCategoryByHotelUniqueNo(String hotelUniqueNo,PageCondition page);

    /**
     * 获取分类列表(已开通)
     *
     * @param hotelUniqueNo 酒店唯一编号
     * @param page 分页参数
     * @return
     */
    ReturnObject<CategoryVO> searchOpenCategoryByHotelUniqueNo(String hotelUniqueNo,PageCondition page);

    /**
     * 添加分类信息
     * @param categoryInfo
     * @return
     */
    ReturnObject<CategoryVO> addCategory(CategoryInfo categoryInfo);

    /**
     * 保存排序
     * @param sortMap
     * @return
     */
    ReturnObject saveSort(Map<Long,Integer> sortMap);

    /**
     * 获取分类列表，附带该分类下已上架的商品列表
     *
     * @return
     */
    ReturnObject<CategoryVO> searchCategoryGoodsList();


}
