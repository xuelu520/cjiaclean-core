/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 14:32:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:32:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.inventory.manager.impl;

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.inventory.dao.MeasureUnitGroupDao;
import com.huazhu.hvip.inventory.manager.MeasureUnitGroupManager;
import com.huazhu.hvip.inventory.model.MeasureUnitGroup;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("measureUnitGroupManager")
public class MeasureUnitGroupManagerImpl extends GenericManagerImpl<MeasureUnitGroup,Long> implements MeasureUnitGroupManager {
    private static Logger logger = LogManager.getLogger(MeasureUnitGroupManagerImpl.class);
    MeasureUnitGroupDao measureUnitGroupDao;

    @Autowired
    public MeasureUnitGroupManagerImpl(MeasureUnitGroupDao measureUnitGroupDao){
        super(measureUnitGroupDao);
        this.measureUnitGroupDao = measureUnitGroupDao;
    }

    /**
     * 根据id删除单位
     * @param paramObject 单位ID
     * @return count
     */
    @Override
    public void deleteMeasureUnitGroup(ParamObject paramObject) {
        logger.info("call deleteMeasureUnitGroup({})", JsonUtil.JSON_Bean2String(paramObject));
        QueryModel queryModel=new QueryModel();
        String id=paramObject.getStringParam("id");
        if(StringUtils.isNotEmpty(id)){
            queryModel.addHqlCondition("UnitGroupId in ("+id+")");
        }
        queryModel.addHqlCondition(" deleteFlag !="+Constants.DELETE_FLAG_TRUE+"");
        List<MeasureUnitGroup> measureUnitGroupList=measureUnitGroupDao.search(queryModel);
        for(MeasureUnitGroup measureUnitGroup :measureUnitGroupList){
            measureUnitGroup.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
            measureUnitGroupDao.save(measureUnitGroup);
        }
    }

    /**
     * 查询单位列表
     * @param param
     * @return
     */
    @Override
    public List<MeasureUnitGroup> searchMeasureUnitGroupList(ParamObject param) {
        logger.info("call searchMeasureUnitGroupList({})", JsonUtil.JSON_Bean2String(param));
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
        if(param.getParam("page")!=null) {
            PageCondition page = (PageCondition) param.getParam("page");
            if (page.getPageNo() != null) {
                queryModel.setPageNo(page.getPageNo());
            }
            if (page.getPageSize() != null) {
                queryModel.setPageSize(page.getPageSize());
            }
        }
        queryModel.addColumnValueCondition("unitGroupName",param.getStringParam("unitGroupName"));
        queryModel.addColumnValueCondition("unitGroupCode",param.getStringParam("unitGroupCode"));
        queryModel.addColumnValueCondition("basicUnit",param.getStringParam("basicUnit"));

        List<MeasureUnitGroup> measureUnitGroupList = measureUnitGroupDao.search(queryModel);
        param.setTotalNum(queryModel.getTotalNum());
        return measureUnitGroupList;
    }
}
