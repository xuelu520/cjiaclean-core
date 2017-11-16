/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelManagerImpl.java
 * Author:   chenli
 * Date:     2016-03-23 17:30:29
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:30:29> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelCateDao;
import com.huazhu.hvip.operation.dao.HotelDao;
import com.huazhu.hvip.operation.dao.HotelGoodsDao;
import com.huazhu.hvip.operation.manager.HotelManager;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.model.HotelCate;
import com.huazhu.hvip.operation.model.HotelGoods;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class HotelManagerImpl extends GenericManagerImpl<Hotel, Long> implements HotelManager {

    private HotelDao hotelDao;


    @Autowired
    public HotelManagerImpl(HotelDao hotelDao) {
        super(hotelDao);
        this.hotelDao = hotelDao;
    }
    @Autowired
    private HotelGoodsDao hotelGoodsDao;

    @Autowired
    private HotelCateDao hotelCateDao;

    @Override
    public ReturnObject<Hotel> searchHotelList(ParamObject paramObject) {
        ReturnObject<Hotel> ret = new ReturnObject<>();

        String keyword = paramObject.getStringParam("keyword");

        String sort = paramObject.getStringParam("sort");

        String order = paramObject.getStringParam("order");

        List<String> hotelIdList = (List<String>) paramObject.getParam("hotelIdList");
        QueryModel queryModel = new QueryModel();

        if(paramObject.getPageNo()!=null && paramObject.getPageSize()!=null){
            queryModel.setPageNo(paramObject.getPageNo());
            queryModel.setPageSize(paramObject.getPageSize());
        }

        if(hotelIdList!=null && hotelIdList.size()>0){
            String id=StringUtils.join(hotelIdList,",");
            queryModel.addHqlCondition(" hotelId in ("+id+")");
        }

        if (!StringUtil.isEmpty(keyword)) {
            queryModel.addHqlCondition(" (hotelName like '%" + keyword + "%' or enName like '%" + keyword + "%' or hotelUniqueNo like '%" + keyword + "%' or hotelNo like '%" + keyword + "%') ");
        }

        if (!StringUtil.isEmpty(sort) && !StringUtil.isEmpty(order)) {
            queryModel.setSortHql(sort + " " + order);
        }

        queryModel.addColumnValueCondition("status", paramObject.getStringParam("status"));
        queryModel.addColumnValueCondition("mgrModel", paramObject.getStringParam("mgrModel"));
        queryModel.addColumnValueCondition("openVipFlag", paramObject.getStringParam("openVipFlag"));

        List<Hotel> hotels = hotelDao.search(queryModel);

        paramObject.setTotalNum(queryModel.getTotalNum());

        Integer totelPageNum = paramObject.getTotelPageNum();

        ret.setDataList(hotels);
        ret.setTotalSize(totelPageNum);
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("获取酒店信息成功");

        return ret;
    }

    /**
     * 根据参数查询酒店信息
     *
     * @param paramObject
     * @return
     */
    @Override
    public Hotel getHotelByParam(ParamObject paramObject) {

        String hotelUniqueNo = paramObject.getStringParam("hotelUniqueNo");
        String hotelNo = paramObject.getStringParam("hotelNo");
        String hotelId = paramObject.getStringParam("hotelId");
        QueryModel queryModel = new QueryModel();

        if (StringUtils.isNotBlank(hotelUniqueNo)) {
            queryModel.addColumnValueCondition("hotelUniqueNo", hotelUniqueNo);
        }

        if (StringUtils.isNotBlank(hotelNo)) {
            queryModel.addColumnValueCondition("hotelNo", hotelNo);
        }
            queryModel.addColumnValueCondition("hotelId",hotelId);
        Hotel hotel = hotelDao.getHotelByParam(queryModel);

        return hotel;
    }

    /**
     * 更新酒店私人定制状态
     *
     * @param paramObject
     * @return
     */
    @Override
    public Integer updateHotelVipFlag(ParamObject paramObject) {
        String openVipFlag = paramObject.getStringParam("openVipFlag");
        Long hotelId = paramObject.getLongParam("hotelId");
        Integer changeNo;
        if (null != hotelId) {
            Hotel ht = hotelDao.get(hotelId);
            if (ht != null) {
                if(openVipFlag.equals("1")){
                    ht.setOpenVipFlag(openVipFlag);
                    hotelDao.save(ht);
                    return 1;
                }else {
                    QueryModel queryModel=new QueryModel();
                    queryModel.addColumnValueCondition("hotelId",hotelId);
                    List<HotelGoods> hotelGoodsList=hotelGoodsDao.search(queryModel);
                    if(hotelGoodsList!=null && hotelGoodsList.size()>0){
                        for(HotelGoods hotelGoods:hotelGoodsList){
                            hotelGoodsDao.remove(hotelGoods);
                        }
                    }
                    List<HotelCate> hotelCateList=hotelCateDao.search(queryModel);
                    if(hotelCateList!=null && hotelCateList.size()>0){
                        for(HotelCate hotelCate:hotelCateList){
                            hotelCateDao.remove(hotelCate);
                        }
                    }
                    ht.setOpenVipFlag(openVipFlag);
                    hotelDao.save(ht);
                    return 1;
                }
            } else {
                return 0;
            }
        }
        return null;
    }
}
