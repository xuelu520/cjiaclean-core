/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeBrandDaoHibernate.java
 * Author:   lijing
 * Date:     2016-04-22 13:17:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-22 13:17:45> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.product.goods.dao.GoodsTypeBrandDao;
import com.huazhu.hvip.product.goods.model.GoodsTypeBrand;
import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("goodsTypeBrandDao")
public class GoodsTypeBrandDaoHibernate extends GenericDaoHibernate<GoodsTypeBrand,Long> implements GoodsTypeBrandDao{
    public GoodsTypeBrandDaoHibernate() {
        super(GoodsTypeBrand.class);
    }

//    @Override
//    public int insert(Long typeId, Long brandId) {
//        int count = 0;
//        String sql = " insert into vip_goodstypebrand(goodsTypeId,brandId) values(" + typeId + "," + brandId + ")";
//        count = super.updateObject(sql);
//        return count;
//    }
}
