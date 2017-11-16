/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserRoleDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-20 14:11:44
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:11:44> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.member.dao.WebUserRoleDao;
import com.huazhu.hvip.member.model.WebUserRole;
import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("webUserRoleDao")
public class WebUserRoleDaoHibernate extends GenericDaoHibernate<WebUserRole,Long> implements WebUserRoleDao{

    public WebUserRoleDaoHibernate() {
        super(WebUserRole.class);
    }
}
