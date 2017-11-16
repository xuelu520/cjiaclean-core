/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateOrderRuleD1ao.java
 * Author:   HUQIANBO001
 * Date:     2016-04-19 14:49:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-19 14:49:48><version><desc>
 */

package com.huazhu.hvip.product.goods.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.model.CateCancelRule;

import java.util.List;

/**
 * An interface that provides a data management interface to the Specification table.
 */
public interface CateCancelRuleDao extends GenericDao<CateCancelRule, Long> {

    /**
     * 查询订单取消规则
     * @param queryModel
     * @return
     */
    public List<CateCancelRule> searchCateCancelRule(QueryModel queryModel);

}