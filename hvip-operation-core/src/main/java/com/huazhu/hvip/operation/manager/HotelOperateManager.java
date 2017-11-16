package com.huazhu.hvip.operation.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.model.HotelControlPrice;
import com.huazhu.hvip.operation.model.HotelControlPriceItem;
import com.huazhu.hvip.operation.model.extend.HotelControlPriceItemExt;

import java.util.List;

/**
 * Created by LYL on 2016/6/14.
 */
public interface HotelOperateManager extends GenericManager<HotelControlPrice, Long> {
    /**
     * 取消申请
     *
     * @param paramObject
     * @return
     */
    void updateHotelControlPriceItemStatus(ParamObject paramObject);
    /**
     * 根据Id查询HotelControlPriceItem
     * @param paramObject
     * @return
     */
    public List<HotelControlPriceItem> searchHotelControlPriceItem(ParamObject paramObject);
    /**
     * 保存酒店控制价格
     *
     * @param paramObject
     * @return
     */
    void saveControlitem(ParamObject paramObject);
    /**
     * 查询控制价格的操作记录
     *
     * @param paramObject
     * @return
     */
    List<HotelControlPrice> searchHotelOperateListByHotelNo(ParamObject paramObject);
}
