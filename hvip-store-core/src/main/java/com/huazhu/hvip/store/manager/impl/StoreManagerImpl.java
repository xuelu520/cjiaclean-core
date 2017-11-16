/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreManagerImpl.java
 * Author:   chenli
 * Date:     2016-03-23 15:43:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 15:43:36> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.store.dao.StoreDao;
import com.huazhu.hvip.store.manager.StoreManager;
import com.huazhu.hvip.store.model.Store;
import com.huazhu.hvip.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service("storeManager")
public class StoreManagerImpl extends GenericManagerImpl<Store, Long> implements StoreManager {

    private StoreDao storeDao;
    private ParamObject paramObject;

    @Autowired
    public StoreManagerImpl(StoreDao storeDao) {
        super(storeDao);
        this.storeDao = storeDao;
    }

    /**
     * 查询不同条件的店铺
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<Store> searchStoreList(ParamObject paramObject) {
        ReturnObject<Store> ret = new ReturnObject<>();

        this.paramObject = paramObject;

        QueryModel queryModel = new QueryModel();

        Integer pageSize = (Integer) paramObject.getPageSize();

        Integer pageNo = (Integer) paramObject.getPageNo();

        String status = paramObject.getStringParam("status");

        String storeName = paramObject.getStringParam("storeName");

        String sort = paramObject.getStringParam("sort");

        String order = paramObject.getStringParam("order");

        queryModel.setPageNo(pageNo);

        queryModel.setPageSize(pageSize);

        if(status != null && storeName != null){

            queryModel.addColumnValueCondition("storeName",QueryModel.OPERATOR_LIKE, storeName);
            queryModel.addColumnValueCondition("status",QueryModel.OPERATOR_EQ, status);
        }else if (status != null && null == storeName) {

            queryModel.addColumnValueCondition("status",QueryModel.OPERATOR_EQ, status);
        }else if (null == status && storeName != null){

            queryModel.addColumnValueCondition("storeName",QueryModel.OPERATOR_LIKE, storeName);
        }

        if(!StringUtil.isEmpty(sort) && !StringUtil.isEmpty(order)){
            queryModel.setSortHql(sort+" "+order);
        }


        List<Store> hotels = storeDao.search(queryModel);
        //List<Hotel> hotels = hotelDao.searchHotelList(queryModel);

        paramObject.setTotalNum(queryModel.getTotalNum());

        Integer totelPageNum = paramObject.getTotelPageNum();

        ret.setDataList(hotels);
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("获取店铺信息成功");

        return ret;
    }

    /**
     * 修改店铺状态
     *
     * @param paramObject
     * @return
     */
    @Override
    public Integer updateStoreStatus(ParamObject paramObject) {
        String storeStatusFlag = paramObject.getStringParam("storeStatusFlag");
        Long storeId = paramObject.getLongParam("storeId");
        Integer changeNo;
        if (null != storeId) {
            Store st = storeDao.get(storeId);
            if (st != null) {
                st.setStatus(storeStatusFlag);
                storeDao.save(st);
                return 1;
            } else {
                return 0;
            }
        }
        return null;
    }

    /**
     * 保存修改后的排序值
     *
     * @param paramObject
     * @return
     */
    @Transactional
    @Override
    public ReturnObject<Store> saveSort(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        Map<Long,Integer> map =  paramObject.getParamMap();
        Long hotelId = paramObject.getLongParam("hotelId");


        Store stores = null;
        stores = new Store();

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Long storeId = Long.valueOf(key.toString());
            Integer sort = Integer.valueOf(value.toString());
            //stores.setStoreId(storeId);
            stores = storeDao.get(storeId);
            if(null != stores){
                stores.setSort(sort);
                storeDao.save(stores);
            }

        }


        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);

        return ret;
    }

    /**
     * 保存店铺
     *
     * @param store
     * @return
     */
    @Override
    public Store saveStore(Store store) {

        Long storeId = store.getStoreId();

        store = storeDao.save(store);

        return store;
    }
}
