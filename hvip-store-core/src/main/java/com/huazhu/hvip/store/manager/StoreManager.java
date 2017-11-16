/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreManager.java
 * Author:   chenli
 * Date:     2016-03-23 15:38:11
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 15:38:11> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.store.model.Store;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface StoreManager extends GenericManager<Store, Long> {

    /**
     * 查询不同条件的店铺
     *
     * @return
     */
    public ReturnObject<Store> searchStoreList(ParamObject paramObject);

    /**
     * 修改店铺状态
     *
     * @param paramObject
     * @return
     */
    public Integer updateStoreStatus(ParamObject paramObject);

    /**
     * 保存修改后的排序值
     *
     * @param paramObject
     * @return
     */
    public ReturnObject<Store> saveSort(ParamObject paramObject);

    /**
     * 保存店铺（创建或者更新）
     *
     * @param store
     * @return
     */
    public Store saveStore(Store store);
}
