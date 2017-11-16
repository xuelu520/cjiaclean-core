/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleServiceImpl.java
 * Author:   lijing
 * Date:     2016-03-11 09:27:19
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <lijing>  <2016-03-11 09:27:19> <version>   <desc>
 *
 */

package com.huazhu.hvip.user.service.impl;

import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.opUser.manager.AuthManager;
import com.huazhu.hvip.user.opUser.model.Auth;
import com.huazhu.hvip.user.request.AuthQO;
import com.huazhu.hvip.user.service.AuthService;
import com.huazhu.hvip.user.vo.AuthVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
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
  @Service("authService")
public class AuthServiceImpl implements AuthService {

    private static Logger logger = LogManager.getLogger(AuthServiceImpl.class);

    @Autowired
    private AuthManager authManager;

    /**
     * 获取权限列表
     *
     * @param authQO
     * @return
     */
    @Override
    public ReturnObject<AuthVO> searchAuthList(AuthQO authQO) {
        logger.info("call searchAuthList({})", JsonUtil.JSON_Bean2String(authQO));
        ReturnObject<AuthVO> ret = new ReturnObject<AuthVO>();
        List<AuthVO> authVOList = new ArrayList<>();
        AuthVO authVO = null;
        try {
            QueryModel queryModel = new QueryModel();
            List<Auth> authList = authManager.search(queryModel);

            for (Auth auth : authList){
                authVO = new AuthVO();
                BeanUtils.copyProperties(auth,authVO);
                authVOList.add(authVO);
            }

            ret.setDataList(authVOList);

            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询成功");

        } catch (Exception e) {
            logger.error("查询失败", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询失败");
        }

        return  ret;
    }

    @Override
    public ReturnObject<AuthVO> searchAllAuth() {
        ReturnObject<AuthVO> ret = new ReturnObject<AuthVO>();

        List<AuthVO> authVOs = new ArrayList<AuthVO>();
        try {
            AuthVO authVO = null;
            List<Auth> auths = authManager.getAll();
            if(auths!=null&&auths.size()!=0){
                for(Auth auth:auths){
                    authVO = new AuthVO();
                    BeanUtils.copyProperties(auth, authVO);
                    authVOs.add(authVO);
                }
            }
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (BeansException e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("查询所有权限点失败");
        }
        ret.setDataList(authVOs);
        return ret;
    }

    @Override
    public ReturnObject saveAuth(AuthVO authVO) {
        ReturnObject<AuthVO> ret = new ReturnObject<AuthVO>();

        try {
            Auth auth=new Auth();
            auth.setAuthType("1");
            if(authVO.getAuthId()!=null){
                auth = authManager.get(authVO.getAuthId());
            }
            auth.setAuthName(authVO.getAuthName());
            auth.setAuthValue(authVO.getAuthValue());
            auth=authManager.save(auth);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("保存权限点失败");
        }
        return ret;
    }

    @Override
    public ReturnObject deleteAuth(Long authId) {
        ReturnObject<AuthVO> ret = new ReturnObject<AuthVO>();

        try {
            if(authId!=null){
                authManager.remove(authId);
            }
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnCode(Constants.RETURN_CODE_FAIL);
            ret.setReturnMsg("删除权限点失败");
        }
        return ret;
    }

    @Override
    public ReturnObject<AuthVO> getUniqueAuth(Long authId) {
        ReturnObject<AuthVO> ret = new ReturnObject<AuthVO>();

        AuthVO  authVO = new AuthVO();
        Auth auth= authManager.get(authId);
        BeanUtils.copyProperties(auth, authVO);

        ret.setData(authVO);
        return ret;
    }
}
