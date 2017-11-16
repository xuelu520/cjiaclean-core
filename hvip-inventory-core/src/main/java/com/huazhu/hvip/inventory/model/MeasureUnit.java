package com.huazhu.hvip.inventory.model;

import com.huazhu.hvip.base.model.BaseObject;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity
@Table(name = "measureUnit")
public class MeasureUnit extends BaseObject {
    private Long unitId;
    private Long unitGroupId;
    private String unit;
    private String deleteFlag;
    private Integer basicUnitRate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitId")
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unitGroupId")
    public Long getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(Long unitGroupId) {
        this.unitGroupId = unitGroupId;
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
    @Column(name = "basicUnitRate")
    public Integer getBasicUnitRate() {
        return basicUnitRate;
    }

    public void setBasicUnitRate(Integer basicUnitRate) {
        this.basicUnitRate = basicUnitRate;
    }


    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureUnit that = (MeasureUnit) o;

        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (unitGroupId != null ? !unitGroupId.equals(that.unitGroupId) : that.unitGroupId != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (basicUnitRate != null ? !basicUnitRate.equals(that.basicUnitRate) : that.basicUnitRate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId != null ? unitId.hashCode() : 0;
        result = 31 * result + (unitGroupId != null ? unitGroupId.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (basicUnitRate != null ? basicUnitRate.hashCode() : 0);
        return result;
    }
}
