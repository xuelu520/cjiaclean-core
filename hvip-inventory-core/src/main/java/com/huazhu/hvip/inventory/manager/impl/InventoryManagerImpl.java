/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 14:32:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:32:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.inventory.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.inventory.dao.InventoryDao;
import com.huazhu.hvip.inventory.manager.InventoryManager;
import com.huazhu.hvip.inventory.manager.WarehouseManager;
import com.huazhu.hvip.inventory.model.Inventory;
import com.huazhu.hvip.inventory.model.Warehouse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("inventoryManager")
public class InventoryManagerImpl extends GenericManagerImpl<Inventory, Long> implements InventoryManager {

    InventoryDao inventoryDao;

    @Autowired
    public InventoryManagerImpl(InventoryDao inventoryDao) {
        super(inventoryDao);
        this.inventoryDao = inventoryDao;
    }

    @Autowired
    private WarehouseManager warehouseManager;

    /**
     * 根据条件查询库存
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Inventory> searchInventoryByGoodsId(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();
        List<Inventory> inventoryList = new ArrayList<>();
        String hotelId = paramObject.getStringParam("hotelId");
        List<Long> goodsIdList = (List<Long>) paramObject.getParam("goodsIdList");
        if (StringUtils.isEmpty(hotelId)) {
            return new ArrayList<>();
        }
        queryModel.addColumnValueCondition("orgValue", hotelId);
        Warehouse warehouse = warehouseManager.getUniqueResult(queryModel);
        if (warehouse != null) {
            Long warehouseId = warehouse.getWarehouseId();
            String goodId = StringUtils.join(goodsIdList, ",");
            queryModel = new QueryModel();
            if (StringUtils.isNotEmpty(goodId)) {
                queryModel.addHqlCondition(" goodsId in (" + goodId + ")");
            }
            queryModel.addColumnValueCondition("warehouseId", warehouseId);
            inventoryList = inventoryDao.search(queryModel);
        }
        return inventoryList;
    }
}
