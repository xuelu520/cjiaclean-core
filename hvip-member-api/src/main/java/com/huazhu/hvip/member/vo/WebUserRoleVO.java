/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserRoleVO.java
 * Author:   lijing
 * Date:     2016-03-21 10:19:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:19:35> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WebUserRoleVO implements Serializable{
    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
