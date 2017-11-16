package com.huazhu.hvip.inventory.vo;

import java.io.Serializable;

/**
 * Created by DINGQIANQIAN on 2016/9/21.
 */
public class MeasureUnitVO implements Serializable {
    private Long unitId;//主键
    private Long unitGroupId;//计量单位组id
    private String unit;//计量单位
    private String deleteFlag;//删除标志
    private Integer basicUnitRate;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(Long unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    public Integer getBasicUnitRate() {
        return basicUnitRate;
    }

    public void setBasicUnitRate(Integer basicUnitRate) {
        this.basicUnitRate = basicUnitRate;
    }
}
