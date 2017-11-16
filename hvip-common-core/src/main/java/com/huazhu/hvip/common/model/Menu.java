/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: Menu.java
 * Author:   admin
 * Date:     2016-03-20 16:22:55
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:22:55><version><desc>
 */

package com.huazhu.hvip.common.model;

import com.huazhu.hvip.base.model.BaseObject;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "menu")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Menu extends BaseObject{
    private static final long serialVersionUID = -6954169905039508566L;
    private Long menuId;
    private String menuName;
    private String displayName;
    private String target;
    private String url;
    private String picPath;
    private Long parentId;
    private String menuType;
    private String authFlag;
    private String usageScope;
    private String deleteFlag;
    private Integer sort;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menuId")
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
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
    @Column(name = "displayName")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "target")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
    @Column(name = "picPath")
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "menuType")
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Basic
    @Column(name = "authFlag")
    public String getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    @Basic
    @Column(name = "usageScope")
    public String getUsageScope() {
        return usageScope;
    }

    public void setUsageScope(String usageScope) {
        this.usageScope = usageScope;
    }

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (menuId != menu.menuId) return false;
        if (menuName != null ? !menuName.equals(menu.menuName) : menu.menuName != null) return false;
        if (displayName != null ? !displayName.equals(menu.displayName) : menu.displayName != null) return false;
        if (target != null ? !target.equals(menu.target) : menu.target != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;
        if (picPath != null ? !picPath.equals(menu.picPath) : menu.picPath != null) return false;
        if (parentId != null ? !parentId.equals(menu.parentId) : menu.parentId != null) return false;
        if (menuType != null ? !menuType.equals(menu.menuType) : menu.menuType != null) return false;
        if (authFlag != null ? !authFlag.equals(menu.authFlag) : menu.authFlag != null) return false;
        if (usageScope != null ? !usageScope.equals(menu.usageScope) : menu.usageScope != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(menu.deleteFlag) : menu.deleteFlag != null) return false;
        if (sort != null ? !sort.equals(menu.sort) : menu.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (menuId ^ (menuId >>> 32));
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (picPath != null ? picPath.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (menuType != null ? menuType.hashCode() : 0);
        result = 31 * result + (authFlag != null ? authFlag.hashCode() : 0);
        result = 31 * result + (usageScope != null ? usageScope.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }
}
