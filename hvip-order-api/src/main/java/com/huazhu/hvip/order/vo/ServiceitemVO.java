package com.huazhu.hvip.order.vo;

import com.huazhu.hvip.base.PageCondition;

import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-17 16:49
 **/
public class ServiceitemVO extends PageCondition {
    private Long serviceItemId;
    private Long serviceId;
    private String floor;
    private String rooms;
    private Long cleanId;
    private String cleanName;
    private String status;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;

    public Long getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Long serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public Long getCleanId() {
        return cleanId;
    }

    public void setCleanId(Long cleanId) {
        this.cleanId = cleanId;
    }

    public String getCleanName() {
        return cleanName;
    }

    public void setCleanName(String cleanName) {
        this.cleanName = cleanName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
