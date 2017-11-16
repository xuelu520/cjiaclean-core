/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: SupplierManagerImpl.java
 * Author:   chenli
 * Date:     2016-03-23 11:08:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <chenli>  <2016-03-23 11:08:53> <version>   <desc>
 *
 */

package com.huazhu.hvip.supplier.manager.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.supplier.dao.SupplierDao;
import com.huazhu.hvip.supplier.dao.SupplierUserDao;
import com.huazhu.hvip.supplier.model.Supplier;
import com.huazhu.hvip.supplier.manager.SupplierManager;
import com.huazhu.hvip.supplier.model.SupplierUser;
import com.huazhu.hvip.supplier.model.extend.SupplierExt;
import com.huazhu.hvip.util.JsonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
public class SupplierManagerImpl extends GenericManagerImpl<Supplier, Long> implements SupplierManager {

    private static Logger logger = LogManager.getLogger(SupplierManagerImpl.class);

    @Autowired
    SupplierDao supplierDao;

    @Autowired
    SupplierUserDao supplierUserDao;

    /**
     * 根据条件查询供应商列表
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject<SupplierExt> searchSupplierList(ParamObject paramObject) {

        logger.info("call seachSupplierList({\"paramObject:\"" + JsonUtil.JSON_Bean2String(paramObject) + "})");

        ReturnObject<SupplierExt> ret = new ReturnObject<>();

        QueryModel queryModel = new QueryModel();

        Integer pageSize = (Integer) paramObject.getPageSize();

        Integer pageNo = (Integer) paramObject.getPageNo();

        String keyword = paramObject.getStringParam("keyword");

        String sort = paramObject.getStringParam("sort");

        String order = paramObject.getStringParam("order");

        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }

        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }

        if(!StringUtil.isEmpty(keyword)){
            queryModel.addHqlCondition(" (su.userName like '%"+keyword+"%' or su.mobile like '%"+keyword+"%' or s.supplierName like '%"+keyword+"%') ");
        }

        if(!StringUtil.isEmpty(sort) && !StringUtil.isEmpty(order)){
            queryModel.setSortHql(sort+" "+order);
        }

        List<SupplierExt> supplierExtsList = supplierDao.searchSupplierList(queryModel, paramObject);

        paramObject.setTotalNum(queryModel.getTotalNum());


        ret.setDataList(supplierExtsList);
        ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        ret.setReturnMsg("获取供应商信息成功");

        return ret;
    }

    /**
     * 保存供应商（创建或者更新）
     *
     * @param supplier
     * @param supplierUser
     * @return
     */
    @Override
    public ReturnObject saveSupplier(Supplier supplier, SupplierUser supplierUser) {

        ReturnObject ret = new ReturnObject();

        Long supplierId = supplier.getSupplierId();

        if(null == supplierId){
            try {
                supplier = supplierDao.save(supplier);
                supplierUser.setSupplierId(supplier.getSupplierId());
                supplierUser = supplierUserDao.save(supplierUser);
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("新增供应商信息成功");
            } catch (Exception e) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("新增供应商信息失败");
            }
        }else{
            try {
                supplier = supplierDao.save(supplier);
                supplierUser.setSupplierId(supplier.getSupplierId());
                supplierUser = supplierUserDao.save(supplierUser);
                ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
                ret.setReturnMsg("更新供应商信息成功");
            } catch (Exception e) {
                ret.setReturnCode(Constants.RETURN_CODE_FAIL);
                ret.setReturnMsg("更新供应商信息失败");
            }


        }

        return ret;
    }

    /**
     * 获取供应商详细（供应商信息和用户信息）
     *
     * @param supplierId
     * @return
     */
    @Override
    public SupplierExt getSupplierDetail(Long supplierId) {

        SupplierExt supplierExt = new SupplierExt();

        Supplier supplier = supplierDao.get(supplierId);
        SupplierUser supplierUser = supplierUserDao.get(supplierId);
        String telNo = supplierUser.getTelNo();
        if(null != supplierUser) {
            BeanUtils.copyProperties(supplierUser,supplierExt);
        }
        if(null != supplier){
            BeanUtils.copyProperties(supplier,supplierExt);//因为两个表有一个同名不同内容字段telNo，所以此处起别名赋值次
            supplierExt.setUserTelNo(telNo);
        }

        return supplierExt;
    }

    /**
     * 根据条件删除供应商
     *
     * @param paramObject
     * @return
     */
    @Override
    public ReturnObject deleteSupplier(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();

        List<Long> supplierIds = (List<Long>) paramObject.getParam("supplierIds");


        try {
            QueryModel queryModel = new QueryModel();
            String s = StringUtils.join(supplierIds,",");
            queryModel.addColumnValueCondition("id", QueryModel.OPERATOR_IN, "(" + s + ")");
            List<Supplier> supplierId = supplierDao.search(queryModel);
            List<SupplierUser> supplierUsers= supplierUserDao.search(queryModel);
            if (supplierId !=null && supplierId.size()>0){
                for (Supplier supplier : supplierId){
                    supplierDao.remove(supplier);
                }
            }
            if (supplierUsers != null && supplierUsers.size()>0){
                for (SupplierUser supplierUser : supplierUsers){
                    supplierUserDao.remove(supplierUser);
                }
            }


//            supplierDao.deleteSuppliers(supplierIds);
//            supplierUserDao.deleteSupplierUsers(supplierIds);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("删除供应商信息成功");
        } catch (Exception e) {
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("删除供应商信息失败");
        }

        return ret;
    }


}
