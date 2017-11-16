/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevel.java
 * Author:   lijing
 * Date:     2016-03-20 11:59:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 11:59:23> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "memberlevel")
public class MemberLevel extends DynamicField{
    private Long levelId;
    private String levelName;
    private String defaultFlag;
    private BigDecimal discount;
    private Integer point;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "levelId")
    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    @Basic
    @Column(name = "levelName")
    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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
    @Column(name = "discount")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "point")
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
    
}
