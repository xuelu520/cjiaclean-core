/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCateService.java
 * Author:   chenli
 * Date:     2016-03-23 17:52:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:52:45> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.service;

import com.huazhu.hvip.base.exception.BizException;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.vo.HotelCateVO;

import java.util.HashMap;
import java.util.Map;

/**
 * 酒店开通分类信息相关接口api
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface HotelCateService {

    /**
     * 根据酒店统一编号获取该酒店已开通的分类列表
     *
     * @param hotelUniqueNo 酒店统一编号
     * @return dataList 分类列表
     */
    public ReturnObject<HotelCateVO> searchOpenCateByHotelUniqueNo(String hotelUniqueNo);

    /**
     * 根据用户勾选，修改酒店开通分类列表
     *
     * @param hotelId 酒店id
     * @param cateMap 用户勾选的分类
     * @param appendFlag 是否追加
     * @return
     */
    public ReturnObject saveOpenCateByHotelId(Long hotelId , Map<Long,String> cateMap , boolean appendFlag);

}
