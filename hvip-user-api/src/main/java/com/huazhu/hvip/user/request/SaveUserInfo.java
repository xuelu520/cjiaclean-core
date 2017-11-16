/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: EditUserVO.java
 * Author:   chenli
 * Date:     2016-04-22 14:30:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-22 14:30:42> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.request;

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

public class SaveUserInfo implements Serializable {

    private Long userId;

    private String userName;                    // required

    private String newPassword;                    // required

    private String firstName;                   // required

    private String lastName;                    // required

    //OpRoleVO扩展字段
    List<Long> roleIdList;

    //Employee扩展字段
    private Long empId;             //员工id
    private String empNo;           //员工编号
    private String userdept;        //部门
    private String remark;          //备注

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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
