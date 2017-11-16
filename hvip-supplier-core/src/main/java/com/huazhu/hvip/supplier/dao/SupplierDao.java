/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SupplierDao.java
 * Author:   chenli
 * Date:     2016-03-23 11:14:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 11:14:13> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.dao;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.supplier.model.Supplier;
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

public interface SupplierDao extends GenericDao<Supplier, Long> {

    /**
     * 根据queryModel查询supplier
     *
     * @param queryModel
     * @param paramObject
     * @return  List<SupplierExt>
     */
    public List<SupplierExt> searchSupplierList(QueryModel queryModel,ParamObject paramObject);


}
