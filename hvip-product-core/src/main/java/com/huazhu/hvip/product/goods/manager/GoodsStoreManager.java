/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsStoreManager.java
 * Author:   chenli
 * Date:     2016-03-20 17:32:19
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 17:32:19> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.OperatorInfo;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.GoodsStore;
import com.huazhu.hvip.product.goods.model.extend.ChangeStoreInfo;

import java.util.List;
import java.util.Map;

public interface GoodsStoreManager extends GenericManager<GoodsStore, Long> {

    /**
     * 根据条件查询商品库存列表
     *
     * @param paramObject
     * @return
     */
    public List<GoodsStore> searchGoodsStoreList(ParamObject paramObject);

    /**
     * 更新或保存商品库存
     *
     * @param paramObject
     * @return
     */
    public ReturnObject updateGoodsStore(ParamObject paramObject);


    /**
     * 修改商品库存
     *
     * @param goodsStoreList
     * @param csMap
     * @param operatorInfo
     * @return
     */
    ReturnObject changeGoodsStore(List<GoodsStore> goodsStoreList, Map<Long, ChangeStoreInfo> csMap, OperatorInfo operatorInfo);

    /**
     * 关闭酒店下的所有的商品库存
     * @param paramObject
     */

    void removeHotelGoodStore(ParamObject paramObject);

    /**
     * 删除类型下的所有的商品库存
     *
     * @param paramObject
     */
    void removeHotelGoodStoreByCateId(ParamObject paramObject);
}