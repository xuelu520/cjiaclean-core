/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: OpRoleManagerImpl.java
 * Author:   admin
 * Date:     2016-03-10 14:19:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-10 14:19:08><version><desc><source>
 */

package com.huazhu.hvip.user.opUser.manager.impl;

import com.huazhu.hvip.base.model.ParamObject;
import com.huazhu.hvip.base.model.QueryModel;
import com.huazhu.hvip.base.service.impl.GenericManagerImpl;
import com.huazhu.hvip.user.opUser.dao.OpRoleDao;
import com.huazhu.hvip.user.opUser.dao.RoleAuthDao;
import com.huazhu.hvip.user.opUser.manager.OpRoleManager;
import com.huazhu.hvip.user.opUser.manager.RoleAuthManager;
import com.huazhu.hvip.user.opUser.model.ComposeIdPK;
import com.huazhu.hvip.user.opUser.model.OpRole;
import com.huazhu.hvip.user.opUser.model.RoleAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("opRoleManager")
public class OpRoleManagerImpl extends GenericManagerImpl<OpRole, Long> implements OpRoleManager {

    @Autowired
    RoleAuthManager roleAuthManager;

    private OpRoleDao opRoleDao;
    @Autowired
    public OpRoleManagerImpl(OpRoleDao opRoleDao) {
        super(opRoleDao);
        this.opRoleDao = opRoleDao;
    }

    @Autowired
    private RoleAuthDao roleAuthDao;

    /**
     * {@inheritDoc}
     */
    public List<OpRole> getOpRoles(OpRole role) {
        return dao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public OpRole getOpRole(String rolename) {
        return opRoleDao.getRoleByName(rolename);
    }


    /**
     * {@inheritDoc}
     */
    public void removeOpRole(String rolename) {
    	opRoleDao.removeRole(rolename);
    }

    /**
     * {@inheritDoc}
     */
	public List<OpRole> getCanAssignRoles() {

       QueryModel queryModel = new QueryModel();

  	   queryModel.addHqlCondition(" roleId not in (1,2) ");

		return opRoleDao.search(queryModel);
	}

	/**
     * {@inheritDoc}
     */
	public Set<String> getAuthedMenu(String roleId) {
		return opRoleDao.getAuthedMenu(roleId);
	}

	/**
     * {@inheritDoc}
     */
	public void saveRoleMenus(String roleId, String[] menuIds) {

		//opRoleDao.removeRoleMenuByRoleId(roleId);

		//opRoleDao.getAuthedMenu(roleId);
	}

	@Override
	public OpRole getRoleByName(String RoleName) {
	         QueryModel queryModel = new QueryModel();
	  		 queryModel.addColumnValueCondition("roleName", RoleName);

	  		 OpRole opRole = getUniqueResult(queryModel);
		   return opRole;
	}

    /**
     * 查询查询所有角色
     *
     * @param paramObject
     * @return
     */
    @Override
    public List<OpRole> searchOpRoles(ParamObject paramObject) {
        QueryModel queryModel = new QueryModel();

        Integer pageNo = paramObject.getPageNo();
        Integer pageSize = paramObject.getPageSize();

        List<OpRole> opRoleList = new ArrayList<>();

        if (pageNo != null) {
            queryModel.setPageNo(pageNo);
        }

        if (pageSize != null) {
            queryModel.setPageSize(pageSize);
        }
        if(queryModel != null) {//全字段查询角色列表
            opRoleList = opRoleDao.searchRoleList(queryModel, paramObject);


            paramObject.setTotalNum(queryModel.getTotalNum());
        }else{
            opRoleList = opRoleDao.searchRoleListPartialField(queryModel, paramObject);

        }
        return opRoleList;
    }

    @Override
    public OpRole getOpRole(Long roleId) {
        return opRoleDao.get(roleId);
    }

    @Override
    public OpRole saveOpRole(OpRole role) {
        return opRoleDao.save(role);
    }

    @Override
    public void removeOpRole(Long roleId) {
        opRoleDao.remove(roleId);
        /*opRoleDao.deleteRoleAuthByRoleId(roleId);*/
    }

    @Override
    public Set<Long> getAuthedMenu(Long roleId) {
        return opRoleDao.getAuthedMenu(roleId);
    }

    @Override
    public OpRole saveRoleAndAuth(OpRole opRole, Long[] authArray) {
        boolean isEdit=opRole.getRoleId()!=null?true:false;
        opRole = saveOpRole( opRole);
        if(isEdit){
            opRoleDao.deleteRoleAuthByRoleId(opRole.getRoleId());
        }
        if(authArray!=null&&authArray.length!=0){
            for(Long authId:authArray){
                ComposeIdPK composeIdPK=new ComposeIdPK ();
                composeIdPK.setAuthId(authId);
                composeIdPK.setRoleId(opRole.getRoleId());
                RoleAuth roleAuth=new RoleAuth();
                roleAuth.setComposeIdPK(composeIdPK);
                roleAuthManager.save(roleAuth);
            }
        }
        return opRole;
    }
}