/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SysParamManagerImpl.java
 * Author:   admin
 * Date:     2016-03-08 15:31:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:31:50><version><desc><source>
 *
 */

package com.huazhu.hvip.common.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.hvip.common.dao.SysParamDao;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.common.model.SysParam;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.common.manager.SysParamManager;

@Service("sysParamManager")
public class SysParamManagerImpl extends GenericManagerImpl<SysParam, Long> implements SysParamManager {
    SysParamDao sysParamDao;

    @Autowired
    public SysParamManagerImpl(SysParamDao sysParamDao) {
        super(sysParamDao);
        this.sysParamDao = sysParamDao;
    }

    /**
     * {@inheritDoc}
     */
	public SysParam getParamByName(String paramName) {
        //取所有入账服务器
		QueryModel queryModel = new QueryModel();
		queryModel.addColumnValueCondition("paramName",paramName);
		List<SysParam> paramlist = sysParamDao.search(queryModel);
		SysParam sysParam = null;
		if(paramlist.size()>0){
			sysParam= paramlist.get(0);
		}
		return sysParam;
	}
}