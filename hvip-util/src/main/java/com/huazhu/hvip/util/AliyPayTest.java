/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AliyPayTest.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;


public class AliyPayTest {
	private static final String CHARSET_UTF8 = HTTP.UTF_8;
	public static void main(String args[]) {

		try {

			HttpClient httpclient = new DefaultHttpClient();

		 
			String host="http://10.1.249.65:8018/gateway/do.aspx";
			//String host="http://10.1.249.66:2198/gateway/do.aspx";
			 
			
			/*
			String cal_er="website";
	    	String cal_memo="-";
	    	String cal_notifydata="0";
	    	
	    	 
	    	String cal_notifyurl="http%3a%2f%2fdcxtestwww.huazhu.com%2fpayNotify%2fwebsite_notify.aspx";
	    	
	    	
	    	String cal_service= "pay";
	    	
	    	String orderQueryNo ="56942a62-d257-4c47-b220-b989486d82f5";
	    	
	    	
	    	String orderType="receive"; 
	    	String pay_netway="WEBRESV";
	    	String pay_paygate="A";
	    	String pay_returl="http%3a%2f%2fdcxtestwww.huazhu.com%2fresv%2fwhenpayok.aspx";
	    	String pay_timeout="75";
	    	String pay_uniqueid="C20000110000162764-A-316-20141022-20141023";
	    	String receiveOrderNo="C20000110000162764";
	    	String res_amount="316";
	    	String res_assurtype="ADD";
	    	
	    	String res_billid="B20000110000180466";
	    	String res_cancelabletime="2014-10-22";
	    	String res_checkin="2014-10-21";
	    	String res_cresno="R20000110000150290";
	    	String res_email ="0";
	    	String res_hotelid ="2000011";
	    	String res_memberid ="030616327";
	    	String res_mobile ="13661564155";
	    	String res_name ="%e7%8e%8b%e8%ae%b8%e5%af%85";
	    	String res_resno ="12123123123";
	    	String res_vno ="VKYIOSQD1017841364";
	    	String token ="";
	    	//String sign ="0364b468a3033f333b7c4cb42a4f32db";
	    	//String sign_type ="MD5";
	    	 res_name =URLDecoder.decode(res_name);
	    	 cal_notifyurl  =URLDecoder.decode(cal_notifyurl);
	    	 pay_returl  =URLDecoder.decode(pay_returl);
	    	  
	    	// 把请求参数打包成数组
	         Map<String, String> sParaTemp = new HashMap<String, String>();
	        sParaTemp.put("cal_er", cal_er);
	        sParaTemp.put("cal_memo", cal_memo);
	        sParaTemp.put("cal_notifydata", cal_notifydata);
	        
	        
	        sParaTemp.put("cal_notifyurl", cal_notifyurl);
	        sParaTemp.put("cal_service", cal_service);
	        sParaTemp.put("orderQueryNo", orderQueryNo);
	        sParaTemp.put("orderType", orderType);
	        sParaTemp.put("pay_netway", pay_netway);
	        sParaTemp.put("pay_paygate", pay_paygate);
	        sParaTemp.put("pay_returl", pay_returl);
	        sParaTemp.put("pay_timeout", pay_timeout);
            sParaTemp.put("pay_uniqueid", pay_uniqueid);  
	        sParaTemp.put("receiveOrderNo", receiveOrderNo);
	        sParaTemp.put("res_amount", res_amount);
	        sParaTemp.put("res_assurtype", res_assurtype);
	        
	        sParaTemp.put("res_billid", res_billid);  
	         sParaTemp.put("res_cancelabletime", res_cancelabletime);
	       sParaTemp.put("res_checkin", res_checkin);
	        sParaTemp.put("res_cresno", res_cresno);
	       sParaTemp.put("res_email", res_email);  
	        sParaTemp.put("res_hotelid", res_hotelid);
	        sParaTemp.put("res_memberid", res_memberid);
	        sParaTemp.put("res_mobile", res_mobile);
	        sParaTemp.put("res_name", res_name);  
	      sParaTemp.put("res_resno", res_resno);  
	         sParaTemp.put("res_vno", res_vno);
	       sParaTemp.put("token", token);
	         sParaTemp.put("token", token);
	        sParaTemp.put("sign_type", token);
	        
			*/
		 
			/*
			    payUrl ="http://10.1.249.65:8018/gateway/do.aspx?cal_er=website
			    &cal_memo=%B3%C9%BC%D2%B6%A9%B5%A5
			    &cal_notifydata=0
			    &cal_notifyurl=http%3A%2F%2Fwww.echengjia.com%3A8080%2Fpay_notify.do%22
			    &cal_service=pay
			    &orderQueryNo=c221b854945a4f7b9945958b8f8091f5
			    &orderType=
			    &pay_netway=WEBRESV
			    &pay_paygate=A
			    &pay_returl=http%3A%2F%2Fwww.echengjia.com%3A8080%2Fpay_notify.do%22
			    &pay_timeout=75
			    &pay_uniqueid=00000026-A-150-20141030-20141031
			    &receiveOrderNo=
			    &res_amount=150&res_assurtype=A&res_billid=00000026&res_cancelabletime=2014-10-31&res_checkin=2014-10-30
			    &res_cresno=00000026&res_email=0&res_hotelid=2&res_memberid=10&res_mobile=13585820668
			    &res_name=%BC%CD%C9%D9%BD%DC&res_resno=00000026&res_vno=00000026
			    &token=&sign=1be292b63d08e9e3544cb73e7ce725a6&sign_type=MD5";
			    ef2408f45e9dbd874592eb63775a879f
		    
		 */
			
			/*
		        String cal_er="website";
		    	String cal_memo="成家订单";
		    	String cal_notifydata="0";
		    	
		    	String cal_notifyurl="http://www.echengjia.com:8080/pay_notify.do\"";
		    	//String cal_notifyurl="http%3a%2f%2fdcxtestwww.huazhu.com%2fpayNotify%2fwebsite_notify.aspx";
		    	
		    	String cal_service= "pay";
		    	String orderQueryNo ="c221b854945a4f7b9945958b8f8091f5";
		    	
		    	
		    	String orderType=""; 
		    	String pay_netway="WEBRESV";
		    	String pay_paygate="A";
		    	String pay_returl="http://www.echengjia.com:8080/pay_notify.do\"";
		    	String pay_timeout="75";
		    	String pay_uniqueid="00000026-A-150-20141030-20141031";  //dingdan -
		        String receiveOrderNo="";
		    	String res_amount="150";
		    	String res_assurtype="A"; 
		    	
		    	String res_billid="00000025"; //账务编号
		    	String res_cancelabletime="2014-10-31";
		    	String res_checkin="2014-10-30";
		    	String res_cresno="00000025";
		    	String res_email ="0";
		    	String res_hotelid ="2";
		    	String res_memberid ="10";
		    	String res_mobile ="13585820668";
		    	String res_name ="纪少杰";
		    	String res_resno ="00000026";
		    	String res_vno ="00000026";
		    	String token ="";
		    	//String sign ="0364b468a3033f333b7c4cb42a4f32db";
		    	//String sign_type ="MD5";
		    	// res_name =URLDecoder.decode(res_name);
		    	// cal_notifyurl  =URLDecoder.decode(cal_notifyurl);
		    	// pay_returl  =URLDecoder.decode(pay_returl);
		    	//http://10.1.249.65:8018/gateway/do.aspx?cal_er=website&cal_memo=%E6%88%90%E5%AE%B6%E8%AE%A2%E5%8D%95&cal_notifydata=0&cal_notifyurl=http%3A%2F%2Fwww.echengjia.com%2Fpay%2FalipayReturl.do&cal_service=pay&orderQueryNo=56942a62-d257-4c47-b220-b989486d82f5&pay_netway=WEBRESV&pay_paygate=A&pay_returl=http%3A%2F%2Fwww.echengjia.com%2Fpay%2FalipayReturl.do&pay_timeout=75&pay_uniqueid=80000111222-A-316-20141026-20151025&res_amount=500&res_assurtype=A&res_billid=80000111222&res_cancelabletime=2014-10-26&res_checkin=2015-10-25&res_cresno=80000111222&res_email=0&res_hotelid=2000011&res_memberid=030616327&res_mobile=13661564155&res_name=%E7%BA%AA%E5%B0%91%E6%9D%B0&res_resno=12123123123&res_vno=VKYIOSQD1017841364&token=&sign=776200baae2bd1cb07eb45aac7c17e9e&sign_type=MD5
   	  
		    	// 把请求参数打包成数组
		         Map<String, String> sParaTemp = new HashMap<String, String>();
		        sParaTemp.put("cal_er", cal_er);
		        sParaTemp.put("cal_memo", cal_memo);
		        sParaTemp.put("cal_notifydata", cal_notifydata);
		        
		        
		        sParaTemp.put("cal_notifyurl", cal_notifyurl);
		        sParaTemp.put("cal_service", cal_service);
		        sParaTemp.put("orderQueryNo", orderQueryNo);
		        sParaTemp.put("orderType", orderType);
		        sParaTemp.put("pay_netway", pay_netway);
		        sParaTemp.put("pay_paygate", pay_paygate);
		        sParaTemp.put("pay_returl", pay_returl);
		        sParaTemp.put("pay_timeout", pay_timeout);
	            sParaTemp.put("pay_uniqueid", pay_uniqueid);  
		       sParaTemp.put("receiveOrderNo", receiveOrderNo);
		        sParaTemp.put("res_amount", res_amount);
		        sParaTemp.put("res_assurtype", res_assurtype);
		        
		        sParaTemp.put("res_billid", res_billid);  
		         sParaTemp.put("res_cancelabletime", res_cancelabletime);
		       sParaTemp.put("res_checkin", res_checkin);
		        sParaTemp.put("res_cresno", res_cresno);
		       sParaTemp.put("res_email", res_email);  
		        sParaTemp.put("res_hotelid", res_hotelid);
		        sParaTemp.put("res_memberid", res_memberid);
		        sParaTemp.put("res_mobile", res_mobile);
		        sParaTemp.put("res_name", res_name);  
		      sParaTemp.put("res_resno", res_resno);  
		         sParaTemp.put("res_vno", res_vno);
		       sParaTemp.put("token", token);
		       //  sParaTemp.put("token", token);
		      //  sParaTemp.put("sign_type", token);
			
			//String  payUrl = "http://10.1.249.66:2198/gateway/do.aspx?cal_er=website&cal_memo=-&cal_notifydata=0&cal_notifyurl=http%3a%2f%2fdcxtestwww.huazhu.com%2fpayNotify%2fwebsite_notify.aspx&cal_service=pay&orderQueryNo=56942a62-d257-4c47-b220-b989486d82f5&orderType=receive&pay_netway=WEBRESV&pay_paygate=A&pay_returl=http%3a%2f%2fdcxtestwww.huazhu.com%2fresv%2fwhenpayok.aspx&pay_timeout=75&pay_uniqueid=C20000110000162764-A-316-20141022-20141023&receiveOrderNo=C20000110000162764&res_amount=316&res_assurtype=ADD&res_billid=B20000110000180466&res_cancelabletime=2014-10-22&res_checkin=2014-10-21&res_cresno=R20000110000150290&res_email=0&res_hotelid=2000011&res_memberid=030616327&res_mobile=13661564155&res_name=%e7%8e%8b%e8%ae%b8%e5%af%85&res_resno=&res_vno=VKYIOSQD1017841364&token=&sign=0364b468a3033f333b7c4cb42a4f32db&sign_type=MD5";
			
	       // http://10.1.249.66:2198/gateway/do.aspx_input_charset=UTF-8&res_checkin=2014-10-21&pay_returl=http%3a%2f%2fdcxtestwww.huazhu.com%2fresv%2fwhenpayok.aspx&orderType=receive&res_cresno=R20000110000150290&res_cancelabletime=2014-10-22&sign_type=MD5&res_mobile=13661564155&cal_memo=成家订单&pay_uniqueid=C20000110000162764-A-316-20141022-20141023&res_amount=316&cal_service=pay&sign=be60d5710c521186b8563214da646071&res_billid=B20000110000180466&receiveOrderNo=C20000110000162764&cal_notifyurl=http://www.echengjia.com/pay/alipayReturl.do&res_name=小马&caler=chengjia&res_vno=VKYIOSQD1017841364&res_memberid=030616327&orderQueryNo=56942a62-d257-4c47-b220-b989486d82f5&res_email=0&res_hotelid=2000011&pay_paygate=A&res_assurtype=ADD&pay_netway=WEBRESV&pay_timeout=75
		                         
		      String   signkey="hca42g6cnidkmm7kk34j";
		    String payUrl = PayParamUtil.buildUrl(host,sParaTemp,signkey);
	        
		   //   payUrl ="http://10.1.249.65:8018/gateway/do.aspx?cal_er=website&cal_memo=%B3%C9%BC%D2%B6%A9%B5%A5&cal_notifydata=0&cal_notifyurl=http%3A%2F%2Fwww.echengjia.com%3A8080%2Fpay_notify.do%22&cal_service=pay&orderQueryNo=c221b854945a4f7b9945958b8f8091f5&orderType=&pay_netway=WEBRESV&pay_paygate=A&pay_returl=http%3A%2F%2Fwww.echengjia.com%3A8080%2Fpay_notify.do%22&pay_timeout=75&pay_uniqueid=00000026-A-150-20141030-20141031&receiveOrderNo=&res_amount=150&res_assurtype=A&res_billid=00000026&res_cancelabletime=2014-10-31&res_checkin=2014-10-30&res_cresno=00000026&res_email=0&res_hotelid=2&res_memberid=10&res_mobile=13585820668&res_name=%BC%CD%C9%D9%BD%DC&res_resno=00000026&res_vno=00000026&token=&sign=1be292b63d08e9e3544cb73e7ce725a6&sign_type=MD5";
		    

			 //访问tocken
			 HttpPost httpPost = new HttpPost(payUrl);
			 	
			List<NameValuePair>  params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("grant_type","client_credentials"));
			params.add(new BasicNameValuePair("scope", "/OAuth/Token"));
			params.add(new BasicNameValuePair("client_id", "5EB2D1649AEA47CFADC8053C4AF9B236"));
			params.add(new BasicNameValuePair("client_secret", "D6B42A16E62441D59836E6BE7BCC42A0"));
			 
			UrlEncodedFormEntity urlEncoded = new UrlEncodedFormEntity(params,CHARSET_UTF8);
			//httpPost.setEntity(urlEncoded);
		 
			System.out.println("REQUEST:" + httpPost.getURI());
			ResponseHandler responseHandler = new BasicResponseHandler();
			 String responseBody = httpclient.execute(httpPost, responseHandler);

			 System.out.println(URLDecoder.decode( responseBody));
			//HttpResponse response = httpclient.execute(httpPost);  
	        
			//System.out.println(EntityUtils.toString(httpPost.getEntity()));  
	        //System.out.println(response.getStatusLine());  
	        //System.out.println(EntityUtils.toString(response.getEntity()));  
	 
			 */
			 
			 
               String payNo = "00000027"; 	 
	            
	            String amount= "150";
	           
			
		        String cal_er="website";
		    	String cal_memo="成家订单";
		    	String cal_notifydata="0";
		    	
		    	String cal_notifyurl="http://www.echengjia.com:8080/pay_notify.do";
		    	 
		    	String cal_service= "pay";
		    	
		    	String orderQueryNo = "2a02763a7ce041e39f1f58dcd5e930d0";
		    	
		    	
		    	String orderType="chengjia"; 
		    	String pay_netway="WEBRESV";
		    	String pay_paygate="A";
		    	String pay_returl="http://www.echengjia.com:8080/pay_notify.do";
		    	String pay_timeout="75";
		    	
		    	String pay_uniqueid="00000027-A-150-20141030-20141031";  //dingdan -
		        
		    	String receiveOrderNo="";
		    	String res_amount=amount;
		    	String res_assurtype="A"; 
		    
		    	String res_billid=payNo; //账务编号
		    	String res_cancelabletime="2014-10-29";
		    	String res_checkin="2014-10-30";
		    	String res_cresno=payNo;
		    	String res_email ="0";
		    	String res_hotelid ="2";
		    	String res_memberid ="10";
		    	String res_mobile ="13585820668";
		    	String res_name ="纪少杰";
		    	String res_resno =payNo;
		    	String res_vno =payNo;
		    	String token ="";
		    	 
		    	// res_name =URLDecoder.decode(res_name);
		    	// cal_notifyurl  =URLDecoder.decode(cal_notifyurl);
		    	// pay_returl  =URLDecoder.decode(pay_returl);
		     
		    	// 把请求参数打包成数组
		         Map<String, String> sParaTemp = new HashMap<String, String>();
		        sParaTemp.put("cal_er", cal_er);
		        sParaTemp.put("cal_memo", cal_memo);
		        sParaTemp.put("cal_notifydata", cal_notifydata);
		        
		        
		        sParaTemp.put("cal_notifyurl", cal_notifyurl);
		        sParaTemp.put("cal_service", cal_service);
		        sParaTemp.put("orderQueryNo", orderQueryNo);
		        sParaTemp.put("orderType", orderType);
		        sParaTemp.put("pay_netway", pay_netway);
		        sParaTemp.put("pay_paygate", pay_paygate);
		        sParaTemp.put("pay_returl", pay_returl);
		        sParaTemp.put("pay_timeout", pay_timeout);
	            sParaTemp.put("pay_uniqueid", pay_uniqueid);  
		       sParaTemp.put("receiveOrderNo", receiveOrderNo);
		        sParaTemp.put("res_amount", res_amount);
		        sParaTemp.put("res_assurtype", res_assurtype);
		        
		        sParaTemp.put("res_billid", res_billid);  
		         sParaTemp.put("res_cancelabletime", res_cancelabletime);
		       sParaTemp.put("res_checkin", res_checkin);
		        sParaTemp.put("res_cresno", res_cresno);
		       sParaTemp.put("res_email", res_email);  
		        sParaTemp.put("res_hotelid", res_hotelid);
		        sParaTemp.put("res_memberid", res_memberid);
		        sParaTemp.put("res_mobile", res_mobile);
		        sParaTemp.put("res_name", res_name);  
		      sParaTemp.put("res_resno", res_resno);  
		         sParaTemp.put("res_vno", res_vno);
		       sParaTemp.put("token", token);
		        // sParaTemp.put("token", token);
		        //sParaTemp.put("sign_type", token);
			
			//String  payUrl = "http://10.1.249.66:2198/gateway/do.aspx?cal_er=website&cal_memo=-&cal_notifydata=0&cal_notifyurl=http%3a%2f%2fdcxtestwww.huazhu.com%2fpayNotify%2fwebsite_notify.aspx&cal_service=pay&orderQueryNo=56942a62-d257-4c47-b220-b989486d82f5&orderType=receive&pay_netway=WEBRESV&pay_paygate=A&pay_returl=http%3a%2f%2fdcxtestwww.huazhu.com%2fresv%2fwhenpayok.aspx&pay_timeout=75&pay_uniqueid=C20000110000162764-A-316-20141022-20141023&receiveOrderNo=C20000110000162764&res_amount=316&res_assurtype=ADD&res_billid=B20000110000180466&res_cancelabletime=2014-10-22&res_checkin=2014-10-21&res_cresno=R20000110000150290&res_email=0&res_hotelid=2000011&res_memberid=030616327&res_mobile=13661564155&res_name=%e7%8e%8b%e8%ae%b8%e5%af%85&res_resno=&res_vno=VKYIOSQD1017841364&token=&sign=0364b468a3033f333b7c4cb42a4f32db&sign_type=MD5";
			                  //http://10.1.249.65:8018/gateway/do.aspx?cal_er=website&cal_memo=%B3%C9%BC%D2%B6%A9%B5%A5&cal_notifydata=0&cal_notifyurl=http%3A%2F%2Fwww.echengjia.com%3A8080%2Fpay_notify.do%22&cal_service=pay&orderQueryNo=7d1fe5e6b09248ba8a4754e643c15881&orderType=&pay_netway=WEBRESV&pay_paygate=A&pay_returl=http%3A%2F%2Fwww.echengjia.com%3A8080%2Fpay_notify.do%22&pay_timeout=75&pay_uniqueid=00000026-A-150-20141030-20141031&receiveOrderNo=&res_amount=150&res_assurtype=A&res_billid=00000026&res_cancelabletime=2014-10-31&res_checkin=2014-10-30&res_cresno=00000026&res_email=0&res_hotelid=2&res_memberid=10&res_mobile=13585820668&res_name=%BC%CD%C9%D9%BD%DC&res_resno=00000026&res_vno=00000026&token=&sign=89c459152a2fe500f06f6d9cf74f1386&sign_type=MD5
	       // http://10.1.249.66:2198/gateway/do.aspx_input_charset=UTF-8&res_checkin=2014-10-21&pay_returl=http%3a%2f%2fdcxtestwww.huazhu.com%2fresv%2fwhenpayok.aspx&orderType=receive&res_cresno=R20000110000150290&res_cancelabletime=2014-10-22&sign_type=MD5&res_mobile=13661564155&cal_memo=成家订单&pay_uniqueid=C20000110000162764-A-316-20141022-20141023&res_amount=316&cal_service=pay&sign=be60d5710c521186b8563214da646071&res_billid=B20000110000180466&receiveOrderNo=C20000110000162764&cal_notifyurl=http://www.echengjia.com/pay/alipayReturl.do&res_name=小马&caler=chengjia&res_vno=VKYIOSQD1017841364&res_memberid=030616327&orderQueryNo=56942a62-d257-4c47-b220-b989486d82f5&res_email=0&res_hotelid=2000011&pay_paygate=A&res_assurtype=ADD&pay_netway=WEBRESV&pay_timeout=75
		       String   signkey="hca42g6cnidkmm7kk34j";
		      
		      String payUrl = PayParamUtil.buildUrl(host,sParaTemp,signkey);
		      HttpPost httpPost = new HttpPost(payUrl);
		     
		      
		      System.out.println(httpclient.getParams().getParameter(HttpMethodParams.HTTP_CONTENT_CHARSET));
		      
				 
				 httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
				System.out.println("REQUEST:" + httpPost.getURI());
				ResponseHandler responseHandler = new BasicResponseHandler();
			 
				// String responseBody = httpclient.execute(httpPost, responseHandler);

				 //System.out.println(  URLDecoder.decode(responseBody) );
			
		
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
}


