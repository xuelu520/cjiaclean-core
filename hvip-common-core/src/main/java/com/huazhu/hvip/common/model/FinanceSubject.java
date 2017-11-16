package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
public class FinanceSubject extends BaseObject {

    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String subjectAdjustCode;
    private BigDecimal taxRateGeneral;
    private BigDecimal taxRateSmallscale;
    private String taxCode;
    private String remark;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subjectId")
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "subjectName")
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "subjectCode")
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Basic
    @Column(name = "subjectAdjustCode")
    public String getSubjectAdjustCode() {
        return subjectAdjustCode;
    }

    public void setSubjectAdjustCode(String subjectAdjustCode) {
        this.subjectAdjustCode = subjectAdjustCode;
    }

    @Basic
    @Column(name = "taxRateGeneral")
    public BigDecimal getTaxRateGeneral() {
        return taxRateGeneral;
    }

    public void setTaxRateGeneral(BigDecimal taxRateGeneral) {
        this.taxRateGeneral = taxRateGeneral;
    }

    @Basic
    @Column(name = "taxRateSmallscale")
    public BigDecimal getTaxRateSmallscale() {
        return taxRateSmallscale;
    }

    public void setTaxRateSmallscale(BigDecimal taxRateSmallscale) {
        this.taxRateSmallscale = taxRateSmallscale;
    }

    @Basic
    @Column(name = "taxCode")
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Returns a multi-line String with key=value pairs.
     *
     * @return a String representation of this class.
     */
    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinanceSubject that = (FinanceSubject) o;

        if (subjectId != that.subjectId) return false;
        if (subjectName != null ? !subjectName.equals(that.subjectName) : that.subjectName != null) return false;
        if (subjectCode != null ? !subjectCode.equals(that.subjectCode) : that.subjectCode != null) return false;
        if (subjectAdjustCode != null ? !subjectAdjustCode.equals(that.subjectAdjustCode) : that.subjectAdjustCode != null)
            return false;
        if (taxRateGeneral != null ? !taxRateGeneral.equals(that.taxRateGeneral) : that.taxRateGeneral != null)
            return false;
        if (taxRateSmallscale != null ? !taxRateSmallscale.equals(that.taxRateSmallscale) : that.taxRateSmallscale != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (subjectId ^ (subjectId >>> 32));
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (subjectCode != null ? subjectCode.hashCode() : 0);
        result = 31 * result + (subjectAdjustCode != null ? subjectAdjustCode.hashCode() : 0);
        result = 31 * result + (taxRateGeneral != null ? taxRateGeneral.hashCode() : 0);
        result = 31 * result + (taxRateSmallscale != null ? taxRateSmallscale.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
