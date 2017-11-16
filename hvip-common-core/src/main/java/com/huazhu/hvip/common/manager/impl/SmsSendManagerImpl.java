/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SmsSendManagerImpl.java
 * Author:   admin
 * Date:     2016-03-20 16:51:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:51:42><version><desc>
 */

package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.exception.BizException;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.dao.SmsSendDao;
import com.huazhu.hvip.common.manager.SmsSendManager;
import com.huazhu.hvip.common.manager.SmsTemplateManager;
import com.huazhu.hvip.common.model.SmsSend;
import com.huazhu.hvip.common.model.SmsTemplate;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.axis.client.Call;
import org.apache.axis.encoding.XMLType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

@Service("smsSendManager")
public class SmsSendManagerImpl extends GenericManagerImpl<SmsSend, Long> implements SmsSendManager {

    private static Logger logger = LogManager.getLogger(SmsSendManagerImpl.class);

    private SmsSendDao smsSendDao;

    @Autowired
    public SmsSendManagerImpl(SmsSendDao smsSendDao) {
        super(smsSendDao);
        this.smsSendDao = smsSendDao;
    }

    @Autowired
    private SmsTemplateManager smsTemplateManager;

    /**
     * {@inheritDoc}
     */

    public ReturnObject smsSend(String smsType, String mobile, Map paramMap){
        logger.info("call SmsSendManagerImpl.smsSend({\"smsType\":" + smsType + "},{\"mobile\":" + mobile + "},{\"paramMap\":" + JsonUtil.JSON_Bean2String(paramMap) + "})");

        ReturnObject ret = new ReturnObject();

        // 根据短信类型查找短信模板
        String result = null;
        String smsContent = null;

        SmsTemplate smsTemplate = null;
        try {
            QueryModel queryModel = new QueryModel();
            queryModel.addColumnValueCondition("smsType", smsType);

            smsTemplate = smsTemplateManager.getUniqueResult(queryModel);
        } catch (Exception e) {
            logger.error("短信发送发生错误，查询短信模板失败", e);

            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("短信发送发生错误，查询短信模板失败");
        }

        try {
            String smsWsUrl = projectProperties.getProperty(Constants.SMS_WS_URL);
            String smsBizCode = projectProperties.getProperty(Constants.SMS_WS_BIZCODE);
            String clientSystem = projectProperties.getProperty(Constants.SMS_WS_CLIENTSYSTEM);
            String hotelId = projectProperties.getProperty(Constants.SMS_WS_HOTELID);


            smsContent = evalContent(smsTemplate.getTemplateContent(), paramMap);

            String endpoint = smsWsUrl;
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setUseSOAPAction(true);
            call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); // 返回参数的类型
            call.setSOAPActionURI("http://tempuri.org/SendSms"); // 这个也要注意 就是要加上要调用的方法Add,不然也会报错
            // WSDL里面描述的接口名称
            call.setOperationName(new QName("http://tempuri.org/", "SendSms"));
            // 参数1 Mobile
            call.addParameter(new QName("http://tempuri.org/", "Mobile"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
            // 参数2 Content
            call.addParameter(new QName("http://tempuri.org/", "Content"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
            // 参数3 BusinessCode
            call.addParameter(new QName("http://tempuri.org/", "BusinessCode"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
            // 参数4 Account
            call.addParameter(new QName("http://tempuri.org/", "ClientSystem"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
            // 参数5 PassWord
            call.addParameter(new QName("http://tempuri.org/", "HotelID"), org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);

            // 设置返回类型
            call.setReturnType(XMLType.XSD_STRING);

            // 给方法传递参数，并且调用方法
            String[] paramArray = new String[5];

            paramArray[0] = mobile;

            paramArray[1] = smsContent;

            paramArray[2] = smsBizCode;

            paramArray[3] = clientSystem;

            paramArray[4] = hotelId;

            result = (String) call.invoke(paramArray);
        } catch (Exception e) {
            logger.error("短信发送发生错误", e);

            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("短信发送发生错误，查询短信模板失败");
        }



        try {
            // 记录发送记录
            SmsSend smsSend = new SmsSend();

            smsSend.setMobileNumber(mobile);
            smsSend.setSmsContent(smsContent);
            smsSend.setSmsType(smsType);
            smsSend.setSendTime(new Date());
            smsSend.setResultCode(result);
            // smsSend.setResultMsg(resultMsg);
            smsSendDao.save(smsSend);
        } catch (Exception e) {
            logger.error("短信发送成功，保存发送记录失败",e);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("短信发送成功，保存发送记录失败");
        }

        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("短信发送成功");

        return ret;

    }

    /**
     * 替换为发送内容
     *
     * @param templateContent
     * @param paramMap
     * @return
     */
    private String evalContent(String templateContent, Map paramMap) {
        String smsContent = null;
        try {

            VelocityEngine ve = new VelocityEngine();
            ve.init();

            VelocityContext context = new VelocityContext(paramMap);

            StringWriter writer = new StringWriter();

            ve.evaluate(context, writer, "", templateContent);
            smsContent = writer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("smstemplate.eval.error", "短信模板替换错误.");

        }

        return smsContent;
    }

    /**
     * {@inheritDoc}
     */
    public String getEmayBalance() {

        try {

            String balance = null;// getClient().getBalance();

            return balance;

        } catch (Exception e) {

            e.printStackTrace();
            throw new BizException("smsSend.error", "获取emay短信账号余额发生错误.");
        }
    }

    /**
     * {@inheritDoc}
     */
    public String chargeUp(String cartSerialNo, String cardPassword) {

        String resultMsg = null;
        try {

            int result = 0;// getClient().chargeUp(cartSerialNo, cardPassword);

            if (result == 0) {
                resultMsg = "充值成功";
            } else if (result == 13) {
                resultMsg = "充值失败";
            } else if (result == 303) {
                resultMsg = "客户端网络超时或者网络故障";
            } else if (result == 305) {
                resultMsg = "服务器端返回错误，错误的返回值（返回值不是数字字符串";
            } else if (result == 999) {
                resultMsg = "操作频繁";
            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new BizException("smsChargeUp.error", "短信账号充值发生错误.");
        }
        return resultMsg;
    }

    public Integer countSmsByCondition(SmsSend sms, int sec) {
        sms.setSec(sec);
        return 0;// smsSendDao.countSmsByCondition(sms);
    }

}