/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCateManager.java
 * Author:   chenli
 * Date:     2016-03-23 17:27:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:27:48> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.model.HotelCate;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface HotelCateManager extends GenericManager<HotelCate, Long> {

    /**
     * 更新酒店商品分类
     *
     * @param paramObject
     * @return
     */
    public ReturnObject updateOpenCateByHotelId(ParamObject paramObject);

    /**
     * 根据酒店Id查询酒店开通的类型
     * @param paramObject
     * @return
     */
    List<HotelCate> searchByhotelIdList(ParamObject paramObject);
}
