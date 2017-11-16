/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-20 14:02:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:02:51> <version>   <desc>
 *
 */

package com.huazhu.hvip.inventory.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.inventory.dao.MeasureUnitGroupDao;
import com.huazhu.hvip.inventory.model.MeasureUnitGroup;
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
@Repository("measureUnitGroupDao")
public class MeasureUnitGroupDaoHibernate extends GenericDaoHibernate<MeasureUnitGroup,Long> implements MeasureUnitGroupDao {

    public MeasureUnitGroupDaoHibernate() {
        super(MeasureUnitGroup.class);
    }
}