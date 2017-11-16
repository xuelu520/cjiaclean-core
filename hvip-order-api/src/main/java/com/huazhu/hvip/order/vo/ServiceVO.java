package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.product.vo.GoodsVO;
import com.huazhu.hvip.user.vo.CleanerVO;

import java.util.Date;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-17 15:49
 **/

public class ServiceVO extends PageCondition {
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
    private List<ServiceitemVO> serviceitemVOs;
    private String cleanIds;
    private String serviceIds;
    private String serviceSn;
    private String evaluate;
    private String evaluateContext;
    private String serviceDetailDate;//获取具体日期
    private String serviceDetailMonth;//获取具体月份
    private String cycle;//判断是否周期订单
    private GoodsVO goodsVO;
    private List<CleanerVO> cleanerVOList;//头像


    public List<CleanerVO> getCleanerVOList() {
        return cleanerVOList;
    }

    public void setCleanerVOList(List<CleanerVO> cleanerVOList) {
        this.cleanerVOList = cleanerVOList;
    }

    public GoodsVO getGoodsVO() {
        return goodsVO;
    }

    public void setGoodsVO(GoodsVO goodsVO) {
        this.goodsVO = goodsVO;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCleanIds() {
        return cleanIds;
    }

    public void setCleanIds(String cleanIds) {
        this.cleanIds = cleanIds;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getEvaluateContext() {
        return evaluateContext;
    }

    public void setEvaluateContext(String evaluateContext) {
        this.evaluateContext = evaluateContext;
    }

    public String getServiceSn() {
        return serviceSn;
    }

    public void setServiceSn(String serviceSn) {
        this.serviceSn = serviceSn;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public List<ServiceitemVO> getServiceitemVOs() {
        return serviceitemVOs;
    }

    public void setServiceitemVOs(List<ServiceitemVO> serviceitemVOs) {
        this.serviceitemVOs = serviceitemVOs;
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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

    public String getServiceDetailDate() {
        return serviceDetailDate;
    }

    public void setServiceDetailDate(String serviceDetailDate) {
        this.serviceDetailDate = serviceDetailDate;
    }

    public String getServiceDetailMonth() {
        return serviceDetailMonth;
    }

    public void setServiceDetailMonth(String serviceDetailMonth) {
        this.serviceDetailMonth = serviceDetailMonth;
    }
}
