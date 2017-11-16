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
import com.huazhu.hvip.inventory.dao.MeasureUnitDao;
import com.huazhu.hvip.inventory.manager.MeasureUnitManager;
import com.huazhu.hvip.inventory.model.MeasureUnit;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@Service("MeasureUnitManager")
public class MeasureUnitManagerImpl extends GenericManagerImpl<MeasureUnit,Long> implements MeasureUnitManager {

    private static Logger logger = LogManager.getLogger(MeasureUnitManagerImpl.class);
    MeasureUnitDao measureUnitDao;

    @Autowired
    public MeasureUnitManagerImpl(MeasureUnitDao measureUnitDao){
        super(measureUnitDao);
        this.measureUnitDao = measureUnitDao;
    }

    /**
     * 根据id删除单位
     * @param paramObject 单位ID
     * @return count
     */
    @Override
    public void deleteMeasureUnit(ParamObject paramObject) {
        logger.info("call deleteMeasureUnit({})", JsonUtil.JSON_Bean2String(paramObject));
        QueryModel queryModel=new QueryModel();
        String id=paramObject.getStringParam("id");
        if(StringUtils.isNotEmpty(id)){
            queryModel.addHqlCondition("unitId in ("+id+")");
        }
        queryModel.addHqlCondition(" deleteFlag !="+Constants.DELETE_FLAG_TRUE+"");
        List<MeasureUnit> measureUnitList=measureUnitDao.search(queryModel);
        for(MeasureUnit measureUnit :measureUnitList){
            measureUnit.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
            measureUnitDao.save(measureUnit);
        }
    }

    /**
     * 查询单位列表
     * @param param
     * @return
     */
    @Override
    public List<MeasureUnit> searchMeasureUnitList(ParamObject param) {
        logger.info("call searchMeasureUnitList({})", JsonUtil.JSON_Bean2String(param));
        QueryModel queryModel = new QueryModel();

        if(param.getParam("page")!=null) {
            PageCondition page = (PageCondition) param.getParam("page");
            if (page.getPageNo() != null) {
                queryModel.setPageNo(page.getPageNo());
            }
            if (page.getPageSize() != null) {
                queryModel.setPageSize(page.getPageSize());
            }
        }

        queryModel.addColumnValueCondition("unitName",param.getStringParam("unitName"));
        queryModel.addColumnValueCondition("unitCode",param.getStringParam("unitCode"));
        queryModel.addColumnValueCondition("basicUnit",param.getStringParam("basicUnit"));
        queryModel.addColumnValueCondition("deleteFlag", Constants.DELETE_FLAG_FALSE);
        queryModel.addColumnValueCondition("unitGroupId",param.getLongParam("unitGroupId"));
        queryModel.setSortHql(" unitGroupId ");
        List<MeasureUnit> measureUnitList = measureUnitDao.search(queryModel);
        param.setTotalNum(queryModel.getTotalNum());
        return measureUnitList;
    }
}
