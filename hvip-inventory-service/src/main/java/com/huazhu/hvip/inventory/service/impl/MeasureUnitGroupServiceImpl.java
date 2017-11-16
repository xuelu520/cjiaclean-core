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
import com.huazhu.hvip.inventory.manager.MeasureUnitGroupManager;
import com.huazhu.hvip.inventory.model.MeasureUnitGroup;
import com.huazhu.hvip.inventory.qo.MeasureUnitGroupQO;
import com.huazhu.hvip.inventory.service.MeasureUnitGroupService;
import com.huazhu.hvip.inventory.vo.MeasureUnitGroupVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
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
@Service("measureUnitGroupService")
public class MeasureUnitGroupServiceImpl implements MeasureUnitGroupService {

    private static Logger logger = LogManager.getLogger(MeasureUnitGroupServiceImpl.class);

    @Autowired
    private MeasureUnitGroupManager measureUnitGroupManager;

    /**
     * 获取计量组列表
     * @return ReturnObject
     */
    @Override
    public ReturnObject<MeasureUnitGroupVO> getAll() {
        logger.info("call getAll()");

        ReturnObject<MeasureUnitGroupVO> ret = new ReturnObject<MeasureUnitGroupVO>();

        try {
            List<MeasureUnitGroupVO> voList = new ArrayList<MeasureUnitGroupVO>();
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
            List<MeasureUnitGroup> measureUnitGroupList = measureUnitGroupManager.search(queryModel);
            for(MeasureUnitGroup measureUnitGroup : measureUnitGroupList) {
                MeasureUnitGroupVO measureUnitGroupVO = new MeasureUnitGroupVO();
                BeanUtils.copyProperties(measureUnitGroup, measureUnitGroupVO);
                voList.add(measureUnitGroupVO);
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
     * 保存计量组
     * @param measureUnitGroupVO
     * @return ReturnObject
     */
    @Override
    public ReturnObject<MeasureUnitGroupVO> saveMeasureUnitGroup(MeasureUnitGroupVO measureUnitGroupVO) {
        logger.info("call saveMeasureUnitGroup({})", JsonUtil.JSON_Bean2String(measureUnitGroupVO));

        ReturnObject<MeasureUnitGroupVO> ret = new ReturnObject<MeasureUnitGroupVO>();

        try {
            MeasureUnitGroup measureUnitGroup = new MeasureUnitGroup();
            BeanUtils.copyProperties(measureUnitGroupVO, measureUnitGroup);
            measureUnitGroup.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
            measureUnitGroup = measureUnitGroupManager.save(measureUnitGroup);
            BeanUtils.copyProperties(measureUnitGroup, measureUnitGroupVO);
            ret.setData(measureUnitGroupVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnMsg("查询失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 查询计量单位组列表
     * @param measureUnitGroupQO
     * @return
     */
    @Override
    public ReturnObject<MeasureUnitGroupVO> searchMeasureUnitGroupList(MeasureUnitGroupQO measureUnitGroupQO) {
        logger.info("call searchMeasureUnitGroupList({})",JsonUtil.JSON_Bean2String(measureUnitGroupQO));
        ReturnObject<MeasureUnitGroupVO> ret = new ReturnObject<MeasureUnitGroupVO>();

        try {
            ParamObject param = new ParamObject();
            param.add("unitGroupName",measureUnitGroupQO.getUnitGroupName());
            param.add("unitGroupCode",measureUnitGroupQO.getUnitGroupCode());
            param.add("basicUnit",measureUnitGroupQO.getBasicUnit());
            param.add("page",measureUnitGroupQO.getPageCondition());
            List<MeasureUnitGroup> list = measureUnitGroupManager.searchMeasureUnitGroupList(param);
            List<MeasureUnitGroupVO> voList = new ArrayList<MeasureUnitGroupVO>();
            for (MeasureUnitGroup measureUnitGroup : list) {
                MeasureUnitGroupVO measureUnitGroupVO = new MeasureUnitGroupVO();
                BeanUtils.copyProperties(measureUnitGroup, measureUnitGroupVO);
                voList.add(measureUnitGroupVO);
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

    @Override
    public ReturnObject<MeasureUnitGroupVO> getMeasureUnitGroupById(Long groupId) {
        logger.info("call getMeasureUnitGroupById({})",groupId);
        ReturnObject<MeasureUnitGroupVO> ret = new ReturnObject<MeasureUnitGroupVO>();
        try {
            if(groupId == null){
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("groupId为空，查询失败");
            }

            MeasureUnitGroup measureUnitGroup = measureUnitGroupManager.get(groupId);
            MeasureUnitGroupVO measureUnitGroupVO = new MeasureUnitGroupVO();
            BeanUtils.copyProperties(measureUnitGroup, measureUnitGroupVO);


            ret.setData(measureUnitGroupVO);
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
    public ReturnObject deleteMeasureUnitGroup(Long[] ids) {
        logger.info("call deleteMeasureUnitGroup({\"ids:\"" + ids.toString() + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ParamObject paramObject=new ParamObject();
            String id=StringUtils.join(ids, ",");
            paramObject.add("id",id);
            measureUnitGroupManager.deleteMeasureUnitGroup(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除成功");
        } catch (Exception e) {
            logger.error("删除失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除失败");
        }

        return ret;
    }

}
