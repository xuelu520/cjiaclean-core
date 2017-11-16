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

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FinanceSubInfoVO implements Serializable {

    private Long subjectId;

    private String debitCode;

    private String debitAdjustCode;

    private String remark;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getDebitCode() {
        return debitCode;
    }

    public void setDebitCode(String debitCode) {
        this.debitCode = debitCode;
    }

    public String getDebitAdjustCode() {
        return debitAdjustCode;
    }

    public void setDebitAdjustCode(String debitAdjustCode) {
        this.debitAdjustCode = debitAdjustCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
