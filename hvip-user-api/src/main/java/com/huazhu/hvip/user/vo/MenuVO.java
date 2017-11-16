package com.huazhu.hvip.user.vo;


import com.huazhu.hvip.base.model.BaseObject;

import java.util.List;

/**
 * Created by XUEYONGPING001 on 2016-07-22.
 */
public class MenuVO extends BaseObject {
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

    public MenuVO() {
    }



    public boolean getHasChildren() {
        this.hasChildren = this.children != null && !this.children.isEmpty();
        return this.hasChildren;
    }

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getAuthFlag() {
        return this.authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    public String getUsageScope() {
        return this.usageScope;
    }

    public void setUsageScope(String usageScope) {
        this.usageScope = usageScope;
    }

    public String getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<MenuVO> getChildren() {
        return this.children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "MenuVO{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", target='" + target + '\'' +
                ", url='" + url + '\'' +
                ", picPath='" + picPath + '\'' +
                ", parentId=" + parentId +
                ", menuType='" + menuType + '\'' +
                ", authFlag='" + authFlag + '\'' +
                ", usageScope='" + usageScope + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                ", hasChildren=" + hasChildren +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuVO menuVO = (MenuVO) o;

        if (hasChildren != menuVO.hasChildren) return false;
        if (menuId != null ? !menuId.equals(menuVO.menuId) : menuVO.menuId != null) return false;
        if (menuName != null ? !menuName.equals(menuVO.menuName) : menuVO.menuName != null) return false;
        if (displayName != null ? !displayName.equals(menuVO.displayName) : menuVO.displayName != null) return false;
        if (target != null ? !target.equals(menuVO.target) : menuVO.target != null) return false;
        if (url != null ? !url.equals(menuVO.url) : menuVO.url != null) return false;
        if (picPath != null ? !picPath.equals(menuVO.picPath) : menuVO.picPath != null) return false;
        if (parentId != null ? !parentId.equals(menuVO.parentId) : menuVO.parentId != null) return false;
        if (menuType != null ? !menuType.equals(menuVO.menuType) : menuVO.menuType != null) return false;
        if (authFlag != null ? !authFlag.equals(menuVO.authFlag) : menuVO.authFlag != null) return false;
        if (usageScope != null ? !usageScope.equals(menuVO.usageScope) : menuVO.usageScope != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(menuVO.deleteFlag) : menuVO.deleteFlag != null) return false;
        if (sort != null ? !sort.equals(menuVO.sort) : menuVO.sort != null) return false;
        if (children != null ? !children.equals(menuVO.children) : menuVO.children != null) return false;
        return !(state != null ? !state.equals(menuVO.state) : menuVO.state != null);

    }

    @Override
    public int hashCode() {
        int result = menuId != null ? menuId.hashCode() : 0;
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
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (hasChildren ? 1 : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
