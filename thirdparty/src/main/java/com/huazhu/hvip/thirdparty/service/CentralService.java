/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: CentralService.java
 * Author:   admin
 * Date:     2016-03-18 17:37:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-18 17:37:51><version><desc>
 */

package com.huazhu.hvip.thirdparty.service;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.thirdparty.entity.BroadcastMessageVO;
import com.huazhu.hvip.thirdparty.handler.HttpClientHandler;
import com.huazhu.hvip.thirdparty.utils.DesUtil;
import com.huazhu.hvip.util.DateUtil;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.MD5Util;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 中枢
 *
 * @author HUQIANBO
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service
public class CentralService {

    private static Logger logger = LogManager.getLogger(CentralService.class);


    private final String PARAM_CENTRAL_TOKEN = "token";

    // ------------------------setting-------------------------------//
    @Value("${central.caller_id}")
    private String CALLERID;
    @Value("${central.caller_privatekey}")
    private String CALLERPRIVATEKEY;
    @Value("${central.password_crypt_key}")
    private String PASSWORD_CRYPT_KEY;
    @Value("${central.apinameurl}")
    private String APINAMEURL;
    @Value("${central.apinameurl.hms}")
    private String APINAMEURL_HMS;
    @Value("${central.appid}")
    private String APPID;
    @Value("${central.apinameurl.readonly}")
    private String CENTRAL_APINAMEURL_READONLY;
    // ------------------------ /setting-------------------------------//


    // ---------------------------method ------------------------------------ //
    private final String ADDORDERREMARK = "api/Reservation/AddOrderRemark";
    private final String GETHOTELTAXRATES = "api/Hotel/GetHotelTaxRates";  //获取税率
    private final String ADDBROADCASTMESSAGE = "api/Broadcast/AddBroadcastMessage";  //添加消息
    private final String QUERYMEMBERINFO = "api/Member/QueryMemberInfo"; // 查询用户详情
    private final String GETMEMBERIDBYTHIRDPARTY = "api/Member/GetMemberIdByThirdParty";//查询第三方用户登录信息
    private final String GETORDERLIST = "api/Order/GetOrderList"; // 查询用户订单列表
    private final String GETORDERDETAIL = "api/Order/GetOrderDetail"; // 查询用户订单详情
    private final String LOGINWITHOUTPASSWORD = "api/Auth/LoginWithoutPassword"; // 通过memberId查询用户信息

    // --------------------------- /method ------------------------------------ //

    // ------------------------return code-------------------------------//
    private final Integer CENTRAL_RETURN_TYPE = 0;
    private final String CENTRAL_RETURN_STAUSCODE = "200";
    // ------------------------ /return code------------------------------//


