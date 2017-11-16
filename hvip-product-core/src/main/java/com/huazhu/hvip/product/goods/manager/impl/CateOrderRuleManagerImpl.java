/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SpecificationManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.CateOrderRuleDao;
import com.huazhu.hvip.product.goods.manager.CateOrderRuleManager;
import com.huazhu.hvip.product.goods.model.CateOrderRule;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cateOrderRuleManager")
public class CateOrderRuleManagerImpl extends GenericManagerImpl<CateOrderRule, Long> implements CateOrderRuleManager {

    private static Logger logger = LogManager.getLogger(CateOrderRuleManagerImpl.class);

    CateOrderRuleDao cateOrderRuleDao;

    @Autowired
    public CateOrderRuleManagerImpl(CateOrderRuleDao cateOrderRuleDao) {
        super(cateOrderRuleDao);
        this.cateOrderRuleDao = cateOrderRuleDao;
    }

    /**
     * 查询订单支付规则
     * @param para
     * @return
     */
    @Override
    public List<CateOrderRule> searchCateOrderRule(ParamObject para) {
        List<CateOrderRule> list = null;
        QueryModel queryModel = new QueryModel();
        Long cateId = para.getLongParam("cateId");
        if(cateId!=null){
            queryModel.addColumnValueCondition(" cor.cateId ",cateId);
        }
        list = cateOrderRuleDao.searchCateOrderRule(queryModel);
        return list;
    }

    /**
     * 保存订单支付规则
     * @param cateOrderRule
     * @return
     */
    @Override
    public CateOrderRule saveCateOrderRule(CateOrderRule cateOrderRule) {
        Long ruleId =  cateOrderRule.getRuleId();
        if(ruleId==null){
            cateOrderRule.setStatus(Constants.FLAG_TRUE);
            return cateOrderRuleDao.save(cateOrderRule);
        }else{
            return cateOrderRuleDao.save(cateOrderRule);
        }
    }
}