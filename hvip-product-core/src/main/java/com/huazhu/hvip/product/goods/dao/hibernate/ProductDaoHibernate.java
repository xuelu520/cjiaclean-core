/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ProductDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-13 14:31:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.ProductDao;
import com.huazhu.hvip.product.goods.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {

    public ProductDaoHibernate() {
        super(Product.class);
    }

    /**
     * 根据条件查询Product
     *
     * @param queryModel
     * @return
     */
    @Override
    public List<Product> searchProductList(QueryModel queryModel) {

        queryModel.setSelectSqlHead("select p from Product p ", false);

        return super.search(queryModel);
    }

    /**
     * 根据商品id查询货品
     * @param goodsId
     * @return
     */
    @Override
    public Product getProductByGoodsId(Long goodsId) {
        String sql = "select * from vip_product where goodsId =" + goodsId;
        List<Product> list = super.searchObject(sql,Product.class);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        else return null;
    }
}
