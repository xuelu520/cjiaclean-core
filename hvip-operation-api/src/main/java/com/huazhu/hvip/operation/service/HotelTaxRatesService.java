package com.huazhu.hvip.operation.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.operation.vo.HotelTaxRatesVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface HotelTaxRatesService {

    /**
     * 批量保存酒店税率信息
     *
     * @param hotelTaxRatesVOList
     * @return
     */
    ReturnObject saveHotelTaxRatesList(List<HotelTaxRatesVO> hotelTaxRatesVOList);

}
