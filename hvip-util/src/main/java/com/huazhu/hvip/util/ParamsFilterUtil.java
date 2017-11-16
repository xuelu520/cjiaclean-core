/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ParamsFilterUtil.java
 * Author:   lijing
 * Date:     2016-04-29 11:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-29 11:01:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.util;


public class ParamsFilterUtil {

	/**
	 *  将容易引起xss漏洞和sql注入的字符直接替换
	 * 
	 * @param value
	 * @return
	 */
	public static String cleanXSS(String value) {
		if(StringUtil.isEmpty(value)) return null;
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
	
	/**
	 *  将容易引起xss漏洞和sql注入的字符直接替换
	 * 
	 * @param value
	 * @return
	 */
	public static String cleanXSSEasy(String value) {
		if(StringUtil.isEmpty(value)) return null;
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
	
}
