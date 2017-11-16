package com.huazhu.hvip.user.opUser.model.extend;/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserExt.java
 * Author:   HUQIANBO
 * Date:     2016-04-15 10:16:34
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO>  <2016-04-15 10:16:34> <version>   <desc>
 *
 */


import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
public class OpUserExt extends DynamicField {

    private Long userId;

    private String userName;                    // required

    private String password;                    // required

    private String email;                       // required; unique

    private String mobile;

    private Long empId;

    // private String qq;

    private Integer version;

    private Boolean accountEnabled;//是否有效

    private Boolean accountExpired;//是否过期

    private Boolean accountLocked;//是否锁定

    private Boolean credentialsExpired;//密码过期

    private Date lastLoginTime;// 登录时间

    private String lastLoginIP; // 最近登录IP

    private String remark;//备注
    private Boolean adAccount;//是否AD账号
    //employee扩展字段

    private String firstName;                   // required

    private String lastName;                    // required

    private String empNo;           //员工编号
    private String userdept;        //部门



    public Boolean getAdAccount() {
        return adAccount;
    }

    public void setAdAccount(Boolean adAccount) {
        this.adAccount = adAccount;
    }

    //扩展业务字段
    private String name;

    private String employeeNo;


    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getUserdept() {
        return userdept;
    }

    public void setUserdept(String userdept) {
        this.userdept = userdept;
    }

    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getName() {

        return (firstName!=null?firstName:"")+(lastName!=null?lastName:"");
    }

    public void setName(String name) {
        this.name = name;
    }
}
