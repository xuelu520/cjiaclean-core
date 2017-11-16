package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-15 10:59
 **/
@Entity
@Table(name = "vip_paymentlog", schema = "", catalog = "cjiaclean_order")
public class Paymentlog {
    private Long logId;
    private Long orderId;
    private Long paymentId;
    private String action;
    private String payMemberName;
    private Date opTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "logId")
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "paymentId")
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "payMemberName")
    public String getPayMemberName() {
        return payMemberName;
    }

    public void setPayMemberName(String payMemberName) {
        this.payMemberName = payMemberName;
    }

    @Basic
    @Column(name = "opTime")
    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paymentlog that = (Paymentlog) o;

        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (payMemberName != null ? !payMemberName.equals(that.payMemberName) : that.payMemberName != null)
            return false;
        return !(opTime != null ? !opTime.equals(that.opTime) : that.opTime != null);

    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (paymentId != null ? paymentId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (payMemberName != null ? payMemberName.hashCode() : 0);
        result = 31 * result + (opTime != null ? opTime.hashCode() : 0);
        return result;
    }
}
