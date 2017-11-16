package com.huazhu.hvip.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 财务科目信息
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FinanceSubInfoVO implements Serializable {

    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String subjectAdjustCode;
    private BigDecimal taxRateGeneral;
    private BigDecimal taxRateSmallscale;
    private String remark;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectAdjustCode() {
        return subjectAdjustCode;
    }

    public void setSubjectAdjustCode(String subjectAdjustCode) {
        this.subjectAdjustCode = subjectAdjustCode;
    }

    public BigDecimal getTaxRateGeneral() {
        return taxRateGeneral;
    }

    public void setTaxRateGeneral(BigDecimal taxRateGeneral) {
        this.taxRateGeneral = taxRateGeneral;
    }

    public BigDecimal getTaxRateSmallscale() {
        return taxRateSmallscale;
    }

    public void setTaxRateSmallscale(BigDecimal taxRateSmallscale) {
        this.taxRateSmallscale = taxRateSmallscale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
