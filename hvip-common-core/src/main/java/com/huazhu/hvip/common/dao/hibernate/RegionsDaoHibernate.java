/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: AreaDaoHibernate.java
 * Author:   admin
 * Date:     2016-03-08 15:32:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:32:23><version><desc><source>
 *
 */

package com.huazhu.hvip.common.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.common.dao.RegionsDao;
import com.huazhu.hvip.common.model.Regiongaode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("regionsDao")
public class RegionsDaoHibernate extends GenericDaoHibernate<Regiongaode, Long> implements RegionsDao {

    public RegionsDaoHibernate() {
        super(Regiongaode.class);
    }


    public List<Regiongaode> getRegionsList(Long parentId) {
        try {
            StringBuffer hql = new StringBuffer();
            hql.append("from Regiongaode reg ");

            if (parentId == null) {
                parentId = 0L;
            }
            hql.append(" where reg.parentId = " + parentId);
            hql.append(" order by reg.regionId");

            Query query = this.getSession().createQuery(hql.toString());

            List<Regiongaode> list = query.list();
            return list;
        } catch (Exception re) {
            log.error("find by getRegionsList failed", re);
        }
        return null;
    }
}
