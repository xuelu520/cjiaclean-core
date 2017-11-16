/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: BrandManager.java
 * Author:   admin
 * Date:     2016-03-13 14:32:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:32:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager;


import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.service.GenericManager;
import com.huazhu.hvip.product.goods.model.Brand;

import java.util.List;

public interface BrandManager extends GenericManager<Brand, Long> {

    /**
     * 根据id删除品牌
     * @param paramObject 品牌ID
     * @return count
     */
    public void deleteBrand(ParamObject paramObject);

    /**
     * 根据条件查询品牌列表
     *
     * @param para
     * @return List<Brand>
     */
    public List<Brand> searchBrandList(ParamObject para);

}