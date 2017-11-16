/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ParamItem.java
 * Author:   lijing
 * Date:     2016-04-20 16:49:17
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-20 16:49:17> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * 商品参数
 * @author apexking
 *
 */
public class ParamItem {
	
	private String name; //参数名
	private String value; //参数值
	
	private List valueList; //多个商品的参数值，用于商品对比 
	
	
	public void addValue(String _value){
		if(valueList == null)  valueList  = new ArrayList();
		valueList.add(_value);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List getValueList() {
		return valueList;
	}
	public void setValueList(List valueList) {
		this.valueList = valueList;
	}
	
	
	
}
