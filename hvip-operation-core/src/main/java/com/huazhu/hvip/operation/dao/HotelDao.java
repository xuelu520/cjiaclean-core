/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelDao.java
 * Author:   chenli
 * Date:     2016-03-23 17:33:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:33:35> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
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

public interface HotelDao extends GenericDao<Hotel, Long> {

    /**
     * 查询所有的有效的酒店
     * @param queryModel
     * @return
     */
    public List<Hotel> searchHotelList(QueryModel queryModel);

    /**
     * 根据参数获取酒店信息
     *
     * @param queryModel
     * @return
     */
    public Hotel getHotelByParam(QueryModel queryModel);

}
