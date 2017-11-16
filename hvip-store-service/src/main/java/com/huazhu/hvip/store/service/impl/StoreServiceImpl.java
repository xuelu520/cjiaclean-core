/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-23 16:14:20
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 16:14:20> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.store.manager.StoreManager;
import com.huazhu.hvip.store.model.Store;
import com.huazhu.hvip.store.request.EditStoreVO;
import com.huazhu.hvip.store.request.SaveStoreVO;
import com.huazhu.hvip.store.service.StoreService;
import com.huazhu.hvip.store.request.AddStoreVO;
import com.huazhu.hvip.store.vo.StoreVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service("storeService")
public class StoreServiceImpl implements StoreService {

    private static Logger logger = LogManager.getLogger(StoreServiceImpl.class);

    private StoreManager storeManager;

    @Autowired
    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    /**
     * 根据店铺id获取店铺详情
     *
     * @param storeId
     * @return
     */
    @Override
    public ReturnObject<EditStoreVO> getStoreDetail(Long storeId) {
        logger.info("call getStoreDetail({\"storeId:\"" + storeId + "})");

        ReturnObject<EditStoreVO> returnObject = new ReturnObject<>();

        try {
            Store store = storeManager.get(storeId);

            if (store == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("未查询到店铺信息");
            }

            EditStoreVO editStoreVO = new EditStoreVO();

            BeanUtils.copyProperties(store, editStoreVO);

            returnObject.setData(editStoreVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("获取店铺详情失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        return returnObject;
    }

    /**
     * 查询店铺列表，或根据店铺状态查询店铺，或者店铺名字查询店铺
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<StoreVO> seachStorelList(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject<>();
        Object object = paramObject;
        try {
            ReturnObject<Store> returnObject = storeManager.searchStoreList(paramObject);

            List<Store> list = returnObject.getDataList();

            List<StoreVO> voList = new ArrayList<StoreVO>();

            for (Store stores : list) {
                StoreVO storeVO = new StoreVO();
                BeanUtils.copyProperties(stores, storeVO);
                voList.add(storeVO);
            }
            Integer totalNum = paramObject.getTotalNum();
            Integer totalPageNum = paramObject.getTotelPageNum();
            ret.setTotalSize(totalNum);
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 修改店铺状态
     *
     * @param storeId
     * @param storeStatusFlag
     * @return
     */
    @Override
    public ReturnObject<StoreVO> updateStoreStatus(Long storeId, String storeStatusFlag) {
        logger.info("call updateVipFlag({\"storeId:\"" + storeId + "\"storeStatusFlag:\"\" + storeStatusFlag + \"})");

        ReturnObject returnObject = new ReturnObject();

        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("storeStatusFlag", storeStatusFlag);
            paramObject.add("storeId", storeId);
            Integer changeNo = storeManager.updateStoreStatus(paramObject);
            if (null == changeNo || changeNo == 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("更新失败");
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setReturnMsg("更新成功");
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("更新失败");
        }
        return returnObject;
    }

    /**
     * 修改并保存店铺排序
     *
     * @param sortMap key:StoreId value:sortNo
     * @return
     */
    @Override
    public ReturnObject<StoreVO> saveSort(Map<Long,Integer> sortMap){
        logger.info("call saveOpenCateByHotelId({\"sortMap:\"" + JsonUtil.JSON_Bean2String(sortMap) + "})");
        ReturnObject ret = new ReturnObject();
        ParamObject paramObject = new ParamObject();
        paramObject.setParamMap(sortMap);
        try {
            ReturnObject<Store> returnObject = storeManager.saveSort(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 新增店铺
     *
     * @param saveStoreVO
     * @return
     */
    @Override
    public ReturnObject<AddStoreVO> createStore(SaveStoreVO saveStoreVO) {
        logger.info("call createStore({\"saveStoreVO:\"" + saveStoreVO.toString() + "})");

        ReturnObject<AddStoreVO> ret = new ReturnObject<AddStoreVO>();

        try {
            AddStoreVO addStoreVO = saveStoreVO.getAddStoreVO();
            Store store = new Store();
            BeanUtils.copyProperties(addStoreVO, store);

            //创建店铺
            store = storeManager.saveStore(store);
            BeanUtils.copyProperties(store, addStoreVO);
            ret.setData(addStoreVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("创建商品成功");
        } catch (BeansException e) {
            logger.error("创建店铺失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("创建店铺失败");
        }


        return ret;
    }

    /**
     * 修改店铺
     *
     * @param saveStoreVO
     * @return
     */
    @Override
    public ReturnObject<EditStoreVO> saveStore(SaveStoreVO saveStoreVO) {
        logger.info("call saveStore({\"saveStoreVO:\"" + saveStoreVO.toString() + "})");

        ReturnObject<EditStoreVO> ret = new ReturnObject<EditStoreVO>();

        try {
            EditStoreVO editStoreVO = saveStoreVO.getEditStoreVO();
            Long storeId = editStoreVO.getStoreId();

            Store store = storeManager.get(storeId);

            if(null != store) {
                BeanUtils.copyProperties(editStoreVO, store);
            }

            store = storeManager.saveStore(store);
            BeanUtils.copyProperties(store,editStoreVO);

            ret.setData(editStoreVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("修改店铺成功");
        } catch (BeansException e) {
            logger.error("修改店铺失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("修改店铺失败");
        }
        return ret;
    }
}
