/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SupplierServiceImpl.java
 * Author:   chenli
 * Date:     2016-03-23 11:33:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 11:33:25> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.supplier.manager.SupplierManager;
import com.huazhu.hvip.supplier.model.Supplier;
import com.huazhu.hvip.supplier.model.SupplierUser;
import com.huazhu.hvip.supplier.model.extend.SupplierExt;
import com.huazhu.hvip.supplier.request.AddSupplierVO;
import com.huazhu.hvip.supplier.request.EditSupplierVO;
import com.huazhu.hvip.supplier.request.SaveSupplierVO;
import com.huazhu.hvip.supplier.service.SupplierService;
import com.huazhu.hvip.supplier.vo.SupplierVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author chenli
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

@Service
public class SupplierServiceImpl implements SupplierService {

    private static Logger logger = LogManager.getLogger(SupplierServiceImpl.class);

    @Autowired
    public SupplierManager supplierManager;

    /**
     * 根据条件查询供应商列表
     *
     * @param paramObject
     * @return
     */
    public ReturnObject searchSupplierList(ParamObject paramObject) {

        logger.info("call seachSupplierList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        ReturnObject ret = new ReturnObject();

        try {
            ReturnObject<SupplierExt> returnObject = supplierManager.searchSupplierList(paramObject);

            List<SupplierExt> supplierExtList = returnObject.getDataList();

            List<SupplierVO> supplierVOList = new ArrayList<>();

            for(SupplierExt supplierExt : supplierExtList){
                SupplierVO supplierVO = new SupplierVO();
                BeanUtils.copyProperties(supplierExt, supplierVO);
                supplierVO.setName(supplierVO.getLastName(),supplierVO.getFirstName());
                supplierVOList.add(supplierVO);

            }

            Integer totalNum = paramObject.getTotalNum();
            Integer totalPageNum = paramObject.getTotelPageNum();
            ret.setTotalSize(totalNum);
            ret.setDataList(supplierVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询供应商列表成功");


        } catch (BeansException e) {
            logger.error("查询列表失败");

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询供应商列表失败");

        }

        return ret;
    }

    /**
     * 新增供应商
     *
     * @param saveSupplierVO
     * @return
     */
    @Override
    public ReturnObject<AddSupplierVO> createSupplier(SaveSupplierVO saveSupplierVO) {
        logger.info("call createSupplier({\"saveSupplierVO:\"" + saveSupplierVO.toString() + "})");

        ReturnObject<AddSupplierVO> ret = new ReturnObject<AddSupplierVO>();

        try {
            AddSupplierVO addSupplierVO = saveSupplierVO.getAddSupplierVO();
            Supplier supplier = new Supplier();
            SupplierUser supplierUser = new SupplierUser();
            String telNo = addSupplierVO.getUserTelNo();

            BeanUtils.copyProperties(addSupplierVO,supplier);
            BeanUtils.copyProperties(addSupplierVO,supplierUser);
            supplierUser.setTelNo(telNo);


            //创建店铺
            supplierManager.saveSupplier(supplier,supplierUser);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("创建供应商成功");
        } catch (BeansException e) {
            logger.error("创建供应商失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("创建供应商失败");
        }


        return ret;
    }

    /**
     * 根据供应商id获取供应商详情（供应商以及供应商用户信息）
     *
     * @param supplierId
     * @return
     */
    @Override
    public ReturnObject<EditSupplierVO> getSupplierDetail(Long supplierId) {
        logger.info("call getSupplierDetail({\"supplierId:\"" + supplierId + "})");

        ReturnObject<EditSupplierVO> returnObject = new ReturnObject<>();

        try {
            SupplierExt supplierExt = supplierManager.getSupplierDetail(supplierId);

            if (supplierExt == null) {
                returnObject.setReturnCode(Constants.RETURN_CODE_FAIL);
                returnObject.setReturnMsg("未查询到供应商信息");
            }

            EditSupplierVO editSupplierVO = new EditSupplierVO();

            BeanUtils.copyProperties(supplierExt, editSupplierVO);

            returnObject.setData(editSupplierVO);

            returnObject.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            returnObject.setReturnMsg("查询成功");
        } catch (Exception e) {
            logger.error("获取店铺详情失败", e);

            returnObject.setReturnCode(Constants.RETURN_CODE_ERROR);
            returnObject.setReturnMsg("查询失败");
        }

        return returnObject;
    }

    /**
     * 修改供应商
     *
     * @param saveSupplierVO
     * @return
     */
    @Override
    public ReturnObject<EditSupplierVO> saveSupplier(SaveSupplierVO saveSupplierVO) {
        logger.info("call saveSupplier({\"saveSupplierVO:\"" + saveSupplierVO.toString() + "})");

        ReturnObject<EditSupplierVO> ret = new ReturnObject<EditSupplierVO>();

        Supplier supplier = new Supplier();
        SupplierUser supplierUser = new SupplierUser();

        try {
            EditSupplierVO editSupplierVO = saveSupplierVO.getEditSupplierVO();
            Long supplierId = editSupplierVO.getSupplierId();

            SupplierExt supplierExt = supplierManager.getSupplierDetail(supplierId);

            String userTelNo = supplierExt.getUserTelNo();

            if(null != supplierExt) {
                BeanUtils.copyProperties(supplierExt,supplier);
                BeanUtils.copyProperties(supplierExt,supplierUser);
                BeanUtils.copyProperties(editSupplierVO,supplier);
                BeanUtils.copyProperties(editSupplierVO,supplierUser);
                supplierUser.setTelNo(userTelNo);
            }

            ReturnObject returnObject  = supplierManager.saveSupplier(supplier,supplierUser);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("修改店铺成功");
        } catch (BeansException e) {
            logger.error("修改店铺失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("修改店铺失败");
        }
        return ret;
    }

    /**
     * 删除供应商
     *
     * @param supplierIds
     * @return
     */
    @Override
    public ReturnObject deleteSupplierBySupplierId(List<Long> supplierIds) {
        logger.info("call deleleSupplier({\"supplierId:\"\" + supplierId + \"})");

        ReturnObject ret = new ReturnObject();


        ParamObject paramObject = new ParamObject();
        paramObject.add("supplierIds", supplierIds);

        try {
            supplierManager.deleteSupplier(paramObject);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除供应商成功");
        } catch (Exception e) {
            logger.error("删除供应商失败");
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("删除供应商失败");
        }

        return ret;
    }

}
