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
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.common.manager.NotifyRecordManager;
import com.huazhu.hvip.common.model.NotifyRecord;
import com.huazhu.hvip.common.model.SysParam;
import com.huazhu.hvip.common.service.NotifyRecordService;
import com.huazhu.hvip.common.vo.NotifyRecordVO;
import com.huazhu.hvip.common.vo.ThirdPartyCityVO;
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

@Service("notifyRecordService")
public class NotifyRecordServiceImpl implements NotifyRecordService {

    private static Logger logger = LogManager.getLogger(NotifyRecordServiceImpl.class);

    @Autowired
    private NotifyRecordManager notifyRecordManager;


    /**
     * 保存通知记录
     *
     * @param notifyRecordVO
     * @return
     */
    @Override
    public ReturnObject<NotifyRecordVO> saveOrUpdateNotifyRecord(NotifyRecordVO notifyRecordVO) {
        logger.info("call addNotifyRecord({})", JsonUtil.JSON_Bean2String(notifyRecordVO));

        ReturnObject<NotifyRecordVO> ret = new ReturnObject<>();

        try {
            NotifyRecord notifyRecord = new NotifyRecord();
            BeanUtils.copyProperties(notifyRecordVO,notifyRecord);
            notifyRecord = notifyRecordManager.save(notifyRecord);

            notifyRecordVO.setRecordId(notifyRecord.getRecordId());

            ret.setData(notifyRecordVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("保存成功");

        } catch (Exception e) {
            logger.error("保存失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("保存失败");
        }

        return ret;
    }
}