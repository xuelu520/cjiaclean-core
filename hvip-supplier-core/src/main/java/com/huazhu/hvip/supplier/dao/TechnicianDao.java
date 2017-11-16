/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TechnicianDao.java
 * Author:   lijing
 * Date:     2016-05-04 09:56:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-04 09:56:31> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.dao;

import com.huazhu.hvip.base.dao.GenericDao;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.supplier.model.Technician;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface TechnicianDao extends GenericDao<Technician,Long>{

    /**
     * 查询技师列表
     * @param queryModel
     * @param param
     * @return
     */
    public List<Technician> searchTechnicianList(QueryModel queryModel,ParamObject param);
}
