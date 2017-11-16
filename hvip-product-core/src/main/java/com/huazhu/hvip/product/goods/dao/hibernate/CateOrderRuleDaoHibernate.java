/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SpecificationDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-13 14:31:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:31:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.product.goods.dao.CateOrderRuleDao;
import com.huazhu.hvip.product.goods.model.CateOrderRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cateOrderRuleDao")
public class CateOrderRuleDaoHibernate extends GenericDaoHibernate<CateOrderRule, Long> implements CateOrderRuleDao {

    public CateOrderRuleDaoHibernate() {
        super(CateOrderRule.class);
    }

    /**
     * 查询分类订单规则
     * @param queryModel
     * @return
     */
    @Override
    public List<CateOrderRule> searchCateOrderRule(QueryModel queryModel) {
        queryModel.setSelectSqlHead(" SELECT cor FROM  CateOrderRule cor ",false);
        return super.search(queryModel);
    }
}
