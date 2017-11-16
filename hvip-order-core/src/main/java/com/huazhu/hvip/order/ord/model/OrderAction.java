package com.huazhu.hvip.order.ord.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HUQIANBO001 on 2016/3/27.
 */
@Entity
@Table(name = "vip_orderaction")
public class OrderAction extends DynamicField {
    private Long actionId;
    private Long orderId;
    private String actionType;
    private String description;
    private Long opId;
    private String opName;
    private String message;
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
    @Column(name = "orderId")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "actionType")
    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "opTime")
    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }


}
