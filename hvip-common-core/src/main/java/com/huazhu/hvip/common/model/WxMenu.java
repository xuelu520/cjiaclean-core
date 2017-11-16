package com.huazhu.hvip.common.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-03 10:14
 **/
@Entity
@Table(name = "wx_menu", schema = "", catalog = "cjiaclean_common")
public class WxMenu {
    private Long wxMenuId;
    private String menuName;
    private String menuType;
    private String menuKey;
    private String url;
    private Long parentId;
    private String authorize;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wx_menuId")
    public Long getWxMenuId() {
        return wxMenuId;
    }

    public void setWxMenuId(Long wxMenuId) {
        this.wxMenuId = wxMenuId;
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
    @Column(name = "authorize")
    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
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
    @Column(name = "menuKey")
    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
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
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

        WxMenu wxMenu = (WxMenu) o;

        if (wxMenuId != null ? !wxMenuId.equals(wxMenu.wxMenuId) : wxMenu.wxMenuId != null) return false;
        if (menuName != null ? !menuName.equals(wxMenu.menuName) : wxMenu.menuName != null) return false;
        if (menuType != null ? !menuType.equals(wxMenu.menuType) : wxMenu.menuType != null) return false;
        if (menuKey != null ? !menuKey.equals(wxMenu.menuKey) : wxMenu.menuKey != null) return false;
        if (url != null ? !url.equals(wxMenu.url) : wxMenu.url != null) return false;
        if (parentId != null ? !parentId.equals(wxMenu.parentId) : wxMenu.parentId != null) return false;
        if (createTime != null ? !createTime.equals(wxMenu.createTime) : wxMenu.createTime != null) return false;
        if (createUser != null ? !createUser.equals(wxMenu.createUser) : wxMenu.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(wxMenu.updateTime) : wxMenu.updateTime != null) return false;
        return !(updateUser != null ? !updateUser.equals(wxMenu.updateUser) : wxMenu.updateUser != null);

    }

    @Override
    public int hashCode() {
        int result = wxMenuId != null ? wxMenuId.hashCode() : 0;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (menuType != null ? menuType.hashCode() : 0);
        result = 31 * result + (menuKey != null ? menuKey.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
