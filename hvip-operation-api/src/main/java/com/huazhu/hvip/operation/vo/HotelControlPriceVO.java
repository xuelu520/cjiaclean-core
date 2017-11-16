/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCate.java
 * Author:   chenli
 * Date:     2016-03-23 17:52:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:52:05> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.vo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author cmy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class HotelControlPriceVO implements Serializable{
    private Long controlPriceId;
    private Long hotelId;
    private String hotelNo;
    private String hotelName;
    private String remark;
    private String status;
    private String createUser;
    private Date createTime;
    private String verifierName;
    private Date verificationTime;
    private String statusName;

    @Id
    public Long getControlPriceId() {
        return controlPriceId;
    }

    public void setControlPriceId(Long controlPriceId) {
        this.controlPriceId = controlPriceId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
