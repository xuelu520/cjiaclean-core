/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelPayRulesDaoHiebernate.java
 * Author:   lijing
 * Date:     2016-03-14 15:22:20
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-14 15:22:20> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.product.channel.dao.ChannelPayRulesDao;
import com.huazhu.hvip.product.channel.model.ChannelPayRules;
import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("channelPayRulesDao")
public class ChannelPayRulesDaoHibernate extends GenericDaoHibernate <ChannelPayRules, Long> implements ChannelPayRulesDao {

    public ChannelPayRulesDaoHibernate(){
        super(ChannelPayRules.class);
    }
}
