/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeVO.java
 * Author:   chenli
 * Date:     2016-03-18 15:56:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-18 15:56:12> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class GoodsTypeVO implements Serializable{
    private Long typeId;//主键id
    private String typeName;//类型名称
    private String props;//属性
    private String params;//参数
    private String status;//状态
    private String isPhysical;//是否是实体商品
    private String haveProp;//是否有属性
    private String haveParm;//是否有参数
    private String joinBrand;//是否关联品牌
    private String haveField;//是否有自定义字段
    private Long subjectId; //财务科目id
    private String bizScope; //业务范围：1.百宝箱 2.niiice cafe
   // private FinanceSubInfoVO financeSubjectVO;
    private String joinSubject;//关联科目

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(String isPhysical) {
        this.isPhysical = isPhysical;
    }

    public String getHaveProp() {
        return haveProp;
    }

    public void setHaveProp(String haveProp) {
        this.haveProp = haveProp;
    }

    public String getHaveParm() {
        return haveParm;
    }

    public void setHaveParm(String haveParm) {
        this.haveParm = haveParm;
    }

    public String getJoinBrand() {
        return joinBrand;
    }

    public void setJoinBrand(String joinBrand) {
        this.joinBrand = joinBrand;
    }

    public String getHaveField() {
        return haveField;
    }

    public void setHaveField(String haveField) {
        this.haveField = haveField;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getJoinSubject() {
        return joinSubject;
    }

    public void setJoinSubject(String joinSubject) {
        this.joinSubject = joinSubject;
    }
}
