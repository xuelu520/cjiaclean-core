/*
 * Copyright (C),2016-2016. ��ס�Ƶ�������޹�˾
 * FileName: SysParamDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼ �޸������� �޸�ʱ�� �汾�� ���� ������Դ
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.FinanceSubjectDao;
import com.huazhu.hvip.common.model.FinanceSubject;
import org.springframework.stereotype.Repository;

@Repository("financeSubjectDao")
public class FinanceSubjectDaoHibernate extends GenericDaoHibernate<FinanceSubject, Long> implements FinanceSubjectDao {

    public FinanceSubjectDaoHibernate() {
        super(FinanceSubject.class);
    }
}
