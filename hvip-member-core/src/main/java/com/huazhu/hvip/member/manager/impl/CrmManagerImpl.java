package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.manager.CrmManager;
import com.huazhu.hvip.util.CommonUtil;
import com.huazhu.hvip.util.JsonUtil;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("crmManager")
@SuppressWarnings({"rawtypes","unchecked"})
public class CrmManagerImpl extends GenericManagerImpl<String, Long> implements CrmManager {
	@Override
	public Boolean validateMobile(String mobile) {

		try {
			String url = projectProperties.getProperty(Constants.CRM_URL_VALIDATEMOBILE);
			String accessToken = auth();
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url + "?mobile=" + mobile);
			httpGet.addHeader("Authorization", "Bearer " + accessToken);

			HttpResponse response =  httpclient.execute(httpGet);
		    String responseBody = EntityUtils.toString(response.getEntity());
		    HashMap map = (HashMap) JsonUtil.JSON_String2Bean(responseBody, HashMap.class);
		    if("1".equals((String)map.get("ResponseCode"))){
		    	return true; // 检测手机号码已经存在
		    }
		}catch(Exception e){
			e.printStackTrace();
		}

		return false; // 检测手机号码不存在
	}


	@Override
	public String auth() {
		// 调用CRM系统的会员接口之前都要进行一次授权的动作
		try {
            String authUrl = projectProperties.getProperty(Constants.CRM_URL_AUTH);
        	String clientId = projectProperties.getProperty(Constants.CRM_URL_CLIENTID);
        	String clientSecret	= projectProperties.getProperty(Constants.CRM_URL_CLIENTSECRET);

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("grant_type","client_credentials"));
			params.add(new BasicNameValuePair("scope", "/OAuth/Token"));
			params.add(new BasicNameValuePair("client_id", clientId));
			params.add(new BasicNameValuePair("client_secret", clientSecret));

			// 访问tocken
			HttpPost httpPost = new HttpPost(authUrl);
			UrlEncodedFormEntity urlEncoded = new UrlEncodedFormEntity(params, "UTF-8");
			httpPost.setEntity(urlEncoded);
			ResponseHandler responseHandler = new BasicResponseHandler();
		    HttpClient httpclient = new DefaultHttpClient();
			String responseBody = (String) httpclient.execute(httpPost, responseHandler);

			Map map = (Map) JsonUtil.JSON_String2Bean(responseBody, HashMap.class);
			String accessToken = (String) map.get("access_token");

			return accessToken;
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}


	// 公共的调用CRM验证的接口方法,不可用于验证手机号
	private JSONObject commonHttpCrm(Map paramMap, String url){

		try{
			String accessToken = auth(); // 链接CRM系统的授权信息
			HttpPost httpPost = new HttpPost(url);
	        httpPost.addHeader("Authorization", "Bearer "+accessToken);
	        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");

	        String json = JsonUtil.JSON_Bean2String(paramMap);
	        StringEntity se = new StringEntity(json);
	        httpPost.setEntity(se);
	        se.setContentType("application/json");
	        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

	        ResponseHandler responseHandler = new BasicResponseHandler();
	        HttpClient httpclient = new DefaultHttpClient();
	        String responseBody = (String)httpclient.execute(httpPost, responseHandler);

	        if(CommonUtil.isNullOREmpty(responseBody)) responseBody = "{}";
	        JSONObject jsonObject = JSONObject.fromObject(responseBody);

	        return jsonObject;
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public ReturnObject<String> regist(String mobile, String password, String name,
			String mail, String idno) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("Mobile",mobile);	// 手机号
		paramMap.put("Password", password);  // 密码
		paramMap.put("Name",name);	// 姓名
		paramMap.put("Mail",mail);	// 邮箱
		paramMap.put("IDNo",idno);	// 证件号

		String url  = projectProperties.getProperty(Constants.CRM_URL_REGISTER);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
			ret.setData(responseMap.getString("ResponseMessage"));
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("注册会员信息失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String>  login(String mobile, String password) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("UserNo",mobile);//手机号
		paramMap.put("Password", password);  //密码

		String url  = projectProperties.getProperty(Constants.CRM_URL_LOGIN);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);

			String content = responseMap.getString("Content");
			ret.setDataMap((Map)JsonUtil.JSON_String2Bean(content, HashMap.class));
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("注册会员信息失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String> changePassword(String crmId, String oldPassword, String newPassword) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("NewPassword",newPassword);	//新密码
		paramMap.put("OldPassword", oldPassword);	//老密码
		paramMap.put("MemberId",crmId);	//会员的ID

		String url  = projectProperties.getProperty(Constants.CRM_URL_CHANGEPASSWORD);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("修改会员密码失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String> resetPassword(String crmId, String mobile) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("Mobile", mobile);	//接收短信的手机号码
		paramMap.put("MemberId",crmId);	//会员的ID

		String url  = projectProperties.getProperty(Constants.CRM_URL_RESETPASSWORD);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("重置会员密码失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String> memberInfoUpdate(String crmId, String idNo, String name) {
		ReturnObject<String> ret = new ReturnObject<String>();

        Map paramMap = new HashMap();
		paramMap.put("Name", name);	//用户名称
		paramMap.put("IDNo", idNo);	//身份证号码
		paramMap.put("MemberId",crmId);	//会员的ID

		String url  = projectProperties.getProperty(Constants.CRM_URL_MEMBERINFOUPDATE);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("更新会员信息失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String> memberInfoUpdate(String crmId, String idNo,
			String idType, String gender, String email) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map paramMap = new HashMap();
		paramMap.put("MemberId",crmId);		//会员的ID
		paramMap.put("IDNo", idNo);			//证件号码
		paramMap.put("IDType", idType);		//证件号码类型
		paramMap.put("Gender", gender);		//性别
		paramMap.put("Email", email);		//邮箱

		String url  = projectProperties.getProperty(Constants.CRM_URL_MEMBERINFOUPDATE);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("更新会员信息失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String> getMemberInfo(String crmId) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map paramMap = new HashMap();
		paramMap.put("MemberId",crmId);		//会员的ID

		String url  = projectProperties.getProperty(Constants.CRM_URL_GETMEMBERINFO);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);

			String content = responseMap.getString("Content");
			ret.setDataMap((Map)JsonUtil.JSON_String2Bean(content, HashMap.class));
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("更新会员信息失败!");
		}

		return ret;
	}


	@Override
	public ReturnObject<String> changeMobile(String crmId, String mobile) {
		ReturnObject<String> ret = new ReturnObject<String>();

		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("NewMobile",mobile);	//手机号
		/*paramMap.put("Password", password);*/	//密码
		paramMap.put("MemberId",crmId);	//会员的ID

		String url  = projectProperties.getProperty(Constants.CRM_URL_CHANGEMOBILE);
		JSONObject responseMap = commonHttpCrm(paramMap, url);

		if(null!=responseMap && !responseMap.isEmpty() && "1".equals(responseMap.getString("ResponseCode"))){
			ret.setReturnMsg(responseMap.getString("ResponseMessage"));
			ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		}else{
			ret.setReturnCode(Constants.RETURN_CODE_FAIL);
	        ret.setReturnMsg("手机号码变更失败!");
		}

		return ret;
	}


}