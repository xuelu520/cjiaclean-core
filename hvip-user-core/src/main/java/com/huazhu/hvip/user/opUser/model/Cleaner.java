package com.huazhu.hvip.user.opUser.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-08 13:48
 **/
@Entity
public class Cleaner {
    private Long cleanId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "cleanId")
    public Long getCleanId() {
        return cleanId;
    }

    public void setCleanId(Long cleanId) {
        this.cleanId = cleanId;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;

    @Basic
    @javax.persistence.Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String employeeNo;

    @Basic
    @javax.persistence.Column(name = "employeeNo")
    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    private String employeeAd;

    @Basic
    @javax.persistence.Column(name = "employeeAD")
    public String getEmployeeAd() {
        return employeeAd;
    }

    public void setEmployeeAd(String employeeAd) {
        this.employeeAd = employeeAd;
    }

    private String sex;

    @Basic
    @javax.persistence.Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String mobile;

    @Basic
    @javax.persistence.Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private Integer age;

    @Basic
    @javax.persistence.Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String height;

    @Basic
    @javax.persistence.Column(name = "height")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    private String weight;

    @Basic
    @javax.persistence.Column(name = "weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    private String needLive;

    @Basic
    @javax.persistence.Column(name = "needLive")
    public String getNeedLive() {
        return needLive;
    }

    public void setNeedLive(String needLive) {
        this.needLive = needLive;
    }

    private String workAge;

    @Basic
    @javax.persistence.Column(name = "workAge")
    public String getWorkAge() {
        return workAge;
    }

    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    private Date interviewTime;

    @Basic
    @javax.persistence.Column(name = "interviewTime")
    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    private String workType;

    @Basic
    @javax.persistence.Column(name = "workType")
    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    private String workBeginTime;

    @Basic
    @javax.persistence.Column(name = "workBeginTime")
    public String getWorkBeginTime() {
        return workBeginTime;
    }

    public void setWorkBeginTime(String workBeginTime) {
        this.workBeginTime = workBeginTime;
    }

    private String workEndTime;

    @Basic
    @javax.persistence.Column(name = "workEndTime")
    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    private String isRiding;

    @Basic
    @javax.persistence.Column(name = "isRiding")
    public String getIsRiding() {
        return isRiding;
    }

    public void setIsRiding(String isRiding) {
        this.isRiding = isRiding;
    }

    private String recommenderMobile;

    @Basic
    @javax.persistence.Column(name = "recommenderMobile")
    public String getRecommenderMobile() {
        return recommenderMobile;
    }

    public void setRecommenderMobile(String recommenderMobile) {
        this.recommenderMobile = recommenderMobile;
    }

    private Date intentionWorkTime;

    @Basic
    @javax.persistence.Column(name = "intentionWorkTime")
    public Date getIntentionWorkTime() {
        return intentionWorkTime;
    }

    public void setIntentionWorkTime(Date intentionWorkTime) {
        this.intentionWorkTime = intentionWorkTime;
    }

    private String urgentName;

    @Basic
    @javax.persistence.Column(name = "urgentName")
    public String getUrgentName() {
        return urgentName;
    }

    public void setUrgentName(String urgentName) {
        this.urgentName = urgentName;
    }

    private String urgentMobile;

    @Basic
    @javax.persistence.Column(name = "urgentMobile")
    public String getUrgentMobile() {
        return urgentMobile;
    }

    public void setUrgentMobile(String urgentMobile) {
        this.urgentMobile = urgentMobile;
    }

    private String urgentRelation;

    @Basic
    @javax.persistence.Column(name = "urgentRelation")
    public String getUrgentRelation() {
        return urgentRelation;
    }

    public void setUrgentRelation(String urgentRelation) {
        this.urgentRelation = urgentRelation;
    }

    private String liveAddress;

    @Basic
    @javax.persistence.Column(name = "liveAddress")
    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    private String socialSecurity;


    private Date realWorkTime;
    @Basic
    @javax.persistence.Column(name = "realWorkTime")
    public Date getRealWorkTime() {
        return realWorkTime;
    }

    public void setRealWorkTime(Date realWorkTime) {
        this.realWorkTime = realWorkTime;
    }

    @Basic
    @javax.persistence.Column(name = "socialSecurity")
    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    private String entryType;

    @Basic
    @javax.persistence.Column(name = "entryType")
    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    private String entryAddress;

    @Basic
    @javax.persistence.Column(name = "entryAddress")
    public String getEntryAddress() {
        return entryAddress;
    }

    public void setEntryAddress(String entryAddress) {
        this.entryAddress = entryAddress;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    private Long leadId;

    @Basic
    @javax.persistence.Column(name = "leadId")
    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }


    private String createUser;

    @Basic
    @javax.persistence.Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    private Date createTime;

    @Basic
    @javax.persistence.Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String updateUser;

    @Basic
    @javax.persistence.Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    private Date updateTime;

    @Basic
    @javax.persistence.Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    private String workArea;
    @Basic
    @javax.persistence.Column(name = "workArea")
    public String getWorkArea() {
        return workArea;
    }
    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    private String leadName;

    @Basic
    @javax.persistence.Column(name = "leadName")
    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }


    private String workStatus;
    @Basic
    @javax.persistence.Column(name = "workStatus")
    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }


    private String position;
    @Basic
    @javax.persistence.Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    private String cleanTypeSn;
    @Basic
    @javax.persistence.Column(name = "cleanTypeSn")
    public String getCleanTypeSn() {
        return cleanTypeSn;
    }

    public void setCleanTypeSn(String cleanTypeSn) {
        this.cleanTypeSn = cleanTypeSn;
    }


    private String headimgurl;
    @Basic
    @javax.persistence.Column(name = "headimgurl")
    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cleaner cleaner = (Cleaner) o;

        if (cleanId != null ? !cleanId.equals(cleaner.cleanId) : cleaner.cleanId != null) return false;
        if (name != null ? !name.equals(cleaner.name) : cleaner.name != null) return false;
        if (password != null ? !password.equals(cleaner.password) : cleaner.password != null) return false;
        if (employeeNo != null ? !employeeNo.equals(cleaner.employeeNo) : cleaner.employeeNo != null) return false;
        if (employeeAd != null ? !employeeAd.equals(cleaner.employeeAd) : cleaner.employeeAd != null) return false;
        if (sex != null ? !sex.equals(cleaner.sex) : cleaner.sex != null) return false;
        if (mobile != null ? !mobile.equals(cleaner.mobile) : cleaner.mobile != null) return false;
        if (age != null ? !age.equals(cleaner.age) : cleaner.age != null) return false;
        if (height != null ? !height.equals(cleaner.height) : cleaner.height != null) return false;
        if (weight != null ? !weight.equals(cleaner.weight) : cleaner.weight != null) return false;
        if (needLive != null ? !needLive.equals(cleaner.needLive) : cleaner.needLive != null) return false;
        if (workAge != null ? !workAge.equals(cleaner.workAge) : cleaner.workAge != null) return false;
        if (interviewTime != null ? !interviewTime.equals(cleaner.interviewTime) : cleaner.interviewTime != null)
            return false;
        if (workType != null ? !workType.equals(cleaner.workType) : cleaner.workType != null) return false;
        if (workBeginTime != null ? !workBeginTime.equals(cleaner.workBeginTime) : cleaner.workBeginTime != null)
            return false;
        if (workEndTime != null ? !workEndTime.equals(cleaner.workEndTime) : cleaner.workEndTime != null) return false;
        if (isRiding != null ? !isRiding.equals(cleaner.isRiding) : cleaner.isRiding != null) return false;
        if (recommenderMobile != null ? !recommenderMobile.equals(cleaner.recommenderMobile) : cleaner.recommenderMobile != null)
            return false;
        if (intentionWorkTime != null ? !intentionWorkTime.equals(cleaner.intentionWorkTime) : cleaner.intentionWorkTime != null)
            return false;
        if (urgentName != null ? !urgentName.equals(cleaner.urgentName) : cleaner.urgentName != null) return false;
        if (urgentMobile != null ? !urgentMobile.equals(cleaner.urgentMobile) : cleaner.urgentMobile != null)
            return false;
        if (urgentRelation != null ? !urgentRelation.equals(cleaner.urgentRelation) : cleaner.urgentRelation != null)
            return false;
        if (liveAddress != null ? !liveAddress.equals(cleaner.liveAddress) : cleaner.liveAddress != null) return false;
        if (socialSecurity != null ? !socialSecurity.equals(cleaner.socialSecurity) : cleaner.socialSecurity != null)
            return false;
        if (realWorkTime != null ? !realWorkTime.equals(cleaner.realWorkTime) : cleaner.realWorkTime != null)
            return false;
        if (entryType != null ? !entryType.equals(cleaner.entryType) : cleaner.entryType != null) return false;
        if (entryAddress != null ? !entryAddress.equals(cleaner.entryAddress) : cleaner.entryAddress != null)
            return false;
        if (status != null ? !status.equals(cleaner.status) : cleaner.status != null) return false;
        if (leadId != null ? !leadId.equals(cleaner.leadId) : cleaner.leadId != null) return false;
        if (createUser != null ? !createUser.equals(cleaner.createUser) : cleaner.createUser != null) return false;
        if (createTime != null ? !createTime.equals(cleaner.createTime) : cleaner.createTime != null) return false;
        if (updateUser != null ? !updateUser.equals(cleaner.updateUser) : cleaner.updateUser != null) return false;
        if (updateTime != null ? !updateTime.equals(cleaner.updateTime) : cleaner.updateTime != null) return false;
        if (workArea != null ? !workArea.equals(cleaner.workArea) : cleaner.workArea != null) return false;
        if (leadName != null ? !leadName.equals(cleaner.leadName) : cleaner.leadName != null) return false;
        if (workStatus != null ? !workStatus.equals(cleaner.workStatus) : cleaner.workStatus != null) return false;
        if (position != null ? !position.equals(cleaner.position) : cleaner.position != null) return false;
        if (cleanTypeSn != null ? !cleanTypeSn.equals(cleaner.cleanTypeSn) : cleaner.cleanTypeSn != null) return false;
        return !(headimgurl != null ? !headimgurl.equals(cleaner.headimgurl) : cleaner.headimgurl != null);

    }

    @Override
    public int hashCode() {
        int result = cleanId != null ? cleanId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (employeeNo != null ? employeeNo.hashCode() : 0);
        result = 31 * result + (employeeAd != null ? employeeAd.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (needLive != null ? needLive.hashCode() : 0);
        result = 31 * result + (workAge != null ? workAge.hashCode() : 0);
        result = 31 * result + (interviewTime != null ? interviewTime.hashCode() : 0);
        result = 31 * result + (workType != null ? workType.hashCode() : 0);
        result = 31 * result + (workBeginTime != null ? workBeginTime.hashCode() : 0);
        result = 31 * result + (workEndTime != null ? workEndTime.hashCode() : 0);
        result = 31 * result + (isRiding != null ? isRiding.hashCode() : 0);
        result = 31 * result + (recommenderMobile != null ? recommenderMobile.hashCode() : 0);
        result = 31 * result + (intentionWorkTime != null ? intentionWorkTime.hashCode() : 0);
        result = 31 * result + (urgentName != null ? urgentName.hashCode() : 0);
        result = 31 * result + (urgentMobile != null ? urgentMobile.hashCode() : 0);
        result = 31 * result + (urgentRelation != null ? urgentRelation.hashCode() : 0);
        result = 31 * result + (liveAddress != null ? liveAddress.hashCode() : 0);
        result = 31 * result + (socialSecurity != null ? socialSecurity.hashCode() : 0);
        result = 31 * result + (realWorkTime != null ? realWorkTime.hashCode() : 0);
        result = 31 * result + (entryType != null ? entryType.hashCode() : 0);
        result = 31 * result + (entryAddress != null ? entryAddress.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (leadId != null ? leadId.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (workArea != null ? workArea.hashCode() : 0);
        result = 31 * result + (leadName != null ? leadName.hashCode() : 0);
        result = 31 * result + (workStatus != null ? workStatus.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (cleanTypeSn != null ? cleanTypeSn.hashCode() : 0);
        result = 31 * result + (headimgurl != null ? headimgurl.hashCode() : 0);
        return result;
    }
}
