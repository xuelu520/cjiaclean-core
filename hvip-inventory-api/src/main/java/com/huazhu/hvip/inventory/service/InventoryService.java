package com.huazhu.hvip.inventory.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.vo.InventoryVO;

import java.util.List;
import java.util.Map;

/**
 * Created by DINGQIANQIAN on 2016/9/18.
 */
public interface InventoryService {

    /**
     * 更新商品的库存
     *
     * @param inventoryVOList
     * @return
     */
    ReturnObject updateGoodsStore(List<InventoryVO> inventoryVOList);

    /**
     * 根据ID查询库存
     *
     * @param hotelId
     * @param goodsIdList
     * @return
     */
    ReturnObject<InventoryVO> searchInventoryByGoodsId(String hotelId,List<Long> goodsIdList);
}
