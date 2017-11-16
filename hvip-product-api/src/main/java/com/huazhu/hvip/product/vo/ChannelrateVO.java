package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.util.Date;

/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelrateVO.java
 * Author:   cmy
 * Date:     2016年4月26日13:12:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <cmy>  <2016-04-08 15:10:04> <version>   <desc>
 */
public class ChannelrateVO implements Serializable {
    private Long rateId;            //价格Id
    private String rateName;        //价格名称
    private Long channelId;         //渠道id
    private Long channelObjectId;   //渠道对象的id
    private Date beginTime;         //开始时间
    private Date endTime;           //结束时间
    private Long activityId;        //活动Id
    private String status;          //是否可用 1可用 0不可用
    private String checked;         //是否审核 0未审核 1审核
    private String payRules;        //支付规则
    private Date createTime;        //创建时间
    private String createUser;      //创建用户
    private Date updateTime;        //更新时间
    private String updateUser;     //更新人员
    private String channelName;     //渠道名称



    public Long getChannelObjectId() {
        return channelObjectId;
    }

    public void setChannelObjectId(Long channelObjectId) {
        this.channelObjectId = channelObjectId;
    }

    public ChannelrateVO() {

    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getPayRules() {
        return payRules;
    }

    public void setPayRules(String payRules) {
        this.payRules = payRules;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

}