    /**
     * 通过用户token获取用户订单信息
     *
     * @param token
     * @return
     */
    public ReturnObject<String> getOrderList(String token) {
        logger.info("call getOrderList({})", token);
        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            Date nt = new Date();
            // post 参数 传递
            List<BasicNameValuePair> basicNameValuePairList = new ArrayList<BasicNameValuePair>();
            basicNameValuePairList.add(new BasicNameValuePair("IsHistory", "False"));
            basicNameValuePairList.add(new BasicNameValuePair("PageIndex", "0"));
            basicNameValuePairList.add(new BasicNameValuePair("PageSize", "100"));
            basicNameValuePairList.add(new BasicNameValuePair("QuerySourceType", "HuaZhu"));

            String apiUrl = APINAMEURL + GETORDERLIST;
            Map<String, String> headMap = new HashMap<>();
            headMap.put(PARAM_CENTRAL_TOKEN, getAccessToken(apiUrl, token, nt));

            logger.info("===================>{}" + "{" + JsonUtil.JSON_List2String(basicNameValuePairList) + "}");
            //
            JSONObject result = HttpClientHandler.postDataByHeader(apiUrl, basicNameValuePairList, true, headMap);
            if (CENTRAL_RETURN_TYPE.equals(result.get("ResultType"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setData2(result.get("Data"));
            } else {
                logger.error((String) result.get("Message"));
                ret.setReturnMsg((String) result.get("Message"));
            }
        } catch (Exception e) {
            logger.error("call getOrderList error", e);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    /**
     * 通过用户token获取用户订单信息
     *
     * @param token
     * @return
     */
    public ReturnObject<String> getOrderDetail(String token, String resNo) {
        logger.info("call getOrderDetail({}{})", token, resNo);
        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            Date nt = new Date();
            // post 参数 传递
            List<BasicNameValuePair> basicNameValuePairList = new ArrayList<BasicNameValuePair>();
            basicNameValuePairList.add(new BasicNameValuePair("IsHistory", "False"));
            basicNameValuePairList.add(new BasicNameValuePair("ResNo", resNo));
            basicNameValuePairList.add(new BasicNameValuePair("QuerySourceType", "HuaZhu"));

            String apiUrl = APINAMEURL + GETORDERDETAIL;
            Map<String, String> headMap = new HashMap<>();
            headMap.put(PARAM_CENTRAL_TOKEN, getAccessToken(apiUrl, token, nt));

            logger.info("===================>{}" + "{" + JsonUtil.JSON_List2String(basicNameValuePairList) + "}");
            //
            JSONObject result = HttpClientHandler.postDataByHeader(apiUrl, basicNameValuePairList, true, headMap);
            if (CENTRAL_RETURN_TYPE.equals(result.get("ResultType"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setData2(result.get("Data"));
            } else {
                logger.error((String) result.get("Message"));
                ret.setReturnMsg((String) result.get("Message"));
            }
        } catch (Exception e) {
            logger.error("call getOrderDetail error", e);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    //通过第三方登录获取用户信息
    public ReturnObject<String> getMemberIdByThirdParty(String thirdPartyId, String thirdPartySource) {
        logger.info("call getMemberIdByThirdParty({})({})", thirdPartyId, thirdPartySource);
        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            Date nt = new Date();

            // post 参数 传递
            List<BasicNameValuePair> basicNameValuePairList = new ArrayList<BasicNameValuePair>();
            basicNameValuePairList.add(new BasicNameValuePair("pThirdPartyId", thirdPartyId));
            basicNameValuePairList.add(new BasicNameValuePair("pThirdPartySource", thirdPartySource));

            String apiUrl = APINAMEURL + GETMEMBERIDBYTHIRDPARTY;
            Map<String, String> headMap = new HashMap<>();
            headMap.put(PARAM_CENTRAL_TOKEN, getAccessToken(apiUrl, "", nt));
            logger.info("===================>" + "{" + JsonUtil.JSON_List2String(basicNameValuePairList) + "}");
            //
            JSONObject result = HttpClientHandler.postDataByHeader(apiUrl, basicNameValuePairList, true, headMap);
            if (CENTRAL_RETURN_TYPE.equals(result.get("ResultType"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setData((String) result.get("Data"));
            } else {
                logger.error((String) result.get("Message"));
                ret.setReturnMsg((String) result.get("Message"));
            }
        } catch (Exception e) {
            logger.error("call getMemberIdByThirdParty error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 获取用户信息
     *
     * @param crmId
     * @return
     */
    public ReturnObject<String> getMemberInfo(String crmId) {
        ReturnObject<String> returnObject = loginWithoutPwd(crmId);
        String token = returnObject.getData();
        //Helper.getRequest().getSession().setAttribute(Const.SESSION_USERTOKEN, token);
        return getMemberInfoByToken(token);
    }

    /**
     * 通过memberId获取用户token
     *
     * @param crmId
     * @return
     */
    public ReturnObject<String> loginWithoutPwd(String crmId) {
        logger.info("call loginWithoutPwd({})", crmId);
        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            Date nt = new Date();
            // post 参数 传递
            List<BasicNameValuePair> basicNameValuePairList = new ArrayList<BasicNameValuePair>();
            basicNameValuePairList.add(new BasicNameValuePair("memberId", crmId));
            basicNameValuePairList.add(new BasicNameValuePair("companyMemberLoginType", "0"));

            String apiUrl = APINAMEURL + LOGINWITHOUTPASSWORD;
            Map<String, String> headMap = new HashMap<>();
            headMap.put(PARAM_CENTRAL_TOKEN, getAccessToken(apiUrl, "", nt));
            logger.info("===================>" + "{" + JsonUtil.JSON_List2String(basicNameValuePairList) + "}");
            //
            JSONObject result = HttpClientHandler.postDataByHeader(apiUrl, basicNameValuePairList, true, headMap);
            if (CENTRAL_RETURN_TYPE.equals(result.get("ResultType"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                JSONObject jsonObject = (JSONObject) result.get("Data");
                ret.setData(jsonObject.getString("Token"));
            } else {
                logger.error((String) result.get("Message"));
                ret.setReturnMsg((String) result.get("Message"));
            }
        } catch (Exception e) {
            logger.error("call loginWithoutPwd({})", e);
        }
        return ret;
    }

    /**
     * 通过用户token 获取用户详情
     *
     * @param token
     * @return
     */
    public ReturnObject<String> getMemberInfoByToken(String token) {
        logger.info("call getMemberInfoByToken({})", token);
        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            Date nt = new Date();

            // post 参数 传递
            List<BasicNameValuePair> basicNameValuePairList = new ArrayList<BasicNameValuePair>();

            String apiUrl = APINAMEURL + QUERYMEMBERINFO;
            Map<String, String> headMap = new HashMap<>();
            headMap.put(PARAM_CENTRAL_TOKEN, getAccessToken(apiUrl, token, nt));

            //
            JSONObject result = HttpClientHandler.postDataByHeader(apiUrl, basicNameValuePairList, true, headMap);
            if (CENTRAL_RETURN_TYPE.equals(result.get("ResultType"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setData2(result.get("Data"));
            } else {
                logger.error("call getMemberInfoByToken error({})", (String) result.get("Message"));
                ret.setReturnMsg((String) result.get("Message"));
            }

        } catch (Exception e) {
            logger.error("call getMemberInfoByToken error", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    public ReturnObject<String> doTest(String token) {
        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {

            String mobile = "18918547231";
            String password = "369258wb";

            Date dd = new Date();

            List<BasicNameValuePair> basicNameValuePairList = new ArrayList<BasicNameValuePair>();
            basicNameValuePairList.add(new BasicNameValuePair("account", mobile));
            basicNameValuePairList.add(new BasicNameValuePair("password", password));


            String apiUrl = APINAMEURL + "api/Auth/Login";// + QUERYMEMBERINFO;
            Map<String, String> headMap = new HashMap<>();
            headMap.put(PARAM_CENTRAL_TOKEN, getAccessToken(apiUrl, "", dd));

            logger.info("===================>{}" + "{" + JsonUtil.JSON_List2String(basicNameValuePairList) + "}");
            //
            JSONObject result = HttpClientHandler.postDataByHeader(apiUrl, basicNameValuePairList, true, headMap);
            if (CENTRAL_RETURN_TYPE.equals((Integer) result.get("ResultType"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setData2((JSONObject) result.get("Data"));
            } else {
                logger.error((String) result.get("Message"));
                ret.setReturnMsg((String) result.get("Message"));
            }


            JSONObject jsonObject = (JSONObject) ret.getData2();
            token = (String) jsonObject.get("Token");
            logger.info("===================>{}" + "{" + token + "}");
            ret.setData(token);

        } catch (Exception e) {
            logger.error(e);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    /**
     * 生成accessToken
     *
     * @param token  用户token
     * @param apiUrl api地址
     * @return
     */
    private String getAccessToken(String apiUrl, String token, Date dd) {
        //请求时间
        String requestTime = DateUtil.convertDateToString(dd, "yyyy-MM-dd HH:mm:ss");

        //生成签名
        String inputString = CALLERID + CALLERPRIVATEKEY + apiUrl + requestTime;
        if (StringUtils.isNotBlank(token)) {
            inputString += token;
        }

        String md5Sign = MD5Util.encode(inputString).toUpperCase();

        //生成token
        String accessToken = md5Sign + "," + CALLERID + "," + requestTime;
        if (StringUtils.isNotBlank(token)) {
            accessToken += "," + token;
        }
        logger.info("(accessToken:{})", accessToken);
        return accessToken;
    }

    /**
     * 修改预订单门店备注
     *
     * @param hotelNo      酒店编号
     * @param hotelOrderNo 预订单号
     * @param operatorName 操作人姓名
     * @param remark       备注
     * @return
     */
    public ReturnObject<String> addOrderRemark(String hotelNo, String hotelOrderNo, String operatorName, String remark) {
        logger.info("call addOrderRemark({}，{}，{}，{})", hotelNo, hotelOrderNo, operatorName, remark);

        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            JSONObject params = new JSONObject();
            params.put("HotelID", hotelNo);
            params.put("OrderID", hotelOrderNo);
            params.put("OperatorID", operatorName);
            params.put("Remak", remark);

            JSONObject paramsHeader = new JSONObject();
            paramsHeader.put("AppID", APPID);
            paramsHeader.put("Token", "");
            params.put("Header", paramsHeader);

            String apiUrl = APINAMEURL_HMS + ADDORDERREMARK;

            logger.info("addOrderRemark.request===================>{}" + "{" + params.toString() + "}");
            String result = HttpClientHandler.postBody(apiUrl, params.toString());

            logger.info("addOrderRemark.response ====================================({})", result);

            JSONObject jsonObject = JSONObject.fromObject(result);
            if (CENTRAL_RETURN_STAUSCODE.equals(jsonObject.getString("StatusCode"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                String target = jsonObject.getString("Target");
                ret.setData(target);
            } else {
                String msg = jsonObject.getString("ErrorMessage");
                ret.setReturnMsg(msg);
            }
        } catch (Exception e) {
            logger.error("call addCreditByBillId error", e);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    /**
     * 获取酒店税率
     *
     * @param hotelNo 酒店编号
     * @return
     */
    public ReturnObject<String> getHotelTaxRates(String hotelNo) {
        logger.info("call getHotelTaxRates({})", hotelNo);

        ReturnObject<String> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            String dynamicKey = DateUtil.toString(new Date(), DateUtil.DATE_FORMATE_YYYYMMDD);
            String md5Password = APPID + "-" + dynamicKey;
            String token = DesUtil.encrypt(md5Password, PASSWORD_CRYPT_KEY);

            JSONObject params = new JSONObject();
            params.put("HotelID", hotelNo);
            params.put("Token", token);
            params.put("DynamicKey", dynamicKey);
            params.put("AppID", APPID);

            String apiUrl = APINAMEURL_HMS + GETHOTELTAXRATES;
            //String apiUrl = "http://10.1.37.50:8083" + GETHOTELTAXRATES;

            logger.info("getHotelTaxRates.request===================>{}" + "{" + params.toString() + "}");
            String result = HttpClientHandler.postBody(apiUrl, params.toString());

            logger.info("getHotelTaxRates.response ====================================({})", result);

            JSONObject jsonObject = JSONObject.fromObject(result);
            if (CENTRAL_RETURN_STAUSCODE.equals(jsonObject.getString("StatusCode"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                String target = jsonObject.getString("Target");
                ret.setData(target);
            } else {
                String msg = jsonObject.getString("ErrorMessage");
                ret.setReturnMsg(msg);
            }
        } catch (Exception e) {
            logger.error("call getHotelTaxRates error", e);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    /**
     * 添加消息广播
     *
     * @param broadcastMessageVO
     * @return
     */
    public ReturnObject<Boolean> addBroadcastMessage(BroadcastMessageVO broadcastMessageVO){
        logger.info("call addBroadcastMessage({})", JsonUtil.JSON_Bean2String(broadcastMessageVO));

        ReturnObject<Boolean> ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            String dynamicKey = DateUtil.toString(new Date(), DateUtil.DATE_FORMATE_YYYYMMDD);
            String md5Password = APPID + "-" + dynamicKey;
            String token = DesUtil.encrypt(md5Password, PASSWORD_CRYPT_KEY);
            JSONObject params = new JSONObject();
            params.put("HotelID", broadcastMessageVO.getHotelId());
            params.put("EventCode", broadcastMessageVO.getEventCode());
            params.put("PublishId", broadcastMessageVO.getPublishId());
            params.put("Title", broadcastMessageVO.getTitle());
            params.put("DisplayText", broadcastMessageVO.getDisplayText());
            params.put("KeyWord", broadcastMessageVO.getKeyWord());
            params.put("Format", broadcastMessageVO.getFormat());
            params.put("Content", broadcastMessageVO.getContent());
            params.put("Url", broadcastMessageVO.getUrl());
            params.put("Source", broadcastMessageVO.getSource());
            params.put("OperatorID", broadcastMessageVO.getOperatorId());
            params.put("ExpiredDate", broadcastMessageVO.getExpiredDate());
            params.put("Memo", broadcastMessageVO.getMemo());
            params.put("Token", token);
            params.put("DynamicKey", dynamicKey);
            params.put("AppID",APPID);

            String apiUrl = APINAMEURL_HMS + ADDBROADCASTMESSAGE;
            //String apiUrl = "http://10.1.37.50:8083" + GETHOTELTAXRATES;

            logger.info("getHotelTaxRates.request===================>{}" + "{" + params.toString() + "}");
            String result = HttpClientHandler.postBody(apiUrl, params.toString());
            logger.info("getHotelTaxRates.response ====================================({})", result);

            JSONObject jsonObject = JSONObject.fromObject(result);
            if (CENTRAL_RETURN_STAUSCODE.equals(jsonObject.getString("StatusCode"))) {
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                Boolean target = jsonObject.getBoolean("Target");
                ret.setData(target);
            } else {
                String msg = jsonObject.getString("ErrorMessage");
                ret.setReturnMsg(msg);
            }
        } catch (Exception e) {
            logger.error("call getHotelTaxRates error", e);
            ret.setReturnMsg(e.getMessage());
        }
        return ret;
    }

    /**
     * 获取酒店税率
     *
     * @param resNo 酒店编号
     * @return
     */
    public ReturnObject querySingleRecord(String resNo) {
        logger.info("call addBroadcastMessage({})",(resNo));
        ReturnObject ret = new ReturnObject<>();
        ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        try {
            com.huazhu.hvip.thirdparty.entity.axis.reservation.QueryLocator queryLoc = new com.huazhu.hvip.thirdparty.entity.axis.reservation.QueryLocator();
            queryLoc.setquerySoapAddress(CENTRAL_APINAMEURL_READONLY);
            com.huazhu.hvip.thirdparty.entity.axis.reservation.QuerySoap_PortType service = queryLoc.getquerySoap();
            com.huazhu.hvip.thirdparty.entity.axis.reservation.EntityResMain entityResMain = service.querySingleRecord(resNo);
            if (entityResMain != null) {
                System.out.println(entityResMain.getSBillID());
                System.out.println(entityResMain.getDBizDay());
            }
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setData(entityResMain);
        } catch (Exception e) {
            logger.error("call getHotelTaxRates error", e);
            ret.setReturnMsg(e.getMessage());
        }
        return  ret;
    }
}
