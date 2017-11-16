/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Smssend.java
 * Author:   admin
 * Date:     2016-03-20 16:22:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:56><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "smsSend")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SmsSend extends BaseObject {
    private static final long serialVersionUID = 6469585203863101894L;
    private Long smsSendId;
    private String mobileNumber;
    private Date sendTime;
    private String smsType;
    private String smsContent;
    private String bizId;
    private String verifyCode;
    private String resultCode;
    private String resultMsg;
    private Integer sec;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "smsSendId")
    public Long getSmsSendId() {
        return smsSendId;
    }

    public void setSmsSendId(Long smsSendId) {
        this.smsSendId = smsSendId;
    }

    @Basic
    @Column(name = "mobileNumber")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "sendTime")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Basic
    @Column(name = "smsType")
    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    @Basic
    @Column(name = "smsContent")
    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    @Basic
    @Column(name = "bizId")
    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    @Basic
    @Column(name = "verifyCode")
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Basic
    @Column(name = "resultCode")
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Basic
    @Column(name = "resultMsg")
    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Basic
    @Column(name = "sec")
    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsSend smsSend = (SmsSend) o;

        if (smsSendId != smsSend.smsSendId) return false;
        if (mobileNumber != null ? !mobileNumber.equals(smsSend.mobileNumber) : smsSend.mobileNumber != null)
            return false;
        if (sendTime != null ? !sendTime.equals(smsSend.sendTime) : smsSend.sendTime != null) return false;
        if (smsType != null ? !smsType.equals(smsSend.smsType) : smsSend.smsType != null) return false;
        if (smsContent != null ? !smsContent.equals(smsSend.smsContent) : smsSend.smsContent != null) return false;
        if (bizId != null ? !bizId.equals(smsSend.bizId) : smsSend.bizId != null) return false;
        if (verifyCode != null ? !verifyCode.equals(smsSend.verifyCode) : smsSend.verifyCode != null) return false;
        if (resultCode != null ? !resultCode.equals(smsSend.resultCode) : smsSend.resultCode != null) return false;
        if (resultMsg != null ? !resultMsg.equals(smsSend.resultMsg) : smsSend.resultMsg != null) return false;
        if (sec != null ? !sec.equals(smsSend.sec) : smsSend.sec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (smsSendId ^ (smsSendId >>> 32));
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        result = 31 * result + (smsType != null ? smsType.hashCode() : 0);
        result = 31 * result + (smsContent != null ? smsContent.hashCode() : 0);
        result = 31 * result + (bizId != null ? bizId.hashCode() : 0);
        result = 31 * result + (verifyCode != null ? verifyCode.hashCode() : 0);
        result = 31 * result + (resultCode != null ? resultCode.hashCode() : 0);
        result = 31 * result + (resultMsg != null ? resultMsg.hashCode() : 0);
        result = 31 * result + (sec != null ? sec.hashCode() : 0);
        return result;
    }
}
