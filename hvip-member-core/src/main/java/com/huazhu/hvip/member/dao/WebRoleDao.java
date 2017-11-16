/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebRoleDao.java
 * Author:   lijing
 * Date:     2016-03-20 13:54:18
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 13:54:18> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.member.model.WebRole;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface WebRoleDao extends GenericDao<WebRole,Long>{

    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return populated role object
     */
	WebRole getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);

}
