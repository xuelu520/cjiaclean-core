/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TagsManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.TagGoodsDao;
import com.huazhu.hvip.product.goods.dao.TagsDao;
import com.huazhu.hvip.product.goods.manager.TagsManager;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.TagGoods;
import com.huazhu.hvip.product.goods.model.Tags;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagGoodsExt;
import com.huazhu.hvip.product.goods.model.extend.TagsExt;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Picture;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("tagsManager")
public class TagsManagerImpl extends GenericManagerImpl<Tags, Long> implements TagsManager {

    private static Logger logger = LogManager.getLogger(GoodsManagerImpl.class);

    TagsDao tagsDao;

    @Autowired
    public TagsManagerImpl(TagsDao tagsDao) {
        super(tagsDao);
        this.tagsDao = tagsDao;
    }

    TagGoodsDao tagGoodsDao;

    @Autowired
    public void setTagGoodsDao(TagGoodsDao tagGoodsDao) {
        this.tagGoodsDao = tagGoodsDao;
    }

    /**
     * 获取标签列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Tags> searchTagsList(ParamObject paramObject) {
        logger.info("call searchTagsList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        Long goodsId = paramObject.getLongParam("goodsId");

        QueryModel queryModel = new QueryModel();

        if (goodsId != null) {
            QueryModel query = new QueryModel();
            query.addColumnValueCondition("goodsId", goodsId);
            List<TagGoods> tagGoodsList = tagGoodsDao.search(query);

            if (tagGoodsList == null || tagGoodsList.isEmpty()) {
                logger.info("该商品未设置标签");
                return null;
            }

            List<Long> tagsIdList = new ArrayList<>();

            for (TagGoods tagGoods : tagGoodsList) {
                tagsIdList.add(tagGoods.getTagsId());
            }

            queryModel.addColumnValueCondition("tagsId", QueryModel.OPERATOR_IN, "(" + StringUtils.join(tagsIdList, ",") + ")");


        }

        List<Tags> tagsList = tagsDao.search(queryModel);

        return tagsList;
    }

    /**
     * 获取全部标签列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<TagsExt> searchAllTagsList(ParamObject paramObject) {
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();
        QueryModel queryModel = new QueryModel();
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        queryModel.setPageNo(pageNo);
        queryModel.setPageSize(pageSize);
        return tagsDao.searchAllTagsList(queryModel, paramObject);
    }

    /**
     * 查询标签商品设置
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<TagGoodsExt> searchTagGoodsList(ParamObject paramObject) {
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();
        QueryModel queryModel = new QueryModel();
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        queryModel.setPageNo(pageNo);
        queryModel.setPageSize(pageSize);
        return tagGoodsDao.searchTagGoodsList(queryModel, paramObject);
    }

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    @Override
    public void saveSort(Map<Long, Integer> sortMap) {
        Tags tags = null;
        for (Map.Entry<Long, Integer> entry : sortMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Long tagsId = Long.valueOf((String) key);
            Integer sort = Integer.valueOf((String) value);
            tags = tagsDao.get(tagsId);
            if (null != tags) {
                tags.setSort(sort);
                tagsDao.save(tags);
            }
        }
    }

    /**
     * 根据id删除标签
     *
     * @param ids
     * @return
     */
    @Override
    public void deleteTagsByIds(Long[] ids) {
        QueryModel queryModel = new QueryModel();
        String s = StringUtils.join(ids, ",");
        queryModel.addColumnValueCondition("id", QueryModel.OPERATOR_IN, "(" + s + ")");
        List<Tags> goodsList =tagsDao.search(queryModel);
        if (goodsList !=null && goodsList.size()>0){
            for (Tags tags : goodsList){
                tagsDao.remove(tags);
            }
        }
    }

    /**
     * 根据Id查询标签
     *
     * @param tagsId
     * @return
     */
    @Override
    public TagsExt searchTagsById(Long tagsId) {
        return tagsDao.searchTagsById(tagsId);
    }

    /**
     * 保存更改标签
     *
     * @param tagsExt
     * @return
     */
    @Override
    public void saveEdit(TagsExt tagsExt) {
        Long id = tagsExt.getTagsId();
        QueryModel queryModel = new QueryModel();
        if (id != null){
            queryModel.addColumnValueCondition("id",id);
        }
        List<Tags> tagsList = tagsDao.search(queryModel);
        for (Tags tags : tagsList){
            tags.setPicId(tagsExt.getPicId());
            tags.setPicWidth(tagsExt.getPicWidth());
            tags.setPicHeight(tagsExt.getPicHeight());
            tagsDao.save(tags);
        }
//        tagsDao.saveEdit(tagsExt);
    }


    /**
     * 查询标签下的商品
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Goods> listGoodsJsonByTagsId(ParamObject paramObject, Long tagsId) {
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();
        QueryModel queryModel = new QueryModel();
        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }
        queryModel.setPageNo(pageNo);
        queryModel.setPageSize(pageSize);
        List<Goods> goodsList = tagGoodsDao.listGoodsJsonByTagsId(queryModel,paramObject,tagsId);
        return goodsList;
    }
}