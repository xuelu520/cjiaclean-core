package com.huazhu.hvip.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
public class MemberInfoVO implements Serializable {

    private Long memberId; //会员id
    private String mobile; //手机
    private String telNo; //电话
    private String name; //姓名
    private String address; //地址
    private String idType; //证件类型
    private String idNo; //证件号

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
