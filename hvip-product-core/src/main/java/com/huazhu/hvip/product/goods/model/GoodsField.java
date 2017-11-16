/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsField.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:12> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_goodsfield")
public class GoodsField extends DynamicField {
    private Long fieldId;
    private String chinaName;
    private String englishName;
    private String pluginId;
    private String config;
    private Long typeId;
    private String isValidate;
    private Integer fieldSort;
    private String isShow;
    private Timestamp createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fieldId")
    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "chinaName")
    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    @Basic
    @Column(name = "englishName")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Basic
    @Column(name = "pluginId")
    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    @Basic
    @Column(name = "config")
    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
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
    @Column(name = "isValidate")
    public String getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(String isValidate) {
        this.isValidate = isValidate;
    }

    @Basic
    @Column(name = "fieldSort")
    public Integer getFieldSort() {
        return fieldSort;
    }

    public void setFieldSort(Integer fieldSort) {
        this.fieldSort = fieldSort;
    }

    @Basic
    @Column(name = "isShow")
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsField that = (GoodsField) o;

        if (fieldId != that.fieldId) return false;
        if (chinaName != null ? !chinaName.equals(that.chinaName) : that.chinaName != null) return false;
        if (englishName != null ? !englishName.equals(that.englishName) : that.englishName != null) return false;
        if (pluginId != null ? !pluginId.equals(that.pluginId) : that.pluginId != null) return false;
        if (config != null ? !config.equals(that.config) : that.config != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (isValidate != null ? !isValidate.equals(that.isValidate) : that.isValidate != null) return false;
        if (fieldSort != null ? !fieldSort.equals(that.fieldSort) : that.fieldSort != null) return false;
        if (isShow != null ? !isShow.equals(that.isShow) : that.isShow != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (fieldId ^ (fieldId >>> 32));
        result = 31 * result + (chinaName != null ? chinaName.hashCode() : 0);
        result = 31 * result + (englishName != null ? englishName.hashCode() : 0);
        result = 31 * result + (pluginId != null ? pluginId.hashCode() : 0);
        result = 31 * result + (config != null ? config.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (isValidate != null ? isValidate.hashCode() : 0);
        result = 31 * result + (fieldSort != null ? fieldSort.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
