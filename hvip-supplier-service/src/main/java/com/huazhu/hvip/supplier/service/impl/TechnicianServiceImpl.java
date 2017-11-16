/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TechnicianServiceImpl.java
 * Author:   lijing
 * Date:     2016-05-04 10:05:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-04 10:05:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.supplier.manager.TechnicianManager;
import com.huazhu.hvip.supplier.model.Technician;
import com.huazhu.hvip.supplier.qo.TechnicianQO;
import com.huazhu.hvip.supplier.service.TechnicianService;
import com.huazhu.hvip.supplier.vo.TechnicianVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
@Service("technicianService")
public class TechnicianServiceImpl implements TechnicianService{

    private static Logger logger = LogManager.getLogger(TechnicianServiceImpl.class);

    @Autowired
    private TechnicianManager technicianManager;


    /**
     * 根据ID查询技师信息
     * @param id
     * @return
     */
    @Override
    public ReturnObject<TechnicianVO> getTechnicianById(Long id) {
        logger.info("call getTechnicianById({\"id:\""+ id +"})");

        ReturnObject<TechnicianVO> ret = new ReturnObject<TechnicianVO>();
        try {
            Technician technician = technicianManager.get(id);
            TechnicianVO technicianVO = new TechnicianVO();
            BeanUtils.copyProperties(technician,technicianVO);
            ret.setData(technicianVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 保存技师信息
     * @param technicianVO
     * @return
     */
    @Override
    public ReturnObject<TechnicianVO> saveTechnician(TechnicianVO technicianVO) {
        logger.info("call saveTechnician({\"technicianVO:\""+ JsonUtil.JSON_Bean2String(technicianVO)+"})");

        ReturnObject<TechnicianVO> ret = new ReturnObject<TechnicianVO>();
        try {
            Technician technician = new Technician();
            BeanUtils.copyProperties(technicianVO,technician);
            technician = technicianManager.saveTechnician(technician);
            BeanUtils.copyProperties(technician,technicianVO);
            ret.setData(technicianVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存成功");
        }

        return ret;
    }

    /**
     * 批量保存技师信息
     * @param list
     * @return
     */
    @Override
    public ReturnObject<TechnicianVO> saveTechnicians(List<TechnicianVO> list) {
        logger.info("call saveTechnicians({\"list:\""+ JsonUtil.JSON_List2String(list)+"})");

        ReturnObject<TechnicianVO> ret = new ReturnObject<TechnicianVO>();
        try {
            List<Technician> tecList = null;
            if(list!=null&&list.size()>0){
                tecList = new ArrayList<Technician>();
                Technician tec = null;
                for(TechnicianVO tecVO : list){
                    tec = new Technician();
                    BeanUtils.copyProperties(tecVO,tec);
                    tecList.add(tec);
                }
            }

            tecList = technicianManager.saveTechnicians(tecList);

            List<TechnicianVO> voList = null;
            if(tecList!=null&&tecList.size()>0){
                voList = new ArrayList<TechnicianVO>();
                TechnicianVO tecVO = null;
                for(Technician tec : tecList){
                    tecVO = new TechnicianVO();
                    BeanUtils.copyProperties(tec,tecVO);
                    voList.add(tecVO);
                }
            }

            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }

        return ret;
    }

    /**
     * 查询技师列表
     * @return
     */
    @Override
    public ReturnObject<TechnicianVO> searchTechnicianList(TechnicianQO technicianQO) {
        logger.info("call searchTechnicianList({\"technicianQO:\""+JsonUtil.JSON_Bean2String(technicianQO)+"})");

        ReturnObject<TechnicianVO> ret = new ReturnObject<TechnicianVO>();

        try {
            ParamObject param = new ParamObject();
            param.add("technicianId",technicianQO.getTechnicianId());
            param.add("technicianIds",technicianQO.getTechnicianIds());
            List<Technician> tecList = technicianManager.searchTechnicianList(param);
            List<TechnicianVO> voList = null;
            if(tecList!=null&&tecList.size()>0){
                voList = new ArrayList<TechnicianVO>();
                TechnicianVO tecVO = null;
                for(Technician tec : tecList){
                    tecVO = new TechnicianVO();
                    BeanUtils.copyProperties(tec,tecVO);
                    voList.add(tecVO);
                }
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }
}
