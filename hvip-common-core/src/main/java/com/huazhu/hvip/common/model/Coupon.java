package com.huazhu.hvip.common.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-14 11:39
 **/
@Entity
@Table(name = "coupon")
public class Coupon {
    private Long couponId;

    @Id
    @javax.persistence.Column(name = "couponId")
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    private String couponSn;

    @Basic
    @javax.persistence.Column(name = "couponSn")
    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    private String couponName;

    @Basic
    @javax.persistence.Column(name = "couponName")
    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    private String couponType;

    @Basic
    @javax.persistence.Column(name = "couponType")
    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    private Integer couponAmount;

    @Basic
    @javax.persistence.Column(name = "couponAmount")
    public Integer getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Integer couponAmount) {
        this.couponAmount = couponAmount;
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

    private String giveFlag;

    @Basic
    @javax.persistence.Column(name = "giveFlag")
    public String getGiveFlag() {
        return giveFlag;
    }

    public void setGiveFlag(String giveFlag) {
        this.giveFlag = giveFlag;
    }

    private Integer minConsume;

    @Basic
    @javax.persistence.Column(name = "minConsume")
    public Integer getMinConsume() {
        return minConsume;
    }

    public void setMinConsume(Integer minConsume) {
        this.minConsume = minConsume;
    }

    private String expressions;

    @Basic
    @javax.persistence.Column(name = "expressions")
    public String getExpressions() {
        return expressions;
    }

    public void setExpressions(String expressions) {
        this.expressions = expressions;
    }

    private Integer codeNum;

    @Basic
    @javax.persistence.Column(name = "codeNum")
    public Integer getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(Integer codeNum) {
        this.codeNum = codeNum;
    }

    private Integer useNum;

    @Basic
    @javax.persistence.Column(name = "useNum")
    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    private Integer perLimit;

    @Basic
    @javax.persistence.Column(name = "perLimit")
    public Integer getPerLimit() {
        return perLimit;
    }

    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }

    private Date couponBeginTime;

    @Basic
    @javax.persistence.Column(name = "couponBeginTime")
    public Date getCouponBeginTime() {
        return couponBeginTime;
    }

    public void setCouponBeginTime(Date couponBeginTime) {
        this.couponBeginTime = couponBeginTime;
    }

    private Date couponEndTime;

    @Basic
    @javax.persistence.Column(name = "couponEndTime")
    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
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

        Coupon coupon = (Coupon) o;

        if (couponId != null ? !couponId.equals(coupon.couponId) : coupon.couponId != null) return false;
        if (couponSn != null ? !couponSn.equals(coupon.couponSn) : coupon.couponSn != null) return false;
        if (couponName != null ? !couponName.equals(coupon.couponName) : coupon.couponName != null) return false;
        if (couponType != null ? !couponType.equals(coupon.couponType) : coupon.couponType != null) return false;
        if (couponAmount != null ? !couponAmount.equals(coupon.couponAmount) : coupon.couponAmount != null)
            return false;
        if (status != null ? !status.equals(coupon.status) : coupon.status != null) return false;
        if (giveFlag != null ? !giveFlag.equals(coupon.giveFlag) : coupon.giveFlag != null) return false;
        if (minConsume != null ? !minConsume.equals(coupon.minConsume) : coupon.minConsume != null) return false;
        if (expressions != null ? !expressions.equals(coupon.expressions) : coupon.expressions != null) return false;
        if (codeNum != null ? !codeNum.equals(coupon.codeNum) : coupon.codeNum != null) return false;
        if (useNum != null ? !useNum.equals(coupon.useNum) : coupon.useNum != null) return false;
        if (perLimit != null ? !perLimit.equals(coupon.perLimit) : coupon.perLimit != null) return false;
        if (couponBeginTime != null ? !couponBeginTime.equals(coupon.couponBeginTime) : coupon.couponBeginTime != null)
            return false;
        if (couponEndTime != null ? !couponEndTime.equals(coupon.couponEndTime) : coupon.couponEndTime != null)
            return false;
        if (createTime != null ? !createTime.equals(coupon.createTime) : coupon.createTime != null) return false;
        if (createUser != null ? !createUser.equals(coupon.createUser) : coupon.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(coupon.updateTime) : coupon.updateTime != null) return false;
        return !(updateUser != null ? !updateUser.equals(coupon.updateUser) : coupon.updateUser != null);

    }

    @Override
    public int hashCode() {
        int result = couponId != null ? couponId.hashCode() : 0;
        result = 31 * result + (couponSn != null ? couponSn.hashCode() : 0);
        result = 31 * result + (couponName != null ? couponName.hashCode() : 0);
        result = 31 * result + (couponType != null ? couponType.hashCode() : 0);
        result = 31 * result + (couponAmount != null ? couponAmount.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (giveFlag != null ? giveFlag.hashCode() : 0);
        result = 31 * result + (minConsume != null ? minConsume.hashCode() : 0);
        result = 31 * result + (expressions != null ? expressions.hashCode() : 0);
        result = 31 * result + (codeNum != null ? codeNum.hashCode() : 0);
        result = 31 * result + (useNum != null ? useNum.hashCode() : 0);
        result = 31 * result + (perLimit != null ? perLimit.hashCode() : 0);
        result = 31 * result + (couponBeginTime != null ? couponBeginTime.hashCode() : 0);
        result = 31 * result + (couponEndTime != null ? couponEndTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
