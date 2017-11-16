/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SpecificationManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.GoodsDao;
import com.huazhu.hvip.product.goods.dao.GoodsStoreDao;
import com.huazhu.hvip.product.goods.dao.StoreRecordDao;
import com.huazhu.hvip.product.goods.manager.DepotManager;
import com.huazhu.hvip.product.goods.manager.GoodsStoreManager;
import com.huazhu.hvip.product.goods.model.Depot;
import com.huazhu.hvip.product.goods.model.Goods;
import com.huazhu.hvip.product.goods.model.GoodsStore;
import com.huazhu.hvip.product.goods.model.StoreRecord;
import com.huazhu.hvip.product.goods.model.extend.ChangeStoreInfo;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service("goodsStoreManager")
public class GoodsStoreManagerImpl extends GenericManagerImpl<GoodsStore, Long> implements GoodsStoreManager {

    private static Logger logger = LogManager.getLogger(GoodsStoreManagerImpl.class);

    private GoodsStoreDao goodsStoreDao;

    private StoreRecordDao storeRecordDao;

    private DepotManager depotManager;
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    public void setDepotManager(DepotManager depotManager) {
        this.depotManager = depotManager;
    }

    @Autowired
    public void setGoodsStoreDao(GoodsStoreDao goodsStoreDao) {
        this.goodsStoreDao = goodsStoreDao;
    }

    @Autowired
    public void setStoreRecordDao(StoreRecordDao storeRecordDao) {
        this.storeRecordDao = storeRecordDao;
    }

    /**
     * 根据条件查询商品库存列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<GoodsStore> searchGoodsStoreList(ParamObject paramObject) {
        logger.info("call searchGoodsStoreList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        Long hotelId = paramObject.getLongParam("hotelId"); //酒店id
        List<Long> goodsIdList = (List<Long>) paramObject.getParam("goodsIdList"); //商品id list
        List<Long> productIdList = (List<Long>) paramObject.getParam("productIdList"); //货品id list

        QueryModel queryModel = new QueryModel();

        if (hotelId != null) {
            queryModel.addColumnValueCondition("d.orgType", Constants.DEPOT_ORGTYPE_HOTEL);
            queryModel.addColumnValueCondition("d.orgId", hotelId);
        }

        if (goodsIdList != null && goodsIdList.size() > 0) {
            queryModel.addColumnValueCondition("gs.goodsId", QueryModel.OPERATOR_IN, "(" + StringUtils.join(goodsIdList, ",") + ")");
        }

        if (productIdList != null && productIdList.size() > 0) {
            queryModel.addColumnValueCondition("gs.productId", QueryModel.OPERATOR_IN, "(" + StringUtils.join(productIdList, ",") + ")");
        }

        List<GoodsStore> goodsStoreList = goodsStoreDao.searchGoodsStore(queryModel);

        return goodsStoreList;
    }

    /**
     * 更新或保存商品库存
     *
     * @param paramObject
     * @return
     */
    @Transactional//多表查询加事务
    @Override
    public ReturnObject updateGoodsStore(ParamObject paramObject) {

        ReturnObject ret = new ReturnObject();

        Long hotelId = paramObject.getLongParam("hotelId");
        Map<Long, Integer> goodsStoreMap = (Map<Long, Integer>) paramObject.getParam("goodsStoreMap");//用户传入的map，key：goodsId，value：storeNum

        Map<Long, GoodsStore> gsMap = new HashMap();//用于存放goodsStore原本的数据

        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("orgId", hotelId);
        queryModel.addColumnValueCondition("orgType", Constants.DEPOT_ORGTYPE_HOTEL);
        Depot depot = depotManager.getUniqueResult(queryModel);
        if (depot == null) {
            depot = new Depot();
            depot.setOrgType(Constants.DEPOT_ORGTYPE_HOTEL);
            depot.setOrgId(hotelId);
            depot.setDepotName("酒店" + hotelId);

            depot = depotManager.save(depot);//新增一个库房数据
        }
        if (goodsStoreMap != null) {
            Long depotId = depot.getDepotId();
            QueryModel queryModel1 = new QueryModel();
            queryModel1.addColumnValueCondition("depotId", depotId);
            List<GoodsStore> goodsStoreList = goodsStoreDao.search(queryModel1);

            if (goodsStoreList != null && goodsStoreList.size() > 0) {
                for (GoodsStore goodsStore : goodsStoreList) {
                    gsMap.put(goodsStore.getGoodsId(), goodsStore);//将goodsId和对应depotId下的商品库存绑定在一起
                }
            }

            Iterator it = goodsStoreMap.entrySet().iterator();
            Map.Entry entry = null;
            GoodsStore goodsStore = null;

            while (it.hasNext()) {
                entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                Long goodsId = Long.valueOf(key.toString());
                Integer storeNum = Integer.valueOf(value.toString());

                goodsStore = gsMap.get(goodsId);
                //假如在库存表中查不到这条数据
                if (goodsStore == null) {
                    goodsStore = new GoodsStore();
                    goodsStore.setDepotId(depotId);
                    goodsStore.setGoodsId(goodsId);
                    goodsStore.setStoreNum(storeNum);
                    goodsStore.setFreeStoreNum(storeNum);
                } else {
                    Integer oldFreeStoreNum = goodsStore.getFreeStoreNum();//获取修改前的可用库存
                    Integer oldStoreNum = goodsStore.getStoreNum();//获取修改前的库存
                    Integer difference = oldStoreNum - storeNum;//计算出差
                    Integer freeStoreNum = oldFreeStoreNum - difference;
                    goodsStore.setDepotId(depotId);
                    goodsStore.setGoodsId(goodsId);
                    goodsStore.setStoreNum(storeNum);
                    goodsStore.setFreeStoreNum(freeStoreNum);

                    storeNum = 0 - difference;
                }
                goodsStoreDao.save(goodsStore);
                ret.setObject(goodsStore);
                Date nowDate = new Date();
                //记录库存操作记录
                StoreRecord storeRecord = new StoreRecord();
                storeRecord.setGoodsId(goodsStore.getGoodsId());
                storeRecord.setDepotId(goodsStore.getDepotId());
                storeRecord.setOpType(Constants.CHANGESTORE_TYPE_OPSET + "");
                storeRecord.setNum(storeNum);
                storeRecord.setRemark(" 修改库存，修改库存以及可用库存数量：" + storeNum);
                storeRecord.setCreateTime(nowDate);
                storeRecord.setUpdateTime(nowDate);

                storeRecord.setCreateUser("op");
                storeRecord.setUpdateUser("op");
                storeRecordDao.save(storeRecord);
            }
        } else {
            Long depotId = depot.getDepotId();
            List<String> goodsIdList = (List<String>) paramObject.getParam("goodsId");
            String goodsId= StringUtils.join(goodsIdList, ",");
            if(StringUtils.isNotEmpty(goodsId)){
                queryModel = new QueryModel();
                queryModel.addColumnValueCondition("depotId", depotId);
                queryModel.addHqlCondition(" goodsId in (" + goodsId + ")");
                List<GoodsStore> goodsStoreList = goodsStoreDao.search(queryModel);
                if (goodsIdList == null) {
                    for (GoodsStore goodsStore : goodsStoreList) {
                        goodsStoreDao.remove(goodsStore);
                    }
                } else {
                    if(goodsStoreList!=null && goodsStoreList.size()>0){
                        for(GoodsStore goodsStore:goodsStoreList){
                            goodsStoreDao.remove(goodsStore);
                        }
                    }
                }
            }
        }
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("新增商品库存成功");
        return ret;
    }

