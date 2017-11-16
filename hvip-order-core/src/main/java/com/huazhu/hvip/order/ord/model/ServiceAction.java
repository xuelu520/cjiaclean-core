package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-17 17:42
 **/
@Entity
@Table(name = "vip_serviceaction", schema = "", catalog = "cjiaclean_order")
public class ServiceAction {
    private Long actionId;
    private Long serviceId;
    private String action;
    private Long opId;
    private String opName;
    private Date opTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actionId")
    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    @Basic
    @Column(name = "serviceId")
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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
    @Column(name = "opId")
    public Long getOpId() {
        return opId;
    }

    public void setOpId(Long opId) {
        this.opId = opId;
    }

    @Basic
    @Column(name = "opName")
    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
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

        ServiceAction that = (ServiceAction) o;

        if (actionId != null ? !actionId.equals(that.actionId) : that.actionId != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (opId != null ? !opId.equals(that.opId) : that.opId != null) return false;
        if (opName != null ? !opName.equals(that.opName) : that.opName != null) return false;
        if (opTime != null ? !opTime.equals(that.opTime) : that.opTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actionId != null ? actionId.hashCode() : 0;
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (opId != null ? opId.hashCode() : 0);
        result = 31 * result + (opName != null ? opName.hashCode() : 0);
        result = 31 * result + (opTime != null ? opTime.hashCode() : 0);
        return result;
    }
}
