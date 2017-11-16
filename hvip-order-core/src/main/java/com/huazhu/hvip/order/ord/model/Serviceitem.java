package com.huazhu.hvip.order.ord.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-08-15 10:59
 **/
@Entity
@Table(name = "vip_serviceitem", schema = "", catalog = "cjiaclean_order")
public class Serviceitem {
    private Long serviceItemId;
    private Long serviceId;
    private String floor;
    private String rooms;
    private Long cleanId;
    private String cleanName;
    private String status;
    private String deleteFlag;
    private Date createTime;
    private Date updateTime;
    private String createUser;
    private String updateUser;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serviceItemId")
    public Long getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Long serviceItemId) {
        this.serviceItemId = serviceItemId;
    }
    @Basic
    @Column(name = "serviceId")
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "rooms")
    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    @Basic
    @Column(name = "cleanId")
    public Long getCleanId() {
        return cleanId;
    }

    public void setCleanId(Long cleanId) {
        this.cleanId = cleanId;
    }

    @Basic
    @Column(name = "cleanName")
    public String getCleanName() {
        return cleanName;
    }

    public void setCleanName(String cleanName) {
        this.cleanName = cleanName;
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
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    @Column(name = "createUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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

        Serviceitem that = (Serviceitem) o;

        if (serviceItemId != null ? !serviceItemId.equals(that.serviceItemId) : that.serviceItemId != null)
            return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (rooms != null ? !rooms.equals(that.rooms) : that.rooms != null) return false;
        if (cleanId != null ? !cleanId.equals(that.cleanId) : that.cleanId != null) return false;
        if (cleanName != null ? !cleanName.equals(that.cleanName) : that.cleanName != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        return !(updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null);

    }

    @Override
    public int hashCode() {
        int result = serviceItemId != null ? serviceItemId.hashCode() : 0;
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        result = 31 * result + (cleanId != null ? cleanId.hashCode() : 0);
        result = 31 * result + (cleanName != null ? cleanName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
