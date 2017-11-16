/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SupplierManager.java
 * Author:   chenli
 * Date:     2016-03-23 11:08:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 11:08:23> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.manager;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.supplier.model.Supplier;
import com.huazhu.hvip.supplier.model.SupplierUser;
import com.huazhu.hvip.supplier.model.extend.SupplierExt;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface SupplierManager extends GenericManager<Supplier, Long> {

    /**
     * 根据条件查询供应商列表
     *
     * @param paramObject
     * @return
     */
    ReturnObject<SupplierExt> searchSupplierList(ParamObject paramObject);

    /**
     * 保存供应商（创建或者更新）
     *
     * @param supplier
     * @return
     */
    public ReturnObject saveSupplier(Supplier supplier,SupplierUser supplierUser);

    /**
     * 获取供应商详细（供应商信息和用户信息）
     *
     * @param supplierId
     * @return
     */
    SupplierExt getSupplierDetail(Long supplierId);

    /**
     * 根据条件删除供应商
     *
     * @param paramObject
     * @return
     */
    public ReturnObject deleteSupplier(ParamObject paramObject);
}
