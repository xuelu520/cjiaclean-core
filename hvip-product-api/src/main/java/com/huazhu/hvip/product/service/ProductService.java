/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ProductService.java
 * Author:   lijing
 * Date:     2016-03-11 15:47:27
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-11 15:47:27> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.ProductVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ProductService {

    /**
     * 获取所有货品
     * @return
     */
    ReturnObject<List> getAll();

    /**
     * 根据id获取货品
     * @param paramObject productId
     * @return
     */
    ReturnObject<ProductVO> getProductById(ParamObject paramObject);

    /**
     * 根据name获取货品
     * @param paramObject name
     * @return
     */
    ReturnObject<ProductVO> getProductByName(ParamObject paramObject);

    /**
     * 保存货品
     * @param productVO
     * @return
     */
    ReturnObject<ProductVO> saveProduct(ProductVO productVO);

    /**
     * 删除货品
     * @param productVO
     * @return
     */
    ReturnObject removeProduct(ProductVO productVO);

    /**
     * 根据id删除货品
     * @param paramObject productId
     * @return
     */
    ReturnObject removeProductById(ParamObject paramObject);

    /**
     * 根据商品的id去查product
     * @param paramObject(goodsIdList)
     * @return
     */
    ReturnObject<ProductVO> getProductByGoodsId(ParamObject paramObject);

}
