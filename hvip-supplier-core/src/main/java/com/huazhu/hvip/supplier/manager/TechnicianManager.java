/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TechnicianManager.java
 * Author:   lijing
 * Date:     2016-05-04 09:59:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-04 09:59:41> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.manager;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
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
public interface TechnicianManager extends GenericManager<Technician,Long>{

    /**
     * 保存技师信息
     * @param technician
     * @return
     */
    public Technician saveTechnician(Technician technician);

    /**
     * 批量保存技师信息
     * @param list
     * @return
     */
    public List<Technician> saveTechnicians(List<Technician> list);

    /**
     * 查询技师列表
     * @param param
     * @return
     */
    public List<Technician> searchTechnicianList(ParamObject param);
}
