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
@Table(name = "measureUnitGroup")
public class MeasureUnitGroup extends BaseObject {
    private Long unitGroupId;
    private String unitGroupName;
    private String unitGroupCode;
    private String basicUnit;
    private String deleteFlag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitGroupId")
    public Long getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(Long unitGroupId) {
        this.unitGroupId = unitGroupId;
    }

    @Basic
    @Column(name = "unitGroupName")
    public String getUnitGroupName() {
        return unitGroupName;
    }

    public void setUnitGroupName(String unitGroupName) {
        this.unitGroupName = unitGroupName;
    }

    @Basic
    @Column(name = "unitGroupCode")
    public String getUnitGroupCode() {
        return unitGroupCode;
    }

    public void setUnitGroupCode(String unitGroupCode) {
        this.unitGroupCode = unitGroupCode;
    }

    @Basic
    @Column(name = "basicUnit")
    public String getBasicUnit() {
        return basicUnit;
    }

    public void setBasicUnit(String basicUnit) {
        this.basicUnit = basicUnit;
    }

    @Basic
    @Column(name = "deleteFlag")
    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * Returns a multi-line String with key=value pairs.
     *
     * @return a String representation of this class.
     */
    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureUnitGroup that = (MeasureUnitGroup) o;

        if (unitGroupId != null ? !unitGroupId.equals(that.unitGroupId) : that.unitGroupId != null) return false;
        if (unitGroupName != null ? !unitGroupName.equals(that.unitGroupName) : that.unitGroupName != null)
            return false;
        if (unitGroupCode != null ? !unitGroupCode.equals(that.unitGroupCode) : that.unitGroupCode != null)
            return false;
        if (basicUnit != null ? !basicUnit.equals(that.basicUnit) : that.basicUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitGroupId != null ? unitGroupId.hashCode() : 0;
        result = 31 * result + (unitGroupName != null ? unitGroupName.hashCode() : 0);
        result = 31 * result + (unitGroupCode != null ? unitGroupCode.hashCode() : 0);
        result = 31 * result + (basicUnit != null ? basicUnit.hashCode() : 0);
        return result;
    }
}
