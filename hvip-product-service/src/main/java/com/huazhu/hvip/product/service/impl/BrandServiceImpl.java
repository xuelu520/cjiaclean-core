/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: BrandServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-23 19:58:33
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-23 19:58:33> <version>   <desc>
 *
 */

package com.huazhu.hvip.product.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.product.goods.manager.BrandManager;
import com.huazhu.hvip.product.goods.model.Brand;
import com.huazhu.hvip.product.service.BrandService;
import com.huazhu.hvip.product.vo.BrandVO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class BrandServiceImpl implements BrandService{
    private static Logger logger = LogManager.getLogger(BrandServiceImpl.class);

    private BrandManager brandManager;

    @Autowired
    public void setBrandManager(BrandManager brandManager) {
        this.brandManager = brandManager;
    }

    /**
     * 获取品牌列表
     * @return ReturnObject
     */
    @Override
    public ReturnObject<BrandVO> getAll() {
        ReturnObject<BrandVO> ret = new ReturnObject<BrandVO>();

        try {
            List<BrandVO> voList = new ArrayList<BrandVO>();
            List<Brand> brandList = brandManager.getAll();
            for(Brand brand : brandList) {
                BrandVO brandVO = new BrandVO();
                BeanUtils.copyProperties(brand, brandVO);
                voList.add(brandVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 保存品牌
     * @param brandVO
     * @return ReturnObject
     */
    @Override
    public ReturnObject<BrandVO> saveBrand(BrandVO brandVO) {
        ReturnObject<BrandVO> ret = new ReturnObject<BrandVO>();

        try {
            Brand brand = new Brand();
            BeanUtils.copyProperties(brandVO, brand);
            Brand brand1 = brandManager.save(brand);
            BrandVO brandVO1 = new BrandVO();
            BeanUtils.copyProperties(brand1, brandVO1);
            ret.setData(brandVO1);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }

        return ret;
    }

    /**
     * 移除品牌
     * @param brandVO
     * @return ReturnObject
     */
    @Override
    public ReturnObject removeBrand(BrandVO brandVO) {
        ReturnObject ret = new ReturnObject();

        try {
            Brand brand = new Brand();
            BeanUtils.copyProperties(brandVO, brand);
            brandManager.remove(brand);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }

    /**
     * 根据id删除品牌
     * @param ids 品牌ID
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject deleteBrand(Long[] ids) {
        logger.info("call deleteBrand({\"ids:\"" + ids.toString() + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ParamObject paramObject=new ParamObject();
            String id=StringUtils.join(ids, ",");
            paramObject.add("id",id);
            brandManager.deleteBrand(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除品牌成功");
        } catch (Exception e) {
            logger.error("删除品牌失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除品牌失败");
        }

        return ret;
    }

    /**
     * 根据id查询品牌
     * @param brandId 品牌id
     * @return ret 通用返回参数
     */
    @Override
    public ReturnObject getBrandById(Long brandId) {
        logger.info("call getBrandById({\"brandId:\"" + brandId + "})");

        ReturnObject<BrandVO> ret = new ReturnObject<BrandVO>();

        try {
            Brand brand = brandManager.get(brandId);
            BrandVO brandVO = new BrandVO();
            BeanUtils.copyProperties(brand, brandVO);
            ret.setData(brandVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败",e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 查询品牌列表
     * @param para
     * @return
     */
    @Override
    public ReturnObject<BrandVO> searchBrandList(ParamObject para) {
        logger.info("call searchBrandList()");
        ReturnObject<BrandVO> ret = new ReturnObject<BrandVO>();

        try {
            List<Brand> list = brandManager.searchBrandList(para);
            List<BrandVO> voList = new ArrayList<BrandVO>();
            for (Brand brand : list) {
                BrandVO brandVO = new BrandVO();
                BeanUtils.copyProperties(brand, brandVO);
                voList.add(brandVO);
            }
            ret.setDataList(voList);
            ret.setTotalSize(para.getTotalNum());
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

    /**
     * 根据类型ID查询关联的品牌
     * @param typeId
     * @return
     */
    @Override
    public ReturnObject<BrandVO> searchBrandByTypeId(Long typeId) {
        logger.info("call searchBrandByTypeId({" + typeId + "})");
        ReturnObject<BrandVO> ret = new ReturnObject<BrandVO>();

        try {
            ParamObject para = new ParamObject();
            para.add("typeId",typeId);
            List<Brand> list = brandManager.searchBrandList(para);
            List<BrandVO> voList = new ArrayList<BrandVO>();
            for (Brand brand : list) {
                BrandVO brandVO = new BrandVO();
                BeanUtils.copyProperties(brand, brandVO);
                voList.add(brandVO);
            }
            ret.setDataList(voList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return ret;
    }

}
