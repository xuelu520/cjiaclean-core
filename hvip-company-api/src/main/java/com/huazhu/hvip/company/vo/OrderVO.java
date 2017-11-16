package com.huazhu.hvip.company.vo;

import com.huazhu.hvip.base.PageCondition;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author cmy
 * @create 2017-10-31 14:28
 **/
public class OrderVO extends PageCondition {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long programId;

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    private String orderName;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    private String orderAdress;

    public String getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(String orderAdress) {
        this.orderAdress = orderAdress;
    }

    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    private String orderTypeName;

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    private Integer workStartTimeHour;

    public Integer getWorkStartTimeHour() {
        return workStartTimeHour;
    }

    public void setWorkStartTimeHour(Integer workStartTimeHour) {
        this.workStartTimeHour = workStartTimeHour;
    }

    private Integer workStartTimeMinute;

    public Integer getWorkStartTimeMinute() {
        return workStartTimeMinute;
    }

    public void setWorkStartTimeMinute(Integer workStartTimeMinute) {
        this.workStartTimeMinute = workStartTimeMinute;
    }

    private Integer workEndTimeHour;

    public Integer getWorkEndTimeHour() {
        return workEndTimeHour;
    }

    public void setWorkEndTimeHour(Integer workEndTimeHour) {
        this.workEndTimeHour = workEndTimeHour;
    }

    private Integer workEndTimeMinute;

    public Integer getWorkEndTimeMinute() {
        return workEndTimeMinute;
    }

    public void setWorkEndTimeMinute(Integer workEndTimeMinute) {
        this.workEndTimeMinute = workEndTimeMinute;
    }

    private Timestamp serviceStartTime;

    public Timestamp getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Timestamp serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    private Timestamp serviceEndTime;

    public Timestamp getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Timestamp serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    private BigDecimal workHours;

    public BigDecimal getWorkHours() {
        return workHours;
    }

    public void setWorkHours(BigDecimal workHours) {
        this.workHours = workHours;
    }

    private Integer workLunch;

    public Integer getWorkLunch() {
        return workLunch;
    }

    public void setWorkLunch(Integer workLunch) {
        this.workLunch = workLunch;
    }

    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private Integer customerCheck;

    public Integer getCustomerCheck() {
        return customerCheck;
    }

    public void setCustomerCheck(Integer customerCheck) {
        this.customerCheck = customerCheck;
    }

    private Integer startOrStop;

    public Integer getStartOrStop() {
        return startOrStop;
    }

    public void setStartOrStop(Integer startOrStop) {
        this.startOrStop = startOrStop;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String orderStatus;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    private String workDays;

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    private Integer cleanerCount;

    public Integer getCleanerCount() {
        return cleanerCount;
    }

    public void setCleanerCount(Integer cleanerCount) {
        this.cleanerCount = cleanerCount;
    }

    private Integer cleanerUseCount;

    public Integer getCleanerUseCount() {
        return cleanerUseCount;
    }

    public void setCleanerUseCount(Integer cleanerUseCount) {
        this.cleanerUseCount = cleanerUseCount;
    }

    private String createDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    private String createBy;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    private String updateDate;

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    private String updateBy;

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


}
