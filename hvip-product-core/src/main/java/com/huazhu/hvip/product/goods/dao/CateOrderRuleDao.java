/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateOrderRuleDao.java
 * Author:   HUQIANBO001
 * Date:     2016-04-11 19:54:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-11 19:54:13><version><desc>
 */

package com.huazhu.hvip.product.goods.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.CateOrderRule;

import java.util.List;

/**
 * An interface that provides a data management interface to the Specification table.
 */
public interface CateOrderRuleDao extends GenericDao<CateOrderRule, Long> {

    /**
     * 查询分类订单规则
     * @param queryModel
     * @return
     */
    public List<CateOrderRule> searchCateOrderRule(QueryModel queryModel);

}