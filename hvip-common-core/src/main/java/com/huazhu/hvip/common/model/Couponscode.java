package com.huazhu.hvip.common.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-14 11:39
 **/
@Entity
@Table(name = "couponscode")
public class Couponscode {
    private Long codeId;

    @Id
    @javax.persistence.Column(name = "codeId")
    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    private Long couponId;

    @Basic
    @javax.persistence.Column(name = "couponId")
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    private String codeSn;

    @Basic
    @javax.persistence.Column(name = "codeSn")
    public String getCodeSn() {
        return codeSn;
    }

    public void setCodeSn(String codeSn) {
        this.codeSn = codeSn;
    }

    private String code;

    @Basic
    @javax.persistence.Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    private Long activityId;

    @Basic
    @javax.persistence.Column(name = "activityId")
    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    private Date startTime;

    @Basic
    @javax.persistence.Column(name = "startTime")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    private Date endTime;

    @Basic
    @javax.persistence.Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private Date receiveTime;

    @Basic
    @javax.persistence.Column(name = "receiveTime")
    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    private Long memberId;

    @Basic
    @javax.persistence.Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    private String memberName;

    @Basic
    @javax.persistence.Column(name = "memberName")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    private String memberMobile;

    @Basic
    @javax.persistence.Column(name = "memberMobile")
    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    private Date useTime;

    @Basic
    @javax.persistence.Column(name = "useTime")
    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    private Long orderId;

    @Basic
    @javax.persistence.Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    private Long productId;

    @Basic
    @javax.persistence.Column(name = "productId")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    private BigDecimal amount;

    @Basic
    @javax.persistence.Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private Long recordId;

    @Basic
    @javax.persistence.Column(name = "recordId")
    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    private String createUser;

    @Basic
    @javax.persistence.Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

    private String updateUser;

    @Basic
    @javax.persistence.Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Couponscode that = (Couponscode) o;

        if (codeId != null ? !codeId.equals(that.codeId) : that.codeId != null) return false;
        if (couponId != null ? !couponId.equals(that.couponId) : that.couponId != null) return false;
        if (codeSn != null ? !codeSn.equals(that.codeSn) : that.codeSn != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (receiveTime != null ? !receiveTime.equals(that.receiveTime) : that.receiveTime != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (memberName != null ? !memberName.equals(that.memberName) : that.memberName != null) return false;
        if (memberMobile != null ? !memberMobile.equals(that.memberMobile) : that.memberMobile != null) return false;
        if (useTime != null ? !useTime.equals(that.useTime) : that.useTime != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (recordId != null ? !recordId.equals(that.recordId) : that.recordId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        return !(updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null);

    }

    @Override
    public int hashCode() {
        int result = codeId != null ? codeId.hashCode() : 0;
        result = 31 * result + (couponId != null ? couponId.hashCode() : 0);
        result = 31 * result + (codeSn != null ? codeSn.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (receiveTime != null ? receiveTime.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (memberName != null ? memberName.hashCode() : 0);
        result = 31 * result + (memberMobile != null ? memberMobile.hashCode() : 0);
        result = 31 * result + (useTime != null ? useTime.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (recordId != null ? recordId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
