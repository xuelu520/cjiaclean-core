/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MenuVO.java
 * Author:   lijing
 * Date:     2016-04-18 16:22:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-18 16:22:31> <version>   <desc>
 *
 */

package com.huazhu.hvip.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RegionsVO implements Serializable {
    private Long regionId;
    private Long parentId;
    private String cityCode;
    private String adCode;
    private String name;
    private String center;
    private String level;
    private String areaCode;
    private Long partitionId;
    private List<RegionsVO> regionsVOs;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Long partitionId) {
        this.partitionId = partitionId;
    }

    public List<RegionsVO> getRegionsVOs() {
        return regionsVOs;
    }

    public void setRegionsVOs(List<RegionsVO> regionsVOs) {
        this.regionsVOs = regionsVOs;
    }
}
