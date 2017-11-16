/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Auth.java
 * Author:   chenli
 * Date:     2016-03-20 12:02:38
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 12:02:38> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "auth")
public class Auth extends DynamicField{
    private Long authId;
    private String authName;
    private String authType;
    private String authValue;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authId")
    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    @Basic
    @Column(name = "authName")
    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Basic
    @Column(name = "authType")
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Basic
    @Column(name = "authValue")
    public String getAuthValue() {
        return authValue;
    }

    public void setAuthValue(String authValue) {
        this.authValue = authValue;
    }

}
