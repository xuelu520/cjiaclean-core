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
import com.huazhu.hvip.inventory.manager.WarehouseManager;
import com.huazhu.hvip.inventory.model.Warehouse;
import com.huazhu.hvip.inventory.qo.WarehouseQO;
import com.huazhu.hvip.inventory.service.WarehouseService;
import com.huazhu.hvip.inventory.vo.WarehouseVO;
import com.huazhu.hvip.util.CopyBeanUtil;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@Service("WarehouseService")
public class WarehouseServiceImpl implements WarehouseService {

    private static Logger logger = LogManager.getLogger(WarehouseServiceImpl.class);

    @Autowired
    private WarehouseManager warehouseManager;

    /**
     * 查询仓库
     *
     * @param warehouseQO
     * @return
     */
    @Override
    public ReturnObject<WarehouseVO> listJson(WarehouseQO warehouseQO) {
        logger.info("call listJson()");
        ReturnObject returnObject = null;
        try {
            List<WarehouseVO> warehouseVOList = new ArrayList<>();
            returnObject = new ReturnObject();
            QueryModel queryModel = new QueryModel();
            queryModel.setPageNo(warehouseQO.getPageNo());
            queryModel.setPageSize(warehouseQO.getPageSize());
            queryModel.addColumnValueCondition("warehouseName", warehouseQO.getWarehouseName());
            queryModel.addColumnValueCondition("provinceId", warehouseQO.getProvinceId());
            queryModel.addColumnValueCondition("cityId", warehouseQO.getCityId());
            queryModel.addColumnValueCondition("regionId", warehouseQO.getRegionId());
            queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
            List<Warehouse> warehouseList = warehouseManager.search(queryModel);
            if (warehouseList != null && warehouseList.size() > 0) {
                for (Warehouse warehouse : warehouseList) {
                    WarehouseVO warehouseVO = new WarehouseVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(warehouse, warehouseVO);
                    warehouseVOList.add(warehouseVO);
                }
            }
            returnObject.setTotalSize(warehouseList.size());
            returnObject.setDataList(warehouseVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call listJson() error",e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }


    /**
     * 添加仓库
     *
     * @param warehouseVO
     * @return
     */
    @Override
    public ReturnObject<WarehouseVO> addWarehouse(WarehouseVO warehouseVO) {
        logger.info("call addWarehouse()", JsonUtil.JSON_Bean2String(warehouseVO));
        ReturnObject returnObject = new ReturnObject();
        try {
            if (warehouseVO != null && warehouseVO.getWarehouseId() != null) {
                Warehouse warehouse = warehouseManager.get(warehouseVO.getWarehouseId());
                CopyBeanUtil.copyPropertiesIgnoreNull(warehouseVO, warehouse);
                warehouse = warehouseManager.save(warehouse);
                CopyBeanUtil.copyPropertiesIgnoreNull(warehouse, warehouseVO);
            } else {
                Warehouse warehouse = new Warehouse();
                CopyBeanUtil.copyPropertiesIgnoreNull(warehouseVO, warehouse);
                warehouse = warehouseManager.save(warehouse);
                CopyBeanUtil.copyPropertiesIgnoreNull(warehouse, warehouseVO);
            }
            returnObject.setData(warehouseVO);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call addWarehouse error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @Override
    public ReturnObject<WarehouseVO> delWarehouse(String ids) {
        logger.info("call delWarehouse()", ids);
        ReturnObject returnObject = new ReturnObject();
        try {
            if (StringUtils.isNotBlank(ids)) {
                QueryModel queryModel = new QueryModel();
                queryModel.addHqlCondition(" warehouseId in (" + ids + ")");
                List<Warehouse> warehouseList = warehouseManager.search(queryModel);
                if (warehouseList != null && warehouseList.size() > 0) {
                    for (Warehouse warehouse : warehouseList) {
                        warehouse.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
                        warehouseManager.save(warehouse);
                    }
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call delWarehouse error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 查询仓库
     *
     * @param id
     * @return
     */
    @Override
    public ReturnObject<WarehouseVO> getWarehouseById(Long id) {
        logger.info("call getWarehouseById()", id);
        ReturnObject returnObject = new ReturnObject();
        try {
            if (id != null) {
                Warehouse warehouse = warehouseManager.get(id);
                WarehouseVO warehouseVO = new WarehouseVO();
                CopyBeanUtil.copyPropertiesIgnoreNull(warehouse, warehouseVO);
                returnObject.setData(warehouseVO);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (Exception e) {
            logger.error("call getWarehouseById error()", e);
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
