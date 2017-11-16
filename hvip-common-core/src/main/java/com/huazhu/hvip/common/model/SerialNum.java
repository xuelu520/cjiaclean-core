/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Serialnum.java
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

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "serialNum")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SerialNum extends BaseObject {
    private static final long serialVersionUID = -4336431815820230383L;
    private Long serialId;
    private Integer nextNum;
    private String remark;
    private Integer serialLen;
    private String serialName;
    private String serialRule;
    private Integer startNum;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serialId")
    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    @Basic
    @Column(name = "nextNum")
    public Integer getNextNum() {
        return nextNum;
    }

    public void setNextNum(Integer nextNum) {
        this.nextNum = nextNum;
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
    @Column(name = "serialLen")
    public Integer getSerialLen() {
        return serialLen;
    }

    public void setSerialLen(Integer serialLen) {
        this.serialLen = serialLen;
    }

    @Basic
    @Column(name = "serialName")
    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    @Basic
    @Column(name = "serialRule")
    public String getSerialRule() {
        return serialRule;
    }

    public void setSerialRule(String serialRule) {
        this.serialRule = serialRule;
    }

    @Basic
    @Column(name = "startNum")
    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SerialNum serialNum = (SerialNum) o;

        if (serialId != serialNum.serialId) return false;
        if (nextNum != null ? !nextNum.equals(serialNum.nextNum) : serialNum.nextNum != null) return false;
        if (remark != null ? !remark.equals(serialNum.remark) : serialNum.remark != null) return false;
        if (serialLen != null ? !serialLen.equals(serialNum.serialLen) : serialNum.serialLen != null) return false;
        if (serialName != null ? !serialName.equals(serialNum.serialName) : serialNum.serialName != null) return false;
        if (serialRule != null ? !serialRule.equals(serialNum.serialRule) : serialNum.serialRule != null) return false;
        if (startNum != null ? !startNum.equals(serialNum.startNum) : serialNum.startNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (serialId ^ (serialId >>> 32));
        result = 31 * result + (nextNum != null ? nextNum.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (serialLen != null ? serialLen.hashCode() : 0);
        result = 31 * result + (serialName != null ? serialName.hashCode() : 0);
        result = 31 * result + (serialRule != null ? serialRule.hashCode() : 0);
        result = 31 * result + (startNum != null ? startNum.hashCode() : 0);
        return result;
    }
}
