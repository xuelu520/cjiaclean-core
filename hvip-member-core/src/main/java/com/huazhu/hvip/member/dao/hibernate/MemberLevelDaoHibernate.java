/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: MemberLevelDaoHibernate.java
 * Author:   lijing
 * Date:     2016-03-20 14:04:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-20 14:04:40> <version>   <desc>
 *
 */

package com.huazhu.hvip.member.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.member.dao.MemberLevelDao;
import com.huazhu.hvip.member.model.MemberLevel;
import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("memberLevelDao")
public class MemberLevelDaoHibernate extends GenericDaoHibernate<MemberLevel,Long> implements MemberLevelDao{

    public MemberLevelDaoHibernate() {
        super(MemberLevel.class);
    }
}
