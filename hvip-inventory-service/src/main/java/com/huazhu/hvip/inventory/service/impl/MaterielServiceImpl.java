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
import com.huazhu.hvip.inventory.manager.MaterielManager;
import com.huazhu.hvip.inventory.manager.MeasureUnitGroupManager;
import com.huazhu.hvip.inventory.manager.MeasureUnitManager;
import com.huazhu.hvip.inventory.model.Materiel;
import com.huazhu.hvip.inventory.model.MeasureUnit;
import com.huazhu.hvip.inventory.model.MeasureUnitGroup;
import com.huazhu.hvip.inventory.qo.MaterielQO;
import com.huazhu.hvip.inventory.service.MaterielService;
import com.huazhu.hvip.inventory.vo.MaterielVO;
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
@Service("materielService")
public class MaterielServiceImpl implements MaterielService {

    private static Logger logger = LogManager.getLogger(MaterielServiceImpl.class);

    @Autowired
    private MaterielManager materielManager;

    @Autowired
    private MeasureUnitManager measureUnitManager;

    @Autowired
    private MeasureUnitGroupManager measureUnitGroupManager;

    /**
     * 获取品牌列表
     * @return ReturnObject
     */
    @Override
    public ReturnObject<MaterielVO> getAll() {
        logger.info("call getAll()");

        ReturnObject<MaterielVO> ret = new ReturnObject<MaterielVO>();

        try {
            List<MaterielVO> voList = new ArrayList<MaterielVO>();
            List<Materiel> measureUnitList = materielManager.getAll();
            for(Materiel measureUnit : measureUnitList) {
                MaterielVO measureUnitVO = new MaterielVO();
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
     * 查询物料列表
     * @param
     * @return ret
     */
    @Override
    public ReturnObject<MaterielVO> searchMaterielList(MaterielQO materielQO){
        logger.info("call searchMaterielList({})", JsonUtil.JSON_Bean2String(materielQO));
        ReturnObject<MaterielVO> ret = new ReturnObject<MaterielVO>();
        List<String> groupIdList=new ArrayList<>();
        try {
            ParamObject param = new ParamObject();
            param.add("materielName",materielQO.getMaterielName());
            param.add("materielSn",materielQO.getMaterielSn());
            param.add("createUser",materielQO.getCreateUser());
            param.add("page",materielQO.getPageCondition());
            List<Materiel> list = materielManager.searchMaterielList(param);
            List<MaterielVO> voList = new ArrayList<MaterielVO>();
            for (Materiel materiel : list) {
                MaterielVO materielVO = new MaterielVO();
                BeanUtils.copyProperties(materiel, materielVO);
                voList.add(materielVO);
                groupIdList.add(materiel.getUnitGroupId());
            }

            String groupId=StringUtils.join(groupIdList,",");
            if(StringUtils.isNotEmpty(groupId)){
                QueryModel queryModel=new QueryModel();
                queryModel.addHqlCondition(" unitGroupId in("+groupId+")");
                List<MeasureUnitGroup> measureUnitGroups=measureUnitGroupManager.search(queryModel);
                for(MeasureUnitGroup measureUnitGroup:measureUnitGroups){
                    for (MaterielVO materielVO : voList) {
                        if(materielVO.getUnitGroupId().equals(measureUnitGroup.getUnitGroupId().toString())){
                            materielVO.setUnitGroupName(measureUnitGroup.getUnitGroupName());
                        }
                    }
                }
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
     * 保存物料
     * @return ReturnObject
     */
    @Override
    public ReturnObject<MaterielVO> saveMateriel(MaterielVO materielVO) {
        logger.info("call saveMateriel({})", JsonUtil.JSON_Bean2String(materielVO));

        ReturnObject<MaterielVO> ret = new ReturnObject<MaterielVO>();

        try {
            Materiel materiel = new Materiel();
            BeanUtils.copyProperties(materielVO, materiel);
            if(materiel.getMaterielId()!=null){
                Materiel mater =  materielManager.get(materiel.getMaterielId());
                materiel.setCreateUser(mater.getCreateUser());
                materiel.setCreateTime(mater.getCreateTime());
            }
            QueryModel queryModel=new QueryModel();
            queryModel.addColumnValueCondition("unitId",materiel.getUnitId());
            MeasureUnit measureUnit=measureUnitManager.getUniqueResult(queryModel);
            materiel.setUnit(measureUnit.getUnit());
            materiel.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
            materiel = materielManager.save(materiel);
            BeanUtils.copyProperties(materiel, materielVO);
            ret.setData(materielVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }
    /**
     * 根据id删除单位
     * @param ids 单位ID
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject deleteMateriel(Long[] ids) {
        logger.info("call deleteMateriel({\"ids:\"" + ids.toString() + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ParamObject paramObject=new ParamObject();
            String id= StringUtils.join(ids, ",");
            paramObject.add("id",id);
            materielManager.deleteMateriel(paramObject);
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
     * 根据id查询
     * @param
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject<MaterielVO> getMaterielById(Long id) {
        logger.info("call getMaterielById({})",id);
        ReturnObject<MaterielVO> ret = new ReturnObject<MaterielVO>();
        try {
            if(id == null){
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("Id为空，查询失败");
            }
            Materiel materiel = materielManager.get(id);
            MaterielVO materielVO = new MaterielVO();
            BeanUtils.copyProperties(materiel, materielVO);
            ret.setData(materielVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

}
