package com.huazhu.hvip.company.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author cmy
 * @create 2017-10-31 14:15
 **/
@Entity
@Table(name = "order", schema = "", catalog = "cjiaclean_company")
public class Order {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long programId;

    @Basic
    @javax.persistence.Column(name = "ProgramID")
    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    private String orderName;

    @Basic
    @javax.persistence.Column(name = "OrderName")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    private String orderAdress;

    @Basic
    @javax.persistence.Column(name = "OrderAdress")
    public String getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(String orderAdress) {
        this.orderAdress = orderAdress;
    }

    private String orderType;

    @Basic
    @javax.persistence.Column(name = "OrderType")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    private String orderTypeName;

    @Basic
    @javax.persistence.Column(name = "OrderTypeName")
    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    private Integer workStartTimeHour;

    @Basic
    @javax.persistence.Column(name = "WorkStartTime_Hour")
    public Integer getWorkStartTimeHour() {
        return workStartTimeHour;
    }

    public void setWorkStartTimeHour(Integer workStartTimeHour) {
        this.workStartTimeHour = workStartTimeHour;
    }

    private Integer workStartTimeMinute;

    @Basic
    @javax.persistence.Column(name = "WorkStartTime_Minute")
    public Integer getWorkStartTimeMinute() {
        return workStartTimeMinute;
    }

    public void setWorkStartTimeMinute(Integer workStartTimeMinute) {
        this.workStartTimeMinute = workStartTimeMinute;
    }

    private Integer workEndTimeHour;

    @Basic
    @javax.persistence.Column(name = "WorkEndTime_Hour")
    public Integer getWorkEndTimeHour() {
        return workEndTimeHour;
    }

    public void setWorkEndTimeHour(Integer workEndTimeHour) {
        this.workEndTimeHour = workEndTimeHour;
    }

    private Integer workEndTimeMinute;

    @Basic
    @javax.persistence.Column(name = "WorkEndTime_Minute")
    public Integer getWorkEndTimeMinute() {
        return workEndTimeMinute;
    }

    public void setWorkEndTimeMinute(Integer workEndTimeMinute) {
        this.workEndTimeMinute = workEndTimeMinute;
    }

    private Timestamp serviceStartTime;

    @Basic
    @javax.persistence.Column(name = "ServiceStartTime")
    public Timestamp getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Timestamp serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    private Timestamp serviceEndTime;

    @Basic
    @javax.persistence.Column(name = "ServiceEndTime")
    public Timestamp getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Timestamp serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    private BigDecimal workHours;

    @Basic
    @javax.persistence.Column(name = "WorkHours")
    public BigDecimal getWorkHours() {
        return workHours;
    }

    public void setWorkHours(BigDecimal workHours) {
        this.workHours = workHours;
    }

    private Integer workLunch;

    @Basic
    @javax.persistence.Column(name = "WorkLunch")
    public Integer getWorkLunch() {
        return workLunch;
    }

    public void setWorkLunch(Integer workLunch) {
        this.workLunch = workLunch;
    }

    private String reason;

    @Basic
    @javax.persistence.Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private Integer customerCheck;

    @Basic
    @javax.persistence.Column(name = "CustomerCheck")
    public Integer getCustomerCheck() {
        return customerCheck;
    }

    public void setCustomerCheck(Integer customerCheck) {
        this.customerCheck = customerCheck;
    }

    private Integer startOrStop;

    @Basic
    @javax.persistence.Column(name = "StartOrStop")
    public Integer getStartOrStop() {
        return startOrStop;
    }

