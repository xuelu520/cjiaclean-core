/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberVO.java
 * Author:   lijing
 * Date:     2016-03-20 15:18:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 15:18:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MemberVO implements Serializable{

    private Long memberId; //本地会员id
    private String email; //邮箱
    private String mobile; //手机
    private String telNo; //电话
    private String name; //姓名
    private String sex; //性别
    private Date birthday; //生日
    private Long provinceId; //省份id
    private Long cityId; //城市id
    private Long regionId; //区域id
    private String province; //省份
    private String city; //城市
    private String region; //区域
    private String address; //地址
    private String zipCode; //邮编
    private String qq; //QQ
    private String face; //facebook
    private String midentity; //身份
    private String nickname; //昵称
    private String idNo; //证件号
    private String idType; //证件类型
    private String remark; //备注
    private Long levelId; //级别id
    private BigDecimal advance; //预存款
    private Integer point; //积分
    private String outerMemberId; //外部会员id  (目前来源于华住会员id)
    private Long companyId; //公司id
    private Date createTime; //创建id
    private String createUser; //创建人
    private Date updateTime; //修改时间
    private String updateUser; //修改人
    private String openid;  //微信openid
    private String headimgurl; //微信头像
    private List<MemberAddressVO> memberAddressVOs;//用户地址
    private MemberLevelVO memberLevelVO;
    private String isAdmin;//是否为管理员 0为普通用户 1为管理员

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public MemberLevelVO getMemberLevelVO() {
        return memberLevelVO;
    }

    public void setMemberLevelVO(MemberLevelVO memberLevelVO) {
        this.memberLevelVO = memberLevelVO;
    }

    public List<MemberAddressVO> getMemberAddressVOs() {
        return memberAddressVOs;
    }

    public void setMemberAddressVOs(List<MemberAddressVO> memberAddressVOs) {
        this.memberAddressVOs = memberAddressVOs;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getMidentity() {
        return midentity;
    }

    public void setMidentity(String midentity) {
        this.midentity = midentity;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public BigDecimal getAdvance() {
        return advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getOuterMemberId() {
        return outerMemberId;
    }

    public void setOuterMemberId(String outerMemberId) {
        this.outerMemberId = outerMemberId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
}
