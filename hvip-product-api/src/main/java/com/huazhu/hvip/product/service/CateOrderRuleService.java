/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateOrderRuleService.java
 * Author:   lijing
 * Date:     2016-04-13 14:13:04
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-13 14:13:04> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.CateOrderRuleVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CateOrderRuleService {

    /**
     * 根据分类ID查询订单支付规则
     * @param cateId
     * @return
     */
    public ReturnObject<CateOrderRuleVO> searchCateOrderRuleByCateId(Long cateId);

    /**
     * 保存订单支付规则
     * @param cateOrderRuleVO
     * @return
     */
    public ReturnObject<CateOrderRuleVO> saveCateOrderRule(CateOrderRuleVO cateOrderRuleVO);
}
