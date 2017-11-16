/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUser.java
 * Author:   lijing
 * Date:     2016-03-20 11:59:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 11:59:23> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "webuser")
public class WebUser extends DynamicField{

    private Long webUserId;// 用户ID
    private String username;// 用户名  现在是手机.....
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private String mobile;
    private Long roleId;
    private Boolean accountEnabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private Boolean credentialsExpired;
    private String signinIp;
    private Date regTime;
    private Date lastLoginTime;
    private String lastLoginIp;
    private String mailVerified;
    private String mobileVerified;
    private Integer version;
    private String securityQuestion;
    private String securityAnswer;
    private String confirmEmailCode;
    private Long memberId;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "webUserId")
    public Long getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(Long webUserId) {
        this.webUserId = webUserId;
    }

    @Basic
    @Column(name = "userName")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "roleId")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "accountEnabled")
    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }


    @Basic
    @Column(name = "accountExpired")
    public Boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }


    @Basic
    @Column(name = "accountLocked")
    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }


    @Basic
    @Column(name = "credentialsExpired")
    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }


    @Basic
    @Column(name = "signinIP")
    public String getSigninIp() {
        return signinIp;
    }

    public void setSigninIp(String signinIp) {
        this.signinIp = signinIp;
    }


    @Basic
    @Column(name = "regTime")
    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }


    @Basic
    @Column(name = "lastLoginTime")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    @Basic
    @Column(name = "lastLoginIP")
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }


    @Basic
    @Column(name = "mailVerified")
    public String getMailVerified() {
        return mailVerified;
    }

    public void setMailVerified(String mailVerified) {
        this.mailVerified = mailVerified;
    }

    @Basic
    @Column(name = "mobileVerified")
    public String getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(String mobileVerified) {
        this.mobileVerified = mobileVerified;
    }


    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "securityQuestion")
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }


    @Basic
    @Column(name = "securityAnswer")
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }


    @Basic
    @Column(name = "confirmEmailCode")
    public String getConfirmEmailCode() {
        return confirmEmailCode;
    }

    public void setConfirmEmailCode(String confirmEmailCode) {
        this.confirmEmailCode = confirmEmailCode;
    }


    @Basic
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }




    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Basic
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
