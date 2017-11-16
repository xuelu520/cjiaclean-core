/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CategoryServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-16 20:41:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-16 20:41:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.service.HotelCateService;
import com.huazhu.hvip.operation.vo.HotelCateVO;
import com.huazhu.hvip.product.goods.manager.CategoryManager;
import com.huazhu.hvip.product.goods.manager.GoodsManager;
import com.huazhu.hvip.product.goods.manager.GoodsTypeManager;
import com.huazhu.hvip.product.goods.model.Category;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.GoodsType;
import com.huazhu.hvip.product.goods.model.extend.CategoryExt;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.product.request.CategoryInfo;
import com.huazhu.hvip.product.service.CategoryService;
import com.huazhu.hvip.product.service.GoodsService;
import com.huazhu.hvip.product.vo.CategoryVO;
import com.huazhu.hvip.product.vo.GoodsVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huazhu.hvip.product.goods.dao.CategoryDao;

import java.util.ArrayList;
import java.util.HashMap;
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
@Service
public class CategoryServiceImpl implements CategoryService {

    private static Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryManager categoryManager;
    @Autowired
    private HotelCateService hotelCateService;
    @Autowired
    private GoodsManager goodsManager;
    @Autowired
    private GoodsTypeManager goodsTypeManager;
    @Autowired
    private CategoryDao categoryDao;

