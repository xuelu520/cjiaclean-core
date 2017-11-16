/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: WebUserSourceManagerImpl.java
 * Author:   lijing
 * Date:     2016-03-20 15:07:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 15:07:53> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.manager.impl;

import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.member.dao.WebUserSourceDao;
import com.huazhu.hvip.member.manager.WebUserSourceManager;
import com.huazhu.hvip.member.model.WebUserSource;
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
@Service("webUserSourceManager")
public class WebUserSourceManagerImpl extends GenericManagerImpl<WebUserSource,Long> implements WebUserSourceManager{

    WebUserSourceDao webUserSourceDao;

    @Autowired
    public WebUserSourceManagerImpl(WebUserSourceDao webUserSourceDao){
        super(webUserSourceDao);
        this.webUserSourceDao = webUserSourceDao;
    }
}
