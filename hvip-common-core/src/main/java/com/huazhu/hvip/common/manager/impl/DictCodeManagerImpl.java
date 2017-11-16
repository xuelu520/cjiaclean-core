/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: DictCodeManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import java.util.List;

import com.huazhu.hvip.common.model.DictCode;
import com.huazhu.hvip.common.manager.DictCodeManager;
import com.huazhu.hvip.common.dao.DictCodeDao;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dictCodeManager")
public class DictCodeManagerImpl extends GenericManagerImpl<DictCode, Long> implements DictCodeManager {
    DictCodeDao dictCodeDao;

    @Autowired
    public DictCodeManagerImpl(DictCodeDao dictCodeDao) {
        super(dictCodeDao);
        this.dictCodeDao = dictCodeDao;
    }


	public DictCode searchByCodeNo(String dictName, String codeNo) {

		return dictCodeDao.searchByCodeNo(dictName,codeNo);
	}


	public List<DictCode> searchByDictName(String dictName) {
		return dictCodeDao.searchByDictName(dictName,null);
	}


	@Override
	public List<DictCode> searchByDictNameLocal(String dictName, String country) {
		// TODO Auto-generated method stub
		return dictCodeDao.searchByDictNameLocal(dictName, country);
	}


	@Override
	public DictCode searchByCodeNoCountry(String dictName, String codeNo, String country) {
		// TODO Auto-generated method stub
		return dictCodeDao.searchByCodeNoCountry(dictName, codeNo, country);
	}
}