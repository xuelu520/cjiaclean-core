/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsFinanceSubject.java
 * Author:   HUQIANBO001
 * Date:     2016-04-27 18:20:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-27 18:20:06><version><desc>
 */

package com.huazhu.hvip.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FinanceSubjectVO implements Serializable {

    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String subjectAdjustCode;
    private BigDecimal taxRateGeneral;
    private BigDecimal taxRateSmallscale;
    private String taxCode;
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

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
