/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CateOrderRuleServiceImpl.java
 * Author:   lijing
 * Date:     2016-04-13 14:12:17
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-13 14:12:17> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.goods.manager.CateOrderRuleManager;
import com.huazhu.hvip.product.goods.model.CateOrderRule;
import com.huazhu.hvip.product.service.CateOrderRuleService;
import com.huazhu.hvip.product.vo.CateOrderRuleVO;
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
@Service
public class CateOrderRuleServiceImpl implements CateOrderRuleService{
    private static Logger logger = LogManager.getLogger(CateOrderRuleServiceImpl.class);

    @Autowired
    private CateOrderRuleManager cateOrderRuleManager;

    /**
     * 根据分类ID查询订单支付规则
     * @param cateId
     * @return
     */
    @Override
    public ReturnObject<CateOrderRuleVO> searchCateOrderRuleByCateId(Long cateId) {
        logger.info("call searchCateOrderRuleByCateId({\"cateId:\"" + cateId + "})");

        ReturnObject<CateOrderRuleVO> ret =  new ReturnObject<CateOrderRuleVO>();
        try {
            ParamObject para = new ParamObject();
            para.add("cateId",cateId);
            List<CateOrderRule> list = cateOrderRuleManager.searchCateOrderRule(para);
            List<CateOrderRuleVO> voList = null;
            if(list!=null&&list.size()>0){
                voList = new ArrayList<CateOrderRuleVO>();
                CateOrderRuleVO corVO = null;
                for(CateOrderRule cor : list){
                    corVO = new CateOrderRuleVO();
                    BeanUtils.copyProperties(cor,corVO);
                    voList.add(corVO);
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
     * 保存订单支付规则
     * @param cateOrderRuleVO
     * @return
     */
    @Override
    public ReturnObject<CateOrderRuleVO> saveCateOrderRule(CateOrderRuleVO cateOrderRuleVO) {
        logger.info("call saveCateOrderRule({\"cateOrderRuleVO:\"" + cateOrderRuleVO.toString() + "})");

        ReturnObject<CateOrderRuleVO> ret = new ReturnObject<CateOrderRuleVO>();

        try {
            CateOrderRule cor = new CateOrderRule();
            BeanUtils.copyProperties(cateOrderRuleVO, cor);
            cor = cateOrderRuleManager.saveCateOrderRule(cor);
            CateOrderRuleVO corVO = new CateOrderRuleVO();
            BeanUtils.copyProperties(cor, corVO);
            ret.setData(corVO);
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
