/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MenuVO.java
 * Author:   lijing
 * Date:     2016-04-18 16:22:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-18 16:22:31> <version>   <desc>
 *
 */

package com.huazhu.hvip.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MenuVO implements Serializable {
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
    private List<MenuVO> children;
    private boolean hasChildren;
    private String state;//菜单是否展开

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // ----------------------view---------------------------- //
    public boolean getHasChildren() {
        hasChildren = this.children == null || this.children.isEmpty() ? false : true;
        return hasChildren;
    }
// ---------------------- /view---------------------------- //

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    public String getUsageScope() {
        return usageScope;
    }

    public void setUsageScope(String usageScope) {
        this.usageScope = usageScope;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
