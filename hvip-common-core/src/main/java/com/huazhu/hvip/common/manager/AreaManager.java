/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AreaManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager;

import java.util.List;

import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.model.Area;
import com.huazhu.hvip.base.service.GenericManager;

public interface AreaManager extends GenericManager<Area, Long> {
    /**
     * 获取地区数据
     *
     * @param queryModel
     * @return
     */
    public List getAreaList(QueryModel queryModel);

    /**
     * 添加地区数据
     *
     * @param AreaVO
     * @return
     */

    public Area createArea(Area area);

    public List<Area> getSubwayWithStationName(QueryModel queryModel);

}