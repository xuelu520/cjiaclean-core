/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelRate.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:09
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:09> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_channelrate")
public class ChannelRate extends DynamicField {
    private Long rateId;
    private String rateName;
    private Long channelId;
    private Long channelObjectId;
    private Date beginTime;
    private Date endTime;
    private Long activityId;
    private String status;
    private String checked;
    private String payRules;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rateId")
    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    @Basic
    @Column(name = "rateName")
    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    @Basic
    @Column(name = "channelId")
    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "channelObjectId")
    public Long getChannelObjectId() {
        return channelObjectId;
    }

    public void setChannelObjectId(Long channelObjectId) {
        this.channelObjectId = channelObjectId;
    }

    @Basic
    @Column(name = "beginTime")
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "activityId")
    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "checked")
    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    @Basic
    @Column(name = "payRules")
    public String getPayRules() {
        return payRules;
    }

    public void setPayRules(String payRules) {
        this.payRules = payRules;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelRate that = (ChannelRate) o;

        if (rateId != that.rateId) return false;
        if (rateName != null ? !rateName.equals(that.rateName) : that.rateName != null) return false;
        if (channelId != null ? !channelId.equals(that.channelId) : that.channelId != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (checked != null ? !checked.equals(that.checked) : that.checked != null) return false;
        if (payRules != null ? !payRules.equals(that.payRules) : that.payRules != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rateId ^ (rateId >>> 32));
        result = 31 * result + (rateName != null ? rateName.hashCode() : 0);
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (checked != null ? checked.hashCode() : 0);
        result = 31 * result + (payRules != null ? payRules.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
