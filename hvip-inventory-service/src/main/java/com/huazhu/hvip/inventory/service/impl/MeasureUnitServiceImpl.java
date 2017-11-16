/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-21 10:30:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-21 10:30:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.inventory.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.inventory.manager.MeasureUnitManager;
import com.huazhu.hvip.inventory.model.MeasureUnit;
import com.huazhu.hvip.inventory.qo.MeasureUnitQO;
import com.huazhu.hvip.inventory.service.MeasureUnitService;
import com.huazhu.hvip.inventory.vo.MeasureUnitVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("measureUnitService")
public class MeasureUnitServiceImpl implements MeasureUnitService {
    private static Logger logger = LogManager.getLogger(MeasureUnitServiceImpl.class);

    @Autowired
    private MeasureUnitManager measureUnitManager;

    /**
     * 获取品牌列表
     * @return ReturnObject
     */
    @Override
    public ReturnObject<MeasureUnitVO> getAll() {
        logger.info("call getAll()");

        ReturnObject<MeasureUnitVO> ret = new ReturnObject<MeasureUnitVO>();

        try {
            List<MeasureUnitVO> voList = new ArrayList<MeasureUnitVO>();
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
            List<MeasureUnit> measureUnitList = measureUnitManager.search(queryModel);
            for(MeasureUnit measureUnit : measureUnitList) {
                MeasureUnitVO measureUnitVO = new MeasureUnitVO();
                BeanUtils.copyProperties(measureUnit, measureUnitVO);
                voList.add(measureUnitVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnMsg("查询失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 保存单位
     * @param measureUnitVO
     * @return ReturnObject
     */
    @Override
    public ReturnObject<MeasureUnitVO> saveMeasureUnit(MeasureUnitVO measureUnitVO) {
        logger.info("call saveMeasureUnit({})", JsonUtil.JSON_Bean2String(measureUnitVO));

        ReturnObject<MeasureUnitVO> ret = new ReturnObject<MeasureUnitVO>();

        try {
            MeasureUnit measureUnit = new MeasureUnit();
            BeanUtils.copyProperties(measureUnitVO, measureUnit);
            measureUnit.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
            measureUnit = measureUnitManager.save(measureUnit);
            BeanUtils.copyProperties(measureUnit, measureUnitVO);
            ret.setData(measureUnitVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnMsg("查询失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 查询计量单位组列表
     * @param measureUnitQO
     * @return
     */
    @Override
    public ReturnObject<MeasureUnitVO> searchMeasureUnitList(MeasureUnitQO measureUnitQO) {
        logger.info("call searchMeasureUnitList({})", JsonUtil.JSON_Bean2String(measureUnitQO));
        ReturnObject<MeasureUnitVO> ret = new ReturnObject<MeasureUnitVO>();

        try {
            ParamObject param = new ParamObject();
            param.add("unitGroupId",measureUnitQO.getUnitGroupId());
            param.add("unit",measureUnitQO.getUnit());
            param.add("basicUnitRate",measureUnitQO.getBasicUnitRate());
            param.add("page",measureUnitQO.getPageCondition());
            List<MeasureUnit> list = measureUnitManager.searchMeasureUnitList(param);
            List<MeasureUnitVO> voList = new ArrayList<MeasureUnitVO>();
            for (MeasureUnit measureUnit : list) {
                MeasureUnitVO measureUnitVO = new MeasureUnitVO();
                BeanUtils.copyProperties(measureUnit, measureUnitVO);
                voList.add(measureUnitVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(param.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 查询单个计量单位
     * @param Id
     * @return
     */
    @Override
    public ReturnObject<MeasureUnitVO> getMeasureUnitById(Long Id) {
        logger.info("call getMeasureUnitById({})",Id);
        ReturnObject<MeasureUnitVO> ret = new ReturnObject<MeasureUnitVO>();
        try {
            if(Id == null){
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("Id为空，查询失败");
            }

            MeasureUnit measureUnit = measureUnitManager.get(Id);
            MeasureUnitVO measureUnitVO = new MeasureUnitVO();
            BeanUtils.copyProperties(measureUnit, measureUnitVO);


            ret.setData(measureUnitVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 根据id删除单位
     * @param ids 单位ID
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject deleteMeasureUnit(Long[] ids) {
        logger.info("call deleteMeasureUnit({\"ids:\"" + ids.toString() + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ParamObject paramObject=new ParamObject();
            String id= StringUtils.join(ids, ",");
            paramObject.add("id",id);
            measureUnitManager.deleteMeasureUnit(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除成功");
        } catch (Exception e) {
            logger.error("删除失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除失败");
        }

        return ret;
    }

    /**
     *查询所有单位
     *
     * @return
     */
    @Override
    public ReturnObject getAllMeasureUnit() {
        logger.info("call getAllMeasureUnit({})");
        ReturnObject returnObject=new ReturnObject();
        try {
            List<MeasureUnitVO> measureUnitVOList=new ArrayList<>();
            QueryModel queryModel=new QueryModel();
            queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
            List<MeasureUnit> measureUnitList=measureUnitManager.search(queryModel);
            if(measureUnitList!=null&& measureUnitList.size()>0){
                for(MeasureUnit measureUnit:measureUnitList){
                    MeasureUnitVO measureUnitVO=new MeasureUnitVO();
                    BeanUtils.copyProperties(measureUnit,measureUnitVO);
                    measureUnitVOList.add(measureUnitVO);
                }
                returnObject.setDataList(measureUnitVOList);
                returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            }
        } catch (BeansException e) {
            logger.error(e.getMessage());
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return returnObject;
    }
}
