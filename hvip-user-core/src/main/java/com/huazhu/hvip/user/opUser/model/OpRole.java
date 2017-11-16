package com.huazhu.hvip.user.opUser.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.huazhu.hvip.base.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

/**
 * 后台用户
 */
@Entity
@Table(name = "opRole")
public class OpRole extends BaseObject implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 3690197650654049848L;
    private Long              roleId;
    private String            roleName;
    private String            description;
    private String            cnName;



    /**
     * Default constructor - creates a new instance with no values set.
     */
    public OpRole() {
    }

    /**
     *
     * @param roleName
     */
    public OpRole(final String roleName) {
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getRoleId() {
        return roleId;
    }

    @Column(length = 20)
    public String getRoleName() {
        return roleName;
    }

    @Column(length = 64)
    public String getDescription() {
        return this.description;
    }

    @Column
    public String getCnName() {
        return cnName;
    }

    /**
     * @return the name property (getAuthority required by Acegi's GrantedAuthority interface)
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    @Transient
    public String getAuthority() {
        return getRoleName();
    }


    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OpRole)) {
            return false;
        }

        final OpRole role = (OpRole) o;

        return !(roleName != null ? !roleName.equals(role.roleName) : role.roleName != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (roleName != null ? roleName.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.roleName).toString();
    }

}
