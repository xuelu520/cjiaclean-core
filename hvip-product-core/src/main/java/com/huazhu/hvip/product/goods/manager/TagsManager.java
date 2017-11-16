/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagsManager.java
 * Author:   chenli
 * Date:     2016-03-20 17:39:33
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 17:39:33> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.Tags;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagGoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagsExt;

import java.util.List;
import java.util.Map;

public interface TagsManager extends GenericManager<Tags, Long> {

    /**
     * 获取标签列表
     *
     * @param paramObject
     * @return
     */
    List<Tags> searchTagsList(ParamObject paramObject);

    /**
     * 获取全部标签列表
     *
     * @param paramObject
     * @return
     */
    List<TagsExt> searchAllTagsList(ParamObject paramObject);

    /**
     * 查询标签商品设置
     *
     * @param paramObject
     * @return
     */
    List<TagGoodsExt> searchTagGoodsList(ParamObject paramObject);

    /**
     * 保存系列
     *
     * @param sortMap
     * @return
     */
    void saveSort(Map<Long, Integer> sortMap);

    /**
     * 根据id删除标签
     *
     * @param ids
     * @return
     */
    void deleteTagsByIds(Long[] ids);

    /**
     * 根据Id查询标签
     *
     * @param tagsId
     * @return
     */
    TagsExt searchTagsById(Long tagsId);

    /**
     * 保存更改标签
     *
     * @param tagsExt
     * @return
     */
    void saveEdit(TagsExt tagsExt);

    /**
     * 查询标签下的商品
     *
     * @param paramObject
     * @return
     */
    List<Goods> listGoodsJsonByTagsId(ParamObject paramObject, Long tagsId);
}