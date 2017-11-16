package com.huazhu.hvip.inventory.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.qo.WarehouseQO;
import com.huazhu.hvip.inventory.vo.WarehouseVO;

/**
 * Created by DINGQIANQIAN on 2016/9/18.
 */
public interface WarehouseService {
    /**
     * 查询仓库
     * @param warehouseQO
     * @return
     */
    ReturnObject<WarehouseVO> listJson(WarehouseQO warehouseQO);

    /**
     * 新增
     * @param warehouseVO
     * @return
     */
    ReturnObject<WarehouseVO> addWarehouse(WarehouseVO warehouseVO);


    /**
     * 删除
     * @param ids
     * @return
     */
    ReturnObject<WarehouseVO> delWarehouse(String ids);

    /**
     * 查询仓库
     * @param id
     * @return
     */
    ReturnObject<WarehouseVO> getWarehouseById(Long id);
}
