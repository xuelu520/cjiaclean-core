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
@Table(name = "goodsMateriel")
public class GoodsMateriel extends BaseObject {
    private Long goodsMaterieId;
    private Long goodsId;
    private Long materielId;
    private Integer goodsNum;
    private Integer materielNum;
    private Long unitId;
    private String unit;
    private Long hotelId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goodsMaterieId")
    public Long getGoodsMaterieId() {
        return goodsMaterieId;
    }

    public void setGoodsMaterieId(Long goodsMaterieId) {
        this.goodsMaterieId = goodsMaterieId;
    }

    @Basic
    @Column(name = "goodsId")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "materielId")
    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    @Basic
    @Column(name = "goodsNum")
    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Basic
    @Column(name = "materielNum")
    public Integer getMaterielNum() {
        return materielNum;
    }

    public void setMaterielNum(Integer materielNum) {
        this.materielNum = materielNum;
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
    @Column(name = "hotelId")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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

        GoodsMateriel that = (GoodsMateriel) o;

        if (goodsMaterieId != null ? !goodsMaterieId.equals(that.goodsMaterieId) : that.goodsMaterieId != null)
            return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (materielId != null ? !materielId.equals(that.materielId) : that.materielId != null) return false;
        if (goodsNum != null ? !goodsNum.equals(that.goodsNum) : that.goodsNum != null) return false;
        if (materielNum != null ? !materielNum.equals(that.materielNum) : that.materielNum != null) return false;
        if (unitId != null ? !unitId.equals(that.unitId) : that.unitId != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsMaterieId != null ? goodsMaterieId.hashCode() : 0;
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (materielId != null ? materielId.hashCode() : 0);
        result = 31 * result + (goodsNum != null ? goodsNum.hashCode() : 0);
        result = 31 * result + (materielNum != null ? materielNum.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        return result;
    }
}
