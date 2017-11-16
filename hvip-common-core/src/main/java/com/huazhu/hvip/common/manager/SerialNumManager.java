/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: SerialNumManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager;

import java.util.List;

import com.huazhu.hvip.common.model.SerialNum;
import com.huazhu.hvip.base.service.GenericManager;

public interface SerialNumManager extends GenericManager<SerialNum, Long> {

    public String createSerialNumber(String name);

	public List<SerialNum> searchSerialNumber(SerialNum serialNumber);
}