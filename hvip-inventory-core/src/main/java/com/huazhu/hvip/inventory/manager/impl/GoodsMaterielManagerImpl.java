/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 14:32:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:32:47> <version>   <desc>
 *
 */

package com.huazhu.hvip.inventory.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.inventory.dao.GoodsMaterielDao;
import com.huazhu.hvip.inventory.manager.GoodsMaterielManager;
import com.huazhu.hvip.inventory.model.GoodsMateriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("goodsMaterielManager")
public class GoodsMaterielManagerImpl extends GenericManagerImpl<GoodsMateriel,Long> implements GoodsMaterielManager {

    GoodsMaterielDao goodsMaterielDao;

    @Autowired
    public GoodsMaterielManagerImpl(GoodsMaterielDao goodsMaterielDao){
        super(goodsMaterielDao);
        this.goodsMaterielDao = goodsMaterielDao;
    }
}
