/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.RegionsManager;
import com.huazhu.hvip.common.model.Regiongaode;
import com.huazhu.hvip.common.service.RegionsService;
import com.huazhu.hvip.common.vo.RegionsVO;
import com.huazhu.hvip.util.CheckUtil;
import com.huazhu.hvip.util.CopyBeanUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RegionsServiceImpl implements RegionsService {

    private static Logger logger = LogManager.getLogger(RegionsServiceImpl.class);

    @Autowired
    private RegionsManager regionsManager;

    @Override
    public ReturnObject<RegionsVO> searchRegionsVOList(Long parentId) {
        logger.info("call searchRegionsVOList(parentId : " + parentId + ")");
        ReturnObject<RegionsVO> returnObject = new ReturnObject();
        returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
        List<RegionsVO> regionsVOList = new ArrayList<>();
        try {
            List<Regiongaode> regionsList = regionsManager.searchRegionsVOList(parentId);
            if (CollectionUtils.isNotEmpty(regionsList)) {
                for (Regiongaode regions : regionsList) {
                    RegionsVO regionsVO = new RegionsVO();
                    CopyBeanUtil.copyPropertiesIgnoreNull(regions, regionsVO);
                    regionsVOList.add(regionsVO);
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call searchRegionsVOList error", e);
        }
        returnObject.setDataList(regionsVOList);
        return returnObject;
    }


    @Override
    public ReturnObject<RegionsVO> searchRegionsVOList() {
        logger.info("call searchRegionsVOList()");
        ReturnObject<RegionsVO> returnObject = new ReturnObject();
        Map<Long,List<RegionsVO>> regionVOMap=new HashMap<>();//父级Id下的List
        List<RegionsVO> regionsVOList = new ArrayList<>();//所有目录
        List<RegionsVO> voList=new ArrayList<>();//父级目录
        try {
            List<Regiongaode> regionsList = regionsManager.getAll();
            for(Regiongaode regiongaode:regionsList){
                RegionsVO regionsVO=new RegionsVO();
                CopyBeanUtil.copyPropertiesIgnoreNull(regiongaode,regionsVO);
                regionsVOList.add(regionsVO);
            }
            for(RegionsVO regionvo:regionsVOList){
                if(regionvo.getParentId()!=null&&regionvo.getParentId()==0L){
                    voList.add(regionvo);
                }
                if(regionvo.getParentId()!=null){
                    List<RegionsVO> regionsVOs=regionVOMap.get(regionvo.getParentId());
                    if(CheckUtil.checkListIsNull(regionsVOs)){
                        regionsVOs.add(regionvo);
                        regionVOMap.put(regionvo.getParentId(),regionsVOs);
                    }else {
                        regionsVOs=new ArrayList<>();
                        regionsVOs.add(regionvo);
                        regionVOMap.put(regionvo.getParentId(),regionsVOs);
                    }
                }
            }
            for(RegionsVO regionsVO:voList){
                List<RegionsVO> regionsVOs=regionVOMap.get(regionsVO.getRegionId());
                if(CheckUtil.checkListIsNull(regionsVOs)){
                    for(RegionsVO regionsVO1:regionsVOs){
                        List<RegionsVO> childRegions=regionVOMap.get(regionsVO1.getRegionId());
                        if(CheckUtil.checkListIsNull(childRegions)){
                            regionsVO1.setRegionsVOs(childRegions);
                        }
                    }
                    regionsVO.setRegionsVOs(regionsVOs);
                }
            }
            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setDataList(voList);
        } catch (Exception e) {
            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            e.printStackTrace();
        }
        return returnObject;
    }
}