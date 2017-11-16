/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SpecificationManager.java
 * Author:   admin
 * Date:     2016-03-13 14:32:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:32:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.CateOrderRule;

import java.util.List;

public interface CateOrderRuleManager extends GenericManager<CateOrderRule, Long> {

    /**
     * 查询订单支付规则
     * @param para
     * @return
     */
    public List<CateOrderRule> searchCateOrderRule(ParamObject para);

    /**
     * 保存订单支付规则
     * @param cateOrderRule
     * @return
     */
    public CateOrderRule saveCateOrderRule(CateOrderRule cateOrderRule);
}