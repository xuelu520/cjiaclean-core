/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: DictCodeManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager;

import java.util.List;

import com.huazhu.hvip.common.model.DictCode;
import com.huazhu.hvip.base.service.GenericManager;


public interface DictCodeManager extends GenericManager<DictCode, Long> {

	 /**
	  * 根据字典名称与代码找具体字典代码
	  * @param dictName
	  * @param codeNo
	  * @return
	  */
	DictCode searchByCodeNo(String dictName, String codeNo);

	/**
	  * 根据字典名称与代码和国家找具体字典代码
	  * @param dictName
	  * @param codeNo
	  * @param country
	  * @return
	  */
	DictCode searchByCodeNoCountry(String dictName, String codeNo, String country);

	 /**
	  * 根据字典名称找字典代码列表
	  * @param dictName
	  * @return
	  */
	List<DictCode> searchByDictName(String dictName);

	/**
	 * 根据字典名称和国家找字典代码列表
	 * @param dictName
	 * @param country
	 * @return
	 */
	List<DictCode> searchByDictNameLocal(String dictName, String country);

}