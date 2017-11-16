/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DepotAdminUser.java
 * Author:   chenli
 * Date:     2016-03-20 16:00:10
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-20 16:00:10> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.model;

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
@Table(name = "vip_depotadminuser")
public class DepotAdminUser extends DynamicField {
    private Long userId;
    private Long depotId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "depotId")
    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepotAdminUser that = (DepotAdminUser) o;

        if (userId != that.userId) return false;
        if (depotId != null ? !depotId.equals(that.depotId) : that.depotId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (depotId != null ? depotId.hashCode() : 0);
        return result;
    }
}
