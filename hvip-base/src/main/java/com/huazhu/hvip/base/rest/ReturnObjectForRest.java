/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: ReturnObject.java
 * Author:   admin
 * Date:     2016-03-08 15:32:43
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:32:43><version><desc><source>
 *
 */

package com.huazhu.hvip.base.rest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 *
 * REST 通用返回对象
 *
 */
public class ReturnObjectForRest<T> implements Serializable{

	private String code;   //0 表示成功  -1表示参数验证失败  1表示业务失败   9  表示系统异常。

	private String message;  //返回消息

    private T data;   //返回对象

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
