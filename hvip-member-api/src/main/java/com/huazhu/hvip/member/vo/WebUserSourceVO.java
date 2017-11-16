/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserSourceVO.java
 * Author:   lijing
 * Date:     2016-03-21 10:20:19
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:20:19> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WebUserSourceVO implements Serializable{
    private Long webuserId;
    private Long sourceid;
    private String sourcekeyword;
    private String srcSubsite;
    private String srcSubUser;
    private String otherKey1;
    private String otherKey2;
    private Date regTime;

    public Long getWebuserId() {
        return webuserId;
    }

    public void setWebuserId(Long webuserId) {
        this.webuserId = webuserId;
    }

    public Long getSourceid() {
        return sourceid;
    }

    public void setSourceid(Long sourceid) {
        this.sourceid = sourceid;
    }

    public String getSourcekeyword() {
        return sourcekeyword;
    }

    public void setSourcekeyword(String sourcekeyword) {
        this.sourcekeyword = sourcekeyword;
    }

    public String getSrcSubsite() {
        return srcSubsite;
    }

    public void setSrcSubsite(String srcSubsite) {
        this.srcSubsite = srcSubsite;
    }

    public String getSrcSubUser() {
        return srcSubUser;
    }

    public void setSrcSubUser(String srcSubUser) {
        this.srcSubUser = srcSubUser;
    }

    public String getOtherKey1() {
        return otherKey1;
    }

    public void setOtherKey1(String otherKey1) {
        this.otherKey1 = otherKey1;
    }

    public String getOtherKey2() {
        return otherKey2;
    }

    public void setOtherKey2(String otherKey2) {
        this.otherKey2 = otherKey2;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}
