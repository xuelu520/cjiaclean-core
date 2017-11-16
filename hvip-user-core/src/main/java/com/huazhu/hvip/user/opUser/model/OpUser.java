package com.huazhu.hvip.user.opUser.model;

import com.huazhu.hvip.base.model.DynamicField;
import com.huazhu.hvip.util.LabelValueUtil;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;

/**
 * 后台用户
 */
@Entity
@Table(name = "opUser")
public class OpUser extends DynamicField {

    private Long userId;

    private String userName;                    // required

    private String password;                    // required

    private String email;                       // required; unique

    private String mobile;
    private String name;

    // private String qq;

    private Integer version;

    private Set<OpRole> roles = new HashSet<OpRole>();//为了多对多用的

    private Boolean adAccount;//是否AD账号

    private Boolean accountEnabled;//是否有效

    private Boolean accountExpired;//是否过期

    private Boolean accountLocked;//是否锁定

    private Boolean credentialsExpired;//密码过期

    private Date lastLoginTime;// 登录时间

    private String lastLoginIP; // 最近登录IP

    private Long cleanerId;

    private String remark;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public Long getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(Long cleanerId) {
        this.cleanerId = cleanerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public OpUser() {
    }

    /**
     * Create a new instance and set the userName.
     *
     * @param userName login name for user.
     */
    public OpUser(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getUserId() {
        return userId;
    }

    @Column(nullable = false, length = 50, unique = true, name = "userName")
    public String getUserName() {
        return userName;

    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }


    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }


    @Version
    public Integer getVersion() {
        return version;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "opUserRole",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    public Set<OpRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<OpRole> roles) {
        this.roles = roles;
    }

    /**
     * Convert user roles to LabelValueUtil objects for convenience.
     *
     * @return a list of LabelValueUtil objects with role information
     */
    @Transient
    public List<LabelValueUtil> getRoleList() {
        List<LabelValueUtil> userRoles = new ArrayList<LabelValueUtil>();

        if (this.roles != null) {
            for (OpRole role : roles) {
                // convert the user's roles to LabelValueUtil Objects
                userRoles.add(new LabelValueUtil(role.getRoleName(), role.getRoleName()));
            }
        }

        return userRoles;
    }

    /**
     * Adds a role for the user
     *
     * @param role the fully instantiated role
     */
    public void addRole(OpRole role) {
        getRoles().add(role);
    }

    /**
     * @return GrantedAuthority[] an array of roles.
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        authorities.addAll(roles);
        return authorities;
    }

    @Column(nullable = false, name = "password")
    public String getPassword() {
        return password;
    }


    @Column(name = "accountExpired", nullable = false)
    public Boolean getAccountExpired() {
        return accountExpired;
    }
    @Column(name = "adAccount", nullable = false)
    public Boolean getAdAccount() {
        return adAccount;
    }

    public void setAdAccount(Boolean adAccount) {
        this.adAccount = adAccount;
    }

    /**
     * @return true if account is still active
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Transient
    public Boolean getAccountNonExpired() {
        return !getAccountExpired();
    }

    @Column(name = "accountLocked", nullable = false)
    public Boolean getAccountLocked() {
        return accountLocked;
    }

    /**
     * @return false if account is locked
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Transient
    public Boolean getAccountNonLocked() {
        return !getAccountLocked();
    }

    @Column(name = "credentialsExpired", nullable = false)
    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    /**
     * @return true if credentials haven't expired
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Transient
    public Boolean getCredentialsNonExpired() {
        return !credentialsExpired;
    }


    @Transient
    public Boolean getAdmin() {

        if (roles != null) {

            for (OpRole role : roles) {

                if ("ROLE_ADMIN".equals(role.getRoleName())) {
                    return true;

                }

            }
        }

        return false;

    }


    @Column
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    @Column(length = 20)
    public String getLastLoginIP() {
        return lastLoginIP;
    }


    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

}
