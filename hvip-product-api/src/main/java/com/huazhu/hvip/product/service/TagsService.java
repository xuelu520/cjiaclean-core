/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsService.java
 * Author:   chenli
 * Date:     2016-03-21 17:05:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-21 17:05:06> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.*;

import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface TagsService {
    /**
     * 查询标签列表
     *
     * @param paramObject
     * @return
     */
    ReturnObject<TagsVO> searchTagsList(ParamObject paramObject);

    /**
     * 查询标签商品设置
     *
     * @param paramObject
     * @return
     */
    ReturnObject<TagGoodsVO> searchTagGoodsList(ParamObject paramObject);

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    ReturnObject saveSort(Map<Long, Integer> sortMap);

    /**
     * 根据id删除标签
     *
     * @param ids
     * @return
     */
    ReturnObject deleteTagsByIds(Long[] ids);

    /**
     * 保存标签
     *
     * @param tagsVO
     * @return
     */
    ReturnObject<TagsVO> saveTags(TagsVO tagsVO);

    /**
     * 根据Id查询标签
     *
     * @param tagsId
     * @return
     */
    TagsVO searchTagsById(Long tagsId);

    /**
     * 保存更改
     *
     * @param tagsVO
     * @return
     */
    public ReturnObject<TagsVO> saveEdit(TagsVO tagsVO);

    /**
     * 查询标签下的商品
     *
     * @param paramObject
     * @return
     */
    ReturnObject<GoodsVO> listGoodsJsonByTagsId(ParamObject paramObject, Long tagsId);

    /**
     * 关联商品与标签
     *
     * @param tagGoodsVO
     * @return
     */
    ReturnObject addTagsGoods(TagGoodsVO tagGoodsVO);

    /**
     * 根据商品Id删除标签下的关联商品
     *
     * @param goodsId
     * @return
     */
    ReturnObject deleteGoods(Long goodsId,Long tagsId);

}
