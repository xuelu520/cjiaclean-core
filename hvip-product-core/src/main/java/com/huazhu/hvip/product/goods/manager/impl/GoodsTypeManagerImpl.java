/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: GoodsTypeManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.GoodsTypeBrandDao;
import com.huazhu.hvip.product.goods.dao.GoodsTypeDao;
import com.huazhu.hvip.product.goods.manager.GoodsTypeManager;
import com.huazhu.hvip.product.goods.model.GoodsType;
import com.huazhu.hvip.product.goods.model.GoodsTypeBrand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("goodsTypeManager")
public class GoodsTypeManagerImpl extends GenericManagerImpl<GoodsType, Long> implements GoodsTypeManager {
    GoodsTypeDao goodsTypeDao;

    @Autowired
    public GoodsTypeManagerImpl(GoodsTypeDao goodsTypeDao) {
        super(goodsTypeDao);
        this.goodsTypeDao = goodsTypeDao;
    }

    @Autowired
    private GoodsTypeBrandDao goodsTypeBrandDao;

    /**
     * 检测是否重名
     * @param name 名称
     * @param typeId 类型Long
     * @return
     */
    public boolean checkname(String name, Long typeId) {
        if(name!=null){
            name=name.trim();
        }
        if(typeId == null){
            typeId = 0L;
        }
        String sql  = "select count(0) from vip_goodstype where name='"+ name +"' and type_id!='"+typeId+"' and disabled=0";
        int count = (int) goodsTypeDao.searchObject(sql);
        if(count>0){
            return true;
        }else return false;
    }

    /**
     * 商品类型列表
     * @return List
     */
    public List listAll() {
        String sql   = "select * from vip_goodstype where status=1";
        List typeList = goodsTypeDao.searchObject(sql,GoodsType.class);
        return typeList;
    }

    /**
     * 根据id获取商品类型
     * @param typeId
     * @return
     */
    public GoodsType getById(Long typeId) {
        return goodsTypeDao.get(typeId);
    }

    /**
     * 根据id批量删除商品类型
     * @param ids
     * @return count
     */
    @Override
    public int deleteGoodsType(Long[] ids) {
        QueryModel queryModel =new QueryModel();
        String s = StringUtils.join(ids, ",");
        queryModel.addColumnValueCondition("id", QueryModel.OPERATOR_IN, "(" + s + ")");
        List <GoodsType> goodsList =goodsTypeDao.search(queryModel);
        if (goodsList !=null && goodsList.size()>0){
            for (GoodsType good:goodsList){
                goodsTypeDao.remove(good);
            }
        }else {
            return 0;
        }
        return goodsList.size();
    }

    /**
     * 查询商品类型列表
     * @param para
     * @return
     */
    @Override
    public List<GoodsType> searchGoodsTypeList(ParamObject para) {
        List<String> bizScopeList= (List<String>) para.getParam("bizScopeList");
        Integer pageSize = para.getPageSize();
        Integer pageNo = para.getPageNo();
        String bizScope=StringUtils.join(bizScopeList,",");
        QueryModel queryModel = new QueryModel();
        if(StringUtils.isNotEmpty(bizScope)){
            queryModel.addHqlCondition(" bizScope in ("+bizScope+")");
        }
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }

        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }

        List<GoodsType> brandList = goodsTypeDao.searchGoodsTypeList(queryModel, para);

        return brandList;
    }

    /**
     * 创建类型品牌关联表数据
     * @param typeId
     * @param brandIds
     * @return
     */
    @Override
    public List<GoodsTypeBrand> createTypeBrand(Long typeId, List<Long> brandIds) {

        //首先删除该类型已有数据
        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("typeId",typeId);
        List<GoodsTypeBrand> typeBrands= goodsTypeBrandDao.search(queryModel);
        if (typeBrands != null && typeBrands.size()>0){
            for (GoodsTypeBrand typeBrand : typeBrands){
                goodsTypeBrandDao.remove(typeBrand);
            }
        }

        //重新生成关联数据
        List<GoodsTypeBrand> list = null;
        if(brandIds!=null&&brandIds.size()>0){
            list = new ArrayList<>();
            GoodsTypeBrand typeBrand = null;
            for(Long brandId : brandIds){
                typeBrand = new GoodsTypeBrand();
                typeBrand.setGoodsTypeId(typeId);
                typeBrand.setBrandId(brandId);
//                goodsTypeBrandDao.insert(typeId,brandId);
                typeBrand = goodsTypeBrandDao.save(typeBrand);
                list.add(typeBrand);
            }
        }

        return list;
    }


}