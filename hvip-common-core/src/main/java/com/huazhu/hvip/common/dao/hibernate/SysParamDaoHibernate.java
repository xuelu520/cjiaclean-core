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

import com.huazhu.hvip.common.dao.SysParamDao;
import com.huazhu.hvip.common.model.SysParam;
import org.springframework.stereotype.Repository;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;

@Repository("sysParamDao")
public class SysParamDaoHibernate extends GenericDaoHibernate<SysParam, Long> implements SysParamDao {

    public SysParamDaoHibernate() {
        super(SysParam.class);
    }
}
