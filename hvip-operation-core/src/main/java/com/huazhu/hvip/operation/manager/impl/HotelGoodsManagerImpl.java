/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelGoodsManagerImpl.java
 * Author:   chenli
 * Date:     2016-03-23 17:31:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:31:51> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelGoodsDao;
import com.huazhu.hvip.operation.manager.HotelGoodsManager;
import com.huazhu.hvip.operation.model.HotelGoods;
import com.huazhu.hvip.operation.model.extend.OpenGoodsInfo;
import com.huazhu.hvip.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
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
@Service("hotelGoodsManager")
public class HotelGoodsManagerImpl extends GenericManagerImpl<HotelGoods, Long> implements HotelGoodsManager {

    private HotelGoodsDao hotelGoodsDao;

    @Autowired
    public HotelGoodsManagerImpl(HotelGoodsDao hotelGoodsDao) {
        super(hotelGoodsDao);
        this.hotelGoodsDao = hotelGoodsDao;
    }

    /**
     * 更新酒店商品
     *
     * @param paramObject
     * @return
     */
    @Transactional
    @Override
    public ReturnObject updateOpenGoodsByHotelId(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        Map<Long, String> goodsMap = (Map<Long, String>) paramObject.getParam("goodsMap");
        Long hotelId = paramObject.getLongParam("hotelId");
        boolean appendFlag = (boolean) paramObject.getParam("appendFlag");

        Map<Long, HotelGoods> hotelGoodsMap = new HashMap<>();

        //如果是追加，则原始数据不变，增加新的商品
        if (appendFlag) {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelId", hotelId);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<HotelGoods> hotelGoodsList = hotelGoodsDao.search(queryModel);

            for (HotelGoods hotelGoods : hotelGoodsList) {
                hotelGoodsMap.put(hotelGoods.getGoodsId(), hotelGoods);
            }

        } else {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelId", hotelId);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<HotelGoods> hotelCateList = hotelGoodsDao.search(queryModel);
            for (HotelGoods hotelGoods : hotelCateList) {
                //hotelGoods.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
                //hotelGoodsDao.save(hotelGoods);
                hotelGoodsDao.remove(hotelGoods);
            }
        }

        HotelGoods goods = null;

        Iterator it = goodsMap.entrySet().iterator();
        OpenGoodsInfo openGoodsInfo = new OpenGoodsInfo();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Long goodsId = Long.valueOf(key.toString());

            if (value != null) {
                openGoodsInfo = (OpenGoodsInfo) JsonUtil.JSON_String2Bean(value.toString(), OpenGoodsInfo.class);
            }
            goods = hotelGoodsMap.get(goodsId);
            if (goods == null) {
                goods = new HotelGoods();
            }
            goods.setCateId(openGoodsInfo.getCateId());
            goods.setGoodsId(goodsId);
            goods.setGoodsName(openGoodsInfo.getGoodsName());
            goods.setOpenChannel(openGoodsInfo.getOpenChannel());
            goods.setHotelId(hotelId);
            goods.setAdjustPriceFlag(openGoodsInfo.getAdjustPriceFlag());
            goods.setSort(openGoodsInfo.getSort());
            goods.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
            hotelGoodsDao.save(goods);
        }
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        return ret;
    }

    /**
     * 通过商品的Id查询酒店的订单
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<HotelGoods> searchHotelByGoodsId(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        queryModel.addColumnValueCondition("goodsId",paramObject.getLongParam("goodsId"));
        queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
        List<HotelGoods> hotelGoodsList=hotelGoodsDao.search(queryModel);
        return hotelGoodsList;
    }

    /**
     * 更改hotelCateId
     * @param paramObject
     */
    @Override
    public void updateCateIdByGoodsId(ParamObject paramObject) {
        StringBuffer sql=new StringBuffer();
        sql.append("UPDATE hotelgoods hg SET hg.cateId="+paramObject.getLongParam("cateId")+" WHERE hg.goodsId="+paramObject.getLongParam("goodsId")+"");
        hotelGoodsDao.updateObject(sql.toString());
    }
}
