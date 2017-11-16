/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeService.java
 * Author:   admin
 * Date:     2016-03-20 17:28:32
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 17:28:32><version><desc>
 */

package com.huazhu.hvip.common.service.impl;


import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.FinanceSubjectManager;
import com.huazhu.hvip.common.manager.SysParamManager;
import com.huazhu.hvip.common.model.FinanceSubject;
import com.huazhu.hvip.common.model.SysParam;
import com.huazhu.hvip.common.service.FinanceSubjectService;
import com.huazhu.hvip.common.service.SysParamService;
import com.huazhu.hvip.common.vo.*;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("financeSubjectService")
public class FinanceSubjectServiceImpl implements FinanceSubjectService {

    private static Logger logger = LogManager.getLogger(SmsSendServiceImpl.class);

    @Autowired
    private FinanceSubjectManager financeSubjectManager;

    /**
     * 获取财务科目列表
     *
     * @return
     */
    @Override
    public ReturnObject<FinanceSubjectVO> searchFinanceSubjectList() {
        logger.info("call searchFinanceSubjectList()");

        ReturnObject<FinanceSubjectVO> ret = new ReturnObject<>();

        try {
            List<FinanceSubjectVO> subjectList = new ArrayList<>();
            FinanceSubjectVO financeSubjectVO = null;

            List<FinanceSubject> list =  financeSubjectManager.getAll();

            if (list.size() < 1) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到财务科目列表");
                return ret;
            }

            for (FinanceSubject sub : list){
                financeSubjectVO = new FinanceSubjectVO();
                BeanUtils.copyProperties(sub,financeSubjectVO);
                subjectList.add(financeSubjectVO);
            }

            ret.setDataList(subjectList);

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
     * 获取财务科目详情
     *
     * @param subjectId
     * @return
     */
    @Override
    public ReturnObject<FinanceSubjectVO> getFinanceSubjectById(Long subjectId) {
        logger.info("call getFinanceSubjectById()");

        ReturnObject<FinanceSubjectVO> ret = new ReturnObject<>();

        try {

            FinanceSubject financeSubject =  financeSubjectManager.get(subjectId);

            if (financeSubject == null) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("未查询到财务科目信息");
                return ret;
            }

            FinanceSubjectVO financeSubjectVO = new FinanceSubjectVO();
            BeanUtils.copyProperties(financeSubject,financeSubjectVO);

            ret.setData(financeSubjectVO);

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
