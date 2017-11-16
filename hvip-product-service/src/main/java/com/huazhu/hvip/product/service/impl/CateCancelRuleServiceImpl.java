/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateCancelRuleServiceImpl.java
 * Author:   lijing
 * Date:     2016-04-20 09:56:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-20 09:56:14> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.goods.manager.CateCancelRuleManager;
import com.huazhu.hvip.product.goods.model.CateCancelRule;
import com.huazhu.hvip.product.service.CateCancelRuleService;
import com.huazhu.hvip.product.vo.CateCancelRuleVO;
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
@Service
public class CateCancelRuleServiceImpl implements CateCancelRuleService{

    private static Logger logger = LogManager.getLogger(CateOrderRuleServiceImpl.class);

    @Autowired
    private CateCancelRuleManager cateCancelRuleManager;

    /**
     * 查询订单取消规则
     * @param cateId
     * @return
     */
    @Override
    public ReturnObject<CateCancelRuleVO> searchCateCancelRuleByCateId(Long cateId) {
        logger.info("call searchCateCancelRuleByCateId({\"cateId:\"" + cateId + "})");

        ReturnObject<CateCancelRuleVO> ret =  new ReturnObject<CateCancelRuleVO>();
        try {
            ParamObject para = new ParamObject();
            para.add("cateId",cateId);
            List<CateCancelRule> list = cateCancelRuleManager.searchCateCancelRule(para);
            List<CateCancelRuleVO> voList = null;
            if(list!=null&&list.size()>0){
                voList = new ArrayList<CateCancelRuleVO>();
                CateCancelRuleVO ccrVO = null;
                for(CateCancelRule ccr : list){
                    ccrVO = new CateCancelRuleVO();
                    BeanUtils.copyProperties(ccr,ccrVO);
                    voList.add(ccrVO);
                }
            }
            ret.setDataList(voList);
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
     * 保存订单取消规则
     * @param cateCancelRuleVO
     * @return
     */
    @Override
    public ReturnObject<CateCancelRuleVO> saveCateCancelRule(CateCancelRuleVO cateCancelRuleVO) {
        logger.info("call saveCateCancelRule({\"cateCancelRuleVO:\"" + cateCancelRuleVO.toString() + "})");

        ReturnObject<CateCancelRuleVO> ret = new ReturnObject<CateCancelRuleVO>();

        try {
            CateCancelRule ccr = new CateCancelRule();
            BeanUtils.copyProperties(cateCancelRuleVO, ccr);
            ccr = cateCancelRuleManager.saveCateCancelRule(ccr);
            CateCancelRuleVO ccrVO = new CateCancelRuleVO();
            BeanUtils.copyProperties(ccr, ccrVO);
            ret.setData(ccrVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");
        } catch (Exception e) {
            logger.error("保存失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }

        return ret;
    }
}
