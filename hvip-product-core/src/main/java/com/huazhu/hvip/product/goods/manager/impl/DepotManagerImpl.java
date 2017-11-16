/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DepotManagerImpl.java
 * Author:   chenli
 * Date:     2016-04-05 19:28:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-05 19:28:45> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.CategoryDao;
import com.huazhu.hvip.product.goods.dao.DepotDao;
import com.huazhu.hvip.product.goods.manager.CategoryManager;
import com.huazhu.hvip.product.goods.manager.DepotManager;
import com.huazhu.hvip.product.goods.model.Category;
import com.huazhu.hvip.product.goods.model.Depot;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("depotManager")
public class DepotManagerImpl extends GenericManagerImpl<Depot, Long> implements DepotManager {

        DepotDao depotDao;

        @Autowired
        public DepotManagerImpl(DepotDao depotDao) {
            super(depotDao);
            this.depotDao = depotDao;
        }

}
