/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRuleDaoHibernate.java
 * Author:   HUQIANBO001
 * Date:     2016-04-19 14:51:11
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-19 14:51:11><version><desc>
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.CateCancelRuleDao;
import com.huazhu.hvip.product.goods.model.CateCancelRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cateCancelRuleDao")
public class CateCancelRuleDaoHibernate extends GenericDaoHibernate<CateCancelRule, Long> implements CateCancelRuleDao {

    public CateCancelRuleDaoHibernate() {
        super(CateCancelRule.class);
    }


    /**
     * 查询分类订单规则
     * @param queryModel
     * @return
     */
    @Override
    public List<CateCancelRule> searchCateCancelRule(QueryModel queryModel) {
        queryModel.setSelectSqlHead(" SELECT ccr FROM  CateCancelRule ccr ",false);
        return super.search(queryModel);
    }

}
