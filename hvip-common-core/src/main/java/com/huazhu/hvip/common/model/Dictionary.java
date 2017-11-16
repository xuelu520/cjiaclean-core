/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Dictionary.java
 * Author:   admin
 * Date:     2016-03-20 16:22:55
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:55><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "dictionary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dictionary extends BaseObject {
    private static final long serialVersionUID = 5366774953855019782L;
    private Long dictId;
    private String dataTable;
    private String dictName;
    private String dictType;
    private String labelFeild;
    private String querySql;
    private String remark;
    private String valueFeild;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dictId")
    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    @Basic
    @Column(name = "dataTable")
    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
    }

    @Basic
    @Column(name = "dictName")
    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    @Basic
    @Column(name = "dictType")
    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    @Basic
    @Column(name = "labelFeild")
    public String getLabelFeild() {
        return labelFeild;
    }

    public void setLabelFeild(String labelFeild) {
        this.labelFeild = labelFeild;
    }

    @Basic
    @Column(name = "querySql")
    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "valueFeild")
    public String getValueFeild() {
        return valueFeild;
    }

    public void setValueFeild(String valueFeild) {
        this.valueFeild = valueFeild;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dictionary that = (Dictionary) o;

        if (dictId != that.dictId) return false;
        if (dataTable != null ? !dataTable.equals(that.dataTable) : that.dataTable != null) return false;
        if (dictName != null ? !dictName.equals(that.dictName) : that.dictName != null) return false;
        if (dictType != null ? !dictType.equals(that.dictType) : that.dictType != null) return false;
        if (labelFeild != null ? !labelFeild.equals(that.labelFeild) : that.labelFeild != null) return false;
        if (querySql != null ? !querySql.equals(that.querySql) : that.querySql != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (valueFeild != null ? !valueFeild.equals(that.valueFeild) : that.valueFeild != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dictId ^ (dictId >>> 32));
        result = 31 * result + (dataTable != null ? dataTable.hashCode() : 0);
        result = 31 * result + (dictName != null ? dictName.hashCode() : 0);
        result = 31 * result + (dictType != null ? dictType.hashCode() : 0);
        result = 31 * result + (labelFeild != null ? labelFeild.hashCode() : 0);
        result = 31 * result + (querySql != null ? querySql.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (valueFeild != null ? valueFeild.hashCode() : 0);
        return result;
    }
}
