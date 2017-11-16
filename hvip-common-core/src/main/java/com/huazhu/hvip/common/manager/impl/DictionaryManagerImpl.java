/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: DictionaryManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.hvip.common.dao.DictionaryDao;
import com.huazhu.hvip.common.model.Dictionary;
import com.huazhu.hvip.common.manager.DictionaryManager;

@Service("dictionaryManager")
public class DictionaryManagerImpl extends GenericManagerImpl<Dictionary, Long> implements DictionaryManager {
    DictionaryDao dictionaryDao;

    @Autowired
    public DictionaryManagerImpl(DictionaryDao dictionaryDao) {
        super(dictionaryDao);
        this.dictionaryDao = dictionaryDao;
    }
}