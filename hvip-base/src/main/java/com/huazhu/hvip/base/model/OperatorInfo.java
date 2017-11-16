package com.huazhu.hvip.base.model;

import java.io.Serializable;

/**
 * Created by HUQIANBO001 on 2016/3/31.
 */
public class OperatorInfo implements Serializable {

    private Long operatorId; //操作人id
    private String operatorName; //操作人姓名
    private String remark; //操作备注

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
