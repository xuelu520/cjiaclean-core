/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: BrandService.java
 * Author:   lijing
 * Date:     2016-03-23 19:58:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-23 19:58:12> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.BrandVO;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface BrandService {

    /**
     * 获取品牌列表
     * @return ReturnObject
     */
    public ReturnObject<BrandVO> getAll();

    /**
     * 保存品牌
     * @param brandVO
     * @return ReturnObject
     */
    public ReturnObject<BrandVO> saveBrand(BrandVO brandVO);

    /**
     * 移除品牌
     * @param brandVO
     * @return ReturnObject
     */
    public ReturnObject removeBrand(BrandVO brandVO);

    /**
     * 根据id删除品牌
     * @param ids 品牌ID
     * @return ret 通用返回参数
     */
    public ReturnObject deleteBrand(Long[] ids);

    /**
     *
     * @param brandId 品牌id
     * @return ret 通用返回参数
     */
    public ReturnObject getBrandById(Long brandId);

    /**
     * 查询品牌列表
     * @param para
     * @return
     */
    public ReturnObject<BrandVO> searchBrandList(ParamObject para);

    /**
     * 根据类型ID查询关联的品牌
     * @param typeId
     * @return
     */
    public ReturnObject<BrandVO> searchBrandByTypeId(Long typeId);
}
