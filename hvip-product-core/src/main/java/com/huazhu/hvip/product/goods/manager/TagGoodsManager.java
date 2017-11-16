/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagGoodsManager.java
 * Author:   chenli
 * Date:     2016-03-20 17:39:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 17:39:07> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.TagGoods;

public interface TagGoodsManager extends GenericManager<TagGoods, Long> {
    /**
     * 关联商品与标签
     *
     * @param tagGoods
     * @return
     */
    void addTagsGoods(TagGoods tagGoods);

    /**
     * 根据商品Id删除标签下的关联商品
     *
     * @param goodsId
     * @param tagsId
     * @return
     */
    void deleteGoods(Long goodsId, Long tagsId);
}