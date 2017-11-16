package com.huazhu.hvip.rest.vo;

import com.huazhu.hvip.base.PageCondition;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author cmy
 * @create 2017-08-08 13:48
 **/
@Entity
public class CleanerVOForApp extends PageCondition {
    private Long cleanId;

    private String name;
    private String mobile;
    private String status;
    private String workStatus;
    private String cleanTypeSn;
    private String headimgurl;
    private String sex;
    private String liveAddress;
    private Integer age;
    private String employeeNo;
    private String realWorkTime;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getRealWorkTime() {
        return realWorkTime;
    }

    public void setRealWorkTime(String realWorkTime) {
        this.realWorkTime = realWorkTime;
    }

    @Id
    public Long getCleanId() {
        return cleanId;
    }

    public void setCleanId(Long cleanId) {
        this.cleanId = cleanId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getCleanTypeSn() {
        return cleanTypeSn;
    }

    public void setCleanTypeSn(String cleanTypeSn) {
        this.cleanTypeSn = cleanTypeSn;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
}
