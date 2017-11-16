/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: SerialNumDao.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao;

import java.util.List;

import com.huazhu.hvip.common.model.SerialNum;
import com.huazhu.hvip.base.dao.GenericDao;

/**
 * An interface that provides a data management interface to the SerialNum table.
 */
public interface SerialNumDao extends GenericDao<SerialNum, Long> {
   public String generateSerialNumber(String name);

	public List<SerialNum> searchSerialNumber(SerialNum serialNum);

	public SerialNum getSerialNumberByName(String name);
}