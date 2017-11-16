/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-21 17:06:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-21 17:06:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.FinanceSubjectService;
import com.huazhu.hvip.common.service.PictureService;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.common.service.SysParamService;
import com.huazhu.hvip.common.vo.FinanceSubjectVO;
import com.huazhu.hvip.common.vo.PictureVO;
import com.huazhu.hvip.inventory.service.InventoryService;
import com.huazhu.hvip.inventory.vo.InventoryVO;
import com.huazhu.hvip.operation.qo.HotelQO;
import com.huazhu.hvip.operation.service.HotelGoodsService;
import com.huazhu.hvip.operation.vo.HotelGoodsVO;
import com.huazhu.hvip.product.goods.manager.*;
import com.huazhu.hvip.product.goods.model.*;
import com.huazhu.hvip.product.goods.model.extend.GoodsExt;
import com.huazhu.hvip.product.qo.GoodsCommentQO;
import com.huazhu.hvip.product.qo.GoodsQO;
import com.huazhu.hvip.product.request.GoodsInfo;
import com.huazhu.hvip.product.request.SaveGoodsVO;
import com.huazhu.hvip.product.service.GoodsService;
import com.huazhu.hvip.product.vo.*;
import com.huazhu.hvip.store.vo.StoreVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private static Logger logger = LogManager.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsManager goodsManager;
    @Autowired
    private GoodsGalleryManager goodsGalleryManager;
    @Autowired
    private GoodsStoreManager goodsStoreManager;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private HotelGoodsService hotelGoodsService;
    @Autowired
    private SerialNumService serialNumService;
    @Autowired
    private CategoryManager categoryManager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private TagsManager tagsManager;
    @Autowired
    private CateOrderRuleManager cateOrderRuleManager;
    @Autowired
    private CateCancelRuleManager cateCancelRuleManager;
    @Autowired
    private SysParamService sysParamService;
    @Autowired
    private GoodsTypeManager goodsTypeManager;
    @Autowired
    private FinanceSubjectService financeSubjectService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private GoodsCommentManager goodsCommentManager;

    /**
     * 根据cateId查询Goods
     *
     * @param cateId
     * @return ReturnObject  data：GoodsVO   data2：CateOrderRuleVO
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsListByCateId(Long cateId) {
        ReturnObject<GoodsVO> ret = new ReturnObject<GoodsVO>();

        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("cateId", cateId);
            paramObject.add("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<GoodsExt> list = goodsManager.searchGoodsList(paramObject);
            List<GoodsVO> voList = new ArrayList<GoodsVO>();
            for (GoodsExt goods : list) {
                GoodsVO goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goods, goodsVO);
                setGoodsPicture(goodsVO); //封装商品图片
                voList.add(goodsVO);
            }
            ret.setDataList(voList);

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("cateId", cateId);
            queryModel.addColumnValueCondition("status", Constants.CATE_STATUS_ENABLE_TRUE);
            CateOrderRule cateOrderRule = cateOrderRuleManager.getUniqueResult(queryModel);

            CateOrderRuleVO cateOrderRuleVO = new CateOrderRuleVO();
            if (cateOrderRule != null) {
                BeanUtils.copyProperties(cateOrderRule, cateOrderRuleVO);
            }
            ret.setData2(cateOrderRuleVO);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }


    /**
     * 根据酒店统一编号获取该酒店的商品信息列表
     *
     * @param hotelUniqueNo
     * @return dataList
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsListByHotelUniqueNo(String hotelUniqueNo) {
        logger.info("call searchGoodsListByHotelUniqueNo({\"hotelUniqueNo:\"" + hotelUniqueNo + "})");

        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        List<GoodsVO> goodsVOList = new ArrayList<>();
        GoodsVO goodsVO = null;
        try {
            //根据酒店统一编号获取该酒店已开通的商品列表
            HotelQO hotelQO=new HotelQO();
            hotelQO.setHotelUniqueNo(hotelUniqueNo);
            ReturnObject<HotelGoodsVO> ret = hotelGoodsService.searchOpenGoodsByHotelQO(hotelQO);
            List<HotelGoodsVO> hotelGoodsVOList = ret.getDataList();

            Map<Long, HotelGoodsVO> openMap = new HashMap<>();
            Long hotelId = null;

            for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOList) {
                openMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);
                hotelId = hotelGoodsVO.getHotelId();
            }

            if (hotelGoodsVOList == null || hotelGoodsVOList.size() <= 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("该酒店暂无开通百宝箱商品");

                return returnObject;
            }


            //查询商品信息列表，目前只查询 时令果盘、宝洁洗漱套装、全棉毛巾、纳米牙具套装四款商品
            List<String> goodsSnList = new ArrayList<>();
            goodsSnList.add(Constants.H5_HOMEPAGE_GOODSSN_1);
            goodsSnList.add(Constants.H5_HOMEPAGE_GOODSSN_2);
            goodsSnList.add(Constants.H5_HOMEPAGE_GOODSSN_3);
            goodsSnList.add(Constants.H5_HOMEPAGE_GOODSSN_4);

            ParamObject paramObject = new ParamObject();
            paramObject.add("goodsSnList", goodsSnList);
            paramObject.add("marketEnable", Constants.GOODS_MARKETENABLE_YES);
            paramObject.add("channelCode", Constants.CHANNEL_CODE_ONLINE);
            paramObject.add("hotelId", hotelId);
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);


            List<GoodsExt> newGoodsList = new ArrayList<>();
            List<Long> goodsIdList = new ArrayList<>();

            //循环获得该酒店已开通商品信息列表
            for (GoodsExt goods : goodsList) {
                if (openMap.containsKey(goods.getGoodsId())) {
                    newGoodsList.add(goods);
                    if (!goodsIdList.contains(goods.getGoodsId())) {
                        goodsIdList.add(goods.getGoodsId());
                    }
                }

            }

            Map<Long, List<GoodsStoreVO>> goodsStoreMap = new HashMap<>();
            List<GoodsStoreVO> gsList = null;
            GoodsStoreVO goodsStoreVO = null;

            if (!newGoodsList.isEmpty() && newGoodsList.size() > 0) {
                //根据酒店id以及商品id列表获得该酒店相关商品库存信息
                ParamObject paramObj = new ParamObject();
                paramObj.add("hotelId", hotelId);
                paramObj.add("goodsIdList", goodsIdList);
                List<GoodsStore> goodsStoreList = goodsStoreManager.searchGoodsStoreList(paramObj);

                if (goodsStoreList != null && goodsStoreList.size() > 0) {

                    for (Long goodsId : goodsIdList) {
                        gsList = new ArrayList<>();

                        for (GoodsStore goodsStore : goodsStoreList) {
                            goodsStoreVO = new GoodsStoreVO();

                            BeanUtils.copyProperties(goodsStore, goodsStoreVO);

                            if (goodsId.equals(goodsStore.getGoodsId())) {
                                gsList.add(goodsStoreVO);
                            }

                        }

                        goodsStoreMap.put(goodsId, gsList);

                    }
                }

            }


            //组装返回数据
            for (GoodsExt goods : newGoodsList) {
                goodsVO = new GoodsVO();
                //goodsVO.setCateId(goods.getCateId());
                BeanUtils.copyProperties(goods, goodsVO);
                if (goodsStoreMap.containsKey(goods.getGoodsId())) {
                    List<GoodsStoreVO> goodsStoreVOList = goodsStoreMap.get(goods.getGoodsId());
                    if (goodsStoreVOList != null && goodsStoreVOList.size() > 0) {
                        goodsVO.setGoodsStoreVOList(goodsStoreVOList);
                        goodsVO.setFreeStoreNum(goodsStoreVOList.get(0).getFreeStoreNum());
                    }
                }
                if (openMap.containsKey(goods.getGoodsId())) {
                    goodsVO.setAdjustPriceFlag(openMap.get(goods.getGoodsId()).getAdjustPriceFlag());
                }
                setGoodsPicture(goodsVO); //封装商品图片

                goodsVOList.add(goodsVO);
            }

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("查询该酒店已开通的商品列表失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        returnObject.setDataList(goodsVOList);

        return returnObject;
    }

    /**
     * 根据酒店统一编号获取该酒店的商品信息列表用于HMS价格控制
     *
     * @param hotelUniqueNo
     * @return dataList
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsListByHotelUniqueNo(String hotelUniqueNo, String HMS) {
        logger.info("call searchGoodsListByHotelUniqueNo({\"hotelUniqueNo:\"" + hotelUniqueNo + "})");
        List<String> goodsIdList = new ArrayList<>();
        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        List<GoodsVO> goodsVOList = new ArrayList<>();
        GoodsVO goodsVO = null;
        try {
            //根据酒店统一编号获取该酒店已开通的商品列表
            HotelQO hotelQO=new HotelQO();
            hotelQO.setHotelUniqueNo(hotelUniqueNo);
            ReturnObject<HotelGoodsVO> ret = hotelGoodsService.searchOpenGoodsByHotelQO(hotelQO);            List<HotelGoodsVO> hotelGoodsVOList = ret.getDataList();
            Map<Long, HotelGoodsVO> openMap = new HashMap<>();
            for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOList) {
                openMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);
                goodsIdList.add(hotelGoodsVO.getGoodsId().toString());
            }

            if (hotelGoodsVOList == null || hotelGoodsVOList.size() <= 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("该酒店暂无开通百宝箱商品");

                return returnObject;
            }
            ParamObject paramObject = new ParamObject();
            paramObject.add("marketEnable", Constants.GOODS_MARKETENABLE_YES);
            paramObject.add("goodsIdList", goodsIdList);
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);
            if (goodsIdList != null && goodsIdList.size() > 0) {
                for (GoodsExt goodsExt : goodsList) {
                    goodsVO = new GoodsVO();
                    BeanUtils.copyProperties(goodsExt, goodsVO);
                    goodsVOList.add(goodsVO);
                }
            }
        } catch (Exception e) {
            logger.error(e);
            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            returnObject.setReturnMsg("查询失败");
        }
        returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        returnObject.setDataList(goodsVOList);
        return returnObject;
    }

    /**
     * 根据酒店统一编号获取该酒店的商品信息列表
     *
     * @param
     * @param pageCondition
     * @return dataList
     */
    @Override
    public ReturnObject<GoodsVO> searchOpenGoodsListByHotelUniqueNo(GoodsQO goodsQO, PageCondition pageCondition) {
        logger.info("call searchOpenGoodsListByHotelUniqueNo({},{})", JsonUtil.JSON_Bean2String(goodsQO), JsonUtil.JSON_Bean2String(pageCondition));

        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        List<GoodsVO> goodsVOList = new ArrayList<>();
        GoodsVO goodsVO = null;

        try {

            Map<Long, HotelGoodsVO> openMap = new HashMap<>();
            List<Long> goodsIdList = null;
            Long hotelId = null;
            String openChannel = goodsQO.getOpenChannel();

            if (goodsQO != null && StringUtils.isNotBlank(goodsQO.getHotelUniqueNo())) {
                //根据酒店统一编号获取该酒店已开通的商品列表
                HotelQO hotelQO=new HotelQO();
                hotelQO.setHotelUniqueNo(goodsQO.getHotelUniqueNo());
                ReturnObject<HotelGoodsVO> ret = hotelGoodsService.searchOpenGoodsByHotelQO(hotelQO);                List<HotelGoodsVO> hotelGoodsVOList = ret.getDataList();

                if (hotelGoodsVOList == null || hotelGoodsVOList.size() <= 0) {
                    returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                    returnObject.setReturnMsg("该酒店暂无开通百宝箱商品");

                    return returnObject;
                }

                goodsIdList = new ArrayList<>();
                for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOList) {
                    hotelId = hotelGoodsVO.getHotelId();
                    openMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);

                    if (StringUtils.isBlank(openChannel)
                            || (StringUtils.isNotBlank(openChannel)
                            && (openChannel.equals(hotelGoodsVO.getOpenChannel())
                            || Constants.OPEN_CHANNEL_ALL.equals(hotelGoodsVO.getOpenChannel())
                    ))) {
                        goodsIdList.add(hotelGoodsVO.getGoodsId());
                    }

                }

                if (StringUtils.isNotBlank(openChannel) && goodsIdList.size() <= 0) {
                    returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                    if (openChannel.equals(Constants.OPEN_CHANNEL_ALL)) {
                        returnObject.setReturnMsg("该酒店暂无开通百宝箱商品");
                    } else if (openChannel.equals(Constants.OPEN_CHANNEL_ONLINE)) {
                        returnObject.setReturnMsg("该酒店暂无开通线上百宝箱商品");
                    } else if (openChannel.equals(Constants.OPEN_CHANNEL_OFFLINE)) {
                        returnObject.setReturnMsg("该酒店暂无开通线下百宝箱商品");
                    }

                    return returnObject;
                }

            }

            //查询商品信息列表
            ParamObject paramObject = new ParamObject();
            if (pageCondition != null) {
                paramObject.setPageSize(pageCondition.getPageSize());
                paramObject.setPageNo(pageCondition.getPageNo());
                if (StringUtils.isNotBlank(pageCondition.getSortBy())) {
                    paramObject.add("orderBy", " " + pageCondition.getSortBy() + " " + pageCondition.getDirection());
                } else {
                    String str = StringUtils.join(goodsIdList, ",");
                    paramObject.add("orderBy", " find_in_set(goodsId,'" + str + "')");
                }
            }

            paramObject.add("goodsSnList", goodsQO.getGoodsSnList());
            paramObject.add("goodsIdList", goodsIdList);
            paramObject.add("cateIds", goodsQO.getCateIds());
            paramObject.add("cateSn", goodsQO.getCateSn());
            paramObject.add("cateSnList", goodsQO.getCateSnList());
            paramObject.add("marketEnable", Constants.GOODS_MARKETENABLE_YES);
            paramObject.add("channelCode", Constants.CHANNEL_CODE_ONLINE);
            paramObject.add("hotelId", hotelId);
            paramObject.add("typeId", goodsQO.getTypeId());
            paramObject.add("typeList", goodsQO.getTypeList());//d
            paramObject.add("bizScope", goodsQO.getBizScope());
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);

            Map<Long, InventoryVO> inventoryVOMap = new HashMap<>();
            List<GoodsStoreVO> gsList = null;
            GoodsStoreVO goodsStoreVO = null;

            if (goodsList != null && goodsList.size() > 0) {
                //根据酒店id以及商品id列表获得该酒店相关商品库存信息
                ReturnObject<InventoryVO> ret = inventoryService.searchInventoryByGoodsId(hotelId == null ? null : hotelId.toString(), goodsIdList);
                if (!ret.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
                    returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
                    returnObject.setReturnMsg("查询库存失败");
                    return returnObject;
                }
                List<InventoryVO> inventoryVOList = ret.getDataList();
                if (inventoryVOList != null && inventoryVOList.size() > 0) {
                    for (InventoryVO inventoryVO : inventoryVOList) {
                        inventoryVOMap.put(inventoryVO.getGoodsId(), inventoryVO);
                    }
                }
            }
            //组装返回数据
            for (GoodsExt goods : goodsList) {
                goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goods, goodsVO);
                InventoryVO inventoryVO = inventoryVOMap.get(goods.getGoodsId());
                if (inventoryVO != null) {
                    goodsVO.setFreeStoreNum(inventoryVO.getInventoryNum() == null ? 0 : inventoryVO.getInventoryNum());
                } else {
                    goodsVO.setFreeStoreNum(0);
                }
                setGoodsPicture(goodsVO); //封装商品图片
                goodsVOList.add(goodsVO);
            }

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (
                Exception e
                )

        {
            logger.error("查询该酒店已开通的商品列表失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        returnObject.setDataList(goodsVOList);

        return returnObject;
    }

    /**
     * 根据商品idList获取该酒店的商品信息列表
     *
     * @param goodsIdList
     * @param hotelId     //酒店id , 该字段用于查询商品库存及价格
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsListByGoodsIdList(List<Long> goodsIdList, Long hotelId, String channelCode) {
        logger.info("call searchGoodsListByGoodsIdList({\"hotelId:\"" + hotelId + "},{\"\":" + JsonUtil.JSON_List2String(goodsIdList) + "})");

        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        List<GoodsVO> goodsVOList = new ArrayList<>();
        GoodsVO goodsVO = null;

        try {
            ParamObject paramObject = new ParamObject();
            paramObject.add("goodsIdList", goodsIdList);
            if (StringUtils.isBlank(channelCode)) {
                channelCode = Constants.CHANNEL_CODE_STORE;
            }
            paramObject.add("channelCode", channelCode);
            paramObject.add("hotelId", hotelId);
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);


            Map<Long, InventoryVO> inventoryVOMap = new HashMap<>();
            List<GoodsStoreVO> gsList = null;
            GoodsStoreVO goodsStoreVO = null;

            if (!goodsList.isEmpty() && goodsList.size() > 0) {
                //根据酒店id以及商品id列表获得该酒店相关商品库存信息
                ReturnObject<InventoryVO> inventoryVOReturnObject = inventoryService.searchInventoryByGoodsId(hotelId.toString(), goodsIdList);
                if (inventoryVOReturnObject.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
                    List<InventoryVO> inventoryVOList = inventoryVOReturnObject.getDataList();
                    for (InventoryVO inventoryVO : inventoryVOList) {
                        inventoryVOMap.put(inventoryVO.getGoodsId(), inventoryVO);
                    }
                }

            }


            //组装返回数据
            for (GoodsExt goods : goodsList) {
                goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goods, goodsVO);
                InventoryVO inventoryVO = inventoryVOMap.get(goods.getGoodsId());
                if (inventoryVO != null) {
                    goodsVO.setFreeStoreNum(inventoryVO.getInventoryNum());
                }
                setGoodsPicture(goodsVO); //封装商品图片

                goodsVOList.add(goodsVO);
            }

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("查询该酒店已开通的商品列表失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        returnObject.setDataList(goodsVOList);

        return returnObject;
    }

    /**
     * 根据商品id获取商品详情
     *
     * @param goodsQO 商品id
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> getGoodsDetail(GoodsQO goodsQO) {
        logger.info("call getGoodsDetail({\"goodsId:\"" + goodsQO + "})");

        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        GoodsVO goodsVO = new GoodsVO();
        List<ProductVO> productVOList = new ArrayList<>();
        ProductVO productVO = null;

        try {
            //根据商品id查询商品信息
            ParamObject paramObject = new ParamObject();
            paramObject.add("goodsId", goodsQO.getGoodsId());
            paramObject.add("hotelId", goodsQO.getHotelId());
            paramObject.add("channelCode", Constants.CHANNEL_CODE_ONLINE);
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);

            if (goodsList == null || goodsList.size() <= 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("未查询到商品信息");

                return returnObject;
            }

            GoodsExt goods = goodsList.get(0);

            BeanUtils.copyProperties(goods, goodsVO);

            String params = goods.getParams(); //商品参数字串，服务时间

            GoodsParam goodsParam = null;
            if (StringUtils.isNotBlank(params)) {
                goodsParam = new GoodsParam();
                goodsParam = (GoodsParam) JsonUtil.JSON_String2Bean(params, GoodsParam.class);
            }

            goodsVO.setGoodsParam(goodsParam);

            //根据商品id得到商品标签列表
            List<Tags> tagsList = tagsManager.searchTagsList(paramObject);

            if (tagsList != null && tagsList.size() > 0) {
                List<GoodsTagsVO> goodsTagsVOList = new ArrayList<>();
                GoodsTagsVO goodsTagsVO = null;

                for (Tags tags : tagsList) {
                    goodsTagsVO = new GoodsTagsVO();
                    BeanUtils.copyProperties(tags, goodsTagsVO);

                    goodsTagsVOList.add(goodsTagsVO);
                }

                goodsVO.setGoodsTagsVOList(goodsTagsVOList);
            }

            //商品分类信息
            Category category = categoryManager.get(goods.getCateId());

            if (category != null) {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
            }

            //根据商品id得到货品信息
            List<Product> productList = productManager.searchProductList(paramObject);

            for (Product product : productList) {
                productVO = new ProductVO();

                BeanUtils.copyProperties(product, productVO);

                productVOList.add(productVO);
            }

            goodsVO.setProductVOList(productVOList);

            //商品分类订单支付规则
            ReturnObject<CateOrderRuleVO> ruleRet = getCateOrderRuleByGoodsId(goodsVO.getGoodsId());

            CateOrderRuleVO cateOrderRuleVO = ruleRet.getData();

            goodsVO.setCateOrderRuleVO(cateOrderRuleVO);

            StoreVO storeVO = null;

            //服务提供商
//            Long storeId = goods.getStoreId();
//            if (storeId != null) {
//                ReturnObject<StoreVO> storeVOReturnObject = storeService.getStoreDetail(storeId);
//                storeVO = storeVOReturnObject.getData();
//            }

            setGoodsPicture(goodsVO); //封装商品图片

            returnObject.setData(goodsVO);
            returnObject.setObject(storeVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("查获取商品详情失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        return returnObject;
    }

    /**
     * 根据酒店统一编号获取该酒店的商品信息列表（已开通和未开通的都列出）
     *
     * @param goodsQO
     * @param page
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsListByHotelUniqueNo(PageCondition page, GoodsQO goodsQO) {
        logger.info("call searchGoodsListByHotelUniqueNo({\"goodsQO:\"" + goodsQO + "})");

        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        List<GoodsVO> goodsVOList = new ArrayList<>();
        GoodsVO goodsVO = null;
        List<Long> cateIds = goodsQO.getCateIds();
        String hotelUniqueNo = goodsQO.getHotelUniqueNo();
        try {
            //根据酒店统一编号获取该酒店已开通的商品列表
            HotelQO hotelQO=new HotelQO();
            hotelQO.setHotelUniqueNo(hotelUniqueNo);
            ReturnObject<HotelGoodsVO> ret = hotelGoodsService.searchOpenGoodsByHotelQO(hotelQO);            List<HotelGoodsVO> hotelGoodsVOList = ret.getDataList();

            Map<Long, HotelGoodsVO> openMap = new HashMap<>();
            Long hotelId = null;

            for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOList) {
                openMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);
                hotelId = hotelGoodsVO.getHotelId();
            }


            //查询已开通分类下商品信息列表
            ParamObject paramObject = new ParamObject();
            if (page != null) {
                paramObject.setPageSize(page.getPageSize());
                paramObject.setPageNo(page.getPageNo());
                if (StringUtils.isNotBlank(page.getSortBy())) {
                    paramObject.add("orderBy", " " + page.getSortBy() + " " + page.getDirection());
                }
            }

            paramObject.add("cateIds", cateIds);
            paramObject.add("marketEnable", Constants.GOODS_MARKETENABLE_YES);
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);

            if (goodsList == null || goodsList.size() == 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("无酒店商品，查询为空");
                return returnObject;

            }

            List<Long> goodsIdList = new ArrayList<>();


            //循环获得该酒店已开通商品信息列表
            for (GoodsExt goods : goodsList) {
                goodsIdList.add(goods.getGoodsId());

            }

            Map<Long, List<GoodsStoreVO>> goodsStoreMap = new HashMap<>();
            List<GoodsStoreVO> gsList = null;
            GoodsStoreVO goodsStoreVO = null;

            if (!goodsIdList.isEmpty() && goodsIdList.size() > 0) {
                //根据酒店id以及商品id列表获得该酒店相关商品库存信息
                ParamObject paramObj = new ParamObject();
                paramObj.add("hotelId", hotelId);
                paramObj.add("goodsIdList", goodsIdList);
                List<GoodsStore> goodsStoreList = goodsStoreManager.searchGoodsStoreList(paramObj);

                if (goodsStoreList != null && goodsStoreList.size() > 0) {

                    for (Long goodsId : goodsIdList) {
                        gsList = new ArrayList<>();

                        for (GoodsStore goodsStore : goodsStoreList) {
                            goodsStoreVO = new GoodsStoreVO();

                            BeanUtils.copyProperties(goodsStore, goodsStoreVO);

                            if (goodsId.equals(goodsStore.getGoodsId())) {
                                gsList.add(goodsStoreVO);
                            }

                        }

                        goodsStoreMap.put(goodsId, gsList);

                    }
                }

            }


            //组装返回数据
            for (GoodsExt goods : goodsList) {
                goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goods, goodsVO);

                if (goodsStoreMap.containsKey(goods.getGoodsId())) {
                    List<GoodsStoreVO> goodsStoreVOList = goodsStoreMap.get(goods.getGoodsId());
                    if (goodsStoreVOList != null && goodsStoreVOList.size() > 0) {
                        goodsVO.setGoodsStoreVOList(goodsStoreVOList);
                        goodsVO.setFreeStoreNum(goodsStoreVOList.get(0).getFreeStoreNum());
                    }
                }
                if (openMap.containsKey(goods.getGoodsId())) {
                    goodsVO.setOpenFlag(true);
                    HotelGoodsVO hotelGoodsVO = openMap.get(goods.getGoodsId());
                    goodsVO.setOpenChannel(hotelGoodsVO.getOpenChannel());
                    goodsVO.setAdjustPriceFlag(hotelGoodsVO.getAdjustPriceFlag());
                    goodsVO.setHotelGoodsSort(hotelGoodsVO.getSort());
                } else {
                    goodsVO.setOpenFlag(false);
                    goodsVO.setHotelGoodsSort(0);
                }

                setGoodsPicture(goodsVO); //封装商品图片

                goodsVOList.add(goodsVO);
            }

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("查询该酒店已开通的商品列表失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        returnObject.setDataList(goodsVOList);

        return returnObject;
    }

    /**
     * 查询所有商品(无查询条件)
     *
     * @return ReturnObject
     */
    @Override
    public ReturnObject<GoodsVO> getAll() {
        logger.info("call getAll()");
        ReturnObject<GoodsVO> ret = new ReturnObject<GoodsVO>();

        try {
            List<Goods> list = goodsManager.getAll();
            List<GoodsVO> voList = new ArrayList<GoodsVO>();
            for (Goods goods : list) {
                GoodsVO goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goods, goodsVO);

                setGoodsPicture(goodsVO); //封装商品图片

                voList.add(goodsVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 自定义条件查询商品
     *
     * @return ReturnObject
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsList(ParamObject paramObject) {
        logger.info("call searchGoodsList()");
        ReturnObject<GoodsVO> ret = new ReturnObject<GoodsVO>();

        try {
            List<GoodsExt> list = goodsManager.searchGoodsList(paramObject);
            List<GoodsVO> voList = new ArrayList<GoodsVO>();
            for (GoodsExt goodsExt : list) {
                GoodsVO goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goodsExt, goodsVO);

                setGoodsPicture(goodsVO); //封装商品图片

                voList.add(goodsVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(paramObject.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 根据id批量删除商品
     *
     * @param ids 类型ID
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject deleteGoods(Long[] ids) {
        logger.info("call deleteGoods({\"ids:\"" + JsonUtil.JSON_List2String(ids) + "})");

        ReturnObject ret = new ReturnObject();

        try {
            int deleteCount = goodsManager.deleteGoods(ids);
            if (deleteCount > 0) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("删除商品成功");
            } else {
                ret.setReturnMsg("删除商品失败");
            }
        } catch (Exception e) {
            logger.error("删除商品失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除商品失败");
        }

        return ret;
    }

    /**
     * 保存商品
     *
     * @param goodsInfo
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> saveGoods(GoodsInfo goodsInfo) {
        logger.info("call saveGoods({\"goodsInfo:\"" + goodsInfo.toString() + "})");

        ReturnObject<GoodsVO> ret = new ReturnObject<GoodsVO>();

        try {
            Goods goods = goodsManager.get(goodsInfo.getGoodsId());
            BeanUtils.copyProperties(goodsInfo, goods);
            goods = goodsManager.saveGoods(goods);
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(goods, goodsVO);
            ret.setData(goodsVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }

        return ret;
    }

    /**
     * 通过id获取商品
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> getGoodsById(Long goodsId) {
        logger.info("call getGoodsById({\"goodsId:\"" + goodsId + "})");

        ReturnObject<GoodsVO> ret = new ReturnObject<GoodsVO>();

        try {
            Goods goods = goodsManager.get(goodsId);
            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(goods, goodsVO);

            //查询cateSn
            Long cateId = goodsVO.getCateId();
            if (cateId != null) {
                Category cate = categoryManager.get(cateId);
                goodsVO.setCateSn(cate.getCateSn());
            }

            //查询商品类型
            GoodsType type = goodsTypeManager.get(goods.getTypeId());
            if (type != null) {
                GoodsTypeVO goodsTypeVO = new GoodsTypeVO();
                BeanUtils.copyProperties(type, goodsTypeVO);
                goodsVO.setGoodsTypeVO(goodsTypeVO);
            }

            setGoodsPicture(goodsVO); //封装商品图片

            ret.setData(goodsVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 保创建商品
     *
     * @param saveGoodsVO
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> createGoods(SaveGoodsVO saveGoodsVO) {
        logger.info("call createGoods({\"saveGoodsVO:\"" + saveGoodsVO.toString() + "})");

        ReturnObject<GoodsVO> ret = new ReturnObject<GoodsVO>();

        try {
            GoodsInfo goodsInfo = saveGoodsVO.getGoodsInfo();
            Goods goods = new Goods();
            BeanUtils.copyProperties(goodsInfo, goods);
            GoodsType goodsType = goodsTypeManager.get(goods.getTypeId());
            if (goodsType != null) {
                goods.setBizScope(goodsType.getBizScope());
            }
            //创建编号以及唯一号
            if (StringUtil.isEmpty(goodsInfo.getGoodsNo())) {
                String goodsNo = serialNumService.generateGoodsNo();
                goods.setGoodsNo(goodsNo);
            }
            String goodsSn = serialNumService.generateGoodsSn();
            goods.setGoodsSn(goodsSn);

            //将相册VO转换成model
            List<GoodsGalleryVO> galleryVOs = saveGoodsVO.getGallerys();
            List<GoodsGallery> galleries = null;
            if (galleryVOs != null && galleryVOs.size() > 0) {
                galleries = new ArrayList<GoodsGallery>();
                for (GoodsGalleryVO vo : galleryVOs) {
                    GoodsGallery gallery = new GoodsGallery();
                    BeanUtils.copyProperties(vo, gallery);
                    galleries.add(gallery);
                }
            }

            //创建商品
            goods = goodsManager.createGoods(goods, galleries);

            GoodsVO goodsVO = new GoodsVO();
            BeanUtils.copyProperties(goods, goodsVO);
            ret.setData(goodsVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("创建商品成功");
        } catch (Exception e) {
            logger.error("创建商品失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("创建商品失败");
        }

        return ret;
    }

    /**
     * 商品下单数+1
     *
     * @param goodsIdList
     * @return
     */
    @Override
    public ReturnObject addGoodsOrderCount(List<Long> goodsIdList) {
        logger.info("call addGoodsOrderCount({\"goodsIdList:\"" + JsonUtil.JSON_List2String(goodsIdList) + "})");

        ReturnObject ret = new ReturnObject();

        try {
            if (goodsIdList == null || goodsIdList.size() <= 0) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("goodsIdList为空。。。");

                return ret;
            }

            ret = goodsManager.saveGoodsOrderCount(goodsIdList);

        } catch (Exception e) {
            logger.error("增加商品下单数失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("增加商品下单数失败");
        }

        return ret;
    }

    /**
     * 封装商品图片
     *
     * @param goodsVO
     * @return
     * @throws Exception
     */
    public GoodsVO setGoodsPicture(GoodsVO goodsVO) throws Exception {

        Long goodsId = goodsVO.getGoodsId();
        //查询相册表
        ParamObject para = new ParamObject();
        para.add("goodsId", goodsId);
        List<GoodsGallery> galleryList = goodsGalleryManager.searchGalleryList(para);

        //获取图片ID集合
        List<Long> picIdList = null;
        if (galleryList != null && galleryList.size() > 0) {
            picIdList = new ArrayList<Long>();
            for (GoodsGallery gallery : galleryList) {
                if (gallery.getGoodsId() != null) {
                    picIdList.add(gallery.getPicId());
                }
            }
        }

        //根据图片ID查询图片
        List<PictureVO> picVOList = pictureService.searchPictureList(picIdList).getDataList();

        //生成 图片id ==>图片VO MAP
        Map<Long, PictureVO> picMap = new HashMap<>();
        for (PictureVO pictureVO : picVOList) {
            picMap.put(pictureVO.getPicId(), pictureVO);
        }

        //合并相册和图片内容
        List<GoodsPictureVO> goodsPictureVOList = new ArrayList<GoodsPictureVO>();
        GoodsPictureVO goodsPictureVO = null;
        GoodsPictureVO defaultGoodsPicture = null;
        PictureVO pictureVO = null;
        for (GoodsGallery gallery : galleryList) {
            pictureVO = picMap.get(gallery.getPicId());
            if (pictureVO != null) {
                if (Constants.FLAG_TRUE.equals(gallery.getDefaultFlag())) {
                    defaultGoodsPicture = new GoodsPictureVO();
                    defaultGoodsPicture.setPicUrlView(pictureVO.getPicUrlView());
                    defaultGoodsPicture.setPicSuffixView(pictureVO.getPicSuffixView());
                    defaultGoodsPicture.setPicPrefixView(pictureVO.getPicPrefixView());
                    BeanUtils.copyProperties(pictureVO, defaultGoodsPicture);
                    BeanUtils.copyProperties(gallery, defaultGoodsPicture);
                }
                goodsPictureVO = new GoodsPictureVO();
                BeanUtils.copyProperties(pictureVO, goodsPictureVO);
                BeanUtils.copyProperties(gallery, goodsPictureVO);
                goodsPictureVOList.add(goodsPictureVO);
            }
        }
        goodsVO.setDefaultGoodsPicture(defaultGoodsPicture);
        goodsVO.setGoodsPictureVOList(goodsPictureVOList);

        return goodsVO;
    }

    /**
     * (hms)根据酒店统一编号，商品名称，类型查找商品列表
     *
     * @return ReturnObject
     */
    @Override
    public ReturnObject<GoodsVO> searchGoodsList(GoodsQO goodsQO) {
        logger.info("call searchGoodsList({\"goodsQO\":" + JsonUtil.JSON_Bean2String(goodsQO) + "}");

        ReturnObject<GoodsVO> returnObject = new ReturnObject<>();
        List<GoodsVO> goodsVOList = new ArrayList<>();
        try {
            if (goodsQO.getHotelUniqueNo() == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("查询失败，酒店统一编号为空");
                return returnObject;
            }
            //======================根据酒店统一编号获取该酒店已开通的商品列表======================================================
            HotelQO hotelQO=new HotelQO();
            hotelQO.setHotelUniqueNo(goodsQO.getHotelUniqueNo());
            ReturnObject<HotelGoodsVO> ret = hotelGoodsService.searchOpenGoodsByHotelQO(hotelQO);            List<HotelGoodsVO> hotelGoodsVOList = ret.getDataList();
            if (hotelGoodsVOList == null || hotelGoodsVOList.size() <= 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("该酒店暂无开通百宝箱商品");
                return returnObject;
            }
            //==============================酒店所属已开通的商品集合,放入map=======================================
            Map<Long, HotelGoodsVO> hotelGoodsMap = new HashMap<>();
            Long hotelId = null;
            for (HotelGoodsVO hotelGoodsVO : hotelGoodsVOList) {
                hotelGoodsMap.put(hotelGoodsVO.getGoodsId(), hotelGoodsVO);
                hotelId = hotelGoodsVO.getHotelId();
            }
            //==============================酒店，类型，商品名，门店商品，已经上架查找商品列表=========================
            ParamObject paramObject = new ParamObject();
            paramObject.add("marketEnable", Constants.GOODS_MARKETENABLE_YES);
            paramObject.add("channelCode", Constants.CHANNEL_CODE_STORE);
            paramObject.add("hotelId", hotelId);
            paramObject.add("cateIds", goodsQO.getCateIds());
            paramObject.add("goodsName", goodsQO.getGoodsName());
            paramObject.add("typeId", goodsQO.getTypeId());
            paramObject.add("bizScope", goodsQO.getBizScope());
            List<GoodsExt> goodsList = goodsManager.searchGoodsList(paramObject);

            List<GoodsExt> resultGoodsList = new ArrayList<>();
            List<Long> goodsIdList = new ArrayList<>();
            HotelGoodsVO hotelGoodsVO = null;
            String openChannel = goodsQO.getOpenChannel();

            //循环获得该酒店已开通商品信息列表
            if (goodsList != null) {
                for (GoodsExt goods : goodsList) {
                    hotelGoodsVO = hotelGoodsMap.get(goods.getGoodsId());
                    if (hotelGoodsVO != null && (openChannel.equals(hotelGoodsVO.getOpenChannel()) || Constants.OPEN_CHANNEL_ALL.equals(hotelGoodsVO.getOpenChannel()) || StringUtils.isBlank(openChannel))) {
                        resultGoodsList.add(goods);
                        if (!goodsIdList.contains(goods.getGoodsId())) {
                            goodsIdList.add(goods.getGoodsId());
                        }
                    }
                }
            }

            //===================================该酒店商品库存的map==================================
            Map<Long, InventoryVO> goodsStoreMap = new HashMap<>();

            if (!resultGoodsList.isEmpty() && resultGoodsList.size() > 0) {
                //根据酒店id以及商品id列表获得该酒店相关商品库存信息
                ParamObject paramObj = new ParamObject();
                ReturnObject<InventoryVO> inventoryVOReturnObject = inventoryService.searchInventoryByGoodsId(hotelId.toString(), goodsIdList);
                if (inventoryVOReturnObject.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
                    List<InventoryVO> inventoryVOList = inventoryVOReturnObject.getDataList();
                    for (InventoryVO inventoryVO : inventoryVOList) {
                        goodsStoreMap.put(inventoryVO.getGoodsId(), inventoryVO);
                    }
                }
            }

            //组装返回数据
            GoodsVO goodsVO = null;
            for (GoodsExt goods : resultGoodsList) {
                goodsVO = new GoodsVO();
                BeanUtils.copyProperties(goods, goodsVO);
                goodsVO.setFreeStoreNum(0);
                if (goodsStoreMap.containsKey(goods.getGoodsId())) {
                    InventoryVO inventoryVO = goodsStoreMap.get(goods.getGoodsId());
                    if (inventoryVO != null) {
                        goodsVO.setFreeStoreNum(inventoryVO.getFreeInventoryNum());
                    }
                }
                if (goodsVO.getPrice() == null) {
                    goodsVO.setPrice(new BigDecimal(0));
                }
                goodsVOList.add(goodsVO);
            }
            returnObject.setDataList(goodsVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询该酒店已开通的商品列表失败", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }
        return returnObject;

    }

    /**
     * 根据商品id获取商品分类的订单支付规则
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<CateOrderRuleVO> getCateOrderRuleByGoodsId(Long goodsId) {
        logger.info("call getCateOrderRuleByGoodsId({\"goodsId\":" + goodsId + "}");

        ReturnObject<CateOrderRuleVO> ret = new ReturnObject<>();
        CateOrderRuleVO cateOrderRuleVO = null;

        try {
            Goods goods = goodsManager.get(goodsId);

            if (goods == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到商品信息，goodsId:" + goods);
                return ret;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("cateId", goods.getCateId());
            queryModel.addColumnValueCondition("status", Constants.CATE_STATUS_ENABLE_TRUE);
            CateOrderRule cateOrderRule = cateOrderRuleManager.getUniqueResult(queryModel);

            if (cateOrderRule != null) {
                cateOrderRuleVO = new CateOrderRuleVO();
                BeanUtils.copyProperties(cateOrderRule, cateOrderRuleVO);

                String rulePromptMsg = cateOrderRule.getRulePromptMsg();

                if (StringUtils.isNotBlank(rulePromptMsg)) {
                    List<PromptMsg> promptMsgList = (List<PromptMsg>) JsonUtil.JSON_String2List(rulePromptMsg, PromptMsg.class);
                    cateOrderRuleVO.setPromptMsgList(promptMsgList);
                }

            }

            ret.setData(cateOrderRuleVO);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询分类规则支付失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询分类规则支付失败");
        }

        return ret;
    }

    /**
     * 根据商品idList获取商品分类的订单支付规则
     *
     * @param goodsIdList
     * @return
     */
    @Override
    public ReturnObject<Map<Long, CateOrderRuleVO>> getCateOrderRuleByGoodsIdList(List<Long> goodsIdList) {
        logger.info("call getCateOrderRuleByGoodsIdList({\"goodsIdList\":" + goodsIdList + "}");

        ReturnObject<Map<Long, CateOrderRuleVO>> ret = new ReturnObject<>();
        Map<Long, CateOrderRuleVO> ruleMap = new HashMap<>();
        CateOrderRuleVO cateOrderRuleVO = null;
        try {
            QueryModel queryModel = new QueryModel();
            if (goodsIdList != null && goodsIdList.size() > 0) {
                String goodsIds = StringUtils.join(goodsIdList, ",");
                queryModel.addHqlCondition("goodsId in (" + goodsIds + ")");
                List<Goods> goodsList = goodsManager.search(queryModel);
                if (goodsList == null || goodsList.size() < 1) {
                    ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                    ret.setReturnMsg("未查询到商品信息，goodsIdList:" + goodsIdList);
                    return ret;
                }

                Map<Long, Long> goodsCateMap = new HashMap<>();
                List<Long> cateIdList = new ArrayList<>();

                for (Goods goods : goodsList) {
                    goodsCateMap.put(goods.getGoodsId(), goods.getCateId());
                    cateIdList.add(goods.getCateId());
                }

                QueryModel queryCate = new QueryModel();
                if (cateIdList != null && cateIdList.size() > 0) {
                    String cateIds = StringUtils.join(cateIdList, ",");
                    queryCate.addHqlCondition("cateId in (" + cateIds + ")");
                    List<CateOrderRule> cateOrderRuleList = cateOrderRuleManager.search(queryCate);
                    Map<Long, CateOrderRuleVO> cateMap = new HashMap<>();
                    if (cateOrderRuleList != null) {
                        for (CateOrderRule rule : cateOrderRuleList) {
                            cateOrderRuleVO = new CateOrderRuleVO();
                            BeanUtils.copyProperties(rule, cateOrderRuleVO);
                            String rulePromptMsg = rule.getRulePromptMsg();
                            if (StringUtils.isNotBlank(rulePromptMsg)) {
                                List<PromptMsg> promptMsgList = (List<PromptMsg>) JsonUtil.JSON_String2List(rulePromptMsg, PromptMsg.class);
                                cateOrderRuleVO.setPromptMsgList(promptMsgList);
                            }
                            cateMap.put(rule.getCateId(), cateOrderRuleVO);
                        }
                    }

                    for (Long goodsId : goodsIdList) {
                        Long cateId = goodsCateMap.get(goodsId);
                        if (cateId != null) {
                            cateOrderRuleVO = cateMap.get(cateId);
                            ruleMap.put(goodsId, cateOrderRuleVO);
                        }
                    }
                    ret.setData(ruleMap);
                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                    ret.setReturnMsg("查询成功");
                } else {
                    ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                    ret.setReturnMsg("查询失败,cateId为空");
                }
            } else {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("查询失败，goodsId为空");
            }
        } catch (Exception e) {
            logger.error("查询分类规则支付失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询分类规则支付失败");
        }

        return ret;
    }

    /**
     * 根据商品id获取商品分类的订单取消规则
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<CateCancelRuleVO> getCateCancelRuleByGoodsId(Long goodsId) {
        logger.info("call getCateCancelRuleByGoodsId({\"goodsId\":" + goodsId + "}");

        ReturnObject<CateCancelRuleVO> ret = new ReturnObject<>();
        CateCancelRuleVO cateCancelRuleVO = null;

        try {
            Goods goods = goodsManager.get(goodsId);

            if (goods == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到商品信息，goodsId:" + goods);
                return ret;
            }

            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("cateId", goods.getCateId());
            queryModel.addColumnValueCondition("status", Constants.CATE_STATUS_ENABLE_TRUE);
            CateCancelRule cateCancelRule = cateCancelRuleManager.getUniqueResult(queryModel);

            if (cateCancelRule != null) {
                cateCancelRuleVO = new CateCancelRuleVO();
                BeanUtils.copyProperties(cateCancelRule, cateCancelRuleVO);
            }

            ret.setData(cateCancelRuleVO);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询分类取消规则失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询分类取消规则失败");
        }

        return ret;
    }

    /**
     * 上下架操作
     *
     * @param goodsId
     * @param enable
     * @return
     */
    @Override
    public ReturnObject setMarketEnable(Long goodsId, String enable) {
        logger.info("call deleteGoodsType({\"goodsId:\"" + goodsId + "\"enable:\"" + "+ enable +" + "})");

        ReturnObject ret = new ReturnObject();

        try {
            int deleteCount = goodsManager.setMarketEnable(goodsId, enable);
            if (deleteCount > 0) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("操作成功");
            } else {
                ret.setReturnCode(Constants.RETURN_CODE_ERROR);
                ret.setReturnMsg("操作失败");
            }
        } catch (Exception e) {
            logger.error("操作失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("操作失败");
        }

        return ret;
    }

    /**
     * 保存商品
     *
     * @param saveGoodsVO
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> saveGoods(SaveGoodsVO saveGoodsVO) {
        logger.info("call deleteGoodsType({\"saveGoodsVO:\"" + saveGoodsVO.toString() + "})");
        ReturnObject<GoodsVO> ret = new ReturnObject<>();

        try {
            GoodsInfo goodsInfo = saveGoodsVO.getGoodsInfo();
            Long goodsId = goodsInfo.getGoodsId();
            Goods goods = goodsManager.get(goodsId);
            CopyBeanUtil.copyPropertiesIgnoreNull(goodsInfo, goods);

            //将相册VO转换成model
            List<GoodsGalleryVO> galleryVOs = saveGoodsVO.getGallerys();
            List<GoodsGallery> galleries = null;
            if (galleryVOs != null && galleryVOs.size() > 0) {
                galleries = new ArrayList<GoodsGallery>();
                for (GoodsGalleryVO vo : galleryVOs) {
                    GoodsGallery gallery = new GoodsGallery();
                    BeanUtils.copyProperties(vo, gallery);
                    galleries.add(gallery);
                }
            }

            //保存商品 并修改商品相册信息
            goods = goodsManager.saveGoods(goods, galleries);
            GoodsVO goodsVO = new GoodsVO();
            CopyBeanUtil.copyPropertiesIgnoreNull(goods, goodsVO);

            ret.setData(goodsVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }
        return ret;
    }

    /**
     * 根据商品id获取商品图片信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<GoodsPictureVO> getGoodsPictureByGoodsId(Long goodsId) {
        logger.info("call getGoodsPictureByGoodsId({\"goodsId:\"" + goodsId + "})");
        ReturnObject<GoodsPictureVO> ret = new ReturnObject<>();

        try {
            //查询相册表
            ParamObject para = new ParamObject();
            para.add("goodsId", goodsId);
            List<GoodsGallery> galleryList = goodsGalleryManager.searchGalleryList(para);

            //获取图片ID集合
            List<Long> picIdList = null;
            if (galleryList != null && galleryList.size() > 0) {
                picIdList = new ArrayList<Long>();
                for (GoodsGallery gallery : galleryList) {
                    picIdList.add(gallery.getPicId());
                }
            }

            //根据图片ID查询图片
            List<PictureVO> picVOList = pictureService.searchPictureList(picIdList).getDataList();

            //生成 图片id ==>图片VO MAP
            Map<Long, PictureVO> picMap = new HashMap<>();
            for (PictureVO pictureVO : picVOList) {
                picMap.put(pictureVO.getPicId(), pictureVO);
            }

            //合并相册和图片内容
            List<GoodsPictureVO> goodsPictureVOList = new ArrayList<GoodsPictureVO>();
            GoodsPictureVO goodsPictureVO = null;
            GoodsPictureVO defaultGoodsPicture = null;
            PictureVO pictureVO = null;
            for (GoodsGallery gallery : galleryList) {
                pictureVO = picMap.get(gallery.getPicId());
                if (Constants.FLAG_TRUE.equals(gallery.getDefaultFlag())) {
                    defaultGoodsPicture = new GoodsPictureVO();
                    BeanUtils.copyProperties(pictureVO, defaultGoodsPicture);
                    BeanUtils.copyProperties(gallery, defaultGoodsPicture);
                }
                goodsPictureVO = new GoodsPictureVO();
                BeanUtils.copyProperties(pictureVO, goodsPictureVO);
                BeanUtils.copyProperties(gallery, goodsPictureVO);
                goodsPictureVOList.add(goodsPictureVO);
            }

            ret.setData(defaultGoodsPicture);
            ret.setDataList(goodsPictureVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("根据商品id获取商品图片信息失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("根据商品id获取商品图片信息失败");
        }

        return ret;

    }

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    @Override
    public ReturnObject saveSort(Map<Long, Integer> sortMap) {
        logger.info("call saveSort({\"sortMap:\"" + JsonUtil.JSON_Bean2String(sortMap) + "})");
        ReturnObject ret = new ReturnObject();
        try {
            goodsManager.saveSort(sortMap);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存排序成功");
        } catch (Exception e) {
            logger.error("保存排序失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存排序成功");
        }
        return ret;
    }

    /**
     * 根据商品id得到财务科目信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public ReturnObject<FinanceSubInfoVO> getFinanceSubjectByGoodsId(Long goodsId) {
        logger.info("call getFinanceSubjectByGoodsId({})", goodsId);

        ReturnObject<FinanceSubInfoVO> ret = new ReturnObject<>();
        FinanceSubInfoVO financeSubInfoVO = null;
        try {
            Goods goods = goodsManager.get(goodsId);

            if (goods == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到商品信息");
                return ret;
            }

            GoodsType goodsType = goodsTypeManager.get(goods.getTypeId());

            //Map<Long, FinanceSubjectVO> subMap = getFinanceSubjectMap();

            //financeSubjectVO = subMap.get(goodsType.getSubjectId());
            ReturnObject<FinanceSubjectVO> subRet = financeSubjectService.getFinanceSubjectById(goodsType.getSubjectId());
            if (subRet.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)) {
                financeSubInfoVO = new FinanceSubInfoVO();
                FinanceSubjectVO financeSubjectVO = subRet.getData();
                BeanUtils.copyProperties(financeSubjectVO, financeSubInfoVO);
            }

            if (financeSubInfoVO == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到科目信息");
                return ret;
            }

            ret.setData(financeSubInfoVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询成功失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }
        return ret;

    }

    /**
     * 查询goodtypebizscope
     *
     * @param goodId
     * @return
     */
    @Override
    public String searchBizScopeByGoodId(Long goodId) {
        logger.info("call searchBizScopeByGoodId({})", goodId);
        Goods goods = goodsManager.get(goodId);
        if (goods != null) {
            Long typeId = goods.getTypeId();
            GoodsType goodsType = goodsTypeManager.get(typeId);
            if (goodsType != null) {
                String bizScope = goodsType.getBizScope();
                return bizScope;
            }
        }
        return null;
    }

    /**
     * 根据id查询商品
     *
     * @param goodsIdList
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> getGoodVOByGoodIdList(List<String> goodsIdList) {
        logger.info("call getGoodVOByGoodIdList({})", goodsIdList);
        QueryModel queryModel = new QueryModel();
        ReturnObject returnObject = new ReturnObject();
        List<GoodsVO> goodsVOs = new ArrayList<>();
        try {
            String goodsId = StringUtils.join(goodsIdList, ",");
            if (StringUtils.isNotEmpty(goodsId)) {
                queryModel.addHqlCondition(" goodsId in (" + goodsId + ")");
                List<Goods> goodsList = goodsManager.search(queryModel);
                if (goodsList != null && goodsList.size() > 0) {
                    for (Goods goods : goodsList) {
                        GoodsVO goodsVO = new GoodsVO();
                        BeanUtils.copyProperties(goods, goodsVO);
                        goodsVOs.add(goodsVO);
                    }
                    returnObject.setDataList(goodsVOs);
                    returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 城家保洁查询商品列表
     *
     * @param goodsQO
     * @return
     */
    @Override
    public ReturnObject<GoodsVO> searchH5GoodsList(GoodsQO goodsQO) {
        logger.info("call searchH5GoodsList({})", JsonUtil.JSON_Bean2String(goodsQO));
        ReturnObject returnObject = new ReturnObject();
        List<GoodsVO> goodsVOList = new ArrayList<>();//查询商品的相册
        Map<Long, List<Long>> goodsIdPicIdMap = new HashMap<>();
        List<Long> picIdList = new ArrayList<>();
        Map<Long, GoodsVO> goodsVOMap = new HashMap<>();
        Map<Long,PictureVO> pictureVOMap=new HashMap<>();
        Set<Long> goodsIdSet = new HashSet<>();
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("bizScope", goodsQO.getBizScope());
            queryModel.addColumnValueCondition("marketEnable", Constants.GOODS_MARKETENABLE_YES);
            List<Goods> goodsList = goodsManager.search(queryModel);
            if (CheckUtil.checkListIsNull(goodsList)) {
                for (Goods goods : goodsList) {
                    GoodsVO goodsVO = new GoodsVO();
                    goodsIdSet.add(goods.getGoodsId());
                    CopyBeanUtil.copyPropertiesIgnoreNull(goods, goodsVO);
                    goodsVOMap.put(goodsVO.getGoodsId(), goodsVO);
                    goodsVOList.add(goodsVO);
                }
            }
            List<GoodsGallery> goodsGalleryList = goodsGalleryManager.searchGalleryList(goodsIdSet);
            if (CheckUtil.checkListIsNull(goodsGalleryList)) {
                for (GoodsGallery goodsGallery : goodsGalleryList) {
                    if (Constants.GOODS_PIC_DEFAULTFLAG.equals(goodsGallery.getDefaultFlag())) {//只查默认图片
                        List<Long> picIds = goodsIdPicIdMap.get(goodsGallery.getGoodsId());
                        if (CheckUtil.checkListIsNull(picIds)) {
                            picIds.add(goodsGallery.getPicId());
                            goodsIdPicIdMap.put(goodsGallery.getGoodsId(), picIds);
                        } else {
                            picIds = new ArrayList<>();
                            picIds.add(goodsGallery.getPicId());
                            goodsIdPicIdMap.put(goodsGallery.getGoodsId(),picIds);
                        }
                        picIdList.add(goodsGallery.getPicId());
                    }
                }
            }
            returnObject = pictureService.searchPictureList(picIdList);
            if (!Constants.RETURN_CODE_SUCCESS.equals(returnObject.getReturnCode())) {
                return returnObject;
            }
            List<PictureVO> pictureVOs = returnObject.getDataList();
            if(CheckUtil.checkListIsNull(pictureVOs)){
                for (PictureVO pictureVO:pictureVOs){
                    pictureVOMap.put(pictureVO.getPicId(),pictureVO);
                }
            }
            for(Map.Entry<Long, List<Long>> entry:goodsIdPicIdMap.entrySet()){
                List<Long> picIds=entry.getValue();
                GoodsVO goodsVO=goodsVOMap.get(entry.getKey());
                for(Long id:picIds){
                    PictureVO pictureVO=pictureVOMap.get(id);
                    if(pictureVO!=null){
                        GoodsPictureVO goodsPictureVO=new GoodsPictureVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(pictureVO,goodsPictureVO);
                        goodsVO.setDefaultGoodsPicture(goodsPictureVO);
                    }
                }
            }
            returnObject.setDataList(goodsVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call searchH5GoodsList error({})", e);
        }
        return returnObject;
    }
    /**
     * 保存商品评价
     * @param goodsCommentVO
     * @return
     */
    @Override
    public ReturnObject<GoodsCommentVO> saveGoodsCommentVO(GoodsCommentVO goodsCommentVO) {
        logger.info("call saveGoodsCommentVO({})", JsonUtil.JSON_Bean2String(goodsCommentVO));
        ReturnObject returnObject=new ReturnObject();
        try {
            GoodsComment goodsComment=new GoodsComment();
            CopyBeanUtil.copyPropertiesIgnoreNull(goodsCommentVO,goodsComment);
            goodsComment=goodsCommentManager.save(goodsComment);
            CopyBeanUtil.copyPropertiesIgnoreNull(goodsComment,goodsCommentVO);
            returnObject.setData(goodsCommentVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            logger.error("call saveGoodsCommentVO error({})", e);
        }
        return returnObject;
    }

    /**
     * 查询商品评价
     * @param goodsCommentQO
     * @return
     */
    @Override
    public ReturnObject<GoodsCommentVO> searchGoodsCommentVO(GoodsCommentQO goodsCommentQO) {
        logger.info("call saveGoodsCommentVO({})", JsonUtil.JSON_Bean2String(goodsCommentQO));
        ReturnObject returnObject=new ReturnObject();
        List<GoodsCommentVO> goodsCommentVOList=new ArrayList<>();
        try {
            if(null!=goodsCommentQO){
                QueryModel queryModel=new QueryModel();
                queryModel.addColumnValueCondition("showFlag",goodsCommentQO.getShowFlag());
                queryModel.addColumnValueCondition("goodsId",goodsCommentQO.getGoodsId());
                queryModel.addColumnValueCondition("commentStatus",goodsCommentQO.getCommentStatus());
                List<GoodsComment> goodsCommentList=goodsCommentManager.search(queryModel);
                if(CheckUtil.checkListIsNull(goodsCommentList)){
                    for(GoodsComment goodsComment:goodsCommentList){
                        GoodsCommentVO goodsCommentVO=new GoodsCommentVO();
                        CopyBeanUtil.copyPropertiesIgnoreNull(goodsComment,goodsCommentVO);
                        goodsCommentVOList.add(goodsCommentVO);
                    }
                }
            }
            returnObject.setDataList(goodsCommentVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.info("call saveGoodsCommentVO error({})",e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    private Map<Long, FinanceSubInfoVO> getFinanceSubjectMap() {
        Map<Long, FinanceSubInfoVO> map = new HashMap<>();
        FinanceSubInfoVO financeSubjectVO = null;

        //ReturnObject<GoodsFinanceSubjectVO> subRet = sysParamService.getGoodsFinanceSubjectList();
        ReturnObject<com.huazhu.hvip.common.vo.FinanceSubInfoVO> subRet = sysParamService.getFinanceSubjectList();

        logger.info("getFinanceSubjectMap----{}", JsonUtil.JSON_Bean2String(subRet));

        List<com.huazhu.hvip.common.vo.FinanceSubInfoVO> list = subRet.getDataList();

        if (list != null && list.size() != 0) {
            for (com.huazhu.hvip.common.vo.FinanceSubInfoVO sub : list) {
                financeSubjectVO = new FinanceSubInfoVO();
                BeanUtils.copyProperties(sub, financeSubjectVO);

                map.put(sub.getSubjectId(), financeSubjectVO);
            }
        }


        return map;
    }
}
