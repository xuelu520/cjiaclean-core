/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: HomeManager.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager;

import java.util.Map;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;

public interface HomeManager extends GenericManager<Object, Long> {
    Map getDate(ParamObject paramObject);
}