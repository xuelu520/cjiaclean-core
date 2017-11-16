/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AuthDaoHibernate.java
 * Author:   lijing
 * Date:     2016-04-18 18:11:03
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-04-18 18:11:03> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.opUser.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.user.opUser.dao.AuthDao;
import com.huazhu.hvip.user.opUser.dao.RoleAuthDao;
import com.huazhu.hvip.user.opUser.model.Auth;
import com.huazhu.hvip.user.opUser.model.RoleAuth;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("roleAuthDao")
public class RoleAuthDaoHibernate extends GenericDaoHibernate<RoleAuth,Long> implements RoleAuthDao{

    public RoleAuthDaoHibernate() {
        super(RoleAuth.class);
    }


}
