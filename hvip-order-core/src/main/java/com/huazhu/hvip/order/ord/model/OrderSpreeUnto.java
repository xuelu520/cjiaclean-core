package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;

/**
 * Created by cmy on 2016/10/18.
 */
@Entity
@Table(name = "vip_orderspreeunto")
public class OrderSpreeUnto {
    private long untoId;
    private String resNo;
    private Long refNo;

    @Id
    @Column(name = "untoId")
    public long getUntoId() {
        return untoId;
    }

    public void setUntoId(long untoId) {
        this.untoId = untoId;
    }

    @Basic
    @Column(name = "resNo")
    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    @Basic
    @Column(name = "refNo")
    public Long getRefNo() {
        return refNo;
    }

    public void setRefNo(Long refNo) {
        this.refNo = refNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderSpreeUnto that = (OrderSpreeUnto) o;

        if (untoId != that.untoId) return false;
        if (resNo != null ? !resNo.equals(that.resNo) : that.resNo != null) return false;
        if (refNo != null ? !refNo.equals(that.refNo) : that.refNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (untoId ^ (untoId >>> 32));
        result = 31 * result + (resNo != null ? resNo.hashCode() : 0);
        result = 31 * result + (refNo != null ? refNo.hashCode() : 0);
        return result;
    }
}
