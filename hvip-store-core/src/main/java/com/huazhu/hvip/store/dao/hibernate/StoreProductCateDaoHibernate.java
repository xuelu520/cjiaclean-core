/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreProductCateDaoHibernate.java
 * Author:   chenli
 * Date:     2016-03-23 15:50:44
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 15:50:44> <version>   <desc>
 *
 */

package com.huazhu.hvip.store.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.store.dao.StoreProductCateDao;
import com.huazhu.hvip.store.model.StoreProductCate;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class StoreProductCateDaoHibernate extends GenericDaoHibernate<StoreProductCate, Long> implements StoreProductCateDao {

    public StoreProductCateDaoHibernate() {
        super(StoreProductCate.class);
    }
}
