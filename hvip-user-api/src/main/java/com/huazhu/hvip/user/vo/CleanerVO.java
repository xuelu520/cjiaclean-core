package com.huazhu.hvip.user.vo;

import com.huazhu.hvip.base.PageCondition;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-08 13:48
 **/
@Entity
public class CleanerVO extends PageCondition{
    private Long cleanId;

    @Id
    public Long getCleanId() {
        return cleanId;
    }

    public void setCleanId(Long cleanId) {
        this.cleanId = cleanId;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String employeeNo;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    private String employeeAd;

    public String getEmployeeAd() {
        return employeeAd;
    }

    public void setEmployeeAd(String employeeAd) {
        this.employeeAd = employeeAd;
    }

    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String height;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    private String needLive;

    public String getNeedLive() {
        return needLive;
    }

    public void setNeedLive(String needLive) {
        this.needLive = needLive;
    }

    private String workAge;

    public String getWorkAge() {
        return workAge;
    }

    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    private Date interviewTime;

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    private String workType;

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    private String workBeginTime;

    public String getWorkBeginTime() {
        return workBeginTime;
    }

    public void setWorkBeginTime(String workBeginTime) {
        this.workBeginTime = workBeginTime;
    }

    private String workEndTime;

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    private String isRiding;

    public String getIsRiding() {
        return isRiding;
    }

    public void setIsRiding(String isRiding) {
        this.isRiding = isRiding;
    }

    private String recommenderMobile;

    public String getRecommenderMobile() {
        return recommenderMobile;
    }

    public void setRecommenderMobile(String recommenderMobile) {
        this.recommenderMobile = recommenderMobile;
    }

    private Date intentionWorkTime;

    public Date getIntentionWorkTime() {
        return intentionWorkTime;
    }

    public void setIntentionWorkTime(Date intentionWorkTime) {
        this.intentionWorkTime = intentionWorkTime;
    }

    private String urgentName;

    public String getUrgentName() {
        return urgentName;
    }

    public void setUrgentName(String urgentName) {
        this.urgentName = urgentName;
    }

    private String urgentMobile;

    public String getUrgentMobile() {
        return urgentMobile;
    }

    public void setUrgentMobile(String urgentMobile) {
        this.urgentMobile = urgentMobile;
    }

    private String urgentRelation;

    public String getUrgentRelation() {
        return urgentRelation;
    }

    public void setUrgentRelation(String urgentRelation) {
        this.urgentRelation = urgentRelation;
    }

    private String liveAddress;

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    private String socialSecurity;

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    private String entryType;

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    private String entryAddress;

    public String getEntryAddress() {
        return entryAddress;
    }

    public void setEntryAddress(String entryAddress) {
        this.entryAddress = entryAddress;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String createUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String updateUser;

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private Long leadId;

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private Date realWorkTime;

    public Date getRealWorkTime() {
        return realWorkTime;
    }

    public void setRealWorkTime(Date realWorkTime) {
        this.realWorkTime = realWorkTime;
    }

    private String workArea;

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    private String leadName;

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    private String workStatus;

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String cleanTypeSn;
    public String getCleanTypeSn() {
        return cleanTypeSn;
    }

    public void setCleanTypeSn(String cleanTypeSn) {
        this.cleanTypeSn = cleanTypeSn;
    }

    private String headimgurl;
    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
}
