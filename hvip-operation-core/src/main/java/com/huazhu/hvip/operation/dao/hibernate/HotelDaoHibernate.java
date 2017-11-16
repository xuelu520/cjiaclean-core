/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: HotelDaoHibernate.java
 * Author:   chenli
 * Date:     2016-03-23 17:39:05
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 17:39:05> <version>   <desc>
 *
 */

package com.huazhu.hvip.operation.dao.hibernate;

import com.huazhu.hvip.base.dao.hibernate.GenericDaoHibernate;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.operation.dao.HotelDao;
import com.huazhu.hvip.operation.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Repository(value = "hotelDao")
public class HotelDaoHibernate extends GenericDaoHibernate<Hotel, Long> implements HotelDao {

    public HotelDaoHibernate() {
        super(Hotel.class);
    }

    /**
     * 查询所有的有效酒店
     *
     * @param queryModel
     * @return
     */
    public List<Hotel> searchHotelList(QueryModel queryModel) {
        queryModel.setSelectSqlHead("select h from Hotel h", false);
        return super.search(queryModel);
    }

    /**
     * 根据参数获取酒店信息
     *
     * @param queryModel
     * @return
     */
    @Override
    public Hotel getHotelByParam(QueryModel queryModel) {

        queryModel.setSelectSqlHead("select h from Hotel h", false);
        List<Hotel> list = super.search(queryModel);
        if (!list.isEmpty() && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }
}
