/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Picture.java
 * Author:   admin
 * Date:     2016-03-20 16:22:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:56><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "picture")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Picture extends BaseObject{
    private static final long serialVersionUID = -934452622361254683L;
    private Long picId;
    private String typeId;
    private String srcFileName;
    private String picSysName;
    private String specName;
    private String url;
    private String picName;
    private String bizId;
    private String bizType;
    private String srcFlag;
    private String cutFlag;
    private String defaultFlag;
    private Integer height;
    private Integer width;
    private Date createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "picId")
    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    @Basic
    @Column(name = "typeId")
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "srcFileName")
    public String getSrcFileName() {
        return srcFileName;
    }

    public void setSrcFileName(String srcFileName) {
        this.srcFileName = srcFileName;
    }

    @Basic
    @Column(name = "picSysName")
    public String getPicSysName() {
        return picSysName;
    }

    public void setPicSysName(String picSysName) {
        this.picSysName = picSysName;
    }

    @Basic
    @Column(name = "specName")
    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "picName")
    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    @Basic
    @Column(name = "bizId")
    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    @Basic
    @Column(name = "bizType")
    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @Basic
    @Column(name = "srcFlag")
    public String getSrcFlag() {
        return srcFlag;
    }

    public void setSrcFlag(String srcFlag) {
        this.srcFlag = srcFlag;
    }

    @Basic
    @Column(name = "cutFlag")
    public String getCutFlag() {
        return cutFlag;
    }

    public void setCutFlag(String cutFlag) {
        this.cutFlag = cutFlag;
    }

    @Basic
    @Column(name = "defaultFlag")
    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    @Basic
    @Column(name = "height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "width")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (picId != picture.picId) return false;
        if (typeId != null ? !typeId.equals(picture.typeId) : picture.typeId != null) return false;
        if (srcFileName != null ? !srcFileName.equals(picture.srcFileName) : picture.srcFileName != null) return false;
        if (picSysName != null ? !picSysName.equals(picture.picSysName) : picture.picSysName != null) return false;
        if (specName != null ? !specName.equals(picture.specName) : picture.specName != null) return false;
        if (url != null ? !url.equals(picture.url) : picture.url != null) return false;
        if (picName != null ? !picName.equals(picture.picName) : picture.picName != null) return false;
        if (bizId != null ? !bizId.equals(picture.bizId) : picture.bizId != null) return false;
        if (bizType != null ? !bizType.equals(picture.bizType) : picture.bizType != null) return false;
        if (srcFlag != null ? !srcFlag.equals(picture.srcFlag) : picture.srcFlag != null) return false;
        if (cutFlag != null ? !cutFlag.equals(picture.cutFlag) : picture.cutFlag != null) return false;
        if (defaultFlag != null ? !defaultFlag.equals(picture.defaultFlag) : picture.defaultFlag != null) return false;
        if (height != null ? !height.equals(picture.height) : picture.height != null) return false;
        if (width != null ? !width.equals(picture.width) : picture.width != null) return false;
        if (createTime != null ? !createTime.equals(picture.createTime) : picture.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (picId ^ (picId >>> 32));
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (srcFileName != null ? srcFileName.hashCode() : 0);
        result = 31 * result + (picSysName != null ? picSysName.hashCode() : 0);
        result = 31 * result + (specName != null ? specName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (picName != null ? picName.hashCode() : 0);
        result = 31 * result + (bizId != null ? bizId.hashCode() : 0);
        result = 31 * result + (bizType != null ? bizType.hashCode() : 0);
        result = 31 * result + (srcFlag != null ? srcFlag.hashCode() : 0);
        result = 31 * result + (cutFlag != null ? cutFlag.hashCode() : 0);
        result = 31 * result + (defaultFlag != null ? defaultFlag.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
