/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Dictcode.java
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
@Table(name = "dictCode")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DictCode extends BaseObject {
    private static final long serialVersionUID = 3999091217059041786L;
    private Long codeId;
    private String codeLabel;
    private String codeNo;
    private String dictId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codeId")
    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    @Basic
    @Column(name = "codeLabel")
    public String getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(String codeLabel) {
        this.codeLabel = codeLabel;
    }

    @Basic
    @Column(name = "codeNo")
    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    @Basic
    @Column(name = "dictId")
    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictCode dictCode = (DictCode) o;

        if (codeId != dictCode.codeId) return false;
        if (codeLabel != null ? !codeLabel.equals(dictCode.codeLabel) : dictCode.codeLabel != null) return false;
        if (codeNo != null ? !codeNo.equals(dictCode.codeNo) : dictCode.codeNo != null) return false;
        if (dictId != null ? !dictId.equals(dictCode.dictId) : dictCode.dictId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeId ^ (codeId >>> 32));
        result = 31 * result + (codeLabel != null ? codeLabel.hashCode() : 0);
        result = 31 * result + (codeNo != null ? codeNo.hashCode() : 0);
        result = 31 * result + (dictId != null ? dictId.hashCode() : 0);
        return result;
    }
}
