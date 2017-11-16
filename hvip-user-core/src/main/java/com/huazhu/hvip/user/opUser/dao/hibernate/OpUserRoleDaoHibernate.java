/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: EmployeeDaoHibernate.java
 * Author:   chenli
 * Date:     2016-04-22 16:27:43
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-22 16:27:43> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.user.opUser.dao.OpUserRoleDao;
import com.huazhu.hvip.user.opUser.model.OpUserRole;
import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("opUserRoleDao")
public class OpUserRoleDaoHibernate extends GenericDaoHibernate<OpUserRole, Long> implements OpUserRoleDao {

    /**
     * Constructor that sets the entity to User.class.
     */
    public OpUserRoleDaoHibernate() {
        super(OpUserRole.class);
    }
}
