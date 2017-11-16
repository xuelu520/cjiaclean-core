/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ChannelPayRules.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:08> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.channel.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_channelpayrules")
public class ChannelPayRules extends DynamicField {
    private Long rulesId;
    private String rulesName;
    private String rulesCode;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rulesId")
    public Long getRulesId() {
        return rulesId;
    }

    public void setRulesId(Long rulesId) {
        this.rulesId = rulesId;
    }

    @Basic
    @Column(name = "rulesName")
    public String getRulesName() {
        return rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = rulesName;
    }

    @Basic
    @Column(name = "rulesCode")
    public String getRulesCode() {
        return rulesCode;
    }

    public void setRulesCode(String rulesCode) {
        this.rulesCode = rulesCode;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelPayRules that = (ChannelPayRules) o;

        if (rulesId != that.rulesId) return false;
        if (rulesName != null ? !rulesName.equals(that.rulesName) : that.rulesName != null) return false;
        if (rulesCode != null ? !rulesCode.equals(that.rulesCode) : that.rulesCode != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rulesId ^ (rulesId >>> 32));
        result = 31 * result + (rulesName != null ? rulesName.hashCode() : 0);
        result = 31 * result + (rulesCode != null ? rulesCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
