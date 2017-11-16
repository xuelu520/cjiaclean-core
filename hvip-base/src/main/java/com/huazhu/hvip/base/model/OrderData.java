package com.huazhu.hvip.base.model;

import java.io.Serializable;

/**
 * Created by cmy on 2016/10/14.
 */
public class OrderData implements Serializable {
    private String refNo;
    private Integer orderNum;

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
