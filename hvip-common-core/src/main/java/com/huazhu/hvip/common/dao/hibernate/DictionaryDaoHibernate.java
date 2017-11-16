/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: DictionaryDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.common.model.Dictionary;
import org.springframework.stereotype.Repository;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.DictionaryDao;

@Repository("dictionaryDao")
public class DictionaryDaoHibernate extends GenericDaoHibernate<Dictionary, Long> implements DictionaryDao {

    public DictionaryDaoHibernate() {
        super(Dictionary.class);
    }
}
