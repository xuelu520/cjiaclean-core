/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: DictCodeDao.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao;

import java.util.List;

import com.huazhu.hvip.common.model.DictCode;
import com.huazhu.hvip.base.dao.GenericDao;

/**
 * An interface that provides a data management interface to the DictCode table.
 */
public interface DictCodeDao extends GenericDao<DictCode, Long> {

	public DictCode searchByCodeNo(String dictKey, String codeNo);
	public DictCode searchByCodeNoCountry(String dictName, String codeNo, String country);

	public List<DictCode> searchByDictName(String dictName, String sortKey);

	public List<DictCode> searchByDictNameLocal(String dictName, String country);

}