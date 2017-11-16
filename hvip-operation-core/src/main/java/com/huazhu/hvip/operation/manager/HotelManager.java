/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelManager.java
 * Author:   chenli
 * Date:     2016-03-23 17:25:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:25:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.operation.model.Hotel;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface HotelManager extends GenericManager<Hotel, Long> {

    /**
     * 查询所有有效酒店
     * @return
     */
    public ReturnObject<Hotel> searchHotelList(ParamObject paramObject);

    /**
     * 根据参数查询酒店信息
     * @param paramObject
     * @return
     */
    public Hotel getHotelByParam(ParamObject paramObject);


    /**
     * 更新酒店私人定制状态
     * @param paramObject
     * @return
     */
    public Integer updateHotelVipFlag(ParamObject paramObject);
}
