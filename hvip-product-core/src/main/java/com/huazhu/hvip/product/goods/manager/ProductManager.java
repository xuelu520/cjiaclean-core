/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ProductManager.java
 * Author:   admin
 * Date:     2016-03-13 14:32:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:32:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.Product;

import java.util.List;

public interface ProductManager extends GenericManager<Product, Long> {

    /**
     * 根据条件查询Product
     *
     * @param paramObject
     * @return
     */
    List<Product> searchProductList(ParamObject paramObject);
}