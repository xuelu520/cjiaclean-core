/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelService.java
 * Author:   chenli
 * Date:     2016-03-23 17:52:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:52:35> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.vo.HotelControlPriceVO;
import com.huazhu.hvip.operation.vo.HotelDataVO;
import com.huazhu.hvip.operation.vo.HotelOperateVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface HotelOperateService {

    /**
     * 查询hotel操作商品价格的数据
     * @param hotelOperateVO
     * @return
     */
    public ReturnObject searchHotelOperateList(HotelOperateVO hotelOperateVO);

    /**
     * 取消申请
     *
     * @param hotelOperateVO
     * @return
     */
    public ReturnObject updateHotelControlPriceItemStatus(HotelOperateVO hotelOperateVO);

    /**
     * 根据Id查询HotelControlPriceItem
     * @param hotelOperateVO
     * @return
     */
    public ReturnObject searchHotelControlPriceItem(HotelOperateVO hotelOperateVO);

    /**
     * 保存酒店控制价格
     * @param hotelDataVO
     * @return
     */
    public ReturnObject saveControlitem(HotelDataVO hotelDataVO);

    /**
     * OP查询门店申请表格数据
     *
     * @param paramObject
     * @return
     */
    public ReturnObject searchApplyManagerList(ParamObject paramObject);

    /**
     * 保存hotelControlPrice状态
     * @param hotelControlPriceVO
     * @return
     */
    public ReturnObject saveHotelControlPrice(HotelControlPriceVO hotelControlPriceVO);

    /**
     * 根据酒店No去查询CrontrolPrice
     * @param hotelControlPriceVO
     * @return
     */
    public ReturnObject searchHotelCrontrolPriceByHotelNo(HotelControlPriceVO hotelControlPriceVO);
}
