/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Member.java
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
import java.math.BigDecimal;
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
@Table(name = "member")
public class Member extends DynamicField{

    private Long memberId;
    private String email;
    private String mobile;
    private String telNo;
    private String name;
    private String sex;
    private String openid;
    private String headimgurl;
    private String isAdmin;//是否为管理员 0为普通用户 1为管理员
    private Date birthday;
    private Long provinceId;
    private Long cityId;
    private Long regionId;
    private String province;
    private String city;
    private String region;
    private String address;
    private String zipCode;
    private String qq;
    private String face;
    private String midentity;
    private String nickname;
    private String idNo;
    private String idType;
    private String remark;
    private Long levelId;
    private String memberLevelID;
    private String memberLevelDesc;
    private BigDecimal advance;
    private Integer point;
    private String outerMemberId;
    private Long companyId;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }


    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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
    @Column(name = "telNo")
    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Basic
    @Column(name = "provinceId")
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }


    @Basic
    @Column(name = "cityId")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "regionId")
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }



    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Basic
    @Column(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Basic
    @Column(name = "QQ")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


    @Basic
    @Column(name = "face")
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }


    @Basic
    @Column(name = "midentity")
    public String getMidentity() {
        return midentity;
    }

    public void setMidentity(String midentity) {
        this.midentity = midentity;
    }


    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    @Basic
    @Column(name = "idNo")
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }


    @Basic
    @Column(name = "idType")
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }


    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Basic
    @Column(name = "levelId")
    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }


    @Basic
    @Column(name = "advance")
    public BigDecimal getAdvance() {
        return advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }


    @Basic
    @Column(name = "point")
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Basic
    @Column(name = "memberLevelID")
    public String getMemberLevelID() {
        return memberLevelID;
    }

    public void setMemberLevelID(String memberLevelID) {
        this.memberLevelID = memberLevelID;
    }

    @Basic
    @Column(name = "memberLevelDesc")
    public String getMemberLevelDesc() {
        return memberLevelDesc;
    }

    public void setMemberLevelDesc(String memberLevelDesc) {
        this.memberLevelDesc = memberLevelDesc;
    }

    @Basic
    @Column(name = "outerMemberId")
    public String getOuterMemberId() {
        return outerMemberId;
    }

    public void setOuterMemberId(String outerMemberId) {
        this.outerMemberId = outerMemberId;
    }


    @Basic
    @Column(name = "companyId")
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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


    @Basic
    @Column(name = "openid")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "headimgurl")
    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
}
