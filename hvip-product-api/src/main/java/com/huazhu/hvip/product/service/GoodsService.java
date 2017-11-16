/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsService.java
 * Author:   chenli
 * Date:     2016-03-21 17:05:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-21 17:05:06> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.qo.GoodsCommentQO;
import com.huazhu.hvip.product.qo.GoodsQO;
import com.huazhu.hvip.product.request.GoodsInfo;
import com.huazhu.hvip.product.request.SaveGoodsVO;
import com.huazhu.hvip.product.vo.*;

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

public interface GoodsService {

    /**
     * 根据cateId查询Goods
     *
     * @param cateId
     * @return ReturnObject  data：GoodsVO   data2：CateOrderRuleVO
     */
    ReturnObject<GoodsVO> searchGoodsListByCateId(Long cateId);


    /**
     * 根据酒店统一编号获取该酒店的商品信息列表
     *
     * @param hotelUniqueNo
     * @return dataList
     */
    ReturnObject<GoodsVO> searchGoodsListByHotelUniqueNo(String hotelUniqueNo);

    /**
     * 根据酒店统一编号获取该酒店的商品信息列表用于HMS价格控制
     *
     * @param hotelUniqueNo
     * @return dataList
     */
    ReturnObject<GoodsVO> searchGoodsListByHotelUniqueNo(String hotelUniqueNo, String HMS);

    /**
     * 根据查询条件获取该酒店的商品信息列表
     *
     * @param goodsQO
     * @param pageCondition
     * @return dataList
     */
    ReturnObject<GoodsVO> searchOpenGoodsListByHotelUniqueNo(GoodsQO goodsQO, PageCondition pageCondition);


    /**
     * 根据商品idList获取该酒店的商品信息列表
     *
     * @param goodsIdList
     * @param hotelId     //酒店id , 该字段用于查询商品库存及价格
     * @return
     */
    ReturnObject<GoodsVO> searchGoodsListByGoodsIdList(List<Long> goodsIdList, Long hotelId, String channelCode);

    /**
     * 根据商品id获取商品详情
     *
     * @param goodsQO 商品id
     * @return
     */
    ReturnObject<GoodsVO> getGoodsDetail(GoodsQO goodsQO);

    /**
     * 根据酒店统一编号获取该酒店的商品信息列表（已开通和未开通的都列出）
     *
     * @param goodsQO
     * @param page
     * @return
     */
    ReturnObject<GoodsVO> searchGoodsListByHotelUniqueNo(PageCondition page, GoodsQO goodsQO);

    /**
     * 查询所有商品(无查询条件)
     *
     * @return ReturnObject
     */
    ReturnObject<GoodsVO> getAll();

    /**
     * 自定义条件查询商品
     *
     * @return ReturnObject
     */
    ReturnObject<GoodsVO> searchGoodsList(ParamObject paramObject);

    /**
     * 根据id批量删除商品
     *
     * @param ids 类型ID
     * @return ret 通用返回参数
     */
    public ReturnObject deleteGoods(Long[] ids);

    /**
     * 保存商品
     *
     * @param goodsInfo
     * @return
     */
    ReturnObject<GoodsVO> saveGoods(GoodsInfo goodsInfo);

    /**
     * 根据id获取商品
     *
     * @param goodsId
     * @return
     */
    ReturnObject<GoodsVO> getGoodsById(Long goodsId);

    /**
     * 创建商品
     *
     * @param saveGoodsVO
     * @return
     */
    public ReturnObject<GoodsVO> createGoods(SaveGoodsVO saveGoodsVO);

    /**
     * 商品下单数+1
     *
     * @param goodsIdList
     * @return
     */
    ReturnObject addGoodsOrderCount(List<Long> goodsIdList);

    /**
     * (hms)根据酒店统一编号，商品名称，类型查找商品列表
     *
     * @return ReturnObject
     */
    ReturnObject<GoodsVO> searchGoodsList(GoodsQO goodsQO);

    /**
     * 根据商品id获取商品分类的订单支付规则
     *
     * @param goodsId
     * @return
     */
    ReturnObject<CateOrderRuleVO> getCateOrderRuleByGoodsId(Long goodsId);

    /**
     * 根据商品idList获取商品分类的订单支付规则
     *
     * @param goodsIdList
     * @return
     */
    ReturnObject<Map<Long, CateOrderRuleVO>> getCateOrderRuleByGoodsIdList(List<Long> goodsIdList);

    /**
     * 根据商品id获取商品分类的订单取消规则
     *
     * @param goodsId
     * @return
     */
    ReturnObject<CateCancelRuleVO> getCateCancelRuleByGoodsId(Long goodsId);


    /**
     * 上下架操作
     *
     * @param goodsId
     * @param enable
     * @return
     */
    ReturnObject setMarketEnable(Long goodsId, String enable);

    /**
     * 保存商品
     *
     * @param saveGoodsVO
     * @return
     */
    ReturnObject<GoodsVO> saveGoods(SaveGoodsVO saveGoodsVO);

    /**
     * 根据商品id获取商品图片信息
     *
     * @param goodsId
     * @return
     */
    ReturnObject<GoodsPictureVO> getGoodsPictureByGoodsId(Long goodsId);

    /**
     * 保存排序
     *
     * @param sortMap
     * @return
     */
    ReturnObject saveSort(Map<Long, Integer> sortMap);

    /**
     * 根据商品id得到财务科目信息
     *
     * @param goodsId
     * @return
     */
    ReturnObject<FinanceSubInfoVO> getFinanceSubjectByGoodsId(Long goodsId);

    /**
     * 查询goodtypebizscope
     * @param goodId
     * @return
     */
    String searchBizScopeByGoodId(Long goodId);

    /**
     * 根据id查询商品
     *
     * @param goodsIdList
     * @return
     */
    ReturnObject<GoodsVO> getGoodVOByGoodIdList(List<String> goodsIdList);

    /**
     * 城家保洁h5商品列表查询
     *
     * @param goodsQO
     * @return
     */
    ReturnObject<GoodsVO> searchH5GoodsList(GoodsQO goodsQO);

    /**
     * 保存商品评价
     * @param goodsCommentVO
     * @return
     */
    ReturnObject<GoodsCommentVO> saveGoodsCommentVO(GoodsCommentVO goodsCommentVO);

    /**
     * 查询商品评价
     * @param goodsCommentQO
     * @return
     */
    ReturnObject<GoodsCommentVO> searchGoodsCommentVO(GoodsCommentQO goodsCommentQO);
}
