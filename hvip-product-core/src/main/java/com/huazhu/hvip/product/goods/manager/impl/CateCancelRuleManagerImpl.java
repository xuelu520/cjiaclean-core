/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRuleManagerImpl.java
 * Author:   HUQIANBO001
 * Date:     2016-04-19 14:54:20
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-19 14:54:20><version><desc>
 */

package com.huazhu.hvip.product.goods.manager.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.CateCancelRuleDao;
import com.huazhu.hvip.product.goods.manager.CateCancelRuleManager;
import com.huazhu.hvip.product.goods.model.CateCancelRule;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cateCancelRuleManager")
public class CateCancelRuleManagerImpl extends GenericManagerImpl<CateCancelRule, Long> implements CateCancelRuleManager {

    private static Logger logger = LogManager.getLogger(CateCancelRuleManagerImpl.class);

    CateCancelRuleDao cateCancelRuleDao;

    @Autowired
    public CateCancelRuleManagerImpl(CateCancelRuleDao cateCancelRuleDao) {
        super(cateCancelRuleDao);
        this.cateCancelRuleDao = cateCancelRuleDao;
    }

    /**
     * 查询订单取消规则
     * @param para
     * @return
     */
    @Override
    public List<CateCancelRule> searchCateCancelRule(ParamObject para) {
        List<CateCancelRule> list = null;
        QueryModel queryModel = new QueryModel();
        Long cateId = para.getLongParam("cateId");
        if(cateId!=null){
            queryModel.addColumnValueCondition(" ccr.cateId ",cateId);
        }
        list = cateCancelRuleDao.searchCateCancelRule(queryModel);
        return list;
    }

    /**
     * 保存订单取消规则
     * @param cateCancelRule
     * @return
     */
    @Override
    public CateCancelRule saveCateCancelRule(CateCancelRule cateCancelRule) {
        Long ruleId =  cateCancelRule.getRuleId();
        if(ruleId==null){
            cateCancelRule.setStatus(Constants.FLAG_TRUE);
            return cateCancelRuleDao.save(cateCancelRule);
        }else{
            return cateCancelRuleDao.save(cateCancelRule);
        }
    }
}