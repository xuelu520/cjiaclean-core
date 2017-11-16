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

import com.huazhu.hvip.base.PageCondition;
import com.huazhu.hvip.base.constants.Constants;
import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.ReturnObject;
import com.huazhu.hvip.user.opUser.manager.OpRoleManager;
import com.huazhu.hvip.user.opUser.manager.RoleAuthManager;
import com.huazhu.hvip.user.opUser.model.OpRole;
import com.huazhu.hvip.user.service.OpRoleService;
import com.huazhu.hvip.user.vo.OpRoleVO;
import com.huazhu.hvip.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author lijing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
  @Service("opRoleService")
public class OpRoleServiceImpl implements OpRoleService {

    private static Logger logger = LogManager.getLogger(OpUserServiceImpl.class);

    private OpRoleManager opRoleManager;

    @Autowired
    private RoleAuthManager roleAuthManager;

    @Autowired
    public void setOpRoleManager(OpRoleManager opRoleManager) {
        this.opRoleManager = opRoleManager;
    }

    /**
     * 根据角色名获取角色
     * @param paramObject roleName
     * @return
     */
    @Override
    public ReturnObject<OpRoleVO> getOpRole(ParamObject paramObject) {

        logger.info("call getOpRole({})",JsonUtil.JSON_Bean2String(paramObject));

        ReturnObject<OpRoleVO> ret = new ReturnObject<OpRoleVO>();
        try {
            Long roleId = paramObject.getLongParam("roleId");
            OpRole opRole = opRoleManager.getOpRole(roleId);
            OpRoleVO opRoleVO = new OpRoleVO();
            BeanUtils.copyProperties(opRole, opRoleVO);
            Set<Long> authIds = opRoleManager.getAuthedMenu(roleId);
            if (authIds != null && authIds.size() != 0) {
                Long[] authArray = new Long[authIds.size()];
                Iterator it = authIds.iterator();
                int i = 0;
                while (it.hasNext()) {
                    authArray[i] = new Long(it.next().toString());
                    i++;
                }
                opRoleVO.setAuthArray(authArray);
            }
            ret.setData(opRoleVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("call getOpRole() error", e);
            ret.setReturnMsg(e.getMessage());
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
        }
        return ret;
    }


    @Override
    public ReturnObject<OpRoleVO> saveOpRole(OpRoleVO opRoleVO) {

        ReturnObject<OpRoleVO> ret = new ReturnObject<OpRoleVO>();
        try {
            OpRole opRole = opRoleVO.getRoleId() == null ? new OpRole() : opRoleManager.get(opRoleVO.getRoleId());
            opRole.setRoleName(opRoleVO.getRoleName());
            opRole.setDescription(opRoleVO.getDescription());
            opRole = opRoleManager.saveRoleAndAuth(opRole, opRoleVO.getAuthArray());
            BeanUtils.copyProperties(opRole, opRoleVO);
            ret.setObject(opRoleVO);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("service保存角色信息异常", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 移除角色
     * @param paramObject rolename
     * @return
     */
    @Override
    public ReturnObject removeOpRole(ParamObject paramObject) {
        ReturnObject ret = new ReturnObject();
        try {
            Long roleId = paramObject.getLongParam("roleId");
            opRoleManager.removeOpRole(roleId);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
        } catch (Exception e) {
            logger.error("删除角色信息异常", e);
            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            return ret;
        }
        return ret;
    }

    /**
     * 获取可活动用户
     * @return
     */
    @Override
    public ReturnObject<List> getCanAssignRoles() {

        ReturnObject<List> ret = new ReturnObject<List>();
        List listRoleVO = new ArrayList();

        try {
            List<OpRole> listOpRole = opRoleManager.getCanAssignRoles();
            for(OpRole opRole :listOpRole ){
                OpRoleVO opRoleVO = new OpRoleVO();
                BeanUtils.copyProperties(opRole, opRoleVO);
                listRoleVO.add(opRoleVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        ret.setDataList(listRoleVO);
        return ret;
    }

    /**
     * 授权菜单
     * @param paramObject roleId menuIds
     * @return
     */
    @Override
    public ReturnObject saveRoleMenus(ParamObject paramObject) {

        ReturnObject ret = new ReturnObject();

        try {
            String roleId = (String) paramObject.getParamMap().get("roleId");
            String[] menuIds = (String[]) paramObject.getParamMap().get("menuIds");
            opRoleManager.saveRoleMenus(roleId, menuIds);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 根据角色名查询角色
     * @param paramObject roleName
     * @return
     */
    @Override
    public ReturnObject<OpRoleVO> getOpRoleByName(ParamObject paramObject) {

        ReturnObject ret = new ReturnObject();

        try {
            String roleName = paramObject.getStringParam("roleName");
            OpRole opRole = opRoleManager.getRoleByName(roleName);
            OpRoleVO opRoleVO = new OpRoleVO();
            BeanUtils.copyProperties(opRole, opRoleVO);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setReturnMsg(e.getMessage());
        }

        return ret;
    }

    /**
     * 查询所有角色列表
     *
     * @param pageCondition
     * @return
     */
    @Override
    public ReturnObject<OpRoleVO> searchOpRoles(PageCondition pageCondition) {
        ReturnObject<OpRoleVO> ret = new ReturnObject<OpRoleVO>();
        ParamObject paramObject = new ParamObject();
        OpRoleVO opRoleVO = null;
        List<OpRoleVO> opRoleVOList = new ArrayList<>();

        Integer pageNo = pageCondition.getPageNo();
        Integer pageSize = pageCondition.getPageSize();

        paramObject.setPageNo(pageNo);
        paramObject.setPageSize(pageSize);

        try {
            List<OpRole> opRoleList = opRoleManager.searchOpRoles(paramObject);

            for(OpRole opRole : opRoleList){
                opRoleVO = new OpRoleVO();
                BeanUtils.copyProperties(opRole,opRoleVO);
                opRoleVOList.add(opRoleVO);
            }
            ret.setDataList(opRoleVOList);
            ret.setReturnCode(Constants.RETURN_CODE_SUCCESS);
            ret.setReturnMsg("查询角色成功");

        } catch (Exception e) {
            logger.error("查询角色失败",e);

            ret.setReturnCode(Constants.RETURN_CODE_ERROR);
            ret.setReturnMsg("查询角色列表失败");
        }


        return ret;
    }
}
