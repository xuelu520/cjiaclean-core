package com.huazhu.hvip.user.opUser.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by XUEYONGPING001 on 2016-11-08.
 */
@Embeddable
public class ComposeIdPK implements Serializable {
    private Long roleId;
    private Long authId;
    @Column(name = "roleId")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    @Column(name = "authId")
    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }
}
