/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreService.java
 * Author:   chenli
 * Date:     2016-03-23 15:56:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 15:56:52> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.store.request.AddStoreVO;
import com.huazhu.hvip.store.request.EditStoreVO;
import com.huazhu.hvip.store.request.SaveStoreVO;
import com.huazhu.hvip.store.vo.StoreVO;

import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service
public interface StoreService {

    /**
     * 根据店铺id获取店铺详情
     *
     * @param storeId
     * @return
     */
    public ReturnObject<EditStoreVO> getStoreDetail(Long storeId);

    /**
     * 查询店铺列表，或根据店铺状态查询店铺，或者店铺名字查询店铺
     *
     * @param paramObject
     * @return
     */
    public ReturnObject<StoreVO> seachStorelList(ParamObject paramObject);

    /**
     * 修改店铺状态
     *
     * @param storeId
     * @param storeStatusFlag
     * @return
     */
    public ReturnObject<StoreVO> updateStoreStatus(Long storeId,String storeStatusFlag);

    /**
     * 修改并保存店铺排序
     *
     * @param sortMap key:StoreId value:sortNo
     * @return
     */
    public ReturnObject<StoreVO> saveSort(Map<Long,Integer> sortMap);

    /**
     * 新增店铺
     *
     * @param saveStoreVO
     * @return
     */
    public ReturnObject<AddStoreVO> createStore(SaveStoreVO saveStoreVO);

    /**
     * 修改店铺
     *
     * @param saveStoreVO
     * @return
     */
    public ReturnObject<EditStoreVO> saveStore(SaveStoreVO saveStoreVO);
}
