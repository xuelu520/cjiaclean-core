/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AllinpayClientTest.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class AllinpayClientTest {
	private static final String CHARSET_UTF8 = HTTP.UTF_8;
	public static void main(String args[]) {

		try {

			HttpClient httpclient = new DefaultHttpClient();
            //访问tocken
			 HttpPost httpPost = new HttpPost("http://www.cjia.com/allinpay/orderpay.do");
			 String xmlstr ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><transaction><transaction_header><transaction_type>MP0001</transaction_type><requester>ALLINPAY</requester></transaction_header><transaction_body><order_no>3751623001</order_no><merchant_id>309610156918134</merchant_id><terminal_id>81340001</terminal_id></transaction_body><sign_type>MD5</sign_type><sign>2abd3928c432620071544c7421ecb8f7</sign></transaction>";
		/*	 订单号	order_no	String(20)	依照华住订单系统格式	N	
			 系统流水号	sys_ser	String(12)	系统流水号(交易参考号)	N	
			 交易日期时间	trans_date	String(14)	交易发起时的时间	N	YYYYMMDDHHMMSS
			 支付金额	trace_amt	Number(11,2)	支付金额，格式为带两位小数	N	12.34
			 凭证号	trace_no	String(6)	凭证号（POS流水号）	N	
			 卡号	card_no	String(19)	银行卡号，前六后四位,中间用星号替换	N	
			 商户号	merchant_id	String(15)	商户号	N	
			 终端号	terminal_id	String(8)	终端号	N	
*/
		/*
			 String xmlstr ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><transaction><transaction_header>" +
					"<transaction_type>MP0002</transaction_type><requester>ALLINPAY</requester></transaction_header>" +
					"<transaction_body><order_no>2868250201</order_no>" +
					"<sys_ser>309610156918134</sys_ser>" +
					"<trans_date>20141212163434</trans_date>" +
					"<trace_amt>11.22</trace_amt>" +
					"<trace_no>2343243242</trace_no>" +
					"<card_no>345435435345</card_no>" +
					"<merchant_id>3453245234</merchant_id>" +
					"<terminal_id>34532452435</terminal_id>" +
					"</transaction_body>" +
					"<sign_type>MD5</sign_type>" +
					"<sign>2abd3928c432620071544c7421ecb8f7</sign>" +
					"</transaction>";*/
			 
			StringEntity se = new StringEntity(xmlstr);
			httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
			httpPost.setEntity(se);
            HttpResponse response = httpclient.execute(httpPost);  
	        System.out.println(response.getStatusLine());  
	        System.out.println(EntityUtils.toString(response.getEntity())); 
	            
			System.out.println("REQUEST:" + httpPost.getURI());
		 
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}
}


