/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: StoreRecordDaoHibernate.java
 * Author:   HUQIANBO001
 * Date:     2016-04-06 17:57:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <HUQIANBO001><2016-04-06 17:57:37><version><desc>
 */

package com.huazhu.hvip.product.goods.dao.hibernate;


import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.product.goods.dao.StoreRecordDao;
import com.huazhu.hvip.product.goods.dao.TagGoodsDao;
import com.huazhu.hvip.product.goods.model.StoreRecord;
import com.huazhu.hvip.product.goods.model.TagGoods;
import org.springframework.stereotype.Repository;

@Repository("storeRecordDao")
public class StoreRecordDaoHibernate extends GenericDaoHibernate<StoreRecord, Long> implements StoreRecordDao {

    public StoreRecordDaoHibernate() {
        super(StoreRecord.class);
    }
}
