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
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.SmsSendManager;
import com.huazhu.hvip.common.service.SmsSendService;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("smsSendService")
public class SmsSendServiceImpl implements SmsSendService {

    private static Logger logger = LogManager.getLogger(SmsSendServiceImpl.class);

    private SmsSendManager smsSendManager;
    @Autowired
    public void setSmsSendManager(SmsSendManager smsSendManager) {
        this.smsSendManager = smsSendManager;
    }

    /**
     * 短信发送
     *
     * @param smsType  短信类型
     * @param mobile   发送短信号码
     * @param paramMap
     * @return
     */
    @Override
    public ReturnObject smsSend(String smsType, String mobile, Map paramMap) {
        logger.info("call smsSend({\"smsType\":" + smsType + "},{\"mobile\":" + mobile + "},{\"paramMap\":" + JsonUtil.JSON_Bean2String(paramMap) + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ret = smsSendManager.smsSend(smsType,mobile,paramMap);

            logger.info(JsonUtil.JSON_Bean2String(ret));
        } catch (Exception e) {
            logger.error("发送短信失败",e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("发送短信失败");
        }

        return ret;
    }
}
