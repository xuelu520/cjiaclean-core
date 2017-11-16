package com.huazhu.hvip.inventory.qo;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author admin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MeasureUnitGroupQO implements Serializable {
    private Long unitGroupId;//主键
    private String unitGroupName;//计量单位组名
    private String unitGroupCode;//计量单位组名
    private String basicUnit;//基本计量单位
    private String deleteFlag;

    private PageCondition pageCondition;

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
