/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleVO.java
 * Author:   lijing
 * Date:     2016-03-10 20:14:59
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-10 20:14:59> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.request;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SaveOpRoleInfo implements Serializable{

    private Long roleId;
    private String roleName;
    private String description;
    private String cnName;

    private List<Long> authIdList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public List<Long> getAuthIdList() {
        return authIdList;
    }

    public void setAuthIdList(List<Long> authIdList) {
        this.authIdList = authIdList;
    }
}
