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

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.inventory.dao.InventoryRecordDao;
import com.huazhu.hvip.inventory.manager.InventoryRecordManager;
import com.huazhu.hvip.inventory.model.InventoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service("inventoryRecordManager")
public class InventoryRecordManagerImpl extends GenericManagerImpl<InventoryRecord,Long> implements InventoryRecordManager {

    InventoryRecordDao inventoryRecordDao;

    @Autowired
    public InventoryRecordManagerImpl(InventoryRecordDao inventoryRecordDao){
        super(inventoryRecordDao);
        this.inventoryRecordDao = inventoryRecordDao;
    }

    /**
     * 存
     * @param inventoryRecordList
     * @return
     */
    @Transactional
    @Override
    public List<InventoryRecord> saveInventoryRecordList(List<InventoryRecord> inventoryRecordList) {
        List<InventoryRecord> inventoryRecords=new ArrayList<>();
        for(InventoryRecord inventoryRecord:inventoryRecordList){
            inventoryRecords.add(inventoryRecordDao.save(inventoryRecord));
        }
        return inventoryRecords;
    }
}
