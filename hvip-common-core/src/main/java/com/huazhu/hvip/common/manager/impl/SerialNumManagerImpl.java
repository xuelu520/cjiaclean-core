/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: SerialNumManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import java.util.HashMap;
import java.util.List;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.manager.SerialNumManager;
import com.huazhu.hvip.util.SerialUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.hvip.common.dao.SerialNumDao;
import com.huazhu.hvip.common.model.SerialNum;

@Service("serialNumManager")
public class SerialNumManagerImpl extends GenericManagerImpl<SerialNum, Long> implements SerialNumManager {
    SerialNumDao serialNumDao;

    @Autowired
    public SerialNumManagerImpl(SerialNumDao serialNumDao) {
        super(serialNumDao);
        this.serialNumDao = serialNumDao;
    }

    public String createSerialNumber(String name) {
    	SerialNum  serial= serialNumDao.getSerialNumberByName(name);

		String rule = serial.getSerialRule();

		Integer curValue = serial.getNextNum();
		HashMap paramMap = new HashMap();
		//paramMap.put("billDate", new Date());
		paramMap.put("curValue", curValue);
		//paramMap.put("dept", "IT");

		String result = SerialUtil.generateSerialNo(rule, paramMap);
		serial.setNextNum(curValue+1);

		serialNumDao.save(serial);
		return result;

	}

	public List<SerialNum> searchSerialNumber(SerialNum serialNumber) {
		return serialNumDao.searchSerialNumber(serialNumber);
	}
}