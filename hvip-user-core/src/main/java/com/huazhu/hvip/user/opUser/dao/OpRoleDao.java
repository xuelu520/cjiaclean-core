/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleDao.java
 * Author:   admin
 * Date:     2016-03-10 14:03:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:03:24><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.user.opUser.model.OpRole;

import java.util.List;
import java.util.Set;


/**
 * Role Data Access Object (DAO) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface OpRoleDao extends GenericDao<OpRole, Long> {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return populated role object
     */
    OpRole getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);

	Set<String> getAuthedMenu(String roleId);

    /**
     * 查询用户列表
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    List<OpRole> searchRoleList(QueryModel queryModel,ParamObject paramObject);

    /**
     * 查询用户列表部分字段
     *
     * @param queryModel
     * @param paramObject
     * @return
     */
    List<OpRole> searchRoleListPartialField(QueryModel queryModel,ParamObject paramObject);


    Set<Long> getAuthedMenu(Long roleId);

    void deleteRoleAuthByRoleId(Long roleId) ;

}
