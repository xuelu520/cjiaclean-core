/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsStoreServiceImpl.java
 * Author:   chenli
 * Date:     2016-04-01 16:07:33
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-01 16:07:33> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.alibaba.dubbo.common.json.JSONObject;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.goods.manager.GoodsStoreManager;
import com.huazhu.hvip.product.goods.model.GoodsStore;
import com.huazhu.hvip.product.goods.model.extend.ChangeStoreInfo;
import com.huazhu.hvip.product.service.GoodsStoreService;
import com.huazhu.hvip.product.vo.ChangeGoodsStoreVO;
import com.huazhu.hvip.product.vo.ChangeStoreInfoVO;
import com.huazhu.hvip.product.vo.GoodsStoreVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
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

public class GoodsStoreServiceImpl implements GoodsStoreService {

    private static Logger logger = LogManager.getLogger(GoodsServiceImpl.class);

    private GoodsStoreManager goodsStoreManager;

    @Autowired
    public void setGoodsStoreManager(GoodsStoreManager goodsStoreManager) {
        this.goodsStoreManager = goodsStoreManager;
    }

    /**
     * 根据商品id查询商品库存表
     *
     * @param goodsIdList
     * @return
     */
    @Override
    public ReturnObject<GoodsStoreVO> searchGoodsStore(Long hotelId, List<Long> goodsIdList) {
        logger.info("call searchGoodsListByGoodsIdList({\"hotelId:\"" + hotelId + "},{\"\":" + JsonUtil.JSON_List2String(goodsIdList) + "})");

        ReturnObject<GoodsStoreVO> returnObject = new ReturnObject<>();

        List<GoodsStoreVO> goodsStoreVOList = new ArrayList<>();
        GoodsStoreVO goodsStoreVO = null;

        ParamObject paramObject = new ParamObject();
        paramObject.add("hotelId", hotelId);
        paramObject.add("goodsIdList", goodsIdList);
        try {
            List<GoodsStore> goodsStores = goodsStoreManager.searchGoodsStoreList(paramObject);

            for (GoodsStore goodsStore : goodsStores) {
                goodsStoreVO = new GoodsStoreVO();
                BeanUtils.copyProperties(goodsStore, goodsStoreVO);
                goodsStoreVOList.add(goodsStoreVO);
            }


            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (BeansException e) {
            logger.error("查询该酒店已开通的商品库存失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        returnObject.setDataList(goodsStoreVOList);
        return returnObject;
    }

    /**
     * 更新或保存商品库存
     *
     * @param hotelId
     * @param goodsStoreMap
     * @return
     */
    @Override
    public ReturnObject updateGoodsStore(Long hotelId, Map<Long, Integer> goodsStoreMap) {
        logger.info("call searchGoodsListByGoodsIdList({},{},{})", hotelId, JsonUtil.JSON_List2String(goodsStoreMap));

        ParamObject paramObject = new ParamObject();
        paramObject.add("hotelId", hotelId);
        paramObject.add("goodsStoreMap", goodsStoreMap);

        ReturnObject ret = new ReturnObject();
        try {
            ret = goodsStoreManager.updateGoodsStore(paramObject);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("修改商品库存成功");
            return ret;
        } catch (Exception e) {
            logger.error("修改商品库存失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("修改商品库存成功");
            return ret;
        }

    }

    /**
     * 改变商品库存，适用于下单、取消、退款等商品库存的变化
     *
     * @param changeGoodsStoreVO
     * @return
     */
    @Override
    public ReturnObject changeGoodsStore(ChangeGoodsStoreVO changeGoodsStoreVO) {
        logger.info("call changeGoodsStore({\"changeGoodsStoreVO:\"" + JsonUtil.JSON_Bean2String(changeGoodsStoreVO) + "}");

        ReturnObject ret = new ReturnObject();
        try {
            Long hotelId = changeGoodsStoreVO.getHotelId();
            List<ChangeStoreInfoVO> changeStoreInfoVOList = changeGoodsStoreVO.getChangeStoreInfoVOList();
            OperatorInfo operatorInfo = changeGoodsStoreVO.getOperatorInfo();

            //根据酒店id得到该酒店已设置过的商品库存信息列表
            ParamObject paramObject = new ParamObject();
            paramObject.add("hotelId", hotelId);
            List<GoodsStore> goodsStoreList = goodsStoreManager.searchGoodsStoreList(paramObject);

            if (goodsStoreList == null || goodsStoreList.size() <= 0) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("该酒店没有设置商品库存信息");
                return ret;
            }

            Map<Long, GoodsStore> gsMap = new HashMap<>();

            for (GoodsStore goodsStore : goodsStoreList) {
                if (!gsMap.containsKey(goodsStore.getGoodsId())) {
                    gsMap.put(goodsStore.getGoodsId(), goodsStore);
                }
            }

            List<GoodsStore> newGoodsStoreList = new ArrayList<>();
            Map<Long, ChangeStoreInfo> csMap = new HashMap<>();
            GoodsStore goodsStore = null;
            ChangeStoreInfo changeStoreInfo = null;
            for (ChangeStoreInfoVO changeStoreInfoVO : changeStoreInfoVOList) {

                goodsStore = gsMap.get(changeStoreInfoVO.getGoodsId());

                if (goodsStore != null) {
                    changeStoreInfo = new ChangeStoreInfo();
                    BeanUtils.copyProperties(changeStoreInfoVO, changeStoreInfo);

                    csMap.put(goodsStore.getGoodsStoreId(), changeStoreInfo);

                    newGoodsStoreList.add(goodsStore);
                }

            }

            ret = goodsStoreManager.changeGoodsStore(newGoodsStoreList, csMap, operatorInfo);

        } catch (Exception e) {
            logger.error("修改商品库存失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("修改商品库存成功");
        }

        return ret;
    }

    /**
     * 删除酒店下的所有ID
     *
     * @param hotelId
     */
    @Override
    public ReturnObject removeHotelGoodStore(String hotelId) {
        logger.info("call removeHotelGoodStore({" + hotelId + "}");
        ReturnObject returnObject = new ReturnObject();
        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("hotelId", hotelId);
            goodsStoreManager.removeHotelGoodStore(paramObject);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage());
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 删除分类下的库存
     *
     * @param hotelId
     * @param cateIds
     * @return
     */
    @Override
    public ReturnObject removeHotelGoodStoreByCateId(String hotelId, List<String> cateIds) {
        logger.info("call removeHotelGoodStoreByCateId("+hotelId+","+JsonUtil.JSON_List2String(cateIds));
        ReturnObject ret=new ReturnObject();
        try {
            ParamObject paramObject=new ParamObject();
            paramObject.add("hotelId",hotelId);
            paramObject.add("cateIds",cateIds);
            goodsStoreManager.removeHotelGoodStoreByCateId(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }
}
