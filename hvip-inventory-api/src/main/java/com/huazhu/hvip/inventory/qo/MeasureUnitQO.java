package com.huazhu.hvip.inventory.qo;

import com.huazhu.hvip.base.PageCondition;

import java.io.Serializable;

/**
 * Created by DINGQIANQIAN on 2016/9/21.
 */
public class MeasureUnitQO implements Serializable {
    private Long unitId;//主键
    private Long unitGroupId;//计量单位组id
    private String unit;//计量单位
    private String basicUnitRate;//与基本计量单位换算率
    private PageCondition pageCondition;//分页
    private String deleteFlag;//删除标志

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

    public String getBasicUnitRate() {
        return basicUnitRate;
    }

    public void setBasicUnitRate(String basicUnitRate) {
        this.basicUnitRate = basicUnitRate;
    }

    public PageCondition getPageCondition() {
        return pageCondition;
    }

    public void setPageCondition(PageCondition pageCondition) {
        this.pageCondition = pageCondition;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
