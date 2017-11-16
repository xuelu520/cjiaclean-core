/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Channel.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:07> <version>   <desc>
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
@Table(name = "vip_channel")
public class Channel extends DynamicField {
    private Long channelId;
    private String channelName;
    private String channelCode;
    private Long typeId;
    private String status;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private String deleteFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channelId")
    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "channelName")
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Basic
    @Column(name = "channelCode")
    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @Basic
    @Column(name = "typeId")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        if (channelId != channel.channelId) return false;
        if (channelName != null ? !channelName.equals(channel.channelName) : channel.channelName != null) return false;
        if (channelCode != null ? !channelCode.equals(channel.channelCode) : channel.channelCode != null) return false;
        if (typeId != null ? !typeId.equals(channel.typeId) : channel.typeId != null) return false;
        if (status != null ? !status.equals(channel.status) : channel.status != null) return false;
        if (createTime != null ? !createTime.equals(channel.createTime) : channel.createTime != null) return false;
        if (createUser != null ? !createUser.equals(channel.createUser) : channel.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(channel.updateTime) : channel.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(channel.updateUser) : channel.updateUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (channelId ^ (channelId >>> 32));
        result = 31 * result + (channelName != null ? channelName.hashCode() : 0);
        result = 31 * result + (channelCode != null ? channelCode.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