    /**
     * 修改商品库存
     *
     * @param goodsStoreList
     * @param csMap
     * @param operatorInfo
     * @return
     */
    @Transactional
    @Override
    public ReturnObject changeGoodsStore(List<GoodsStore> goodsStoreList, Map<Long, ChangeStoreInfo> csMap, OperatorInfo operatorInfo) {
        logger.info("call changeGoodsStore({\"newGoodsStoreList:\"" + JsonUtil.JSON_List2String(goodsStoreList) + "},{\"newGoodsStoreList:\"" + JsonUtil.JSON_Bean2String(operatorInfo) + "})");

        ReturnObject ret = new ReturnObject();

        ChangeStoreInfo changeStoreInfo = null;

        for (GoodsStore goodsStore : goodsStoreList) {
            changeStoreInfo = csMap.get(goodsStore.getGoodsStoreId());

            if (changeStoreInfo == null) {
                continue;
            }

            Integer storeNum = goodsStore.getStoreNum(); //库存数
            Integer freeStoreNum = goodsStore.getFreeStoreNum(); //可用库存数

            Integer changeType = changeStoreInfo.getChangeType(); //改变类型 1.下单 2.发货 3.退货收货
            Integer changeNum = changeStoreInfo.getChangeNum();

            if (changeType != null && changeType.equals(Constants.CHANGESTORE_TYPE_BOOK)) { //下单
                //可用库存减下单商品数量
                freeStoreNum = freeStoreNum - changeNum;
            } else if (changeType != null && changeType.equals(Constants.CHANGESTORE_TYPE_SHIP)) { //发货
                //库存减商品数量
                storeNum = storeNum - changeNum;
            } else if (changeType != null && changeType.equals(Constants.CHANGESTORE_TYPE_REFUND)) { //退货收货
                //库存+商品数量
                storeNum = storeNum + changeNum;
                //可用库存+商品数量
                freeStoreNum = freeStoreNum + changeNum;
            } else if (changeType != null && changeType.equals(Constants.CHANGESTORE_TYPE_CAL)) { //未付款取消
                //库存+商品数量
                //storeNum = storeNum + changeNum;
                //可用库存+商品数量
                freeStoreNum = freeStoreNum + changeNum;
            } else if (changeType != null && changeType.equals(Constants.CHANGESTORE_TYPE_DEL)) { //未付款删除
                //库存+商品数量
                //storeNum = storeNum + changeNum;
                //可用库存+商品数量
                freeStoreNum = freeStoreNum + changeNum;
            } else {
                continue;
            }

            //修改库存
            goodsStore.setStoreNum(storeNum);
            goodsStore.setFreeStoreNum(freeStoreNum);

            goodsStoreDao.save(goodsStore);

            Date nowDate = new Date();

            //记录库存操作记录
            StoreRecord storeRecord = new StoreRecord();
            storeRecord.setGoodsId(goodsStore.getGoodsId());
            storeRecord.setDepotId(goodsStore.getDepotId());
            storeRecord.setOpType(changeType + "");
            storeRecord.setNum(changeNum);
            storeRecord.setRemark(changeStoreInfo.getRemark());
            storeRecord.setCreateTime(nowDate);
            storeRecord.setUpdateTime(nowDate);

            if (operatorInfo != null) {
                storeRecord.setCreateUser(operatorInfo.getOperatorName());
                storeRecord.setUpdateUser(operatorInfo.getOperatorName());
            }

            storeRecordDao.save(storeRecord);
        }

        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("修改商品库存成功");

        return ret;
    }

