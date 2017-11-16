/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeService.java
 * Author:   chenli
 * Date:     2016-03-17 11:24:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-17 11:24:56> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.vo.GoodsTypeBrandVO;
import com.huazhu.hvip.product.vo.GoodsTypeVO;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface GoodsTypeService {

    /**
     * 获取商品类型
     * @return List
     */
    public ReturnObject<GoodsTypeVO> getAll();

    /**
     * 根据id获取商品类型
     * @param typeId 类型id
     * @return ret 通用返回参数
     */
    ReturnObject<GoodsTypeVO> getGoodsTypeById(Long typeId);

    /**
     * 保存商品类型
     * @param goodsTypeVO
     * @return ReturnObject
     */
    public  ReturnObject<GoodsTypeVO> saveGoodsType(GoodsTypeVO goodsTypeVO);

    /**
     * 移除商品类型
     * @param goodsTypeVO
     * @return ReturnObject
     */
    public ReturnObject removeGoodsType(GoodsTypeVO goodsTypeVO);


    /**
     * 根据id批量删除商品类型
     * @param ids 类型ID
     * @return ret 通用返回参数
     */
    public ReturnObject deleteGoodsType(Long[] ids);


    /**
     * 将一个ParamGroup 对象的List 生成json字串 <br/> 此字串将会保存在数据库goods_type的params字段 或
     * js_goods中的params字段
     * 不同的是：goods_type字段中的参数信息无参数值信息，而js_goods表中的params字段有参数值信息。 <br/> List
     * 是根据是根据客户端页面用户输入的参数信息生成的
     *
     * @param paramnums
     * @param groupnames
     * @param paramnames
     * @return
     */
    public ReturnObject<String> getParamString(String[] paramnums, String[] groupnames, String[] paramnames, String[] paramvalues);

    /**
     * 查询类型列表
     * @param para
     * @return
     */
    public ReturnObject<GoodsTypeVO> searchGoodsTypeList(ParamObject para);

    /**
     * 创建类型品牌关联表数据
     * @param typeId
     * @param brandIds
     * @return
     */
    public ReturnObject<GoodsTypeBrandVO> createTypeBrand(Long typeId,List<Long> brandIds);


}
