package com.huazhu.hvip.inventory.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.vo.InventoryRecordVO;

import java.util.List;

/**
 * Created by DINGQIANQIAN on 2016/9/18.
 */
public interface InventoryRecordService {

    /**
     *保存
     *
     * @return
     */
    ReturnObject<InventoryRecordVO> saveInventoryRecord(List<InventoryRecordVO> inventoryRecordVOList);
}
