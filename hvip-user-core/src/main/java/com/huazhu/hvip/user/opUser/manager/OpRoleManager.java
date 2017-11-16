/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleManager.java
 * Author:   admin
 * Date:     2016-03-10 14:05:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:05:52><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.user.opUser.model.OpRole;

import java.util.List;
import java.util.Set;


/**
 * Business Service Interface to handler communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface OpRoleManager extends GenericManager<OpRole, Long> {

	public List getOpRoles(OpRole role);


    public OpRole getOpRole(String rolename);



    public void removeOpRole(String rolename);

    /**
     * 获得可活动的角色
     * @return
     */
    public List<OpRole> getCanAssignRoles();

    /**
     * 已授权菜单
     * @param roleId
     * @return
     */
	public Set<String> getAuthedMenu(String roleId);

    //授权
	public void saveRoleMenus(String roleId, String[] menuIds);

    /**
     * 根据角色名获取
     * @param RoleName
     * @return
     */
	public OpRole getRoleByName(String RoleName);


    /**
     * 查询查询所有角色
     *
     * @param paramObject
     * @return
     */
    List<OpRole> searchOpRoles(ParamObject paramObject);



    OpRole getOpRole(Long roleId);


    OpRole saveOpRole(OpRole role);


    void removeOpRole(Long roleId);


    /**
     * 已授权菜单
     * @param roleId
     * @return
     */
    Set<Long> getAuthedMenu(Long roleId);

    //授权
    OpRole saveRoleAndAuth(OpRole opRole,  Long[] authArray) ;
}
