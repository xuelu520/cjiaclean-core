/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserRole.java
 * Author:   chenli
 * Date:     2016-03-20 12:02:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 12:02:40> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.model;

import com.huazhu.hvip.base.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "opuserrole")
public class OpUserRole extends BaseObject {
    private Long userRoleId;
    private Long userId;
    private Long roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userRoleId")
    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Column(name = "userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "roleId")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
