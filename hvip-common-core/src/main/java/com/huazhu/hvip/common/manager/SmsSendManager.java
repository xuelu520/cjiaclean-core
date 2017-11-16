/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SmsSendManager.java
 * Author:   admin
 * Date:     2016-03-20 16:51:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:51:08><version><desc>
 */

package com.huazhu.hvip.common.manager;


import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.common.model.SmsSend;

import java.util.Map;

public interface SmsSendManager extends GenericManager<SmsSend, Long> {


    /**
     * 短信发送
     *
     * @param smsType
     *            短信类型
     * @param mobile
     *            发送短信号码
     * @param paramMap
     * @return
     */
    public ReturnObject smsSend(String smsType, String mobile, Map paramMap);

    /**
     * 获取短信余额
     *
     * @return
     */
    public String getEmayBalance();

    /**
     * 充值
     *
     * @param cartSerialNo
     *            充值卡序列号
     * @param cardPassword
     *            充值卡序密码
     * @return
     */
    public String chargeUp(String cartSerialNo, String cardPassword);

    /**
     * 用于验证同一手机同一功能sec秒内发送次数限制
     *
     * @param sms
     * @param sec
     * @return
     */
    public Integer countSmsByCondition(SmsSend sms, int sec);
}