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
import com.huazhu.hvip.operation.qo.HotelQO;
import com.huazhu.hvip.operation.vo.HotelVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface HotelService {

    /**
     * 分页查询酒店
     * @param paramObject
     * @return
     */
    public ReturnObject<HotelVO> seachHotelList(ParamObject paramObject);

    /**
     * 更新酒店私人定制状态
     * @param  openVipFlag , hotelId
     * @return
     */
    public ReturnObject updateVipFlag(String openVipFlag ,Long hotelId);

    /**
     * 根据酒店统一编号获取酒店信息
     *
     * @param hotelUniqueNo
     * @return
     */
    public ReturnObject<HotelVO> getHotelByHotelUniqueNo(String hotelUniqueNo);

    /**
     * 根据查询条件获取酒店信息
     *
     * @param hotelQO
     * @return
     */
    public ReturnObject<HotelVO> getHotelByHotelQO(HotelQO hotelQO);


    /**
     * 保存公寓信息
     *
     * @param hotelVO
     * @return
     */
    public ReturnObject<HotelVO> saveHotelVO(HotelVO hotelVO);

}
