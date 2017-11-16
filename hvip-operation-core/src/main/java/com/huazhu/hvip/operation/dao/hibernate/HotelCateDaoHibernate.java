/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelCateDaoHibernate.java
 * Author:   chenli
 * Date:     2016-03-23 17:41:04
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:41:04> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.operation.dao.HotelCateDao;
import com.huazhu.hvip.operation.dao.HotelDao;
import com.huazhu.hvip.operation.model.Hotel;
import com.huazhu.hvip.operation.model.HotelCate;
import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository("hotelCateDao")
public class HotelCateDaoHibernate extends GenericDaoHibernate<HotelCate, Long> implements HotelCateDao {

    public HotelCateDaoHibernate(){
        super(HotelCate.class);
    }


}
