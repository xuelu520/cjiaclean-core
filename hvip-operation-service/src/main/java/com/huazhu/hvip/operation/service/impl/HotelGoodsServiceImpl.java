/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelGoodsServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-23 18:08:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 18:08:45> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.manager.HotelCateManager;
import com.huazhu.hvip.operation.manager.HotelGoodsManager;
import com.huazhu.hvip.operation.manager.HotelManager;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.model.HotelCate;
import com.huazhu.hvip.operation.model.HotelGoods;
import com.huazhu.hvip.operation.qo.HotelQO;
import com.huazhu.hvip.operation.service.HotelGoodsService;
import com.huazhu.hvip.operation.vo.HotelGoodsVO;
import com.huazhu.hvip.product.qo.GoodsQO;
import com.huazhu.hvip.product.service.GoodsService;
import com.huazhu.hvip.product.vo.GoodsVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("hotelGoodsService")
public class HotelGoodsServiceImpl implements HotelGoodsService {

    private static Logger logger = LogManager.getLogger(HotelGoodsServiceImpl.class);

    private HotelManager hotelManager;

    @Autowired
    public void setHotelManager(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    private HotelGoodsManager hotelGoodsManager;

    @Autowired
    private HotelCateManager hotelCateManager;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    public void setHotelGoodsManager(HotelGoodsManager hotelGoodsManager) {
        this.hotelGoodsManager = hotelGoodsManager;
    }

    /**
     * 根据酒店统一编号获取该酒店已开通的商品列表
     *
     * @param hotelQO
     * @return dataList 分类列表
     */
    @Override
    public ReturnObject<HotelGoodsVO> searchOpenGoodsByHotelQO(HotelQO hotelQO) {
        logger.info("call searchOpenGoodsByHotelUniqueNo({\"hotelUniqueNo:\"" + JsonUtil.JSON_Bean2String(hotelQO) + "})");

        ReturnObject<HotelGoodsVO> ret = new ReturnObject<>();
        List<HotelGoodsVO> hotelGoodsVOList = new ArrayList<>();
        HotelGoodsVO hotelGoodsVO = null;

        try {
            if (hotelQO != null) {
                //根据酒店id查询该酒店已开通的商品列表
                QueryModel queryModel = new QueryModel();
                if (CheckUtil.checkListIsNull(hotelQO.getGoodsIdList())) {
                    queryModel.addHqlCondition(" goodsId in("+StringUtils.join(hotelQO.getGoodsIdList(),",")+")");
                }
                queryModel.addColumnValueCondition("hotelId", hotelQO.getHotelId());
                queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
                queryModel.setSortHql(" sort desc,goodsId asc ");
                List<HotelGoods> list = hotelGoodsManager.search(queryModel);
                for (HotelGoods hotelGoods : list) {
                    hotelGoodsVO = new HotelGoodsVO();
                    BeanUtils.copyProperties(hotelGoods, hotelGoodsVO);
                    hotelGoodsVOList.add(hotelGoodsVO);
                }
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("查询成功");
            } else {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到该酒店信息");
            }
        } catch (Exception e) {
            logger.error("查询该酒店已开通的商品列表失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        ret.setDataList(hotelGoodsVOList);

        return ret;
    }

    /**
     * 根据用户勾选，修改酒店开通商品列表
     *
     * @param hotelId  酒店id
     * @param goodsMap 用户勾选的商品
     * @return
     */
    @Override
    public ReturnObject saveOpenGoodsByHotelId(Long hotelId, Map<Long, String> goodsMap, boolean appendFlag) {
        logger.info("call saveOpenCateByHotelId({},{},{})", hotelId, JsonUtil.JSON_List2String(goodsMap), appendFlag);
        ReturnObject ret = new ReturnObject();

        ParamObject paramObject = new ParamObject();
        paramObject.add("hotelId", hotelId);
        paramObject.add("goodsMap", goodsMap);
        paramObject.add("appendFlag", appendFlag);

        try {
            ret = hotelGoodsManager.updateOpenGoodsByHotelId(paramObject);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 通过商品的Id查询酒店的订单
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<HotelGoodsVO> searchHotelByGoodsId(Long goodsId) {
        logger.info("call searchHotelByGoodsId({})", goodsId);
        ReturnObject returnObject = null;
        Map<Long, Hotel> hotelMap = new HashMap<>();
        try {
            List<HotelGoodsVO> hotelGoodsVOList = new ArrayList<>();
            List<Long> hotelIdList = new ArrayList<>();
            returnObject = new ReturnObject();
            ParamObject paramObject = new ParamObject();
            paramObject.add("goodsId", goodsId);
            List<HotelGoods> hotelGoodsList = hotelGoodsManager.searchHotelByGoodsId(paramObject);
            if (hotelGoodsList != null && hotelGoodsList.size() > 0) {
                for (HotelGoods hotelGoods : hotelGoodsList) {
                    HotelGoodsVO hotelGoodsVO = new HotelGoodsVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(hotelGoods, hotelGoodsVO);
                    hotelGoodsVOList.add(hotelGoodsVO);
                    hotelIdList.add(hotelGoods.getHotelId());
                }
                if (CheckUtil.checkListIsNull(hotelIdList)) {
                    QueryModel queryModel = new QueryModel();
                    queryModel.addHqlCondition(" hotelId in (" + StringUtils.join(hotelIdList, ",") + ")");
                    List<Hotel> hotelList = hotelManager.search(queryModel);
                    if (CheckUtil.checkListIsNull(hotelList)) {
                        for (Hotel hotel : hotelList) {
                            hotelMap.put(hotel.getHotelId(), hotel);
                        }
                    }
                }
                for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOList) {
                    Hotel hotel = hotelMap.get(hotelGoodsVO.getHotelId());
                    if (hotel != null) {
                        hotelGoodsVO.setHotelName(hotel.getHotelName());
                    }
                }
                returnObject.setDataList(hotelGoodsVOList);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            } else {
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error(e.getMessage());
        }
        return returnObject;
    }

    /**
     * 更新酒店的商品cateId
     *
     * @param hotelGoodsVOList
     * @return
     */
    @Override
    public ReturnObject<HotelGoodsVO> saveHotelGoodsCateId(List<HotelGoodsVO> hotelGoodsVOList) {
        logger.info("call saveHotelGoodsCateId({})", JsonUtil.JSON_List2String(hotelGoodsVOList));
        String cateId = null;
        String goodsName = null;
        Map<String, List<String>> hotelCateIdMap = new HashMap<>();
        List<String> hotelIdList = new ArrayList<>();
        List<String> hotelCateIdList = new ArrayList<>();
        ReturnObject returnObject = new ReturnObject();
        try {
            if (hotelGoodsVOList != null && hotelGoodsVOList.size() > 0) {
                HotelGoodsVO hotelGoodsVO = hotelGoodsVOList.get(0);
                ParamObject paramObject = new ParamObject();
                paramObject.add("cateId", hotelGoodsVO.getCateId());
                paramObject.add("goodsId", hotelGoodsVO.getGoodsId());
                hotelGoodsManager.updateCateIdByGoodsId(paramObject);
                for (HotelGoodsVO hotelGoods : hotelGoodsVOList) {
                    cateId = hotelGoodsVO.getCateId().toString();
                    if (!hotelIdList.contains(hotelGoods.getHotelId().toString())) {
                        hotelIdList.add(hotelGoods.getHotelId().toString());
                    }
                }
                paramObject.add("hotelIdList", hotelIdList);
                List<HotelCate> hotelCateList = hotelCateManager.searchByhotelIdList(paramObject);
                if (hotelCateList != null && hotelCateList.size() > 0) {
                    for (String hotelId : hotelIdList) {
                        hotelCateIdList = new ArrayList<>();
                        for (HotelCate hotelCate : hotelCateList) {
                            if (hotelId.equals(hotelCate.getHotelId().toString())) {
                                hotelCateIdList.add(hotelCate.getCateId().toString());
                            }
                        }
                        hotelCateIdMap.put(hotelId, hotelCateIdList);
                    }
                    for (String hotelId : hotelIdList) {
                        hotelCateIdList = hotelCateIdMap.get(hotelId);
                        if (!hotelCateIdList.contains(cateId)) {
                            HotelCate hotelCate = new HotelCate();
                            hotelCate.setCateId(Long.valueOf(cateId));
                            hotelCate.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
                            hotelCate.setHotelId(Long.valueOf(hotelId));
                            hotelCate.setCateName(goodsName);
                            hotelCateManager.save(hotelCate);
                        }
                    }
                }
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error(e.getMessage());
        }
        return returnObject;
    }

    /**
     * 查询已开通和未开通的商品
     *
     * @param hotelQO
     * @return
     */
    @Override
    public ReturnObject<HotelGoodsVO> searchOpenGoodsAndNoOpen(HotelQO hotelQO) {
        logger.info("call searchOpenGoodsAndNoOpen({})", JsonUtil.JSON_List2String(hotelQO));
        ReturnObject returnObject = new ReturnObject();
        try {
            List<HotelGoodsVO> hotelGoodsVOList = new ArrayList<>();
            Map<Long, HotelGoodsVO> longHotelGoodsVOMap = new HashMap<>();
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("hotelId", hotelQO.getHotelId());
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<HotelGoods> hotelGoodsList = hotelGoodsManager.search(queryModel);
            if (CheckUtil.checkListIsNull(hotelGoodsList)) {
                for (HotelGoods hotelGoods : hotelGoodsList) {
                    HotelGoodsVO hotelGoodsVO = new HotelGoodsVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(hotelGoods, hotelGoodsVO);
                    hotelGoodsVOList.add(hotelGoodsVO);
                    longHotelGoodsVOMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);
                }
            }
            GoodsQO goodsQO = new GoodsQO();
            goodsQO.setBizScope(Constants.GOODSTYPE_BIZSCOPE_APARTMENTCLEAN);
            returnObject = goodsService.searchH5GoodsList(goodsQO);
            if (Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                List<GoodsVO> goodsVOList = returnObject.getDataList();
                if (CheckUtil.checkListIsNull(goodsVOList)) {
                    for (GoodsVO goodsVO : goodsVOList) {
                        HotelGoodsVO hotelGoodsVO = longHotelGoodsVOMap.get(goodsVO.getGoodsId());
                        if (hotelGoodsVO == null) {
                            hotelGoodsVO = new HotelGoodsVO();
                            hotelGoodsVO.setGoodsId(goodsVO.getGoodsId());
                            hotelGoodsVO.setGoodsName(goodsVO.getGoodsName());
                            hotelGoodsVOList.add(hotelGoodsVO);
                        }
                    }
                }
            }
            returnObject.setDataList(hotelGoodsVOList);
            returnObject.setReturnMsg(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnMsg(Constants.RETURN_CODE_ERROR);
            logger.info("call searchOpenGoodsAndNoOpen error({})", e);
        }
        return returnObject;
    }

    /**
     * 开通酒店商品
     *
     * @param hotelGoodsVOs
     * @return
     */
    @Override
    public ReturnObject<HotelGoodsVO> saveHotelGoodsVOList(List<HotelGoodsVO> hotelGoodsVOs) {
        logger.info("call saveHotelGoodsVOList({})", JsonUtil.JSON_List2String(hotelGoodsVOs));
        ReturnObject returnObject = new ReturnObject();
        try {
            Map<Long, HotelGoodsVO> hotelGoodsVOMap = new HashMap<>();
            if (CheckUtil.checkListIsNull(hotelGoodsVOs)) {
                List<String> goodsIdList = new ArrayList<>();
                Long hotelId = null;
                for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOs) {
                    hotelId = hotelGoodsVO.getHotelId();
                    hotelGoodsVOMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);
                    goodsIdList.add(hotelGoodsVO.getGoodsId().toString());
                }
                if (hotelId != null && CheckUtil.checkListIsNull(goodsIdList)) {
                    QueryModel queryModel = new QueryModel();
                    queryModel.addColumnValueCondition("hotelId", hotelId);
                    queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
                    queryModel.addHqlCondition(" goodsId in(" + StringUtils.join(goodsIdList, ",") + ")");
                    List<HotelGoods> hotelGoodsList = hotelGoodsManager.search(queryModel);
                    for (HotelGoods hotelGoods : hotelGoodsList) {
                        hotelGoods.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
                        hotelGoodsManager.save(hotelGoods);
                    }
                }
                returnObject = goodsService.getGoodVOByGoodIdList(goodsIdList);
                if (Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                    List<GoodsVO> goodsVOList = returnObject.getDataList();
                    for (GoodsVO goodsVO : goodsVOList) {
                        HotelGoodsVO hotelGoodsVO = hotelGoodsVOMap.get((goodsVO.getGoodsId()));
                        if (hotelGoodsVO != null) {
                            hotelGoodsVO.setTypeId(goodsVO.getTypeId());
                            hotelGoodsVO.setCateId(goodsVO.getCateId());
                            hotelGoodsVO.setGoodsName(goodsVO.getGoodsName());
                            hotelGoodsVO.setGoodsSn(goodsVO.getGoodsSn());
                            hotelGoodsVO.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
                            hotelGoodsVO.setSellPrice(goodsVO.getMktprice());
                        }
                    }
                }
                for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOs) {
                    HotelGoods hotelGoods = new HotelGoods();
                    CopyBeanUtil.copyPropertiesIgnoreNull(hotelGoodsVO, hotelGoods);
                    hotelGoodsManager.save(hotelGoods);
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error(" call saveHotelGoodsVOList({}) error", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
