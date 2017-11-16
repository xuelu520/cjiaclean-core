/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SupplierService.java
 * Author:   chenli
 * Date:     2016-03-23 11:29:38
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 11:29:38> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.supplier.request.AddSupplierVO;
import com.huazhu.hvip.supplier.request.EditSupplierVO;
import com.huazhu.hvip.supplier.request.SaveSupplierVO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface SupplierService {

    /**
     * 根据条件查询供应商列表
     *
     * @param paramObject
     * @return
     */
    ReturnObject searchSupplierList(ParamObject paramObject);

    /**
     * 新增供应商
     *
     * @param saveSupplierVO
     * @return
     */
    public ReturnObject<AddSupplierVO> createSupplier(SaveSupplierVO saveSupplierVO);

    /**
     * 根据供应商id获取供应商详情（供应商以及供应商用户信息）
     *
     * @param supplierId
     * @return
     */
    public ReturnObject<EditSupplierVO> getSupplierDetail(Long supplierId);

    /**
     * 修改供应商
     *
     * @param saveSupplierVO
     * @return
     */
    public ReturnObject<EditSupplierVO> saveSupplier(SaveSupplierVO saveSupplierVO);

    /**
     * 删除供应商
     *
     * @param supplierIds
     * @return
     */
    public ReturnObject deleteSupplierBySupplierId(List<Long> supplierIds);

}
