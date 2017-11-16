/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Smstemplate.java
 * Author:   admin
 * Date:     2016-03-20 16:22:57
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:57><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import com.huazhu.hvip.base.model.DynamicField;
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
@Table(name = "smsTemplate")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SmsTemplate extends DynamicField {

    private static final long serialVersionUID = 3749677353604227567L;

    private Long templateId;
    private String smsType;
    private String templateDesc;
    private String templateContent;
    private Date createdTime;
    private String deleteFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "templateId")
    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
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
    @Column(name = "templateDesc")
    public String getTemplateDesc() {
        return templateDesc;
    }

    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    @Basic
    @Column(name = "templateContent")
    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    @Basic
    @Column(name = "createdTime")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
