/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-21 10:30:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:30:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.inventory.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.manager.InventoryRecordManager;
import com.huazhu.hvip.inventory.model.InventoryRecord;
import com.huazhu.hvip.inventory.service.InventoryRecordService;
import com.huazhu.hvip.inventory.vo.InventoryRecordVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("inventoryRecordService")
public class InventoryRecordServiceImpl implements InventoryRecordService {

    private static Logger logger = LogManager.getLogger(InventoryRecordServiceImpl.class);

    @Autowired
    private InventoryRecordManager inventoryRecordManager;

    /**
     * 更新库存记录的状态
     *
     * @param inventoryRecordVOList
     * @return
     */
    @Override
    public ReturnObject<InventoryRecordVO> saveInventoryRecord(List<InventoryRecordVO> inventoryRecordVOList) {
        logger.info("call returnInventoryRecord({})", JsonUtil.JSON_List2String(inventoryRecordVOList));
        ReturnObject returnObject = new ReturnObject();
        Map<Long, InventoryRecord> longInventoryRecordMap = new HashMap<>();
        try {
            if (inventoryRecordVOList == null || inventoryRecordVOList.size() == 0) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("集合为空");
                return returnObject;
            }
            Set<Long> materielIdList = new HashSet<>();
            for (InventoryRecordVO inventoryRecordVO : inventoryRecordVOList) {
                materielIdList.add(inventoryRecordVO.getMaterielId());
            }
            if (materielIdList.size() > 0) {
                String materielIds = StringUtils.join(materielIdList, ",");
                QueryModel queryModel = new QueryModel();
                queryModel.addColumnValueCondition("employeeId", inventoryRecordVOList.get(0).getEmployeeId());
                queryModel.addColumnValueCondition("status", Constants.INVENTORY_RECORD_USING);
                queryModel.addHqlCondition(" materielId in (" + materielIds + ")");
                List<InventoryRecord> inventoryRecordList = inventoryRecordManager.search(queryModel);
                if (inventoryRecordList != null && inventoryRecordList.size() > 0) {//更改
                    for (InventoryRecord inventoryRecord : inventoryRecordList) {
                        longInventoryRecordMap.put(inventoryRecord.getMaterielId(), inventoryRecord);
                    }
                }
                inventoryRecordList.clear();
                for (InventoryRecordVO inventoryRecordVO : inventoryRecordVOList) {//遍历传进来的集合
                    InventoryRecord inventoryRecord = longInventoryRecordMap.get(inventoryRecordVO.getMaterielId());
                    if (inventoryRecord != null) {//不为空,则有归还与在领用物料
                        inventoryRecord.setUpdateUser(inventoryRecordVO.getUpdateUser());
                        inventoryRecord.setUpdateTime(inventoryRecordVO.getUpdateTime());
                        if (inventoryRecordVO.getNumber() == null || inventoryRecordVO.getNumber() <= 0) {
                            returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                            returnObject.setReturnMsg("数量有问题");
                            return returnObject;
                        }
                        if (Constants.INVENTORYRECORD_FLOWTYPE_IN.equals(inventoryRecordVO.getOperateFlag())) {//归还物料
                            if (inventoryRecordVO.getNumber() > inventoryRecord.getNumber()) {
                                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                                returnObject.setReturnMsg("数量有问题");
                                return returnObject;
                            }
                            inventoryRecord.setNumber(inventoryRecord.getNumber() - inventoryRecordVO.getNumber());
                        } else if (Constants.INVENTORYRECORD_FLOWTYPE_OUT.equals(inventoryRecordVO.getOperateFlag())) {//再次领用物料
                            inventoryRecord.setNumber(inventoryRecord.getNumber() + inventoryRecordVO.getNumber());
                        }
                        if (inventoryRecord.getNumber() == 0) {//数量为0则归还完毕
                            inventoryRecord.setStatus(Constants.INVENTORY_RECORD_RETURNAll);
                        }
                    } else if (Constants.INVENTORYRECORD_FLOWTYPE_OUT.equals(inventoryRecordVO.getOperateFlag())) {//第一次申请物料
                        inventoryRecord = new InventoryRecord();
                        CopyBeanUtil.copyPropertiesIgnoreNull(inventoryRecordVO, inventoryRecord);
                    }
                    if (inventoryRecord != null) {
                        inventoryRecordList.add(inventoryRecord);
                    }
                }
                inventoryRecordList = inventoryRecordManager.saveInventoryRecordList(inventoryRecordList);
                inventoryRecordVOList.clear();
                for (InventoryRecord inventoryRecord : inventoryRecordList) {
                    InventoryRecordVO inventoryRecordVO = new InventoryRecordVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(inventoryRecord, inventoryRecordVO);
                    inventoryRecordVOList.add(inventoryRecordVO);
                }
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                returnObject.setDataList(inventoryRecordVOList);
            }
        } catch (Exception e) {
            logger.error("call returnInventoryRecord error({})", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("更改异常");
        }
        return returnObject;
    }
}
