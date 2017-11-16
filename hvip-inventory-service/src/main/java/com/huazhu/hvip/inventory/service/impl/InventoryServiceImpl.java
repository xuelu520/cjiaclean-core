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
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.service.SerialNumService;
import com.huazhu.hvip.inventory.manager.InventoryManager;
import com.huazhu.hvip.inventory.manager.InventoryRecordManager;
import com.huazhu.hvip.inventory.manager.MeasureUnitManager;
import com.huazhu.hvip.inventory.manager.WarehouseManager;
import com.huazhu.hvip.inventory.model.Inventory;
import com.huazhu.hvip.inventory.model.InventoryRecord;
import com.huazhu.hvip.inventory.model.MeasureUnit;
import com.huazhu.hvip.inventory.model.Warehouse;
import com.huazhu.hvip.inventory.service.InventoryService;
import com.huazhu.hvip.inventory.vo.InventoryVO;
import com.huazhu.hvip.product.service.GoodsService;
import com.huazhu.hvip.product.vo.GoodsVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
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
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {

    private static Logger logger = LogManager.getLogger(InventoryServiceImpl.class);

    @Autowired
    private InventoryManager inventoryManager;

    @Autowired
    private WarehouseManager warehouseManager;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SerialNumService serialNumService;

    @Autowired
    private MeasureUnitManager measureUnitManager;

    @Autowired
    private InventoryRecordManager inventoryRecordManager;


    /**
     * 更新商品的库存
     *
     * @param inventoryVOList
     * @return
     */
    @Override
    public ReturnObject updateGoodsStore(List<InventoryVO> inventoryVOList) {
        logger.info("call updateGoodsStore({" + JsonUtil.JSON_List2String(inventoryVOList) + "})");
        ReturnObject returnObject = new ReturnObject();
        try {
            List<String> goodsIdList = new ArrayList<>();
            Map<String, GoodsVO> goodsVOMap = new HashMap<>();
            Map<String, InventoryVO> inventoryVOMap = new HashMap<>();
            InventoryVO inventoryVO = inventoryVOList.get(0);
          /*  if (StringUtils.isEmpty(inventoryVO.getHotelId())) { //判断是否有酒店ID
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
                returnObject.setReturnMsg("酒店id为空");
                return returnObject;
            }*/
            Warehouse warehouse = checkIsEsistEarehouse(inventoryVO); //查询仓库
            Long warehouseId = warehouse.getWarehouseId();
            for (InventoryVO inventory : inventoryVOList) {
                inventoryVOMap.put(inventory.getGoodsId().toString(), inventory);
                goodsIdList.add(inventory.getGoodsId().toString());
            }
            String goodsId = StringUtils.join(goodsIdList, ",");
            if (StringUtils.isEmpty(goodsId)) {
                returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
                returnObject.setReturnMsg("查询失败，没有商品Id");
                return returnObject;
            }
            ParamObject paramObject = new ParamObject();
            paramObject.add("goodsIdList", goodsIdList);
            returnObject = goodsService.getGoodVOByGoodIdList(goodsIdList);
            List<GoodsVO> goodsVOList = returnObject.getDataList();
            if (goodsVOList != null && goodsVOList.size() > 0) {
                for (GoodsVO goodsVO : goodsVOList) {
                    if (goodsVO.getUnitId() == null) {
                        returnObject.setReturnMsg("该商品还没有单位，请先设置单位goodsId:" + goodsVO.getGoodsId());
                        returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                        return returnObject;
                    }
                    goodsVOMap.put(goodsVO.getGoodsId().toString(), goodsVO);
                }
            }
            List<Inventory> inventoryList = saveInventory(goodsVOMap, inventoryVOMap, warehouseId, goodsId);
            if (inventoryList != null && inventoryList.size() > 0) {
                for (Inventory inventory : inventoryList) {
                    inventoryVO = inventoryVOMap.get(inventory.getGoodsId().toString());
                    InventoryRecord inventoryRecord = saveInventoryrecord(inventory, inventoryVO, goodsVOMap);
                    if (inventoryRecord != null) {
                        returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                    }
                }

            }
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg(e.getMessage());
        }
        return returnObject;
    }


    /**
     * 根据ID查询库存
     *
     * @param hotelId
     * @param goodsIdList
     * @return
     */

    @Override
    public ReturnObject<InventoryVO> searchInventoryByGoodsId(String hotelId, List<Long> goodsIdList) {
        logger.info("call searchInventoryByGoodsId({\"hotelId:\"" + hotelId + "},{\"goodsIdList:\"+" + JsonUtil.JSON_List2String(goodsIdList) + "})");
        ReturnObject returnObject = new ReturnObject();
        List<InventoryVO> inventoryVOList = null;
        try {
            inventoryVOList = new ArrayList<>();
            ParamObject paramObject = new ParamObject();
            paramObject.add("hotelId", hotelId);
            paramObject.add("goodsIdList", goodsIdList);
            List<Inventory> inventoryList = inventoryManager.searchInventoryByGoodsId(paramObject);
            if (inventoryList != null && inventoryList.size() > 0) {
                for (Inventory inventory : inventoryList) {
                    InventoryVO inventoryVO = new InventoryVO();
                    BeanUtils.copyProperties(inventory, inventoryVO);
                    inventoryVOList.add(inventoryVO);
                }
            }else {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
            }
            returnObject.setDataList(inventoryVOList);
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            logger.error("查询库存失败" + e.getMessage());
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }

    /**
     * 封装inventory
     *
     * @param inventory
     * @param warehouseId
     * @param goodsVO
     * @return
     */
    private Inventory setInventoryPram(Inventory inventory, Long warehouseId, GoodsVO goodsVO) {
        inventory.setUnit(goodsVO.getUnit());//单位
        inventory.setUnitId(goodsVO.getUnitId()); //单位id
        inventory.setMaterielId(null);//物料id
        inventory.setWarehouseId(warehouseId); //仓库id
        inventory.setGoodsId(goodsVO.getGoodsId()); //商品id
        inventory.setProductId(null);
        return inventory;
    }


    /**
     * 检测是该酒店是否有仓库
     *
     * @return
     */
    private Warehouse checkIsEsistEarehouse(InventoryVO inventoryVO) {
        Boolean flag = false;
        logger.info("call checkIsEsistEarehouse({\"inventoryVO:\"" + JsonUtil.JSON_Bean2String(inventoryVO) + "})");
        QueryModel queryModel = new QueryModel();
        /*queryModel.addColumnValueCondition("orgValue", inventoryVO.getHotelId());*/
        List<Warehouse> warehouseList = warehouseManager.search(queryModel);
        if (warehouseList != null && warehouseList.size() > 0) {
            flag = true;
        }
        Warehouse warehouse = new Warehouse();
        if (!flag) {//判断该酒店是否有仓库没有新建，有则查询
         /*   warehouse.setWarehouseName(inventoryVO.getHotelName());
            warehouse.setWarehouseType(Constants.WARHOUSETYPE_DEFAULT_TYPE);
            warehouse.setOrgType(Constants.DEPOT_ORGTYPE_HOTEL);
            warehouse.setOrgValue(inventoryVO.getHotelId());*/
            warehouse = warehouseManager.save(warehouse);
        } else {
            warehouse = warehouseList.get(0);
        }
        return warehouse;
    }

    /**
     * @param goodsVOMap
     * @param goodsId
     * @param inventoryVOMap
     * @param warehouseId
     * @return
     */
    private List<Inventory> saveInventory(Map<String, GoodsVO> goodsVOMap, Map<String, InventoryVO> inventoryVOMap, Long warehouseId, String goodsId) {
        logger.info("call saveInventory(productMap:{" + JsonUtil.JSON_Bean2String(goodsVOMap) + "\"},inventoryVOMap:" + JsonUtil.JSON_Bean2String(inventoryVOMap) + "\"},warehouseId:" + warehouseId + "\"})");
        List<Inventory> inventorys = new ArrayList<>();
        List<String> unitIdList = new ArrayList<>();
        Map<Long, Inventory> longInventoryMap = new HashMap<>();
        Map<Long, MeasureUnit> measureUnitMap = new HashMap<>();
        for (Map.Entry<String, GoodsVO> entry : goodsVOMap.entrySet()) {
            unitIdList.add(entry.getValue().getUnitId().toString());
        }
        QueryModel queryModel = new QueryModel();
        String unitId = StringUtils.join(unitIdList, ",");
        if (StringUtils.isEmpty(unitId)) {
            throw new RuntimeException("UnitId为空");
        }
        queryModel.addHqlCondition(" unitId in (" + unitId + ")");
        List<MeasureUnit> measureUnitList = measureUnitManager.search(queryModel);
        if (measureUnitList != null && measureUnitList.size() > 0) {
            for (MeasureUnit measureUnit : measureUnitList) {
                measureUnitMap.put(measureUnit.getUnitId(), measureUnit);
            }
        }
        queryModel = new QueryModel();
        queryModel.addColumnValueCondition("warehouseId", warehouseId.toString());//查询仓库
        List<Inventory> inventoryList = inventoryManager.search(queryModel);
        if (inventoryList != null && inventoryList.size() > 0) {//判断开通的商品是否有库存
            for (Inventory inventory : inventoryList) {
                longInventoryMap.put(inventory.getGoodsId(), inventory);
            }
            for (Map.Entry<String, InventoryVO> entry : inventoryVOMap.entrySet()) {
                InventoryVO inventoryVO = entry.getValue();
                GoodsVO goodsVO = goodsVOMap.get(entry.getKey());
                Inventory inventory = longInventoryMap.get(Long.valueOf(entry.getKey()));
                if (inventory != null) {//已有库存
                    MeasureUnit measureUnit = measureUnitMap.get(goodsVO.getUnitId());
                    inventory.setInventoryNum(inventory.getInventoryNum() + (inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate()));
                    inventory.setFreeInventoryNum(inventory.getFreeInventoryNum() + (inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate()));
                    inventory.setWarnInventoryNum(inventory.getWarnInventoryNum() + (inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate())); //安全库存
                    inventory = setInventoryPram(inventory, warehouseId, goodsVO);
                    inventory = inventoryManager.save(inventory);
                    inventorys.add(inventory);
                } else {
                    MeasureUnit measureUnit = measureUnitMap.get(goodsVO.getUnitId());
                    if(measureUnit==null){
                        throw new RuntimeException("该商品没有单位，商品id"+goodsVO.getGoodsId());
                    }
                    inventory = new Inventory();
                    inventory.setInventoryNum((inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate()));
                    inventory.setFreeInventoryNum((inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate()));
                    inventory.setWarnInventoryNum((inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate())); //安全库存
                    inventory = setInventoryPram(inventory, warehouseId, goodsVO);
                    inventory = inventoryManager.save(inventory);
                    inventorys.add(inventory);
                }
            }
        } else {//商品新开通库存
            for (Map.Entry<String, InventoryVO> entry : inventoryVOMap.entrySet()) {
                InventoryVO inventoryVO = entry.getValue();
                GoodsVO goodsVO = goodsVOMap.get(entry.getKey());
                MeasureUnit measureUnit = measureUnitMap.get(goodsVO.getUnitId());
                Inventory inventory = new Inventory();
                inventory.setInventoryNum((inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate()));
                inventory.setFreeInventoryNum((inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate()));
                inventory.setWarnInventoryNum((inventoryVO.getInventoryNum() * measureUnit.getBasicUnitRate())); //安全库存
                inventory = setInventoryPram(inventory, warehouseId, goodsVO);
                inventory = inventoryManager.save(inventory);
                inventorys.add(inventory);
            }
        }
        return inventorys;
    }

    /**
     * 添加存储记录
     *
     * @param inventory
     * @param inventoryVO
     * @param goodsVOMap
     * @return
     */
    private InventoryRecord saveInventoryrecord(Inventory inventory, InventoryVO inventoryVO, Map<String, GoodsVO> goodsVOMap) {
        logger.info("call saveInventory(inventoryList:{" + JsonUtil.JSON_List2String(inventory) + "\"},inventoryVO:" + JsonUtil.JSON_Bean2String(inventoryVO) + "\"},goodsVOMap:" + JsonUtil.JSON_Bean2String(goodsVOMap) + "\"})");
        InventoryRecord inventoryRecord = null;
        long count = 0;
        Map<Long, MeasureUnit> measureUnitMap = new HashMap<>();
        List<String> unitIdList = new ArrayList<>();
        for (Map.Entry<String, GoodsVO> entry : goodsVOMap.entrySet()) {
            unitIdList.add(entry.getValue().getUnitId().toString());
        }
        QueryModel queryModel = new QueryModel();
        String unitIds = StringUtils.join(unitIdList, ",");
        if (StringUtils.isNotEmpty(unitIds)) {
            queryModel.addHqlCondition(" unitId in (" + unitIds + ")");
            List<MeasureUnit> measureUnitList = measureUnitManager.search(queryModel);
            if (measureUnitList != null && measureUnitList.size() > 0) {
                for (MeasureUnit measureUnit : measureUnitList) {
                    measureUnitMap.put(measureUnit.getUnitId(), measureUnit);
                }
            }
        }
        inventoryRecord = new InventoryRecord();
        String voucherNo = serialNumService.generateVoucherNo();
       /* inventoryRecord.setVoucherNo(voucherNo);//凭证号
        inventoryRecord.setLineNum(++count);
        inventoryRecord.setGoodsId(inventory.getGoodsId());
        inventoryRecord.setProductId(inventory.getProductId());
        inventoryRecord.setMaterielId(inventory.getMaterielId());
        inventoryRecord.setWarehouseId(inventory.getWarehouseId());
        inventoryRecord.setOperateType(Constants.INVENTORYRECORD_OPERATETYPE_INVENTORY);
        if (inventoryVO.getInventoryNum() < 0) {
            inventoryRecord.setFlowType(Constants.INVENTORYRECORD_FLOWTYPE_OUT);
        } else {
            inventoryRecord.setFlowType(Constants.INVENTORYRECORD_FLOWTYPE_IN);
        }
        inventoryRecord.setMeasureUnit(inventoryVO.getUnit());
        inventoryRecord.setMeasureNum(inventoryVO.getInventoryNum());
        inventoryRecord.setBasicUnit(inventory.getUnit());
        MeasureUnit measureUnit = measureUnitMap.get(inventory.getUnitId());
        inventoryRecord.setBasicNum(inventoryVO.getInventoryNum() * (measureUnit.getBasicUnitRate()));*/
        Date date = new Date();
        inventoryRecord.setCreateTime(date);
        inventoryRecord.setUpdateTime(date);
        inventoryRecord.setCreateUser(inventoryVO.getCreateUser());
        inventoryRecord.setUpdateUser(inventoryVO.getUpdateUser());
        inventoryRecordManager.save(inventoryRecord);
        return inventoryRecord;
    }
}