    /**
     * 获取所有分类
     *
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> getAll() {

        ReturnObject<CategoryVO> ret = new ReturnObject<CategoryVO>();
        List<CategoryVO> cateVOList = new ArrayList();

        try {
            List<Category> cateList = categoryManager.getAll();
            for (Category cate : cateList) {
                CategoryVO cateVO = new CategoryVO();
                BeanUtils.copyProperties(cate, cateVO);
                cateVOList.add(cateVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        ret.setDataList(cateVOList);
        return ret;
    }


    /**
     * 通过id获取分类
     *
     * @param cateId 分类id
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> getCategoryById(Long cateId) {
        logger.info("call getCategoryById({\"cateId:\"" + cateId + "})");

        ReturnObject<CategoryVO> ret = new ReturnObject<CategoryVO>();

        try {
            Category category = categoryManager.get(cateId);
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(category, categoryVO);
            GoodsType goodsType = goodsTypeManager.get(categoryVO.getTypeId());
            categoryVO.setBizScope(goodsType.getBizScope());
            ret.setData(categoryVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 根据名称获取分类
     *
     * @param paramObject cateName
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> getCategoryByName(ParamObject paramObject) {

        ReturnObject<CategoryVO> ret = new ReturnObject<>();

        try {
            String cateName = paramObject.getStringParam("cateName");
            Category cate = categoryManager.getCategoryByName(cateName);
            CategoryVO cateVO = new CategoryVO();
            BeanUtils.copyProperties(cate, cateVO);
            ret.setData(cateVO);
        } catch (BeansException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 保存分类
     *
     * @param categoryInfo
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> saveCategory(CategoryInfo categoryInfo) {

        ReturnObject<CategoryVO> ret = new ReturnObject<CategoryVO>();

        try {
            Long cateId = categoryInfo.getCateId();
            Category cate = categoryManager.get(cateId);
            BeanUtils.copyProperties(categoryInfo, cate);
            cate = categoryManager.save(cate);
            CategoryVO cateVO = new CategoryVO();
            BeanUtils.copyProperties(cate, cateVO);
            ret.setData(cateVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 移除分类
     *
     * @param categoryVO
     * @return
     */
    @Override
    public ReturnObject removeCategory(CategoryVO categoryVO) {
        Integer recount = categoryManager.getIsParentByCategoryId(categoryVO.getCateId());
        ReturnObject ret = new ReturnObject();
        if (recount > 0) {
            ret.setReturnMsg("该分类下有子子分类请先删除子分类");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            return ret;
        }
        recount = goodsManager.getGoodsIsExistByCategoryId(categoryVO.getCateId());
        if (recount > 0) {
            ret.setReturnMsg("该分类下有商品，请先删除该分类下的商品");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            return ret;
        }
        try {
            Category cate = new Category();
            BeanUtils.copyProperties(categoryVO, cate);
            categoryManager.remove(cate);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 检查分类名是否存在
     *
     * @param paramObject cateName cateId
     * @return
     */
    @Override
    public ReturnObject<Boolean> checkName(ParamObject paramObject) {

        ReturnObject<Boolean> ret = new ReturnObject<Boolean>();

        try {
            String cateName = paramObject.getStringParam("cateName");
            String cateId = paramObject.getStringParam("cateId");
            Boolean result = categoryManager.checkname(cateName, Long.valueOf(cateId));
            ret.setData(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 获取子分类
     *
     * @param cateId
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> getChildren(Long cateId) {
        logger.info("call getChildren({\"cateId:\"" + cateId + "})");
        ReturnObject<CategoryVO> ret = new ReturnObject<CategoryVO>();

        try {

            ParamObject paramObject = new ParamObject();
            paramObject.add("parentId", cateId);
            List<CategoryExt> list = categoryManager.searchCategoryList(paramObject);
            List<CategoryVO> voList = new ArrayList<CategoryVO>();
            for (CategoryExt category : list) {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
                voList.add(categoryVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 获取父分类
     *
     * @param categoryVO
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> getParent(CategoryVO categoryVO) {
        return null;
    }


    /**
     * 查询主分类列表
     *
     * @return ReturnObject
     */
    @Override
    public ReturnObject<CategoryVO> searchCategoryList() {

        ReturnObject<CategoryVO> ret = new ReturnObject<CategoryVO>();

        try {
            List<CategoryExt> list = categoryManager.searchCategoryList();
            List<CategoryVO> voList = new ArrayList<CategoryVO>();
            for (CategoryExt category : list) {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
                voList.add(categoryVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 查询树形结构分类列表
     *
     * @return ReturnObject
     */
    @Override
    public ReturnObject<CategoryVO> searchAllCategory() {

        ReturnObject<CategoryVO> ret = null;
        try {
            ret = new ReturnObject<CategoryVO>();
            List<CategoryExt> list = categoryManager.searchAllCategory();
            List<CategoryVO> voList = new ArrayList<CategoryVO>();
            copyAllProperties(list, voList);
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 获取首页分类列表
     *
     * @param hotelUniqueNo 酒店唯一编号
     * @param page          分页参数
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> searchCategoryByHotelUniqueNo(String hotelUniqueNo, PageCondition page) {
        logger.info("call searchCategoryByHotelUniqueNo({\"hotelUniqueNo:\"" + hotelUniqueNo + "})");

        ReturnObject<CategoryVO> returnObject = new ReturnObject<>();
        List<CategoryVO> categoryVOList = new ArrayList<>();
        CategoryVO categoryVO = null;

        try {
            //根据酒店统一编号获取该酒店已开通的分类列表
            ReturnObject<HotelCateVO> ret = hotelCateService.searchOpenCateByHotelUniqueNo(hotelUniqueNo);
            List<HotelCateVO> hotelCateVOList = ret.getDataList();

            Map<Long, HotelCateVO> openMap = new HashMap<>();

            for (HotelCateVO hotelCateVO : hotelCateVOList) {
                openMap.put(hotelCateVO.getCateId(), hotelCateVO);
            }

            //查询分类列表
            ParamObject paramObject = new ParamObject();
            if (page != null) {
                paramObject.setPageSize(page.getPageSize());
                paramObject.setPageNo(page.getPageNo());
                if (StringUtils.isNotBlank(page.getSortBy())) {
                    paramObject.add("orderBy", " " + page.getSortBy() + " " + page.getDirection());
                }
            }
            paramObject.add("status", Constants.CATE_STATUS_ENABLE_TRUE);

            List<CategoryExt> categoryList = categoryManager.searchCategoryList(paramObject);

            for (CategoryExt category : categoryList) {
                categoryVO = new CategoryVO();

                BeanUtils.copyProperties(category, categoryVO);

                if (openMap.containsKey(category.getCateId())) {
                    categoryVO.setOpenFlag(true);
                } else {
                    categoryVO.setOpenFlag(false);
                }

                categoryVOList.add(categoryVO);

            }

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("查询该酒店已开通的商品列表失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        returnObject.setDataList(categoryVOList);

        return returnObject;
    }

    /**
     * 获取分类列表(已开通)
     *
     * @param hotelUniqueNo 酒店唯一编号
     * @param page          分页参数
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> searchOpenCategoryByHotelUniqueNo(String hotelUniqueNo, PageCondition page) {
        logger.info("call searchOpenCategoryByHotelUniqueNo({\"hotelUniqueNo:\"" + hotelUniqueNo + "})");

        ReturnObject<CategoryVO> returnObject = new ReturnObject<>();
        List<CategoryVO> categoryVOList = new ArrayList<>();
        CategoryVO categoryVO = null;

        try {
            //根据酒店统一编号获取该酒店已开通的分类列表
            ReturnObject<HotelCateVO> ret = hotelCateService.searchOpenCateByHotelUniqueNo(hotelUniqueNo);
            List<HotelCateVO> hotelCateVOList = ret.getDataList();

            for (HotelCateVO hotelCateVO : hotelCateVOList) {
                categoryVO = new CategoryVO();
                categoryVO.setCateId(hotelCateVO.getCateId());
                categoryVOList.add(categoryVO);
            }
            returnObject.setDataList(categoryVOList);
            returnObject.setReturnMsg("查询已开通分类列表成功");
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnMsg("查询已开通分类列表失败");
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
        }

        return returnObject;
    }

    /**
     * 添加分类信息
     *
     * @param categoryInfo
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> addCategory(CategoryInfo categoryInfo) {
        logger.info("call addCategory({\"categoryInfo:\"" + categoryInfo.toString() + "})");

        ReturnObject<CategoryVO> ret = new ReturnObject<CategoryVO>();

        try {
            Category cate = new Category();
            BeanUtils.copyProperties(categoryInfo, cate);
            cate.setStatus(Constants.COMMON_STATUS_1);
            cate = categoryManager.addCategory(cate);
            CategoryVO cateVO = new CategoryVO();
            BeanUtils.copyProperties(cate, cateVO);
            ret.setData(cateVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("添加分类成功");
        } catch (Exception e) {
            logger.error("添加分类失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("添加分类失败");
        }

        return ret;
    }

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    @Override
    public ReturnObject saveSort(Map<Long, Integer> sortMap) {
        logger.info("call saveSort({\"sortMap:\"" + JsonUtil.JSON_Bean2String(sortMap) + "})");
        ReturnObject ret = new ReturnObject();
        try {
            categoryManager.saveSort(sortMap);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存排序成功");
        } catch (Exception e) {
            logger.error("保存排序失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存排序成功");
        }
        return ret;
    }

    /**
     * 获取分类列表，附带该分类下已上架的商品列表
     *
     * @return
     */
    @Override
    public ReturnObject<CategoryVO> searchCategoryGoodsList() {
        logger.info("call searchCategoryGoodsList()");
        ReturnObject<CategoryVO> ret = ret = new ReturnObject<>();

        try {
            List<CategoryVO> categoryVOList = new ArrayList<>();
            CategoryVO categoryVO = null;
            List<GoodsVO> goodsVOList = null;
            GoodsVO goodsVO = null;
            ParamObject paramObject = null;

            List<Category> cateList = categoryManager.getAll();

            for (Category cate : cateList) {
                paramObject = new ParamObject();
                paramObject.add("cateId", cate.getCateId());
                paramObject.add("marketEnable", Constants.GOODS_MARKETENABLE_YES);
                List<GoodsExt> goodsExtList = goodsManager.searchGoodsList(paramObject);

                if (goodsExtList != null && goodsExtList.size() > 0) {
                    categoryVO = new CategoryVO();
                    BeanUtils.copyProperties(cate, categoryVO);

                    goodsVOList = new ArrayList<>();
                    for (GoodsExt goodsExt : goodsExtList) {
                        goodsVO = new GoodsVO();
                        BeanUtils.copyProperties(goodsExt, goodsVO);
                        goodsVOList.add(goodsVO);
                    }
                    categoryVO.setGoodsVOList(goodsVOList);

                    categoryVOList.add(categoryVO);
                }

            }
            ret.setDataList(categoryVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 将list中所有对象以及children
     * 中的所有对象转换成VO对象
     *
     * @param list
     */
    private void copyAllProperties(List list, List voList) {
        if (list != null && list.size() > 0) {
            for (Object o : list) {
                CategoryExt cate = (CategoryExt) o;
                CategoryVO cateVO = new CategoryVO();
                BeanUtils.copyProperties(cate, cateVO);
                voList.add(cateVO);
                List child = cate.getChildren();
                if (child != null) {
                    List voChildList = new ArrayList();
                    cateVO.setChildren(voChildList);
                    copyAllProperties(child, voChildList);
                }
            }
        }
    }

}
