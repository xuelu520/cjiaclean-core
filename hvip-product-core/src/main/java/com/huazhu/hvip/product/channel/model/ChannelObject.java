/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelObject.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:08> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_channelobject")
public class ChannelObject extends DynamicField {
    private Long channelObjectId;
    private Long channelId;
    private Long objectId;
    private String objectName;
    private String objectCode;
    private String status;
    private String objectType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "channelObjectId")
    public Long getChannelObjectId() {
        return channelObjectId;
    }

    public void setChannelObjectId(Long channelObjectId) {
        this.channelObjectId = channelObjectId;
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
    @Column(name = "objectId")
    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    @Basic
    @Column(name = "objectName")
    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Basic
    @Column(name = "objectCode")
    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    @Basic
    @Column(name = "objectType")
    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelObject that = (ChannelObject) o;

        if (channelObjectId != that.channelObjectId) return false;
        if (channelId != null ? !channelId.equals(that.channelId) : that.channelId != null) return false;
        if (objectId != null ? !objectId.equals(that.objectId) : that.objectId != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (objectCode != null ? !objectCode.equals(that.objectCode) : that.objectCode != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (channelObjectId ^ (channelObjectId >>> 32));
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        result = 31 * result + (objectId != null ? objectId.hashCode() : 0);
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (objectCode != null ? objectCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
