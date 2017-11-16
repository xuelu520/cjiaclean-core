/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelGoodsService.java
 * Author:   chenli
 * Date:     2016-03-23 17:54:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:54:05> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.qo.HotelQO;
import com.huazhu.hvip.operation.vo.HotelGoodsVO;

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

public interface HotelGoodsService {

    /**
     * 根据酒店统一编号获取该酒店已开通的商品列表
     *
     * @return dataList 分类列表
     */
    public ReturnObject<HotelGoodsVO> searchOpenGoodsByHotelQO(HotelQO hotelQO);

    /**
     * 根据用户勾选，修改酒店开通商品列表
     *
     * @param hotelId   酒店id
     * @param goodsMap  用户勾选的商品
     * @return
     */
    public ReturnObject saveOpenGoodsByHotelId(Long hotelId , Map<Long,String> goodsMap, boolean appendFlag);

    /**
     * 通过商品的Id查询酒店的订单
     * @param goodsId
     * @return
     */
    public ReturnObject<HotelGoodsVO> searchHotelByGoodsId(Long goodsId);

    /**
     * 更新酒店的商品cateId
     * @param hotelGoodsVOList
     * @return
     */
    public ReturnObject<HotelGoodsVO> saveHotelGoodsCateId(List<HotelGoodsVO> hotelGoodsVOList);



    /**
     * 更新酒店的开通商品和未开通
     * @param hotelQO
     * @return
     */
    public ReturnObject<HotelGoodsVO> searchOpenGoodsAndNoOpen(HotelQO hotelQO);


    /**
     * 开通酒店商品
     * @param hotelGoodsVOs
     * @return
     */
    public ReturnObject<HotelGoodsVO> saveHotelGoodsVOList(List<HotelGoodsVO> hotelGoodsVOs);

}
