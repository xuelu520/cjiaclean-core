/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ProductManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.ProductDao;
import com.huazhu.hvip.product.goods.manager.ProductManager;
import com.huazhu.hvip.product.goods.model.Product;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productManager")
public class ProductManagerImpl extends GenericManagerImpl<Product, Long> implements ProductManager {

    private static Logger logger = LogManager.getLogger(ProductManagerImpl.class);

    ProductDao productDao;

    @Autowired
    public ProductManagerImpl(ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }

    /**
     * 根据条件查询Product
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<Product> searchProductList(ParamObject paramObject) {
        logger.info("call searchProductList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        Long goodsId = paramObject.getLongParam("goodsId"); //商品id

        QueryModel queryModel = new QueryModel();

        if (goodsId != null) {
            queryModel.addColumnValueCondition("p.goodsId", goodsId);
        }

        return productDao.searchProductList(queryModel);
    }
}