/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ProductServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-11 15:48:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-11 15:48:31> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.goods.manager.ProductManager;
import com.huazhu.hvip.product.goods.model.Product;
import com.huazhu.hvip.product.service.ProductService;
import com.huazhu.hvip.product.vo.ProductVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductManager productManager;

    private static Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    /**
     * 获取所有货品
     * @return
     */
    @Override
    public ReturnObject<List> getAll() {

        ReturnObject<List> ret = new ReturnObject<List>();
        List productVOList = new ArrayList();

        try {
            List<Product> productList = productManager.getAll();
            for(Product product : productList){
                ProductVO productVO = new ProductVO();
                BeanUtils.copyProperties(product, productVO);
                productVOList.add(productVO);
            }
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        ret.setDataList(productVOList);
        return ret;
    }

    /**
     * 通过id获取货品
     * @param paramObject productId
     * @return
     */
    @Override
    public ReturnObject<ProductVO> getProductById(ParamObject paramObject) {

        ReturnObject<ProductVO> ret = new ReturnObject<ProductVO>();

        try {
            String productId = paramObject.getStringParam("productId");
            Product product = productManager.get(Long.valueOf(productId));
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product, productVO);
            ret.setData(productVO);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 通过名称获取货品
     * @param paramObject name
     * @return
     */
    @Override
    public ReturnObject<ProductVO> getProductByName(ParamObject paramObject) {

        return null;
    }

    /**
     * 保存货品
     * @param productVO
     * @return
     */
    @Override
    public ReturnObject<ProductVO> saveProduct(ProductVO productVO) {

        ReturnObject<ProductVO> ret = new ReturnObject<>();

        try {
            Product product = new Product();
            BeanUtils.copyProperties(productVO, product);
            Product product1 = productManager.save(product);
            ProductVO productVO1 = new ProductVO();
            BeanUtils.copyProperties(product1, productVO1);
            ret.setObject(productVO1);
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 删除货品
     * @param productVO
     * @return
     */
    @Override
    public ReturnObject removeProduct(ProductVO productVO) {

        ReturnObject ret = new ReturnObject();

        try {
            Product product = new Product();
            BeanUtils.copyProperties(productVO, product);
            productManager.remove(product);
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 根据id删除货品
     * @param paramObject productId
     * @return
     */
    @Override
    public ReturnObject removeProductById(ParamObject paramObject) {

        ReturnObject ret = new ReturnObject();

        try {
            String productId =paramObject.getStringParam("productId");
            productManager.remove(Long.valueOf(productId));
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }



    /**
     * 根据商品的id去查product
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject getProductByGoodsId(ParamObject paramObject) {
        logger.info("call getProductByGoodsId({" + JsonUtil.JSON_Bean2String(paramObject)+"})");
        QueryModel queryModel=new QueryModel();
        ReturnObject ret=new ReturnObject();
        List<ProductVO> productVOList=new ArrayList<>();
        try {
            List<String> goodsIdList= (List<String>) paramObject.getParam("goodsIdList");
            if(goodsIdList!=null && goodsIdList.size()>0){
                String goodsId= StringUtils.join(goodsIdList,",");
                if(StringUtils.isNotEmpty(goodsId)){
                    queryModel.addHqlCondition(" goodsId in(" + goodsId + ")");
                    List<Product> productList=productManager.search(queryModel);
                    if(productList!=null && productList.size()>0){
                        for(Product product:productList){
                            ProductVO productVO=new ProductVO();
                            BeanUtils.copyProperties(product,productVO);
                            productVOList.add(productVO);
                        }
                    }
                    ret.setDataList(productVOList);
                    ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                }else {
                    ret.setDataList(new ArrayList());
                    ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                }
            }
        } catch (Exception e) {
            ret.setDataList(new ArrayList());
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            logger.error(e.getMessage());
        }
        return ret;
    }
}
