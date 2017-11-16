package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-11-15 15:20
 **/
@Entity
@Table(name = "vip_orderupdatelog", schema = "", catalog = "cjiaclean_order")
public class OrderUpdateLog {
    private Long logId;
    private Long orderId;
    private String oldParam;
    private String newParam;
    private String updateUser;
    private Date updateTime;

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
    @Column(name = "oldParam")
    public String getOldParam() {
        return oldParam;
    }

    public void setOldParam(String oldParam) {
        this.oldParam = oldParam;
    }

    @Basic
    @Column(name = "newParam")
    public String getNewParam() {
        return newParam;
    }

    public void setNewParam(String newParam) {
        this.newParam = newParam;
    }

    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderUpdateLog that = (OrderUpdateLog) o;

        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (oldParam != null ? !oldParam.equals(that.oldParam) : that.oldParam != null) return false;
        if (newParam != null ? !newParam.equals(that.newParam) : that.newParam != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        return !(updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null);

    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (oldParam != null ? oldParam.hashCode() : 0);
        result = 31 * result + (newParam != null ? newParam.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
