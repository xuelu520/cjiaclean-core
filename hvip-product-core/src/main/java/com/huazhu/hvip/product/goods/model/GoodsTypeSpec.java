/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeSpec.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

import com.huazhu.hvip.base.model.DynamicField;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Entity
@Table(name = "vip_goodstypespec")
public class GoodsTypeSpec extends DynamicField {
    private Long typeSpecId;
    private Long typeId;
    private Long specId;
    private Long storeId;
    private String status;
    private Timestamp createTime;
    private String createUser;
    private Timestamp updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "typeSpecId")
    public Long getTypeSpecId() {
        return typeSpecId;
    }

    public void setTypeSpecId(Long typeSpecId) {
        this.typeSpecId = typeSpecId;
    }

    @Basic
    @Column(name = "typeId")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "specId")
    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "storeId")
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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

        GoodsTypeSpec that = (GoodsTypeSpec) o;

        if (typeSpecId != that.typeSpecId) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (specId != null ? !specId.equals(that.specId) : that.specId != null) return false;
        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (typeSpecId ^ (typeSpecId >>> 32));
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (specId != null ? specId.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
