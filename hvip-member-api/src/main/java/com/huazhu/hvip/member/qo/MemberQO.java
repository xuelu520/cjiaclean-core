/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberQO.java
 * Author:   chenli
 * Date:     2016-04-14 13:34:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-04-14 13:34:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenli
 */

public class MemberQO implements Serializable{

    private Long memberId; //本地会员id
    private String openid;
    private String name; //姓名
    private String mobile; //手机
    private String idNo; //证件号
    private String memberLevelID;//华住会员级别ID
    private String email; //邮箱
    private Date createTime; //创建时间
    private String outerMemberId; //外部会员id  (目前来源于华住会员id)
    private String sex; //性别
    private String isAdmin;//是否为管理员 0为普通用户 1为管理员
    private String keyword;//关键字


    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMemberLevelID() {
        return memberLevelID;
    }

    public void setMemberLevelID(String memberLevelID) {
        this.memberLevelID = memberLevelID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOuterMemberId() {
        return outerMemberId;
    }

    public void setOuterMemberId(String outerMemberId) {
        this.outerMemberId = outerMemberId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
