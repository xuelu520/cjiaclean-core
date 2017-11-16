/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleService.java
 * Author:   lijing
 * Date:     2016-03-10 20:27:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-10 20:27:53> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.service;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.vo.OpRoleVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface OpRoleService {

    /**
     * 根据角色名查找角色
     * @param paramObject roleName
     * @return
     */
    public ReturnObject<OpRoleVO> getOpRole(ParamObject paramObject);


    /**
     * 保存角色
     * @param opRoleVO
     * @return
     */
    ReturnObject<OpRoleVO> saveOpRole(OpRoleVO opRoleVO);

    /**
     * 通过角色名删除角色
     * @param paramObject rolename
     * @return
     */
    public ReturnObject removeOpRole(ParamObject paramObject);

    /**
     * 可活动的角色
     * @return
     */
    public ReturnObject<List> getCanAssignRoles();

    /**
     * 授权
     * @param paramObject roleId menuIds
     * @return
     */
    public ReturnObject saveRoleMenus(ParamObject paramObject);

    /**
     * 根据角色名获取角色
     * @param paramObject roleName
     * @return
     */
    public ReturnObject<OpRoleVO> getOpRoleByName(ParamObject paramObject);

    /**
     * 查询所有角色列表
     *
     * @param pageCondition
     * @return
     */
    public ReturnObject<OpRoleVO> searchOpRoles(PageCondition pageCondition);


}
