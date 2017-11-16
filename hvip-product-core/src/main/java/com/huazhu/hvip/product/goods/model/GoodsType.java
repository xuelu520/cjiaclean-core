/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsType.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:13> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

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
@Table(name = "vip_goodstype")
public class GoodsType extends DynamicField {
    private Long typeId;
    private String typeName;
    private String props;
    private String params;
    private String status;
    private String isPhysical;
    private String haveProp;
    private String haveParm;
    private String haveSpec;
    private String joinBrand;
    private String haveField;
    private Long subjectId;
    private String bizScope; //业务范围：1.百宝箱 2.niiice cafe

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "typeId")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "typeName")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "props")
    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    @Basic
    @Column(name = "params")
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
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
    @Column(name = "isPhysical")
    public String getIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(String isPhysical) {
        this.isPhysical = isPhysical;
    }

    @Basic
    @Column(name = "haveProp")
    public String getHaveProp() {
        return haveProp;
    }

    public void setHaveProp(String haveProp) {
        this.haveProp = haveProp;
    }

    @Basic
    @Column(name = "haveParm")
    public String getHaveParm() {
        return haveParm;
    }

    public void setHaveParm(String haveParm) {
        this.haveParm = haveParm;
    }

    @Basic
    @Column(name = "haveSpec")
    public String getHaveSpec() {
        return haveSpec;
    }

    public void setHaveSpec(String haveSpec) {
        this.haveSpec = haveSpec;
    }

    @Basic
    @Column(name = "joinBrand")
    public String getJoinBrand() {
        return joinBrand;
    }

    public void setJoinBrand(String joinBrand) {
        this.joinBrand = joinBrand;
    }

    @Basic
    @Column(name = "haveField")
    public String getHaveField() {
        return haveField;
    }

    public void setHaveField(String haveField) {
        this.haveField = haveField;
    }

    @Basic
    @Column(name = "subjectId")
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "bizScope")
    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsType goodsType = (GoodsType) o;

        if (typeId != goodsType.typeId) return false;
        if (typeName != null ? !typeName.equals(goodsType.typeName) : goodsType.typeName != null) return false;
        if (props != null ? !props.equals(goodsType.props) : goodsType.props != null) return false;
        if (params != null ? !params.equals(goodsType.params) : goodsType.params != null) return false;
        if (status != null ? !status.equals(goodsType.status) : goodsType.status != null) return false;
        if (isPhysical != null ? !isPhysical.equals(goodsType.isPhysical) : goodsType.isPhysical != null) return false;
        if (haveProp != null ? !haveProp.equals(goodsType.haveProp) : goodsType.haveProp != null) return false;
        if (haveParm != null ? !haveParm.equals(goodsType.haveParm) : goodsType.haveParm != null) return false;
        if (haveSpec != null ? !haveSpec.equals(goodsType.haveSpec) : goodsType.haveSpec != null) return false;
        if (joinBrand != null ? !joinBrand.equals(goodsType.joinBrand) : goodsType.joinBrand != null) return false;
        if (haveField != null ? !haveField.equals(goodsType.haveField) : goodsType.haveField != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (typeId ^ (typeId >>> 32));
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (props != null ? props.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isPhysical != null ? isPhysical.hashCode() : 0);
        result = 31 * result + (haveProp != null ? haveProp.hashCode() : 0);
        result = 31 * result + (haveParm != null ? haveParm.hashCode() : 0);
        result = 31 * result + (haveSpec != null ? haveSpec.hashCode() : 0);
        result = 31 * result + (joinBrand != null ? joinBrand.hashCode() : 0);
        result = 31 * result + (haveField != null ? haveField.hashCode() : 0);
        return result;
    }
}
