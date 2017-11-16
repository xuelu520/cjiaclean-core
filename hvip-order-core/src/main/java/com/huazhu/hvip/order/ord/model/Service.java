package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-15 10:59
 **/
@Entity
@Table(name = "vip_service", schema = "", catalog = "cjiaclean_order")
public class Service {
    private Long serviceId;
    private String serviceSn;
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
    private String evaluate;
    private String evaluateContext;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serviceId")
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "evaluate")
    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
    @Basic
    @Column(name = "evaluateContext")
    public String getEvaluateContext() {
        return evaluateContext;
    }

    public void setEvaluateContext(String evaluateContext) {
        this.evaluateContext = evaluateContext;
    }

    @Basic
    @Column(name = "serviceSn")
    public String getServiceSn() {
        return serviceSn;
    }

    public void setServiceSn(String serviceSn) {
        this.serviceSn = serviceSn;
    }
    @Basic
    @Column(name = "beginTime")
    public Integer getWorkBeginTime() {
        return workBeginTime;
    }

    public void setWorkBeginTime(Integer workBeginTime) {
        this.workBeginTime = workBeginTime;
    }

    @Basic
    @Column(name = "endTime")
    public Integer getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Integer workEndTime) {
        this.workEndTime = workEndTime;
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
    @Column(name = "serviceAddress")
    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    @Basic
    @Column(name = "serviceMobile")
    public String getServiceMobile() {
        return serviceMobile;
    }

    public void setServiceMobile(String serviceMobile) {
        this.serviceMobile = serviceMobile;
    }

    @Basic
    @Column(name = "serviceName")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "memberId")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "memberMobile")
    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    @Basic
    @Column(name = "serviceTime")
    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "cleanId")
    public String getCleanId() {
        return cleanId;
    }

    public void setCleanId(String cleanId) {
        this.cleanId = cleanId;
    }

    @Basic
    @Column(name = "cleanName")
    public String getCleanName() {
        return cleanName;
    }

    public void setCleanName(String cleanName) {
        this.cleanName = cleanName;
    }

    @Basic
    @Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (serviceId != null ? !serviceId.equals(service.serviceId) : service.serviceId != null) return false;
        if (orderId != null ? !orderId.equals(service.orderId) : service.orderId != null) return false;
        if (workBeginTime != null ? !workBeginTime.equals(service.workBeginTime) : service.workBeginTime != null)
            return false;
        if (workEndTime != null ? !workEndTime.equals(service.workEndTime) : service.workEndTime != null) return false;
        if (serviceTime != null ? !serviceTime.equals(service.serviceTime) : service.serviceTime != null) return false;
        if (status != null ? !status.equals(service.status) : service.status != null) return false;
        if (cleanId != null ? !cleanId.equals(service.cleanId) : service.cleanId != null) return false;
        if (cleanName != null ? !cleanName.equals(service.cleanName) : service.cleanName != null) return false;
        if (goodsId != null ? !goodsId.equals(service.goodsId) : service.goodsId != null) return false;
        if (createTime != null ? !createTime.equals(service.createTime) : service.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(service.updateTime) : service.updateTime != null) return false;
        if (createUser != null ? !createUser.equals(service.createUser) : service.createUser != null) return false;
        if (updateUser != null ? !updateUser.equals(service.updateUser) : service.updateUser != null) return false;
        if (serviceAddress != null ? !serviceAddress.equals(service.serviceAddress) : service.serviceAddress != null)
            return false;
        if (serviceMobile != null ? !serviceMobile.equals(service.serviceMobile) : service.serviceMobile != null)
            return false;
        if (serviceName != null ? !serviceName.equals(service.serviceName) : service.serviceName != null) return false;
        if (memberId != null ? !memberId.equals(service.memberId) : service.memberId != null) return false;
        return !(memberMobile != null ? !memberMobile.equals(service.memberMobile) : service.memberMobile != null);

    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (workBeginTime != null ? workBeginTime.hashCode() : 0);
        result = 31 * result + (workEndTime != null ? workEndTime.hashCode() : 0);
        result = 31 * result + (serviceTime != null ? serviceTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (cleanId != null ? cleanId.hashCode() : 0);
        result = 31 * result + (cleanName != null ? cleanName.hashCode() : 0);
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (serviceAddress != null ? serviceAddress.hashCode() : 0);
        result = 31 * result + (serviceMobile != null ? serviceMobile.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (memberMobile != null ? memberMobile.hashCode() : 0);
        return result;
    }
}
