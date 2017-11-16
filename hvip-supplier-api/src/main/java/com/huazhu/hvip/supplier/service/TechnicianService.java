/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: TechnicianService.java
 * Author:   lijing
 * Date:     2016-05-04 10:05:30
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-05-04 10:05:30> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.service;

import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.supplier.qo.TechnicianQO;
import com.huazhu.hvip.supplier.vo.TechnicianVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface TechnicianService {

    /**
     * 根据ID获取技师信息
     * @param id
     * @return
     */
    public ReturnObject<TechnicianVO> getTechnicianById(Long id);

    /**
     * 保存技师信息
     * @param technicianVO
     * @return
     */
    public ReturnObject<TechnicianVO> saveTechnician(TechnicianVO technicianVO);

    /**
     * 批量保存技师信息
     * @param list
     * @return
     */
    public ReturnObject<TechnicianVO> saveTechnicians(List<TechnicianVO> list);

    /**
     * 查询技术列表
     * @return
     */
    public ReturnObject<TechnicianVO> searchTechnicianList(TechnicianQO qo);
}