    public void setStartOrStop(Integer startOrStop) {
        this.startOrStop = startOrStop;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String orderStatus;

    @Basic
    @javax.persistence.Column(name = "OrderStatus")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    private String workDays;

    @Basic
    @javax.persistence.Column(name = "WorkDays")
    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    private Integer cleanerCount;

    @Basic
    @javax.persistence.Column(name = "CleanerCount")
    public Integer getCleanerCount() {
        return cleanerCount;
    }

    public void setCleanerCount(Integer cleanerCount) {
        this.cleanerCount = cleanerCount;
    }

    private Integer cleanerUseCount;

    @Basic
    @javax.persistence.Column(name = "CleanerUseCount")
    public Integer getCleanerUseCount() {
        return cleanerUseCount;
    }

    public void setCleanerUseCount(Integer cleanerUseCount) {
        this.cleanerUseCount = cleanerUseCount;
    }

    private String createDate;

    @Basic
    @javax.persistence.Column(name = "CreateDate")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    private String createBy;

    @Basic
    @javax.persistence.Column(name = "CreateBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    private String updateDate;

    @Basic
    @javax.persistence.Column(name = "UpdateDate")
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    private String updateBy;

    @Basic
    @javax.persistence.Column(name = "UpdateBy")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    private String orderNo;

    @Basic
    @javax.persistence.Column(name = "OrderNo")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (programId != null ? !programId.equals(order.programId) : order.programId != null) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        if (orderAdress != null ? !orderAdress.equals(order.orderAdress) : order.orderAdress != null) return false;
        if (orderType != null ? !orderType.equals(order.orderType) : order.orderType != null) return false;
        if (orderTypeName != null ? !orderTypeName.equals(order.orderTypeName) : order.orderTypeName != null)
            return false;
        if (workStartTimeHour != null ? !workStartTimeHour.equals(order.workStartTimeHour) : order.workStartTimeHour != null)
            return false;
        if (workStartTimeMinute != null ? !workStartTimeMinute.equals(order.workStartTimeMinute) : order.workStartTimeMinute != null)
            return false;
        if (workEndTimeHour != null ? !workEndTimeHour.equals(order.workEndTimeHour) : order.workEndTimeHour != null)
            return false;
        if (workEndTimeMinute != null ? !workEndTimeMinute.equals(order.workEndTimeMinute) : order.workEndTimeMinute != null)
            return false;
        if (serviceStartTime != null ? !serviceStartTime.equals(order.serviceStartTime) : order.serviceStartTime != null)
            return false;
        if (serviceEndTime != null ? !serviceEndTime.equals(order.serviceEndTime) : order.serviceEndTime != null)
            return false;
        if (workHours != null ? !workHours.equals(order.workHours) : order.workHours != null) return false;
        if (workLunch != null ? !workLunch.equals(order.workLunch) : order.workLunch != null) return false;
        if (reason != null ? !reason.equals(order.reason) : order.reason != null) return false;
        if (customerCheck != null ? !customerCheck.equals(order.customerCheck) : order.customerCheck != null)
            return false;
        if (startOrStop != null ? !startOrStop.equals(order.startOrStop) : order.startOrStop != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (workDays != null ? !workDays.equals(order.workDays) : order.workDays != null) return false;
        if (cleanerCount != null ? !cleanerCount.equals(order.cleanerCount) : order.cleanerCount != null) return false;
        if (cleanerUseCount != null ? !cleanerUseCount.equals(order.cleanerUseCount) : order.cleanerUseCount != null)
            return false;
        if (createDate != null ? !createDate.equals(order.createDate) : order.createDate != null) return false;
        if (createBy != null ? !createBy.equals(order.createBy) : order.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(order.updateDate) : order.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(order.updateBy) : order.updateBy != null) return false;
        if (orderNo != null ? !orderNo.equals(order.orderNo) : order.orderNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (programId != null ? programId.hashCode() : 0);
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + (orderAdress != null ? orderAdress.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);
        result = 31 * result + (orderTypeName != null ? orderTypeName.hashCode() : 0);
        result = 31 * result + (workStartTimeHour != null ? workStartTimeHour.hashCode() : 0);
        result = 31 * result + (workStartTimeMinute != null ? workStartTimeMinute.hashCode() : 0);
        result = 31 * result + (workEndTimeHour != null ? workEndTimeHour.hashCode() : 0);
        result = 31 * result + (workEndTimeMinute != null ? workEndTimeMinute.hashCode() : 0);
        result = 31 * result + (serviceStartTime != null ? serviceStartTime.hashCode() : 0);
        result = 31 * result + (serviceEndTime != null ? serviceEndTime.hashCode() : 0);
        result = 31 * result + (workHours != null ? workHours.hashCode() : 0);
        result = 31 * result + (workLunch != null ? workLunch.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (customerCheck != null ? customerCheck.hashCode() : 0);
        result = 31 * result + (startOrStop != null ? startOrStop.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (workDays != null ? workDays.hashCode() : 0);
        result = 31 * result + (cleanerCount != null ? cleanerCount.hashCode() : 0);
        result = 31 * result + (cleanerUseCount != null ? cleanerUseCount.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        return result;
    }
}
