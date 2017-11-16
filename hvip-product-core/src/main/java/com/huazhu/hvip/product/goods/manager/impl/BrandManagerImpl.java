/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: BrandManagerImpl.java
 * Author:   admin
 * Date:     2016-03-13 14:33:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <admin>  <2016-03-13 14:33:01> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.goods.manager.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.product.goods.dao.BrandDao;
import com.huazhu.hvip.product.goods.manager.BrandManager;
import com.huazhu.hvip.product.goods.model.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brandManager")
public class BrandManagerImpl extends GenericManagerImpl<Brand, Long> implements BrandManager {
    BrandDao brandDao;

    @Autowired
    public BrandManagerImpl(BrandDao brandDao) {
        super(brandDao);
        this.brandDao = brandDao;
    }

    /**
     * 根据id删除品牌
     * @param paramObject 品牌ID
     * @return count
     */
    @Override
    public void deleteBrand(ParamObject paramObject) {
        QueryModel queryModel=new QueryModel();
        String id=paramObject.getStringParam("id");
        if(StringUtils.isNotEmpty(id)){
            queryModel.addHqlCondition("brandId in ("+id+")");
        }
        queryModel.addHqlCondition(" deleteFlag !="+Constants.DELETE_FLAG_TRUE+"");
        List<Brand> brandList=brandDao.search(queryModel);
        for(Brand brand :brandList){
            brand.setDeleteFlag(Constants.DELETE_FLAG_TRUE);
            brandDao.save(brand);
        }
    }

    /**
     * 查询品牌列表
     * @param para
     * @return
     */
    @Override
    public List<Brand> searchBrandList(ParamObject para) {

        Integer pageSize = para.getPageSize();
        Integer pageNo = para.getPageNo();

        QueryModel queryModel = new QueryModel();
        queryModel.addColumnValueCondition("deleteFlag",Constants.DELETE_FLAG_FALSE);
        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }

        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        List<Brand> brandList = brandDao.searchBrandList(queryModel, para);
        brandDao.search(queryModel);

        return brandList;
    }
}