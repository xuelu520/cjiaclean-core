package com.huazhu.hvip.order.vo;

import java.io.Serializable;

/**
 * Created by LYL on 2016/10/18.
 */
public class OrderSpreeUntoVO implements Serializable{
    private long untoId;
    private String resNo;
    private String refNo;

    public long getUntoId() {
        return untoId;
    }

    public void setUntoId(long untoId) {
        this.untoId = untoId;
    }

    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }
}
