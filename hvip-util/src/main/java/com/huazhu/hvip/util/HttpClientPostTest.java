/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HttpClientPostTest.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpClientPostTest {
	private static final String CHARSET_UTF8 = HTTP.UTF_8;
	public static void main(String args[]) {

		try {

			HttpClient httpclient = new DefaultHttpClient();
            //Secure Protocol implementation.
			SSLContext ctx = SSLContext.getInstance("SSL");
            //Implementation of a trust manager for X509 certificates
			X509TrustManager tm = new X509TrustManager() {

				public void checkClientTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {

				}

				public void checkServerTrusted(X509Certificate[] xcs,
						String string) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx);
		//	gAAAAAgA7BdjISuKvKhPfblyjElc74cW1bUgQYbMb5f_a6zFwhceK-F2wKNJBj_7WThp0dNIivdQ1PWzuFUxwbVEwk8h8qJCZdZCZmjgvwVGg1h9bbgP0JSnFHgxxqYTkVcEaoru_B2cvYG2cPlT9YtdGIHkNQ1qd00L-84b3GyDE48-RAEAAIAAAABQl1GLCkXzqWBC7QbHPO_2PD145-E8kX95lomevwZqGbg2RrjCSbsf69Fz-0L0wXFD-D1YvsuJtbJZtDyqsOhj9cHDfM2pjBV8VV9f7sd6wlmyCESB3e20gfcoiy2CS6orZTqc3JO8D-Vb7YyhGPXT271-sWr7q9iHUO9L_C4S6rURjSv94b-nD4W96N1aP9ys-ffPE1D72vDcs_78aRHMiKx6JOBBUxl1Nus6InbtTJE-HaeYGpAC8SxvNSo-bXwikGgY28vT59qwfHE98fyxRcJSC8bjfnH23QXRb6SKDa_a7mintqas981CIEF1GlnRgRBAc4ev8WJaHKm_Cmj6vKyVLuuqZ3fHRGgQo-K8G-7ex6TxN4ZLTUu6VEl2HVPv3RO0qyOJvb5mC4NZQ0IQmQAAXGTmHBHfcdGeD0djGA
			
			
			ClientConnectionManager ccm = httpclient.getConnectionManager();
                        //register https protocol in httpclient's scheme registry
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));
  	
			 //访问tocken
			 HttpPost httpPost = new HttpPost("http://10.1.200.120:7000/OAuth/Token");
			// HttpPost httpPost = new HttpPost("http://localhost:8080/signup_ajaxReceiveRequest.do");
				
			List<NameValuePair>  params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("grant_type","client_credentials"));
			params.add(new BasicNameValuePair("scope", "/OAuth/Token"));
			params.add(new BasicNameValuePair("client_id", "3756C2F7548A481FB727A83BCBCCD4DE"));
			params.add(new BasicNameValuePair("client_secret", "BC295EC52B7747798C20206A64FAA01C"));
			 
			UrlEncodedFormEntity urlEncoded = new UrlEncodedFormEntity(params,
					CHARSET_UTF8);
			httpPost.setEntity(urlEncoded);
		 
			
			 
			  HttpResponse response = httpclient.execute(httpPost);  
	          
	            System.out.println(response.getStatusLine());  
	            System.out.println(EntityUtils.toString(response.getEntity())); 
	            
			System.out.println("REQUEST:" + httpPost.getURI());
			ResponseHandler responseHandler = new BasicResponseHandler();
			String responseBody;

			//responseBody = httpclient.execute(httpPost, responseHandler);

			
			//System.out.println(responseBody);

			//HashMap map =  (HashMap)JsonUtil.JSON_String2Bean(responseBody, HashMap.class);
			
			
			//String accessToken=(String)map.get("access_token");
			 	 
			String checkExistUrl ="http://10.1.200.120:7001/api/v1/Member/validatemobile?mobile=13585820668";
            HttpContext httpContext = null;
		     
            HttpGet httpGet = new HttpGet(checkExistUrl);
            //httpGet.addHeader("Authorization", "Bearer "+accessToken);
           //  HttpParams params = httpclient.getParams();
            // params.setParameter("Mobile", mobile); //手机号
 
			 
			// httpGet.setParams(params); 
			   
			 
			  HttpResponse response1 = httpclient.execute(httpGet);  
	          
	            System.out.println(response1.getStatusLine());  
	            System.out.println(EntityUtils.toString(response1.getEntity())); 
	            
	          //  String responseBody =EntityUtils.toString(response.getEntity());
		        
	           //  HashMap map =  (HashMap)JsonUtil.JSON_String2Bean(responseBody, HashMap.class);
				// String responseCode=(String)map.get("ResponseCode");
			  
			
			  //注册
			  
				 /*
			  HttpContext httpContext = null;
		        
		 
		    
			 HttpPost httpPostReg = new HttpPost("http://10.1.249.63:7879/api/v1/Member/validatemobile?mobile=1232131231");
			//HttpPost httpPostReg = new HttpPost("http://localhost:8080/signup_ajaxReceiveRequest.do");
			 httpPostReg.addHeader("Authorization", "Bearer "+accessToken);
			 httpPostReg.addHeader(HTTP.CONTENT_TYPE, "application/json");
			 //httpPostReg.addHeader)
			 HashMap paramMap = new HashMap();
			// paramMap.put("Password", "123456");  //密码
			 paramMap.put("Mobile","13585820668");//手机号
			// paramMap.put("Name","chengqianming");//姓名
			// paramMap.put("Mail","chance@126.com");// 邮箱
			// paramMap.put("IDNo","61273219780623273X");//手机号
			 String json = JsonUtil.JSON_Bean2String(paramMap);
		//	String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);
			// se.setContentType("text/json");
			 

			    //HttpPost httppost = new HttpPost("http://localhost");
			    // 一个本地的文件
			    //FileBody bin = new FileBody(new File("d:/BIMG1181.JPG"));
			    // 一个字符串
			   // StringBody comment = new StringBody(encoderJson);
			    // 多部分的实体
			   // MultipartEntity reqEntity = new MultipartEntity();
			    
			    StringEntity se = new StringEntity(json);
			   // reqEntity.addPart("request:", comment);
			    // 增加
			   // reqEntity.addPart("bin", bin);
			    //reqEntity.addPart("comment", comment);
			    // 设置
			    httpPostReg.setEntity(se);
			    
			     se.setContentType("application/json");
				 se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
					
		      System.out.println("REQUEST:" + httpPostReg.getURI());
		    
		         
			//ResponseHandler responseHandler2 = new BasicResponseHandler();
			//String responseBody2 = httpclient.execute(httpPostReg, responseHandler2);
		     // System.out.println(responseBody2);
		      HttpResponse response = httpclient.execute(httpPostReg);  
	            System.out.println(EntityUtils.toString(httpPostReg.getEntity()));  
	            System.out.println(response.getStatusLine());  
	            System.out.println(EntityUtils.toString(response.getEntity()));  
	            */
			
			/*
			   HttpContext httpContext = null;
		        final HttpClientBuilder hcBuilder = HttpClientBuilder.create();	        
		       // hcBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
		    
		        final RequestBuilder    reqBuilder = RequestBuilder.post();
		       
		        reqBuilder.setUri("http://10.1.249.63:7879/api/v1/Member/Register");
		        
		        final String authHeader = "Bearer "+accessToken;
	            
		        Header header = new BasicHeader("Authorization", authHeader);
	            reqBuilder.addHeader(header);
	           
	            HashMap paramMap = new HashMap();
				 paramMap.put("Password", "123456");  //密码
				 paramMap.put("Mobile","13585820668");//手机号
				 paramMap.put("Name","jishaojie");//姓名
				 paramMap.put("Mail","shaojie.ji@126.com");// 邮箱
				 paramMap.put("IDNo","61273219780623273X");//手机号
				 String encoderJson = JsonUtil.JSON_Bean2String(paramMap);
			//	String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);
				
			//String encoderJson = "{\"mobile\":\"13585820668\",\"password\":\"123456\"}";
				
	            //  ContentType contentType = new ContentTypeBean("application/json", Charsets.UTF_8);
	    	    
	          ContentType contentType = ContentType.create("application/json", "UTF-8");
	              
	              
	             // ReqEntitySimple bean=    new   ReqEntityStringBean(encoderJson,contentType);
	              
	              AbstractHttpEntity e =   new StringEntity(encoderJson, contentType); //HTTPClientUtil.getEntity(bean);
	              
	             //AbstractHttpEntity entity = new StringEntity("", contentType);
	                
	              reqBuilder.setEntity(e);
	              HttpUriRequest req = reqBuilder.build();
	              CloseableHttpClient httpClient = hcBuilder.build();
	              HttpResponse response = httpClient.execute(req, httpContext);
	              
		            System.out.println(response.getStatusLine());  
		            System.out.println(EntityUtils.toString(response.getEntity()));  
			
		 */
		
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
}


