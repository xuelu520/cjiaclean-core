/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeManager.java
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
import com.huazhu.hvip.product.goods.model.GoodsType;
import com.huazhu.hvip.product.goods.model.GoodsTypeBrand;

import java.util.List;

public interface GoodsTypeManager extends GenericManager<GoodsType, Long> {

    /**
     * 检测是否重名
     * @param name 名称
     * @param typeId 类型Long
     * @return
     */
    public boolean checkname(String name,Long typeId);

    /**
     * 商品类型列表
     * @return List
     */
    public List listAll();

    /**
     * 根据id获取商品类型
     * @param typeId
     * @return
     */
    public GoodsType getById(Long typeId);

    /**
     *保存商品类型
     * @param type
     */
    //public Integer save(GoodsType type) ;

    /**
     *保存商品类型 品牌信息
     * @param type
     */
    //public Integer saveTypeBrand(GoodsType type) ;

    /**
     * 读取一个类型的信息
     * @param type_id
     * @return
     */
    //public GoodsTypeDTO get(Integer type_id);

    /**
     * 根据id批量删除商品类型
     * @param ids
     * @return count
     */
    public int deleteGoodsType(Long[] ids);

    /**
     * 根据条件查询类型列表
     *
     * @param para
     * @return List<GoodsType>
     */
    public List<GoodsType> searchGoodsTypeList(ParamObject para);

    /**
     * 创建类型品牌关联表数据
     * @param typeId
     * @param brandIds
     * @return
     */
    List<GoodsTypeBrand> createTypeBrand(Long typeId,List<Long> brandIds);
}