package com.huazhu.hvip.inventory.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author cmy
 * @create 2017-07-27 16:03
 **/
@Entity
public class Materiel {
    private Long materielId;
    private String materielName;
    private String materielSn;
    private String brief;
    private String description;
    private String unitGroupId;
    private Long unitId;
    private String unit;
    private String status;
    private String deleteFlag;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "materielId")
    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    @Basic
    @Column(name = "materielName")
    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    @Basic
    @Column(name = "materielSn")
    public String getMaterielSn() {
        return materielSn;
    }

    public void setMaterielSn(String materielSn) {
        this.materielSn = materielSn;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "unitGroupId")
    public String getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(String unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    @Basic
    @Column(name = "unitId")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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

        Materiel materiel = (Materiel) o;

        if (materielId != null ? !materielId.equals(materiel.materielId) : materiel.materielId != null) return false;
        if (materielName != null ? !materielName.equals(materiel.materielName) : materiel.materielName != null)
            return false;
        if (materielSn != null ? !materielSn.equals(materiel.materielSn) : materiel.materielSn != null) return false;
        if (brief != null ? !brief.equals(materiel.brief) : materiel.brief != null) return false;
        if (description != null ? !description.equals(materiel.description) : materiel.description != null)
            return false;
        if (unitGroupId != null ? !unitGroupId.equals(materiel.unitGroupId) : materiel.unitGroupId != null)
            return false;
        if (unitId != null ? !unitId.equals(materiel.unitId) : materiel.unitId != null) return false;
        if (unit != null ? !unit.equals(materiel.unit) : materiel.unit != null) return false;
        if (status != null ? !status.equals(materiel.status) : materiel.status != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(materiel.deleteFlag) : materiel.deleteFlag != null) return false;
        if (createTime != null ? !createTime.equals(materiel.createTime) : materiel.createTime != null) return false;
        if (createUser != null ? !createUser.equals(materiel.createUser) : materiel.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(materiel.updateTime) : materiel.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(materiel.updateUser) : materiel.updateUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = materielId != null ? materielId.hashCode() : 0;
        result = 31 * result + (materielName != null ? materielName.hashCode() : 0);
        result = 31 * result + (materielSn != null ? materielSn.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (unitGroupId != null ? unitGroupId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        return result;
    }
}
