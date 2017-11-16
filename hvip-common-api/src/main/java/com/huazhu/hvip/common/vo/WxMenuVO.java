package com.huazhu.hvip.common.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author cmy
 * @create 2017-08-03 10:17
 **/
public class WxMenuVO implements Serializable {
    private Long wxMenuId;
    private String menuName;
    private String menuType;
    private String menuKey;
    private String authorize;
    private String url;
    private Long parentId;
    private List<WxMenuVO> children;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;


    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    public Long getWxMenuId() {
        return wxMenuId;
    }

    public void setWxMenuId(Long wxMenuId) {
        this.wxMenuId = wxMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public List<WxMenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<WxMenuVO> children) {
        this.children = children;
    }
}
