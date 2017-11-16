package com.huazhu.hvip.inventory.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DINGQIANQIAN on 2016/9/26.
 */
public class MaterielVO implements Serializable {
    private Long materielId; //主键id
    private String materielName;//物料名称
    private String materielSn;//系统编码
    private String brief;//简介
    private String description;//详细描述
    private String unitGroupId;//计量单位组id
    private Long unitId;//计量单位id
    private String unit;//计量单位
    private String unitGroupName;//组名称
    private String status;//状态
    private Date createTime;//创建时间
    private String createUser;//创建人
    private Date updateTime;//更新时间
    private String updateUser;//更新人
    private String deleteFlag;//删除标志：0否 1是


    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getMaterielSn() {
        return materielSn;
    }

    public void setMaterielSn(String materielSn) {
        this.materielSn = materielSn;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(String unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUnitGroupName() {
        return unitGroupName;
    }

    public void setUnitGroupName(String unitGroupName) {
        this.unitGroupName = unitGroupName;
    }
}
