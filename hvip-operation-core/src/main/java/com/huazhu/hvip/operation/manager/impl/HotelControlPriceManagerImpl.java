/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelControlPriceManagerImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-06-13 17:02:59
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-06-13 17:02:59><version><desc>
 */

package com.huazhu.hvip.operation.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.operation.dao.HotelControlPriceDao;
import com.huazhu.hvip.operation.manager.HotelControlPriceManager;
import com.huazhu.hvip.operation.model.HotelControlPrice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("hotelControlPriceManager")
public class HotelControlPriceManagerImpl extends GenericManagerImpl<HotelControlPrice, Long> implements HotelControlPriceManager {

    private HotelControlPriceDao hotelControlPriceDao;

    @Autowired
    public HotelControlPriceManagerImpl(HotelControlPriceDao hotelControlPriceDao) {
        super(hotelControlPriceDao);
        this.hotelControlPriceDao = hotelControlPriceDao;
    }
    /**
     * OP查询门店申请表格数据
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<HotelControlPrice> searchApplyManagerList(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        String keyword=paramObject.getStringParam("keyword");
        Integer page=Integer.valueOf(paramObject.getStringParam("page"));
        Integer row=Integer.valueOf(paramObject.getStringParam("row"));
        String beginTime=paramObject.getStringParam("beginDate");
        String endTime=paramObject.getStringParam("endDate");
        if (StringUtils.isNotBlank(keyword)) {
            queryModel.addHqlCondition(" (hotelName like '%" + keyword + "%' or hotelNo like '%" + keyword + "%' ) ");
        }
        if (StringUtils.isNotBlank(beginTime)) {
            queryModel.addHqlCondition(" createTime >= '" + beginTime + " 00:00:00' ");
        }
        if (StringUtils.isNotBlank(endTime)) {
            queryModel.addHqlCondition(" createTime <= '" + endTime + " 23:59:59' ");
        }
        queryModel.addColumnValueCondition("status",paramObject.getStringParam("status"));
        queryModel.setSortHql("createTime desc");
        queryModel.setPageNo(page);
        queryModel.setStartRecorder(page);
        queryModel.setPageSize(row);
        List<HotelControlPrice>hotelControlPriceList= hotelControlPriceDao.search(queryModel);
        paramObject.setTotalNum(queryModel.getTotalNum());
        return  hotelControlPriceList;
    }
}
