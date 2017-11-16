/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRuleManager.java
 * Author:   HUQIANBO001
 * Date:     2016-04-19 14:52:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-19 14:52:23><version><desc>
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.CateCancelRule;

import java.util.List;

public interface CateCancelRuleManager extends GenericManager<CateCancelRule, Long> {

    /**
     * 查询订单取消规则
     * @param para
     * @return
     */
    public List<CateCancelRule> searchCateCancelRule(ParamObject para);

    /**
     * 保存订单取消规则
     * @param cateCancelRule
     * @return
     */
    public CateCancelRule saveCateCancelRule(CateCancelRule cateCancelRule);

}