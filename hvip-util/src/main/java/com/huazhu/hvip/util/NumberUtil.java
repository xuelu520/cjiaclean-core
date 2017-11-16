/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: NumberUtil.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

/**
 * 
 */
package com.huazhu.hvip.util;

 
public class NumberUtil {

	
	/**
	 * 比较两个float数字是否相等
	 * @param f1
	 * @param f2
	 * @return
	 */
	public static boolean compareFloatEqual(float f1,float f2){
		
		
		if (Math.abs(f2 - f1) < 0.00000001) {
		  return true;
		}	
		return false;
	}
	public static Boolean equals(Integer i1, Integer i2) {
		
		if (i1 == null && i2 == null) {
			return true;
		} 
		
		if ((i1 == null && i2 != null) || (i1 != null && i2 == null)) {
			return false;
		}
		
		if (i1.equals(i2)) {
			return true;
		}
		
		return false;
	}
	
	public static Boolean equals(Double i1, Double i2) {
		
		if (i1 == null && i2 == null) {
			return true;
		} 
		
		if ((i1 == null && i2 != null) || (i1 != null && i2 == null)) {
			return false;
		}
		
		if (i1.equals(i2)) {
			return true;
		}
		
		return false;
	}
	
}
