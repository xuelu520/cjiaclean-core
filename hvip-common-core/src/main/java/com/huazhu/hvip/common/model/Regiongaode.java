package com.huazhu.hvip.common.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
public class Regiongaode {
    private long regionId;
    private Long parentId;
    private String cityCode;
    private String adCode;
    private String name;
    private String center;
    private String level;
    private String areaCode;
    private Long partitionId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "regionId")
    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "cityCode")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "adCode")
    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "center")
    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "areaCode")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "partitionId")
    public Long getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Long partitionId) {
        this.partitionId = partitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Regiongaode that = (Regiongaode) o;

        if (regionId != that.regionId) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (adCode != null ? !adCode.equals(that.adCode) : that.adCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (center != null ? !center.equals(that.center) : that.center != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (areaCode != null ? !areaCode.equals(that.areaCode) : that.areaCode != null) return false;
        if (partitionId != null ? !partitionId.equals(that.partitionId) : that.partitionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (regionId ^ (regionId >>> 32));
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (adCode != null ? adCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (center != null ? center.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (partitionId != null ? partitionId.hashCode() : 0);
        return result;
    }
}