    /**
     * 关闭开通删除库存
     *
     * @param paramObject
     */
    @Override
    public void removeHotelGoodStore(ParamObject paramObject) {
        String hotelId = paramObject.getStringParam("hotelId");
        QueryModel queryModel=new QueryModel();
        queryModel.addColumnValueCondition("orgId", hotelId);
        queryModel.addColumnValueCondition("orgType", Constants.DEPOT_ORGTYPE_HOTEL);
        Depot depot = depotManager.getUniqueResult(queryModel);
        if(depot!=null){
            queryModel=new QueryModel();
            queryModel.addColumnValueCondition("depotId",depot.getDepotId());
            List<GoodsStore> goodsStoreList=goodsStoreDao.search(queryModel);
            if(goodsStoreList!=null && goodsStoreList.size()>0){
                for(GoodsStore goodsStore:goodsStoreList){
                    goodsStoreDao.remove(goodsStore);
                }
            }
        }
    }

    /**
     * 删除类型下的所有的商品库存
     * @param paramObject
     */
    @Override
    public void removeHotelGoodStoreByCateId(ParamObject paramObject) {
        String hotelId=paramObject.getStringParam("hotelId");
        List<String> goodsIdList=new ArrayList<>();
        List<String> cateIds= (List<String>) paramObject.getParam("cateIds");
        String cateId=StringUtils.join(cateIds,",");
        if(StringUtils.isNotEmpty(cateId)){
            QueryModel queryModel=new QueryModel();
            queryModel.addHqlCondition(" cateId in ("+ cateId+")");
            List<Goods> goodsList=goodsDao.search(queryModel);
            if(goodsList!=null && goodsList.size()>0){
                for(Goods goods:goodsList){
                    goodsIdList.add(goods.getGoodsId().toString());
                }
            }
        }
        if(goodsIdList.size()>0){
            QueryModel queryModel=new QueryModel();
            queryModel.addColumnValueCondition("orgId", hotelId);
            queryModel.addColumnValueCondition("orgType", Constants.DEPOT_ORGTYPE_HOTEL);
            Depot depot = depotManager.getUniqueResult(queryModel);
            if(depot!=null){
                queryModel=new QueryModel();
                queryModel.addColumnValueCondition("depotId",depot.getDepotId());
                List<GoodsStore> goodsStoreList=goodsStoreDao.search(queryModel);
                if(goodsStoreList!=null && goodsStoreList.size()>0){
                    for(GoodsStore goodsStore:goodsStoreList){
                        if(!goodsIdList.contains(goodsStore.getGoodsId().toString())){
                            goodsStoreDao.remove(goodsStore);
                        }
                    }
                }
            }
        }
    }
}