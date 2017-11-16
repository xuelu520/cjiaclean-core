/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MenuDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-20 16:45:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin><2016-03-20 16:45:35><version><desc>
 */

package com.huazhu.hvip.common.dao.hibernate;
import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.NotifyRecordDao;
import com.huazhu.hvip.common.model.NotifyRecord;
import org.springframework.stereotype.Repository;

@Repository("notifyRecordDao")
public class NotifyRecordDaoHibernate extends GenericDaoHibernate<NotifyRecord, Long> implements NotifyRecordDao {

    public NotifyRecordDaoHibernate() {
        super(NotifyRecord.class);
    }

}
