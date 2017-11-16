/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagsDao.java
 * Author:   admin
 * Date:     2016-03-13 14:31:21
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:21> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.Tags;
import com.huazhu.hvip.product.goods.model.extend.TagsExt;

import java.util.List;

/**
 * An interface that provides a data management interface to the Tags table.
 */
public interface TagsDao extends GenericDao<Tags, Long> {
    /**
     * 获取全部标签列表
     *
     * @param paramObject
     * @return
     */
    List<TagsExt> searchAllTagsList(QueryModel queryModel, ParamObject paramObject);

    /**
     * 根据Id查询标签
     *
     * @param tagsId
     * @return
     */
    TagsExt searchTagsById(Long tagsId);

//    /**
//     * 保存更改标签
//     *
//     * @param tagsExt
//     * @return
//     */
//    void saveEdit(TagsExt tagsExt);
}