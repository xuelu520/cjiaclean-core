/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCateManagerImpl.java
 * Author:   chenli
 * Date:     2016-03-23 17:32:28
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:32:28> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelCateDao;
import com.huazhu.hvip.operation.dao.HotelGoodsDao;
import com.huazhu.hvip.operation.manager.HotelCateManager;
import com.huazhu.hvip.operation.model.HotelCate;
import com.huazhu.hvip.operation.model.HotelGoods;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("hotelCateManager")
public class HotelCateManagerImpl extends GenericManagerImpl<HotelCate, Long> implements HotelCateManager {

    private HotelCateDao hotelCateDao;

    @Autowired
    public HotelCateManagerImpl(HotelCateDao hotelCateDao) {
        super(hotelCateDao);
        this.hotelCateDao = hotelCateDao;
    }

    @Autowired
    private HotelGoodsDao hotelGoodsDao;

    /**
     * 更新酒店商品分类
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject updateOpenCateByHotelId(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        List<String> cateIdList = new ArrayList<>();
        Map<Long, String> cateMap = (Map<Long, String>) paramObject.getParam("cateMap");
        Long hotelId = paramObject.getLongParam("hotelId");
        boolean appendFlag = (boolean) paramObject.getParam("appendFlag");

        Map<Long, HotelCate> hotelCateMap = new HashMap<>();

        //如果是追加，则原始数据不变，增加新的分类
        if (appendFlag) {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelId", hotelId);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<HotelCate> hotelCateList = hotelCateDao.search(queryModel);
            for (HotelCate hotelCate : hotelCateList) {
                cateIdList.add(hotelCate.getCateId().toString());
                hotelCateMap.put(hotelCate.getCateId(), hotelCate);
            }
        } else {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelId", hotelId);
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<HotelCate> hotelCateList = hotelCateDao.search(queryModel);
            for (HotelCate hotelCate : hotelCateList) {
                hotelCateDao.remove(hotelCate);
            }
        }
        HotelCate cate = null;
        Iterator it = cateMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Long cateId = Long.valueOf(key.toString());
            String valueChange = value.toString();
            cateIdList.add(cateId.toString());
            cate = hotelCateMap.get(cateId);
            if (cate == null) {
                cate = new HotelCate();
                cate.setCateId(cateId);
                cate.setCateName(valueChange);
                cate.setHotelId(hotelId);
                cate.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
                hotelCateDao.save(cate);
            }
        }
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("hotelId", hotelId);
        List<HotelGoods> hotelGoodsList = hotelGoodsDao.search(queryModel);
        for (HotelGoods hotelGoods : hotelGoodsList) {
            if (!cateIdList.contains(hotelGoods.getCateId().toString())) {
                hotelGoodsDao.remove(hotelGoods);
            }
        }
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        return ret;
    }

    /**
     * 根据酒店Id查询酒店开通的类型
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<HotelCate> searchByhotelIdList(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        List<String> hotelIdList= (List<String>) paramObject.getParam("hotelIdList");
        String hotelId=StringUtils.join(hotelIdList,",");
        if(StringUtils.isNotEmpty(hotelId)){
            queryModel.addHqlCondition(" hotelId in ("+hotelId+")");
        }
        List<HotelCate> hotelCateList=hotelCateDao.search(queryModel);
        return hotelCateList;
    }
}
