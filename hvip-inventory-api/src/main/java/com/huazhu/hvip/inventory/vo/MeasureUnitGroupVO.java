package com.huazhu.hvip.inventory.vo;

import java.io.Serializable;

/**
 * Created by DINGQIANQIAN on 2016/9/21.
 */
public class MeasureUnitGroupVO implements Serializable {
    private Long unitGroupId;//主键
    private String unitGroupName;//计量单位组名
    private String unitGroupCode;//计量单位组名
    private String basicUnit;//基本计量单位
    private String deleteFlag;

    public Long getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(Long unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    public String getUnitGroupName() {
        return unitGroupName;
    }

    public void setUnitGroupName(String unitGroupName) {
        this.unitGroupName = unitGroupName;
    }

    public String getUnitGroupCode() {
        return unitGroupCode;
    }

    public void setUnitGroupCode(String unitGroupCode) {
        this.unitGroupCode = unitGroupCode;
    }

    public String getBasicUnit() {
        return basicUnit;
    }

    public void setBasicUnit(String basicUnit) {
        this.basicUnit = basicUnit;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
