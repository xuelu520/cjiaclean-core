/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.channel.dao.ChannelGoodsPriceDao;
import com.huazhu.hvip.product.channel.model.ChannelGoodsPrice;
import com.huazhu.hvip.product.goods.dao.*;
import com.huazhu.hvip.product.goods.manager.GoodsManager;
import com.huazhu.hvip.product.goods.model.*;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("goodsManager")
public class GoodsManagerImpl extends GenericManagerImpl<Goods, Long> implements GoodsManager {

    private static Logger logger = LogManager.getLogger(GoodsManagerImpl.class);

    GoodsDao goodsDao;

    @Autowired
    public GoodsManagerImpl(GoodsDao goodsDao) {
        super(goodsDao);
        this.goodsDao = goodsDao;
    }

    @Autowired
    ProductDao productDao;
    @Autowired
    GoodsGalleryDao goodsGalleryDao;
    @Autowired
    ChannelGoodsPriceDao goodsPriceDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    GoodsTypeDao goodsTypeDao;

    /**
     * 根据条件查询Goods
     *
     * @param paramObject
     * @return List<Goods>
     */
    @Override
    public List<GoodsExt> searchGoodsList(ParamObject paramObject) {
        logger.info("call searchGoodsList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        String keyword = paramObject.getStringParam("keyword");
        String goodsName = paramObject.getStringParam("goodsName");//商品名称
        Long hotelId = paramObject.getLongParam("hotelId"); //酒店id
        String channelCode = paramObject.getStringParam("channelCode"); //渠道CODE;
        String deleteFlag = paramObject.getStringParam("deleteFlag"); //删除标志
        List<String> goodsSnList = (List<String>) paramObject.getParam("goodsSnList");
        List<Long> goodsIds = (List<Long>) paramObject.getParam("goodsIdList");
        List<Long> cateIds = (List<Long>) paramObject.getParam("cateIds");//酒店已开通的分类id
        List<String> cateSnList = (List<String>) paramObject.getParam("cateSnList");
        List<Long> typeList = (List<Long>) paramObject.getParam("typeList");//类型列表  d
        String orderBy = paramObject.getStringParam("orderBy");
        String bizScope = paramObject.getStringParam("bizScope");
        Integer pageSize = paramObject.getPageSize();
        Integer pageNo = paramObject.getPageNo();

        QueryModel queryModel = new QueryModel();

        queryModel.addColumnValueCondition("g.goodsSn", paramObject.getStringParam("goodsSn"));
        queryModel.addColumnValueCondition("g.goodsId", paramObject.getLongParam("goodsId"));
        queryModel.addColumnValueCondition("g.cateId", paramObject.getLongParam("cateId"));
        queryModel.addColumnValueCondition("c.cateSn", paramObject.getStringParam("cateSn"));
        queryModel.addColumnValueCondition("g.typeId", paramObject.getLongParam("typeId"));
        queryModel.addColumnValueCondition("g.marketEnable", paramObject.getStringParam("marketEnable"));

        if (StringUtils.isNotBlank(keyword)) {
            queryModel.addHqlCondition(" (g.goodsSn LIKE '%" + keyword + "%' OR g.goodsName LIKE '%" + keyword + "%') ");
        }
        if (goodsName != null) {
            queryModel.addHqlCondition(" (g.goodsName LIKE '%" + goodsName + "%') ");
        }

        if (StringUtils.isNotBlank(deleteFlag)) {
            queryModel.addColumnValueCondition("g.deleteFlag", deleteFlag);
        } else {
            queryModel.addColumnValueCondition("g.deleteFlag", Constants.DELETE_FLAG_FALSE);
        }

        if (cateIds != null && cateIds.size() > 0) {
            String str = StringUtils.join(cateIds, ",");
            queryModel.addHqlCondition("g.cateId IN (" + str + ")");
        }

        if (goodsSnList != null && goodsSnList.size() > 0) {
            String str = StringUtils.join(goodsSnList.toArray(), ",");
            str = StringUtil.spiltStr(str);
            queryModel.addHqlCondition("g.goodsSn IN (" + str + ")");
        }

        if (goodsIds != null && goodsIds.size() > 0) {
            String str = StringUtils.join(goodsIds, ",");
            queryModel.addHqlCondition("g.goodsId IN (" + str + ")");
        }

        if (cateSnList != null && cateSnList.size() > 0) {
            String str = StringUtils.join(cateSnList, ",");
            str = StringUtil.spiltStr(str);
            queryModel.addHqlCondition("c.cateSn IN (" + str + ")");
        }
        //类型列表  d
        if (typeList != null && typeList.size() > 0) {
            String str = StringUtils.join(typeList, ",");
            str = StringUtil.spiltStr(str);
            queryModel.addHqlCondition("g.typeId IN (" + str + ")");
        }

        if (StringUtils.isNotBlank(bizScope)) {
            QueryModel query = new QueryModel();
            query.addColumnValueCondition("bizScope", bizScope);
            List<GoodsType> goodsTypeList = goodsTypeDao.search(query);
            List<Long> typeIdList = new ArrayList<>();
            for (GoodsType type : goodsTypeList) {
                typeIdList.add(type.getTypeId());
            }

            if (typeIdList.size() > 0) {
                String str = StringUtils.join(typeIdList, ",");
                queryModel.addHqlCondition("g.typeId IN (" + str + ")");
            }
        }

        if (StringUtils.isNotBlank(orderBy)) {
            queryModel.setSortHql(orderBy);
        } else {
            queryModel.setSortHql(" g.goodsId asc");
        }

        if (pageNo != null && pageSize != null) {
            queryModel.setPageNo(pageNo);
            queryModel.setPageSize(pageSize);
        }

        List<GoodsExt> goodsList = goodsDao.searchGoodsList(queryModel, paramObject);


        List<Long> goodsIdList = new ArrayList<>();
        for (GoodsExt goodsExt : goodsList) {
            goodsIdList.add(goodsExt.getGoodsId());
        }

        if (goodsIdList.size() <= 0) {
            return goodsList;
        }

        if (hotelId == null) {
            return goodsList;
        }

        if (StringUtils.isBlank(channelCode)) {
            channelCode = Constants.CHANNEL_CODE_ONLINE;
        }

        //根据酒店id查询该酒店设置的渠道价格
        QueryModel query = new QueryModel();
        query.addColumnValueCondition("co.objectId", hotelId); //渠道对象的id
        query.addColumnValueCondition("co.objectType", Constants.CHANNELOBJECT_TYPE_HOTEL); //渠道对象类型
        query.addColumnValueCondition("co.status", Constants.CHANNELOBJECT_STATUS_AVAIL); //渠道对象状态
        query.addColumnValueCondition("c.channelCode", channelCode);
        String str = StringUtils.join(goodsIdList, ",");
        query.addColumnValueCondition("cgp.goodsId", QueryModel.OPERATOR_IN, "(" + str + ")"); //商品ids
        //queryModel.addHqlCondition("cgp.goodsId IN (" + str + ")");
        List<ChannelGoodsPrice> priceList = goodsPriceDao.searchChannelGoodsPriceList(query);

        Map<Long, ChannelGoodsPrice> priceMap = new HashMap<>();

        //取最小值对象
        for (ChannelGoodsPrice price : priceList) {

            boolean flag = true;

            if (priceMap.containsKey(price.getGoodsId())) {
                ChannelGoodsPrice oldPrice = priceMap.get(price.getGoodsId());

                if (oldPrice.getSellPrice().compareTo(price.getSellPrice()) == -1) {
                    flag = false;
                }

            }

            if (flag) {
                priceMap.put(price.getGoodsId(), price);
            }

        }

        //如果酒店有设置商品单独的价格则取设置的价格，否则取默认
        for (GoodsExt goodsExt : goodsList) {

            if (priceMap.containsKey(goodsExt.getGoodsId())) {

                ChannelGoodsPrice price = priceMap.get(goodsExt.getGoodsId());
                goodsExt.setPrice(price.getSellPrice());
                goodsExt.setChannelPriceId(price.getPriceId());
            }

        }

        return goodsList;
    }

    /**
     * 根据id批量删除商品
     *
     * @param ids
     * @return count
     */
    @Override
    public int deleteGoods(Long[] ids) {
        QueryModel queryModel =new QueryModel();
            String s = StringUtils.join(ids, ",");
            queryModel.addColumnValueCondition("id", QueryModel.OPERATOR_IN, "(" + s + ")");
            List <Goods> goodsList =goodsDao.search(queryModel);
        if (goodsList !=null && goodsList.size()>0){

            for (Goods good:goodsList){
                good.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
                goodsDao.save(good);
            }
        }else {
            return 0;
        }
        return goodsList.size();
    }

    /**
     * 保存商品
     *
     * @param goods
     * @return
     */
    @Override
    public Goods saveGoods(Goods goods) {
        goods.setUpdateTime(new Date());
        String metaDescription = goods.getMetaDescription();
        if (StringUtils.isNotBlank(metaDescription)) {
            metaDescription = metaDescription.replace("\n", "<br/>");
            goods.setMetaDescription(metaDescription);
        }
        Category category = categoryDao.get(goods.getCateId());
        goods.setTypeId(category.getTypeId());

        goods = goodsDao.save(goods);
        return goods;
    }

    /**
     * 创建商品
     *
     * @param goods
     * @param list
     * @return
     */
    @Transactional
    @Override
    public Goods createGoods(Goods goods, List<GoodsGallery> list) {
        goods.setCreateTime(new Date());
        goods.setDeleteFlag(Constants.FLAG_FALSE);//删除标志默认为否
        String metaDescription = goods.getMetaDescription();
        if (StringUtils.isNotBlank(metaDescription)) {
            metaDescription = metaDescription.replace("\n", "<br/>");
            goods.setMetaDescription(metaDescription);
        }
        Category category = categoryDao.get(goods.getCateId());
        goods.setTypeId(category.getTypeId());

        goods = goodsDao.save(goods);

        Long goodsId = goods.getGoodsId();
        Product product = productDao.getProductByGoodsId(goodsId);
        if (product == null) {
            product = new Product();
        }
        //填充货品属性
        product.setGoodsId(goods.getGoodsId());
        product.setProductName(goods.getGoodsName());
        product.setCost(goods.getCost());
        product.setMktprice(goods.getMktprice());
        product.setWeight(goods.getWeight());
        product.setUnit(goods.getUnit());
        product.setCreateTime(new Date());
        productDao.save(product);

        //保存商品相册
        if (list != null && list.size() > 0) {
            for (GoodsGallery gallery : list) {
                gallery.setGoodsId(goodsId);
                goodsGalleryDao.save(gallery);
            }
        }

        return goods;
    }

    /**
     * 商品下单数+1
     *
     * @param goodsIdList
     * @return
     */
    @Override
    public ReturnObject saveGoodsOrderCount(List<Long> goodsIdList) {
        logger.info("call saveGoodsOrderCount({\"goodsIdList:\"" + JsonUtil.JSON_List2String(goodsIdList) + "})");

        ReturnObject ret = new ReturnObject();

        QueryModel queryModel = new QueryModel();
        String str = StringUtils.join(goodsIdList, ",");
        queryModel.addColumnValueCondition("goodsId", QueryModel.OPERATOR_IN, "(" + str + ")"); //商品ids
        List<Goods> goodsList = goodsDao.search(queryModel);

        for (Goods goods : goodsList) {
            Integer orderCount = goods.getOrderCount();

            orderCount = (orderCount == null ? 0 : orderCount);

            orderCount = orderCount + 1;

            goods.setOrderCount(orderCount);

            goodsDao.save(goods);

        }

        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("商品下单数加1操作成功");

        return ret;
    }

    /**
     * 上下架设置
     *
     * @param goodsId
     * @param enable
     * @return
     */
    @Override
    public int setMarketEnable(Long goodsId, String enable) {
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("id",goodsId);
        List<Goods> goodsList = goodsDao.search(queryModel);
        for (Goods goods : goodsList){
            goods.setMarketEnable(enable);
            goods.setGoodsId(goodsId);
            goodsDao.save(goods);
        }
        return goodsList.size();
    }

    /**
     * 保存商品
     *
     * @param goods
     * @param list
     * @return
     */
    @Override
    public Goods saveGoods(Goods goods, List<GoodsGallery> list) {

        goods = this.saveGoods(goods);

        if (list != null && list.size() > 0) {
            for (GoodsGallery gallery : list) {
                //如果存在则修改图片ID
                if (gallery.getGalleryId() != null) {
                    GoodsGallery gallery1 = goodsGalleryDao.get(gallery.getGalleryId());
                    gallery1.setPicId(gallery.getPicId());
                    goodsGalleryDao.save(gallery1);
                } else {
                    //如果不存在新增相册数据
                    gallery.setGoodsId(goods.getGoodsId());
                    goodsGalleryDao.save(gallery);
                }

            }
        }
        return goods;
    }

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    @Override
    public void saveSort(Map<Long, Integer> sortMap) {
        Goods goods = null;
        for (Map.Entry<Long, Integer> entry : sortMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Long goodsId = Long.valueOf((String) key);
            Integer sort = Integer.valueOf((String) value);
            goods = goodsDao.get(goodsId);
            if (null != goods) {
                goods.setSort(sort);
                goodsDao.save(goods);
            }
        }
    }

    /**
     * 根据cateId判断商品是否存在
     *
     * @param cateId
     * @return
     */
    @Override
    public Integer getGoodsIsExistByCategoryId(Long cateId) {
        Integer recount = goodsDao.getGoodsIsExistByCategoryId(cateId);
        return recount;
    }
}