/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsFieldDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-13 14:31:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.product.goods.dao.GoodsFieldDao;
import com.huazhu.hvip.product.goods.model.GoodsField;
import org.springframework.stereotype.Repository;

@Repository("goodsFieldDao")
public class GoodsFieldDaoHibernate extends GenericDaoHibernate<GoodsField, Long> implements GoodsFieldDao {

    public GoodsFieldDaoHibernate() {
        super(GoodsField.class);
    }
}
