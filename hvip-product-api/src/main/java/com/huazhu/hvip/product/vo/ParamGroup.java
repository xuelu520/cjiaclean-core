/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ParamGroup.java
 * Author:   lijing
 * Date:     2016-04-20 16:47:58
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-20 16:47:58> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.vo;

import java.util.List;


/**
 * 参数组
 * @author apexking
 *
 */
public class ParamGroup {
	
	
	private String name; //参数组名称
	private List<ParamItem> paramList;  //包含的参数列表
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ParamItem> getParamList() {
		return paramList;
	}
	public void setParamList(List<ParamItem> paramList) {
		this.paramList = paramList;
	}
	
	
	
	/**
	 * 参数的个数
	 * @return
	 */
	public int getParamNum(){
		if(paramList==null) return 0;
		return paramList.size();
	}
	
	
	
	
}
