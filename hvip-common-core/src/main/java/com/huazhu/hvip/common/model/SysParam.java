/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Sysparam.java
 * Author:   admin
 * Date:     2016-03-20 16:22:57
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:57><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "sysParam")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysParam extends BaseObject{
    private static final long serialVersionUID = -5701416019806417815L;
    private Long paramId;
    private String paramName;
    private String description;
    private String paramValue;
    private String paramType;
    private String deleteFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paramId")
    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    @Basic
    @Column(name = "paramName")
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "paramValue")
    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Basic
    @Column(name = "paramType")
    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
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
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysParam sysParam = (SysParam) o;

        if (paramId != sysParam.paramId) return false;
        if (paramName != null ? !paramName.equals(sysParam.paramName) : sysParam.paramName != null) return false;
        if (description != null ? !description.equals(sysParam.description) : sysParam.description != null)
            return false;
        if (paramValue != null ? !paramValue.equals(sysParam.paramValue) : sysParam.paramValue != null) return false;
        if (paramType != null ? !paramType.equals(sysParam.paramType) : sysParam.paramType != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(sysParam.deleteFlag) : sysParam.deleteFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (paramId ^ (paramId >>> 32));
        result = 31 * result + (paramName != null ? paramName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (paramValue != null ? paramValue.hashCode() : 0);
        result = 31 * result + (paramType != null ? paramType.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        return result;
    }
}
