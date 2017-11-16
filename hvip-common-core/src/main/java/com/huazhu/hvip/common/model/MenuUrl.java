/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Menuurl.java
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

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "menuUrl")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MenuUrl extends BaseObject {
    private static final long serialVersionUID = 6677471104123760933L;
    private Long urlId;
    private String menuId;
    private String menuName;
    private String url;
    private String masterFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "urlId")
    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    @Basic
    @Column(name = "menuId")
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "menuName")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "masterFlag")
    public String getMasterFlag() {
        return masterFlag;
    }

    public void setMasterFlag(String masterFlag) {
        this.masterFlag = masterFlag;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuUrl menuurl = (MenuUrl) o;

        if (urlId != menuurl.urlId) return false;
        if (menuId != null ? !menuId.equals(menuurl.menuId) : menuurl.menuId != null) return false;
        if (menuName != null ? !menuName.equals(menuurl.menuName) : menuurl.menuName != null) return false;
        if (url != null ? !url.equals(menuurl.url) : menuurl.url != null) return false;
        if (masterFlag != null ? !masterFlag.equals(menuurl.masterFlag) : menuurl.masterFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (urlId ^ (urlId >>> 32));
        result = 31 * result + (menuId != null ? menuId.hashCode() : 0);
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (masterFlag != null ? masterFlag.hashCode() : 0);
        return result;
    }
}
