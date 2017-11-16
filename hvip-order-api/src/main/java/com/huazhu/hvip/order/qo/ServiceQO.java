package com.huazhu.hvip.order.qo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-21 17:07
 **/
public class ServiceQO implements Serializable {
    private Long serviceId;
    private Long orderId;
    private Integer workBeginTime;
    private Integer workEndTime;
    private Date serviceTime;
    private String status;
    private String cleanId;
    private String cleanName;
    private Long goodsId;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private String serviceAddress;
    private String serviceMobile;
    private String serviceName;
    private Long memberId;
    private String memberMobile;
    private String serviceSn;
    private List<String> statusList;


    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getWorkBeginTime() {
        return workBeginTime;
    }

    public void setWorkBeginTime(Integer workBeginTime) {
        this.workBeginTime = workBeginTime;
    }

    public Integer getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Integer workEndTime) {
        this.workEndTime = workEndTime;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCleanId() {
        return cleanId;
    }

    public void setCleanId(String cleanId) {
        this.cleanId = cleanId;
    }

    public String getCleanName() {
        return cleanName;
    }

    public void setCleanName(String cleanName) {
        this.cleanName = cleanName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceMobile() {
        return serviceMobile;
    }

    public void setServiceMobile(String serviceMobile) {
        this.serviceMobile = serviceMobile;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getServiceSn() {
        return serviceSn;
    }

    public void setServiceSn(String serviceSn) {
        this.serviceSn = serviceSn;
    }
}
