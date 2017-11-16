/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpUserVo.java
 * Author:   chenli
 * Date:     2016-03-10 17:17:46
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-10 17:17:46> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class OpUserVO implements Serializable {

    private Long userId;

    private String userName;                    // required

    private String password;                    // required

    private String newPassword;
    private String confirmPassword;

    private String firstName;                   // required

    private String lastName;                    // required

    private String email;                       // required; unique

    private Boolean adAccount;//是否AD账号

    public Boolean getAdAccount() {
        return adAccount;
    }

    public void setAdAccount(Boolean adAccount) {
        this.adAccount = adAccount;
    }

    private String telNo;

    private String mobile;

    private String name;

    private EmployeeVO employeeVO;

    private CleanerVO cleanerVO;

    private Long[] roleArray;

    private List<OpRoleVO> opRoleVOList ;  //角色列表
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }


    public EmployeeVO getEmployeeVO() {
        return employeeVO;
    }

    public void setEmployeeVO(EmployeeVO employeeVO) {
        this.employeeVO = employeeVO;
    }

    public Long[] getRoleArray() {
        return roleArray;
    }

    public void setRoleArray(Long[] roleArray) {
        this.roleArray = roleArray;
    }

    public List<OpRoleVO> getOpRoleVOList() {
        return opRoleVOList;
    }

    public void setOpRoleVOList(List<OpRoleVO> opRoleVOList) {
        this.opRoleVOList = opRoleVOList;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public CleanerVO getCleanerVO() {
        return cleanerVO;
    }

    public void setCleanerVO(CleanerVO cleanerVO) {
        this.cleanerVO = cleanerVO;
    }
}
